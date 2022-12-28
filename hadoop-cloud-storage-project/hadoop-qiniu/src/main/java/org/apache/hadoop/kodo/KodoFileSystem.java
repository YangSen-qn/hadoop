package org.apache.hadoop.kodo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.permission.FsPermission;
import org.apache.hadoop.util.Progressable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

public class KodoFileSystem extends FileSystem {
    @Override
    public FSDataInputStream open(Path f, int bufferSize) throws IOException {
        return null;
    }

    @Override
    public FSDataOutputStream create(Path f, FsPermission permission, boolean overwrite, int bufferSize, short replication, long blockSize, Progressable progress) throws IOException {
        return null;
    }

    @Override
    public boolean rename(Path src, Path dst) throws IOException {
        return false;
    }

    @Override
    public boolean delete(Path f, boolean recursive) throws IOException {
        return false;
    }

    @Override
    public FileStatus[] listStatus(Path f) throws FileNotFoundException, IOException {
        return new FileStatus[0];
    }

    @Override
    public boolean mkdirs(Path f, FsPermission permission) throws IOException {
        return false;
    }

    @Override
    public FileStatus getFileStatus(Path f) throws IOException {
        return null;
    }


    private String bucket;
    private Path workingDir;
    private URI uri;

    @Override
    public void initialize(URI name, Configuration conf) throws IOException {
        super.initialize(name, conf);
        this.bucket = name.getHost();
        this.uri = name;
        setConf(conf);
        this.workingDir = new Path("/");
    }

    @Override
    public URI getUri() {
        return uri;
    }

    @Override
    public FSDataOutputStream append(Path f, int bufferSize, Progressable progress) throws IOException {
        throw new IOException("Not supported");
    }

    @Override
    public void setWorkingDirectory(Path f) {
        this.workingDir = f;
    }

    @Override
    public Path getWorkingDirectory() {
        return this.workingDir;
    }

    @Override
    public String getScheme() {
        return Constants.SCHEME;
    }
}
