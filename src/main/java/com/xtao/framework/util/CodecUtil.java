package com.xtao.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by xutao on 16/9/15.
 */
public final class CodecUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CodecUtil.class);

    private static final String UTF8 = "UTF-8";

    public static String encodeURL(String source) {
        String target;
        try {
            target = URLEncoder.encode(source, UTF8);
        } catch (Exception e) {
            LOGGER.error("encode url error", e);
            throw new RuntimeException(e);
        }
        return target;
    }

    public static String decodeURL(String source) {
        String target;
        try {
            target = URLDecoder.decode(source, UTF8);
        } catch (Exception e){
            LOGGER.error("decode url error", e);
            throw new RuntimeException(e);
        }
        return target;
    }
}
