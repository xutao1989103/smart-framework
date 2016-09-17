package com.xtao.framework.enums;

/**
 * Created by xutao on 16/9/15.
 */
public enum RequestMethod {
    GET,POST,HEAD,DELETE;

    public static RequestMethod getRequestMethod(String name) {
        RequestMethod requestMethod = GET;
        for(RequestMethod method : RequestMethod.values()){
            if(method.name().equals(name)) {
                requestMethod = method;
                break;
            }
        }
        return requestMethod;
    }
}
