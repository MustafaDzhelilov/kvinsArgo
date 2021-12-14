package com.example.projectsoftuni.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {

    private String username;
    private String password;

    public UserLoginBindingModel() {
    }

    @NotBlank(message = "Username wrong !")
    @Size(min = 3, max = 20, message = "Username length must between 3 and 20")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotBlank(message = "Password wrong !")
    @Size(min = 3, max = 20, message = "Password length must between 3 and 20")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
