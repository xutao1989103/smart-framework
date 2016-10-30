package com.xtao.smart.utils.copier;

/**
 * @author xutao
 * @email xt111024@alibaba-inc.com
 * @create 2016-10-29 下午10:31
 */

public class Student extends Person {
    private String address;
    private String grade;
    private String school;

    public Student() {
    }

    public static Student getDefaultInstance() {
        Student s = new Student();
        s.setId(1L);
        s.setDeleted(false);
        s.setName("st");
        s.setAge(11);
        s.setAddress("big road");
        s.setSchool("tong ji");
        s.setGrade("2");
        return s;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
