package com.ttm.HelloSpringMerdeka.Entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserName {
    @Size(min=3, max =50, message = "long name must 3-50 character")
    private String Name;
    private String Address;
    @Email(message = "invalid message")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        //tradisional put if in here
        this.email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }



}
