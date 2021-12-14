package com.example.projectsoftuni.model.entity;

import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "cartons")
public class Cartons  extends  BaseEntity{

    private CategoryCartonsEnum cartons;
    private CategoryBaseEnum base;
    private Long count;
    private LocalDateTime date;

    public Cartons() {
    }

    @Enumerated(EnumType.STRING)
    public CategoryCartonsEnum getCartons() {
        return cartons;
    }

    public void setCartons(CategoryCartonsEnum cartons) {
        this.cartons = cartons;
    }

    @Enumerated(EnumType.STRING)
    public CategoryBaseEnum getBase() {
        return base;
    }

    public void setBase(CategoryBaseEnum base) {
        this.base = base;
    }

    @Column(name = "count")
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Column(name = "date")
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
