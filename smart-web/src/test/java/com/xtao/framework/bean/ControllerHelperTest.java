package com.xtao.framework.bean;

import com.xtao.framework.enums.RequestMethod;
import com.xtao.framework.helper.ControllerHelper;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by xutao on 16/9/15.
 */
public class ControllerHelperTest extends TestCase {
    @Test
    public void testControllerHelper() {
        Handler handler1 = ControllerHelper.getHandler(RequestMethod.GET, "/test");
        Handler handler2 = ControllerHelper.getHandler(RequestMethod.POST, "/testPost");
        assertNotNull(handler1);
        assertNotNull(handler2);

    }
}
