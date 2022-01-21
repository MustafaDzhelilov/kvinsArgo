package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.binding.ReturnedPalletsBindingModel;
import com.example.projectsoftuni.model.binding.SellBindingModel;
import com.example.projectsoftuni.model.entity.Sells;
import com.example.projectsoftuni.model.service.ReturnedPalletsServiceModel;
import com.example.projectsoftuni.model.service.SellsServiceModel;
import com.example.projectsoftuni.service.ReturnedPalletsService;
import com.example.projectsoftuni.service.SellsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;


@Controller
@RequestMapping("/egg")
public class SellsController {

    private final SellsService sellsService;
    private final ModelMapper modelMapper;
    private final SellsServiceModel sellsServiceModel;
    private final ReturnedPalletsServiceModel returnedPalletsServiceModel;
    private final ReturnedPalletsService returnedPalletsService;


    public SellsController(SellsService sellsService, ModelMapper modelMapper, SellsServiceModel sellsServiceModel, ReturnedPalletsServiceModel returnedPalletsServiceModel, ReturnedPalletsService returnedPalletsService) {
        this.sellsService = sellsService;
        this.modelMapper = modelMapper;
        this.sellsServiceModel = sellsServiceModel;
        this.returnedPalletsServiceModel = returnedPalletsServiceModel;
        this.returnedPalletsService = returnedPalletsService;
    }


    @GetMapping("/sells")
    public String sell(Model model, HttpSession httpSession){

        if(!model.containsAttribute("sellBindingModel")){
            model.addAttribute("sellBindingModel", new SellBindingModel());
        }

        return "sell-eggs";
    }

    @PostMapping("/sells")
    public String addCartonConfirm(@Valid SellBindingModel sellBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("sellBindingModel", sellBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.sellBindingModel", sellBindingModel);

            return "redirect:sell-eggs";
        }
        System.out.println();

        sellsService.addSell(modelMapper.map(sellBindingModel, SellsServiceModel.class));


        return "redirect:confirm"; // TODO redirect to Yes or NO

    }

    @GetMapping("/returned-pallets")
    public String returnedPallets(Model model, HttpSession httpSession){

        if(!model.containsAttribute("returnedPalletsBindingModel")){
            model.addAttribute("returnedPalletsBindingModel", new ReturnedPalletsBindingModel());
        }

        return "returned-pallets";
    }

    @PostMapping("/returned-pallets")
    public String returnedPalletsConfirm(@Valid ReturnedPalletsBindingModel returnedPalletsBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("returnedPalletsBindingModel", returnedPalletsBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.returnedPalletsBindingModel", returnedPalletsBindingModel);

            return "redirect:returned-pallets";
        }

        returnedPalletsService.returnPallets(modelMapper.map(returnedPalletsBindingModel, ReturnedPalletsServiceModel.class));


        return "redirect:sells"; // TODO redirect to Yes or NO

    }


    @GetMapping("/validation")
    public String validation(){
        return "validation";
    }

    @GetMapping("/confirm")
    public String confirm(Model model, HttpSession httpSession){

        return "message-after-sell";
    }



    @GetMapping("/faktura")
    public String faktura(Model model){

        List<Sells> sells = sellsService.findLastSellsByDate(LocalDate.now());

        System.out.println();

        int sizeOfList = sells.size();

        Sells price = sells.get(sizeOfList - 1);

        System.out.println();

        double totalSum = ((price.getPrice() * price.getCountOfEgg()) * 20) / 100 + (price.getCountOfEgg() * price.getPrice());

        model.addAttribute("localDateTime", LocalDate.now());

        model.addAttribute("countOfInvoice", sizeOfList);

        model.addAttribute("currentClient", sells.get(sizeOfList -1 ));

        model.addAttribute("dds", ((price.getPrice() * price.getCountOfEgg()) * 20) / 100);

        model.addAttribute("sumWithoutDds", price.getCountOfEgg() * price.getPrice());

        model.addAttribute("TotalSumWithDds", totalSum);

        System.out.println();

        return "faktura";
    }

    @GetMapping("/all-sells")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("all-sells");
        return modelAndView;
    }

}
