package com.example.projectsoftuni.model.entity;

import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.MaterialEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "materialOnBase")
public class MaterialOnBase extends BaseEntity{

    private MaterialEnum materialEnum;
    private CategoryBaseEnum categoryBaseEnum;
    private Long materialCount;
    private LocalDate addDate;

    public MaterialOnBase() {
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "type",nullable = false)
    public MaterialEnum getMaterialEnum() {
        return materialEnum;
    }

    public void setMaterialEnum(MaterialEnum materialEnum) {
        this.materialEnum = materialEnum;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "base",nullable = false)
    public CategoryBaseEnum getCategoryBaseEnum() {
        return categoryBaseEnum;
    }

    public void setCategoryBaseEnum(CategoryBaseEnum categoryBaseEnum) {
        this.categoryBaseEnum = categoryBaseEnum;
    }

    @Column(name = "count",nullable = false)
    public Long getMaterialCount() {
        return materialCount;
    }

    public void setMaterialCount(Long materialCount) {
        this.materialCount = materialCount;
    }

    @Column(name = "addDate", nullable = false)
    public LocalDate getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDate addDate) {
        this.addDate = addDate;
    }
}
