package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.service.PalletsServiceModel;
import com.example.projectsoftuni.model.service.TransferPalletsBetweenBaseServiceModel;

public interface PalletsService {
    void add(PalletsServiceModel palletsServiceModel);

    void transfer(TransferPalletsBetweenBaseServiceModel transferPalletsBetweenBaseServiceModel);

    Long getCOuntEuroLower();

    Long getCountThermoLower();

    Long getCountEuroUpper();

    Long getCountThermoUpper();

    Long getCountEuroPackaging();

    Long getCountThermoPackaging();
}
