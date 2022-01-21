package com.example.projectsoftuni.model.service;

import com.example.projectsoftuni.model.entity.enums.ClientEnum;
import com.example.projectsoftuni.model.entity.enums.PalletTypeEnum;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class ReturnedPalletsServiceModel {

    private Long id;
    private ClientEnum clientEnum;
    private PalletTypeEnum palletTypeEnum;
    private Long countReturned;
    private LocalDate returnedDate;

    public ReturnedPalletsServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientEnum getClientEnum() {
        return clientEnum;
    }

    public void setClientEnum(ClientEnum clientEnum) {
        this.clientEnum = clientEnum;
    }

    public PalletTypeEnum getPalletTypeEnum() {
        return palletTypeEnum;
    }

    public void setPalletTypeEnum(PalletTypeEnum palletTypeEnum) {
        this.palletTypeEnum = palletTypeEnum;
    }

    public Long getCountReturned() {
        return countReturned;
    }

    public void setCountReturned(Long countReturned) {
        this.countReturned = countReturned;
    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }
}
