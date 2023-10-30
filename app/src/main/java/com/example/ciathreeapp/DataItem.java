package com.example.ciathreeapp;

public class DataItem {
    private String name;
    private int age;
    private String phone;
    private String mail;
    private String aadhaar;
    private String address;


    public DataItem(String name, int age,String phone,String mail,String aadhaar,String address) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.mail = mail;
        this.aadhaar = aadhaar;
        this.address = address;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getAadhaar() {
        return aadhaar;
    }

    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
