package com.example.projectsoftuni.model.binding;

import com.example.projectsoftuni.model.entity.enums.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class ExportBindingModel {

    private CategoryBaseEnum categoryBaseEnum;
    private CategoryCartonsEnum categoryCartonsEnum;
    private CategoryEggEnum categoryEggEnum;
    private TypeExportEnum typeExportEnum;
    private ClientEnum clientEnum;
    private PalletTypeEnum palletTypeEnum;
    private Long countPallet;
    private Long typeOfCorner;
    private Long typeOfPaper;
    private LocalDate date;
    private double price;

    public ExportBindingModel() {
    }

    @NotNull(message = "Cannot be empty")
    public CategoryBaseEnum getCategoryBaseEnum() {
        return categoryBaseEnum;
    }

    public void setCategoryBaseEnum(CategoryBaseEnum categoryBaseEnum) {
        this.categoryBaseEnum = categoryBaseEnum;
    }

    @NotNull(message = "Cannot be empty")
    public TypeExportEnum getTypeExportEnum() {
        return typeExportEnum;
    }

    public void setTypeExportEnum(TypeExportEnum typeExportEnum) {
        this.typeExportEnum = typeExportEnum;
    }

    @NotNull(message = "Cannot be empty")
    public CategoryEggEnum getCategoryEggEnum() {
        return categoryEggEnum;
    }

    public void setCategoryEggEnum(CategoryEggEnum categoryEggEnum) {
        this.categoryEggEnum = categoryEggEnum;
    }

    @NotNull(message = "Cannot be empty")
    public CategoryCartonsEnum getCategoryCartonsEnum() {
        return categoryCartonsEnum;
    }

    public void setCategoryCartonsEnum(CategoryCartonsEnum categoryCartonsEnum) {
        this.categoryCartonsEnum = categoryCartonsEnum;
    }

    @NotNull(message = "Cannot be empty")
    public PalletTypeEnum getPalletTypeEnum() {
        return palletTypeEnum;
    }

    public void setPalletTypeEnum(PalletTypeEnum palletTypeEnum) {
        this.palletTypeEnum = palletTypeEnum;
    }

    @NotNull(message = "Cannot be empty")
    public ClientEnum getClientEnum() {
        return clientEnum;
    }

    public void setClientEnum(ClientEnum clientEnum) {
        this.clientEnum = clientEnum;
    }

    @NotNull(message = "Cannot be empty")
    @Positive(message = "Must be positive number")
    public Long getTypeOfCorner() {
        return typeOfCorner;
    }

    public void setTypeOfCorner(Long typeOfCorner) {
        this.typeOfCorner = typeOfCorner;
    }

    @NotNull(message = "Cannot be empty")
    @Positive(message = "Must be positive number")
    public Long getTypeOfPaper() {
        return typeOfPaper;
    }

    public void setTypeOfPaper(Long typeOfPaper) {
        this.typeOfPaper = typeOfPaper;
    }

    @NotNull(message = "Cannot be empty")
    @Positive(message = "Must be positive number")
    public Long getCountPallet() {
        return countPallet;
    }

    public void setCountPallet(Long countPallet) {
        this.countPallet = countPallet;
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
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
