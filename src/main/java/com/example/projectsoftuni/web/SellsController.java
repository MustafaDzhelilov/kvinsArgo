package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.binding.ExportBindingModel;
import com.example.projectsoftuni.model.binding.ReturnedPalletsBindingModel;
import com.example.projectsoftuni.model.binding.SellBindingModel;
import com.example.projectsoftuni.model.binding.SellFromPackagingBindingModel;
import com.example.projectsoftuni.model.entity.Sells;
import com.example.projectsoftuni.model.service.ExportServiceModel;
import com.example.projectsoftuni.model.service.ReturnedPalletsServiceModel;
import com.example.projectsoftuni.model.service.SellFromPackagingServiceModel;
import com.example.projectsoftuni.model.service.SellsServiceModel;
import com.example.projectsoftuni.service.ExportService;
import com.example.projectsoftuni.service.Impl.SellsServiceImpl;
import com.example.projectsoftuni.service.ReturnedPalletsService;
import com.example.projectsoftuni.service.SellFromPackagingService;
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
import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequestMapping("/egg")
public class SellsController {

    private final SellsService sellsService;
    private final ModelMapper modelMapper;
    private final SellsServiceModel sellsServiceModel;
    private final ReturnedPalletsServiceModel returnedPalletsServiceModel;
    private final ReturnedPalletsService returnedPalletsService;
    private final SellsServiceImpl sellsServiceImpl;
    private final ExportService exportService;
    private final SellFromPackagingService sellFromPackagingService;


    public SellsController(SellsService sellsService, ModelMapper modelMapper, SellsServiceModel sellsServiceModel, ReturnedPalletsServiceModel returnedPalletsServiceModel, ReturnedPalletsService returnedPalletsService, SellsServiceImpl sellsServiceImpl, ExportService exportService, SellFromPackagingService sellFromPackagingService) {
        this.sellsService = sellsService;
        this.modelMapper = modelMapper;
        this.sellsServiceModel = sellsServiceModel;
        this.returnedPalletsServiceModel = returnedPalletsServiceModel;
        this.returnedPalletsService = returnedPalletsService;
        this.sellsServiceImpl = sellsServiceImpl;
        this.exportService = exportService;
        this.sellFromPackagingService = sellFromPackagingService;
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

        String result = null;

       int halfCartonOrCorey = sellsService.getTrueDivideCountOfEgg();
        if(halfCartonOrCorey == 0) {
            sellsService.addSell(modelMapper.map(sellBindingModel, SellsServiceModel.class));
            int notOK = sellsService.getStatusNotOk();
            int notOKCartons = sellsService.getStatusNotOkCartons();

            if (notOK == 1) {
                result = "redirect:not_confirm";
            } else if (notOKCartons == 1) {
                result = "redirect:not_confirm_carton";
            } else {
                result = "redirect:confirm";
            }
        }else if(halfCartonOrCorey == 1){
           result = "redirect:not_confirm_divide";
        }

        return result;
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


        return "redirect:sells";

    }


    @GetMapping("/validation")
    public String validation(){
        return "validation";
    }

    @GetMapping("/confirm")
    public String confirm(){

        return "message-after-sell";
    }



    @GetMapping("/not_confirm")
    public String notConfirm(){

        return "message_after_sells_not_succses";
    }

    @GetMapping("/not_confirm_carton")
    public String notConfirmCartons(){

        return "message_after_sells_not_cartons";
    }

    @GetMapping("/not_confirm_divide")
    public String notConfirmDivide(){

        return "message_half_carton_or_corey_divide";
    }


    @GetMapping("/faktura")
    public String faktura(Model model){

      //  List<Sells> sells = sellsService.findLastSellsByDate(LocalDate.now());
        //int minute = 10;

        //List<Sells> test = sellsService.findSellsFromLastFiveMinutes(minute);



        List<Sells> allSells  =  sellsService.getAllSellsAboutToday();

        double totalSum = 0;

        for (int i = 0; i <= allSells.size() - 1; i++) {
            totalSum +=allSells.get(i).getTotalPrice();
        }

        model.addAttribute("allSells", allSells);
        model.addAttribute("totalSum", totalSum);


       // System.out.println();

       // model.addAttribute("test", test);

      // System.out.println();

      // int sizeOfList = sells.size();

      // Sells price = sells.get(sizeOfList - 1);

      // System.out.println();

      // double totalSum = ((price.getPrice() * price.getCountOfEgg()) * 20) / 100 + (price.getCountOfEgg() * price.getPrice());

      // model.addAttribute("localDateTime", LocalDate.now());

      // model.addAttribute("countOfInvoice", sizeOfList);

      // model.addAttribute("currentClient", sells.get(sizeOfList -1 ));

      // model.addAttribute("dds", ((price.getPrice() * price.getCountOfEgg()) * 20) / 100);

      // model.addAttribute("sumWithoutDds", price.getCountOfEgg() * price.getPrice());

      // model.addAttribute("TotalSumWithDds", totalSum);

      // System.out.println();

        return "view-sells-before-15-minutes";
    }

    @GetMapping("/all-sells")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("all-sells");
        return modelAndView;
    }

    @GetMapping("/export")
    public String export(Model model){

        if(!model.containsAttribute("exportBindingModel")){
            model.addAttribute("exportBindingModel", new ExportBindingModel());
        }

        return "exportEgg";
    }

    @PostMapping("/export")
    public String exportConfirm(@Valid ExportBindingModel exportBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("exportBindingModel", exportBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.exportBindingModel", exportBindingModel);

            return "redirect:export";
        }
        String res = null;
        exportService.add(modelMapper.map(exportBindingModel, ExportServiceModel.class));
        int typePaper = exportService.getStatusPaper();
        int typeCorner = exportService.getStatusCorner();
        int coreyNull = exportService.getStatusCoreyisNull();
        int cornerNull = exportService.getStatusCornerisNull();
        int paperNull = exportService.getStatusPaperisNull();
        int eggNoQuantity = exportService.getStatusEggNoQuantity();

        if(coreyNull == 1){
            res = "redirect:message-no-quantity-corey";
        }else if( cornerNull == 1){
            res = "redirect:message-no-quantity-corner";
        }else if(paperNull == 1){
            res = "redirect:message-no-quantity-paper";
        }else if(eggNoQuantity ==1){
            res = "redirect:message-no-quantity-egg";
        }else if(typePaper == 1) {
            res = "redirect:message-wrong-type-paper";
        }else if(typeCorner == 1){
            res = "redirect:message-wrong-type-corner";
        } else {
            res = "redirect:confirm";
        }

        return res;

    }


    @GetMapping("/sell-from-packaging")
    public String sellFromPackaging(Model model){

        if(!model.containsAttribute("sellFromPackagingBindingModel")){
            model.addAttribute("sellFromPackagingBindingModel", new SellFromPackagingBindingModel());
        }

        return "sell-from-packaging";
    }

    @PostMapping("/sell-from-packaging")
    public String sellFromPackagingConfirm(@Valid SellFromPackagingBindingModel sellFromPackagingBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("sellFromPackagingBindingModel", sellFromPackagingBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.sellFromPackagingBindingModel", sellFromPackagingBindingModel);

            return "redirect:sell-from-packaging";
        }
        String result= null;
        sellFromPackagingService.sell(modelMapper.map(sellFromPackagingBindingModel, SellFromPackagingServiceModel.class));
        int noQuantity = sellFromPackagingService.getStatusForQuantityEgg();

        if(noQuantity == 0){
            result = "redirect:not_confirm";
        }else{
            result = "redirect:confirm";
        }
        return result;

    }


    @GetMapping("/message-wrong-type-paper")
    public String wrongTypePaper(Model model){

        return "message-after-wrong-paper-sheet";
    }

    @GetMapping("/message-wrong-type-corner")
    public String wrongTypeCorner(Model model){

        return "message-after-wrong-paper-corner";
    }

    @GetMapping("/message-no-quantity-egg")
    public String noEgg(Model model){

        return "message-no-egg-for-sell";
    }

    @GetMapping("/message-no-quantity-corner")
    public String noCorner(Model model){

        return "message-no-corner-for-sell";
    }

    @GetMapping("/message-no-quantity-paper")
    public String noPaper(Model model){

        return "message-no-paper-for-sell";
    }

    @GetMapping("/message-no-quantity-corey")
    public String noCorey(Model model){

        return "message-no-corey-for-sell";
    }

}
