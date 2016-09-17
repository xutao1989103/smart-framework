package com.xtao.framework.annotation;

import java.lang.annotation.*;

/**
 * Created by xutao on 16/9/17.
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    Class<? extends Annotation> value();
}
