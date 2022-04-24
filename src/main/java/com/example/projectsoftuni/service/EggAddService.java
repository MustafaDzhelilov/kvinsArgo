package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.entity.Egg;
import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.service.EggServiceModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EggAddService {
    void add(EggServiceModel eggServiceModel);

    Long findByCategoryXL();

    Long findByCategoryL();

    Long findByCategoryM();

    Long findByCategoryS();

    Long findByCategoryBROKEN();

    Long findByCategoryXLLower();

    Long findByCategoryXLCartonsLower();

    Long findByCategoryLCartonLower();

    Long findByCategoryMCartonLower();

    Long findByCategorySCartonLower();

    Long findByCategoryXLUpper();

    Long findByCategoryXLCartonsUpper();

    Long findByCategoryLCartonsUpper();

    Long findByCategoryMCartonsUpper();

    Long findByCategorySCartonUpper();

    // За процентната таблица Първо хале
    Long findFirstAndDateDescMinusOneDay();

    Long findByHaleFirstAndDateDescCurrentDay();

    Long findFirstAndDateDescMinusTwoDay();

    Long findFirstAndDateDescMinusThreeDay();

    Long findFirstAndDateDescMinusFourthDay();

    Long findFirstAndDateDescMinusFiveDay();

    Long findFirstAndDateDescMinusSixDay();

    Long findFirstAndDateDescMinusSevenDay();

    //Процентна таблица Второ хале
    Long findByHaleSecondAndDateDescCurrentDay();

    Long findSecondAndDateDescMinusOneDay();

    Long findSecondAndDateDescMinusTwoDay();

    Long findSecondAndDateDescMinusThreeDay();

    Long findSecondAndDateDescMinusFourthDay();

    Long findSecondAndDateDescMinusFiveDay();

    Long findSecondAndDateDescMinusSixDay();

    Long findSecondAndDateDescMinusSevenDay();

    //Процентна таблица Трето хале
    Long findByHaleThirdAndDateDescCurrentDay();

    Long findThirdAndDateDescMinusOneDay();

    Long findThirdAndDateDescMinusTwoDay();

    Long findThirdAndDateDescMinusThreeDay();

    Long findThirdAndDateDescMinusFourthDay();

    Long findThirdAndDateDescMinusFiveDay();

    Long findThirdAndDateDescMinusSixDay();

    Long findThirdAndDateDescMinusSevenDay();

    //Процентна таблица Четвърто хале
    Long findByHaleFourthAndDateDescCurrentDay();

    Long findFourthAndDateDescMinusOneDay();

    Long findFourthAndDateDescMinusTwoDay();

    Long findFourthAndDateDescMinusThreeDay();

    Long findFourthAndDateDescMinusFourthDay();

    Long findFourthAndDateDescMinusFiveDay();

    Long findFourthAndDateDescMinusSixDay();

    Long findFourthAndDateDescMinusSevenDay();

    //Процентна таблица Пето хале
    Long findByHaleFiveAndDateDescCurrentDay();

    Long findFiveAndDateDescMinusOneDay();

    Long findFiveAndDateDescMinusTwoDay();

    Long findFiveAndDateDescMinusThreeDay();

    Long findFiveAndDateDescMinusFourthDay();

    Long findFiveAndDateDescMinusFiveDay();

    Long findFiveAndDateDescMinusSixDay();

    Long findFiveAndDateDescMinusSevenDay();

    //Процентна таблица Шесто хале
    Long findByHaleSixAndDateDescCurrentDay();

    Long findSixAndDateDescMinusOneDay();

    Long findSixAndDateDescMinusTwoDay();

    Long findSixAndDateDescMinusThreeDay();

    Long findSixAndDateDescMinusFourthDay();

    Long findSixAndDateDescMinusFiveDay();

    Long findSixAndDateDescMinusSixDay();

    Long findSixAndDateDescMinusSevenDay();

    //Процентна таблица Седмо хале
    Long findByHaleSevenAndDateDescCurrentDay();

    Long findSevenAndDateDescMinusOneDay();

    Long findSevenAndDateDescMinusTwoDay();

    Long findSevenAndDateDescMinusThreeDay();

    Long findSevenAndDateDescMinusFourthDay();

    Long findSevenAndDateDescMinusFiveDay();

    Long findSevenAndDateDescMinusSixDay();

    Long findSevenAndDateDescMinusSevenDay();

    //Процентна таблица Осмо хале
    Long findByHaleEightAndDateDescCurrentDay();

    Long findEightAndDateDescMinusOneDay();

    Long findEightAndDateDescMinusTwoDay();

    Long findEightAndDateDescMinusThreeDay();

    Long findEightAndDateDescMinusFourthDay();

    Long findEightAndDateDescMinusFiveDay();

    Long findEightAndDateDescMinusSixDay();

    Long findEightAndDateDescMinusSevenDay();

    //Процентна таблица Девето хале
    Long findByHaleNinthAndDateDescCurrentDay();

    Long findNinthAndDateDescMinusOneDay();

    Long findNinthAndDateDescMinusTwoDay();

    Long findNinthAndDateDescMinusThreeDay();

    Long findNinthAndDateDescMinusFourthDay();

    Long findNinthAndDateDescMinusFiveDay();

    Long findNinthAndDateDescMinusSixDay();

    Long findNinthAndDateDescMinusSevenDay();
    // Край на процентна таблица

    Long findCoreyChezBaseLowerL();

    Long findCoreyFamilyBaseLowerL();

    Long findCoreyHartmanBaseLowerL();

    Long findCoreyEuroBaseLowerL();

    Long findCartons180BaseLowerBrownL();

    Long findCartons360BaseLowerBrownL();

    Long findCoreyChezBaseLowerM();

    Long findCoreyEuroBaseLowerM();

    Long findCoreyHartmanBaseLowerM();

    Long findCoreyFamilyBaseLowerM();

    Long findByCarton180BaseLowerBrownM();

    Long findByCarton360BaseLowerBrownM();

    Long findCoreyFamilyBaseLowerS();

    Long findCoreyChezBaseLowerS();

    Long findCoreyHartmanBaseLowerS();

    Long findCoreyEuroBaseLowerS();

    Long findCarton180BaseLowerBrownS();

    Long findCarton360BaseLowerBrownS();

    Long findCoreyFamilyLowerBroken();

    Long findCoreyEuroLowerBroken();

    Long findCoreyHartmanLowerBroken();

    Long findCoreyChezLowerBroken();

    Long findByCartonLowerBroken();

    Long findCoreyChezUpperL();

    Long findCoreyEuroUpperL();

    Long findCoreyHartmanUpperL();

    Long findCoreyFamilyUpperL();

    Long findCarton180UpperBrownL();

    Long findCarton360UpperBrownL();

    Long findCoreyFamilyUpperM();

    Long findCoreyEuroUpperM();

    Long findCoreyHartmanUpperM();

    Long findCoreyChezUpperM();

    Long findCarton180UpperBrownM();

    Long findCarton360UpperBrownM();

    Long findCoreyChezUpperS();

    Long findCoreyFamilyUpperS();

    Long findCoreyHartmanUpperS();

    Long findCoreyEuroUpperS();

    Long findCarton180UpperBrownS();

    Long findCarton360UpperBrownS();

    Long findCoreyEuroUpperBroken();

    Long findCoreyChezUpperBroken();

    Long findCoreyHartmanUpperBroken();

    Long findCoreyFamilyUpperBroken();

    Long findCartonUpperBroken();

    Long findCarton360BaseUpperBrownBroken();

    Long findCarton180BaseUpperBrownBroken();

    Long findCarton360BaseLowerBrownBroken();

    Long findCarton180BaseLowerBrownBroken();

    Long getCountEgg(CategoryBaseEnum categoryBaseEnum, CategoryEggEnum categoryEggEnum, CategoryCartonsEnum categoryCartonsEnum);

    int equalsTypeCartons();

    int wrongCoreyInXL();

    int wrongCoreyLMS();

    Long findCoreyUkraynaLowerL();

    Long findCoreyElpaLowerL();

    Long findCoreyEkoFarmLowerL();

    Long findCoreyNew1LowerL();

    Long findCoreyNew2LowerL();

    Long findCoreyUkraynaLowerM();

    Long findCoreyElpaLowerM();

    Long findCoreyEkoFarmLowerM();

    Long findCoreyNew1LowerM();

    Long findCoreyNew2LowerM();

    Long findCoreyUkraynaLowerS();

    Long findCoreyElpaLowerS();

    Long findCoreyEkoFarmLowerS();

    Long findCoreyNew1LowerS();

    Long findCoreyNew2LowerS();

    Long findCoreyUkraynaLowerBROKEN();

    Long findCoreyElpaLowerBROKEN();

    Long findCoreyEkoFarmLowerBROKEN();

    Long findCoreyNew1LowerBROKEN();

    Long findCoreyNew2LowerBROKEN();

    Long findCoreyUkraynaUpperL();

    Long findCoreyElpaUpperL();

    Long findCoreyEkoFarmUpperL();

    Long findCoreyNew1UpperL();

    Long findCoreyNew2UpperL();

    Long findCoreyUkraynaUpperM();

    Long findCoreyElpaUpperM();

    Long findCoreyEkoFarmUpperM();

    Long findCoreyNew1UpperM();

    Long findCoreyNew2UpperM();

    Long findCoreyUkraynaUpperS();

    Long findCoreyElpaUpperS();

    Long findCoreyEkoFarmUpperS();

    Long findCoreyNew1UpperS();

    Long findCoreyNew2UpperS();

    Long findCoreyUkraynaUpperBROKEN();

    Long findCoreyElpaUpperBROKEN();

    Long findCoreyEkoFarmUpperBROKEN();

    Long findCoreyNew1UpperBROKEN();

    Long findCoreyNew2UpperBROKEN();


    List<Egg> checkCountOfImport(LocalDate now);

    List<Egg> findAll();

    void deleteLocation(Long id);
}
