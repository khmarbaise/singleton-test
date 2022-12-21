package com.soebes.kata.singleton;

import java.util.UUID;

public class AClassSomeWhereEnum {

  private long id;

  public AClassSomeWhereEnum(long id) {
    this.id = id;
  }

  public UUID getUuid() {
    return SingletonEnum.INSTANCE.getUuid();
  }

  public long getId() {
    return id;
  }
}
