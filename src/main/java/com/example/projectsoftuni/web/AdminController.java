package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.binding.UserRegistrationBindingModel;
import com.example.projectsoftuni.model.view.UserViewModel;
import com.example.projectsoftuni.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}/edit")
    public String editConfirm(@PathVariable Long id, Model model){

        System.out.println();
        UserViewModel user = userService.findUserById(id);

        model.addAttribute("user", user);

        System.out.println();
        return "edit-profile";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable Long id,
                       UserRegistrationBindingModel userRegistrationBindingModel){

        UserViewModel user = userService.findUserById(id);

        user.setRoles(userRegistrationBindingModel.getRole());
        userService.editRegisteredUser(user,id);
        return "redirect:/admin/all-users";
    }

    @GetMapping("/all-users")
    public String viewUsers(Model model) {

        model.addAttribute("allUsers",userService.getAllUsers());

        System.out.println();
        return "all-users";

    }

    @ModelAttribute
    public UserRegistrationBindingModel userRegistrationBindingModel(){
        return new UserRegistrationBindingModel();
    }
}
