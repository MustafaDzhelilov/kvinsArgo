package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.binding.SellFromPackagingBindingModel;
import com.example.projectsoftuni.model.entity.SellFromPackaging;
import com.example.projectsoftuni.model.entity.enums.ClientEnum;
import com.example.projectsoftuni.model.entity.enums.PalletTypeEnum;
import com.example.projectsoftuni.model.service.SellFromPackagingServiceModel;

import java.util.List;

public interface SellFromPackagingService {
    void sell(SellFromPackagingServiceModel sellFromPackagingServiceModel);

    int getStatusForQuantityEgg();

    List<SellFromPackaging> getAllSellsFromPackaging();

    Long getReturnedEuroByCLient(ClientEnum client, PalletTypeEnum euro);

    Long getReturnedPallThermoByClient(ClientEnum client, PalletTypeEnum thermo);
}
