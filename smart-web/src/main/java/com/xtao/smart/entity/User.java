package com.xtao.smart.entity;

/**
 * @author xutao
 * @email xt111024@alibaba-inc.com
 * @create 2016-09-29 上午9:58
 */

public class User {

    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
