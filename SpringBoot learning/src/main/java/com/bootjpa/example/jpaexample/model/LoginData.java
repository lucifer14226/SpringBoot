package com.bootjpa.example.jpaexample.model;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginData {

    @NotBlank(message = "User Name cannot be empty")
    @Size(min=3,max = 15,message = "User Name should consist of 3 - 12 Characters")
    private String userName;

    @NotBlank(message = "email cannot be empty")
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$" , message = "INVALID-EMAIL")
    private String email;

    @AssertTrue(message = "You must check the terms and Condition")
    private boolean isBoxChecked;

    public boolean getIsBoxChecked() {
        return isBoxChecked;
    }

    public void setIsBoxChecked(boolean boxChecked) {
        isBoxChecked = boxChecked;
    }



    public LoginData() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
