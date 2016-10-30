package com.xtao.smart.utils.copier;

/**
 * @author xutao
 * @email xt111024@alibaba-inc.com
 * @create 2016-10-30 上午11:10
 */

public class CommonEntityCopier extends EntityCopier {
    public static <T> T copy(Class fClass, Class tClass, Object sourceObj) {
        EntityCopier entityCopier = new CommonEntityCopier();
        entityCopier.setSourceClass(fClass);
        entityCopier.setTargetClass(tClass);
        entityCopier.init();
        return (T)entityCopier.doCopy(sourceObj);
    }
}
