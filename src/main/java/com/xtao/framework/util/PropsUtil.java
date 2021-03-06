package com.xtao.framework.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by xutao on 16/9/14.
 */
public class PropsUtil {
    public static Properties loadProps(String fileName) {
        Properties properties = new Properties();
        try {
            InputStream in = ClassUtil.getClassLoader().getResourceAsStream(fileName);
            properties.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getString(Properties properties, String key) {
        return properties.getProperty(key);
    }

    public static String getString(Properties properties, String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
