package com.xtao.framework.helper;

import com.google.common.collect.Maps;
import com.xtao.framework.annotation.Inject;
import com.xtao.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;


/**
 * Created by xutao on 16/9/15.
 */
public class BeanHelper {

    private static final Map<Class<?>, Object> BEAN_MAP = Maps.newHashMap();

    static {
        Set<Class<?>> classSet = ClassHelper.getBeanClassSet();
        for(Class<?> clazz : classSet){
            Object obj = ReflectionUtil.newInstance(clazz);
            BEAN_MAP.put(clazz, obj);
        }
    }

    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

    public static <T> T getBean(Class<T> clazz) {
        if(!BEAN_MAP.containsKey(clazz)){
            throw new RuntimeException("can not get bean by class: " + clazz);
        }
        return (T)BEAN_MAP.get(clazz);
    }
}
