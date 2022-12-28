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
    public FSDataInputStream open(Path path, int i) throws IOException {
        return null;
    }

    @Override
    public FSDataOutputStream create(Path path, FsPermission fsPermission, boolean b, int i, short i1, long l, Progressable progressable) throws IOException {
        return null;
    }



    @Override
    public boolean rename(Path path, Path path1) throws IOException {
        return false;
    }

    @Override
    public boolean delete(Path path, boolean b) throws IOException {
        return false;
    }

    @Override
    public FileStatus[] listStatus(Path path) throws FileNotFoundException, IOException {
        return new FileStatus[0];
    }




    @Override
    public boolean mkdirs(Path path, FsPermission fsPermission) throws IOException {
        return true;
    }

    @Override
    public FileStatus getFileStatus(Path path) throws IOException {
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
    public FSDataOutputStream append(Path path, int i, Progressable progressable) throws IOException {
        throw new IOException("Not supported");
    }
    @Override
    public void setWorkingDirectory(Path path) {
        this.workingDir = path;
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
