package com.hibernate.model;

/**
 *
 * @author: XingPc
 * @版本: 1.0
 * @创建日期: 2019年9月26日 下午9:39:30
 * @ClassName Customer
 * @类描述-Description: Customer实体类
 */

public class Customer {

    private int id;
    private String name;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", address=" + address + "]";
    }

}
