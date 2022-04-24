package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.entity.Cartons;
import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.service.CartonServiceModel;
import com.example.projectsoftuni.model.service.SearchFromToCartonServiceModel;
import com.example.projectsoftuni.model.service.TransferCartonBetweenBaseServiceModel;

import java.util.List;

public interface CartonAddService {
    void addCarton(CartonServiceModel cartonServiceModel);

    Long getCountOfCore120FromBaseUpper();

    Long getCountOfCarton120FromBaseUpper();

    Long getCountOfCarton180FromBaseUpper();

    Long getCountOfCore120FromBaseLower();

    Long getCountOfCarton120FromBaseLower();

    Long getCountOfCarton180FromBaseLower();

    Long getCountOfCore120FromBaseLowerLast();

    void deleteTopCartonsByCartonsCategory();

    Long getCountOfCarton180FromBaseLowerBrown();

    Long getCountOfCarton360FromBaseLowerBrown();

    Long getCountOfCarton180FromBaseUpperBrown();

    Long getCountOfCarton360FromBaseUpperBrown();

    Long getCountCoreyFamilyLower();

    Long getCountCoreyChezLower();

    Long getCountCoreyEuroLower();

    Long getCountCoreyHartmanLower();

    Long getCountCoreyHartmanUpper();

    Long getCountCoreyEuroUpper();

    Long getCountCoreyChezUpper();

    Long getCountCoreyFamilyUpper();

    Long getCountPaperDunapackUpper();

    Long getCountPaperDSmitkUpper();

    Long getCountCornerDunapackUpper();

    Long getCountCornerDSmitkUpper();

    Long getCountPaperDunapackLower();

    Long getCountPaperDSmitkLower();

    Long getCountCornerDunapackLower();

    Long getCountCornerDSmitkLower();

    Long getCountCartons(CategoryCartonsEnum cartons, CategoryBaseEnum categoryBaseEnum);

    Long getCountCorner(CategoryCartonsEnum cartons, CategoryBaseEnum categoryBaseEnum);

    Long getCountPaper(CategoryCartonsEnum cartons, CategoryBaseEnum categoryBaseEnum);

    void transferCarton(TransferCartonBetweenBaseServiceModel transferCartonBetweenBaseServiceModel);

    Long getCountCoreyUkraynaLower();

    Long getCountCoreyElpaLower();

    Long getCountCoreyEkoFarmLower();

    Long getCountCoreyNew1Lower();

    Long getCountCoreyNew2Lower();

    Long getCountCoreyUkraynaUpper();

    Long getCountCoreyElpaUpper();

    Long getCountCoreyEkoFarmUpper();

    Long getCountCoreyNew1Upper();

    Long getCountCoreyNew2Upper();

    List<Cartons> viewIssuedCarton(SearchFromToCartonServiceModel searchFromToCartonServiceModel);
}
