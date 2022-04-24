package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.binding.FodderBindingModel;
import com.example.projectsoftuni.model.binding.MainFodderBindingModel;
import com.example.projectsoftuni.model.binding.SearchFromToKgAcceptedFooderBindingModel;
import com.example.projectsoftuni.model.entity.Fodder;
import com.example.projectsoftuni.model.service.FodderServiceModel;
import com.example.projectsoftuni.model.service.MainFodderServiceModel;
import com.example.projectsoftuni.model.service.SearchFromToKgAcceptedFooderServiceModel;
import com.example.projectsoftuni.service.EatenFodderAndWaterService;
import com.example.projectsoftuni.service.FodderService;
import com.example.projectsoftuni.service.HensAddService;
import com.example.projectsoftuni.service.MainFodderService;
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
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/fodder")
public class FodderController {

    private final FodderService fodderService;
    private final ModelMapper modelMapper;
    private final EatenFodderAndWaterService eatenFodderAndWaterService;
    private final HensAddService hensAddService;
    private final MainFodderService mainFodderService;
    String result = null;
    List<Fodder> allAceptedFooderForLastDay;
    Long totalKg = 0L;
    Long kg = 0L;
    LocalDate start;
    LocalDate end;
    Long status;

    public FodderController(FodderService fodderService, ModelMapper modelMapper, EatenFodderAndWaterService eatenFodderAndWaterService, HensAddService hensAddService, MainFodderService mainFodderService) {
        this.fodderService = fodderService;
        this.modelMapper = modelMapper;
        this.eatenFodderAndWaterService = eatenFodderAndWaterService;
        this.hensAddService = hensAddService;
        this.mainFodderService = mainFodderService;
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession httpSession){
        if(!model.containsAttribute("fodderBindingModel")){
            model.addAttribute("fodderBindingModel", new FodderBindingModel());
        }

        Long currentKgOfFodder = mainFodderService.getKg();
        model.addAttribute("kg", currentKgOfFodder);

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

        String result = null;
        fodderService.add(modelMapper.map(fodderBindingModel, FodderServiceModel.class));

        status = fodderService.checkStatusKg();

        if(status == 0){
            result = "redirect:/home";
        }else if(status > 0){
            result = "redirect:message-fodder-needed";
        }

        return result;
    }

    @GetMapping("/message-fodder-needed")
    public String add(Model model){

        model.addAttribute("kgNeeded", status);
        model.addAttribute("totalKgFodder", mainFodderService.getKg());

        return "message-fodder";
    }


    @GetMapping("/search-fodder")
    public String fodderView(Model model){

        if(!model.containsAttribute("searchFromToKgAcceptedFooderBindingModel")){
            model.addAttribute("searchFromToKgAcceptedFooderBindingModel", new SearchFromToKgAcceptedFooderBindingModel());
        }

        return "search-kg-fooder-from-to";
    }

    @PostMapping("/search-fodder")
    public String fodderViewConfirm(@Valid SearchFromToKgAcceptedFooderBindingModel searchFromToKgAcceptedFooderBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("searchSellFromToWithClient", searchFromToKgAcceptedFooderBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.searchFromToKgAcceptedFooderBindingModel", searchFromToKgAcceptedFooderBindingModel);

            return "redirect:search-kg-fooder-from-to";
        }

        allAceptedFooderForLastDay = fodderService
                .getKgOfFodderBySilo(modelMapper.map(searchFromToKgAcceptedFooderBindingModel, SearchFromToKgAcceptedFooderServiceModel.class))
                .stream()
                .sorted(Comparator.comparing(Fodder::getAcceptedTime)
                        .reversed())
                .collect(Collectors.toList());


        for (int i=0; i<=allAceptedFooderForLastDay.size()-1; i++) {
            if(allAceptedFooderForLastDay.get(i).getKilogramOfFodder() > 0) {
                totalKg += allAceptedFooderForLastDay.get(i).getKilogramOfFodder();
            }
        }
         kg = totalKg;
        totalKg = 0L;

        Long type  = searchFromToKgAcceptedFooderBindingModel.getNumber();
        start = searchFromToKgAcceptedFooderBindingModel.getStart();
        end = searchFromToKgAcceptedFooderBindingModel.getEnd();

        if(!allAceptedFooderForLastDay.isEmpty()) {
            if (type == 1) {
                result = "redirect:view-silo";
            } else if (type == 2) {
                result = "redirect:view-silo-total";
            }
        }else{
            result = "redirect:message-after-search-fodder";
        }


        return result;
    }

    @GetMapping("/view-silo")
    public String siloView(Model model){

        for (int i = 0; i <= allAceptedFooderForLastDay.size()-1; i++) {
            if(allAceptedFooderForLastDay.get(i).getKilogramOfFodder() < 0){
                allAceptedFooderForLastDay.remove(i);
            }
        }

        model.addAttribute("fodderList", allAceptedFooderForLastDay);

        return "silo-view";
    }


    @GetMapping("/view-silo-total")
    public String siloViewKgTotal(Model model){

        model.addAttribute("start",start );
        model.addAttribute("end",end );
        model.addAttribute("kg", kg);

        return "result-search-fodder-kg-total";
    }

    @GetMapping("/message-after-search-fodder")
    public String message(Model model){

        return "message-fodder-kg";
    }

    @GetMapping("/free-space-in-all-silo")
    public String freeSpace(Model model){

                Long kgSilo_1_now = fodderService.getKGSilo1();
                Long kgSilo_2_now = fodderService.getKGSilo2();
                Long kgSilo_3_now = fodderService.getKGSilo3();
                Long kgSilo_4_now = fodderService.getKGSilo4();
                Long kgSilo_5_now = fodderService.getKGSilo5();
                Long kgSilo_6_now = fodderService.getKGSilo6();
                Long kgSilo_7_now = fodderService.getKGSilo7();
                Long kgSilo_8_now = fodderService.getKGSilo8();
                Long kgSilo_9_now = fodderService.getKGSilo9();

        model.addAttribute("silo1", kgSilo_1_now);
        model.addAttribute("silo2", kgSilo_2_now);
        model.addAttribute("silo3", kgSilo_3_now);
        model.addAttribute("silo4", kgSilo_4_now);
        model.addAttribute("silo5", kgSilo_5_now);
        model.addAttribute("silo6", kgSilo_6_now);
        model.addAttribute("silo7", kgSilo_7_now);
        model.addAttribute("silo8", kgSilo_8_now);
        model.addAttribute("silo9", kgSilo_9_now);

        model.addAttribute("silo1free", 15000-kgSilo_1_now);
        model.addAttribute("silo2free", 15000-kgSilo_2_now);
        model.addAttribute("silo3free", 15000-kgSilo_3_now);
        model.addAttribute("silo4free", 15000-kgSilo_4_now);
        model.addAttribute("silo5free", 26000-kgSilo_5_now);
        model.addAttribute("silo6free", 26000-kgSilo_6_now);
        model.addAttribute("silo7free", 26000-kgSilo_7_now);
        model.addAttribute("silo8free", 26000-kgSilo_8_now);
        model.addAttribute("silo9free", 26000-kgSilo_9_now);


        return "kgOfFodderAndFreeSpaceInSilo";
    }

    @GetMapping("/last-eat")
    public String lastEat(Model model){
        System.out.println();
        String statusSilo1 = "OK";
        String statusSilo2 = "OK";
        String statusSilo3 = "OK";
        String statusSilo4 = "OK";
        String statusSilo5 = "OK";
        String statusSilo6 = "OK";
        String statusSilo7 = "OK";
        String statusSilo8 = "OK";
        String statusSilo9 = "OK";

        Long kgSilo_1_last = eatenFodderAndWaterService.getLastEatenKgSilo1();
        Long countHensHale1 = hensAddService.getCountOfHnesFirstLast();
        if((countHensHale1 * 0.04166) > kgSilo_1_last || (countHensHale1 * 0.045) <= kgSilo_1_last){
            statusSilo1 = "Внимание !";
        }
        model.addAttribute("kgSilo_1_last",kgSilo_1_last);
        model.addAttribute("statusSilo1",statusSilo1);

        Long kgSilo_2_last = eatenFodderAndWaterService.getLastEatenKgSilo2();
        Long countHensHale2 = hensAddService.getCountOfHensSecondLast();
        if((countHensHale2 * 0.04166) > kgSilo_2_last || (countHensHale2 * 0.045) <= kgSilo_2_last){
            statusSilo2 = "Внимание !";
        }
        model.addAttribute("kgSilo_2_last",kgSilo_2_last);
        model.addAttribute("statusSilo2",statusSilo2);

        Long kgSilo_3_last = eatenFodderAndWaterService.getLastEatenKgSilo3();
        Long countHensHale3 = hensAddService.getCountOfHensThirdLast();
        if((countHensHale3 * 0.04166) > kgSilo_3_last || (countHensHale3 * 0.045) <= kgSilo_3_last){
            statusSilo3 = "Внимание !";
        }
        model.addAttribute("kgSilo_3_last",kgSilo_3_last);
        model.addAttribute("statusSilo3",statusSilo3);

        Long kgSilo_4_last = eatenFodderAndWaterService.getLastEatenKgSilo4();
        Long countHensHale4 = hensAddService.getCountOfHensFourthLast();
        if((countHensHale4 * 0.04166) > kgSilo_4_last || (countHensHale4 * 0.045) <= kgSilo_4_last){
            statusSilo4 = "Внимание !";
        }
        model.addAttribute("kgSilo_4_last",kgSilo_4_last);
        model.addAttribute("statusSilo4",statusSilo4);

        Long kgSilo_5_last = eatenFodderAndWaterService.getLastEatenKgSilo5();
        Long countHensHale5 = hensAddService.getCountOfHensFifthLast();
        if((countHensHale5 * 0.04166) > kgSilo_5_last || (countHensHale5 * 0.045) <= kgSilo_5_last){
            statusSilo5 = "Внимание !";
        }
        model.addAttribute("kgSilo_5_last",kgSilo_5_last);
        model.addAttribute("statusSilo5",statusSilo5);

        Long kgSilo_6_last = eatenFodderAndWaterService.getLastEatenKgSilo6();
        Long countHensHale6 = hensAddService.getCountOfHensSixthLast();
        if((countHensHale6 * 0.04166) > kgSilo_6_last || (countHensHale6 * 0.045) <= kgSilo_6_last){
            statusSilo6 = "Внимание !";
        }
        model.addAttribute("kgSilo_6_last",kgSilo_6_last);
        model.addAttribute("statusSilo6",statusSilo6);

        Long kgSilo_7_last = eatenFodderAndWaterService.getLastEatenKgSilo7();
        Long countHensHale7 = hensAddService.getCountOfHensSeventhLast();
        if((countHensHale7 * 0.04166) > kgSilo_7_last || (countHensHale7 * 0.045) <= kgSilo_7_last){
            statusSilo7 = "Внимание !";
        }
        model.addAttribute("kgSilo_7_last",kgSilo_7_last);
        model.addAttribute("statusSilo7",statusSilo7);

        Long kgSilo_8_last = eatenFodderAndWaterService.getLastEatenKgSilo8();
        Long countHensHale8 = hensAddService.getCountOfHensEighthLast();
        if((countHensHale8 * 0.04166) > kgSilo_8_last || (countHensHale8 * 0.045) <= kgSilo_8_last){
            statusSilo8 = "Внимание !";
        }
        model.addAttribute("kgSilo_8_last",kgSilo_8_last);
        model.addAttribute("statusSilo8",statusSilo8);


        Long kgSilo_9_last = eatenFodderAndWaterService.getLastEatenKgSilo9();
        Long countHensHale9 = hensAddService.getCountOfHensNinthLast();
        if((countHensHale9 * 0.04166) > kgSilo_9_last || (countHensHale9 * 0.045) <= kgSilo_9_last){
            statusSilo9 = "Внимание !";
        }
        model.addAttribute("kgSilo_9_last",kgSilo_9_last);
        model.addAttribute("statusSilo9",statusSilo9);

        return "last-eaten-fodder-and-sas";
    }


    @GetMapping("/add-main")
    public String addMain(Model model){
        if(!model.containsAttribute("mainFodderBindingModel")){
            model.addAttribute("mainFodderBindingModel", new MainFodderBindingModel());
        }
        return "main-fodder-add";
    }

    @PostMapping("/add-main")
    public String addMainConfirm(@Valid MainFodderBindingModel mainFodderBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("mainFodderBindingModel", mainFodderBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.mainFodderBindingModel", bindingResult);

            return "redirect:add-main";
        }

        mainFodderService.add(modelMapper.map(mainFodderBindingModel, MainFodderServiceModel.class));

        return "redirect:/home";
    }

}


