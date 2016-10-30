package com.xtao.smart.utils.copier;

import net.sf.cglib.beans.BeanCopier;

/**
 * @author xutao
 * @email xt111024@alibaba-inc.com
 * @create 2016-10-29 下午11:00
 */

public class EntityCopier<F, T> {
    private BeanCopier beanCopier;
    private Class<F> sourceClass;
    private Class<T> targetClass;

    public EntityCopier() {
    }

    protected void init() {
        beanCopier = BeanCopier.create(this.getSourceClass(), this.getTargetClass(), false);
    }

    public T doCopy(F from) {
        try {
            T to = targetClass.newInstance();
            beanCopier.copy(from, to, null);
            return afterCopy(from, to);
        }catch (Exception e){
            throw new RuntimeException("create target object error:" + targetClass.getName() + " ", e);
        }
    }

    public T afterCopy(F source, T target) {
        return target;
    }

    public T apply(F from) {
        return doCopy(from);
    }

    public Class<T> getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class<T> targetClass) {
        this.targetClass = targetClass;
    }

    public Class<F> getSourceClass() {
        return sourceClass;
    }

    public void setSourceClass(Class<F> sourceClass) {
        this.sourceClass = sourceClass;
    }

    public BeanCopier getBeanCopier() {
        return beanCopier;
    }
}
