package com.example.projectsoftuni.model.service;

import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.ClientEnum;
import com.example.projectsoftuni.model.entity.enums.PackagingCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.PalletTypeEnum;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class SellFromPackagingServiceModel {

    private Long id;
    private CategoryEggEnum egg;
    private PackagingCartonsEnum packagingCartonsEnum;
    private Long count;
    private LocalDate date;
    private double price;
    private ClientEnum clientEnum;
    private PalletTypeEnum palletTypeEnum;
    private Long countIssuedPallets;

    public SellFromPackagingServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryEggEnum getEgg() {
        return egg;
    }

    public void setEgg(CategoryEggEnum egg) {
        this.egg = egg;
    }

    public PackagingCartonsEnum getPackagingCartonsEnum() {
        return packagingCartonsEnum;
    }

    public void setPackagingCartonsEnum(PackagingCartonsEnum packagingCartonsEnum) {
        this.packagingCartonsEnum = packagingCartonsEnum;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public Long getCountIssuedPallets() {
        return countIssuedPallets;
    }

    public void setCountIssuedPallets(Long countIssuedPallets) {
        this.countIssuedPallets = countIssuedPallets;
    }
}
