<!---
 Licensed to the Apache Software Foundation (ASF) under one or more
 contributor license agreements.  See the NOTICE file distributed with
 this work for additional information regarding copyright ownership.
 The ASF licenses this file to You under the Apache License, Version 2.0
 (the "License"); you may not use this file except in compliance with
 the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
-->
# Singleton Pattern Test Project

The default singleton pattern which is often propagated (given in the `Singleton` class)
is simply not thread safe which means it does not fulfil the basic idea of the Singleton 
pattern.

There are two working solutions which are either `SingletonEnum` version or one which
contains a synchronized locking via separate object (`SingletonWithSynchronizedLock`).

you can build the project with the following requirements:

* JDK 17+
* Apache Maven 3.8.6+

Just run:
```
$ mvn package
```

# Wrong Singleton

The following will execute the `Main.main` method which uses the `Singleton` (classical
wrong implementation):

```
$ java -cp target/example-minimal-1.0-SNAPSHOT.jar com.soebes.kata.singleton.Main 
```
The above call will produce an output similar like this:
```
k: e8a47975-690c-4f20-802d-643c1b45f99b v:30
k: fc972e8b-0080-48c1-b93a-d2c06b971003 v:1
k: 65edd7d1-5e9e-4263-bcd0-524a02871438 v:302
k: a4ff3d6a-8341-46b4-8825-87f076cce1af v:49
k: 6160bddf-b1af-46cf-b32c-d94e0ff449de v:1
k: 129ddc35-d378-41ae-9479-c635e4461103 v:1
k: 23ba1321-c764-4b4f-8964-1cb14ca9cef4 v:999400
k: eee78336-5be4-4826-bb13-54937ed3b2ea v:3
k: 5e1b3f8f-235f-4b46-a935-dc9090eb9b7f v:1
k: 3f3cfdf7-176b-49a4-89b2-d8946003717e v:212
```
This indicated that there existing multiple instances of the `Singleton` class
based on the different uuid.

# The Enum Singleton Pattern

You can also run the execution with the `SingletonEnum` pattern which uses an
`Enum` class as a singleton (There might be cases where you can't use an Enum
because sometimes that will not work with an enum.)

```
$ java -cp target/example-minimal-1.0-SNAPSHOT.jar com.soebes.kata.singleton.MainEnum 
```
and the output will look like this:
```
k: f3dfb9d6-34e2-44e1-88a7-c9f24f2ed4db v:1000000
```
This correctly shows there exists only a single instance of the `SingletonEnum` class
which is not really astonishing because enums are handled by the compiler (and the JVM).

# The Lock Singleton Pattern
And in cases where you can't use the previous enum pattern you have to implement like 
the `SingletonWithLock` to make sure having only a single instance within the whole JVM.

This example can be executed via:
```
$ java -cp target/example-minimal-1.0-SNAPSHOT.jar com.soebes.kata.singleton.MainSynchronizedLock 
```
which will result in the following output:
```
k: c620ab52-bd67-45fe-a833-43554da79f98 v:1000000
```

