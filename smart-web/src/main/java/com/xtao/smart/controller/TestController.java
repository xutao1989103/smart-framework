package com.xtao.smart.controller;

import com.xtao.framework.annotation.Action;
import com.xtao.framework.annotation.Controller;
import com.xtao.framework.annotation.Inject;
import com.xtao.framework.enums.RequestMethod;
import com.xtao.smart.service.TestService;

/**
 * Created by xutao on 16/9/14.
 */
@Controller
public class TestController {

    @Inject
    private TestService testService;

    @Action(method = RequestMethod.GET, path = "/test")
    public Boolean test(){
        return testService.test();
    }

    @Action(method = RequestMethod.POST, path = "/testPost")
    public void testPost() {

    }
}
