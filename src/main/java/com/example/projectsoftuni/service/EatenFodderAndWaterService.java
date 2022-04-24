package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.service.EatenFodderAndWaterServiceModel;

public interface EatenFodderAndWaterService {
    void add(EatenFodderAndWaterServiceModel eatenFodderAndWaterServiceModel);

    //До 16 ред за текушия ден
    Long findLastRecordsByCategory();
    Long getLitreOfWater();
    Long findLastRecordsByCategoryHale2();
    Long getLitreOfWaterHale2();
    Long findLastRecordsByCategoryHale3();
    Long getLitreOfWaterHale3();
    Long findLastRecordsByCategoryHale4();
    Long getLitreOfWaterHale4();
    //До 31 ред за текущия -1 ден
    Long findLastRecordsByCategoryHale1MinOne();
    Long getLitreOfWaterMinOne();

    Long findLastRecordsByCategoryHale2MinOne();

    Long getLitreOfWaterHale2MinOne();

    Long findLastRecordsByCategoryHale3MinOne();

    Long getLitreOfWaterHale3MinOne();

    Long findLastRecordsByCategoryHale4MinOne();

    Long getLitreOfWaterHale4MinOne();
    //До 47 ред за текущия -2 ден
    Long findLastRecordsByCategoryHale1MinTwo();

    Long getLitreOfWaterMinTwo();

    Long findLastRecordsByCategoryHale2MinTwo();

    Long getLitreOfWaterHale2MinTwo();

    Long findLastRecordsByCategoryHale3MinTwo();

    Long getLitreOfWaterHale3MinTwo();

    Long findLastRecordsByCategoryHale4MinTwo();

    Long getLitreOfWaterHale4MinTwo();
    //До 63 ред за текущия -3 дена
    Long findLastRecordsByCategoryHale1MinThree();

    Long getLitreOfWaterMinThree();

    Long findLastRecordsByCategoryHale2MinThree();

    Long getLitreOfWaterHale2MinThree();

    Long findLastRecordsByCategoryHale3MinThree();

    Long getLitreOfWaterHale3MinThree();

    Long findLastRecordsByCategoryHale4MinThree();

    Long getLitreOfWaterHale4MinThree();
    //До 79 ред за текущия -4 дена
    Long findLastRecordsByCategoryHale1MinFourth();

    Long getLitreOfWaterMinFourth();

    Long findLastRecordsByCategoryHale2MinFourth();

    Long getLitreOfWaterHale2MinFourth();

    Long findLastRecordsByCategoryHale3MinFourth();

    Long getLitreOfWaterHale3MinFourth();

    Long findLastRecordsByCategoryHale4MinFourth();

    Long getLitreOfWaterHale4MinFourth();

    //До 96 ред за текущия ден -5 дена
    Long findLastRecordsByCategoryHale1MinFifth();

    Long getLitreOfWaterMinFifth();

    Long findLastRecordsByCategoryHale2MinFifth();

    Long getLitreOfWaterHale2MinFifth();

    Long findLastRecordsByCategoryHale3MinFifth();

    Long getLitreOfWaterHale3MinFifth();

    Long findLastRecordsByCategoryHale4MinFifth();

    Long getLitreOfWaterHale4MinFifth();
    //До  ред за текущия ден -6 дена
    Long findLastRecordsByCategoryHale1MinSix();

    Long getLitreOfWaterMinSix();

    Long findLastRecordsByCategoryHale2MinSix();

    Long getLitreOfWaterHale2MinSix();

    Long findLastRecordsByCategoryHale3MinSix();

    Long getLitreOfWaterHale3MinSix();

    Long findLastRecordsByCategoryHale4MinSix();

    Long getLitreOfWaterHale4MinSix();
    //За текущия ден
    Long findLastRecordsByCategoryHale5();

    Long getLitreOfWaterHale5();

    Long findLastRecordsByCategoryHale6();

    Long getLitreOfWaterHale6();

    Long findLastRecordsByCategoryHale7();

    Long getLitreOfWaterHale7();

    Long findLastRecordsByCategoryHale8();

    Long getLitreOfWaterHale8();

    Long findLastRecordsByCategoryHale9();

    Long getLitreOfWaterHale9();
    // -1
    Long findLastRecordsByCategoryHale5MinOne();

    Long getLitreOfWaterHale5MinOne();

    Long findLastRecordsByCategoryHale6MinOne();

    Long getLitreOfWaterHale6MinOne();

    Long findLastRecordsByCategoryHale7MinOne();

    Long getLitreOfWaterHale7MinOne();

    Long findLastRecordsByCategoryHale8MinOne();

    Long getLitreOfWaterHale8MinOne();

    Long findLastRecordsByCategoryHale9MinOne();

    Long getLitreOfWaterHale9MinOne();
    // -2
    Long findLastRecordsByCategoryHale5MinTwo();

    Long getLitreOfWaterHale5MinTwo();

    Long findLastRecordsByCategoryHale6MinTwo();

    Long getLitreOfWaterHale6MinTwo();

    Long findLastRecordsByCategoryHale7MinTwo();

    Long getLitreOfWaterHale7MinTwo();

    Long findLastRecordsByCategoryHale8MinTwo();

    Long getLitreOfWaterHale8MinTwo();

    Long findLastRecordsByCategoryHale9MinTwo();

    Long getLitreOfWaterHale9MinTwo();
    // -3
    Long findLastRecordsByCategoryHale5MinThree();

    Long getLitreOfWaterHale5MinThree();

    Long findLastRecordsByCategoryHale6MinThree();

    Long getLitreOfWaterHale6MinThree();

    Long findLastRecordsByCategoryHale7MinThree();

    Long getLitreOfWaterHale7MinThree();

    Long findLastRecordsByCategoryHale8MinThree();

    Long getLitreOfWaterHale8MinThree();

    Long findLastRecordsByCategoryHale9MinThree();

    Long getLitreOfWaterHale9MinThree();
    // -4
    Long findLastRecordsByCategoryHale5MinFourth();

    Long getLitreOfWaterHale5MinFourth();

    Long findLastRecordsByCategoryHale6MinFourth();

    Long getLitreOfWaterHale6MinFourth();

    Long findLastRecordsByCategoryHale7MinFourth();

    Long getLitreOfWaterHale7MinFourth();

    Long findLastRecordsByCategoryHale8MinFourth();

    Long getLitreOfWaterHale8MinFourth();

    Long findLastRecordsByCategoryHale9MinFourth();

    Long getLitreOfWaterHale9MinFourth();
    // -5
    Long findLastRecordsByCategoryHale5MinFive();

    Long getLitreOfWaterHale5MinFive();

    Long findLastRecordsByCategoryHale6MinFive();

    Long getLitreOfWaterHale6MinFive();

    Long findLastRecordsByCategoryHale7MinFive();

    Long getLitreOfWaterHale7MinFive();

    Long findLastRecordsByCategoryHale8MinFive();

    Long getLitreOfWaterHale8MinFive();

    Long findLastRecordsByCategoryHale9MinFive();

    Long getLitreOfWaterHale9MinFive();
    // -6
    Long findLastRecordsByCategoryHale5MinSix();

    Long getLitreOfWaterHale5MinSix();

    Long findLastRecordsByCategoryHale6MinSix();

    Long getLitreOfWaterHale6MinSix();

    Long findLastRecordsByCategoryHale7MinSix();

    Long getLitreOfWaterHale7MinSix();

    Long findLastRecordsByCategoryHale8MinSix();

    Long getLitreOfWaterHale8MinSix();

    Long findLastRecordsByCategoryHale9MinSix();

    Long getLitreOfWaterHale9MinSix();

    Long getLastEatenKgSilo1();

    Long getLastEatenKgSilo2();

    Long getLastEatenKgSilo3();

    Long getLastEatenKgSilo4();

    Long getLastEatenKgSilo5();

    Long getLastEatenKgSilo6();

    Long getLastEatenKgSilo7();

    Long getLastEatenKgSilo8();

    Long getLastEatenKgSilo9();
}
