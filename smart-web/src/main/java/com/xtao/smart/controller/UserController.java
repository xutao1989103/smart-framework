package com.xtao.smart.controller;

import com.xtao.framework.annotation.Action;
import com.xtao.framework.annotation.Controller;
import com.xtao.framework.annotation.Inject;
import com.xtao.framework.enums.RequestMethod;
import com.xtao.smart.entity.User;
import com.xtao.smart.service.UserService;

import java.util.List;

/**
 * @author xutao
 * @email xt111024@alibaba-inc.com
 * @create 2016-09-29 上午9:57
 */

@Controller
public class UserController {

    @Inject
    private UserService userService;

    @Action(method = RequestMethod.GET, path = "/list")
    public List<User> getList() {
        return userService.getUsers();
    }
}
