package com.example.projectsoftuni.model.entity;

import com.example.projectsoftuni.model.entity.enums.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "sells")
public class Sells extends BaseEntity{

    private CategoryEggEnum egg;
    private CategoryBaseEnum base;
    private Long countOfEgg;
    private CategoryCartonsEnum cartons;
    private LocalDateTime addDate;
    private double price;
    private ClientEnum clientEnum;
    private PalletTypeEnum palletTypeEnum;
    private double totalPrice;
    private Long countIssuedPallets;

    public Sells() {
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "base",nullable = false)
    public CategoryBaseEnum getBase() {
        return base;
    }

    public void setBase(CategoryBaseEnum base) {
        this.base = base;
    }

    @Column(name = "countOfEgg",nullable = false)
    public Long getCountOfEgg() {
        return countOfEgg;
    }

    public void setCountOfEgg(Long countOfEgg) {
        this.countOfEgg = countOfEgg;
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
    @Column(name = "cartons",nullable = false)
    public CategoryCartonsEnum getCartons() {
        return cartons;
    }

    public void setCartons(CategoryCartonsEnum cartons) {
        this.cartons = cartons;
    }


    @Column(name = "addDate", nullable = false)
    public LocalDateTime getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDateTime addDate) {
        this.addDate = addDate;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "client",nullable = false)
    public ClientEnum getClientEnum() {
        return clientEnum;
    }

    public void setClientEnum(ClientEnum clientEnum) {
        this.clientEnum = clientEnum;
    }

    @Column(name = "price", nullable = false)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
