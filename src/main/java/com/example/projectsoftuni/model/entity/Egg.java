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
    private CategoryHaleEnum hale;
    private LocalDate addDate;

    public Egg() {
    }

    @Enumerated(EnumType.STRING)
    public CategoryBaseEnum getBase() {
        return base;
    }

    public void setBase(CategoryBaseEnum base) {
        this.base = base;
    }

    @Column(name = "countOfEgg")
    public Long getCountOfEgg() {
        return countOfEgg;
    }

    public void setCountOfEgg(Long countOfEgg) {
        this.countOfEgg = countOfEgg;
    }

    @Enumerated(EnumType.STRING)
    public CategoryEggEnum getEgg() {
        return egg;
    }

    public void setEgg(CategoryEggEnum egg) {
        this.egg = egg;
    }

    @Enumerated(EnumType.STRING)
    public CategoryCartonsEnum getCartons() {
        return cartons;
    }

    public void setCartons(CategoryCartonsEnum cartons) {
        this.cartons = cartons;
    }

    @Enumerated(EnumType.STRING)
    public CategoryHaleEnum getHale() {
        return hale;
    }

    public void setHale(CategoryHaleEnum hale) {
        this.hale = hale;
    }


    @Column(name = "addDate")
    public LocalDate getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDate addDate) {
        this.addDate = addDate;
    }
}
