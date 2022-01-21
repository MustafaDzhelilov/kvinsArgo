package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.binding.HensAddBindingModel;
import com.example.projectsoftuni.model.binding.UserRegistrationBindingModel;
import com.example.projectsoftuni.model.entity.UserRoleEntity;
import com.example.projectsoftuni.model.entity.enums.UserRoleEnum;
import com.example.projectsoftuni.model.view.UserViewModel;
import com.example.projectsoftuni.repository.HensAddRepository;
import com.example.projectsoftuni.service.CartonAddService;
import com.example.projectsoftuni.service.EggAddService;
import com.example.projectsoftuni.service.HensAddService;
import com.example.projectsoftuni.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Set;

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

    public HomeController(EggAddService eggAddService, HensAddService hensAddService
            , ModelMapper modelMapper, HensAddBindingModel hensAddBindingModel
            , HensAddRepository hensAddRepository, CartonAddService cartonAddService, UserService userService, UserViewModel userViewModel) {

        this.eggAddService = eggAddService;
        this.hensAddService = hensAddService;
        this.modelMapper = modelMapper;
        this.hensAddBindingModel = hensAddBindingModel;
        this.hensAddRepository = hensAddRepository;
        this.cartonAddService = cartonAddService;
        this.userService = userService;
        this.userViewModel = userViewModel;
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
        Long eggXLCoreyLower = eggAddService.findByCategoryXLLower();
        Long eggXLCartonLower = eggAddService.findByCategoryXLCartonsLower();
        Long eggLCoreyLower = eggAddService.findByCategoryLCoreyLower();
        Long eggLCartonLower = eggAddService.findByCategoryLCartonLower();
        Long eggMCoreyLower = eggAddService.findByCategoryMCoreyLower();
        Long eggMCartonLower = eggAddService.findByCategoryMCartonLower();
        Long eggSCoreyLower = eggAddService.findByCategorySCoreyLower();
        Long eggSCartonLower = eggAddService.findByCategorySCartonLower();
        Long eggBrokenLower = eggAddService.findByCategoryBrokenLower();


        model.addAttribute("eggXLCoreyLower", eggAddService.findByCategoryXLLower() / 20);
        model.addAttribute("eggXLCartonLower", eggAddService.findByCategoryXLCartonsLower() / 120);
        model.addAttribute("eggLCoreyLower", eggAddService.findByCategoryLCoreyLower() / 30);
        model.addAttribute("eggLCartonLower", eggAddService.findByCategoryLCartonLower() / 180);
        model.addAttribute("eggMCoreyLower", eggAddService.findByCategoryMCoreyLower() / 30);
        model.addAttribute("eggMCartonLower", eggAddService.findByCategoryMCartonLower() / 180);
        model.addAttribute("eggSCoreyLower", eggAddService.findByCategorySCoreyLower() / 30);
        model.addAttribute("eggSCartonLower", eggAddService.findByCategorySCartonLower() / 180);
        model.addAttribute("eggBrokenLower", eggAddService.findByCategoryBrokenLower() / 30);


        //Base Upper
        Long eggXLCoreyUpper = eggAddService.findByCategoryXLUpper();
        Long eggXLCartonUpper = eggAddService.findByCategoryXLCartonsUpper();
        Long eggLCoreyUpper = eggAddService.findByCategoryLCoreyUpper();
        Long eggLCartonUpper = eggAddService.findByCategoryLCartonsUpper();
        Long eggMCoreyUpper = eggAddService.findByCategoryMCoreyUpper();
        Long eggMCartonUpper = eggAddService.findByCategoryMCartonsUpper();
        Long eggSCoreyUpper = eggAddService.findByCategorySCoreyUpper();
        Long eggSCartonUpper = eggAddService.findByCategorySCartonUpper();
        Long eggBrokenUpper = eggAddService.findByCategoryBrokenUpper();

        model.addAttribute("eggXLCoreyUpper", eggAddService.findByCategoryXLUpper() / 20);
        model.addAttribute("eggXLCartonUpper", eggAddService.findByCategoryXLCartonsUpper() / 120);
        model.addAttribute("eggLCoreyUpper", eggAddService.findByCategoryLCoreyUpper() / 30);
        model.addAttribute("eggLCartonUpper", eggAddService.findByCategoryLCartonsUpper() / 180);
        model.addAttribute("eggMCoreyUpper", eggAddService.findByCategoryMCoreyUpper() / 30);
        model.addAttribute("eggMCartonUpper", eggAddService.findByCategoryMCartonsUpper() / 180);
        model.addAttribute("eggSCoreyUpper", eggAddService.findByCategorySCoreyUpper() / 30);
        model.addAttribute("eggSCartonUpper", eggAddService.findByCategorySCartonUpper() / 180);
        model.addAttribute("eggBrokenUpper", eggAddService.findByCategoryBrokenUpper() / 30);


        // За брой яйца По категории на яйцата за база 1 + 2
        Long eggXL = eggAddService.findByCategoryXL();
        Long eggL = eggAddService.findByCategoryL();
        Long eggM = eggAddService.findByCategoryM();
        Long eggS = eggAddService.findByCategoryS();
        Long eggBROKEN = eggAddService.findByCategoryBROKEN();


        model.addAttribute("countXL", eggAddService.findByCategoryXL());
        model.addAttribute("countL", eggAddService.findByCategoryL());
        model.addAttribute("countM", eggAddService.findByCategoryM());
        model.addAttribute("countS", eggAddService.findByCategoryS());
        model.addAttribute("countBROKEN", eggAddService.findByCategoryBROKEN());


        model.addAttribute("countXLCarton", eggAddService.findByCategoryXL() / 120);
        model.addAttribute("countLCarton", eggAddService.findByCategoryL() / 180);
        model.addAttribute("countMCarton", eggAddService.findByCategoryM() / 180);
        model.addAttribute("countSCarton", eggAddService.findByCategoryS() / 180);
        model.addAttribute("countBROKENCarton", eggAddService.findByCategoryBROKEN() / 180);


        return "allCountTableByCategory";
    }

    @GetMapping("/count-hens-now")
    public String countHensNow(Model model){

        Long haleFirst = hensAddService.getCountOfHensFirst();
        Long lastHaleFirst = hensAddService.getCountOfHnesFirstLast();

        Long haleSecond = hensAddService.getCountOfHensSecond();
        Long lastHaleSecond = hensAddService.getCountOfHensSecondLast();

        Long haleThird = hensAddService.getCountOfHensThird();
        Long lastHaleThird = hensAddService.getCountOfHensThirdLast();

        Long haleFourth = hensAddService.getCountOfHensFourth();
        Long lastHaleFourth = hensAddService.getCountOfHensFourthLast();

        Long haleFifth = hensAddService.getCountOfHensFifth();
        Long lastHaleFifth = hensAddService.getCountOfHensFifthLast();

        Long haleSixth = hensAddService.getCountOfHensSixth();
        Long lastHaleSixth = hensAddService.getCountOfHensSixthLast();

        Long haleSeventh = hensAddService.getCountOfHensSeventh();
        Long lastHaleSeventh = hensAddService.getCountOfHensSeventhLast();

        Long haleEighth = hensAddService.getCountOfHensEighth();
        Long lastHaleEighth = hensAddService.getCountOfHensEighthLast();

        Long haleNinth = hensAddService.getCountOfHensNinth();
        Long lastHaleNinth = hensAddService.getCountOfHensNinthLast();


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

        Long corey20Upper = cartonAddService.getCountOfCore120FromBaseUpper();
        Long carton120Upper = cartonAddService.getCountOfCarton120FromBaseUpper();
        Long carton180Upper = cartonAddService.getCountOfCarton180FromBaseUpper();
        Long corey30Upper = cartonAddService.getCountOfCore180FromBaseUpper();


        model.addAttribute("countCorey120Upper",cartonAddService.getCountOfCore120FromBaseUpper());
        model.addAttribute("countCarton120Upper", cartonAddService.getCountOfCarton120FromBaseUpper());
        model.addAttribute("countCarton180Upper", cartonAddService.getCountOfCarton180FromBaseUpper());
        model.addAttribute("countCorey180Upper", cartonAddService.getCountOfCore180FromBaseUpper());


        Long corey20Lower = cartonAddService.getCountOfCore120FromBaseLower();
        Long carton120Lower = cartonAddService.getCountOfCarton120FromBaseLower();
        Long carton180Lower = cartonAddService.getCountOfCarton180FromBaseLower();
        Long corey30Lower = cartonAddService.getCountOfCore180FromBaseLower();

        model.addAttribute("countCorey20Lower",cartonAddService.getCountOfCore120FromBaseLower());
        model.addAttribute("countCarton120Lower", cartonAddService.getCountOfCarton120FromBaseLower());
        model.addAttribute("countCarton180Lower", cartonAddService.getCountOfCarton180FromBaseLower());
        model.addAttribute("countCorey30Lower", cartonAddService.getCountOfCore180FromBaseLower());



        // for decrement cartons count when adding eggs

        Long corey20LowerLast = cartonAddService.getCountOfCore120FromBaseLowerLast();


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
                = (countEggOfFirstHaleByDescDateCurrentDayMinusThreeDay / (countHensOfFirstHaleByDescDateCurrentDayMinusThree
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
                = (countEggOfSecondHaleByDescDateCurrentDayMinusFourthDay / (countHensOfSecondHaleByDescDateCurrentDayMinusFourth * 1.0f)) * 100;

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
                = (countEggOfThirdHaleByDescDateCurrentDayMinusSixDay / (countHensOfThirdHaleByDescDateCurrentDayMinusSix * 1.0f)) * 100;

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
                = (countEggOfFourthHaleByDescDateCurrentDayMinusOneDay / (countHensOfFourthHaleByDescDateCurrentDayMinusOne * 1.0f)) * 100;

        model.addAttribute("countEggOfFourthHaleByDescDateMinusOne"
                , String.format("%.2f",percentHaleFourthCurrentDayMinusOne));

        //За текущия ден - 2 дни
        Long countEggOfFourthHaleByDescDateCurrentDayMinusTwoDay
                = eggAddService.findFourthAndDateDescMinusTwoDay();

        Long countHensOfFourthHaleByDescDateCurrentDayMinusTwo
                = hensAddService.getCountOfHensFourthAboutCurrentDayMinusTwo();

        float percentHaleFourthCurrentDayMinusTwo
                = (countEggOfFourthHaleByDescDateCurrentDayMinusTwoDay / (countHensOfFourthHaleByDescDateCurrentDayMinusTwo * 1.0f)) * 100;

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
                = (countEggOfFourthHaleByDescDateCurrentDayMinusFourthDay / (countHensOfFourthHaleByDescDateCurrentDayMinusFourth * 1.0f)) * 100;

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
                = (countEggOfFourthHaleByDescDateCurrentDayMinusSevenDay / (countHensOfFourthHaleByDescDateCurrentDayMinusSeven * 1.0f)) * 100;

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
