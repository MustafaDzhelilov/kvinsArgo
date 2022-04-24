package com.example.projectsoftuni.model.entity;


import com.example.projectsoftuni.model.entity.enums.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "export")
public class Export extends BaseEntity{

    private CategoryBaseEnum categoryBaseEnum;
    private CategoryPaperSheetEnum categoryPaperSheetEnum;
    private CategoryPaperCornerEnum categoryPaperCornerEnum;
    private CategoryCartonsEnum categoryCartonsEnum;
    private CategoryEggEnum categoryEggEnum;
    private TypeExportEnum typeExportEnum;
    private PalletTypeEnum palletTypeEnum;
    private ClientEnum clientEnum;
    private Long countPallet;
    private LocalDate date;
    private Long countEgg;
    private double price;
    private double totalPrice;

    public Export() {
    }

    @Enumerated(EnumType.STRING)
    public CategoryBaseEnum getCategoryBaseEnum() {
        return categoryBaseEnum;
    }

    public void setCategoryBaseEnum(CategoryBaseEnum categoryBaseEnum) {
        this.categoryBaseEnum = categoryBaseEnum;
    }

    @Enumerated(EnumType.STRING)
    public TypeExportEnum getTypeExportEnum() {
        return typeExportEnum;
    }

    public void setTypeExportEnum(TypeExportEnum typeExportEnum) {
        this.typeExportEnum = typeExportEnum;
    }

    @Enumerated(EnumType.STRING)
    public CategoryEggEnum getCategoryEggEnum() {
        return categoryEggEnum;
    }

    public void setCategoryEggEnum(CategoryEggEnum categoryEggEnum) {
        this.categoryEggEnum = categoryEggEnum;
    }

    @Enumerated(EnumType.STRING)
    public CategoryCartonsEnum getCategoryCartonsEnum() {
        return categoryCartonsEnum;
    }

    public void setCategoryCartonsEnum(CategoryCartonsEnum categoryCartonsEnum) {
        this.categoryCartonsEnum = categoryCartonsEnum;
    }

    @Enumerated(EnumType.STRING)
    public ClientEnum getClientEnum() {
        return clientEnum;
    }

    public void setClientEnum(ClientEnum clientEnum) {
        this.clientEnum = clientEnum;
    }

    @Enumerated(EnumType.STRING)
    public CategoryPaperSheetEnum getCategoryPaperSheetEnum() {
        return categoryPaperSheetEnum;
    }

    public void setCategoryPaperSheetEnum(CategoryPaperSheetEnum categoryPaperSheetEnum) {
        this.categoryPaperSheetEnum = categoryPaperSheetEnum;
    }

    @Enumerated(EnumType.STRING)
    public CategoryPaperCornerEnum getCategoryPaperCornerEnum() {
        return categoryPaperCornerEnum;
    }

    public void setCategoryPaperCornerEnum(CategoryPaperCornerEnum categoryPaperCornerEnum) {
        this.categoryPaperCornerEnum = categoryPaperCornerEnum;
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

    @Enumerated(EnumType.STRING)
    public PalletTypeEnum getPalletTypeEnum() {
        return palletTypeEnum;
    }

    public void setPalletTypeEnum(PalletTypeEnum palletTypeEnum) {
        this.palletTypeEnum = palletTypeEnum;
    }

    public Long getCountEgg() {
        return countEgg;
    }

    public void setCountEgg(Long countEgg) {
        this.countEgg = countEgg;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
