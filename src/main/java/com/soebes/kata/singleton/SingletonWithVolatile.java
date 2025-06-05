package com.soebes.kata.singleton;

import java.util.UUID;

public class SingletonWithVolatile {
  private static volatile SingletonWithVolatile theOnlyInstance;
  private static final Object mutex = new Object();
  private final UUID uid;

  private SingletonWithVolatile() {
    this.uid = UUID.randomUUID();
  }

  public static SingletonWithVolatile getInstance() {
    var result = theOnlyInstance;
    if (result == null) {
      synchronized (mutex) {
        result = theOnlyInstance;
        if (result == null)
          theOnlyInstance = result = new SingletonWithVolatile();
      }
    }

    return result;
  }

  public UUID getUid() {
    return uid;
  }
}