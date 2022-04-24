package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.binding.PalletsBindingModel;
import com.example.projectsoftuni.model.binding.TransferPalletsBetweenBaseBindingModel;
import com.example.projectsoftuni.model.entity.ReturnedPallets;
import com.example.projectsoftuni.model.entity.enums.*;
import com.example.projectsoftuni.model.service.PalletsServiceModel;
import com.example.projectsoftuni.model.service.ReturnedPalletsServiceModel;
import com.example.projectsoftuni.model.service.TransferPalletsBetweenBaseServiceModel;
import com.example.projectsoftuni.service.*;
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
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pallets-count")
public class PalletsCountController {

    private final ReturnedPalletsService returnedPalletsService;
    private final SellsService sellsService;
    private final SellFromPackagingService sellFromPackagingService;
    private final ModelMapper modelMapper;
    private final ReturnedPalletsServiceModel returnedPalletsServiceModel;
    private final ExportService exportService;
    private final PalletsService palletsService;
    List<ReturnedPallets> countEuro = new ArrayList<>();

    public PalletsCountController(ReturnedPalletsService returnedPalletsService, SellsService sellsService, SellFromPackagingService sellFromPackagingService, ModelMapper modelMapper, ReturnedPalletsServiceModel returnedPalletsServiceModel, ExportService exportService, PalletsService palletsService) {
        this.returnedPalletsService = returnedPalletsService;
        this.sellsService = sellsService;
        this.sellFromPackagingService = sellFromPackagingService;
        this.modelMapper = modelMapper;
        this.returnedPalletsServiceModel = returnedPalletsServiceModel;
        this.exportService = exportService;
        this.palletsService = palletsService;
    }

    @GetMapping("/now")
    public String pallets(Model model){

        countEuro.clear();

            int count = -1;
        for (ClientEnum client : ClientEnum.values()) {
                count++;

                Long sumEuro = returnedPalletsService.getReturnedEuroByClient(client, PalletTypeEnum.EURO);
                Long sumIssuedEuroSell = sellsService.getReturnedEUroByClient(client, PalletTypeEnum.EURO);
                Long sumIssuedEuroExport = exportService.getReturnedEuroByClient(client,PalletTypeEnum.EURO);
                Long sumIssuedEuroFromPack = sellFromPackagingService.getReturnedEuroByCLient(client, PalletTypeEnum.EURO);
                Long totalEuro = sumEuro - (sumIssuedEuroSell + sumIssuedEuroFromPack + sumIssuedEuroExport);

                Long sumThermo = returnedPalletsService.getReturnedPallThermoByClient(client, PalletTypeEnum.THERMO);
                Long sumIssuesThermoSell = sellsService.getReturnedPallThermoByClient(client, PalletTypeEnum.THERMO);
                Long sumIssuesThermoExport = exportService.getReturnedPallThermoByClient(client, PalletTypeEnum.THERMO);
                Long sumIssuesThermoFromPack = sellFromPackagingService.getReturnedPallThermoByClient(client, PalletTypeEnum.THERMO);
                Long totalThermo = sumThermo - (sumIssuesThermoSell + sumIssuesThermoExport + sumIssuesThermoFromPack);


            ReturnedPallets returnedPallets = modelMapper.map(returnedPalletsServiceModel, ReturnedPallets.class);
            ReturnedPallets returnedPalletsThermo = modelMapper.map(returnedPalletsServiceModel, ReturnedPallets.class);
            returnedPalletsThermo.setClientEnum(client);
            returnedPallets.setClientEnum(client);
            returnedPallets.setPalletTypeEnum(PalletTypeEnum.EURO);
            returnedPalletsThermo.setPalletTypeEnum(PalletTypeEnum.THERMO);
            returnedPallets.setReturnedDate(LocalDate.now());
            returnedPalletsThermo.setReturnedDate(LocalDate.now());
            returnedPallets.setCountReturned(totalEuro);
            returnedPalletsThermo.setCountReturned(totalThermo);
            countEuro.add(count,returnedPallets);
            countEuro.add(count, returnedPalletsThermo);
            }

        model.addAttribute("test", countEuro);


        return "pallets-count";
    }

    @GetMapping("/add")
    public String add(Model model){
        if(!model.containsAttribute("palletsBindingModel")){
            model.addAttribute("palletsBindingModel", new PalletsBindingModel());
        }
        return "pallets-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid PalletsBindingModel palletsBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("palletsBindingModel", palletsBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.palletsBindingModel", bindingResult);

            return "redirect:add";
        }

        palletsService.add(modelMapper.map(palletsBindingModel, PalletsServiceModel.class));

        return "redirect:/home";
    }

    @GetMapping("/transfer")
    public String transfer(Model model){
        if(!model.containsAttribute("transferPalletsBetweenBaseBindingModel")){
            model.addAttribute("transferPalletsBetweenBaseBindingModel", new TransferPalletsBetweenBaseBindingModel());
        }
        return "transfer-pallets-between-base";
    }

    @PostMapping("/transfer")
    public String transferConfirm(@Valid TransferPalletsBetweenBaseBindingModel transferPalletsBetweenBaseBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("transferPalletsBetweenBaseBindingModel", transferPalletsBetweenBaseBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.transferPalletsBetweenBaseBindingModel", bindingResult);

            return "redirect:add";
        }

        palletsService.transfer(modelMapper.map(transferPalletsBetweenBaseBindingModel, TransferPalletsBetweenBaseServiceModel.class));

        return "redirect:/home";
    }

    @GetMapping("/totalCount")
    public String totalCount(Model model){

        Long countEuroLower = palletsService.getCOuntEuroLower();
        Long countThermoLower = palletsService.getCountThermoLower();
        Long countEuroUpper =  palletsService.getCountEuroUpper();
        Long countThermoUpper = palletsService.getCountThermoUpper();
        Long countEuroPackaging = palletsService.getCountEuroPackaging();
        Long countThermoPackaging = palletsService.getCountThermoPackaging();

        model.addAttribute("countEuroLower", countEuroLower);
        model.addAttribute("countThermoLower", countThermoLower);
        model.addAttribute("countEuroUpper", countEuroUpper);
        model.addAttribute("countThermoUpper", countThermoUpper);
        model.addAttribute("countEuroPackaging", countEuroPackaging);
        model.addAttribute("countThermoPackaging", countThermoPackaging);

        return "total-pallets-count";
    }

}
