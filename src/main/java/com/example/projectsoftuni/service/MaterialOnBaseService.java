package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.service.MaterialOnBaseServiceModel;

public interface MaterialOnBaseService {
    void addMaterialOnBase(MaterialOnBaseServiceModel materialOnBaseServiceModel);

    Long getTapeCountLower();

    Long getStretchOrdinaryLower();

    Long getStretchHolesLower();

    Long getTapeCountUpper();

    Long getStretchOrdinaryUpper();

    Long getStretchHolesUpper();
}
