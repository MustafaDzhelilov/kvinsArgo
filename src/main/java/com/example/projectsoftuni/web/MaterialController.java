package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.binding.MaterialBindingModel;
import com.example.projectsoftuni.model.binding.MaterialOnBaseBindingModel;
import com.example.projectsoftuni.model.service.MaterialOnBaseServiceModel;
import com.example.projectsoftuni.model.service.MaterialServiceModel;
import com.example.projectsoftuni.service.MaterialOnBaseService;
import com.example.projectsoftuni.service.MaterialService;
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
@RequestMapping("/material")
public class MaterialController {

    private final ModelMapper modelMapper;
    private final MaterialService materialService;
    private final MaterialServiceModel materialServiceModel;
    private final MaterialOnBaseService materialOnBaseService;
    private final  MaterialOnBaseServiceModel materialOnBaseServiceModel;

    public MaterialController(ModelMapper modelMapper, MaterialService materialService, MaterialServiceModel materialServiceModel, MaterialOnBaseService materialOnBaseService, MaterialOnBaseServiceModel materialOnBaseServiceModel) {
        this.modelMapper = modelMapper;
        this.materialService = materialService;
        this.materialServiceModel = materialServiceModel;
        this.materialOnBaseService = materialOnBaseService;
        this.materialOnBaseServiceModel = materialOnBaseServiceModel;
    }

    @GetMapping("/add")
    public String sell(Model model){

        if(!model.containsAttribute("materialBindingModel")){
            model.addAttribute("materialBindingModel", new MaterialBindingModel());
        }

        return "material-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid MaterialBindingModel materialBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("materialBindingModel", materialBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.materialBindingModel", materialBindingModel);

            return "redirect:add";
        }

        materialService.addMaterial(modelMapper.map(materialBindingModel, MaterialServiceModel.class));

        return "redirect:/home";
    }

    @GetMapping("/now")
    public String viewMaterialNow(Model model){

        Long tape = materialService.getTapeCount();
        Long stretchOrdinary = materialService.getStretchOrdinary();
        Long stretchHoles = materialService.getStretchHoles();

        model.addAttribute("tape", tape);
        model.addAttribute("stretchOrdinary", stretchOrdinary);
        model.addAttribute("stretchHoles", stretchHoles);

        Long typeLower = materialOnBaseService.getTapeCountLower();
        Long stretchOrdinaryLower = materialOnBaseService.getStretchOrdinaryLower();
        Long stretchHolesLower = materialOnBaseService.getStretchHolesLower();

        model.addAttribute("typeLower", typeLower);
        model.addAttribute("stretchOrdinaryLower", stretchOrdinaryLower);
        model.addAttribute("stretchHolesLower", stretchHolesLower);

        Long typeUpper = materialOnBaseService.getTapeCountUpper();
        Long stretchOrdinaryUpper = materialOnBaseService.getStretchOrdinaryUpper();
        Long stretchHolesUpper = materialOnBaseService.getStretchHolesUpper();

        model.addAttribute("typeUpper", typeUpper);
        model.addAttribute("stretchOrdinaryUpper", stretchOrdinaryUpper);
        model.addAttribute("stretchHolesUpper", stretchHolesUpper);

        return "office-material-now";
    }

    @GetMapping("/add_base")
    public String addBase(Model model){

        if(!model.containsAttribute("materialOnBaseBindingModel")){
            model.addAttribute("materialOnBaseBindingModel", new MaterialOnBaseBindingModel());
        }


        return "material-add-base";
    }

    @PostMapping("/add_base")
    public String addConfirm(@Valid MaterialOnBaseBindingModel materialOnBaseBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("materialOnBaseBindingModel", materialOnBaseBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.materialOnBaseBindingModel", materialOnBaseBindingModel);

            return "redirect:add_base";
        }

        materialOnBaseService.addMaterialOnBase(modelMapper.map(materialOnBaseBindingModel, MaterialOnBaseServiceModel.class));

        return "redirect:/home";
    }

}
