package com.example.projectsoftuni.model.service;

import com.example.projectsoftuni.model.entity.enums.MaterialEnum;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class MaterialServiceModel {

    private Long id;
    private MaterialEnum materialEnum;
    private Long materialCount;
    private LocalDate addDate;

    public MaterialServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MaterialEnum getMaterialEnum() {
        return materialEnum;
    }

    public void setMaterialEnum(MaterialEnum materialEnum) {
        this.materialEnum = materialEnum;
    }

    public Long getMaterialCount() {
        return materialCount;
    }

    public void setMaterialCount(Long materialCount) {
        this.materialCount = materialCount;
    }

    public LocalDate getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDate addDate) {
        this.addDate = addDate;
    }
}
