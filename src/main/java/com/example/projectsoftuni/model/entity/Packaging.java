package com.example.projectsoftuni.model.entity;

import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "packaging")
public class Packaging extends BaseEntity{

    private CategoryEggEnum categoryEggEnum;
    private CategoryCartonsEnum categoryCartonsEnum;
    private CategoryBaseEnum categoryBaseEnum;
    private Long count;
    private LocalDate transferDate;

    public Packaging() {
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "EggType",nullable = false)
    public CategoryEggEnum getCategoryEggEnum() {
        return categoryEggEnum;
    }

    public void setCategoryEggEnum(CategoryEggEnum categoryEggEnum) {
        this.categoryEggEnum = categoryEggEnum;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "CartonType",nullable = false)
    public CategoryCartonsEnum getCategoryCartonsEnum() {
        return categoryCartonsEnum;
    }

    public void setCategoryCartonsEnum(CategoryCartonsEnum categoryCartonsEnum) {
        this.categoryCartonsEnum = categoryCartonsEnum;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "BaseType")
    public CategoryBaseEnum getCategoryBaseEnum() {
        return categoryBaseEnum;
    }

    public void setCategoryBaseEnum(CategoryBaseEnum categoryBaseEnum) {
        this.categoryBaseEnum = categoryBaseEnum;
    }

    @Column(name = "Count",nullable = false)
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Column(name = "TransferDate", nullable = false)
    public LocalDate getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }
}
