package com.xtao.framework.bean;

import com.xtao.framework.enums.RequestMethod;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by xutao on 16/9/15.
 */
public class Request {

    private RequestMethod requestMethod;

    private String requestPath;

    public Request(RequestMethod requestMethod, String requestPath) {
        this.requestMethod = requestMethod;
        this.requestPath = requestPath;
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(RequestMethod requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }
}
