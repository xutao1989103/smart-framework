package com.xtao.framework;

import com.xtao.framework.helper.*;
import com.xtao.framework.util.ClassUtil;

/**
 * Created by xutao on 16/9/15.
 */
public final class HelperLoader {
    public static void init() {
        Class<?>[] classes = {
                ClassHelper.class,
                BeanHelper.class,
                AopHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> clazz : classes) {
            ClassUtil.loadClass(clazz.getName(), true);
        }
    }
}
