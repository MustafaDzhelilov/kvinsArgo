package com.example.projectsoftuni.model.entity;

import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "eggs")
public class Egg extends BaseEntity{

    private CategoryEggEnum egg;
    private CategoryBaseEnum base;
    private Long countOfEgg;
    private CategoryCartonsEnum cartons;
    private CategoryCartonsEnum coreyInCartons;
    private CategoryHaleEnum hale;
    private LocalDate addDate;

    public Egg() {
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
    @Column(name = "egg",nullable = false)
    public CategoryEggEnum getEgg() {
        return egg;
    }

    public void setEgg(CategoryEggEnum egg) {
        this.egg = egg;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "cartons",nullable = false)
    public CategoryCartonsEnum getCartons() {
        return cartons;
    }

    public void setCartons(CategoryCartonsEnum cartons) {
        this.cartons = cartons;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "corey",length = 32, columnDefinition = "varchar(32) default 'UNKNOWN'")
    public CategoryCartonsEnum getCoreyInCartons() {
        return coreyInCartons;
    }

    public void setCoreyInCartons(CategoryCartonsEnum coreyInCartons) {
        this.coreyInCartons = coreyInCartons;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "hale")
    public CategoryHaleEnum getHale() {
        return hale;
    }

    public void setHale(CategoryHaleEnum hale) {
        this.hale = hale;
    }


    @Column(name = "addDate",nullable = false)
    public LocalDate getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDate addDate) {
        this.addDate = addDate;
    }
}
