package com.soebes.kata.singleton;

import java.util.UUID;

public class AClassSomeWhereLock {

  private long id;

  public AClassSomeWhereLock(long id) {
    this.id = id;
  }

  public UUID getUuid() {
    return SingletonWithLock.getInstance().getUuid();
  }

  public long getId() {
    return id;
  }
}
