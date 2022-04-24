package com.example.projectsoftuni.model.entity;

import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "residueOfExtraction")
public class ResidueOfExtraction extends BaseEntity{

    private CategoryEggEnum egg;
    private CategoryBaseEnum base;
    private CategoryCartonsEnum cartons;
    private CategoryCartonsEnum coreyInCartons;
    private CategoryHaleEnum hale;
    private Long countOfEgg;
    private LocalDate addDate;

    public ResidueOfExtraction() {
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "eggType",nullable = false)
    public CategoryEggEnum getEgg() {
        return egg;
    }

    public void setEgg(CategoryEggEnum egg) {
        this.egg = egg;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "base",nullable = false)
    public CategoryBaseEnum getBase() {
        return base;
    }

    public void setBase(CategoryBaseEnum base) {
        this.base = base;
    }

    @Column(name = "countOfEgg",nullable = false)
    public Long getCountOfEgg() {
        return countOfEgg;
    }

    public void setCountOfEgg(Long countOfEgg) {
        this.countOfEgg = countOfEgg;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "hale",nullable = false)
    public CategoryHaleEnum getHale() {
        return hale;
    }

    public void setHale(CategoryHaleEnum hale) {
        this.hale = hale;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "cartons")
    public CategoryCartonsEnum getCartons() {
        return cartons;
    }

    public void setCartons(CategoryCartonsEnum cartons) {
        this.cartons = cartons;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "corey")
    public CategoryCartonsEnum getCoreyInCartons() {
        return coreyInCartons;
    }

    public void setCoreyInCartons(CategoryCartonsEnum coreyInCartons) {
        this.coreyInCartons = coreyInCartons;
    }

    @Column(name = "addDate",nullable = false)
    public LocalDate getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDate addDate) {
        this.addDate = addDate;
    }
}
