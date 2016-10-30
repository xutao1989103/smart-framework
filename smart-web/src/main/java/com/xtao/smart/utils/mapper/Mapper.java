package com.xtao.smart.utils.mapper;

/**
 * @author xutao
 * @email xt111024@alibaba-inc.com
 * @create 2016-10-29 下午10:09
 */

public interface Mapper<F, T> {
    T map(F from);
}
