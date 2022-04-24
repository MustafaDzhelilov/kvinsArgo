package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.binding.ResidueOfExtractionBindingModel;
import com.example.projectsoftuni.model.service.ResidueOfExtractionServiceModel;
import com.example.projectsoftuni.service.ResidueOfExtractionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/residue")
public class ResidueOfExtractionEggController {

    private final ModelMapper modelMapper;
    private final ResidueOfExtractionService residueOfExtractionService;

    public ResidueOfExtractionEggController(ModelMapper modelMapper, ResidueOfExtractionService residueOfExtractionService) {
        this.modelMapper = modelMapper;
        this.residueOfExtractionService = residueOfExtractionService;
    }

    @GetMapping("/packaging-lower")
    public String addMain(Model model){
        if(!model.containsAttribute("residueOfExtractionBindingModel")){
            model.addAttribute("residueOfExtractionBindingModel", new ResidueOfExtractionBindingModel());
        }

        model.addAttribute("XLLower",residueOfExtractionService.getCountXlLower());
        model.addAttribute("LLower",residueOfExtractionService.getCountLLower());
        model.addAttribute("MLower",residueOfExtractionService.getCountMLower());
        model.addAttribute("SLower",residueOfExtractionService.getCountSLower());
        model.addAttribute("HLower",residueOfExtractionService.getCountHLower());

        return "packaging-residue-egg-lower";
    }

    @PostMapping("/packaging-lower")
    public String addMainConfirm(ResidueOfExtractionBindingModel residueOfExtractionBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("residueOfExtractionBindingModel", residueOfExtractionBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.residueOfExtractionBindingModel", bindingResult);

            return "redirect:packaging-lower";
        }

        residueOfExtractionService.packagingLower(modelMapper.map(residueOfExtractionBindingModel, ResidueOfExtractionServiceModel.class));

        return "redirect:/home";
    }

    @GetMapping("/packaging-upper")
    public String packagingUpper(Model model){
        if(!model.containsAttribute("residueOfExtractionBindingModel")){
            model.addAttribute("residueOfExtractionBindingModel", new ResidueOfExtractionBindingModel());
        }

        model.addAttribute("XLUpper",residueOfExtractionService.getCountXlUpper());
        model.addAttribute("LUpper",residueOfExtractionService.getCountLUpper());
        model.addAttribute("MUpper",residueOfExtractionService.getCountMUpper());
        model.addAttribute("SUpper",residueOfExtractionService.getCountSUpper());
        model.addAttribute("HUpper",residueOfExtractionService.getCountHUpper());

        return "packaging-residue-egg-upper";
    }

    @PostMapping("/packaging-upper")
    public String packagingUpperConfirm(ResidueOfExtractionBindingModel residueOfExtractionBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("residueOfExtractionBindingModel", residueOfExtractionBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.residueOfExtractionBindingModel", bindingResult);

            return "redirect:packaging-upper";
        }

        String result;

        int isThereAnyPacking = residueOfExtractionService.getStatusIsZero();

        residueOfExtractionService.packagingUpper(modelMapper.map(residueOfExtractionBindingModel, ResidueOfExtractionServiceModel.class));

        if(isThereAnyPacking == 1){
            result = "redirect:/home";
        }else{
            result = "redirect:not-carton";
        }

        return result;
    }

    @GetMapping("/not-carton")
    public String notCarton(){

        return "message-not-carton";
    }
}
