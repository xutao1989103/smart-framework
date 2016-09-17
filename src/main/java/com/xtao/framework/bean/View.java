package com.xtao.framework.bean;

import java.util.Map;

/**
 * Created by xutao on 16/9/15.
 */
public class View {

    private String path;

    private Map<String, Object> model;

    public View(String path, Map<String, Object> model) {
        this.path = path;
        this.model = model;
    }

    public View addModel(String key, String value) {
        model.put(key, value);
        return this;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
