package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.binding.EggAddBindingModel;
import com.example.projectsoftuni.model.binding.UserRegistrationBindingModel;
import com.example.projectsoftuni.model.entity.Egg;
import com.example.projectsoftuni.model.service.EggServiceModel;
import com.example.projectsoftuni.model.view.UserViewModel;
import com.example.projectsoftuni.service.CartonAddService;
import com.example.projectsoftuni.service.EggAddService;
import org.hibernate.TransactionException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.nio.file.AccessDeniedException;
import java.time.LocalDate;
import java.util.List;

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

       List<Egg> count = eggAddService.checkCountOfImport(LocalDate.now());

        boolean areImported = false;
        if(count.size() == 9){
            areImported = true;
        }

        model.addAttribute("areImported", areImported);

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

        String result = "";

        int equalTypeCartons = eggAddService.equalsTypeCartons();
        int wrongCoreyInXl = eggAddService.wrongCoreyInXL();
        int wrongCoreyLMS = eggAddService.wrongCoreyLMS();

        if(equalTypeCartons == 1){
            result  = "redirect:equal-type-carton";
        }else{
            result = "redirect:/home";
        }

        if(wrongCoreyInXl == 1){
            result = "redirect:wrong-corey-xl";
        }else{
            result = "redirect:/home";
        }

        if(wrongCoreyLMS == 1){
            result = "redirect:wrong-corey-lms";
        }else{
            result = "redirect:/home";
        }

        return result;
    }

    @GetMapping("/equal-type-carton")
    public String equalTypeCarton()  {

        return "message-equalsType-cartons";
    }

    @GetMapping("/wrong-corey-xl")
    public String wrongCoreyXL()  {

        return "message-wrong-corey-int-xl";
    }

    @GetMapping("/wrong-corey-lms")
    public String wrongCoreyLMS()  {

        return "message-wrong-corey-lms";
    }


    @GetMapping("/all-records-egg")
    public String getAllRecord(Model model)  {

        List<Egg> allRecords = eggAddService.findAll();

        model.addAttribute("allRecords", allRecords);

        return "all-records-eggs";
    }


    @RequestMapping(value = "/{id}/delete-product", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        eggAddService.deleteLocation(id);
        return "redirect:/home";
    }


}


