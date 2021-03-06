/*
 * Copyright 2017 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.storm.kafka.spout.subscription;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.storm.kafka.spout.ManualPartitionSubscription;
import org.apache.storm.kafka.spout.ManualPartitioner;
import org.apache.storm.kafka.spout.TopicFilter;
import org.apache.storm.kafka.spout.builders.SingleTopicKafkaSpoutConfiguration;
import org.apache.storm.task.TopologyContext;
import org.junit.Test;
import org.mockito.InOrder;

public class ManualPartitionSubscriptionTest {

    @Test
    public void testCanReassignPartitions() {
        ManualPartitioner partitionerMock = mock(ManualPartitioner.class);
        TopicFilter filterMock = mock(TopicFilter.class);
        KafkaConsumer<String, String> consumerMock = mock(KafkaConsumer.class);
        ConsumerRebalanceListener listenerMock = mock(ConsumerRebalanceListener.class);
        TopologyContext contextMock = mock(TopologyContext.class);
        ManualPartitionSubscription subscription = new ManualPartitionSubscription(partitionerMock, filterMock);
        
        List<TopicPartition> onePartition = Collections.singletonList(new TopicPartition(SingleTopicKafkaSpoutConfiguration.TOPIC, 0));
        List<TopicPartition> twoPartitions = new ArrayList<>();
        twoPartitions.add(new TopicPartition(SingleTopicKafkaSpoutConfiguration.TOPIC, 0));
        twoPartitions.add(new TopicPartition(SingleTopicKafkaSpoutConfiguration.TOPIC, 1));
        when(partitionerMock.partition(anyList(), any(TopologyContext.class)))
            .thenReturn(onePartition)
            .thenReturn(twoPartitions);
        
        //Set the first assignment
        subscription.subscribe(consumerMock, listenerMock, contextMock);
        
        InOrder inOrder = inOrder(consumerMock, listenerMock);
        inOrder.verify(consumerMock).assign(new HashSet<>(onePartition));
        inOrder.verify(listenerMock).onPartitionsAssigned(new HashSet<>(onePartition));
        
        reset(consumerMock, listenerMock);
        
        when(consumerMock.assignment()).thenReturn(new HashSet<>(onePartition));
        
        //Update to set the second assignment
        subscription.refreshAssignment();
        
        //The partition revocation hook must be called before the new partitions are assigned to the consumer,
        //to allow the revocation hook to commit offsets for the revoked partitions.
        inOrder.verify(listenerMock).onPartitionsRevoked(new HashSet<>(onePartition));
        inOrder.verify(consumerMock).assign(new HashSet<>(twoPartitions));
        inOrder.verify(listenerMock).onPartitionsAssigned(new HashSet<>(twoPartitions));
    }
    
}
