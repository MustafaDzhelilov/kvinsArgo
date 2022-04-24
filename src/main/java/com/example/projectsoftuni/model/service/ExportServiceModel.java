package com.example.projectsoftuni.model.service;

import com.example.projectsoftuni.model.entity.enums.*;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class ExportServiceModel {

    private Long id;
    private CategoryBaseEnum categoryBaseEnum;
    private CategoryCartonsEnum categoryCartonsEnum;
    private CategoryEggEnum categoryEggEnum;
    private TypeExportEnum typeExportEnum;
    private PalletTypeEnum palletTypeEnum;
    private ClientEnum clientEnum;
    private Long countPallet;
    private Long typeOfCorner;
    private Long typeOfPaper;
    private LocalDate date;
    private double price;

    public ExportServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryBaseEnum getCategoryBaseEnum() {
        return categoryBaseEnum;
    }

    public void setCategoryBaseEnum(CategoryBaseEnum categoryBaseEnum) {
        this.categoryBaseEnum = categoryBaseEnum;
    }

    public TypeExportEnum getTypeExportEnum() {
        return typeExportEnum;
    }

    public void setTypeExportEnum(TypeExportEnum typeExportEnum) {
        this.typeExportEnum = typeExportEnum;
    }

    public CategoryEggEnum getCategoryEggEnum() {
        return categoryEggEnum;
    }

    public void setCategoryEggEnum(CategoryEggEnum categoryEggEnum) {
        this.categoryEggEnum = categoryEggEnum;
    }

    public CategoryCartonsEnum getCategoryCartonsEnum() {
        return categoryCartonsEnum;
    }

    public void setCategoryCartonsEnum(CategoryCartonsEnum categoryCartonsEnum) {
        this.categoryCartonsEnum = categoryCartonsEnum;
    }

    public Long getCountPallet() {
        return countPallet;
    }

    public void setCountPallet(Long countPallet) {
        this.countPallet = countPallet;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getTypeOfCorner() {
        return typeOfCorner;
    }

    public void setTypeOfCorner(Long typeOfCorner) {
        this.typeOfCorner = typeOfCorner;
    }

    public Long getTypeOfPaper() {
        return typeOfPaper;
    }

    public void setTypeOfPaper(Long typeOfPaper) {
        this.typeOfPaper = typeOfPaper;
    }

    public PalletTypeEnum getPalletTypeEnum() {
        return palletTypeEnum;
    }

    public void setPalletTypeEnum(PalletTypeEnum palletTypeEnum) {
        this.palletTypeEnum = palletTypeEnum;
    }

    public ClientEnum getClientEnum() {
        return clientEnum;
    }

    public void setClientEnum(ClientEnum clientEnum) {
        this.clientEnum = clientEnum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
