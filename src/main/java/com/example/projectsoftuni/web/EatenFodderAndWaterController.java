package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.binding.EatenFodderBindingModel;
import com.example.projectsoftuni.model.service.EatenFodderAndWaterServiceModel;
import com.example.projectsoftuni.service.EatenFodderAndWaterService;
import com.example.projectsoftuni.service.FodderService;
import com.example.projectsoftuni.service.HensAddService;
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
import java.text.DecimalFormat;
import java.time.LocalDate;

@Controller
@RequestMapping("/eaten")
public class EatenFodderAndWaterController {

    private final EatenFodderAndWaterService eatenFodderAndWaterService;
    private final ModelMapper modelMapper;
    private final EatenFodderAndWaterServiceModel eatenFodderAndWaterServiceModel;
    private final FodderService fodderService;
    private final HensAddService hensAddService;

    public EatenFodderAndWaterController(EatenFodderAndWaterService eatenFodderAndWaterService, ModelMapper modelMapper, EatenFodderAndWaterServiceModel eatenFodderAndWaterServiceModel, FodderService fodderService, HensAddService hensAddService) {
        this.eatenFodderAndWaterService = eatenFodderAndWaterService;
        this.modelMapper = modelMapper;
        this.eatenFodderAndWaterServiceModel = eatenFodderAndWaterServiceModel;
        this.fodderService = fodderService;
        this.hensAddService = hensAddService;
    }
    // За достъп до таблица Справка за консумация на фураж и вода за деня Долна база
    @GetMapping("/reference-consuming-lower")
    public String viewLower(Model model, HttpSession httpSession){

        // За текущия ден Хале 1 Силоз 1
        Long lastDayEatenFodder = eatenFodderAndWaterService.findLastRecordsByCategory();
        Long countHensOfCurrentDay = hensAddService.getCountOfHnesFirstLast();
        Long currentDayKgOfFodder = fodderService.getKgOfFodder();
        Long currentDayLitreOfWater = eatenFodderAndWaterService.getLitreOfWater();

        float percentCurrentDay = (lastDayEatenFodder / (countHensOfCurrentDay * 1.0f));
        float percentCurrentDayWater = (currentDayLitreOfWater / (countHensOfCurrentDay * 1.0f));

        model.addAttribute("currentDay", LocalDate.now());
        model.addAttribute("currentDayKgOfFodder", currentDayKgOfFodder);
        model.addAttribute("percentCurrentDay"
                , String.format("%.4f" + " гр.",percentCurrentDay));
        model.addAttribute("percentCurrentDayWater"
                , String.format("%.4f" + " мл.", percentCurrentDayWater));

        // За текущия ден Хале 2 Силоз 2
        Long lastDayEatenFodderHale2 = eatenFodderAndWaterService.findLastRecordsByCategoryHale2();
        Long countHensOfCurrentDayHale2 = hensAddService.getCountOfHensSecondLast();
        Long currentDayKgOfFodderHale2 = fodderService.getKgOfFodderSilo2();
        Long currentDayLitreOfWaterHale2 = eatenFodderAndWaterService.getLitreOfWaterHale2();

        float percentCurrentDayHale2 = (lastDayEatenFodderHale2 / (countHensOfCurrentDayHale2 * 1.0f));
        float percentCurrentDayWaterHale2 = (currentDayLitreOfWaterHale2 / (countHensOfCurrentDayHale2 * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale2", currentDayKgOfFodderHale2);
        model.addAttribute("percentCurrentDayHale2"
                , String.format("%.4f" + " гр.",percentCurrentDayHale2));
        model.addAttribute("percentCurrentDayWaterHale2"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale2));

        // За текущия ден Хале 3 Силоз 3
        Long lastDayEatenFodderHale3 = eatenFodderAndWaterService.findLastRecordsByCategoryHale3();
        Long countHensOfCurrentDayHale3 = hensAddService.getCountOfHensThirdLast();
        Long currentDayKgOfFodderHale3 = fodderService.getKgOfFodderSilo3();
        Long currentDayLitreOfWaterHale3 = eatenFodderAndWaterService.getLitreOfWaterHale3();

        float percentCurrentDayHale3 = (lastDayEatenFodderHale3 / (countHensOfCurrentDayHale3 * 1.0f));
        float percentCurrentDayWaterHale3 = (currentDayLitreOfWaterHale3 / (countHensOfCurrentDayHale3 * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale3", currentDayKgOfFodderHale3);
        model.addAttribute("percentCurrentDayHale3"
                , String.format("%.4f" + " гр.",percentCurrentDayHale3));
        model.addAttribute("percentCurrentDayWaterHale3"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale3));

        // За текущия ден Хале 4 Силоз 4
        Long lastDayEatenFodderHale4 = eatenFodderAndWaterService.findLastRecordsByCategoryHale4();
        Long countHensOfCurrentDayHale4 = hensAddService.getCountOfHensFourthLast();
        Long currentDayKgOfFodderHale4 = fodderService.getKgOfFodderSilo4();
        Long currentDayLitreOfWaterHale4 = eatenFodderAndWaterService.getLitreOfWaterHale4();

        float percentCurrentDayHale4 = (lastDayEatenFodderHale4 / (countHensOfCurrentDayHale4 * 1.0f));
        float percentCurrentDayWaterHale4 = (currentDayLitreOfWaterHale4 / (countHensOfCurrentDayHale4 * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale4", currentDayKgOfFodderHale4);
        model.addAttribute("percentCurrentDayHale4"
                , String.format("%.4f" + " гр.",percentCurrentDayHale4));
        model.addAttribute("percentCurrentDayWaterHale4"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale4));

        // За текущия - 1 ден Хале 1 Силоз 1
        Long eatenFodderCurrentDayMinOneDay = eatenFodderAndWaterService.findLastRecordsByCategoryHale1MinOne();
        Long countHensOfCurrentDayMinOne = hensAddService.getCountOfHensFirstAboutCurrentDayMinusOne();
        Long currentDayKgOfFodderMinOne = fodderService.getKgOfFodderMinOne();
        Long currentDayLitreOfWaterMinOne = eatenFodderAndWaterService.getLitreOfWaterMinOne();

        float percentCurrentDayMinOne = (eatenFodderCurrentDayMinOneDay / (countHensOfCurrentDayMinOne * 1.0f));
        float percentCurrentDayWaterMinOne = (currentDayLitreOfWaterMinOne / (countHensOfCurrentDayMinOne * 1.0f));

        model.addAttribute("currentDayMinOne", LocalDate.now().minusDays(1));
        model.addAttribute("currentDayKgOfFodderMinOne", currentDayKgOfFodderMinOne);
        model.addAttribute("percentCurrentDayMinOne"
                , String.format("%.4f" + " гр.",percentCurrentDayMinOne));
        model.addAttribute("percentCurrentDayWaterMinOne"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterMinOne));

        // За текущия -1 ден Хале 2 Силоз 2
        Long lastDayEatenFodderHale2MinOne = eatenFodderAndWaterService.findLastRecordsByCategoryHale2MinOne();
        Long countHensOfCurrentDayHale2MinOne = hensAddService.getCountOfHensSecondAboutCurrentDayMinusOne();
        Long currentDayKgOfFodderHale2MinOne = fodderService.getKgOfFodderSilo2MinOne();
        Long currentDayLitreOfWaterHale2MinOne = eatenFodderAndWaterService.getLitreOfWaterHale2MinOne();

        float percentCurrentDayHale2MinOne = (lastDayEatenFodderHale2MinOne / (countHensOfCurrentDayHale2MinOne * 1.0f));
        float percentCurrentDayWaterHale2MinOne = (currentDayLitreOfWaterHale2MinOne / (countHensOfCurrentDayHale2MinOne * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale2MinOne", currentDayKgOfFodderHale2MinOne);
        model.addAttribute("percentCurrentDayHale2MinOne"
                , String.format("%.4f" + " гр.",percentCurrentDayHale2MinOne));
        model.addAttribute("percentCurrentDayWaterHale2MinOne"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale2MinOne));

        // За текущия -1 ден Хале 3 Силоз 3
        Long lastDayEatenFodderHale3MinOne = eatenFodderAndWaterService.findLastRecordsByCategoryHale3MinOne();
        Long countHensOfCurrentDayHale3MinOne = hensAddService.getCountOfHensThirdAboutCurrentDayMinusOne();
        Long currentDayKgOfFodderHale3MinOne = fodderService.getKgOfFodderSilo3MinOne();
        Long currentDayLitreOfWaterHale3MinOne = eatenFodderAndWaterService.getLitreOfWaterHale3MinOne();

        float percentCurrentDayHale3MinOne = (lastDayEatenFodderHale3MinOne / (countHensOfCurrentDayHale3MinOne * 1.0f));
        float percentCurrentDayWaterHale3MinOne = (currentDayLitreOfWaterHale3MinOne / (countHensOfCurrentDayHale3MinOne * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale3MinOne", currentDayKgOfFodderHale3MinOne);
        model.addAttribute("percentCurrentDayHale3MinOne"
                , String.format("%.4f" + " гр.",percentCurrentDayHale3MinOne));
        model.addAttribute("percentCurrentDayWaterHale3MinOne"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale3MinOne));

        // За текущия -1 ден Хале 4 Силоз 4
        Long lastDayEatenFodderHale4MinOne = eatenFodderAndWaterService.findLastRecordsByCategoryHale4MinOne();
        Long countHensOfCurrentDayHale4MinOne = hensAddService.getCountOfHensFourthAboutCurrentDayMinusOne();
        Long currentDayKgOfFodderHale4MinOne = fodderService.getKgOfFodderSilo4MinOne();
        Long currentDayLitreOfWaterHale4MinOne = eatenFodderAndWaterService.getLitreOfWaterHale4MinOne();

        float percentCurrentDayHale4MinOne = (lastDayEatenFodderHale4MinOne / (countHensOfCurrentDayHale4MinOne * 1.0f));
        float percentCurrentDayWaterHale4MinOne = (currentDayLitreOfWaterHale4MinOne / (countHensOfCurrentDayHale4MinOne * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale4MinOne", currentDayKgOfFodderHale4MinOne);
        model.addAttribute("percentCurrentDayHale4MinOne"
                , String.format("%.4f" + " гр.",percentCurrentDayHale4MinOne));
        model.addAttribute("percentCurrentDayWaterHale4MinOne"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale4MinOne));

        // За текущия - 2 ден Хале 1 Силоз 1
        Long eatenFodderCurrentDayMinTwo = eatenFodderAndWaterService.findLastRecordsByCategoryHale1MinTwo();
        Long countHensOfCurrentDayMinTwo = hensAddService.getCountOfHensFirstAboutCurrentDayMinusTwo();
        Long currentDayKgOfFodderMinTwo = fodderService.getKgOfFodderMinTwo();
        Long currentDayLitreOfWaterMinTwo = eatenFodderAndWaterService.getLitreOfWaterMinTwo();

        float percentCurrentDayMinTwo = (eatenFodderCurrentDayMinTwo / (countHensOfCurrentDayMinTwo * 1.0f));
        float percentCurrentDayWaterMinTwo = (currentDayLitreOfWaterMinTwo / (countHensOfCurrentDayMinTwo * 1.0f));

        model.addAttribute("currentDayMinTwo", LocalDate.now().minusDays(2));
        model.addAttribute("currentDayKgOfFodderMinTwo", currentDayKgOfFodderMinTwo);
        model.addAttribute("percentCurrentDayMinTwo"
                , String.format("%.4f" + " гр.",percentCurrentDayMinTwo));
        model.addAttribute("percentCurrentDayWaterMinTwo"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterMinTwo));

        // За текущия -2 ден Хале 2 Силоз 2
        Long lastDayEatenFodderHale2MinTwo = eatenFodderAndWaterService.findLastRecordsByCategoryHale2MinTwo();
        Long countHensOfCurrentDayHale2MinTwo = hensAddService.getCountOfHensSecondAboutCurrentDayMinusTwo();
        Long currentDayKgOfFodderHale2MinTwo = fodderService.getKgOfFodderSilo2MinTwo();
        Long currentDayLitreOfWaterHale2MinTwo = eatenFodderAndWaterService.getLitreOfWaterHale2MinTwo();

        float percentCurrentDayHale2MinTwo = (lastDayEatenFodderHale2MinTwo / (countHensOfCurrentDayHale2MinTwo * 1.0f));
        float percentCurrentDayWaterHale2MinTwo = (currentDayLitreOfWaterHale2MinTwo / (countHensOfCurrentDayHale2MinTwo * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale2MinTwo", currentDayKgOfFodderHale2MinTwo);
        model.addAttribute("percentCurrentDayHale2MinTwo"
                , String.format("%.4f" + " гр.",percentCurrentDayHale2MinTwo));
        model.addAttribute("percentCurrentDayWaterHale2MinTwo"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale2MinTwo));

        // За текущия -2 ден Хале 3 Силоз 3
        Long lastDayEatenFodderHale3MinTwo = eatenFodderAndWaterService.findLastRecordsByCategoryHale3MinTwo();
        Long countHensOfCurrentDayHale3MinTwo = hensAddService.getCountOfHensThirdAboutCurrentDayMinusTwo();
        Long currentDayKgOfFodderHale3MinTwo = fodderService.getKgOfFodderSilo3MinTwo();
        Long currentDayLitreOfWaterHale3MinTwo = eatenFodderAndWaterService.getLitreOfWaterHale3MinTwo();

        float percentCurrentDayHale3MinTwo = (lastDayEatenFodderHale3MinTwo / (countHensOfCurrentDayHale3MinTwo * 1.0f));
        float percentCurrentDayWaterHale3MinTwo = (currentDayLitreOfWaterHale3MinTwo / (countHensOfCurrentDayHale3MinTwo * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale3MinTwo", currentDayKgOfFodderHale3MinTwo);
        model.addAttribute("percentCurrentDayHale3MinTwo"
                , String.format("%.4f" + " гр.",percentCurrentDayHale3MinTwo));
        model.addAttribute("percentCurrentDayWaterHale3MinTwo"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale3MinTwo));

        // За текущия -2 ден Хале 4 Силоз 4
        Long lastDayEatenFodderHale4MinTwo = eatenFodderAndWaterService.findLastRecordsByCategoryHale4MinTwo();
        Long countHensOfCurrentDayHale4MinTwo = hensAddService.getCountOfHensFourthAboutCurrentDayMinusTwo();
        Long currentDayKgOfFodderHale4MinTwo = fodderService.getKgOfFodderSilo4MinTwo();
        Long currentDayLitreOfWaterHale4MinTwo = eatenFodderAndWaterService.getLitreOfWaterHale4MinTwo();

        float percentCurrentDayHale4MinTwo = (lastDayEatenFodderHale4MinTwo / (countHensOfCurrentDayHale4MinTwo * 1.0f));
        float percentCurrentDayWaterHale4MinTwo = (currentDayLitreOfWaterHale4MinTwo / (countHensOfCurrentDayHale4MinTwo * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale4MinTwo", currentDayKgOfFodderHale4MinTwo);
        model.addAttribute("percentCurrentDayHale4MinTwo"
                , String.format("%.4f" + " гр.",percentCurrentDayHale4MinTwo));
        model.addAttribute("percentCurrentDayWaterHale4MinTwo"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale4MinTwo));

        // За текущия - 3 ден Хале 1 Силоз 1
        Long eatenFodderCurrentDayMinThree = eatenFodderAndWaterService.findLastRecordsByCategoryHale1MinThree();
        Long countHensOfCurrentDayMinThree = hensAddService.getCountOfHensFirstAboutCurrentDayMinusThree();
        Long currentDayKgOfFodderMinThree = fodderService.getKgOfFodderMinThree();
        Long currentDayLitreOfWaterMinThree = eatenFodderAndWaterService.getLitreOfWaterMinThree();

        float percentCurrentDayMinThree = (eatenFodderCurrentDayMinThree / (countHensOfCurrentDayMinThree * 1.0f));
        float percentCurrentDayWaterMinThree = (currentDayLitreOfWaterMinThree / (countHensOfCurrentDayMinThree * 1.0f));

        model.addAttribute("currentDayMinThree", LocalDate.now().minusDays(3));
        model.addAttribute("currentDayKgOfFodderMinThree", currentDayKgOfFodderMinThree);
        model.addAttribute("percentCurrentDayMinThree"
                , String.format("%.4f" + " гр.",percentCurrentDayMinThree));
        model.addAttribute("percentCurrentDayWaterMinThree"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterMinThree));

        // За текущия -3 ден Хале 2 Силоз 2
        Long lastDayEatenFodderHale2MinThree = eatenFodderAndWaterService.findLastRecordsByCategoryHale2MinThree();
        Long countHensOfCurrentDayHale2MinThree = hensAddService.getCountOfHensSecondAboutCurrentDayMinusThree();
        Long currentDayKgOfFodderHale2MinThree = fodderService.getKgOfFodderSilo2MinThree();
        Long currentDayLitreOfWaterHale2MinThree = eatenFodderAndWaterService.getLitreOfWaterHale2MinThree();

        float percentCurrentDayHale2MinThree = (lastDayEatenFodderHale2MinThree / (countHensOfCurrentDayHale2MinThree * 1.0f));
        float percentCurrentDayWaterHale2MinThree = (currentDayLitreOfWaterHale2MinThree / (countHensOfCurrentDayHale2MinThree * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale2MinThree", currentDayKgOfFodderHale2MinThree);
        model.addAttribute("percentCurrentDayHale2MinThree"
                , String.format("%.4f" + " гр.",percentCurrentDayHale2MinThree));
        model.addAttribute("percentCurrentDayWaterHale2MinThree"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale2MinThree));

        // За текущия -3 ден Хале 3 Силоз 3
        Long lastDayEatenFodderHale3MinThree = eatenFodderAndWaterService.findLastRecordsByCategoryHale3MinThree();
        Long countHensOfCurrentDayHale3MinThree = hensAddService.getCountOfHensThirdAboutCurrentDayMinusThree();
        Long currentDayKgOfFodderHale3MinThree = fodderService.getKgOfFodderSilo3MinThree();
        Long currentDayLitreOfWaterHale3MinThree = eatenFodderAndWaterService.getLitreOfWaterHale3MinThree();

        float percentCurrentDayHale3MinThree = (lastDayEatenFodderHale3MinThree / (countHensOfCurrentDayHale3MinThree * 1.0f));
        float percentCurrentDayWaterHale3MinThree = (currentDayLitreOfWaterHale3MinThree / (countHensOfCurrentDayHale3MinThree * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale3MinThree", currentDayKgOfFodderHale3MinThree);
        model.addAttribute("percentCurrentDayHale3MinThree"
                , String.format("%.4f" + " гр.",percentCurrentDayHale3MinThree));
        model.addAttribute("percentCurrentDayWaterHale3MinThree"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale3MinThree));

        // За текущия -3 ден Хале 4 Силоз 4
        Long lastDayEatenFodderHale4MinThree = eatenFodderAndWaterService.findLastRecordsByCategoryHale4MinThree();
        Long countHensOfCurrentDayHale4MinThree = hensAddService.getCountOfHensFourthAboutCurrentDayMinusThree();
        Long currentDayKgOfFodderHale4MinThree = fodderService.getKgOfFodderSilo4MinThree();
        Long currentDayLitreOfWaterHale4MinThree = eatenFodderAndWaterService.getLitreOfWaterHale4MinThree();

        float percentCurrentDayHale4MinThree = (lastDayEatenFodderHale4MinThree / (countHensOfCurrentDayHale4MinThree * 1.0f));
        float percentCurrentDayWaterHale4MinThree = (currentDayLitreOfWaterHale4MinThree / (countHensOfCurrentDayHale4MinThree * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale4MinThree", currentDayKgOfFodderHale4MinThree);
        model.addAttribute("percentCurrentDayHale4MinThree"
                , String.format("%.4f" + " гр.",percentCurrentDayHale4MinThree));
        model.addAttribute("percentCurrentDayWaterHale4MinThree"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale4MinThree));

        // За текущия - 4 ден Хале 1 Силоз 1
        Long eatenFodderCurrentDayMinFourth = eatenFodderAndWaterService.findLastRecordsByCategoryHale1MinFourth();
        Long countHensOfCurrentDayMinFourth = hensAddService.getCountOfHensFirstAboutCurrentDayMinusFourth();
        Long currentDayKgOfFodderMinFourth = fodderService.getKgOfFodderMinFourth();
        Long currentDayLitreOfWaterMinFourth = eatenFodderAndWaterService.getLitreOfWaterMinFourth();

        float percentCurrentDayMinFourth = (eatenFodderCurrentDayMinFourth / (countHensOfCurrentDayMinFourth * 1.0f));
        float percentCurrentDayWaterMinFourth = (currentDayLitreOfWaterMinFourth / (countHensOfCurrentDayMinFourth * 1.0f));

        model.addAttribute("currentDayMinFourth", LocalDate.now().minusDays(4));
        model.addAttribute("currentDayKgOfFodderMinFourth", currentDayKgOfFodderMinFourth);
        model.addAttribute("percentCurrentDayMinFourth"
                , String.format("%.4f" + " гр.",percentCurrentDayMinFourth));
        model.addAttribute("percentCurrentDayWaterMinFourth"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterMinFourth));

        // За текущия -4 ден Хале 2 Силоз 2
        Long lastDayEatenFodderHale2MinFourth = eatenFodderAndWaterService.findLastRecordsByCategoryHale2MinFourth();
        Long countHensOfCurrentDayHale2MinFourth = hensAddService.getCountOfHensSecondAboutCurrentDayMinusFourth();
        Long currentDayKgOfFodderHale2MinFourth = fodderService.getKgOfFodderSilo2MinFourth();
        Long currentDayLitreOfWaterHale2MinFourth = eatenFodderAndWaterService.getLitreOfWaterHale2MinFourth();

        float percentCurrentDayHale2MinFourth = (lastDayEatenFodderHale2MinFourth / (countHensOfCurrentDayHale2MinFourth * 1.0f));
        float percentCurrentDayWaterHale2MinFourth = (currentDayLitreOfWaterHale2MinFourth / (countHensOfCurrentDayHale2MinFourth * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale2MinFourth", currentDayKgOfFodderHale2MinFourth);
        model.addAttribute("percentCurrentDayHale2MinFourth"
                , String.format("%.4f" + " гр.",percentCurrentDayHale2MinFourth));
        model.addAttribute("percentCurrentDayWaterHale2MinFourth"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale2MinFourth));

        // За текущия -4 ден Хале 3 Силоз 3
        Long lastDayEatenFodderHale3MinFourth = eatenFodderAndWaterService.findLastRecordsByCategoryHale3MinFourth();
        Long countHensOfCurrentDayHale3MinFourth = hensAddService.getCountOfHensThirdAboutCurrentDayMinusFourth();
        Long currentDayKgOfFodderHale3MinFourth = fodderService.getKgOfFodderSilo3MinFourth();
        Long currentDayLitreOfWaterHale3MinFourth = eatenFodderAndWaterService.getLitreOfWaterHale3MinFourth();

        float percentCurrentDayHale3MinFourth = (lastDayEatenFodderHale3MinFourth / (countHensOfCurrentDayHale3MinFourth * 1.0f));
        float percentCurrentDayWaterHale3MinFourth = (currentDayLitreOfWaterHale3MinFourth / (countHensOfCurrentDayHale3MinFourth * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale3MinFourth", currentDayKgOfFodderHale3MinFourth);
        model.addAttribute("percentCurrentDayHale3MinFourth"
                , String.format("%.4f" + " гр.",percentCurrentDayHale3MinFourth));
        model.addAttribute("percentCurrentDayWaterHale3MinFourth"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale3MinFourth));

        // За текущия -4 ден Хале 4 Силоз 4
        Long lastDayEatenFodderHale4MinFourth = eatenFodderAndWaterService.findLastRecordsByCategoryHale4MinFourth();
        Long countHensOfCurrentDayHale4MinFourth = hensAddService.getCountOfHensFourthAboutCurrentDayMinusFourth();
        Long currentDayKgOfFodderHale4MinFourth = fodderService.getKgOfFodderSilo4MinFourth();
        Long currentDayLitreOfWaterHale4MinFourth = eatenFodderAndWaterService.getLitreOfWaterHale4MinFourth();

        float percentCurrentDayHale4MinFourth = (lastDayEatenFodderHale4MinFourth / (countHensOfCurrentDayHale4MinFourth * 1.0f));
        float percentCurrentDayWaterHale4MinFourth = (currentDayLitreOfWaterHale4MinFourth / (countHensOfCurrentDayHale4MinFourth * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale4MinFourth", currentDayKgOfFodderHale4MinFourth);
        model.addAttribute("percentCurrentDayHale4MinFourth"
                , String.format("%.4f" + " гр.",percentCurrentDayHale4MinFourth));
        model.addAttribute("percentCurrentDayWaterHale4MinFourth"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale4MinFourth));

        // За текущия - 5 ден Хале 1 Силоз 1
        Long eatenFodderCurrentDayMinFifth = eatenFodderAndWaterService.findLastRecordsByCategoryHale1MinFifth();
        Long countHensOfCurrentDayMinFifth = hensAddService.getCountOfHensFirstAboutCurrentDayMinusFive();
        Long currentDayKgOfFodderMinFifth = fodderService.getKgOfFodderMinFifth();
        Long currentDayLitreOfWaterMinFifth = eatenFodderAndWaterService.getLitreOfWaterMinFifth();

        float percentCurrentDayMinFifth = (eatenFodderCurrentDayMinFifth / (countHensOfCurrentDayMinFifth * 1.0f));
        float percentCurrentDayWaterMinFifth = (currentDayLitreOfWaterMinFifth / (countHensOfCurrentDayMinFifth * 1.0f));

        model.addAttribute("currentDayMinFifth", LocalDate.now().minusDays(5));
        model.addAttribute("currentDayKgOfFodderMinFifth", currentDayKgOfFodderMinFifth);
        model.addAttribute("percentCurrentDayMinFifth"
                , String.format("%.4f" + " гр.",percentCurrentDayMinFifth));
        model.addAttribute("percentCurrentDayWaterMinFifth"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterMinFifth));

        // За текущия -5 ден Хале 2 Силоз 2
        Long lastDayEatenFodderHale2MinFifth = eatenFodderAndWaterService.findLastRecordsByCategoryHale2MinFifth();
        Long countHensOfCurrentDayHale2MinFifth = hensAddService.getCountOfHensSecondAboutCurrentDayMinusFive();
        Long currentDayKgOfFodderHale2MinFifth = fodderService.getKgOfFodderSilo2MinFifth();
        Long currentDayLitreOfWaterHale2MinFifth = eatenFodderAndWaterService.getLitreOfWaterHale2MinFifth();

        float percentCurrentDayHale2MinFifth = (lastDayEatenFodderHale2MinFifth / (countHensOfCurrentDayHale2MinFifth * 1.0f));
        float percentCurrentDayWaterHale2MinFifth = (currentDayLitreOfWaterHale2MinFifth / (countHensOfCurrentDayHale2MinFifth * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale2MinFifth", currentDayKgOfFodderHale2MinFifth);
        model.addAttribute("percentCurrentDayHale2MinFifth"
                , String.format("%.4f" + " гр.",percentCurrentDayHale2MinFifth));
        model.addAttribute("percentCurrentDayWaterHale2MinFifth"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale2MinFifth));

        // За текущия -5 ден Хале 3 Силоз 3
        Long lastDayEatenFodderHale3MinFifth = eatenFodderAndWaterService.findLastRecordsByCategoryHale3MinFifth();
        Long countHensOfCurrentDayHale3MinFifth = hensAddService.getCountOfHensThirdAboutCurrentDayMinusFive();
        Long currentDayKgOfFodderHale3MinFifth = fodderService.getKgOfFodderSilo3MinFifth();
        Long currentDayLitreOfWaterHale3MinFifth = eatenFodderAndWaterService.getLitreOfWaterHale3MinFifth();

        float percentCurrentDayHale3MinFifth = (lastDayEatenFodderHale3MinFifth / (countHensOfCurrentDayHale3MinFifth * 1.0f));
        float percentCurrentDayWaterHale3MinFifth = (currentDayLitreOfWaterHale3MinFifth / (countHensOfCurrentDayHale3MinFifth * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale3MinFifth", currentDayKgOfFodderHale3MinFifth);
        model.addAttribute("percentCurrentDayHale3MinFifth"
                , String.format("%.4f" + " гр.",percentCurrentDayHale3MinFifth));
        model.addAttribute("percentCurrentDayWaterHale3MinFifth"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale3MinFifth));

        // За текущия -5 ден Хале 4 Силоз 4
        Long lastDayEatenFodderHale4MinFifth = eatenFodderAndWaterService.findLastRecordsByCategoryHale4MinFifth();
        Long countHensOfCurrentDayHale4MinFifth = hensAddService.getCountOfHensFourthAboutCurrentDayMinusFive();
        Long currentDayKgOfFodderHale4MinFifth = fodderService.getKgOfFodderSilo4MinFifth();
        Long currentDayLitreOfWaterHale4MinFifth = eatenFodderAndWaterService.getLitreOfWaterHale4MinFifth();

        float percentCurrentDayHale4MinFifth = (lastDayEatenFodderHale4MinFifth / (countHensOfCurrentDayHale4MinFifth * 1.0f));
        float percentCurrentDayWaterHale4MinFifth = (currentDayLitreOfWaterHale4MinFifth / (countHensOfCurrentDayHale4MinFifth * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale4MinFifth", currentDayKgOfFodderHale4MinFifth);
        model.addAttribute("percentCurrentDayHale4MinFifth"
                , String.format("%.4f" + " гр.",percentCurrentDayHale4MinFifth));
        model.addAttribute("percentCurrentDayWaterHale4MinFifth"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale4MinFifth));

        // За текущия - 6 ден Хале 1 Силоз 1
        Long eatenFodderCurrentDayMinSix = eatenFodderAndWaterService.findLastRecordsByCategoryHale1MinSix();
        Long countHensOfCurrentDayMinSix = hensAddService.getCountOfHensFirstAboutCurrentDayMinusSix();
        Long currentDayKgOfFodderMinSix = fodderService.getKgOfFodderMinSix();
        Long currentDayLitreOfWaterMinSix = eatenFodderAndWaterService.getLitreOfWaterMinSix();

        float percentCurrentDayMinSix = (eatenFodderCurrentDayMinSix / (countHensOfCurrentDayMinSix * 1.0f));
        float percentCurrentDayWaterMinSix = (currentDayLitreOfWaterMinSix / (countHensOfCurrentDayMinSix * 1.0f));

        model.addAttribute("currentDayMinSix", LocalDate.now().minusDays(6));
        model.addAttribute("currentDayKgOfFodderMinSix", currentDayKgOfFodderMinSix);
        model.addAttribute("percentCurrentDayMinSix"
                , String.format("%.4f" + " гр.",percentCurrentDayMinSix));
        model.addAttribute("percentCurrentDayWaterMinSix"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterMinSix));

        // За текущия -6 ден Хале 2 Силоз 2
        Long lastDayEatenFodderHale2MinSix = eatenFodderAndWaterService.findLastRecordsByCategoryHale2MinSix();
        Long countHensOfCurrentDayHale2MinSix = hensAddService.getCountOfHensSecondAboutCurrentDayMinusSix();
        Long currentDayKgOfFodderHale2MinSix = fodderService.getKgOfFodderSilo2MinSix();
        Long currentDayLitreOfWaterHale2MinSix = eatenFodderAndWaterService.getLitreOfWaterHale2MinSix();

        float percentCurrentDayHale2MinSix = (lastDayEatenFodderHale2MinSix / (countHensOfCurrentDayHale2MinSix * 1.0f));
        float percentCurrentDayWaterHale2MinSix = (currentDayLitreOfWaterHale2MinSix / (countHensOfCurrentDayHale2MinSix * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale2MinSix", currentDayKgOfFodderHale2MinSix);
        model.addAttribute("percentCurrentDayHale2MinSix"
                , String.format("%.4f" + " гр.",percentCurrentDayHale2MinSix));
        model.addAttribute("percentCurrentDayWaterHale2MinSix"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale2MinSix));

        // За текущия -6 ден Хале 3 Силоз 3
        Long lastDayEatenFodderHale3MinSix = eatenFodderAndWaterService.findLastRecordsByCategoryHale3MinSix();
        Long countHensOfCurrentDayHale3MinSix = hensAddService.getCountOfHensThirdAboutCurrentDayMinusSix();
        Long currentDayKgOfFodderHale3MinSix = fodderService.getKgOfFodderSilo3MinSix();
        Long currentDayLitreOfWaterHale3MinSix = eatenFodderAndWaterService.getLitreOfWaterHale3MinSix();

        float percentCurrentDayHale3MinSix = (lastDayEatenFodderHale3MinSix / (countHensOfCurrentDayHale3MinSix * 1.0f));
        float percentCurrentDayWaterHale3MinSix = (currentDayLitreOfWaterHale3MinSix / (countHensOfCurrentDayHale3MinSix * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale3MinSix", currentDayKgOfFodderHale3MinSix);
        model.addAttribute("percentCurrentDayHale3MinSix"
                , String.format("%.4f" + " гр.",percentCurrentDayHale3MinSix));
        model.addAttribute("percentCurrentDayWaterHale3MinSix"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale3MinSix));

        // За текущия -6 ден Хале 4 Силоз 4
        Long lastDayEatenFodderHale4MinSix = eatenFodderAndWaterService.findLastRecordsByCategoryHale4MinSix();
        Long countHensOfCurrentDayHale4MinSix = hensAddService.getCountOfHensFourthAboutCurrentDayMinusSix();
        Long currentDayKgOfFodderHale4MinSix = fodderService.getKgOfFodderSilo4MinSix();
        Long currentDayLitreOfWaterHale4MinSix = eatenFodderAndWaterService.getLitreOfWaterHale4MinSix();

        float percentCurrentDayHale4MinSix = (lastDayEatenFodderHale4MinSix / (countHensOfCurrentDayHale4MinSix * 1.0f));
        float percentCurrentDayWaterHale4MinSix = (currentDayLitreOfWaterHale4MinSix / (countHensOfCurrentDayHale4MinSix * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale4MinSix", currentDayKgOfFodderHale4MinSix);
        model.addAttribute("percentCurrentDayHale4MinSix"
                , String.format("%.4f" + " гр.",percentCurrentDayHale4MinSix));
        model.addAttribute("percentCurrentDayWaterHale4MinSix"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale4MinSix));

        return "spravka-fodder";
    }
    //За горна база фураж и вода за деня
    @GetMapping("/reference-consuming-upper")
    public String viewUpper(Model model, HttpSession httpSession){

        // За текущия ден Хале 5 Силоз 5
        Long lastDayEatenFodderHale5 = eatenFodderAndWaterService.findLastRecordsByCategoryHale5();
        Long countHensOfCurrentDayHale5 = hensAddService.getCountOfHensFiveAboutCurrentDay();
        Long currentDayKgOfFodderHale5 = fodderService.getKgOfFodderHale5();
        Long currentDayLitreOfWaterHale5 = eatenFodderAndWaterService.getLitreOfWaterHale5();

        float percentCurrentDayHale5 = (lastDayEatenFodderHale5 / (countHensOfCurrentDayHale5 * 1.0f));
        float percentCurrentDayWaterHale5 = (currentDayLitreOfWaterHale5 / (countHensOfCurrentDayHale5 * 1.0f));

        model.addAttribute("currentDayHale5", LocalDate.now());
        model.addAttribute("currentDayKgOfFodderHale5", currentDayKgOfFodderHale5);
        model.addAttribute("percentCurrentDayHale5"
                , String.format("%.4f" + " гр.",percentCurrentDayHale5));
        model.addAttribute("percentCurrentDayWaterHale5"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale5));

        // За текущия ден Хале 6 Силоз 6
        Long lastDayEatenFodderHale6 = eatenFodderAndWaterService.findLastRecordsByCategoryHale6();
        Long countHensOfCurrentDayHale6 = hensAddService.getCountOfHensSixAboutCurrentDay();
        Long currentDayKgOfFodderHale6 = fodderService.getKgOfFodderSilo6();
        Long currentDayLitreOfWaterHale6 = eatenFodderAndWaterService.getLitreOfWaterHale6();

        float percentCurrentDayHale6 = (lastDayEatenFodderHale6 / (countHensOfCurrentDayHale6 * 1.0f));
        float percentCurrentDayWaterHale6 = (currentDayLitreOfWaterHale6 / (countHensOfCurrentDayHale6 * 1.0f));



        model.addAttribute("currentDayKgOfFodderHale6", currentDayKgOfFodderHale6);
        model.addAttribute("percentCurrentDayHale6"
                , String.format("%.4f" + " гр.",percentCurrentDayHale6));
        model.addAttribute("percentCurrentDayWaterHale6"
                , String.format("%.4f" + " мл.",percentCurrentDayWaterHale6));

        // За текущия ден Хале 7 Силоз 7
        Long lastDayEatenFodderHale7 = eatenFodderAndWaterService.findLastRecordsByCategoryHale7();
        Long countHensOfCurrentDayHale7 = hensAddService.getCountOfHensSevenAboutCurrentDay();
        Long currentDayKgOfFodderHale7 = fodderService.getKgOfFodderSilo7();
        Long currentDayLitreOfWaterHale7 = eatenFodderAndWaterService.getLitreOfWaterHale7();

        float percentCurrentDayHale7 = (lastDayEatenFodderHale7 / (countHensOfCurrentDayHale7 * 1.0f));
        float percentCurrentDayWaterHale7 = (currentDayLitreOfWaterHale7 / (countHensOfCurrentDayHale7 * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale7", currentDayKgOfFodderHale7);
        model.addAttribute("percentCurrentDayHale7"
                , String.format("%.4f" + " гр.",percentCurrentDayHale7));
        model.addAttribute("percentCurrentDayWaterHale7"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale7));

        // За текущия ден Хале 8 Силоз 8
        Long lastDayEatenFodderHale8 = eatenFodderAndWaterService.findLastRecordsByCategoryHale8();
        Long countHensOfCurrentDayHale8 = hensAddService.getCountOfHensEightAboutCurrentDay();
        Long currentDayKgOfFodderHale8 = fodderService.getKgOfFodderSilo8();
        Long currentDayLitreOfWaterHale8 = eatenFodderAndWaterService.getLitreOfWaterHale8();

        float percentCurrentDayHale8 = (lastDayEatenFodderHale8 / (countHensOfCurrentDayHale8 * 1.0f));
        float percentCurrentDayWaterHale8 = (currentDayLitreOfWaterHale8 / (countHensOfCurrentDayHale8 * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale8", currentDayKgOfFodderHale8);
        model.addAttribute("percentCurrentDayHale8"
                , String.format("%.4f" + " гр.",percentCurrentDayHale8));
        model.addAttribute("percentCurrentDayWaterHale8"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale8));

        // За текущия ден Хале 9 Силоз 9
        Long lastDayEatenFodderHale9 = eatenFodderAndWaterService.findLastRecordsByCategoryHale9();
        Long countHensOfCurrentDayHale9 = hensAddService.getCountOfHensNinthAboutCurrentDay();
        Long currentDayKgOfFodderHale9 = fodderService.getKgOfFodderSilo9();
        Long currentDayLitreOfWaterHale9 = eatenFodderAndWaterService.getLitreOfWaterHale9();

        float percentCurrentDayHale9 = (lastDayEatenFodderHale9 / (countHensOfCurrentDayHale9 * 1.0f));
        float percentCurrentDayWaterHale9 = (currentDayLitreOfWaterHale9 / (countHensOfCurrentDayHale9 * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale9", currentDayKgOfFodderHale9);
        model.addAttribute("percentCurrentDayHale9"
                , String.format("%.4f" + " гр.",percentCurrentDayHale9));
        model.addAttribute("percentCurrentDayWaterHale9"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale9));

        // За текущия ден - 1 ден Хале 5 Силоз 5
        Long lastDayEatenFodderHale5MinOne = eatenFodderAndWaterService.findLastRecordsByCategoryHale5MinOne();
        Long countHensOfCurrentDayHale5MinOne = hensAddService.getCountOfHensFiveAboutCurrentDayMinusOne();
        Long currentDayKgOfFodderHale5MinOne = fodderService.getKgOfFodderHale5MinOne();
        Long currentDayLitreOfWaterHale5MinOne = eatenFodderAndWaterService.getLitreOfWaterHale5MinOne();

        float percentCurrentDayHale5MinOne = (lastDayEatenFodderHale5MinOne / (countHensOfCurrentDayHale5MinOne * 1.0f));
        float percentCurrentDayWaterHale5MinOne = (currentDayLitreOfWaterHale5MinOne / (countHensOfCurrentDayHale5MinOne * 1.0f));

        model.addAttribute("currentDayHale5MinOne", LocalDate.now().minusDays(1));
        model.addAttribute("currentDayKgOfFodderHale5MinOne", currentDayKgOfFodderHale5MinOne);
        model.addAttribute("percentCurrentDayHale5MinOne"
                , String.format("%.4f" + " гр.",percentCurrentDayHale5MinOne));
        model.addAttribute("percentCurrentDayWaterHale5MinOne"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale5MinOne));

        // За текущия ден - 1 ден Хале 6 Силоз 6
        Long lastDayEatenFodderHale6MinOne = eatenFodderAndWaterService.findLastRecordsByCategoryHale6MinOne();
        Long countHensOfCurrentDayHale6MinOne = hensAddService.getCountOfHensSixAboutCurrentDayMinusOne();
        Long currentDayKgOfFodderHale6MinOne = fodderService.getKgOfFodderSilo6MinOne();
        Long currentDayLitreOfWaterHale6MinOne = eatenFodderAndWaterService.getLitreOfWaterHale6MinOne();

        float percentCurrentDayHale6MinOne = (lastDayEatenFodderHale6MinOne / (countHensOfCurrentDayHale6MinOne * 1.0f));
        float percentCurrentDayWaterHale6MinOne = (currentDayLitreOfWaterHale6MinOne / (countHensOfCurrentDayHale6MinOne * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale6MinOne", currentDayKgOfFodderHale6MinOne);
        model.addAttribute("percentCurrentDayHale6MinOne"
                , String.format("%.4f" + " гр.",percentCurrentDayHale6MinOne));
        model.addAttribute("percentCurrentDayWaterHale6MinOne"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale6MinOne));

        // За текущия ден  - 1 ден Хале 7 Силоз 7
        Long lastDayEatenFodderHale7MinOne = eatenFodderAndWaterService.findLastRecordsByCategoryHale7MinOne();
        Long countHensOfCurrentDayHale7MinOne = hensAddService.getCountOfHensSevenAboutCurrentDayMinusOne();
        Long currentDayKgOfFodderHale7MinOne = fodderService.getKgOfFodderSilo7MinOne();
        Long currentDayLitreOfWaterHale7MinOne = eatenFodderAndWaterService.getLitreOfWaterHale7MinOne();

        float percentCurrentDayHale7MinOne = (lastDayEatenFodderHale7MinOne / (countHensOfCurrentDayHale7MinOne * 1.0f));
        float percentCurrentDayWaterHale7MinOne = (currentDayLitreOfWaterHale7MinOne / (countHensOfCurrentDayHale7MinOne * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale7MinOne", currentDayKgOfFodderHale7MinOne);
        model.addAttribute("percentCurrentDayHale7MinOne"
                , String.format("%.4f" + " гр.",percentCurrentDayHale7MinOne));
        model.addAttribute("percentCurrentDayWaterHale7MinOne"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale7MinOne));

        // За текущия ден - 1 ден Хале 8 Силоз 8
        Long lastDayEatenFodderHale8MinOne = eatenFodderAndWaterService.findLastRecordsByCategoryHale8MinOne();
        Long countHensOfCurrentDayHale8MinOne = hensAddService.getCountOfHensEightAboutCurrentDayMinusOne();
        Long currentDayKgOfFodderHale8MinOne = fodderService.getKgOfFodderSilo8MinOne();
        Long currentDayLitreOfWaterHale8MinOne = eatenFodderAndWaterService.getLitreOfWaterHale8MinOne();

        float percentCurrentDayHale8MinOne = (lastDayEatenFodderHale8MinOne / (countHensOfCurrentDayHale8MinOne * 1.0f));
        float percentCurrentDayWaterHale8MinOne = (currentDayLitreOfWaterHale8MinOne / (countHensOfCurrentDayHale8MinOne * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale8MinOne", currentDayKgOfFodderHale8MinOne);
        model.addAttribute("percentCurrentDayHale8MinOne"
                , String.format("%.4f" + " гр.",percentCurrentDayHale8MinOne));
        model.addAttribute("percentCurrentDayWaterHale8MinOne"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale8MinOne));

        // За текущия ден - 1 ден Хале 9 Силоз 9
        Long lastDayEatenFodderHale9MinOne = eatenFodderAndWaterService.findLastRecordsByCategoryHale9MinOne();
        Long countHensOfCurrentDayHale9MinOne = hensAddService.getCountOfHensNinthAboutCurrentDayMinusOne();
        Long currentDayKgOfFodderHale9MinOne = fodderService.getKgOfFodderSilo9MinOne();
        Long currentDayLitreOfWaterHale9MinOne = eatenFodderAndWaterService.getLitreOfWaterHale9MinOne();

        float percentCurrentDayHale9MinOne = (lastDayEatenFodderHale9MinOne / (countHensOfCurrentDayHale9MinOne * 1.0f));
        float percentCurrentDayWaterHale9MinOne = (currentDayLitreOfWaterHale9MinOne / (countHensOfCurrentDayHale9MinOne * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale9MinOne", currentDayKgOfFodderHale9MinOne);
        model.addAttribute("percentCurrentDayHale9MinOne"
                , String.format("%.4f" + " гр.",percentCurrentDayHale9MinOne));
        model.addAttribute("percentCurrentDayWaterHale9MinOne"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale9MinOne));

        // За текущия ден -2 Хале 5 Силоз 5
        Long lastDayEatenFodderHale5MinTwo = eatenFodderAndWaterService.findLastRecordsByCategoryHale5MinTwo();
        Long countHensOfCurrentDayHale5MinTwo = hensAddService.getCountOfHensFiveAboutCurrentDayMinusTwo();
        Long currentDayKgOfFodderHale5MinTwo = fodderService.getKgOfFodderHale5MinTwo();
        Long currentDayLitreOfWaterHale5MinTwo = eatenFodderAndWaterService.getLitreOfWaterHale5MinTwo();

        float percentCurrentDayHale5MinTwo = (lastDayEatenFodderHale5MinTwo / (countHensOfCurrentDayHale5MinTwo * 1.0f));
        float percentCurrentDayWaterHale5MinTwo = (currentDayLitreOfWaterHale5MinTwo / (countHensOfCurrentDayHale5MinTwo * 1.0f));

        model.addAttribute("currentDayHale5MinTwo", LocalDate.now().minusDays(2));
        model.addAttribute("currentDayKgOfFodderHale5MinTwo", currentDayKgOfFodderHale5MinTwo);
        model.addAttribute("percentCurrentDayHale5MinTwo"
                , String.format("%.4f" + " гр.",percentCurrentDayHale5MinTwo));
        model.addAttribute("percentCurrentDayWaterHale5MinTwo"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale5MinTwo));

        // За текущия ден -2 Хале 6 Силоз 6
        Long lastDayEatenFodderHale6MinTwo = eatenFodderAndWaterService.findLastRecordsByCategoryHale6MinTwo();
        Long countHensOfCurrentDayHale6MinTwo = hensAddService.getCountOfHensSixAboutCurrentDayMinusTwo();
        Long currentDayKgOfFodderHale6MinTwo = fodderService.getKgOfFodderSilo6MinTwo();
        Long currentDayLitreOfWaterHale6MinTwo = eatenFodderAndWaterService.getLitreOfWaterHale6MinTwo();

        float percentCurrentDayHale6MinTwo = (lastDayEatenFodderHale6MinTwo / (countHensOfCurrentDayHale6MinTwo * 1.0f));
        float percentCurrentDayWaterHale6MinTwo = (currentDayLitreOfWaterHale6MinTwo / (countHensOfCurrentDayHale6MinTwo * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale6MinTwo", currentDayKgOfFodderHale6MinTwo);
        model.addAttribute("percentCurrentDayHale6MinTwo"
                , String.format("%.4f" + " гр.",percentCurrentDayHale6MinTwo));
        model.addAttribute("percentCurrentDayWaterHale6MinTwo"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale6MinTwo));

        // За текущия ден -2 Хале 7 Силоз 7
        Long lastDayEatenFodderHale7MinTwo = eatenFodderAndWaterService.findLastRecordsByCategoryHale7MinTwo();
        Long countHensOfCurrentDayHale7MinTwo = hensAddService.getCountOfHensSevenAboutCurrentDayMinusTwo();
        Long currentDayKgOfFodderHale7MinTwo = fodderService.getKgOfFodderSilo7MinTwo();
        Long currentDayLitreOfWaterHale7MinTwo = eatenFodderAndWaterService.getLitreOfWaterHale7MinTwo();

        float percentCurrentDayHale7MinTwo = (lastDayEatenFodderHale7MinTwo / (countHensOfCurrentDayHale7MinTwo * 1.0f));
        float percentCurrentDayWaterHale7MinTwo = (currentDayLitreOfWaterHale7MinTwo / (countHensOfCurrentDayHale7MinTwo * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale7MinTwo", currentDayKgOfFodderHale7MinTwo);
        model.addAttribute("percentCurrentDayHale7MinTwo"
                , String.format("%.4f" + " гр.",percentCurrentDayHale7MinTwo));
        model.addAttribute("percentCurrentDayWaterHale7MinTwo"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale7MinTwo));

        // За текущия ден  -2 Хале 8 Силоз 8
        Long lastDayEatenFodderHale8MinTwo = eatenFodderAndWaterService.findLastRecordsByCategoryHale8MinTwo();
        Long countHensOfCurrentDayHale8MinTwo = hensAddService.getCountOfHensEightAboutCurrentDayMinusTwo();
        Long currentDayKgOfFodderHale8MinTwo = fodderService.getKgOfFodderSilo8MinTwo();
        Long currentDayLitreOfWaterHale8MinTwo = eatenFodderAndWaterService.getLitreOfWaterHale8MinTwo();

        float percentCurrentDayHale8MinTwo = (lastDayEatenFodderHale8MinTwo / (countHensOfCurrentDayHale8MinTwo * 1.0f));
        float percentCurrentDayWaterHale8MinTwo = (currentDayLitreOfWaterHale8MinTwo / (countHensOfCurrentDayHale8MinTwo * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale8MinTwo", currentDayKgOfFodderHale8MinTwo);
        model.addAttribute("percentCurrentDayHale8MinTwo"
                , String.format("%.4f" + " гр.",percentCurrentDayHale8MinTwo));
        model.addAttribute("percentCurrentDayWaterHale8MinTwo"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale8MinTwo));

        // За текущия ден - 2 Хале 9 Силоз 9
        Long lastDayEatenFodderHale9MinTwo = eatenFodderAndWaterService.findLastRecordsByCategoryHale9MinTwo();
        Long countHensOfCurrentDayHale9MinTwo = hensAddService.getCountOfHensNinthAboutCurrentDayMinusTwo();
        Long currentDayKgOfFodderHale9MinTwo = fodderService.getKgOfFodderSilo9MinTwo();
        Long currentDayLitreOfWaterHale9MinTwo = eatenFodderAndWaterService.getLitreOfWaterHale9MinTwo();

        float percentCurrentDayHale9MinTwo = (lastDayEatenFodderHale9MinTwo / (countHensOfCurrentDayHale9MinTwo * 1.0f));
        float percentCurrentDayWaterHale9MinTwo = (currentDayLitreOfWaterHale9MinTwo / (countHensOfCurrentDayHale9MinTwo * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale9MinTwo", currentDayKgOfFodderHale9MinTwo);
        model.addAttribute("percentCurrentDayHale9MinTwo"
                , String.format("%.4f" + " гр.",percentCurrentDayHale9MinTwo));
        model.addAttribute("percentCurrentDayWaterHale9MinTwo"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale9MinTwo));

        // За текущия ден -3 Хале 5 Силоз 5
        Long lastDayEatenFodderHale5MinThree = eatenFodderAndWaterService.findLastRecordsByCategoryHale5MinThree();
        Long countHensOfCurrentDayHale5MinThree = hensAddService.getCountOfHensFiveAboutCurrentDayMinusThree();
        Long currentDayKgOfFodderHale5MinThree = fodderService.getKgOfFodderHale5MinThree();
        Long currentDayLitreOfWaterHale5MinThree = eatenFodderAndWaterService.getLitreOfWaterHale5MinThree();

        float percentCurrentDayHale5MinThree = (lastDayEatenFodderHale5MinThree / (countHensOfCurrentDayHale5MinThree * 1.0f));
        float percentCurrentDayWaterHale5MinThree = (currentDayLitreOfWaterHale5MinThree / (countHensOfCurrentDayHale5MinThree * 1.0f));

        model.addAttribute("currentDayHale5MinThree", LocalDate.now().minusDays(3));
        model.addAttribute("currentDayKgOfFodderHale5MinThree", currentDayKgOfFodderHale5MinThree);
        model.addAttribute("percentCurrentDayHale5MinThree"
                , String.format("%.4f" + " гр.",percentCurrentDayHale5MinThree));
        model.addAttribute("percentCurrentDayWaterHale5MinThree"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale5MinThree));

        // За текущия ден -3 Хале 6 Силоз 6
        Long lastDayEatenFodderHale6MinThree = eatenFodderAndWaterService.findLastRecordsByCategoryHale6MinThree();
        Long countHensOfCurrentDayHale6MinThree = hensAddService.getCountOfHensSixAboutCurrentDayMinusThree();
        Long currentDayKgOfFodderHale6MinThree = fodderService.getKgOfFodderSilo6MinThree();
        Long currentDayLitreOfWaterHale6MinThree = eatenFodderAndWaterService.getLitreOfWaterHale6MinThree();

        float percentCurrentDayHale6MinThree = (lastDayEatenFodderHale6MinThree / (countHensOfCurrentDayHale6MinThree * 1.0f));
        float percentCurrentDayWaterHale6MinThree = (currentDayLitreOfWaterHale6MinThree / (countHensOfCurrentDayHale6MinThree* 1.0f));

        model.addAttribute("currentDayKgOfFodderHale6MinThree", currentDayKgOfFodderHale6MinThree);
        model.addAttribute("percentCurrentDayHale6MinThree"
                , String.format("%.4f" + " гр.",percentCurrentDayHale6MinThree));
        model.addAttribute("percentCurrentDayWaterHale6MinThree"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale6MinThree));

        // За текущия ден -3 Хале 7 Силоз 7
        Long lastDayEatenFodderHale7MinThree = eatenFodderAndWaterService.findLastRecordsByCategoryHale7MinThree();
        Long countHensOfCurrentDayHale7MinThree = hensAddService.getCountOfHensSevenAboutCurrentDayMinusThree();
        Long currentDayKgOfFodderHale7MinThree = fodderService.getKgOfFodderSilo7MinThree();
        Long currentDayLitreOfWaterHale7MinThree = eatenFodderAndWaterService.getLitreOfWaterHale7MinThree();

        float percentCurrentDayHale7MinThree = (lastDayEatenFodderHale7MinThree / (countHensOfCurrentDayHale7MinThree * 1.0f));
        float percentCurrentDayWaterHale7MinThree = (currentDayLitreOfWaterHale7MinThree / (countHensOfCurrentDayHale7MinThree * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale7MinThree", currentDayKgOfFodderHale7MinThree);
        model.addAttribute("percentCurrentDayHale7MinThree"
                , String.format("%.4f" + " гр.",percentCurrentDayHale7MinThree));
        model.addAttribute("percentCurrentDayWaterHale7MinThree"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale7MinThree));

        // За текущия ден -3 Хале 8 Силоз 8
        Long lastDayEatenFodderHale8MinThree = eatenFodderAndWaterService.findLastRecordsByCategoryHale8MinThree();
        Long countHensOfCurrentDayHale8MinThree = hensAddService.getCountOfHensEightAboutCurrentDayMinusThree();
        Long currentDayKgOfFodderHale8MinThree = fodderService.getKgOfFodderSilo8MinThree();
        Long currentDayLitreOfWaterHale8MinThree = eatenFodderAndWaterService.getLitreOfWaterHale8MinThree();

        float percentCurrentDayHale8MinThree = (lastDayEatenFodderHale8MinThree / (countHensOfCurrentDayHale8MinThree * 1.0f));
        float percentCurrentDayWaterHale8MinThree = (currentDayLitreOfWaterHale8MinThree / (countHensOfCurrentDayHale8MinThree * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale8MinThree", currentDayKgOfFodderHale8MinThree);
        model.addAttribute("percentCurrentDayHale8MinThree"
                , String.format("%.4f" + " гр.",percentCurrentDayHale8MinThree));
        model.addAttribute("percentCurrentDayWaterHale8MinThree"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale8MinThree));

        // За текущия ден -3 Хале 9 Силоз 9
        Long lastDayEatenFodderHale9MinThree = eatenFodderAndWaterService.findLastRecordsByCategoryHale9MinThree();
        Long countHensOfCurrentDayHale9MinThree = hensAddService.getCountOfHensNinthAboutCurrentDayMinusThree();
        Long currentDayKgOfFodderHale9MinThree = fodderService.getKgOfFodderSilo9MinThree();
        Long currentDayLitreOfWaterHale9MinThree = eatenFodderAndWaterService.getLitreOfWaterHale9MinThree();

        float percentCurrentDayHale9MinThree = (lastDayEatenFodderHale9MinThree / (countHensOfCurrentDayHale9MinThree * 1.0f));
        float percentCurrentDayWaterHale9MinThree = (currentDayLitreOfWaterHale9MinThree / (countHensOfCurrentDayHale9MinThree * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale9MinThree", currentDayKgOfFodderHale9MinThree);
        model.addAttribute("percentCurrentDayHale9MinThree"
                , String.format("%.4f" + " гр.",percentCurrentDayHale9MinThree));
        model.addAttribute("percentCurrentDayWaterHale9MinThree"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale9MinThree));

        // За текущия ден -4 Хале 5 Силоз 5
        Long lastDayEatenFodderHale5MinFourth = eatenFodderAndWaterService.findLastRecordsByCategoryHale5MinFourth();
        Long countHensOfCurrentDayHale5MinFourth = hensAddService.getCountOfHensFiveAboutCurrentDayMinusFourth();
        Long currentDayKgOfFodderHale5MinFourth = fodderService.getKgOfFodderHale5MinFourth();
        Long currentDayLitreOfWaterHale5MinFourth = eatenFodderAndWaterService.getLitreOfWaterHale5MinFourth();

        float percentCurrentDayHale5MinFourth = (lastDayEatenFodderHale5MinFourth / (countHensOfCurrentDayHale5MinFourth * 1.0f));
        float percentCurrentDayWaterHale5MinFourth = (currentDayLitreOfWaterHale5MinFourth / (countHensOfCurrentDayHale5MinFourth * 1.0f));

        model.addAttribute("currentDayHale5MinFourth", LocalDate.now().minusDays(4));
        model.addAttribute("currentDayKgOfFodderHale5MinFourth", currentDayKgOfFodderHale5MinFourth);
        model.addAttribute("percentCurrentDayHale5MinFourth"
                , String.format("%.4f" + " гр.",percentCurrentDayHale5MinFourth));
        model.addAttribute("percentCurrentDayWaterHale5MinFourth"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale5MinFourth));

        // За текущия ден -4 Хале 6 Силоз 6
        Long lastDayEatenFodderHale6MinFourth = eatenFodderAndWaterService.findLastRecordsByCategoryHale6MinFourth();
        Long countHensOfCurrentDayHale6MinFourth = hensAddService.getCountOfHensSixAboutCurrentDayMinusFourth();
        Long currentDayKgOfFodderHale6MinFourth = fodderService.getKgOfFodderSilo6MinFourth();
        Long currentDayLitreOfWaterHale6MinFourth = eatenFodderAndWaterService.getLitreOfWaterHale6MinFourth();

        float percentCurrentDayHale6MinFourth = (lastDayEatenFodderHale6MinFourth / (countHensOfCurrentDayHale6MinFourth * 1.0f));
        float percentCurrentDayWaterHale6MinFourth = (currentDayLitreOfWaterHale6MinFourth / (countHensOfCurrentDayHale6MinFourth * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale6MinFourth", currentDayKgOfFodderHale6MinFourth);
        model.addAttribute("percentCurrentDayHale6MinFourth"
                , String.format("%.4f" + " гр.",percentCurrentDayHale6MinFourth));
        model.addAttribute("percentCurrentDayWaterHale6MinFourth"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale6MinFourth));

        // За текущия ден -4 Хале 7 Силоз 7
        Long lastDayEatenFodderHale7MinFourth = eatenFodderAndWaterService.findLastRecordsByCategoryHale7MinFourth();
        Long countHensOfCurrentDayHale7MinFourth = hensAddService.getCountOfHensSevenAboutCurrentDayMinusFourth();
        Long currentDayKgOfFodderHale7MinFourth = fodderService.getKgOfFodderSilo7MinFourth();
        Long currentDayLitreOfWaterHale7MinFourth = eatenFodderAndWaterService.getLitreOfWaterHale7MinFourth();

        float percentCurrentDayHale7MinFourth = (lastDayEatenFodderHale7MinFourth / (countHensOfCurrentDayHale7MinFourth * 1.0f));
        float percentCurrentDayWaterHale7MinFourth = (currentDayLitreOfWaterHale7MinFourth / (countHensOfCurrentDayHale7MinFourth * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale7MinFourth", currentDayKgOfFodderHale7MinFourth);
        model.addAttribute("percentCurrentDayHale7MinFourth"
                , String.format("%.4f" + " гр.",percentCurrentDayHale7MinFourth));
        model.addAttribute("percentCurrentDayWaterHale7MinFourth"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale7MinFourth));

        // За текущия ден -4 Хале 8 Силоз 8
        Long lastDayEatenFodderHale8MinFourth = eatenFodderAndWaterService.findLastRecordsByCategoryHale8MinFourth();
        Long countHensOfCurrentDayHale8MinFourth = hensAddService.getCountOfHensEightAboutCurrentDayMinusFourth();
        Long currentDayKgOfFodderHale8MinFourth = fodderService.getKgOfFodderSilo8MinFourth();
        Long currentDayLitreOfWaterHale8MinFourth = eatenFodderAndWaterService.getLitreOfWaterHale8MinFourth();

        float percentCurrentDayHale8MinFourth = (lastDayEatenFodderHale8MinFourth / (countHensOfCurrentDayHale8MinFourth * 1.0f));
        float percentCurrentDayWaterHale8MinFourth = (currentDayLitreOfWaterHale8MinFourth / (countHensOfCurrentDayHale8MinFourth * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale8MinFourth", currentDayKgOfFodderHale8MinFourth);
        model.addAttribute("percentCurrentDayHale8MinFourth"
                , String.format("%.4f" + " гр.",percentCurrentDayHale8MinFourth));
        model.addAttribute("percentCurrentDayWaterHale8MinFourth"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale8MinFourth));

        // За текущия ден -4 Хале 9 Силоз 9
        Long lastDayEatenFodderHale9MinFourth = eatenFodderAndWaterService.findLastRecordsByCategoryHale9MinFourth();
        Long countHensOfCurrentDayHale9MinFourth = hensAddService.getCountOfHensNinthAboutCurrentDayMinusFourth();
        Long currentDayKgOfFodderHale9MinFourth = fodderService.getKgOfFodderSilo9MinFourth();
        Long currentDayLitreOfWaterHale9MinFourth = eatenFodderAndWaterService.getLitreOfWaterHale9MinFourth();

        float percentCurrentDayHale9MinFourth = (lastDayEatenFodderHale9MinFourth / (countHensOfCurrentDayHale9MinFourth * 1.0f));
        float percentCurrentDayWaterHale9MinFourth = (currentDayLitreOfWaterHale9MinFourth / (countHensOfCurrentDayHale9MinFourth * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale9MinFourth", currentDayKgOfFodderHale9MinFourth);
        model.addAttribute("percentCurrentDayHale9MinFourth"
                , String.format("%.4f" + " гр.",percentCurrentDayHale9MinFourth));
        model.addAttribute("percentCurrentDayWaterHale9MinFourth"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale9MinFourth));

        // За текущия ден -5 Хале 5 Силоз 5
        Long lastDayEatenFodderHale5MinFive = eatenFodderAndWaterService.findLastRecordsByCategoryHale5MinFive();
        Long countHensOfCurrentDayHale5MinFive = hensAddService.getCountOfHensFiveAboutCurrentDayMinusFive();
        Long currentDayKgOfFodderHale5MinFive = fodderService.getKgOfFodderHale5MinFive();
        Long currentDayLitreOfWaterHale5MinFive = eatenFodderAndWaterService.getLitreOfWaterHale5MinFive();

        float percentCurrentDayHale5MinFive = (lastDayEatenFodderHale5MinFive / (countHensOfCurrentDayHale5MinFive * 1.0f));
        float percentCurrentDayWaterHale5MinFive = (currentDayLitreOfWaterHale5MinFive / (countHensOfCurrentDayHale5MinFive * 1.0f));

        model.addAttribute("currentDayHale5MinFive", LocalDate.now().minusDays(5));
        model.addAttribute("currentDayKgOfFodderHale5MinFive", currentDayKgOfFodderHale5MinFive);
        model.addAttribute("percentCurrentDayHale5MinFive"
                , String.format("%.4f" + " гр.",percentCurrentDayHale5MinFive));
        model.addAttribute("percentCurrentDayWaterHale5MinFive"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale5MinFive));

        // За текущия ден -5 Хале 6 Силоз 6
        Long lastDayEatenFodderHale6MinFive = eatenFodderAndWaterService.findLastRecordsByCategoryHale6MinFive();
        Long countHensOfCurrentDayHale6MinFive = hensAddService.getCountOfHensSixAboutCurrentDayMinusFive();
        Long currentDayKgOfFodderHale6MinFive = fodderService.getKgOfFodderSilo6MinFive();
        Long currentDayLitreOfWaterHale6MinFive = eatenFodderAndWaterService.getLitreOfWaterHale6MinFive();

        float percentCurrentDayHale6MinFive = (lastDayEatenFodderHale6MinFive / (countHensOfCurrentDayHale6MinFive * 1.0f));
        float percentCurrentDayWaterHale6MinFive = (currentDayLitreOfWaterHale6MinFive / (countHensOfCurrentDayHale6MinFive * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale6MinFive", currentDayKgOfFodderHale6MinFive);
        model.addAttribute("percentCurrentDayHale6MinFive"
                , String.format("%.4f" + " гр.",percentCurrentDayHale6MinFive));
        model.addAttribute("percentCurrentDayWaterHale6MinFive"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale6MinFive));

        // За текущия ден -5 Хале 7 Силоз 7
        Long lastDayEatenFodderHale7MinFive = eatenFodderAndWaterService.findLastRecordsByCategoryHale7MinFive();
        Long countHensOfCurrentDayHale7MinFive = hensAddService.getCountOfHensSevenAboutCurrentDayMinusFive();
        Long currentDayKgOfFodderHale7MinFive = fodderService.getKgOfFodderSilo7MinFive();
        Long currentDayLitreOfWaterHale7MinFive = eatenFodderAndWaterService.getLitreOfWaterHale7MinFive();

        float percentCurrentDayHale7MinFive = (lastDayEatenFodderHale7MinFive / (countHensOfCurrentDayHale7MinFive * 1.0f));
        float percentCurrentDayWaterHale7MinFive = (currentDayLitreOfWaterHale7MinFive / (countHensOfCurrentDayHale7MinFive * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale7MinFive", currentDayKgOfFodderHale7MinFive);
        model.addAttribute("percentCurrentDayHale7MinFive"
                , String.format("%.4f" + " гр.",percentCurrentDayHale7MinFive));
        model.addAttribute("percentCurrentDayWaterHale7MinFive"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale7MinFive));

        // За текущия ден -5 Хале 8 Силоз 8
        Long lastDayEatenFodderHale8MinFive = eatenFodderAndWaterService.findLastRecordsByCategoryHale8MinFive();
        Long countHensOfCurrentDayHale8MinFive = hensAddService.getCountOfHensEightAboutCurrentDayMinusFive();
        Long currentDayKgOfFodderHale8MinFive = fodderService.getKgOfFodderSilo8MinFive();
        Long currentDayLitreOfWaterHale8MinFive = eatenFodderAndWaterService.getLitreOfWaterHale8MinFive();

        float percentCurrentDayHale8MinFive = (lastDayEatenFodderHale8MinFive / (countHensOfCurrentDayHale8MinFive * 1.0f));
        float percentCurrentDayWaterHale8MinFive = (currentDayLitreOfWaterHale8MinFive / (countHensOfCurrentDayHale8MinFive * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale8MinFive", currentDayKgOfFodderHale8MinFive);
        model.addAttribute("percentCurrentDayHale8MinFive"
                , String.format("%.4f" + " гр.",percentCurrentDayHale8MinFive));
        model.addAttribute("percentCurrentDayWaterHale8MinFive"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale8MinFive));

        // За текущия ден -5 Хале 9 Силоз 9
        Long lastDayEatenFodderHale9MinFive = eatenFodderAndWaterService.findLastRecordsByCategoryHale9MinFive();
        Long countHensOfCurrentDayHale9MinFive = hensAddService.getCountOfHensNinthAboutCurrentDayMinusFive();
        Long currentDayKgOfFodderHale9MinFive = fodderService.getKgOfFodderSilo9MinFive();
        Long currentDayLitreOfWaterHale9MinFive = eatenFodderAndWaterService.getLitreOfWaterHale9MinFive();

        float percentCurrentDayHale9MinFive = (lastDayEatenFodderHale9MinFive / (countHensOfCurrentDayHale9MinFive * 1.0f));
        float percentCurrentDayWaterHale9MinFive = (currentDayLitreOfWaterHale9MinFive / (countHensOfCurrentDayHale9MinFive * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale9MinFive", currentDayKgOfFodderHale9MinFive);
        model.addAttribute("percentCurrentDayHale9MinFive"
                , String.format("%.4f" + " гр.",percentCurrentDayHale9MinFive));
        model.addAttribute("percentCurrentDayWaterHale9MinFive"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale9MinFive));

        // За текущия ден -6  Хале 5 Силоз 5
        Long lastDayEatenFodderHale5MinSix = eatenFodderAndWaterService.findLastRecordsByCategoryHale5MinSix();
        Long countHensOfCurrentDayHale5MinSix = hensAddService.getCountOfHensFiveAboutCurrentDayMinusSix();
        Long currentDayKgOfFodderHale5MinSix = fodderService.getKgOfFodderHale5MinSix();
        Long currentDayLitreOfWaterHale5MinSix = eatenFodderAndWaterService.getLitreOfWaterHale5MinSix();

        float percentCurrentDayHale5MinSix = (lastDayEatenFodderHale5MinSix / (countHensOfCurrentDayHale5MinSix * 1.0f));
        float percentCurrentDayWaterHale5MinSix = (currentDayLitreOfWaterHale5MinSix / (countHensOfCurrentDayHale5MinSix * 1.0f));

        model.addAttribute("currentDayHale5MinSix", LocalDate.now().minusDays(6));
        model.addAttribute("currentDayKgOfFodderHale5MinSix", currentDayKgOfFodderHale5MinSix);
        model.addAttribute("percentCurrentDayHale5MinSix"
                , String.format("%.4f" + " гр.",percentCurrentDayHale5MinSix));
        model.addAttribute("percentCurrentDayWaterHale5MinSix"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale5MinSix));

        // За текущия ден -6 Хале 6 Силоз 6
        Long lastDayEatenFodderHale6MinSix = eatenFodderAndWaterService.findLastRecordsByCategoryHale6MinSix();
        Long countHensOfCurrentDayHale6MinSix = hensAddService.getCountOfHensSixAboutCurrentDayMinusSix();
        Long currentDayKgOfFodderHale6MinSix = fodderService.getKgOfFodderSilo6MinSix();
        Long currentDayLitreOfWaterHale6MinSix = eatenFodderAndWaterService.getLitreOfWaterHale6MinSix();

        float percentCurrentDayHale6MinSix = (lastDayEatenFodderHale6MinSix / (countHensOfCurrentDayHale6MinSix * 1.0f));
        float percentCurrentDayWaterHale6MinSix = (currentDayLitreOfWaterHale6MinSix / (countHensOfCurrentDayHale6MinSix * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale6MinSix", currentDayKgOfFodderHale6MinSix);
        model.addAttribute("percentCurrentDayHale6MinSix"
                , String.format("%.4f" + " гр.",percentCurrentDayHale6MinSix));
        model.addAttribute("percentCurrentDayWaterHale6MinSix"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale6MinSix));

        // За текущия ден -6 Хале 7 Силоз 7
        Long lastDayEatenFodderHale7MinSix = eatenFodderAndWaterService.findLastRecordsByCategoryHale7MinSix();
        Long countHensOfCurrentDayHale7MinSix = hensAddService.getCountOfHensSevenAboutCurrentDayMinusSix();
        Long currentDayKgOfFodderHale7MinSix = fodderService.getKgOfFodderSilo7MinSix();
        Long currentDayLitreOfWaterHale7MinSix = eatenFodderAndWaterService.getLitreOfWaterHale7MinSix();

        float percentCurrentDayHale7MinSix = (lastDayEatenFodderHale7MinSix / (countHensOfCurrentDayHale7MinSix * 1.0f));
        float percentCurrentDayWaterHale7MinSix = (currentDayLitreOfWaterHale7MinSix / (countHensOfCurrentDayHale7MinSix * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale7MinSix", currentDayKgOfFodderHale7MinSix);
        model.addAttribute("percentCurrentDayHale7MinSix"
                , String.format("%.4f" + " гр.",percentCurrentDayHale7MinSix));
        model.addAttribute("percentCurrentDayWaterHale7MinSix"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale7MinSix));

        // За текущия ден -6 Хале 8 Силоз 8
        Long lastDayEatenFodderHale8MinSix = eatenFodderAndWaterService.findLastRecordsByCategoryHale8MinSix();
        Long countHensOfCurrentDayHale8MinSix = hensAddService.getCountOfHensEightAboutCurrentDayMinusSix();
        Long currentDayKgOfFodderHale8MinSix = fodderService.getKgOfFodderSilo8MinSix();
        Long currentDayLitreOfWaterHale8MinSix = eatenFodderAndWaterService.getLitreOfWaterHale8MinSix();

        float percentCurrentDayHale8MinSix = (lastDayEatenFodderHale8MinSix / (countHensOfCurrentDayHale8MinSix * 1.0f));
        float percentCurrentDayWaterHale8MinSix = (currentDayLitreOfWaterHale8MinSix / (countHensOfCurrentDayHale8MinSix * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale8MinSix", currentDayKgOfFodderHale8MinSix);
        model.addAttribute("percentCurrentDayHale8MinSix"
                , String.format("%.4f" + " гр.",percentCurrentDayHale8MinSix));
        model.addAttribute("percentCurrentDayWaterHale8MinSix"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale8MinSix));

        // За текущия ден -6 Хале 9 Силоз 9
        Long lastDayEatenFodderHale9MinSix = eatenFodderAndWaterService.findLastRecordsByCategoryHale9MinSix();
        Long countHensOfCurrentDayHale9MinSix = hensAddService.getCountOfHensNinthAboutCurrentDayMinusSix();
        Long currentDayKgOfFodderHale9MinSix = fodderService.getKgOfFodderSilo9MinSix();
        Long currentDayLitreOfWaterHale9MinSix = eatenFodderAndWaterService.getLitreOfWaterHale9MinSix();

        float percentCurrentDayHale9MinSix = (lastDayEatenFodderHale9MinSix / (countHensOfCurrentDayHale9MinSix * 1.0f));
        float percentCurrentDayWaterHale9MinSix = (currentDayLitreOfWaterHale9MinSix / (countHensOfCurrentDayHale9MinSix * 1.0f));

        model.addAttribute("currentDayKgOfFodderHale9MinSix", currentDayKgOfFodderHale9MinSix);
        model.addAttribute("percentCurrentDayHale9MinSix"
                , String.format("%.4f" + " гр.",percentCurrentDayHale9MinSix));
        model.addAttribute("percentCurrentDayWaterHale9MinSix"
                , String.format("%.4f" + " мл.", percentCurrentDayWaterHale9MinSix));

        return "spravka-fodder-upper";
    }



    @GetMapping("/consuming")
    public String add(Model model, HttpSession httpSession){
        if(!model.containsAttribute("eatenFodderBindingModel")){
            model.addAttribute("eatenFodderBindingModel", new EatenFodderBindingModel());
        }

        return "eaten-fodder";
    }


    @PostMapping("/consuming")
    public String addConfirm(@Valid EatenFodderBindingModel eatenFodderBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("eatenFodderBindingModel", eatenFodderBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.eatenFodderBindingModel", bindingResult);

            return "redirect:consuming";
        }

        eatenFodderAndWaterService.add(modelMapper.map(eatenFodderBindingModel, EatenFodderAndWaterServiceModel.class));

        return "redirect:/home";
    }
}
