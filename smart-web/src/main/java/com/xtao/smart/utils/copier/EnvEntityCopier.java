package com.xtao.smart.utils.copier;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author xutao
 * @email xt111024@alibaba-inc.com
 * @create 2016-10-29 下午11:49
 */

public class EnvEntityCopier extends EntityCopier<Student, Worker> {

    public static <T> T copy(Object sourceObj) {
        EntityCopier entityCopier = new EnvEntityCopier();

        Type type = EnvEntityCopier.class.getGenericSuperclass();
        Type[] types = ((ParameterizedType)type).getActualTypeArguments();
        Class fClass = (Class)types[0];
        Class tClass = (Class)types[1];
        entityCopier.setSourceClass(fClass);
        entityCopier.setTargetClass(tClass);
        entityCopier.init();
        return (T)entityCopier.doCopy(sourceObj);
    }

    @Override
    public Worker afterCopy(Student source, Worker target) {
        target.setCompany("alibaba");
        target.setSalary(3000L);
        return target;
    }
}
