package org.apache.hadoop.kodo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.contract.AbstractBondedFSContract;

public class KodoContract extends AbstractBondedFSContract {
    public static final String CONTRACT_XML = "contract/kodo.xml";

    public KodoContract(Configuration conf) {
        super(conf);
        addConfResource(CONTRACT_XML);
    }

    @Override
    public String getScheme() {
        return "kodo";
    }

    public synchronized static Configuration getConfiguration() {
        Configuration cfg = new Configuration();
        cfg.addResource(CONTRACT_XML);
        return cfg;
    }
}