package com.xtao.smart.service;

import com.xtao.framework.annotation.Service;

/**
 * Created by xutao on 16/9/15.
 */
@Service
public class TestService {
    public Boolean test() {
        System.out.println("test");
        return true;
    }
}
