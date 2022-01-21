package com.example.projectsoftuni.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegistrationBindingModel {

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
    private String email;

    private String role;


    public UserRegistrationBindingModel() {
    }


    @NotBlank(message = "Username wrong !")
    @Size(min = 3, max = 20, message = "Username length must between 3 and 20")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotBlank(message = "FirstName wrong !")
    @Size(min = 3, max = 20, message = "FirstName length must between 3 and 20")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotBlank(message = "LastName wrong !")
    @Size(min = 3, max = 20, message = "LastName length must between 3 and 20")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotBlank(message = "Password wrong !")
    @Size(min = 3, max = 20, message = "Password length must between 3 and 20")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotBlank(message = "Wrong email")
    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotBlank(message = "Password wrong !")
    @Size(min = 3, max = 20, message = "Password length must between 3 and 20")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
