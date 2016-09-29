package com.xtao.framework.aop;

import com.google.common.collect.Lists;
import com.xtao.framework.HelperLoader;
import com.xtao.framework.helper.BeanHelper;
import com.xtao.smart.controller.TestController;
import com.xtao.smart.controller.UserController;
import com.xtao.smart.entity.User;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by xutao on 16/9/17.
 */
public class AspectTest extends TestCase {

    public static final int invokeTimes = 10;

    @Test
    public void testAspect() {
        HelperLoader.init();
        TestController testController = BeanHelper.getBean(TestController.class);
        //testController.test("x", 18L);

        testController.testPost();
    }

    @Test
    public void testMutiThreadAspect() throws Exception{
        HelperLoader.init();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Future<Boolean>> futures = Lists.newArrayList();
        for(int i=0; i<invokeTimes; i++) {
            Future<Boolean> future = executor.submit(new MockRequest());
            futures.add(future);
        }

        for (Future<Boolean> future : futures) {
            assertTrue(future.get());
        }
    }

    class MockRequest implements Callable<Boolean> {
        @Override
        public Boolean call() throws Exception {
            UserController userController = BeanHelper.getBean(UserController.class);
            List<User> users = userController.getList();
            return users != null ? users.size() == 3 : false;
        }
    }

}
