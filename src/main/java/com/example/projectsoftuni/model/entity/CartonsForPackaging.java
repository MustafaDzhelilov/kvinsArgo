package com.example.projectsoftuni.model.entity;

import com.example.projectsoftuni.model.entity.enums.PackagingCartonsEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CartonsForPackaging")
public class CartonsForPackaging extends BaseEntity{

    private PackagingCartonsEnum packagingCartonsEnum;
    private Long count;
    private LocalDate date;

    public CartonsForPackaging() {
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "cartons",nullable = false)
    public PackagingCartonsEnum getPackagingCartonsEnum() {
        return packagingCartonsEnum;
    }

    public void setPackagingCartonsEnum(PackagingCartonsEnum packagingCartonsEnum) {
        this.packagingCartonsEnum = packagingCartonsEnum;
    }

    @Column(name = "count",nullable = false)
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Column(name = "date", nullable = false)
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
