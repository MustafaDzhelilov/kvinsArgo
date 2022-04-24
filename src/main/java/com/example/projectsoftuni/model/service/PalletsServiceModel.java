package com.example.projectsoftuni.model.service;

import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.PalletTypeEnum;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class PalletsServiceModel {
    private Long id;
    private CategoryBaseEnum categoryBaseEnum;
    private PalletTypeEnum palletTypeEnum;
    private Long count;
    private LocalDate localDate;

    public PalletsServiceModel() {
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

    public PalletTypeEnum getPalletTypeEnum() {
        return palletTypeEnum;
    }

    public void setPalletTypeEnum(PalletTypeEnum palletTypeEnum) {
        this.palletTypeEnum = palletTypeEnum;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
