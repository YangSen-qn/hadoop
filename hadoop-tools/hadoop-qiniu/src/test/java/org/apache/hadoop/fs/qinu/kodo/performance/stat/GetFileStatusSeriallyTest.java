package org.apache.hadoop.fs.qinu.kodo.performance.stat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GetFileStatusSeriallyTest extends AGetFileStatusTest {
    @Override
    protected ExecutorService buildExecutorService() {
        return Executors.newSingleThreadExecutor();
    }

    @Override
    protected int consumers() {
        return 1;
    }
}
