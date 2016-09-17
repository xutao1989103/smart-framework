package com.xtao.framework.helper;

import com.xtao.framework.annotation.Inject;
import com.xtao.framework.util.ReflectionUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by xutao on 16/9/15.
 */
public class IocHelper {

    static {
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        for (Map.Entry<Class<?>, Object> entry : beanMap.entrySet()) {
            Class<?> clazz = entry.getKey();
            Object obj = entry.getValue();
            Field[] fields = clazz.getDeclaredFields();
            if (ArrayUtils.isNotEmpty(fields)) {
                for (Field field : fields) {
                    if (field.isAnnotationPresent(Inject.class)) {
                        Class<?> beanFieldClass = field.getType();
                        Object beanFieldInstance = beanMap.get(beanFieldClass);
                        if (beanFieldInstance != null) {
                            ReflectionUtil.setField(obj, field, beanFieldInstance);
                        }
                    }
                }
            }
        }
    }
}
