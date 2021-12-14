package com.example.projectsoftuni.model.entity;

import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;

import javax.persistence.*;

@Entity
@Table(name = "eggsCategories")
public class EggCategory extends BaseEntity{

    private CategoryEggEnum egg;

    public EggCategory(CategoryEggEnum name) {
        this.egg = name;
    }

    public EggCategory() {

    }

    @Enumerated(EnumType.STRING)
    public CategoryEggEnum getEgg() {
        return egg;
    }

    public void setEgg(CategoryEggEnum egg) {
        this.egg = egg;
    }
}
