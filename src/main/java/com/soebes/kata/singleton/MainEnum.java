package com.soebes.kata.singleton;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class MainEnum {

  public static void main(String[] args) {
    var listOfInstances = IntStream.range(0, 1000000).mapToObj(AClassSomeWhereEnum::new).collect(toList());
    var listOfExecutedSingletons = listOfInstances
        .parallelStream()
        .collect(groupingBy(AClassSomeWhereEnum::getUuid, mapping(AClassSomeWhereEnum::getId, toList())));
    listOfExecutedSingletons.entrySet().stream().forEach(
        s -> System.out.println("k: " + s.getKey() + " v:" + s.getValue().size())
    );

  }
}
