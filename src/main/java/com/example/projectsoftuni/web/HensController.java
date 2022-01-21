package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.binding.HensAddBindingModel;
import com.example.projectsoftuni.model.entity.Hale;
import com.example.projectsoftuni.model.service.HensServiceModel;
import com.example.projectsoftuni.repository.HensAddRepository;
import com.example.projectsoftuni.service.HensAddService;
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
@RequestMapping("/hales")
public class HensController {

    private final HensAddService hensAddService;
    private final ModelMapper modelMapper;
    private final HensAddBindingModel hensAddBindingModel;
    private final HensAddRepository hensAddRepository;


    public HensController(HensAddService hensAddService, ModelMapper modelMapper
            , HensAddBindingModel hensAddBindingModel, HensAddBindingModel hensAddBindingModel1
            , HensAddRepository hensAddRepository) {

        this.hensAddService = hensAddService;
        this.modelMapper = modelMapper;
        this.hensAddBindingModel = hensAddBindingModel;
        this.hensAddRepository = hensAddRepository;
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession httpSession){
        if(!model.containsAttribute("hensAddBindingModel")){
            model.addAttribute("hensAddBindingModel", new HensAddBindingModel());
        }
        return "hens-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid HensAddBindingModel hensAddBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("hensAddBindingModel", hensAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.hensAddBindingModel", bindingResult);

            return "redirect:add";
        }

        hensAddService.add(modelMapper.map(hensAddBindingModel, HensServiceModel.class));

        return "redirect:/home";
    }


   @GetMapping("/delete")
   public String delete(Model model, HttpSession httpSession){
       if(!model.containsAttribute("hensAddBindingModel")){
           model.addAttribute("hensAddBindingModel", new HensAddBindingModel());
       }

       return "hens-substraction";
   }

   @PostMapping("/delete")
   public String deleteConfirm(@Valid HensAddBindingModel hensAddBindingModel, BindingResult bindingResult
           , RedirectAttributes redirectAttributes){
       if(bindingResult.hasErrors()){
           redirectAttributes.addFlashAttribute("hensAddBindingModel", hensAddBindingModel);
           redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.hensAddBindingModel", bindingResult);

           return "redirect:delete";
       }

       hensAddService.delete(modelMapper.map(hensAddBindingModel, HensServiceModel.class));


        return "redirect:/home";

   }


}
