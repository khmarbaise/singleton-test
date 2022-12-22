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

class SingletonTest {

  @Test
  void multiThreadEnum() {
    var listOfInstances = IntStream.range(0, 1000000).mapToObj(i -> new AClassSomeWhereEnum(i)).collect(toList());
    var listOfExecutedSingletons = listOfInstances
        .parallelStream()
        .collect(groupingBy(AClassSomeWhereEnum::getUuid, mapping(AClassSomeWhereEnum::getId, toList())));
    listOfExecutedSingletons.entrySet().stream().forEach(
        s -> System.out.println("k: " + s.getKey() + " v:" + s.getValue().size())
    );

  }

  @Test
  void multiThread() {
    var listOfInstances = IntStream.range(0, 1000000).mapToObj(i -> new AClassSomeWhere(i)).collect(toList());
    var listOfExecutedSingletons = listOfInstances
        .parallelStream()
        .collect(groupingBy(AClassSomeWhere::getUuid, mapping(AClassSomeWhere::getId, toList())));
    listOfExecutedSingletons.entrySet().stream().forEach(
        s -> System.out.println("k: " + s.getKey() + " v:" + s.getValue().size())
    );

  }

  @Test
  void multiThreadLock() {
    var listOfInstances = IntStream.range(0, 1000000).mapToObj(i -> new AClassSomeWhereSynchronizedLock(i)).collect(toList());
    var listOfExecutedSingletons = listOfInstances
        .parallelStream()
        .collect(groupingBy(AClassSomeWhereSynchronizedLock::getUuid, mapping(AClassSomeWhereSynchronizedLock::getId, toList())));
    listOfExecutedSingletons.entrySet().stream().forEach(
        s -> System.out.println("k: " + s.getKey() + " v:" + s.getValue().size())
    );

  }
}