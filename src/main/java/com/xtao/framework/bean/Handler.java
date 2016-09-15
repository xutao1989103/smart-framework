package com.xtao.framework.bean;

import java.lang.reflect.Method;

/**
 * Created by xutao on 16/9/15.
 */
public class Handler {

    private Class<?> cotrollerClass;

    private Method actionMethod;

    public Handler(Class<?> cotrollerClass, Method actionMethod) {
        this.cotrollerClass = cotrollerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getCotrollerClass() {
        return cotrollerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
