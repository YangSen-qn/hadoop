package org.apache.hadoop.kodo;

public class Constants {
    public static final String SCHEME = "kodo";

    private static final String CONFIG_KEY_PREFIX = "fs.kodo.";

    public static final String CONFIG_KEY_ACCESS_KEY = CONFIG_KEY_PREFIX + "auth.accessKey";

    public static final String CONFIG_KEY_SECRET_KEY = CONFIG_KEY_PREFIX + "secretKey";

    public static final String CONFIG_KEY_TMP_DIR = CONFIG_KEY_PREFIX + "tmp.dir";
}
