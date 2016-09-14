package com.xtao.framework.helper;


import com.google.common.collect.Sets;
import com.xtao.framework.annotation.Controller;
import com.xtao.framework.annotation.Service;
import com.xtao.framework.util.ClassUtil;

import java.util.Set;

/**
 * Created by xutao on 16/9/14.
 */
public class ClassHelper {
    private static final Set<Class<?>> CLASS_SET;

    static {
        CLASS_SET = ClassUtil.getClassSet(ConfigHelper.getAppBasePackage());
    }

    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    public static Set<Class<?>> getServiceClassSet() {
        Set<Class<?>> classSet = Sets.newHashSet();
        for (Class clazz : CLASS_SET) {
            if (clazz.isAnnotationPresent(Service.class)) {
                classSet.add(clazz);
            }
        }
        return classSet;
    }

    public static Set<Class<?>> getControllerClassSet() {
        Set<Class<?>> classSet = Sets.newHashSet();
        for (Class clazz : CLASS_SET) {
            if (clazz.isAnnotationPresent(Controller.class)) {
                classSet.add(clazz);
            }
        }
        return classSet;
    }

    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> classSet = Sets.newHashSet();
        classSet.addAll(getServiceClassSet());
        classSet.addAll(getControllerClassSet());
        return classSet;
    }

}
