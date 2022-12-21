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
}