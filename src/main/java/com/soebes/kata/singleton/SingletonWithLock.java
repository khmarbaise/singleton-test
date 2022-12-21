package com.soebes.kata.singleton;

import java.util.UUID;

import static java.util.Objects.isNull;

public class SingletonWithLock {
  private static SingletonWithLock instance;

  private static final Object lock = new Object();

  private UUID uuid;

  private SingletonWithLock() {
    this.uuid = UUID.randomUUID();
  }

  public UUID getUuid() {
    return uuid;
  }

  public static SingletonWithLock getInstance() {
    synchronized (lock) {
      if (isNull(instance)) {
        instance = new SingletonWithLock();
      }
    }
    return instance;
  }

}
