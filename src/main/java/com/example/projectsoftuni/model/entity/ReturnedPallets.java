package com.example.projectsoftuni.model.entity;

import com.example.projectsoftuni.model.entity.enums.ClientEnum;
import com.example.projectsoftuni.model.entity.enums.PalletTypeEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "returnedPallets")
public class ReturnedPallets extends BaseEntity{

    private ClientEnum clientEnum;
    private PalletTypeEnum palletTypeEnum;
    private Long countReturned;
    private LocalDate returnedDate;

    public ReturnedPallets() {
    }

    @Enumerated(EnumType.STRING)
    public ClientEnum getClientEnum() {
        return clientEnum;
    }

    public void setClientEnum(ClientEnum clientEnum) {
        this.clientEnum = clientEnum;
    }

    @Enumerated(EnumType.STRING)
    public PalletTypeEnum getPalletTypeEnum() {
        return palletTypeEnum;
    }

    public void setPalletTypeEnum(PalletTypeEnum palletTypeEnum) {
        this.palletTypeEnum = palletTypeEnum;
    }

    @Column(name = "countReturned",nullable = false)
    public Long getCountReturned() {
        return countReturned;
    }

    public void setCountReturned(Long countReturned) {
        this.countReturned = countReturned;
    }

    @Column(name = "returnedDate", nullable = false)
    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }
}
