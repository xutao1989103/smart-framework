package com.xtao.smart.service;

import com.google.common.collect.Lists;
import com.xtao.framework.annotation.Service;
import com.xtao.smart.entity.User;

import java.util.List;

/**
 * @author xutao
 * @email xt111024@alibaba-inc.com
 * @create 2016-09-29 上午9:59
 */

@Service
public class UserService {

    private static List<User> userList = Lists.newArrayList();

    static {
        userList.add(new User("wade", 24));
        userList.add(new User("bosh", 25));
        userList.add(new User("james", 26));
    }

    public List<User> getUsers(){
        return userList;
    }

    public User update(User user) {
        return user;
    }
}
