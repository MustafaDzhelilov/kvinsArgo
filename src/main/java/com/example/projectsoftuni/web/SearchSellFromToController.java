package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.binding.SearchSellFromTo;
import com.example.projectsoftuni.model.service.SearchSellFromToServiceModel;
import com.example.projectsoftuni.service.SellsService;
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
@RequestMapping("/search")
public class SearchSellFromToController {

    private final ModelMapper modelMapper;
    private final SellsService sellsService;
    Long count;
    String category;

    public SearchSellFromToController(ModelMapper modelMapper, SellsService sellsService) {
        this.modelMapper = modelMapper;
        this.sellsService = sellsService;
    }

    @GetMapping("/sell")
    public String sell(Model model){

        if(!model.containsAttribute("searchSellFromTo")){
            model.addAttribute("searchSellFromTo", new SearchSellFromTo());
        }

        return "search-sell";
    }

    @PostMapping("/sell")
    public String addCartonConfirm(@Valid SearchSellFromTo searchSellFromTo, BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("searchSellFromTo", searchSellFromTo);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.searchSellFromTo", searchSellFromTo);

            return "redirect:search-sell";
        }

        count = sellsService.fromTo(modelMapper.map(searchSellFromTo, SearchSellFromToServiceModel.class));


        return "redirect:sell-view";
    }

    @GetMapping("/sell-view")
    public String sellView(Model model){

       model.addAttribute("countFromTo", count);

        return "count-sell-view";
    }
}
