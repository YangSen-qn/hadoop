<!---
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License. See accompanying LICENSE file.
-->

# Integeration of Qiniu Kodo in Hadoop

## Introduction

[Qiniu Kodo](https://www.qiniu.com/products/kodo) is a famous object storage system provided by Qiniu. Hadoop-Kodo is a client that makes the upper computing systems based on HDFS be able to use the Kodo as its underlying storage system. The big data-processing systems that have been identified for support are: Hadoop MR, Spark, Alluxio and etc. In addition, Druid also can use Kodo as its deep storage by configuring HDFS-Load-Plugin integerating with HADOOP-KODO.


## Features

- Support Hadoop write data into Kodo and read from it directly.


## Testing the hadoop-cos Module

To test Kodo filesystem, the following two files which pass in authentication details to the test runner are needed.

1. auth-keys.xml
2. core-site.xml

These two files need to be created under the `hadoop-cloud-storage-project/hadoop-kodo/src/test/resource` directory.


### `auth-key.xml`

Kodo credentials can specified in `auth-key.xml`. At the same time, it is also a trigger for the Kodo filesystem tests.
Kodo bucket URL should be provided by specifying the option: `test.fs.kodo.name`.

An example of the `auth-keys.xml` is as follow:

```xml
<configuration>
    <property>
        <name>fs.qiniu.kodo.auth.accessKey</name>
        <value>XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</value>
    </property>

    <property>
        <name>fs.qiniu.kodo.auth.secretKey</name>
        <value>XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</value>
    </property>
</configuration>
```

Without this file, all tests in this module will be skipped.

### `core-site.xml`

This file pre-exists and sources the configurations created in auth-keys.xml.
For most cases, no modification is needed, unless a specific, non-default property needs to be set during the testing.

### `contract-test-options.xml`

All configurations related to support contract tests need to be specified in `contract-test-options.xml`. Here is an example of `contract-test-options.xml`.

```xml
<?xml version="1.0"?>
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
<configuration>
    <include xmlns="http://www.w3.org/2001/XInclude"
             href="auth-keys.xml"/>
    <property>
        <name>fs.contract.test.fs.kodo</name>
        <value>kodo://testbucket-xxx</value>
    </property>
</configuration>

```

If the option `fs.contract.test.fs.kodo` not definded in the file, all contract tests will be skipped.