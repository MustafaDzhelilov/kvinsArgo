package com.example.projectsoftuni.model.entity;

import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.ClientEnum;
import com.example.projectsoftuni.model.entity.enums.PackagingCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.PalletTypeEnum;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Entity
@Table(name = "sellsFromPackaging")
public class SellFromPackaging extends BaseEntity{

    private CategoryEggEnum egg;
    private PackagingCartonsEnum packagingCartonsEnum;
    private Long count;
    private LocalDate date;
    private double price;
    private ClientEnum clientEnum;
    private PalletTypeEnum palletTypeEnum;
    private Long countIssuedPallets;
    private double totalPrice;

    public SellFromPackaging() {
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "egg",nullable = false)
    public CategoryEggEnum getEgg() {
        return egg;
    }

    public void setEgg(CategoryEggEnum egg) {
        this.egg = egg;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "carton",nullable = false)
    public PackagingCartonsEnum getPackagingCartonsEnum() {
        return packagingCartonsEnum;
    }

    public void setPackagingCartonsEnum(PackagingCartonsEnum packagingCartonsEnum) {
        this.packagingCartonsEnum = packagingCartonsEnum;
    }

    @Column(name = "countOfEgg",nullable = false)
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Column(name = "date", nullable = false)
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column(name = "price", nullable = false)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "client",nullable = false)
    public ClientEnum getClientEnum() {
        return clientEnum;
    }

    public void setClientEnum(ClientEnum clientEnum) {
        this.clientEnum = clientEnum;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "palletsType",nullable = false)
    public PalletTypeEnum getPalletTypeEnum() {
        return palletTypeEnum;
    }

    public void setPalletTypeEnum(PalletTypeEnum palletTypeEnum) {
        this.palletTypeEnum = palletTypeEnum;
    }

    @Column(name = "totalPrice", nullable = false)
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Column(name = "issuedPallets", nullable = false)
    public Long getCountIssuedPallets() {
        return countIssuedPallets;
    }

    public void setCountIssuedPallets(Long countIssuedPallets) {
        this.countIssuedPallets = countIssuedPallets;
    }
}
