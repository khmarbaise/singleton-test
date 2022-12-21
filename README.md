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
# Singleton Test Project

The default singleton pattern which is often propagated is simply not thread safe 
which means it does not fulfil the basic idea of the Singleton pattern.

There two working solutions which are the `SingletonEnum` version or one which
contains a synchronized locking via separate object.


```
mvn clean verify org.pitest:pitest-maven:mutationCoverage
```


