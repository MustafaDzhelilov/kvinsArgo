package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.entity.enums.ClientEnum;
import com.example.projectsoftuni.model.entity.enums.PalletTypeEnum;
import com.example.projectsoftuni.model.service.ExportServiceModel;

public interface ExportService {
    void add(ExportServiceModel exportServiceModel);

    int getStatusPaper();

    int getStatusCorner();

    int getStatusCoreyisNull();

    int getStatusCornerisNull();

    int getStatusPaperisNull();

    int getStatusEggNoQuantity();

    Long getReturnedEuroByClient(ClientEnum client, PalletTypeEnum euro);

    Long getReturnedPallThermoByClient(ClientEnum client, PalletTypeEnum thermo);
}
