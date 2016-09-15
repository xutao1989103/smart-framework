package com.xtao.framework.bean;


import com.google.common.collect.Maps;
import com.xtao.framework.annotation.Action;
import com.xtao.framework.enums.RequestMethod;
import com.xtao.framework.helper.ClassHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/**
 * Created by xutao on 16/9/15.
 */
public class ControllerHelper {

    private static final Map<Request, Handler> ACTION_MAP = Maps.newHashMap();

    static {
        Set<Class<?>> controllers = ClassHelper.getControllerClassSet();
        if (CollectionUtils.isNotEmpty(controllers)) {
            for (Class<?> clazz : controllers) {
                Method[] methods = clazz.getMethods();
                if(ArrayUtils.isNotEmpty(methods)) {
                    for(Method method : methods) {
                        if(method.isAnnotationPresent(Action.class)) {
                            Action action = method.getAnnotation(Action.class);
                            RequestMethod requestMethod = action.method();
                            String requestPath = action.path();
                            Request request = new Request(requestMethod, requestPath);
                            Handler handler = new Handler(clazz, method);
                            ACTION_MAP.put(request, handler);
                        }
                    }
                }
            }
        }
    }

    public static Handler getHandler(Request request) {
        return ACTION_MAP.get(request);
    }

    public static Handler getHandler(RequestMethod requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return getHandler(request);
    }

}
