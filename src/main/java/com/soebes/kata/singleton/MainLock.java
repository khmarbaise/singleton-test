package com.soebes.kata.singleton;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class MainLock {

  public static void main(String[] args) {
    var listOfInstances = IntStream.range(0, 1000000).mapToObj(AClassSomeWhereLock::new).collect(toList());
    var listOfExecutedSingletons = listOfInstances
        .parallelStream()
        .collect(groupingBy(AClassSomeWhereLock::getUuid, mapping(AClassSomeWhereLock::getId, toList())));
    listOfExecutedSingletons.entrySet().stream().forEach(
        s -> System.out.println("k: " + s.getKey() + " v:" + s.getValue().size())
    );

  }
}
