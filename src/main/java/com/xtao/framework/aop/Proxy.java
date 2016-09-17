package com.xtao.framework.aop;

/**
 * Created by xutao on 16/9/17.
 */
public interface Proxy {

    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
