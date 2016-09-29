package com.xtao.smart.aop;




import com.xtao.framework.annotation.Aspect;
import com.xtao.framework.annotation.Controller;
import com.xtao.framework.aop.AspectProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;


/**
 * @author xutao
 * @email xt111024@alibaba-inc.com
 * @create 2016-09-29 上午9:49
 */

@Aspect(Controller.class)
public class LogAspect extends AspectProxy{
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        logger.info(Thread.currentThread().getName() + " " + method.getName() + " begin");
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
        logger.info(Thread.currentThread().getName() + " " + method.getName() + " end");
    }
}
