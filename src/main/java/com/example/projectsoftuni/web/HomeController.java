package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.binding.HensAddBindingModel;
import com.example.projectsoftuni.model.view.UserViewModel;
import com.example.projectsoftuni.repository.HensAddRepository;
import com.example.projectsoftuni.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class HomeController {

    private final EggAddService eggAddService;
    private final HensAddService hensAddService;
    private final ModelMapper modelMapper;
    private final HensAddBindingModel hensAddBindingModel;
    private final HensAddRepository hensAddRepository;
    private final CartonAddService cartonAddService;
    private final UserService userService;
    private final UserViewModel userViewModel;
    private final ResidueOfExtractionService residueOfExtractionService;

    public HomeController(EggAddService eggAddService, HensAddService hensAddService
            , ModelMapper modelMapper, HensAddBindingModel hensAddBindingModel
            , HensAddRepository hensAddRepository, CartonAddService cartonAddService, UserService userService, UserViewModel userViewModel, ResidueOfExtractionService residueOfExtractionService) {

        this.eggAddService = eggAddService;
        this.hensAddService = hensAddService;
        this.modelMapper = modelMapper;
        this.hensAddBindingModel = hensAddBindingModel;
        this.hensAddRepository = hensAddRepository;
        this.cartonAddService = cartonAddService;
        this.userService = userService;
        this.userViewModel = userViewModel;
        this.residueOfExtractionService = residueOfExtractionService;
    }

    @GetMapping("/")
    public String index(){

        return "index";

    }



    @GetMapping("/home")
    public String home(){

        return "home";

    }

    @GetMapping("/allCountTableByCategory")
    public String AllCountTable(Model model){

        //Base Lower
        //XL
        model.addAttribute("eggXLCoreyLower", eggAddService.findByCategoryXLLower() / 20);
        model.addAttribute("eggXLCartonLower", eggAddService.findByCategoryXLCartonsLower() / 120);
        //L
        model.addAttribute("eggFamilyCoreyLowerL", eggAddService.findCoreyFamilyBaseLowerL() / 30);
        model.addAttribute("eggChezCoreyLowerL", eggAddService.findCoreyChezBaseLowerL() / 30);
        model.addAttribute("eggEuroCoreyLowerL", eggAddService.findCoreyEuroBaseLowerL() / 30);
        model.addAttribute("eggHartmanCoreyLowerL", eggAddService.findCoreyHartmanBaseLowerL() / 30);
        model.addAttribute("eggLCartonLower", eggAddService.findByCategoryLCartonLower() / 180);
        model.addAttribute("eggLCartonLowerBrown", eggAddService.findCartons180BaseLowerBrownL() / 180);
        model.addAttribute("eggLCartonLowerBrown360", eggAddService.findCartons360BaseLowerBrownL() / 360);
        model.addAttribute("eggLCoreyUkraynaLowerL", eggAddService.findCoreyUkraynaLowerL() / 30);
        model.addAttribute("eggLCoreyElpaLowerL", eggAddService.findCoreyElpaLowerL() / 30);
        model.addAttribute("eggLCoreyEkoFarmLowerL", eggAddService.findCoreyEkoFarmLowerL() / 30);
        model.addAttribute("eggLCoreyNew1LowerL", eggAddService.findCoreyNew1LowerL() / 30);
        model.addAttribute("eggLCoreyNew2LowerL", eggAddService.findCoreyNew2LowerL() / 30);

        //M
        model.addAttribute("eggMCartonLower", eggAddService.findByCategoryMCartonLower() / 180);
        model.addAttribute("eggFamilyCoreyLowerM", eggAddService.findCoreyFamilyBaseLowerM() / 30);
        model.addAttribute("eggChezCoreyLowerM", eggAddService.findCoreyChezBaseLowerM() / 30);
        model.addAttribute("eggEuroCoreyLowerM", eggAddService.findCoreyEuroBaseLowerM() / 30);
        model.addAttribute("eggHartmanCoreyLowerM", eggAddService.findCoreyHartmanBaseLowerM() / 30);
        model.addAttribute("eggLCartonMowerBrown", eggAddService.findByCarton180BaseLowerBrownM() / 180);
        model.addAttribute("eggLCartonMowerBrown360", eggAddService.findByCarton360BaseLowerBrownM() / 360);
        model.addAttribute("eggCoreyUkraynaLowerM", eggAddService.findCoreyUkraynaLowerM() / 30);
        model.addAttribute("eggCoreyElpaLowerM", eggAddService.findCoreyElpaLowerM() / 30);
        model.addAttribute("eggCoreyEkoFarmLowerM", eggAddService.findCoreyEkoFarmLowerM() / 30);
        model.addAttribute("eggCoreyNew1LowerM", eggAddService.findCoreyNew1LowerM() / 30);
        model.addAttribute("eggCoreyNew2LowerM", eggAddService.findCoreyNew2LowerM() / 30);

        //S
        model.addAttribute("eggSCartonLower", eggAddService.findByCategorySCartonLower() / 180);
        model.addAttribute("eggFamilyCoreyLowerS", eggAddService.findCoreyFamilyBaseLowerS() / 30);
        model.addAttribute("eggChezCoreyLowerS", eggAddService.findCoreyChezBaseLowerS() / 30);
        model.addAttribute("eggEuroCoreyLowerS", eggAddService.findCoreyEuroBaseLowerS() / 30);
        model.addAttribute("eggHartmanCoreyLowerS", eggAddService.findCoreyHartmanBaseLowerS() / 30);
        model.addAttribute("eggSCartonMowerBrown", eggAddService.findCarton180BaseLowerBrownS() / 180);
        model.addAttribute("eggSCartonMowerBrown360", eggAddService.findCarton360BaseLowerBrownS()/ 360);
        model.addAttribute("eggCoreyUkraynaLowerS", eggAddService.findCoreyUkraynaLowerS() / 30);
        model.addAttribute("eggCoreyElpaLowerS", eggAddService.findCoreyElpaLowerS() / 30);
        model.addAttribute("eggCoreyEkoFarmLowerS", eggAddService.findCoreyEkoFarmLowerS() / 30);
        model.addAttribute("eggCoreyNew1LowerS", eggAddService.findCoreyNew1LowerS() / 30);
        model.addAttribute("eggCoreyNew2LowerS", eggAddService.findCoreyNew2LowerS() / 30);

        //Broken
        model.addAttribute("eggBrokenCartonLower", eggAddService.findByCartonLowerBroken() / 180);
        model.addAttribute("eggFamilyCoreyLowerBr", eggAddService.findCoreyFamilyLowerBroken() / 30);
        model.addAttribute("eggChezCoreyLowerBr", eggAddService.findCoreyChezLowerBroken() / 30);
        model.addAttribute("eggEuroCoreyLowerBr", eggAddService.findCoreyEuroLowerBroken() / 30);
        model.addAttribute("eggHartmanCoreyLowerBr", eggAddService.findCoreyHartmanLowerBroken() / 30);
        model.addAttribute("eggBrCartonMowerBrown", eggAddService.findCarton180BaseLowerBrownBroken() / 180);
        model.addAttribute("eggBrCartonMowerBrown360", eggAddService.findCarton360BaseLowerBrownBroken()/ 360);
        model.addAttribute("eggCoreyUkraynaLowerBROKEN", eggAddService.findCoreyUkraynaLowerBROKEN() / 30);
        model.addAttribute("eggCoreyElpaLowerBROKEN", eggAddService.findCoreyElpaLowerBROKEN() / 30);
        model.addAttribute("eggCoreyEkoFarmLowerBROKEN", eggAddService.findCoreyEkoFarmLowerBROKEN() / 30);
        model.addAttribute("eggCoreyNew1LowerBROKEN", eggAddService.findCoreyNew1LowerBROKEN() / 30);
        model.addAttribute("eggCoreyNew2LowerBROKEN", eggAddService.findCoreyNew2LowerBROKEN() / 30);


        //Base Upper
        //XL
        model.addAttribute("eggXLCoreyUpper", eggAddService.findByCategoryXLUpper() / 20);
        model.addAttribute("eggXLCartonUpper", eggAddService.findByCategoryXLCartonsUpper() / 120);
        //L
        model.addAttribute("eggFamilyCoreyUpperL", eggAddService.findCoreyFamilyUpperL() / 30);
        model.addAttribute("eggChezCoreyUpperL", eggAddService.findCoreyChezUpperL() / 30);
        model.addAttribute("eggEuroCoreyUpperL", eggAddService.findCoreyEuroUpperL() / 30);
        model.addAttribute("eggHartmanCoreyUpperL", eggAddService.findCoreyHartmanUpperL() / 30);
        model.addAttribute("eggLCartonUpper", eggAddService.findByCategoryLCartonsUpper() / 180);
        model.addAttribute("eggLCartonUpperBrown", eggAddService.findCarton180UpperBrownL() / 180);
        model.addAttribute("eggLCartonUpperBrown360", eggAddService.findCarton360UpperBrownL() / 360);
        model.addAttribute("eggCoreyUkraynaUpperL", eggAddService.findCoreyUkraynaUpperL() / 30);
        model.addAttribute("eggCoreyElpaUpperL", eggAddService.findCoreyElpaUpperL() / 30);
        model.addAttribute("eggCoreyEkoFarmUpperL", eggAddService.findCoreyEkoFarmUpperL() / 30);
        model.addAttribute("eggCoreyNew1UpperL", eggAddService.findCoreyNew1UpperL() / 30);
        model.addAttribute("eggCoreyNew2UpperL", eggAddService.findCoreyNew2UpperL() / 30);


        //M
        model.addAttribute("eggFamilyCoreyUpperM", eggAddService.findCoreyFamilyUpperM() / 30);
        model.addAttribute("eggChezCoreyUpperM", eggAddService.findCoreyChezUpperM() / 30);
        model.addAttribute("eggEuroCoreyUpperM", eggAddService.findCoreyEuroUpperM() / 30);
        model.addAttribute("eggHartmanCoreyUpperM", eggAddService.findCoreyHartmanUpperM() / 30);
        model.addAttribute("eggMCartonUpper", eggAddService.findByCategoryMCartonsUpper() / 180);
        model.addAttribute("eggMCartonUpperBrown", eggAddService.findCarton180UpperBrownM() / 180);
        model.addAttribute("eggMCartonUpperBrown360", eggAddService.findCarton360UpperBrownM() / 360);
        model.addAttribute("eggCoreyUkraynaUpperM", eggAddService.findCoreyUkraynaUpperM() / 30);
        model.addAttribute("eggCoreyElpaUpperM", eggAddService.findCoreyElpaUpperM() / 30);
        model.addAttribute("eggCoreyEkoFarmUpperM", eggAddService.findCoreyEkoFarmUpperM() / 30);
        model.addAttribute("eggCoreyNew1UpperM", eggAddService.findCoreyNew1UpperM() / 30);
        model.addAttribute("eggCoreyNew2UpperM", eggAddService.findCoreyNew2UpperM() / 30);

        //S
        model.addAttribute("eggFamilyCoreyUpperS", eggAddService.findCoreyFamilyUpperS() / 30);
        model.addAttribute("eggChezCoreyUpperS", eggAddService.findCoreyChezUpperS() / 30);
        model.addAttribute("eggEuroCoreyUpperS", eggAddService.findCoreyEuroUpperS() / 30);
        model.addAttribute("eggHartmanCoreyUpperS", eggAddService.findCoreyHartmanUpperS() / 30);
        model.addAttribute("eggSCartonUpper", eggAddService.findByCategorySCartonUpper() / 180);
        model.addAttribute("eggSCartonUpperBrown", eggAddService.findCarton180UpperBrownS() / 180);
        model.addAttribute("eggSCartonUpperBrown360", eggAddService.findCarton360UpperBrownS() / 360);
        model.addAttribute("eggCoreyUkraynaUpperS", eggAddService.findCoreyUkraynaUpperS() / 30);
        model.addAttribute("eggCoreyElpaUpperS", eggAddService.findCoreyElpaUpperS() / 30);
        model.addAttribute("eggCoreyEkoFarmUpperS", eggAddService.findCoreyEkoFarmUpperS() / 30);
        model.addAttribute("eggCoreyNew1UpperS", eggAddService.findCoreyNew1UpperS() / 30);
        model.addAttribute("eggCoreyNew2UpperS", eggAddService.findCoreyNew2UpperS() / 30);

        //Broken
        model.addAttribute("eggBrokenCartonUpper", eggAddService.findCartonUpperBroken() / 180);
        model.addAttribute("eggFamilyCoreyUpperBr", eggAddService.findCoreyFamilyUpperBroken() / 30);
        model.addAttribute("eggChezCoreyUpperBr", eggAddService.findCoreyChezUpperBroken() / 30);
        model.addAttribute("eggEuroCoreyUpperBr", eggAddService.findCoreyEuroUpperBroken() / 30);
        model.addAttribute("eggHartmanCoreyUpperBr", eggAddService.findCoreyHartmanUpperBroken() / 30);
        model.addAttribute("eggBrCartonUpperBrown", eggAddService.findCarton180BaseUpperBrownBroken() / 180);
        model.addAttribute("eggBrCartonUpperBrown360", eggAddService.findCarton360BaseUpperBrownBroken()/ 360);
        model.addAttribute("eggCoreyUkraynaUpperBROKEN", eggAddService.findCoreyUkraynaUpperBROKEN() / 30);
        model.addAttribute("eggCoreyElpaUpperBROKEN", eggAddService.findCoreyElpaUpperBROKEN() / 30);
        model.addAttribute("eggCoreyEkoFarmUpperBROKEN", eggAddService.findCoreyEkoFarmUpperBROKEN() / 30);
        model.addAttribute("eggCoreyNew1UpperBROKEN", eggAddService.findCoreyNew1UpperBROKEN() / 30);
        model.addAttribute("eggCoreyNew2UpperBROKEN", eggAddService.findCoreyNew2UpperBROKEN() / 30);


        // За брой яйца По категории на яйцата за база 1 + 2

     //   model.addAttribute("countXL", eggAddService.findByCategoryXL());
     //   model.addAttribute("countL", eggAddService.findByCategoryL());
     //   model.addAttribute("countM", eggAddService.findByCategoryM());
     //   model.addAttribute("countS", eggAddService.findByCategoryS());
     //   model.addAttribute("countBROKEN", eggAddService.findByCategoryBROKEN());
//
//
     //   model.addAttribute("countXLCarton", eggAddService.findByCategoryXL() / 120);
     //   model.addAttribute("countLCarton", eggAddService.findByCategoryL() / 180);
     //   model.addAttribute("countMCarton", eggAddService.findByCategoryM() / 180);
     //   model.addAttribute("countSCarton", eggAddService.findByCategoryS() / 180);
     //   model.addAttribute("countBROKENCarton", eggAddService.findByCategoryBROKEN() / 180);


        return "allCountTableByCategory";
    }

    @GetMapping("/count-hens-now")
    public String countHensNow(Model model){

        model.addAttribute("countFIRST", hensAddService.getCountOfHnesFirstLast());
        model.addAttribute("countSECOND", hensAddService.getCountOfHensSecondLast());
        model.addAttribute("countTHIRD", hensAddService.getCountOfHensThirdLast());
        model.addAttribute("countFOURTH", hensAddService.getCountOfHensFourthLast());
        model.addAttribute("countFIFTH", hensAddService.getCountOfHensFifthLast());
        model.addAttribute("countSIXTH", hensAddService.getCountOfHensSixthLast());
        model.addAttribute("countSEVENTH", hensAddService.getCountOfHensSeventhLast());
        model.addAttribute("countEIGHT", hensAddService.getCountOfHensEighthLast());
        model.addAttribute("countNINTH", hensAddService.getCountOfHensNinthLast());

        return "count-hens-now";
    }

    @GetMapping("/count-cartons-now")
    public String allCartonsCount(Model model){

        //Upper Base
        model.addAttribute("countCorey120Upper",cartonAddService.getCountOfCore120FromBaseUpper());
        model.addAttribute("countCarton120Upper", cartonAddService.getCountOfCarton120FromBaseUpper());
        model.addAttribute("countCarton180Upper", cartonAddService.getCountOfCarton180FromBaseUpper());
        model.addAttribute("countCoreyFamilyUpper", cartonAddService.getCountCoreyFamilyUpper());
        model.addAttribute("countCoreyChezUpper", cartonAddService.getCountCoreyChezUpper());
        model.addAttribute("countCoreyHartmanUpper", cartonAddService.getCountCoreyHartmanUpper());
        model.addAttribute("countCoreyEuroUpper", cartonAddService.getCountCoreyEuroUpper());
        model.addAttribute("countCarton180BrownUpper", cartonAddService.getCountOfCarton180FromBaseUpperBrown());
        model.addAttribute("countCarton360BrownUpper", cartonAddService.getCountOfCarton360FromBaseUpperBrown());
        model.addAttribute("countPaperDunapackUpper", cartonAddService.getCountPaperDunapackUpper());
        model.addAttribute("countPaperDSmitkUpper", cartonAddService.getCountPaperDSmitkUpper());
        model.addAttribute("countCornerDunapackUpper", cartonAddService.getCountCornerDunapackUpper());
        model.addAttribute("countCornerDSmitkUpper", cartonAddService.getCountCornerDSmitkUpper());
        model.addAttribute("countCoreyUkraynaUpper", cartonAddService.getCountCoreyUkraynaUpper());
        model.addAttribute("countCoreyElpaUpper", cartonAddService.getCountCoreyElpaUpper());
        model.addAttribute("countCoreyEkoFarmUpper", cartonAddService.getCountCoreyEkoFarmUpper());
        model.addAttribute("countCoreyNew1Upper", cartonAddService.getCountCoreyNew1Upper());
        model.addAttribute("countCoreyNew2Upper", cartonAddService.getCountCoreyNew2Upper());


        //Lower Base
        model.addAttribute("countCorey20Lower",cartonAddService.getCountOfCore120FromBaseLower());
        model.addAttribute("countCarton120Lower", cartonAddService.getCountOfCarton120FromBaseLower());
        model.addAttribute("countCarton180Lower", cartonAddService.getCountOfCarton180FromBaseLower());
        model.addAttribute("countCoreyFamilyLower", cartonAddService.getCountCoreyFamilyLower());
        model.addAttribute("countCoreyChezLower", cartonAddService.getCountCoreyChezLower());
        model.addAttribute("countCoreyHartmanLower", cartonAddService.getCountCoreyHartmanLower());
        model.addAttribute("countCoreyEuroLower", cartonAddService.getCountCoreyEuroLower());
        model.addAttribute("countCarton180BrownLower", cartonAddService.getCountOfCarton180FromBaseLowerBrown());
        model.addAttribute("countCarton360BrownLower", cartonAddService.getCountOfCarton360FromBaseLowerBrown());
        model.addAttribute("countPaperDunapackLower", cartonAddService.getCountPaperDunapackLower());
        model.addAttribute("countPaperDSmitkLower", cartonAddService.getCountPaperDSmitkLower());
        model.addAttribute("countCornerDunapackLower", cartonAddService.getCountCornerDunapackLower());
        model.addAttribute("countCornerDSmitkLower", cartonAddService.getCountCornerDSmitkLower());
        model.addAttribute("countCoreyUkraynaLower", cartonAddService.getCountCoreyUkraynaLower());
        model.addAttribute("countCoreyElpaLower", cartonAddService.getCountCoreyElpaLower());
        model.addAttribute("countCoreyEkoFarmLower", cartonAddService.getCountCoreyEkoFarmLower());
        model.addAttribute("countCoreyNew1Lower", cartonAddService.getCountCoreyNew1Lower());
        model.addAttribute("countCoreyNew2Lower", cartonAddService.getCountCoreyNew2Lower());


        return "count-cartons-now";
    }

    @GetMapping("/percentage-table")
    public String percentage(Model model){

        //За броя на яйцата от Първо хале от текущия ден
        Long countEggOfFirstHaleByDescDateCurrentDay
                = eggAddService.findByHaleFirstAndDateDescCurrentDay();

        Long countHensOfFirstHaleByDescDateCurrentDay
                = hensAddService.getCountOfHensFirstAboutCurrentDay();

        float percentHaleFirstCurrentDay
                = (countEggOfFirstHaleByDescDateCurrentDay / (countHensOfFirstHaleByDescDateCurrentDay * 1.0f)) * 100;

        model.addAttribute("currentDay", LocalDate.now());
        model.addAttribute("countEggOfFirstHaleByDescDate"
                , String.format("%.2f",percentHaleFirstCurrentDay));

        //За текущия ден - 1 ден
        Long countEggOfFirstHaleByDescDateCurrentDayMinusOneDay
                = eggAddService.findFirstAndDateDescMinusOneDay();

        Long countHensOfFirstHaleByDescDateCurrentDayMinusOne
                = hensAddService.getCountOfHensFirstAboutCurrentDayMinusOne();

        float percentHaleFirstCurrentDayMinusOne
                = (countEggOfFirstHaleByDescDateCurrentDayMinusOneDay / (countHensOfFirstHaleByDescDateCurrentDayMinusOne * 1.0f)) * 100;

        model.addAttribute("currentDayMinusOne", LocalDate.now().minusDays(1));
        model.addAttribute("countEggOfFirstHaleByDescDateMinusOne"
                , String.format("%.2f",percentHaleFirstCurrentDayMinusOne));

        //За текущия ден - 2 дни
        Long countEggOfFirstHaleByDescDateCurrentDayMinusTwoDay
                = eggAddService.findFirstAndDateDescMinusTwoDay();

        Long countHensOfFirstHaleByDescDateCurrentDayMinusTwo
                = hensAddService.getCountOfHensFirstAboutCurrentDayMinusTwo();

        float percentHaleFirstCurrentDayMinusTwo
                = (countEggOfFirstHaleByDescDateCurrentDayMinusTwoDay / (countHensOfFirstHaleByDescDateCurrentDayMinusTwo * 1.0f)) * 100;

        model.addAttribute("currentDayMinusTwo", LocalDate.now().minusDays(2));
        model.addAttribute("countEggOfFirstHaleByDescDateMinusTwo"
                , String.format("%.2f",percentHaleFirstCurrentDayMinusTwo));

        //За текущия ден - 3 дни
        Long countEggOfFirstHaleByDescDateCurrentDayMinusThreeDay
                = eggAddService.findFirstAndDateDescMinusThreeDay();

        Long countHensOfFirstHaleByDescDateCurrentDayMinusThree
                = hensAddService.getCountOfHensFirstAboutCurrentDayMinusThree();

        float percentHaleFirstCurrentDayMinusThree
                = (countEggOfFirstHaleByDescDateCurrentDayMinusThreeDay/ (countHensOfFirstHaleByDescDateCurrentDayMinusThree
                * 1.0f)) * 100;

        model.addAttribute("currentDayMinusThree", LocalDate.now().minusDays(3));
        model.addAttribute("countEggOfFirstHaleByDescDateMinusThree"
                , String.format("%.2f",percentHaleFirstCurrentDayMinusThree));

        //За текущия ден - 4 дни
        Long countEggOfFirstHaleByDescDateCurrentDayMinusFourthDay
                = eggAddService.findFirstAndDateDescMinusFourthDay();

        Long countHensOfFirstHaleByDescDateCurrentDayMinusFourth
                = hensAddService.getCountOfHensFirstAboutCurrentDayMinusFourth();

        float percentHaleFirstCurrentDayMinusFourth
                = (countEggOfFirstHaleByDescDateCurrentDayMinusFourthDay / (countHensOfFirstHaleByDescDateCurrentDayMinusFourth * 1.0f)) * 100;

        model.addAttribute("currentDayMinusFourth", LocalDate.now().minusDays(4));
        model.addAttribute("countEggOfFirstHaleByDescDateMinusFourth"
                , String.format("%.2f",percentHaleFirstCurrentDayMinusFourth));

        //За текущия ден - 5 дни
        Long countEggOfFirstHaleByDescDateCurrentDayMinusFiveDay
                = eggAddService.findFirstAndDateDescMinusFiveDay();

        Long countHensOfFirstHaleByDescDateCurrentDayMinusFive
                = hensAddService.getCountOfHensFirstAboutCurrentDayMinusFive();

        float percentHaleFirstCurrentDayMinusFive
                = (countEggOfFirstHaleByDescDateCurrentDayMinusFiveDay / (countHensOfFirstHaleByDescDateCurrentDayMinusFive * 1.0f)) * 100;

        model.addAttribute("currentDayMinusFive", LocalDate.now().minusDays(5));
        model.addAttribute("countEggOfFirstHaleByDescDateMinusFive"
                , String.format("%.2f",percentHaleFirstCurrentDayMinusFive));

        //За текущия ден - 6 дни
        Long countEggOfFirstHaleByDescDateCurrentDayMinusSixDay
                = eggAddService.findFirstAndDateDescMinusSixDay();

        Long countHensOfFirstHaleByDescDateCurrentDayMinusSix
                = hensAddService.getCountOfHensFirstAboutCurrentDayMinusSix();

        float percentHaleFirstCurrentDayMinusSix
                = (countEggOfFirstHaleByDescDateCurrentDayMinusSixDay / (countHensOfFirstHaleByDescDateCurrentDayMinusSix * 1.0f)) * 100;

        model.addAttribute("currentDayMinusSix", LocalDate.now().minusDays(6));
        model.addAttribute("countEggOfFirstHaleByDescDateMinusSix"
                , String.format("%.2f",percentHaleFirstCurrentDayMinusSix));

        //За текущия ден - 7 дни
        Long countEggOfFirstHaleByDescDateCurrentDayMinusSevenDay
                = eggAddService.findFirstAndDateDescMinusSevenDay();

        Long countHensOfFirstHaleByDescDateCurrentDayMinusSeven
                = hensAddService.getCountOfHensFirstAboutCurrentDayMinusSeven();

        float percentHaleFirstCurrentDayMinusSeven
                = (countEggOfFirstHaleByDescDateCurrentDayMinusSevenDay / (countHensOfFirstHaleByDescDateCurrentDayMinusSeven * 1.0f)) * 100;

        model.addAttribute("currentDayMinusSeven", LocalDate.now().minusDays(7));
        model.addAttribute("countEggOfFirstHaleByDescDateMinusSeven"
                , String.format("%.2f",percentHaleFirstCurrentDayMinusSeven));


        //За броя на яйцата от Второ хале от текущия ден
        Long countEggOfSecondHaleByDescDateCurrentDay
                = eggAddService.findByHaleSecondAndDateDescCurrentDay();

        Long countHensOfSecondHaleByDescDateCurrentDay
                = hensAddService.getCountOfHensSecondAboutCurrentDay();

        float percentHaleSecondCurrentDay
                = (countEggOfSecondHaleByDescDateCurrentDay / (countHensOfSecondHaleByDescDateCurrentDay * 1.0f)) * 100;

        model.addAttribute("countEggOfSecondHaleByDescDate"
                , String.format("%.2f",percentHaleSecondCurrentDay));

        //За текущия ден - 1 ден
        Long countEggOfSecondHaleByDescDateCurrentDayMinusOneDay
                = eggAddService.findSecondAndDateDescMinusOneDay();

        Long countHensOfSecondHaleByDescDateCurrentDayMinusOne
                = hensAddService.getCountOfHensSecondAboutCurrentDayMinusOne();

        float percentHaleSecondCurrentDayMinusOne
                = (countEggOfSecondHaleByDescDateCurrentDayMinusOneDay / (countHensOfSecondHaleByDescDateCurrentDayMinusOne * 1.0f)) * 100;

        model.addAttribute("countEggOfSecondHaleByDescDateMinusOne"
                , String.format("%.2f",percentHaleSecondCurrentDayMinusOne));

        //За текущия ден - 2 дни
        Long countEggOfSecondHaleByDescDateCurrentDayMinusTwoDay
                = eggAddService.findSecondAndDateDescMinusTwoDay();

        Long countHensOfSecondHaleByDescDateCurrentDayMinusTwo
                = hensAddService.getCountOfHensSecondAboutCurrentDayMinusTwo();

        float percentHaleSecondCurrentDayMinusTwo
                = (countEggOfSecondHaleByDescDateCurrentDayMinusTwoDay / (countHensOfSecondHaleByDescDateCurrentDayMinusTwo * 1.0f)) * 100;

        model.addAttribute("countEggOfSecondHaleByDescDateMinusTwo"
                , String.format("%.2f",percentHaleSecondCurrentDayMinusTwo));

        //За текущия ден - 3 дни
        Long countEggOfSecondHaleByDescDateCurrentDayMinusThreeDay
                = eggAddService.findSecondAndDateDescMinusThreeDay();

        Long countHensOfSecondHaleByDescDateCurrentDayMinusThree
                = hensAddService.getCountOfHensSecondAboutCurrentDayMinusThree();

        float percentHaleSecondCurrentDayMinusThree
                = (countEggOfSecondHaleByDescDateCurrentDayMinusThreeDay / (countHensOfSecondHaleByDescDateCurrentDayMinusThree
                * 1.0f)) * 100;

        model.addAttribute("countEggOfSecondHaleByDescDateMinusThree"
                , String.format("%.2f",percentHaleSecondCurrentDayMinusThree));

        //За текущия ден - 4 дни
        Long countEggOfSecondHaleByDescDateCurrentDayMinusFourthDay
                = eggAddService.findSecondAndDateDescMinusFourthDay();

        Long countHensOfSecondHaleByDescDateCurrentDayMinusFourth
                = hensAddService.getCountOfHensSecondAboutCurrentDayMinusFourth();

        float percentHaleSecondCurrentDayMinusFourth
                = (countEggOfSecondHaleByDescDateCurrentDayMinusFourthDay/ (countHensOfSecondHaleByDescDateCurrentDayMinusFourth * 1.0f)) * 100;

        model.addAttribute("countEggOfSecondHaleByDescDateMinusFourth"
                , String.format("%.2f",percentHaleSecondCurrentDayMinusFourth));

        //За текущия ден - 5 дни
        Long countEggOfSecondHaleByDescDateCurrentDayMinusFiveDay
                = eggAddService.findSecondAndDateDescMinusFiveDay();

        Long countHensOfSecondHaleByDescDateCurrentDayMinusFive
                = hensAddService.getCountOfHensSecondAboutCurrentDayMinusFive();

        float percentHaleSecondCurrentDayMinusFive
                = (countEggOfSecondHaleByDescDateCurrentDayMinusFiveDay / (countHensOfSecondHaleByDescDateCurrentDayMinusFive * 1.0f)) * 100;

        model.addAttribute("countEggOfSecondHaleByDescDateMinusFive"
                , String.format("%.2f",percentHaleSecondCurrentDayMinusFive));

        //За текущия ден - 6 дни
        Long countEggOfSecondHaleByDescDateCurrentDayMinusSixDay
                = eggAddService.findSecondAndDateDescMinusSixDay();

        Long countHensOfSecondHaleByDescDateCurrentDayMinusSix
                = hensAddService.getCountOfHensSecondAboutCurrentDayMinusSix();

        float percentHaleSecondCurrentDayMinusSix
                = (countEggOfSecondHaleByDescDateCurrentDayMinusSixDay / (countHensOfSecondHaleByDescDateCurrentDayMinusSix * 1.0f)) * 100;

        model.addAttribute("countEggOfSecondHaleByDescDateMinusSix"
                , String.format("%.2f",percentHaleSecondCurrentDayMinusSix));

        //За текущия ден - 7 дни
        Long countEggOfSecondHaleByDescDateCurrentDayMinusSevenDay
                = eggAddService.findSecondAndDateDescMinusSevenDay();

        Long countHensOfSecondHaleByDescDateCurrentDayMinusSeven
                = hensAddService.getCountOfHensSecondAboutCurrentDayMinusSeven();

        float percentHaleSecondCurrentDayMinusSeven
                = (countEggOfSecondHaleByDescDateCurrentDayMinusSevenDay / (countHensOfSecondHaleByDescDateCurrentDayMinusSeven * 1.0f)) * 100;

        model.addAttribute("countEggOfSecondHaleByDescDateMinusSeven"
                , String.format("%.2f",percentHaleSecondCurrentDayMinusSeven));


        //За броя на яйцата от Трето хале от текущия ден
        Long countEggOfThirdHaleByDescDateCurrentDay
                = eggAddService.findByHaleThirdAndDateDescCurrentDay();

        Long countHensOfThirdHaleByDescDateCurrentDay
                = hensAddService.getCountOfHensThirdAboutCurrentDay();

        float percentHaleThirdCurrentDay
                = (countEggOfThirdHaleByDescDateCurrentDay / (countHensOfThirdHaleByDescDateCurrentDay * 1.0f)) * 100;

        model.addAttribute("countEggOfThirdHaleByDescDate"
                , String.format("%.2f",percentHaleThirdCurrentDay));

        //За текущия ден - 1 ден
        Long countEggOfThirdHaleByDescDateCurrentDayMinusOneDay
                = eggAddService.findThirdAndDateDescMinusOneDay();

        Long countHensOfThirdHaleByDescDateCurrentDayMinusOne
                = hensAddService.getCountOfHensThirdAboutCurrentDayMinusOne();

        float percentHaleThirdCurrentDayMinusOne
                = (countEggOfThirdHaleByDescDateCurrentDayMinusOneDay / (countHensOfThirdHaleByDescDateCurrentDayMinusOne * 1.0f)) * 100;

        model.addAttribute("countEggOfThirdHaleByDescDateMinusOne"
                , String.format("%.2f",percentHaleThirdCurrentDayMinusOne));

        //За текущия ден - 2 дни
        Long countEggOfThirdHaleByDescDateCurrentDayMinusTwoDay
                = eggAddService.findThirdAndDateDescMinusTwoDay();

        Long countHensOfThirdHaleByDescDateCurrentDayMinusTwo
                = hensAddService.getCountOfHensThirdAboutCurrentDayMinusTwo();

        float percentHaleThirdCurrentDayMinusTwo
                = (countEggOfThirdHaleByDescDateCurrentDayMinusTwoDay / (countHensOfThirdHaleByDescDateCurrentDayMinusTwo * 1.0f)) * 100;

        model.addAttribute("countEggOfThirdHaleByDescDateMinusTwo"
                , String.format("%.2f",percentHaleThirdCurrentDayMinusTwo));

        //За текущия ден - 3 дни
        Long countEggOfThirdHaleByDescDateCurrentDayMinusThreeDay
                = eggAddService.findThirdAndDateDescMinusThreeDay();

        Long countHensOfThirdHaleByDescDateCurrentDayMinusThree
                = hensAddService.getCountOfHensThirdAboutCurrentDayMinusThree();

        float percentHaleThirdCurrentDayMinusThree
                = (countEggOfThirdHaleByDescDateCurrentDayMinusThreeDay / (countHensOfThirdHaleByDescDateCurrentDayMinusThree
                * 1.0f)) * 100;

        model.addAttribute("countEggOfThirdHaleByDescDateMinusThree"
                , String.format("%.2f",percentHaleThirdCurrentDayMinusThree));

        //За текущия ден - 4 дни
        Long countEggOfThirdHaleByDescDateCurrentDayMinusFourthDay
                = eggAddService.findThirdAndDateDescMinusFourthDay();

        Long countHensOfThirdHaleByDescDateCurrentDayMinusFourth
                = hensAddService.getCountOfHensThirdAboutCurrentDayMinusFourth();

        float percentHaleThirdCurrentDayMinusFourth
                = (countEggOfThirdHaleByDescDateCurrentDayMinusFourthDay / (countHensOfThirdHaleByDescDateCurrentDayMinusFourth * 1.0f)) * 100;

        model.addAttribute("countEggOfThirdHaleByDescDateMinusFourth"
                , String.format("%.2f",percentHaleThirdCurrentDayMinusFourth));

        //За текущия ден - 5 дни
        Long countEggOfThirdHaleByDescDateCurrentDayMinusFiveDay
                = eggAddService.findThirdAndDateDescMinusFiveDay();

        Long countHensOfThirdHaleByDescDateCurrentDayMinusFive
                = hensAddService.getCountOfHensThirdAboutCurrentDayMinusFive();

        float percentHaleThirdCurrentDayMinusFive
                = (countEggOfThirdHaleByDescDateCurrentDayMinusFiveDay / (countHensOfThirdHaleByDescDateCurrentDayMinusFive * 1.0f)) * 100;

        model.addAttribute("countEggOfThirdHaleByDescDateMinusFive"
                , String.format("%.2f",percentHaleThirdCurrentDayMinusFive));

        //За текущия ден - 6 дни
        Long countEggOfThirdHaleByDescDateCurrentDayMinusSixDay
                = eggAddService.findThirdAndDateDescMinusSixDay();

        Long countHensOfThirdHaleByDescDateCurrentDayMinusSix
                = hensAddService.getCountOfHensThirdAboutCurrentDayMinusSix();

        float percentHaleThirdCurrentDayMinusSix
                = (countEggOfThirdHaleByDescDateCurrentDayMinusSixDay  / (countHensOfThirdHaleByDescDateCurrentDayMinusSix * 1.0f)) * 100;

        model.addAttribute("countEggOfThirdHaleByDescDateMinusSix"
                , String.format("%.2f",percentHaleThirdCurrentDayMinusSix));

        //За текущия ден - 7 дни
        Long countEggOfThirdHaleByDescDateCurrentDayMinusSevenDay
                = eggAddService.findThirdAndDateDescMinusSevenDay();

        Long countHensOfThirdHaleByDescDateCurrentDayMinusSeven
                = hensAddService.getCountOfHensThirdAboutCurrentDayMinusSeven();

        float percentHaleThirdCurrentDayMinusSeven
                = (countEggOfThirdHaleByDescDateCurrentDayMinusSevenDay / (countHensOfThirdHaleByDescDateCurrentDayMinusSeven * 1.0f)) * 100;

        model.addAttribute("countEggOfThirdHaleByDescDateMinusSeven"
                , String.format("%.2f",percentHaleThirdCurrentDayMinusSeven));


        //За броя на яйцата от Четвърто хале от текущия ден
        Long countEggOfFourthHaleByDescDateCurrentDay
                = eggAddService.findByHaleFourthAndDateDescCurrentDay();

        Long countHensOfFourthHaleByDescDateCurrentDay
                = hensAddService.getCountOfHensFourthAboutCurrentDay();

        float percentHaleFourthCurrentDay
                = (countEggOfFourthHaleByDescDateCurrentDay / (countHensOfFourthHaleByDescDateCurrentDay * 1.0f)) * 100;

        model.addAttribute("countEggOfFourthHaleByDescDate"
                , String.format("%.2f",percentHaleFourthCurrentDay));

        //За текущия ден - 1 ден
        Long countEggOfFourthHaleByDescDateCurrentDayMinusOneDay
                = eggAddService.findFourthAndDateDescMinusOneDay();

        Long countHensOfFourthHaleByDescDateCurrentDayMinusOne
                = hensAddService.getCountOfHensFourthAboutCurrentDayMinusOne();

        float percentHaleFourthCurrentDayMinusOne
                = (countEggOfFourthHaleByDescDateCurrentDayMinusOneDay/ (countHensOfFourthHaleByDescDateCurrentDayMinusOne * 1.0f)) * 100;

        model.addAttribute("countEggOfFourthHaleByDescDateMinusOne"
                , String.format("%.2f",percentHaleFourthCurrentDayMinusOne));

        //За текущия ден - 2 дни
        Long countEggOfFourthHaleByDescDateCurrentDayMinusTwoDay
                = eggAddService.findFourthAndDateDescMinusTwoDay();

        Long countHensOfFourthHaleByDescDateCurrentDayMinusTwo
                = hensAddService.getCountOfHensFourthAboutCurrentDayMinusTwo();

        float percentHaleFourthCurrentDayMinusTwo
                = (countEggOfFourthHaleByDescDateCurrentDayMinusTwoDay/ (countHensOfFourthHaleByDescDateCurrentDayMinusTwo * 1.0f)) * 100;

        model.addAttribute("countEggOfFourthHaleByDescDateMinusTwo"
                , String.format("%.2f",percentHaleFourthCurrentDayMinusTwo));

        //За текущия ден - 3 дни
        Long countEggOfFourthHaleByDescDateCurrentDayMinusThreeDay
                = eggAddService.findFourthAndDateDescMinusThreeDay();

        Long countHensOfFourthHaleByDescDateCurrentDayMinusThree
                = hensAddService.getCountOfHensFourthAboutCurrentDayMinusThree();

        float percentHaleFourthCurrentDayMinusThree
                = (countEggOfFourthHaleByDescDateCurrentDayMinusThreeDay / (countHensOfFourthHaleByDescDateCurrentDayMinusThree
                * 1.0f)) * 100;

        model.addAttribute("countEggOfFourthHaleByDescDateMinusThree"
                , String.format("%.2f",percentHaleFourthCurrentDayMinusThree));

        //За текущия ден - 4 дни
        Long countEggOfFourthHaleByDescDateCurrentDayMinusFourthDay
                = eggAddService.findFourthAndDateDescMinusFourthDay();

        Long countHensOfFourthHaleByDescDateCurrentDayMinusFourth
                = hensAddService.getCountOfHensFourthAboutCurrentDayMinusFourth();

        float percentHaleFourthCurrentDayMinusFourth
                = (countEggOfFourthHaleByDescDateCurrentDayMinusFourthDay  / (countHensOfFourthHaleByDescDateCurrentDayMinusFourth * 1.0f)) * 100;

        model.addAttribute("countEggOfFourthHaleByDescDateMinusFourth"
                , String.format("%.2f",percentHaleFourthCurrentDayMinusFourth));

        //За текущия ден - 5 дни
        Long countEggOfFourthHaleByDescDateCurrentDayMinusFiveDay
                = eggAddService.findFourthAndDateDescMinusFiveDay();

        Long countHensOfFourthHaleByDescDateCurrentDayMinusFive
                = hensAddService.getCountOfHensFourthAboutCurrentDayMinusFive();

        float percentHaleFourthCurrentDayMinusFive
                = (countEggOfFourthHaleByDescDateCurrentDayMinusFiveDay / (countHensOfFourthHaleByDescDateCurrentDayMinusFive * 1.0f)) * 100;

        model.addAttribute("countEggOfFourthHaleByDescDateMinusFive"
                , String.format("%.2f",percentHaleFourthCurrentDayMinusFive));

        //За текущия ден - 6 дни
        Long countEggOfFourthHaleByDescDateCurrentDayMinusSixDay
                = eggAddService.findFourthAndDateDescMinusSixDay();

        Long countHensOfFourthHaleByDescDateCurrentDayMinusSix
                = hensAddService.getCountOfHensFourthAboutCurrentDayMinusSix();

        float percentHaleFourthCurrentDayMinusSix
                = (countEggOfFourthHaleByDescDateCurrentDayMinusSixDay / (countHensOfFourthHaleByDescDateCurrentDayMinusSix * 1.0f)) * 100;

        model.addAttribute("countEggOfFourthHaleByDescDateMinusSix"
                , String.format("%.2f",percentHaleFourthCurrentDayMinusSix));

        //За текущия ден - 7 дни
        Long countEggOfFourthHaleByDescDateCurrentDayMinusSevenDay
                = eggAddService.findFourthAndDateDescMinusSevenDay();

        Long countHensOfFourthHaleByDescDateCurrentDayMinusSeven
                = hensAddService.getCountOfHensFourthAboutCurrentDayMinusSeven();

        float percentHaleFourthCurrentDayMinusSeven
                = (countEggOfFourthHaleByDescDateCurrentDayMinusSevenDay  / (countHensOfFourthHaleByDescDateCurrentDayMinusSeven * 1.0f)) * 100;

        model.addAttribute("countEggOfFourthHaleByDescDateMinusSeven"
                , String.format("%.2f",percentHaleFourthCurrentDayMinusSeven));


        //За броя на яйцата от Пето хале от текущия ден
        Long countEggOfFiveHaleByDescDateCurrentDay
                = eggAddService.findByHaleFiveAndDateDescCurrentDay();

        Long countHensOfFiveHaleByDescDateCurrentDay
                = hensAddService.getCountOfHensFiveAboutCurrentDay();

        float percentHaleFiveCurrentDay
                = (countEggOfFiveHaleByDescDateCurrentDay / (countHensOfFiveHaleByDescDateCurrentDay * 1.0f)) * 100;

        model.addAttribute("countEggOfFiveHaleByDescDate"
                , String.format("%.2f",percentHaleFiveCurrentDay));

        //За текущия ден - 1 ден
        Long countEggOfFiveHaleByDescDateCurrentDayMinusOneDay
                = eggAddService.findFiveAndDateDescMinusOneDay();

        Long countHensOfFiveHaleByDescDateCurrentDayMinusOne
                = hensAddService.getCountOfHensFiveAboutCurrentDayMinusOne();

        float percentHaleFiveCurrentDayMinusOne
                = (countEggOfFiveHaleByDescDateCurrentDayMinusOneDay / (countHensOfFiveHaleByDescDateCurrentDayMinusOne * 1.0f)) * 100;

        model.addAttribute("countEggOfFiveHaleByDescDateMinusOne"
                , String.format("%.2f",percentHaleFiveCurrentDayMinusOne));

        //За текущия ден - 2 дни
        Long countEggOfFiveHaleByDescDateCurrentDayMinusTwoDay
                = eggAddService.findFiveAndDateDescMinusTwoDay();

        Long countHensOfFiveHaleByDescDateCurrentDayMinusTwo
                = hensAddService.getCountOfHensFiveAboutCurrentDayMinusTwo();

        float percentHaleFiveCurrentDayMinusTwo
                = (countEggOfFiveHaleByDescDateCurrentDayMinusTwoDay / (countHensOfFiveHaleByDescDateCurrentDayMinusTwo * 1.0f)) * 100;

        model.addAttribute("countEggOfFiveHaleByDescDateMinusTwo"
                , String.format("%.2f",percentHaleFiveCurrentDayMinusTwo));

        //За текущия ден - 3 дни
        Long countEggOfFiveHaleByDescDateCurrentDayMinusThreeDay
                = eggAddService.findFiveAndDateDescMinusThreeDay();

        Long countHensOfFiveHaleByDescDateCurrentDayMinusThree
                = hensAddService.getCountOfHensFiveAboutCurrentDayMinusThree();

        float percentHaleFiveCurrentDayMinusThree
                = (countEggOfFiveHaleByDescDateCurrentDayMinusThreeDay / (countHensOfFiveHaleByDescDateCurrentDayMinusThree
                * 1.0f)) * 100;

        model.addAttribute("countEggOfFiveHaleByDescDateMinusThree"
                , String.format("%.2f",percentHaleFiveCurrentDayMinusThree));

        //За текущия ден - 4 дни
        Long countEggOfFiveHaleByDescDateCurrentDayMinusFourthDay
                = eggAddService.findFiveAndDateDescMinusFourthDay();

        Long countHensOfFiveHaleByDescDateCurrentDayMinusFourth
                = hensAddService.getCountOfHensFiveAboutCurrentDayMinusFourth();

        float percentHaleFiveCurrentDayMinusFourth
                = (countEggOfFiveHaleByDescDateCurrentDayMinusFourthDay / (countHensOfFiveHaleByDescDateCurrentDayMinusFourth * 1.0f)) * 100;

        model.addAttribute("countEggOfFiveHaleByDescDateMinusFourth"
                , String.format("%.2f",percentHaleFiveCurrentDayMinusFourth));

        //За текущия ден - 5 дни
        Long countEggOfFiveHaleByDescDateCurrentDayMinusFiveDay
                = eggAddService.findFiveAndDateDescMinusFiveDay();

        Long countHensOfFiveHaleByDescDateCurrentDayMinusFive
                = hensAddService.getCountOfHensFiveAboutCurrentDayMinusFive();

        float percentHaleFiveCurrentDayMinusFive
                = (countEggOfFiveHaleByDescDateCurrentDayMinusFiveDay / (countHensOfFiveHaleByDescDateCurrentDayMinusFive * 1.0f)) * 100;

        model.addAttribute("countEggOfFiveHaleByDescDateMinusFive"
                , String.format("%.2f",percentHaleFiveCurrentDayMinusFive));

        //За текущия ден - 6 дни
        Long countEggOfFiveHaleByDescDateCurrentDayMinusSixDay
                = eggAddService.findFiveAndDateDescMinusSixDay();

        Long countHensOfFiveHaleByDescDateCurrentDayMinusSix
                = hensAddService.getCountOfHensFiveAboutCurrentDayMinusSix();

        float percentHaleFiveCurrentDayMinusSix
                = (countEggOfFiveHaleByDescDateCurrentDayMinusSixDay / (countHensOfFiveHaleByDescDateCurrentDayMinusSix * 1.0f)) * 100;

        model.addAttribute("countEggOfFiveHaleByDescDateMinusSix"
                , String.format("%.2f",percentHaleFiveCurrentDayMinusSix));

        //За текущия ден - 7 дни
        Long countEggOfFiveHaleByDescDateCurrentDayMinusSevenDay
                = eggAddService.findFiveAndDateDescMinusSevenDay();

        Long countHensOfFiveHaleByDescDateCurrentDayMinusSeven
                = hensAddService.getCountOfHensFiveAboutCurrentDayMinusSeven();

        float percentHaleFiveCurrentDayMinusSeven
                = (countEggOfFiveHaleByDescDateCurrentDayMinusSevenDay / (countHensOfFiveHaleByDescDateCurrentDayMinusSeven * 1.0f)) * 100;

        model.addAttribute("countEggOfFiveHaleByDescDateMinusSeven"
                , String.format("%.2f",percentHaleFiveCurrentDayMinusSeven));


        //За броя на яйцата от Шесто хале от текущия ден
        Long countEggOfSixHaleByDescDateCurrentDay
                = eggAddService.findByHaleSixAndDateDescCurrentDay();

        Long countHensOfSixHaleByDescDateCurrentDay
                = hensAddService.getCountOfHensSixAboutCurrentDay();

        float percentHaleSixCurrentDay
                = (countEggOfSixHaleByDescDateCurrentDay / (countHensOfSixHaleByDescDateCurrentDay * 1.0f)) * 100;

        model.addAttribute("countEggOfSixHaleByDescDate"
                , String.format("%.2f",percentHaleSixCurrentDay));

        //За текущия ден - 1 ден
        Long countEggOfSixHaleByDescDateCurrentDayMinusOneDay
                = eggAddService.findSixAndDateDescMinusOneDay();

        Long countHensOfSixHaleByDescDateCurrentDayMinusOne
                = hensAddService.getCountOfHensSixAboutCurrentDayMinusOne();

        float percentHaleSixCurrentDayMinusOne
                = (countEggOfSixHaleByDescDateCurrentDayMinusOneDay / (countHensOfSixHaleByDescDateCurrentDayMinusOne * 1.0f)) * 100;

        model.addAttribute("countEggOfSixHaleByDescDateMinusOne"
                , String.format("%.2f",percentHaleSixCurrentDayMinusOne));

        //За текущия ден - 2 дни
        Long countEggOfSixHaleByDescDateCurrentDayMinusTwoDay
                = eggAddService.findSixAndDateDescMinusTwoDay();

        Long countHensOfSixHaleByDescDateCurrentDayMinusTwo
                = hensAddService.getCountOfHensSixAboutCurrentDayMinusTwo();

        float percentHaleSixCurrentDayMinusTwo
                = (countEggOfSixHaleByDescDateCurrentDayMinusTwoDay / (countHensOfSixHaleByDescDateCurrentDayMinusTwo * 1.0f)) * 100;

        model.addAttribute("countEggOfSixHaleByDescDateMinusTwo"
                , String.format("%.2f",percentHaleSixCurrentDayMinusTwo));

        //За текущия ден - 3 дни
        Long countEggOfSixHaleByDescDateCurrentDayMinusThreeDay
                = eggAddService.findSixAndDateDescMinusThreeDay();

        Long countHensOfSixHaleByDescDateCurrentDayMinusThree
                = hensAddService.getCountOfHensSixAboutCurrentDayMinusThree();

        float percentHaleSixCurrentDayMinusThree
                = (countEggOfSixHaleByDescDateCurrentDayMinusThreeDay / (countHensOfSixHaleByDescDateCurrentDayMinusThree
                * 1.0f)) * 100;

        model.addAttribute("countEggOfSixHaleByDescDateMinusThree"
                , String.format("%.2f",percentHaleSixCurrentDayMinusThree));

        //За текущия ден - 4 дни
        Long countEggOfSixHaleByDescDateCurrentDayMinusFourthDay
                = eggAddService.findSixAndDateDescMinusFourthDay();

        Long countHensOfSixHaleByDescDateCurrentDayMinusFourth
                = hensAddService.getCountOfHensSixAboutCurrentDayMinusFourth();

        float percentHaleSixCurrentDayMinusFourth
                = (countEggOfSixHaleByDescDateCurrentDayMinusFourthDay / (countHensOfSixHaleByDescDateCurrentDayMinusFourth * 1.0f)) * 100;

        model.addAttribute("countEggOfSixHaleByDescDateMinusFourth"
                , String.format("%.2f",percentHaleSixCurrentDayMinusFourth));

        //За текущия ден - 5 дни
        Long countEggOfSixHaleByDescDateCurrentDayMinusFiveDay
                = eggAddService.findSixAndDateDescMinusFiveDay();

        Long countHensOfSixHaleByDescDateCurrentDayMinusFive
                = hensAddService.getCountOfHensSixAboutCurrentDayMinusFive();

        float percentHaleSixCurrentDayMinusFive
                = (countEggOfSixHaleByDescDateCurrentDayMinusFiveDay / (countHensOfSixHaleByDescDateCurrentDayMinusFive * 1.0f)) * 100;

        model.addAttribute("countEggOfSixHaleByDescDateMinusFive"
                , String.format("%.2f",percentHaleSixCurrentDayMinusFive));

        //За текущия ден - 6 дни
        Long countEggOfSixHaleByDescDateCurrentDayMinusSixDay
                = eggAddService.findSixAndDateDescMinusSixDay();

        Long countHensOfSixHaleByDescDateCurrentDayMinusSix
                = hensAddService.getCountOfHensSixAboutCurrentDayMinusSix();

        float percentHaleSixCurrentDayMinusSix
                = (countEggOfSixHaleByDescDateCurrentDayMinusSixDay / (countHensOfSixHaleByDescDateCurrentDayMinusSix * 1.0f)) * 100;

        model.addAttribute("countEggOfSixHaleByDescDateMinusSix"
                , String.format("%.2f",percentHaleSixCurrentDayMinusSix));

        //За текущия ден - 7 дни
        Long countEggOfSixHaleByDescDateCurrentDayMinusSevenDay
                = eggAddService.findSixAndDateDescMinusSevenDay();

        Long countHensOfSixHaleByDescDateCurrentDayMinusSeven
                = hensAddService.getCountOfHensSixAboutCurrentDayMinusSeven();

        float percentHaleSixCurrentDayMinusSeven
                = (countEggOfSixHaleByDescDateCurrentDayMinusSevenDay / (countHensOfSixHaleByDescDateCurrentDayMinusSeven * 1.0f)) * 100;

        model.addAttribute("countEggOfSixHaleByDescDateMinusSeven"
                , String.format("%.2f",percentHaleSixCurrentDayMinusSeven));


        //За броя на яйцата от Седмо хале от текущия ден
        Long countEggOfSevenHaleByDescDateCurrentDay
                = eggAddService.findByHaleSevenAndDateDescCurrentDay();

        Long countHensOfSevenHaleByDescDateCurrentDay
                = hensAddService.getCountOfHensSevenAboutCurrentDay();

        float percentHaleSevenCurrentDay
                = (countEggOfSevenHaleByDescDateCurrentDay / (countHensOfSevenHaleByDescDateCurrentDay * 1.0f)) * 100;

        model.addAttribute("countEggOfSevenHaleByDescDate"
                , String.format("%.2f",percentHaleSevenCurrentDay));

        //За текущия ден - 1 ден
        Long countEggOfSevenHaleByDescDateCurrentDayMinusOneDay
                = eggAddService.findSevenAndDateDescMinusOneDay();

        Long countHensOfSevenHaleByDescDateCurrentDayMinusOne
                = hensAddService.getCountOfHensSevenAboutCurrentDayMinusOne();

        float percentHaleSevenCurrentDayMinusOne
                = (countEggOfSevenHaleByDescDateCurrentDayMinusOneDay / (countHensOfSevenHaleByDescDateCurrentDayMinusOne * 1.0f)) * 100;

        model.addAttribute("countEggOfSevenHaleByDescDateMinusOne"
                , String.format("%.2f",percentHaleSevenCurrentDayMinusOne));

        //За текущия ден - 2 дни
        Long countEggOfSevenHaleByDescDateCurrentDayMinusTwoDay
                = eggAddService.findSevenAndDateDescMinusTwoDay();

        Long countHensOfSevenHaleByDescDateCurrentDayMinusTwo
                = hensAddService.getCountOfHensSevenAboutCurrentDayMinusTwo();

        float percentHaleSevenCurrentDayMinusTwo
                = (countEggOfSevenHaleByDescDateCurrentDayMinusTwoDay / (countHensOfSevenHaleByDescDateCurrentDayMinusTwo * 1.0f)) * 100;

        model.addAttribute("countEggOfSevenHaleByDescDateMinusTwo"
                , String.format("%.2f",percentHaleSevenCurrentDayMinusTwo));

        //За текущия ден - 3 дни
        Long countEggOfSevenHaleByDescDateCurrentDayMinusThreeDay
                = eggAddService.findSevenAndDateDescMinusThreeDay();

        Long countHensOfSevenHaleByDescDateCurrentDayMinusThree
                = hensAddService.getCountOfHensSevenAboutCurrentDayMinusThree();

        float percentHaleSevenCurrentDayMinusThree
                = (countEggOfSevenHaleByDescDateCurrentDayMinusThreeDay / (countHensOfSevenHaleByDescDateCurrentDayMinusThree
                * 1.0f)) * 100;

        model.addAttribute("countEggOfSevenHaleByDescDateMinusThree"
                , String.format("%.2f",percentHaleSevenCurrentDayMinusThree));

        //За текущия ден - 4 дни
        Long countEggOfSevenHaleByDescDateCurrentDayMinusFourthDay
                = eggAddService.findSevenAndDateDescMinusFourthDay();

        Long countHensOfSevenHaleByDescDateCurrentDayMinusFourth
                = hensAddService.getCountOfHensSevenAboutCurrentDayMinusFourth();

        float percentHaleSevenCurrentDayMinusFourth
                = (countEggOfSevenHaleByDescDateCurrentDayMinusFourthDay / (countHensOfSevenHaleByDescDateCurrentDayMinusFourth * 1.0f)) * 100;

        model.addAttribute("countEggOfSevenHaleByDescDateMinusFourth"
                , String.format("%.2f",percentHaleSevenCurrentDayMinusFourth));

        //За текущия ден - 5 дни
        Long countEggOfSevenHaleByDescDateCurrentDayMinusFiveDay
                = eggAddService.findSevenAndDateDescMinusFiveDay();

        Long countHensOfSevenHaleByDescDateCurrentDayMinusFive
                = hensAddService.getCountOfHensSevenAboutCurrentDayMinusFive();

        float percentHaleSevenCurrentDayMinusFive
                = (countEggOfSevenHaleByDescDateCurrentDayMinusFiveDay / (countHensOfSevenHaleByDescDateCurrentDayMinusFive * 1.0f)) * 100;

        model.addAttribute("countEggOfSevenHaleByDescDateMinusFive"
                , String.format("%.2f",percentHaleSevenCurrentDayMinusFive));

        //За текущия ден - 6 дни
        Long countEggOfSevenHaleByDescDateCurrentDayMinusSixDay
                = eggAddService.findSevenAndDateDescMinusSixDay();

        Long countHensOfSevenHaleByDescDateCurrentDayMinusSix
                = hensAddService.getCountOfHensSevenAboutCurrentDayMinusSix();

        float percentHaleSevenCurrentDayMinusSix
                = (countEggOfSevenHaleByDescDateCurrentDayMinusSixDay / (countHensOfSevenHaleByDescDateCurrentDayMinusSix * 1.0f)) * 100;

        model.addAttribute("countEggOfSevenHaleByDescDateMinusSix"
                , String.format("%.2f",percentHaleSevenCurrentDayMinusSix));

        //За текущия ден - 7 дни
        Long countEggOfSevenHaleByDescDateCurrentDayMinusSevenDay
                = eggAddService.findSevenAndDateDescMinusSevenDay();

        Long countHensOfSevenHaleByDescDateCurrentDayMinusSeven
                = hensAddService.getCountOfHensSevenAboutCurrentDayMinusSeven();

        float percentHaleSevenCurrentDayMinusSeven
                = (countEggOfSevenHaleByDescDateCurrentDayMinusSevenDay / (countHensOfSevenHaleByDescDateCurrentDayMinusSeven * 1.0f)) * 100;

        model.addAttribute("countEggOfSevenHaleByDescDateMinusSeven"
                , String.format("%.2f",percentHaleSevenCurrentDayMinusSeven));


        //За броя на яйцата от Осмо хале от текущия ден
        Long countEggOfEightHaleByDescDateCurrentDay
                = eggAddService.findByHaleEightAndDateDescCurrentDay();

        Long countHensOfEightHaleByDescDateCurrentDay
                = hensAddService.getCountOfHensEightAboutCurrentDay();

        float percentHaleEightCurrentDay
                = (countEggOfEightHaleByDescDateCurrentDay / (countHensOfEightHaleByDescDateCurrentDay * 1.0f)) * 100;

        model.addAttribute("countEggOfEightHaleByDescDate"
                , String.format("%.2f",percentHaleEightCurrentDay));

        //За текущия ден - 1 ден
        Long countEggOfEightHaleByDescDateCurrentDayMinusOneDay
                = eggAddService.findEightAndDateDescMinusOneDay();

        Long countHensOfEightHaleByDescDateCurrentDayMinusOne
                = hensAddService.getCountOfHensEightAboutCurrentDayMinusOne();

        float percentHaleEightCurrentDayMinusOne
                = (countEggOfEightHaleByDescDateCurrentDayMinusOneDay / (countHensOfEightHaleByDescDateCurrentDayMinusOne * 1.0f)) * 100;

        model.addAttribute("countEggOfEightHaleByDescDateMinusOne"
                , String.format("%.2f",percentHaleEightCurrentDayMinusOne));

        //За текущия ден - 2 дни
        Long countEggOfEightHaleByDescDateCurrentDayMinusTwoDay
                = eggAddService.findEightAndDateDescMinusTwoDay();

        Long countHensOfEightHaleByDescDateCurrentDayMinusTwo
                = hensAddService.getCountOfHensEightAboutCurrentDayMinusTwo();

        float percentHaleEightCurrentDayMinusTwo
                = (countEggOfEightHaleByDescDateCurrentDayMinusTwoDay / (countHensOfEightHaleByDescDateCurrentDayMinusTwo * 1.0f)) * 100;

        model.addAttribute("countEggOfEightHaleByDescDateMinusTwo"
                , String.format("%.2f",percentHaleEightCurrentDayMinusTwo));

        //За текущия ден - 3 дни
        Long countEggOfEightHaleByDescDateCurrentDayMinusThreeDay
                = eggAddService.findEightAndDateDescMinusThreeDay();

        Long countHensOfEightHaleByDescDateCurrentDayMinusThree
                = hensAddService.getCountOfHensEightAboutCurrentDayMinusThree();

        float percentHaleEightCurrentDayMinusThree
                = (countEggOfEightHaleByDescDateCurrentDayMinusThreeDay / (countHensOfEightHaleByDescDateCurrentDayMinusThree
                * 1.0f)) * 100;

        model.addAttribute("countEggOfEightHaleByDescDateMinusThree"
                , String.format("%.2f",percentHaleEightCurrentDayMinusThree));

        //За текущия ден - 4 дни
        Long countEggOfEightHaleByDescDateCurrentDayMinusFourthDay
                = eggAddService.findEightAndDateDescMinusFourthDay();

        Long countHensOfEightHaleByDescDateCurrentDayMinusFourth
                = hensAddService.getCountOfHensEightAboutCurrentDayMinusFourth();

        float percentHaleEightCurrentDayMinusFourth
                = (countEggOfEightHaleByDescDateCurrentDayMinusFourthDay / (countHensOfEightHaleByDescDateCurrentDayMinusFourth * 1.0f)) * 100;

        model.addAttribute("countEggOfEightHaleByDescDateMinusFourth"
                , String.format("%.2f",percentHaleEightCurrentDayMinusFourth));

        //За текущия ден - 5 дни
        Long countEggOfEightHaleByDescDateCurrentDayMinusFiveDay
                = eggAddService.findEightAndDateDescMinusFiveDay();

        Long countHensOfEightHaleByDescDateCurrentDayMinusFive
                = hensAddService.getCountOfHensEightAboutCurrentDayMinusFive();

        float percentHaleEightCurrentDayMinusFive
                = (countEggOfEightHaleByDescDateCurrentDayMinusFiveDay / (countHensOfEightHaleByDescDateCurrentDayMinusFive * 1.0f)) * 100;

        model.addAttribute("countEggOfEightHaleByDescDateMinusFive"
                , String.format("%.2f",percentHaleEightCurrentDayMinusFive));

        //За текущия ден - 6 дни
        Long countEggOfEightHaleByDescDateCurrentDayMinusSixDay
                = eggAddService.findEightAndDateDescMinusSixDay();

        Long countHensOfEightHaleByDescDateCurrentDayMinusSix
                = hensAddService.getCountOfHensEightAboutCurrentDayMinusSix();

        float percentHaleEightCurrentDayMinusSix
                = (countEggOfEightHaleByDescDateCurrentDayMinusSixDay / (countHensOfEightHaleByDescDateCurrentDayMinusSix * 1.0f)) * 100;

        model.addAttribute("countEggOfEightHaleByDescDateMinusSix"
                , String.format("%.2f",percentHaleEightCurrentDayMinusSix));

        //За текущия ден - 7 дни
        Long countEggOfEightHaleByDescDateCurrentDayMinusSevenDay
                = eggAddService.findEightAndDateDescMinusSevenDay();

        Long countHensOfEightHaleByDescDateCurrentDayMinusSeven
                = hensAddService.getCountOfHensEightAboutCurrentDayMinusSeven();

        float percentHaleEightCurrentDayMinusSeven
                = (countEggOfEightHaleByDescDateCurrentDayMinusSevenDay / (countHensOfEightHaleByDescDateCurrentDayMinusSeven * 1.0f)) * 100;

        model.addAttribute("countEggOfEightHaleByDescDateMinusSeven"
                , String.format("%.2f",percentHaleEightCurrentDayMinusSeven));


        //За броя на яйцата от Девето хале от текущия ден
        Long countEggOfNinthHaleByDescDateCurrentDay
                = eggAddService.findByHaleNinthAndDateDescCurrentDay();

        Long countHensOfNinthHaleByDescDateCurrentDay
                = hensAddService.getCountOfHensNinthAboutCurrentDay();

        float percentHaleNinthCurrentDay
                = (countEggOfNinthHaleByDescDateCurrentDay / (countHensOfNinthHaleByDescDateCurrentDay * 1.0f)) * 100;

        model.addAttribute("countEggOfNinthHaleByDescDate"
                , String.format("%.2f",percentHaleNinthCurrentDay));

        //За текущия ден - 1 ден
        Long countEggOfNinthHaleByDescDateCurrentDayMinusOneDay
                = eggAddService.findNinthAndDateDescMinusOneDay();

        Long countHensOfNinthHaleByDescDateCurrentDayMinusOne
                = hensAddService.getCountOfHensNinthAboutCurrentDayMinusOne();

        float percentHaleNinthCurrentDayMinusOne
                = (countEggOfNinthHaleByDescDateCurrentDayMinusOneDay / (countHensOfNinthHaleByDescDateCurrentDayMinusOne * 1.0f)) * 100;

        model.addAttribute("countEggOfNinthHaleByDescDateMinusOne"
                , String.format("%.2f",percentHaleNinthCurrentDayMinusOne));

        //За текущия ден - 2 дни
        Long countEggOfNinthHaleByDescDateCurrentDayMinusTwoDay
                = eggAddService.findNinthAndDateDescMinusTwoDay();

        Long countHensOfNinthHaleByDescDateCurrentDayMinusTwo
                = hensAddService.getCountOfHensNinthAboutCurrentDayMinusTwo();

        float percentHaleNinthCurrentDayMinusTwo
                = (countEggOfNinthHaleByDescDateCurrentDayMinusTwoDay / (countHensOfNinthHaleByDescDateCurrentDayMinusTwo * 1.0f)) * 100;

        model.addAttribute("countEggOfNinthHaleByDescDateMinusTwo"
                , String.format("%.2f",percentHaleNinthCurrentDayMinusTwo));

        //За текущия ден - 3 дни
        Long countEggOfNinthHaleByDescDateCurrentDayMinusThreeDay
                = eggAddService.findNinthAndDateDescMinusThreeDay();

        Long countHensOfNinthHaleByDescDateCurrentDayMinusThree
                = hensAddService.getCountOfHensNinthAboutCurrentDayMinusThree();

        float percentHaleNinthCurrentDayMinusThree
                = (countEggOfNinthHaleByDescDateCurrentDayMinusThreeDay / (countHensOfNinthHaleByDescDateCurrentDayMinusThree
                * 1.0f)) * 100;

        model.addAttribute("countEggOfNinthHaleByDescDateMinusThree"
                , String.format("%.2f",percentHaleNinthCurrentDayMinusThree));

        //За текущия ден - 4 дни
        Long countEggOfNinthHaleByDescDateCurrentDayMinusFourthDay
                = eggAddService.findNinthAndDateDescMinusFourthDay();

        Long countHensOfNinthHaleByDescDateCurrentDayMinusFourth
                = hensAddService.getCountOfHensNinthAboutCurrentDayMinusFourth();

        float percentHaleNinthCurrentDayMinusFourth
                = (countEggOfNinthHaleByDescDateCurrentDayMinusFourthDay / (countHensOfNinthHaleByDescDateCurrentDayMinusFourth * 1.0f)) * 100;

        model.addAttribute("countEggOfNinthHaleByDescDateMinusFourth"
                , String.format("%.2f",percentHaleNinthCurrentDayMinusFourth));

        //За текущия ден - 5 дни
        Long countEggOfNinthHaleByDescDateCurrentDayMinusFiveDay
                = eggAddService.findNinthAndDateDescMinusFiveDay();

        Long countHensOfNinthHaleByDescDateCurrentDayMinusFive
                = hensAddService.getCountOfHensNinthAboutCurrentDayMinusFive();

        float percentHaleNinthCurrentDayMinusFive
                = (countEggOfNinthHaleByDescDateCurrentDayMinusFiveDay / (countHensOfNinthHaleByDescDateCurrentDayMinusFive * 1.0f)) * 100;

        model.addAttribute("countEggOfNinthHaleByDescDateMinusFive"
                , String.format("%.2f",percentHaleNinthCurrentDayMinusFive));

        //За текущия ден - 6 дни
        Long countEggOfNinthHaleByDescDateCurrentDayMinusSixDay
                = eggAddService.findNinthAndDateDescMinusSixDay();

        Long countHensOfNinthHaleByDescDateCurrentDayMinusSix
                = hensAddService.getCountOfHensNinthAboutCurrentDayMinusSix();

        float percentHaleNinthCurrentDayMinusSix
                = (countEggOfNinthHaleByDescDateCurrentDayMinusSixDay / (countHensOfNinthHaleByDescDateCurrentDayMinusSix * 1.0f)) * 100;

        model.addAttribute("countEggOfNinthHaleByDescDateMinusSix"
                , String.format("%.2f",percentHaleNinthCurrentDayMinusSix));

        //За текущия ден - 7 дни
        Long countEggOfNinthHaleByDescDateCurrentDayMinusSevenDay
                = eggAddService.findNinthAndDateDescMinusSevenDay();

        Long countHensOfNinthHaleByDescDateCurrentDayMinusSeven
                = hensAddService.getCountOfHensNinthAboutCurrentDayMinusSeven();

        float percentHaleNinthCurrentDayMinusSeven
                = (countEggOfNinthHaleByDescDateCurrentDayMinusSevenDay / (countHensOfNinthHaleByDescDateCurrentDayMinusSeven * 1.0f)) * 100;

        model.addAttribute("countEggOfNinthHaleByDescDateMinusSeven"
                , String.format("%.2f",percentHaleNinthCurrentDayMinusSeven));

        System.out.println();

        return "percentage-table";
    }





}
