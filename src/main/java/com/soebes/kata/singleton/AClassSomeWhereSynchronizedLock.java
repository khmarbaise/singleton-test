package com.soebes.kata.singleton;

import java.util.UUID;

public class AClassSomeWhereSynchronizedLock {

  private long id;

  public AClassSomeWhereSynchronizedLock(long id) {
    this.id = id;
  }

  public UUID getUuid() {
    return SingletonWithSynchronizedLock.getInstance().getUuid();
  }

  public long getId() {
    return id;
  }
}
