package com.xtao.framework.helper;

import com.xtao.framework.util.ClassUtil;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Set;

/**
 * Created by xutao on 16/9/14.
 */
public class ClassUtilTest extends TestCase {
    @Test
    public void testGetClassSet() {
        Set<Class<?>> classSet = ClassUtil.getClassSet(ConfigHelper.getAppBasePackage());
        System.out.println(classSet);
        assertNotNull(classSet);
    }
}
