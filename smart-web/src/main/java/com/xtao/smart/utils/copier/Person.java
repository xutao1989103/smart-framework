package com.xtao.smart.utils.copier;

/**
 * @author xutao
 * @email xt111024@alibaba-inc.com
 * @create 2016-10-29 下午10:33
 */

public class Person extends Entity{
    private String name;
    private Integer age;

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

    @Override
    public String toString() {
        return "Person{" +
                "p=" + super.toString() +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
