package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.binding.CartonAddBindingModel;
import com.example.projectsoftuni.model.service.CartonServiceModel;
import com.example.projectsoftuni.service.CartonAddService;
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
@RequestMapping("/cartons")
public class CartonAddController {

    private final CartonAddService cartonAddService;
    private final ModelMapper modelMapper;

    public CartonAddController(CartonAddService cartonAddService, ModelMapper modelMapper) {
        this.cartonAddService = cartonAddService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add-cartons")
    public String addCarton(Model model, HttpSession httpSession){
        if(!model.containsAttribute("cartonAddBindingModel")){
            model.addAttribute("cartonAddBindingModel", new CartonAddBindingModel());
        }

        return "carton-add";
    }


    @PostMapping("/add-cartons")
    public String addCartonConfirm(@Valid CartonAddBindingModel cartonAddBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("cartonAddBindingModel", cartonAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.cartonAddBindingModel", cartonAddBindingModel);

            return "redirect:add-cartons";
        }

        cartonAddService.addCarton(modelMapper.map(cartonAddBindingModel, CartonServiceModel.class));


        return "redirect:/home";

    }

}
