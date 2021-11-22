package com.example.class3demo2.model;

public class Student {
    String name = "";
    String id = "";
    boolean flag = false;
    String phone = "";
    String address = "";

    public Student() {
    }

    public Student(String name, String id, boolean flag) {
        this.name = name;
        this.id = id;
        this.flag = flag;
    }

    public Student(String name, String id, String address, String phone, boolean flag) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.address = address;
        this.flag = flag;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public boolean isFlag() {
        return flag;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
