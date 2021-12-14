package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.entity.Hale;
import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;
import com.example.projectsoftuni.model.service.HensServiceModel;

import javax.validation.constraints.Positive;

public interface HensAddService {
    void add(HensServiceModel hensServiceModel);

    Long getCountOfHensFirst();

    Long getCountOfDelHensFirst();

    Long getCountOfHensSecond();

    Long getCountOfHensThird();

    Long getCountOfHensFourth();

    Long getCountOfHensFifth();

    Long getCountOfHensSixth();

    Long getCountOfHensSeventh();

    Long getCountOfHensEighth();

    Long getCountOfHensNinth();

    void delete(HensServiceModel hensServiceModel);

   // void reAdd(HensServiceModel hensServiceModel);

    Long getCountOfHnesFirstLast();

    Long getCountOfHensSecondLast();

    Long getCountOfHensThirdLast();

    Long getCountOfHensFourthLast();

    Long getCountOfHensFifthLast();

    Long getCountOfHensSixthLast();

    Long getCountOfHensSeventhLast();

    Long getCountOfHensEighthLast();

    Long getCountOfHensNinthLast();

    //За броя на кокошките за Хале 1 за текущия ден
    Long getCountOfHensFirstAboutCurrentDay();

    Long getCountOfHensFirstAboutCurrentDayMinusOne();

    Long getCountOfHensFirstAboutCurrentDayMinusTwo();

    Long getCountOfHensFirstAboutCurrentDayMinusThree();

    Long getCountOfHensFirstAboutCurrentDayMinusFourth();

    Long getCountOfHensFirstAboutCurrentDayMinusFive();

    Long getCountOfHensFirstAboutCurrentDayMinusSix();

    Long getCountOfHensFirstAboutCurrentDayMinusSeven();

    //За броя на кокошките за Хале 2 за текущия ден
    Long getCountOfHensSecondAboutCurrentDay();

    Long getCountOfHensSecondAboutCurrentDayMinusOne();

    Long getCountOfHensSecondAboutCurrentDayMinusTwo();

    Long getCountOfHensSecondAboutCurrentDayMinusThree();

    Long getCountOfHensSecondAboutCurrentDayMinusFourth();

    Long getCountOfHensSecondAboutCurrentDayMinusFive();

    Long getCountOfHensSecondAboutCurrentDayMinusSix();

    Long getCountOfHensSecondAboutCurrentDayMinusSeven();

    //За броя на кокошките за Хале 3 за текущия ден
    Long getCountOfHensThirdAboutCurrentDay();

    Long getCountOfHensThirdAboutCurrentDayMinusOne();

    Long getCountOfHensThirdAboutCurrentDayMinusTwo();

    Long getCountOfHensThirdAboutCurrentDayMinusThree();

    Long getCountOfHensThirdAboutCurrentDayMinusFourth();

    Long getCountOfHensThirdAboutCurrentDayMinusFive();

    Long getCountOfHensThirdAboutCurrentDayMinusSix();

    Long getCountOfHensThirdAboutCurrentDayMinusSeven();

    //За броя на кокошките за Хале 4 за текущия ден
    Long getCountOfHensFourthAboutCurrentDay();

    Long getCountOfHensFourthAboutCurrentDayMinusOne();

    Long getCountOfHensFourthAboutCurrentDayMinusTwo();

    Long getCountOfHensFourthAboutCurrentDayMinusThree();

    Long getCountOfHensFourthAboutCurrentDayMinusFourth();

    Long getCountOfHensFourthAboutCurrentDayMinusFive();

    Long getCountOfHensFourthAboutCurrentDayMinusSix();

    Long getCountOfHensFourthAboutCurrentDayMinusSeven();

    //За броя на кокошките за Хале 5 за текущия ден
    Long getCountOfHensFiveAboutCurrentDay();

    Long getCountOfHensFiveAboutCurrentDayMinusOne();

    Long getCountOfHensFiveAboutCurrentDayMinusTwo();

    Long getCountOfHensFiveAboutCurrentDayMinusThree();

    Long getCountOfHensFiveAboutCurrentDayMinusFourth();

    Long getCountOfHensFiveAboutCurrentDayMinusFive();

    Long getCountOfHensFiveAboutCurrentDayMinusSix();

    Long getCountOfHensFiveAboutCurrentDayMinusSeven();

    //За броя на кокошките за Хале 6 за текущия ден
    Long getCountOfHensSixAboutCurrentDay();

    Long getCountOfHensSixAboutCurrentDayMinusOne();

    Long getCountOfHensSixAboutCurrentDayMinusTwo();

    Long getCountOfHensSixAboutCurrentDayMinusThree();

    Long getCountOfHensSixAboutCurrentDayMinusFourth();

    Long getCountOfHensSixAboutCurrentDayMinusFive();

    Long getCountOfHensSixAboutCurrentDayMinusSix();

    Long getCountOfHensSixAboutCurrentDayMinusSeven();

    //За броя на кокошките за Хале 7 за текущия ден
    Long getCountOfHensSevenAboutCurrentDay();

    Long getCountOfHensSevenAboutCurrentDayMinusOne();

    Long getCountOfHensSevenAboutCurrentDayMinusTwo();

    Long getCountOfHensSevenAboutCurrentDayMinusThree();

    Long getCountOfHensSevenAboutCurrentDayMinusFourth();

    Long getCountOfHensSevenAboutCurrentDayMinusFive();

    Long getCountOfHensSevenAboutCurrentDayMinusSix();

    Long getCountOfHensSevenAboutCurrentDayMinusSeven();

    //За броя на кокошките за Хале 8 за текущия ден
    Long getCountOfHensEightAboutCurrentDay();

    Long getCountOfHensEightAboutCurrentDayMinusOne();

    Long getCountOfHensEightAboutCurrentDayMinusTwo();

    Long getCountOfHensEightAboutCurrentDayMinusThree();

    Long getCountOfHensEightAboutCurrentDayMinusFourth();

    Long getCountOfHensEightAboutCurrentDayMinusFive();

    Long getCountOfHensEightAboutCurrentDayMinusSix();

    Long getCountOfHensEightAboutCurrentDayMinusSeven();

    //За броя на кокошките за Хале 9 за текущия ден
    Long getCountOfHensNinthAboutCurrentDay();

    Long getCountOfHensNinthAboutCurrentDayMinusOne();

    Long getCountOfHensNinthAboutCurrentDayMinusTwo();

    Long getCountOfHensNinthAboutCurrentDayMinusThree();

    Long getCountOfHensNinthAboutCurrentDayMinusFourth();

    Long getCountOfHensNinthAboutCurrentDayMinusFive();

    Long getCountOfHensNinthAboutCurrentDayMinusSix();

    Long getCountOfHensNinthAboutCurrentDayMinusSeven();
}
