package com.xtao.smart.controller;

import com.xtao.framework.annotation.Action;
import com.xtao.framework.annotation.Controller;
import com.xtao.framework.annotation.Inject;
import com.xtao.smart.service.TestService;

/**
 * Created by xutao on 16/9/14.
 */
@Controller
public class TestController {

    @Inject
    private TestService testService;

    @Action("/test")
    public Boolean test(){
        return testService.test();
    }
}
