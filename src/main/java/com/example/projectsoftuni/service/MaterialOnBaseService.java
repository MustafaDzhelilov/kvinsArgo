package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.entity.MaterialOnBase;
import com.example.projectsoftuni.model.service.MaterialOnBaseServiceModel;
import com.example.projectsoftuni.model.service.SearchFromToMaterialServiceModel;
import com.example.projectsoftuni.model.service.SubtractionMaterialFromBasesServiceModel;

import java.util.List;

public interface MaterialOnBaseService {
    void addMaterialOnBase(MaterialOnBaseServiceModel materialOnBaseServiceModel);

    Long getTapeCountLower();

    Long getStretchOrdinaryLower();

    Long getStretchHolesLower();

    Long getTapeCountUpper();

    Long getStretchOrdinaryUpper();

    Long getStretchHolesUpper();

    void subtractionMaterial(SubtractionMaterialFromBasesServiceModel subtractionMaterialFromBasesServiceModel);

    Long getTapeCountPAckaging();

    Long getStretchOrdinaryPackaging();

    Long getStretchHolesPackaging();


    List<MaterialOnBase> viewIssuedMaterial(SearchFromToMaterialServiceModel searchFromToMaterialServiceModel);
}
