package com.soebes.kata.singleton;

import java.util.UUID;

public class AClassSomeWhere {

  private long id;

  public AClassSomeWhere(long id) {
    this.id = id;
  }

  public UUID getUuid() {
    return Singleton.getInstance().getUuid();
  }

  public long getId() {
    return id;
  }
}
