package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.binding.SearchSellFromTo;
import com.example.projectsoftuni.model.binding.SearchSellFromToWithClient;
import com.example.projectsoftuni.model.binding.SearchSellTottalPriceByClientBindingModel;
import com.example.projectsoftuni.model.entity.Sells;
import com.example.projectsoftuni.model.entity.enums.*;
import com.example.projectsoftuni.model.service.SearchSellFromToServiceModel;
import com.example.projectsoftuni.model.service.SearchSellFromToWithClientServiceModel;
import com.example.projectsoftuni.model.service.SearchSellTotalPriceByClientServiceModel;
import com.example.projectsoftuni.model.service.SellsServiceModel;
import com.example.projectsoftuni.model.view.SearchFromToViewModel;
import com.example.projectsoftuni.model.view.SellsViewModel;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchSellFromToController {

    private final ModelMapper modelMapper;
    private final SellsService sellsService;
    private final SearchFromToViewModel searchFromToViewModel;
    private final SellsServiceModel sellsServiceModel;
    Long count;
    String clientName;
    List<SellsViewModel> search;
    String categoryName;
    Long countXL;
    Long countL;
    Long countM;
    Long countS;
    Long countBroken;
    String from;
    String to;
    List<Sells> allSells ;
    List<Sells> allS = new ArrayList<>();

    public SearchSellFromToController(ModelMapper modelMapper, SellsService sellsService, SearchFromToViewModel searchFromToViewModel, SellsServiceModel sellsServiceModel) {
        this.modelMapper = modelMapper;
        this.sellsService = sellsService;
        this.searchFromToViewModel = searchFromToViewModel;
        this.sellsServiceModel = sellsServiceModel;
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

        from = searchSellFromTo.getStart().toString();
        to = searchSellFromTo.getEnd().toString();
        categoryName = searchSellFromTo.getCategoryEggEnum().name();
        count = sellsService.fromTo(modelMapper.map(searchSellFromTo, SearchSellFromToServiceModel.class));
        search = sellsService.getAllSells();  //  за всички продажби, като не ги събира в едно а както се е осъществила продажбата.


        return "redirect:sell-view";
    }

    //Общата бройка за тази категория за избрания период
    @GetMapping("/sell-view")
    public String sellView(Model model){

       model.addAttribute("countFromTo", count);
       model.addAttribute("categoryName", categoryName);
       model.addAttribute("from", from);
       model.addAttribute("to", to);

        return "count-sell-view";
    }




    @GetMapping("/sell-view-with-client")
    public String sellViewClient(Model model){

        if(!model.containsAttribute("searchSellFromToWithClient")){
            model.addAttribute("searchSellFromToWithClient", new SearchSellFromToWithClient());
        }

        return "search-sell-with-client";
    }

    @PostMapping("/sell-view-with-client")
    public String sellViewClientConfirm(@Valid SearchSellFromToWithClient searchSellFromToWithClient, BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("searchSellFromToWithClient", searchSellFromToWithClient);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.searchSellFromToWithClient", searchSellFromToWithClient);

            return "redirect:search-sell-with-client";
        }

        clientName = searchSellFromToWithClient.getClientEnum().name();

        countXL = sellsService.fromToForCountXL(modelMapper.map(searchSellFromToWithClient, SearchSellFromToWithClientServiceModel.class));
        countL = sellsService.fromToForCountL(modelMapper.map(searchSellFromToWithClient, SearchSellFromToWithClientServiceModel.class));
        countM = sellsService.fromToForCountM(modelMapper.map(searchSellFromToWithClient, SearchSellFromToWithClientServiceModel.class));
        countS = sellsService.fromToForCountS(modelMapper.map(searchSellFromToWithClient, SearchSellFromToWithClientServiceModel.class));
        countBroken = sellsService.fromToForCountBroken(modelMapper.map(searchSellFromToWithClient, SearchSellFromToWithClientServiceModel.class));

        return "redirect:sell-view-client";
    }

    @GetMapping("/sell-view-client")
    public String sellClientView(Model model){

        model.addAttribute("clientName", clientName);
        model.addAttribute("countXL", countXL);
        model.addAttribute("countL", countL);
        model.addAttribute("countM", countM);
        model.addAttribute("countS", countS);
        model.addAttribute("countBroken", countBroken);


        return "count-sell-view-with-client";
    }


    @GetMapping("/total-price")
    public String totalPriceByClient(Model model){

        if(!model.containsAttribute("searchSellTottalPriceByClientBindingModel")){
            model.addAttribute("searchSellTottalPriceByClientBindingModel", new SearchSellTottalPriceByClientBindingModel());
        }

        return "search-price-by-client";
    }

    @PostMapping("/total-price")
    public String totalPriceByClientConfirm(@Valid SearchSellTottalPriceByClientBindingModel searchSellTottalPriceByClientBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("searchSellTottalPriceByClientBindingModel", searchSellTottalPriceByClientBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.searchSellTottalPriceByClientBindingModel", searchSellTottalPriceByClientBindingModel);

            return "redirect:search-price-by-client";
        }
           allSells = sellsService.getAllFromTo(modelMapper.map(searchSellTottalPriceByClientBindingModel, SearchSellTotalPriceByClientServiceModel.class));

        double sum= 0;
        int i;


        for (ClientEnum client : ClientEnum.values()) {
            sum = 0;
            for (i=0; i<=allSells.size()- 1; i++){
                if(allSells.get(i).getClientEnum().name().equals(client.name())){
                    sum += allSells.get(i).getTotalPrice();
                }
            }
            Sells sells = modelMapper.map(sellsServiceModel, Sells.class);
            sells.setPrice(0.2);
            sells.setAddDate(LocalDateTime.now());
            sells.setCountIssuedPallets(1L);
            sells.setCountOfEgg(1L);
            sells.setEgg(CategoryEggEnum.L);
            sells.setBase(CategoryBaseEnum.LOWER);
            sells.setClientEnum(client);
            sells.setCartons(CategoryCartonsEnum.CARTONS_180_WHITE);
            sells.setPalletTypeEnum(PalletTypeEnum.THERMO);
            sells.setTotalPrice(sum);
            allS.add(sells);
        }

        return "redirect:view-total-price-by-client";
    }

    @GetMapping("/view-total-price-by-client")
    public String totalPriceView(Model model){

        model.addAttribute("allS", allS);

        return "total-price-view";
    }
}
