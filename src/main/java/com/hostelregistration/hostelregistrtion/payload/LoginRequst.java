package com.hostelregistration.hostelregistrtion.payload;

import org.aspectj.bridge.IMessage;

import javax.validation.constraints.NotBlank;

public class LoginRequst {
     @NotBlank(message="Email cannot be blank")
    private String email;
     @NotBlank(message ="password cannot be blank")
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
