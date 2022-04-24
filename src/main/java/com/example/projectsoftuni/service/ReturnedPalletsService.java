package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.entity.ReturnedPallets;
import com.example.projectsoftuni.model.entity.enums.ClientEnum;
import com.example.projectsoftuni.model.entity.enums.PalletTypeEnum;
import com.example.projectsoftuni.model.service.ReturnedPalletsServiceModel;

import java.util.List;

public interface ReturnedPalletsService {

    void returnPallets(ReturnedPalletsServiceModel returnedPalletsServiceModel);

    Long getReturnedEuroByClient(ClientEnum client, PalletTypeEnum euro);

    Long getReturnedPallThermoByClient(ClientEnum client, PalletTypeEnum thermo);
}
