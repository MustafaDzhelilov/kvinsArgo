package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.service.FodderServiceModel;

public interface FodderService {
    void add(FodderServiceModel fodderServiceModel);

    //До 15 ред за текущия ден
    Long getKgOfFodder();

    Long getKgOfFodderSilo2();

    Long getKgOfFodderSilo3();

    Long getKgOfFodderSilo4();
    //До 23 ред за текущия ден -1 ден
    Long getKgOfFodderMinOne();

    Long getKgOfFodderSilo2MinOne();

    Long getKgOfFodderSilo3MinOne();

    Long getKgOfFodderSilo4MinOne();
    //До 31 за текущия -2 ден
    Long getKgOfFodderMinTwo();

    Long getKgOfFodderSilo2MinTwo();

    Long getKgOfFodderSilo3MinTwo();

    Long getKgOfFodderSilo4MinTwo();
    //До 39 ред за текущия -3 дена
    Long getKgOfFodderMinThree();

    Long getKgOfFodderSilo2MinThree();

    Long getKgOfFodderSilo3MinThree();

    Long getKgOfFodderSilo4MinThree();
    //До 47 ред за текущия -4 дена
    Long getKgOfFodderMinFourth();

    Long getKgOfFodderSilo2MinFourth();

    Long getKgOfFodderSilo3MinFourth();

    Long getKgOfFodderSilo4MinFourth();
    //До 55 ред за текущия -5 дена
    Long getKgOfFodderMinFifth();

    Long getKgOfFodderSilo2MinFifth();

    Long getKgOfFodderSilo3MinFifth();

    Long getKgOfFodderSilo4MinFifth();
    //До  ред за текущия -6 дена
    Long getKgOfFodderMinSix();

    Long getKgOfFodderSilo2MinSix();

    Long getKgOfFodderSilo3MinSix();

    Long getKgOfFodderSilo4MinSix();
    //За текущия ден
    Long getKgOfFodderHale5();

    Long getKgOfFodderSilo6();

    Long getKgOfFodderSilo7();

    Long getKgOfFodderSilo8();

    Long getKgOfFodderSilo9();
    // -1
    Long getKgOfFodderHale5MinOne();

    Long getKgOfFodderSilo6MinOne();

    Long getKgOfFodderSilo7MinOne();

    Long getKgOfFodderSilo8MinOne();

    Long getKgOfFodderSilo9MinOne();
    // -2
    Long getKgOfFodderHale5MinTwo();

    Long getKgOfFodderSilo6MinTwo();

    Long getKgOfFodderSilo7MinTwo();

    Long getKgOfFodderSilo8MinTwo();

    Long getKgOfFodderSilo9MinTwo();
    // -3
    Long getKgOfFodderHale5MinThree();

    Long getKgOfFodderSilo6MinThree();

    Long getKgOfFodderSilo7MinThree();

    Long getKgOfFodderSilo8MinThree();

    Long getKgOfFodderSilo9MinThree();
    // -4
    Long getKgOfFodderHale5MinFourth();

    Long getKgOfFodderSilo6MinFourth();

    Long getKgOfFodderSilo7MinFourth();

    Long getKgOfFodderSilo8MinFourth();

    Long getKgOfFodderSilo9MinFourth();
    // -5
    Long getKgOfFodderHale5MinFive();

    Long getKgOfFodderSilo6MinFive();

    Long getKgOfFodderSilo7MinFive();

    Long getKgOfFodderSilo8MinFive();

    Long getKgOfFodderSilo9MinFive();
    // -6
    Long getKgOfFodderHale5MinSix();

    Long getKgOfFodderSilo6MinSix();

    Long getKgOfFodderSilo7MinSix();

    Long getKgOfFodderSilo8MinSix();

    Long getKgOfFodderSilo9MinSix();
}
