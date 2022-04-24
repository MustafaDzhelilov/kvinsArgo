package com.example.projectsoftuni.model.binding;

import com.example.projectsoftuni.model.entity.enums.*;
import com.example.projectsoftuni.model.service.SellsServiceModel;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SellBindingModel {

    private CategoryEggEnum categoryEgg;
    private CategoryCartonsEnum categoryCartons;
    private CategoryBaseEnum categoryBase;
    private Long countOfEgg;
    private ClientEnum clientEnum;
    private LocalDateTime addDate;
    private double price;
    private PalletTypeEnum palletTypeEnum;
    private Long countIssuedPallets;


    public SellBindingModel() {
    }

    @NotNull(message = "Cannot be empty")
    public CategoryEggEnum getCategoryEgg() {
        return categoryEgg;
    }

    public void setCategoryEgg(CategoryEggEnum categoryEgg) {
        this.categoryEgg = categoryEgg;
    }

    @NotNull(message = "Cannot be empty")
    public CategoryCartonsEnum getCategoryCartons() {
        return categoryCartons;
    }

    public void setCategoryCartons(CategoryCartonsEnum categoryCartons) {
        this.categoryCartons = categoryCartons;
    }


    @NotNull(message = "Cannot be empty")
    public CategoryBaseEnum getCategoryBase() {
        return categoryBase;
    }

    public void setCategoryBase(CategoryBaseEnum categoryBase) {
        this.categoryBase = categoryBase;
    }

    @Positive(message = "Must be positive number")
    public Long getCountOfEgg() {
        return countOfEgg;
    }

    public void setCountOfEgg(Long countOfEgg) {
        this.countOfEgg = countOfEgg;
    }

    @PastOrPresent(message = "Date cannot be in future")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    public LocalDateTime getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDateTime addDate) {
        this.addDate = addDate;
    }

    @NotNull(message = "Cannot be empty")
    public ClientEnum getClientEnum() {
        return clientEnum;
    }

    public void setClientEnum(ClientEnum clientEnum) {
        this.clientEnum = clientEnum;
    }

    @NotNull(message = "Cannot be empty")
    @Positive(message = "Must be positive")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @NotNull(message = "Cannot be empty")
    public PalletTypeEnum getPalletTypeEnum() {
        return palletTypeEnum;
    }

    public void setPalletTypeEnum(PalletTypeEnum palletTypeEnum) {
        this.palletTypeEnum = palletTypeEnum;
    }

    @NotNull(message = "Cannot be empty")
    @Positive(message = "Must be positive")
    public Long getCountIssuedPallets() {
        return countIssuedPallets;
    }

    public void setCountIssuedPallets(Long countIssuedPallets) {
        this.countIssuedPallets = countIssuedPallets;
    }
}
