package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.binding.FodderBindingModel;
import com.example.projectsoftuni.model.service.FodderServiceModel;
import com.example.projectsoftuni.service.FodderService;
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
@RequestMapping("/fodder")
public class FodderController {

    private final FodderService fodderService;
    private final ModelMapper modelMapper;

    public FodderController(FodderService fodderService, ModelMapper modelMapper) {
        this.fodderService = fodderService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession httpSession){
        if(!model.containsAttribute("fodderBindingModel")){
            model.addAttribute("fodderBindingModel", new FodderBindingModel());
        }
        return "fodder-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid FodderBindingModel fodderBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("fodderBindingModel", fodderBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.fodderBindingModel", bindingResult);

            return "redirect:add";
        }

        fodderService.add(modelMapper.map(fodderBindingModel, FodderServiceModel.class));

        return "redirect:/home";
    }

}


