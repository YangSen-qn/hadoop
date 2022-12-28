package org.apache.hadoop.kodo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.contract.AbstractFSContract;
import org.apache.hadoop.fs.contract.AbstractFSContractTestBase;
import org.junit.Test;

public class TestQiniuAuth extends AbstractFSContractTestBase {
    @Override
    protected AbstractFSContract createContract(Configuration conf) {
        return new KodoContract(conf);
    }

    @Test
    public void testScheme() {
        assertEquals("kodo", getContract().getScheme());
    }
}