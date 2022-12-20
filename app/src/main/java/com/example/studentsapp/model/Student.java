package com.example.studentsapp.model;

public class Student {
    private String name;
    private String id;
    private String phone;
    private String address;
    private boolean isChecked;

    public Student(){
        this.name = "";
        this.id = "";
        this.phone = "";
        this.address = "";
        this.isChecked = false;
    }

    public Student(String name, String id, String phone, String address,boolean isChecked) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.address = address;
        this.isChecked = isChecked;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getId() {
        return id;
    }

    public boolean getIsChecked() {
        return isChecked;
    }
}