package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.service.EggServiceModel;

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

    Long findByCategoryLCoreyLower();

    Long findByCategoryLCartonLower();

    Long findByCategoryMCoreyLower();

    Long findByCategoryMCartonLower();

    Long findByCategorySCoreyLower();

    Long findByCategorySCartonLower();

    Long findByCategoryBrokenLower();

    Long findByCategoryXLUpper();

    Long findByCategoryXLCartonsUpper();

    Long findByCategoryLCoreyUpper();

    Long findByCategoryLCartonsUpper();

    Long findByCategoryMCoreyUpper();

    Long findByCategoryMCartonsUpper();

    Long findByCategorySCoreyUpper();

    Long findByCategorySCartonUpper();

    Long findByCategoryBrokenUpper();

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
}
