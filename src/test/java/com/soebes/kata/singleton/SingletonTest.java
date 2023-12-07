/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.soebes.kata.singleton;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class SingletonTest {

  @Test
  void multiThreadWithEnumSingleton() {
    var listOfInstances = IntStream.range(0, 1_000_000).mapToObj(AClassSomeWhereEnum::new).toList();
    var mapOfExecutedSingletons = listOfInstances
        .parallelStream()
        .collect(groupingBy(AClassSomeWhereEnum::getUuid, mapping(AClassSomeWhereEnum::getId, toList())));
    assertThat(mapOfExecutedSingletons).hasSize(1);
  }

  @Test
  void multiThreadWithOldSingleton() {
    var listOfInstances = IntStream.range(0, 1_000_000).mapToObj(AClassSomeWhere::new).toList();
    var mapOfExecutedSingletons = listOfInstances
        .parallelStream()
        .collect(groupingBy(AClassSomeWhere::getUuid, mapping(AClassSomeWhere::getId, toList())));
    assertThat(mapOfExecutedSingletons).hasSize(1);
  }

  @Test
  void multiThreadWithLockedSingleton() {
    var listOfInstances = IntStream.range(0, 1_000_000).mapToObj(AClassSomeWhereSynchronizedLock::new).toList();
    var mapOfExecutedSingletons = listOfInstances
        .parallelStream()
        .collect(groupingBy(AClassSomeWhereSynchronizedLock::getUuid, mapping(AClassSomeWhereSynchronizedLock::getId, toList())));
    assertThat(mapOfExecutedSingletons).hasSize(1);
  }

  @Test
  void multiThreadWithHolderSingleton() {
    var listOfInstances = IntStream.range(0, 1_000_000).mapToObj(AClassSomeWhereHolderSingleton::new).toList();
    var mapOfExecutedSingletons = listOfInstances
        .parallelStream()
        .collect(groupingBy(AClassSomeWhereHolderSingleton::getUuid, mapping(AClassSomeWhereHolderSingleton::getId, toList())));
    assertThat(mapOfExecutedSingletons).hasSize(1);
  }
}