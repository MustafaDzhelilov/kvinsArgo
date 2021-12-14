package com.example.projectsoftuni.model.entity;

import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "cartonCategories")
public class CartonCategory extends BaseEntity{

    private CategoryCartonsEnum cartons;

    public CartonCategory(CategoryCartonsEnum categoryCartonsEnum) {
        this.cartons = categoryCartonsEnum;
    }

    public CartonCategory() {
    }

    @Enumerated(EnumType.STRING)
    public CategoryCartonsEnum getCartons() {
        return cartons;
    }

    public void setCartons(CategoryCartonsEnum cartons) {
        this.cartons = cartons;
    }
}
