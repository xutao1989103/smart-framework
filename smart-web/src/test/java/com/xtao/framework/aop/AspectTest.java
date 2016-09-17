package com.xtao.framework.aop;

import com.xtao.framework.HelperLoader;
import com.xtao.framework.helper.BeanHelper;
import com.xtao.smart.controller.TestController;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by xutao on 16/9/17.
 */
public class AspectTest extends TestCase {

    @Test
    public void testAspect() {
        HelperLoader.init();
        TestController testController = BeanHelper.getBean(TestController.class);
        testController.test("x", 18L);
    }

}
