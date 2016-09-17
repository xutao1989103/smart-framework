package com.xtao.framework.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xutao on 16/9/15.
 */
public final class JsonUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static <T> String toJosn(T obj) {
        String json;
        try {
            json = OBJECT_MAPPER.writeValueAsString(obj);
        } catch (Exception e){
            LOGGER.error("convert POJO to JSON error ", e);
            throw new RuntimeException(e);
        }
        return json;
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        T pojo;
        try {
            pojo = OBJECT_MAPPER.readValue(json, clazz);
        } catch (Exception e){
            LOGGER.error("convert POJO to JSON error ", e);
            throw new RuntimeException(e);
        }
        return pojo;
    }

}
