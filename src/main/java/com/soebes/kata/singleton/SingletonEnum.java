package com.soebes.kata.singleton;

import java.util.UUID;

public enum SingletonEnum {
  INSTANCE;

  private UUID uuid;

  SingletonEnum() {
    this.uuid = UUID.randomUUID();
  }

  public UUID getUuid() {
    return uuid;
  }
}
