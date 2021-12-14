package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.binding.ClientAddBindingModel;
import com.example.projectsoftuni.model.service.CartonServiceModel;
import com.example.projectsoftuni.model.service.ClientServiceModel;
import com.example.projectsoftuni.service.ClientAddService;
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

@Controller
@RequestMapping("/clients")
public class ClientAddController {

    private final ClientAddService clientAddService;
    private final ModelMapper modelMapper;
    private final ClientServiceModel clientServiceModel;

    public ClientAddController(ClientAddService clientAddService, ModelMapper modelMapper, ClientServiceModel clientServiceModel) {
        this.clientAddService = clientAddService;
        this.modelMapper = modelMapper;
        this.clientServiceModel = clientServiceModel;
    }

    @GetMapping("/add-client")
    public String addClient(Model model, HttpSession httpSession){
        if(!model.containsAttribute("clientAddBindingModel")){
            model.addAttribute("clientAddBindingModel", new ClientAddBindingModel());
        }

        return "client-add";
    }


    @PostMapping("/add-client")
    public String addCartonConfirm(@Valid ClientAddBindingModel clientAddBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("clientAddBindingModel", clientAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.clientAddBindingModel", clientAddBindingModel);

            return "redirect:add-client";
        }

        clientAddService.addClient(modelMapper.map(clientAddBindingModel, ClientServiceModel.class));


        return "redirect:/home";

    }

}



