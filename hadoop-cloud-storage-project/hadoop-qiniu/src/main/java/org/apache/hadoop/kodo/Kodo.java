package org.apache.hadoop.kodo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.DelegateToFileSystem;
import org.apache.hadoop.fs.FileSystem;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Kodo extends DelegateToFileSystem {
    public Kodo(URI theUri, Configuration conf) throws IOException, URISyntaxException {
        super(theUri, new KodoFileSystem(), conf, Constants.SCHEME, false);
    }

    @Override
    public int getUriDefaultPort() {
        return -1;
    }
}
