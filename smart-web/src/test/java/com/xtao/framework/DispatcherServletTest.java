package com.xtao.framework;

import junit.framework.TestCase;
import org.junit.Test;


/**
 * Created by xutao on 16/9/15.
 */
public class DispatcherServletTest extends TestCase {

    @Test
    public void testDispatcherServlet() throws Exception {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        dispatcherServlet.init();
    }
}
