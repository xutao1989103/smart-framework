package com.xtao.framework.helper;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by xutao on 16/9/14.
 */
public class ConfigHelperTest extends TestCase {
    @Test
    public void testGetProperties() {
        assertNotNull(ConfigHelper.getJdbcDriver());
        assertNotNull(ConfigHelper.getJdbcUrl());
        assertNotNull(ConfigHelper.getJdbcUsername());
        assertNotNull(ConfigHelper.getJdbcPassword());
        assertNotNull(ConfigHelper.getAppBasePackage());
        assertNotNull(ConfigHelper.getAppJspPath());
        assertNotNull(ConfigHelper.getAppAssetPath());
    }
}
