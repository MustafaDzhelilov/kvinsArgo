package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.binding.EggAddBindingModel;
import com.example.projectsoftuni.model.binding.UserLoginBindingModel;
import com.example.projectsoftuni.model.binding.UserRegistrationBindingModel;
import com.example.projectsoftuni.model.entity.User;
import com.example.projectsoftuni.model.service.UserServiceModel;
import com.example.projectsoftuni.model.view.UserViewModel;
import com.example.projectsoftuni.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }



    @GetMapping("/register")
    public String register(Model model){
        if(!model.containsAttribute("userRegistrationBindingModel")){
            model.addAttribute("userRegistrationBindingModel", new UserRegistrationBindingModel());
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegistrationBindingModel userRegistrationBindingModel
            , BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userRegistrationBindingModel", userRegistrationBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationBindingModel", bindingResult);

            return "redirect:register";
        }

        System.out.println();
        userService.register(modelMapper.map(userRegistrationBindingModel, UserServiceModel.class));


        return "redirect:login";
    }



    @GetMapping("/login")
    public String login(Model model){

        return "login";
   }



    @GetMapping("/error-not-auth")
    public String failureError(Model model){
        return "error-not-auth";
    }



    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();

        return "redirect:/";
    }



}
