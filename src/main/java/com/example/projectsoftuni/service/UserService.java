package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.entity.User;
import com.example.projectsoftuni.model.service.UserServiceModel;
import com.example.projectsoftuni.model.view.UserViewModel;

import java.util.List;

public interface UserService {

   //UserServiceModel findByUsernameAndPassword(String username, String password);

   void initializeUsersAndRoles();

    void register(UserServiceModel userServiceModel);

    User findByEmail(String email);

    String findByUsername(String username);

    UserViewModel findUserById(Long id);

    void editRegisteredUser(UserViewModel userViewModel, Long id);

   List<UserViewModel> getAllUsers();
}

