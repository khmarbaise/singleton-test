package com.soebes.kata.singleton;

import java.util.UUID;

public class SingletonWithoutLazyCheck {
    // 1. The instance is created when the class is loaded.
    private static final SingletonWithoutLazyCheck INSTANCE = new SingletonWithoutLazyCheck();

    private final UUID uuid;
    // 2. Private constructor prevents outside instantiation.
    private SingletonWithoutLazyCheck() {
        this.uuid = UUID.randomUUID();
    }

    // 3. Global access point.
    public static SingletonWithoutLazyCheck getInstance() {
        return INSTANCE;
    }
    public UUID getUuid() {
        return uuid;
    }
}
