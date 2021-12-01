package com.example.avia;

public class Client {
    private String name;
    private String phone;
    private String reason;

    public Client(){

    }
    public Client(String name, String phone, String reason) {
        this.name = name;
        this.phone = phone;
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
