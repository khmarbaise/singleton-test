package com.soebes.kata.singleton;

import java.util.UUID;

import static java.util.Objects.isNull;

public class SingletonWithSynchronizedLock {
  private static SingletonWithSynchronizedLock instance;

  private static final Object lock = new Object();

  private UUID uuid;

  private SingletonWithSynchronizedLock() {
    this.uuid = UUID.randomUUID();
  }

  public UUID getUuid() {
    return uuid;
  }

  public static SingletonWithSynchronizedLock getInstance() {
    synchronized (lock) {
      if (isNull(instance)) {
        instance = new SingletonWithSynchronizedLock();
      }
    }
    return instance;
  }

}
