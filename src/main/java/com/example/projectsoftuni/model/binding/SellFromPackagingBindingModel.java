package com.example.projectsoftuni.model.binding;

import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.ClientEnum;
import com.example.projectsoftuni.model.entity.enums.PackagingCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.PalletTypeEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class SellFromPackagingBindingModel {

    private CategoryEggEnum egg;
    private PackagingCartonsEnum packagingCartonsEnum;
    private Long count;
    private LocalDate date;
    private double price;
    private ClientEnum clientEnum;
    private PalletTypeEnum palletTypeEnum;
    private Long countIssuedPallets;

    public SellFromPackagingBindingModel() {
    }

    @NotNull(message = "Cannot be empty")
    public CategoryEggEnum getEgg() {
        return egg;
    }

    public void setEgg(CategoryEggEnum egg) {
        this.egg = egg;
    }

    @NotNull(message = "Cannot be empty")
    public PackagingCartonsEnum getPackagingCartonsEnum() {
        return packagingCartonsEnum;
    }

    public void setPackagingCartonsEnum(PackagingCartonsEnum packagingCartonsEnum) {
        this.packagingCartonsEnum = packagingCartonsEnum;
    }

    @NotNull(message = "Cannot be empty")
    @Positive(message = "Must be positive number")
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @PastOrPresent(message = "Date cannot be in future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
    @Positive(message = "Must be positive")
    public Long getCountIssuedPallets() {
        return countIssuedPallets;
    }

    public void setCountIssuedPallets(Long countIssuedPallets) {
        this.countIssuedPallets = countIssuedPallets;
    }
}
