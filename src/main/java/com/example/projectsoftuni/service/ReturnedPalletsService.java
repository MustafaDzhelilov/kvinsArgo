package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.service.ReturnedPalletsServiceModel;

public interface ReturnedPalletsService {
    void returnPallets(ReturnedPalletsServiceModel returnedPalletsServiceModel);

    Long getReturnedPallCount();

    Long getReturnedPallCountT();

    Long getReturnedPallCountAkvTermo();

    Long getReturnedPallCountTTermo();
}
