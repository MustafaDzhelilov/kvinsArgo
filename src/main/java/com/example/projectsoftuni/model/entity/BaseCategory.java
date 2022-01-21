package com.example.projectsoftuni.model.entity;

import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "baseCategories")
public class BaseCategory extends BaseEntity{

    private CategoryBaseEnum base;

    public BaseCategory(CategoryBaseEnum categoryBaseEnum) {
        this.base = categoryBaseEnum;
    }

    public BaseCategory() {
    }

    @Enumerated(EnumType.STRING)
    public CategoryBaseEnum getBase() {
        return base;
    }

    public void setBase(CategoryBaseEnum base) {
        this.base = base;
    }
}
