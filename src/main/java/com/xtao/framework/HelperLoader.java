package com.xtao.framework;

import com.xtao.framework.helper.ControllerHelper;
import com.xtao.framework.helper.BeanHelper;
import com.xtao.framework.helper.ClassHelper;
import com.xtao.framework.helper.IocHelper;
import com.xtao.framework.util.ClassUtil;

/**
 * Created by xutao on 16/9/15.
 */
public final class HelperLoader {
    public static void init() {
        Class<?>[] classes = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for(Class<?> clazz : classes){
            ClassUtil.loadClass(clazz.getName(), false);
        }
    }
}
