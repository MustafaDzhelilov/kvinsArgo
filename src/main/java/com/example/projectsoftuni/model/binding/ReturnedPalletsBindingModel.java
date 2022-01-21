package com.example.projectsoftuni.model.binding;

import com.example.projectsoftuni.model.entity.enums.ClientEnum;
import com.example.projectsoftuni.model.entity.enums.PalletTypeEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class ReturnedPalletsBindingModel {

    private ClientEnum clientEnum;
    private PalletTypeEnum palletTypeEnum;
    private Long countReturned;
    private LocalDate returnedDate;

    public ReturnedPalletsBindingModel() {
    }

    @NotNull(message = "Cannot be empty")
    public ClientEnum getClientEnum() {
        return clientEnum;
    }

    public void setClientEnum(ClientEnum clientEnum) {
        this.clientEnum = clientEnum;
    }

    @NotNull(message = "Cannot be empty")
    public PalletTypeEnum getPalletTypeEnum() {
        return palletTypeEnum;
    }

    public void setPalletTypeEnum(PalletTypeEnum palletTypeEnum) {
        this.palletTypeEnum = palletTypeEnum;
    }

    @NotNull(message = "Cannot be empty")
    @Positive(message = "Must be positive!")
    public Long getCountReturned() {
        return countReturned;
    }

    public void setCountReturned(Long countReturned) {
        this.countReturned = countReturned;
    }

    @PastOrPresent(message = "Date cannot be in future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }
}
