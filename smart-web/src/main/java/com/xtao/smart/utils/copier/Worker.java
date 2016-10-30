package com.xtao.smart.utils.copier;

/**
 * @author xutao
 * @email xt111024@alibaba-inc.com
 * @create 2016-10-29 下午10:33
 */

public class Worker extends Person {
    private String address;
    private String company;
    private Long salary;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "p=" + super.toString() +
                ", address='" + address + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                '}';
    }
}
