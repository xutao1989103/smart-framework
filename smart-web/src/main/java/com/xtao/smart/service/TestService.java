package com.xtao.smart.service;

import com.xtao.framework.annotation.Service;
import com.xtao.framework.annotation.Transaction;

/**
 * Created by xutao on 16/9/15.
 */
@Service
public class TestService {

    @Transaction
    public Boolean test() {
        System.out.println("test");
        throw new RuntimeException();
        //return true;
    }
}
