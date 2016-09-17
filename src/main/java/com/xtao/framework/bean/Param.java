package com.xtao.framework.bean;

import java.util.Map;

/**
 * Created by xutao on 16/9/15.
 */
public class Param {

    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public Long getLong(String name) {
        return Long.valueOf(paramMap.get(name).toString());
    }

    public Map<String, Object> getMap() {
        return paramMap;
    }
}
