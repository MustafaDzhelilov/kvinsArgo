package com.example.projectsoftuni.model.service;

import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.MaterialEnum;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class MaterialOnBaseServiceModel {

    private Long id;
    private MaterialEnum materialEnum;
    private CategoryBaseEnum categoryBaseEnum;
    private Long materialCount;
    private LocalDate addDate;

    public MaterialOnBaseServiceModel() {
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

    public CategoryBaseEnum getCategoryBaseEnum() {
        return categoryBaseEnum;
    }

    public void setCategoryBaseEnum(CategoryBaseEnum categoryBaseEnum) {
        this.categoryBaseEnum = categoryBaseEnum;
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
