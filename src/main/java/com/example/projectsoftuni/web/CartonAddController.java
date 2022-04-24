package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.binding.CartonAddBindingModel;
import com.example.projectsoftuni.model.binding.SearchFromToCartonBindingModel;
import com.example.projectsoftuni.model.binding.SearchFromToMaterialBindingModel;
import com.example.projectsoftuni.model.binding.TransferCartonBetweenBaseBindingModel;
import com.example.projectsoftuni.model.entity.Cartons;
import com.example.projectsoftuni.model.entity.MaterialOnBase;
import com.example.projectsoftuni.model.service.CartonServiceModel;
import com.example.projectsoftuni.model.service.SearchFromToCartonServiceModel;
import com.example.projectsoftuni.model.service.SearchFromToMaterialServiceModel;
import com.example.projectsoftuni.model.service.TransferCartonBetweenBaseServiceModel;
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
import java.util.List;

@Controller
@RequestMapping("/cartons")
public class CartonAddController {

    private final CartonAddService cartonAddService;
    private final ModelMapper modelMapper;

    List<Cartons> allMaterial;

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

    @GetMapping("/transfer-cartons")
    public String transferCarton(Model model){
        if(!model.containsAttribute("transferCartonBetweenBaseBindingModel")){
            model.addAttribute("transferCartonBetweenBaseBindingModel", new TransferCartonBetweenBaseBindingModel());
        }

        return "transfer-carton-between-base";
    }


    @PostMapping("/transfer-cartons")
    public String transferCartonConfirm(@Valid TransferCartonBetweenBaseBindingModel transferCartonBetweenBaseBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("transferCartonBetweenBaseBindingModel", transferCartonBetweenBaseBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.transferCartonBetweenBaseBindingModel", transferCartonBetweenBaseBindingModel);

            return "redirect:transfer-carton-between-base";
        }

        cartonAddService.transferCarton(modelMapper.map(transferCartonBetweenBaseBindingModel, TransferCartonBetweenBaseServiceModel.class));


        return "redirect:/home";

    }

    @GetMapping("/issued")
    public String issued(Model model){

        if(!model.containsAttribute("searchFromToCartonBindingModel")){
            model.addAttribute("searchFromToCartonBindingModel", new SearchFromToCartonBindingModel());
        }

        return "search-from-to-issued-carton";
    }

    @PostMapping("/issued")
    public String issuedConfirm(@Valid SearchFromToCartonBindingModel searchFromToCartonBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("searchFromToMaterialBindingModel", searchFromToCartonBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.searchFromToCartonBindingModel", searchFromToCartonBindingModel);

            return "redirect:search-from-to-issued-carton";
        }

        allMaterial = cartonAddService.viewIssuedCarton(modelMapper.map(searchFromToCartonBindingModel, SearchFromToCartonServiceModel.class));

        return "redirect:view-issued";
    }

    @GetMapping("/view-issued")
    public String viewIssued(Model model){

        model.addAttribute("issuedMaterial", allMaterial);

        return "view-issued-carton";
    }

}
