/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.storm.hbase.common;

import com.google.common.collect.Lists;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellBuilder;
import org.apache.hadoop.hbase.CellBuilderFactory;
import org.apache.hadoop.hbase.CellBuilderType;
import org.apache.hadoop.hbase.HConstants;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Durability;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Increment;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.security.UserProvider;
import org.apache.storm.hbase.bolt.mapper.HBaseProjectionCriteria;
import org.apache.storm.hbase.security.HBaseSecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HBase client for constructing requests and do actual interaction with HBase.
 */
public class HBaseClient implements Closeable {
    private static final Logger LOG = LoggerFactory.getLogger(HBaseClient.class);

    private Table table;
    private Connection connection;

    public HBaseClient(Map<String, Object> map , final Configuration configuration, final String tableName) {
        try {
            UserProvider provider = HBaseSecurityUtil.login(map, configuration);
            if(provider != null) {
                this.connection = ConnectionFactory.createConnection(configuration, provider.getCurrent());
            } else {
                this.connection = ConnectionFactory.createConnection(configuration);
            }
            this.table = Utils.getTable(this.connection, provider, configuration, tableName);
        } catch (Exception e) {
            throw new RuntimeException("HBase bolt preparation failed: " + e.getMessage(), e);
        }
    }

    public List<Mutation> constructMutationReq(byte[] rowKey, ColumnList cols, Durability durability) {
        List<Mutation> mutations = Lists.newArrayList();

        if (cols.hasColumns()) {
            CellBuilder builder = CellBuilderFactory.create(CellBuilderType.DEEP_COPY);

            Put put = new Put(rowKey);
            put.setDurability(durability);
            for (ColumnList.Column col : cols.getColumns()) {
                try {
                    if (col.getTs() > 0) {
                        put.add(
                                builder.setFamily(col.getFamily())
                                        .setQualifier(col.getQualifier())
                                        .setTimestamp(col.getTs())
                                        .setValue(col.getValue())
                                        .setType(Cell.Type.Put)
                                        .setRow(rowKey)
                                        .build()
                        );
                    } else {
                        put.add(
                                builder.setFamily(col.getFamily())
                                        .setQualifier(col.getQualifier())
                                        .setType(Cell.Type.Put)
                                        .setValue(col.getValue())
                                        .setRow(rowKey)
                                        .build()
                        );
                    }
                } catch (IOException e) {
                    throw new RuntimeException("HBase Put failed", e);
                }
            }
            mutations.add(put);
        }

        if (cols.hasCounters()) {
            Increment inc = new Increment(rowKey);
            inc.setDurability(durability);
            for (ColumnList.Counter cnt : cols.getCounters()) {
                inc.addColumn(
                        cnt.getFamily(),
                        cnt.getQualifier(),
                        cnt.getIncrement()
                );
            }
            mutations.add(inc);
        }

        if (cols.hasColumnsToDelete()) {
            Delete delete = new Delete(rowKey);
            delete.setDurability(durability);
            for (ColumnList.Column col : cols.getColumnsToDelete()) {
                if (col.getTs() > 0) {
                    delete.addColumn(col.getFamily(), col.getQualifier(), col.getTs());
                } else {
                    delete.addColumn(col.getFamily(), col.getQualifier());
                }
            }
            mutations.add(delete);
        }

        if (mutations.isEmpty()) {
            mutations.add(new Put(rowKey));
        }
        return mutations;
    }

    public void batchMutate(List<Mutation> mutations) throws Exception {
        Object[] result = new Object[mutations.size()];
        try {
            table.batch(mutations, result);
        } catch (InterruptedException e) {
            LOG.warn("Error performing a mutation to HBase.", e);
            throw e;
        } catch (IOException e) {
            LOG.warn("Error performing a mutation to HBase.", e);
            throw e;
        }
    }


    public Get constructGetRequests(byte[] rowKey, HBaseProjectionCriteria projectionCriteria) {
        Get get = new Get(rowKey);

        if (projectionCriteria != null) {
            for (byte[] columnFamily : projectionCriteria.getColumnFamilies()) {
                get.addFamily(columnFamily);
            }

            for (HBaseProjectionCriteria.ColumnMetaData columnMetaData : projectionCriteria.getColumns()) {
                get.addColumn(columnMetaData.getColumnFamily(), columnMetaData.getQualifier());
            }
        }

        return get;
    }

    public Result[] batchGet(List<Get> gets) throws Exception {
        try {
            return table.get(gets);
        } catch (Exception e) {
            LOG.warn("Could not perform HBASE lookup.", e);
            throw e;
        }
    }

    public ResultScanner scan(byte[] startRow, byte[] stopRow) throws Exception {
        try {
            if (startRow == null) {
                startRow = HConstants.EMPTY_START_ROW;
            }
            if (stopRow == null) {
                stopRow = HConstants.EMPTY_END_ROW;
            }

            Scan scan = new Scan(startRow, stopRow);
            return table.getScanner(scan);
        } catch (Exception e) {
            LOG.warn("Could not open HBASE scanner.", e);
            throw e;
        }
    }

    public boolean exists(Get get) throws Exception {
        try {
            return table.exists(get);
        } catch (Exception e) {
            LOG.warn("Could not perform HBASE existence check.", e);
            throw e;
        }
    }

    @Override
    public void close() throws IOException {
        table.close();
    }
}
