package com.xtao.framework.helper;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Set;

/**
 * Created by xutao on 16/9/14.
 */
public class ClassHelperTest extends TestCase {
    @Test
    public void testGetBeanClassSet() {
        Set<Class<?>> beanSet = ClassHelper.getBeanClassSet();
        assertNotNull(beanSet);
        assertTrue(beanSet.size() > 0);
    }
}
