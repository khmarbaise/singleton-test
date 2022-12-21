package com.soebes.kata.singleton;

import java.util.UUID;

import static java.util.Objects.isNull;

public class Singleton {
  private static Singleton instance;

  private UUID uuid;

  private Singleton() {
    this.uuid = UUID.randomUUID();
  }

  public UUID getUuid() {
    return uuid;
  }

  public static Singleton getInstance() {
    if (isNull(instance)) {
      instance = new Singleton();
    }
    return instance;
  }

}
