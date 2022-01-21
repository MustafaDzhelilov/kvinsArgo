package com.example.projectsoftuni.web;

import com.example.projectsoftuni.service.ReturnedPalletsService;
import com.example.projectsoftuni.service.SellsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pallets-count")
public class PalletsCountController {

    private final ReturnedPalletsService returnedPalletsService;
    private final SellsService sellsService;

    public PalletsCountController(ReturnedPalletsService returnedPalletsService, SellsService sellsService) {
        this.returnedPalletsService = returnedPalletsService;
        this.sellsService = sellsService;
    }

    @GetMapping("/now")
    public String pallets(Model model){

        //akvilon
        Long returnedPallEuro = returnedPalletsService.getReturnedPallCount();
        Long issuedPallEuro = sellsService.getIssuedPallCount();
        Long diffAkvilonEuro = returnedPallEuro - issuedPallEuro;
        model.addAttribute("countAkv", diffAkvilonEuro);

        Long returnedPallTermo = returnedPalletsService.getReturnedPallCountAkvTermo();
        Long issuedPallTermo = sellsService.getIssuedPallCountAkvTermo();
        Long diffAkvilonTermo = returnedPallTermo - issuedPallTermo;
        model.addAttribute("countAkvThermo", diffAkvilonTermo);

        //teodor
        Long returnedPallTEuro = returnedPalletsService.getReturnedPallCountT();
        Long issPallEuro = sellsService.getIssuedPallCountT();
        Long diffTeodorEuro = returnedPallTEuro - issPallEuro;
        model.addAttribute("countTeod", diffTeodorEuro);

        Long returnedPallTTermo = returnedPalletsService.getReturnedPallCountTTermo();
        Long issPallTermo = sellsService.getIssuedPallCountTTermo();
        Long diffTeodorTermo = returnedPallTTermo - issPallTermo;
        model.addAttribute("countTeodTermo", diffTeodorTermo);

        return "pallets-count";
    }
}
