package com.xtao.framework.aop;

import com.xtao.framework.annotation.Transaction;
import com.xtao.framework.helper.DatabaseHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by xutao on 16/9/18.
 */
public class TransactionProxy implements Proxy {

    private static final Logger logger = LoggerFactory.getLogger(TransactionProxy.class);

    private static final ThreadLocal<Boolean> FLAG_HOLDER = new ThreadLocal<Boolean>() {
        @Override
        protected Boolean initialValue() {
            return false;
        }
    };

    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;
        boolean flag = FLAG_HOLDER.get();
        Method method = proxyChain.getTargetMethod();
        if(!flag && method.isAnnotationPresent(Transaction.class)) {
            FLAG_HOLDER.set(true);
            try {
                logger.info("begin transaction");
                DatabaseHelper.beginTransaction();
                result = proxyChain.doProxyChain();
                logger.info("commit transaction");
                DatabaseHelper.commitTransaction();
            }catch (Exception e) {
                DatabaseHelper.rollbackTransaction();
                logger.error("roll back transaction");
            }finally {
                FLAG_HOLDER.remove();
            }
        }else {
            result = proxyChain.doProxyChain();
        }

        return result;
    }
}
