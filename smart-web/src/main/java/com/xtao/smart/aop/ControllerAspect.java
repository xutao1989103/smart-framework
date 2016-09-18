package com.xtao.smart.aop;

import com.xtao.framework.annotation.Aspect;
import com.xtao.framework.annotation.Controller;
import com.xtao.framework.aop.AspectProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by xutao on 16/9/17.
 */

@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {

    private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);
    private Long begin;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        logger.info("-----------begin---------");
        logger.info(String.format("class: %s", cls.getName()));
        logger.info(String.format("method: %s", method.getName()));
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
        logger.info(String.format("time: %s", System.currentTimeMillis() - begin));
        logger.info("-----------end---------");
    }
}
