package com.example.projectsoftuni.model.service;

import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.PalletTypeEnum;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class TransferPalletsBetweenBaseServiceModel {

    private Long id;
    private CategoryBaseEnum from;
    private  CategoryBaseEnum to;
    private PalletTypeEnum palletTypeEnum;
    private Long count;
    private LocalDate date;

    public TransferPalletsBetweenBaseServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryBaseEnum getFrom() {
        return from;
    }

    public void setFrom(CategoryBaseEnum from) {
        this.from = from;
    }

    public CategoryBaseEnum getTo() {
        return to;
    }

    public void setTo(CategoryBaseEnum to) {
        this.to = to;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
