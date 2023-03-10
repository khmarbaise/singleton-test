/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.soebes.kata.singleton;

import java.util.UUID;

import static java.util.Objects.isNull;

public final class SingletonWithSynchronizedLock {
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
