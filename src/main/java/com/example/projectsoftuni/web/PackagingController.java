package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.binding.CartonsForPacagingBindingModel;
import com.example.projectsoftuni.model.binding.CoreyFreeAfterPackagingBindingModel;
import com.example.projectsoftuni.model.binding.PackagingBindingModel;
import com.example.projectsoftuni.model.binding.ProductAfterPackakingBindingModel;
import com.example.projectsoftuni.model.entity.CoreyFreeAfterPackaging;
import com.example.projectsoftuni.model.entity.PackingProduct;
import com.example.projectsoftuni.model.entity.SellFromPackaging;
import com.example.projectsoftuni.model.service.*;
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
import java.util.List;

@Controller
@RequestMapping("/packing")
public class PackagingController {

    private final PackagingService packagingService;
    private final ModelMapper modelMapper;
    private final PackagingServiceModel packagingServiceModel;
    private final ProductAfterPackagingService productAfterPackagingService;
    private final ProductAfterPackagingServiceModel productAfterPackagingServiceModel;
    private final CartonsForPackagingService cartonsForPackagingService;
    private final CoreyAfterPackagingService coreyAfterPackagingService;
    private final  CoreyFreeAfterPackagingServiceModel coreyFreeAfterPackagingServiceModel;
    private final SellFromPackagingService sellFromPackagingService;
    String result = null;

    public PackagingController(PackagingService packagingService, ModelMapper modelMapper, PackagingServiceModel packagingServiceModel, ProductAfterPackagingService productAfterPackagingService, ProductAfterPackagingServiceModel productAfterPackagingServiceModel, CartonsForPackagingService cartonsForPackagingService, CoreyAfterPackagingService coreyAfterPackagingService, CoreyFreeAfterPackagingServiceModel coreyFreeAfterPackagingServiceModel, SellFromPackagingService sellFromPackagingService) {
        this.packagingService = packagingService;
        this.modelMapper = modelMapper;
        this.packagingServiceModel = packagingServiceModel;
        this.productAfterPackagingService = productAfterPackagingService;
        this.productAfterPackagingServiceModel = productAfterPackagingServiceModel;
        this.cartonsForPackagingService = cartonsForPackagingService;
        this.coreyAfterPackagingService = coreyAfterPackagingService;
        this.coreyFreeAfterPackagingServiceModel = coreyFreeAfterPackagingServiceModel;
        this.sellFromPackagingService = sellFromPackagingService;
    }

    @GetMapping("/add")
    public String addEgg(Model model) {

        if (!model.containsAttribute("packagingBindingModel")) {
            model.addAttribute("packagingBindingModel", new PackagingBindingModel());
        }

        return "packaging";
    }

    @PostMapping("/add")
    public String addEggConfirm(@Valid PackagingBindingModel packagingBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("packagingBindingModel", packagingBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.packagingBindingModel", packagingBindingModel);

            return "redirect:add";
        }

        packagingService.add(modelMapper.map(packagingBindingModel, PackagingServiceModel.class));
        int notOK = packagingService.getStatusNotOk();

        if (notOK == 1) {
            result = "redirect:message-no-egg-for-transfer";
        }else{
            result = "redirect:/home";
        }

        return result;
    }

    @GetMapping("/count-egg-before-packing")
    public String viewEggBefore(Model model) {

        model.addAttribute("XLCore", packagingService.getXLCoreCount());

        model.addAttribute("LCartonFamily", packagingService.getLFamilyCartonCount());
        model.addAttribute("LCartonChez", packagingService.getLChezCartonCount());
        model.addAttribute("LCartonHartman", packagingService.getLHartmanCartonCount());
        model.addAttribute("LCartonEuro", packagingService.getLEuroCartonCount());

        model.addAttribute("MCartonFamily", packagingService.getMFamilyCartonCount());
        model.addAttribute("MCartonChez", packagingService.getMChezCartonCount());
        model.addAttribute("MCartonHartman", packagingService.getMHartmanCartonCount());
        model.addAttribute("MCartonEuro", packagingService.getMEuroCartonCount());

        model.addAttribute("SCartonFamily", packagingService.getSFamilyCartonCount());
        model.addAttribute("SCartonChez", packagingService.getSChezCartonCount());
        model.addAttribute("SCartonHartman", packagingService.getSHartmanCartonCount());
        model.addAttribute("SCartonEuro", packagingService.getSEuroCartonCount());


        return "before-packing-count-egg";
    }

    @GetMapping("/create-new-product")
    public String createNewProduct(Model model) {

        if (!model.containsAttribute("productAfterPackakingBindingModel")) {
            model.addAttribute("productAfterPackakingBindingModel", new ProductAfterPackakingBindingModel());
        }

        return "packaging-new-product";
    }

    @PostMapping("/create-new-product")
    public String createNewProductConfirm(@Valid ProductAfterPackakingBindingModel productAfterPackakingBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productAfterPackakingBindingModel", productAfterPackakingBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productAfterPackakingBindingModel", productAfterPackakingBindingModel);

            return "redirect:create-new-product";
        }
        String result = null;
        productAfterPackagingService.add(modelMapper.map(productAfterPackakingBindingModel, ProductAfterPackagingServiceModel.class));
        int notOkEgg = productAfterPackagingService.getStatusEggNotOk();
        int notOK = productAfterPackagingService.getStatusNotOk();

        if(notOkEgg == 1) {
            result = "redirect:message-no-egg";
        } else if (notOK == 1) {
            result = "redirect:message-no-boxes";
            } else{
            result = "redirect:/home";
            }

        return result;
    }

    @GetMapping("/history")
    public String history(Model model) {

        List<PackingProduct> allPackingProduct = productAfterPackagingService.getAll();

        model.addAttribute("packingList", allPackingProduct);

        return "history";
    }

    @GetMapping("/count-egg-after-packing")
    public String viewEggAfter(Model model) {

        model.addAttribute("BOX_6XL", productAfterPackagingService.getXLbox_6());
        model.addAttribute("BOX_10XL", productAfterPackagingService.getXLbox_10());
        model.addAttribute("BOX_12XL", productAfterPackagingService.getXLbox_12());
        model.addAttribute("BOX_6L", productAfterPackagingService.getLbox_6());
        model.addAttribute("BOX_10L", productAfterPackagingService.getLbox_10());
        model.addAttribute("BOX_12L", productAfterPackagingService.getLbox_12());
        model.addAttribute("BOX_6M", productAfterPackagingService.getMbox_6());
        model.addAttribute("BOX_10M", productAfterPackagingService.getMbox_10());
        model.addAttribute("BOX_12M", productAfterPackagingService.getMbox_12());
        model.addAttribute("BOX_6S", productAfterPackagingService.getSbox_6());
        model.addAttribute("BOX_10S", productAfterPackagingService.getSbox_10());
        model.addAttribute("BOX_12S", productAfterPackagingService.getSbox_12());

        model.addAttribute("BOX_15L", productAfterPackagingService.getLBox15());
        model.addAttribute("BOX_30L", productAfterPackagingService.getLBox30());
        model.addAttribute("BOX_15M", productAfterPackagingService.getMbox_15());
        model.addAttribute("BOX_30M", productAfterPackagingService.getMbox_30());
        model.addAttribute("BOX_15S", productAfterPackagingService.getSbox_15());
        model.addAttribute("BOX_30S", productAfterPackagingService.getSbox_30());

        return "after-packing-count-egg";
    }

    @GetMapping("/add-cartons-for-packaging")
    public String addPackagingCarton(Model model) {

        if (!model.containsAttribute("cartonsForPacagingBindingModel")) {
            model.addAttribute("cartonsForPacagingBindingModel", new CartonsForPacagingBindingModel());
        }

        return "add-carton-packaging";
    }

    @PostMapping("/add-cartons-for-packaging")
    public String addPackagingCartonConfirm(@Valid CartonsForPacagingBindingModel cartonsForPacagingBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("cartonsForPacagingBindingModel", cartonsForPacagingBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.cartonsForPacagingBindingModel", cartonsForPacagingBindingModel);

            return "redirect:add-carton-packaging";
        }

        cartonsForPackagingService.addCartons(modelMapper.map(cartonsForPacagingBindingModel, CartonsForPackagingServiceModel.class));

        return "/home";
    }

    @GetMapping("/transfer-carton-to-base")
    public String transferCartonToBase(Model model) {

        if (!model.containsAttribute("coreyFreeAfterPackagingBindingModel")) {
            model.addAttribute("coreyFreeAfterPackagingBindingModel", new CoreyFreeAfterPackagingBindingModel());
        }

        return "transfer-free-cartons-to-base";
    }

    @PostMapping("/transfer-carton-to-base")
    public String transferCartonToBase(@Valid CoreyFreeAfterPackagingBindingModel coreyFreeAfterPackagingBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("coreyFreeAfterPackagingBindingModel", coreyFreeAfterPackagingBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.coreyFreeAfterPackagingBindingModel", coreyFreeAfterPackagingBindingModel);

            return "redirect:transfer-free-cartons-to-base";
        }
        System.out.println();
        String result = null;
        Long countCoreyToTransfer = coreyAfterPackagingService.getCartonsCountToTransfer(coreyFreeAfterPackagingServiceModel.getCartons());
        Long countTransferCount = coreyAfterPackagingService.getCount(modelMapper.map(coreyFreeAfterPackagingBindingModel, CoreyFreeAfterPackagingServiceModel.class));

        if(countTransferCount > countCoreyToTransfer){
            result = "redirect:message-no-corey-to-transfer";
        }else{
            coreyAfterPackagingService.transferCartonToBase(modelMapper.map(coreyFreeAfterPackagingBindingModel, CoreyFreeAfterPackagingServiceModel.class));
            result = "/home";
        }

        return result;
    }

    @GetMapping("/count-cartons-for-transfer")
    public String cartonsFroTransfer(Model model) {


        List<CoreyFreeAfterPackaging> toTransferCount = coreyAfterPackagingService.getAllCartons();

        model.addAttribute("cartons", toTransferCount);


        return "cartons-for-transfer-to-base";
    }

    @GetMapping("/count-carton-packing")
    public String countCartonInPacking(Model model) {

        model.addAttribute("box_6",  cartonsForPackagingService.getPackagingCartonsEnumBox6());
        model.addAttribute("box_10",  cartonsForPackagingService.getPackagingCartonsEnumBox10());
        model.addAttribute("box_12",  cartonsForPackagingService.getPackagingCartonsEnumBox12());
        model.addAttribute("cover_15",  cartonsForPackagingService.getPackagingCartonsEnumCover15());
        model.addAttribute("cover_30",  cartonsForPackagingService.getPackagingCartonsEnumCover30());


        return "packing-cartons-now";
    }

    @GetMapping("/message-no-boxes")
    public String messageNoBoxes(Model model) {

        return "message-no-boxes";
    }

    @GetMapping("/message-no-egg")
    public String messageNoEgg(Model model) {

        return "message-no-egg";
    }

    @GetMapping("/message-no-corey-to-transfer")
    public String messageFreeCorey(Model model) {

        return "message-not-free-corey-after-packing";
    }

    @GetMapping("/message-no-egg-for-transfer")
    public String noEggForTransfer(Model model) {

        return "message-no-egg-for-transfer";
    }

    @GetMapping("/sell-from-packaging-view")
    public String sellFromPackagingView(Model model){

        List<SellFromPackaging> sellFromPackaging = sellFromPackagingService.getAllSellsFromPackaging();
        model.addAttribute("sellsFromPackaging", sellFromPackaging);

        return "sell-from-packaging-view";
    }

}
