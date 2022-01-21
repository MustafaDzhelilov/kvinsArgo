package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.service.CartonServiceModel;

public interface CartonAddService {
    void addCarton(CartonServiceModel cartonServiceModel);

    Long getCountOfCore120FromBaseUpper();

    Long getCountOfCarton120FromBaseUpper();

    Long getCountOfCarton180FromBaseUpper();

    Long getCountOfCore180FromBaseUpper();

    Long getCountOfCore120FromBaseLower();

    Long getCountOfCarton120FromBaseLower();

    Long getCountOfCarton180FromBaseLower();

    Long getCountOfCore180FromBaseLower();

    Long getCountOfCore120FromBaseLowerLast();


    void deleteTopCartonsByCartonsCategory();
}
