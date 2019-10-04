/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.storm.sql.runtime.serde.json;

import org.apache.storm.spout.Scheme;
import org.apache.storm.tuple.Fields;
import org.apache.storm.utils.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonScheme implements Scheme {
  private final List<String> fields;

  public JsonScheme(List<String> fields) {
    this.fields = fields;
  }

  @Override
  public List<Object> deserialize(ByteBuffer ser) {
    ObjectMapper mapper = new ObjectMapper();
    try {
      @SuppressWarnings("unchecked")
      HashMap<String, Object> map = mapper.readValue(Utils.toByteArray(ser), HashMap.class);
      ArrayList<Object> list = new ArrayList<>(fields.size());
      for (String f : fields) {
        list.add(map.get(f));
      }
      return list;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Fields getOutputFields() {
    return new Fields(fields);
  }
}
