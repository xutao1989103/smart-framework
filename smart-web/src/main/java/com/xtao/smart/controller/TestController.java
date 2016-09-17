package com.xtao.smart.controller;

import com.xtao.framework.annotation.Action;
import com.xtao.framework.annotation.Controller;
import com.xtao.framework.annotation.Inject;
import com.xtao.framework.bean.Data;
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
    public Data test(String name, Long age) {
        System.out.println(name + ": " + age);
        Boolean test = testService.test();
        Data data = new Data(test);
        return data;
    }

    @Action(method = RequestMethod.POST, path = "/testPost")
    public void testPost() {
        System.out.println("test post");
    }
}
