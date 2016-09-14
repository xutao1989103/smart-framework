package com.xtao.framework.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by xutao on 16/9/14.
 */
public class PropsUtil {
    public static Properties loadProps(String fileName){
        Properties properties = new Properties();
        try {
            FileInputStream in = new FileInputStream(fileName);
            properties.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
