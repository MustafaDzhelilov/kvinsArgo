package com.example.projectsoftuni.model.entity;

import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "haleCategory")
public class HaleCategory extends BaseEntity{

    private CategoryHaleEnum hale;

    public HaleCategory(CategoryHaleEnum categoryHaleEnum) {
        this.hale = categoryHaleEnum;
    }

    public HaleCategory() {
    }

    @Enumerated(EnumType.STRING)
    public CategoryHaleEnum getHale() {
        return hale;
    }

    public void setHale(CategoryHaleEnum hale) {
        this.hale = hale;
    }
}
