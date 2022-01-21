package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.binding.EggAddBindingModel;
import com.example.projectsoftuni.model.service.EggServiceModel;
import com.example.projectsoftuni.service.CartonAddService;
import com.example.projectsoftuni.service.EggAddService;
import org.hibernate.TransactionException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.nio.file.AccessDeniedException;

@Controller
@RequestMapping("/products")
public class EggAddController {

    private final EggServiceModel eggServiceModel;
    private final ModelMapper modelMapper;
    private final EggAddService eggAddService;

    public EggAddController(EggServiceModel eggServiceModel, ModelMapper modelMapper, EggAddService eggAddService) {
        this.eggServiceModel = eggServiceModel;
        this.modelMapper = modelMapper;
        this.eggAddService = eggAddService;
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession httpSession)  {
        if(!model.containsAttribute("eggAddBindingModel")){
            model.addAttribute("eggAddBindingModel", new EggAddBindingModel());
        }
        return "product-add";
    }


    @PostMapping("/add")
    public String addConfirm(@Valid EggAddBindingModel eggAddBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("eggAddBindingModel", eggAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.eggAddBindingModel", bindingResult);

            return "redirect:add";
        }


        eggAddService.add(modelMapper.map(eggAddBindingModel, EggServiceModel.class));



        return "redirect:/home";
    }


}


