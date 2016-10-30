package com.xtao.smart.utils.mapper;

/**
 * @author xutao
 * @email xt111024@alibaba-inc.com
 * @create 2016-10-29 下午10:16
 */

public class EntityMapper<F, T> implements Mapper<F, T> {

    Class<F> fClass;
    Class<T> tClass;

    public EntityMapper(Class<F> fClass, Class<T> tClass) {
        this.fClass = fClass;
        this.tClass = tClass;
    }

    @Override
    public T map(F from) {
        try {
            T to = tClass.newInstance();
            return to;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
