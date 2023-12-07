package com.soebes.kata.singleton;

import java.util.UUID;

public class HolderSingleton {

    private final UUID uuid;

    private HolderSingleton() {
        this.uuid = UUID.randomUUID();
    }

    // Private static inner class that holds the instance
    private static class SingletonHolder {
        private static final HolderSingleton instance = new HolderSingleton();
    }

    public static HolderSingleton getInstance() {
        return SingletonHolder.instance;
    }

    public UUID getUuid() {
        return uuid;
    }
}