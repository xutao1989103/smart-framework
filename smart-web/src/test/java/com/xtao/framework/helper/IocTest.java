package com.xtao.framework.helper;

import com.xtao.smart.controller.TestController;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by xutao on 16/9/15.
 */
public class IocTest extends TestCase{
    @Test
    public void testController() {
        IocHelper iocHelper = new IocHelper();
        TestController testController = BeanHelper.getBean(TestController.class);
        assertNotNull(testController.test("xtao", 26L));
    }
}
