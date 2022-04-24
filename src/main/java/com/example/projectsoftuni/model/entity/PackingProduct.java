package com.example.projectsoftuni.model.entity;

import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.PackagingCartonsEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PackingProducts")
public class PackingProduct extends BaseEntity{

    private CategoryEggEnum categoryEggEnum;
    private CategoryCartonsEnum categoryCartonsEnum;
    private PackagingCartonsEnum packagingCartonsEnum;
    private Long count;
    private LocalDate packingDate;

    public PackingProduct() {
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
    @Column(name = "CartonType")
    public CategoryCartonsEnum getCategoryCartonsEnum() {
        return categoryCartonsEnum;
    }

    public void setCategoryCartonsEnum(CategoryCartonsEnum categoryCartonsEnum) {
        this.categoryCartonsEnum = categoryCartonsEnum;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "PackingType",nullable = false)
    public PackagingCartonsEnum getPackagingCartonsEnum() {
        return packagingCartonsEnum;
    }

    public void setPackagingCartonsEnum(PackagingCartonsEnum packagingCartonsEnum) {
        this.packagingCartonsEnum = packagingCartonsEnum;
    }

    @Column(name = "Count",nullable = false)
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Column(name = "PackingDate",nullable = false)
    public LocalDate getPackingDate() {
        return packingDate;
    }

    public void setPackingDate(LocalDate packingDate) {
        this.packingDate = packingDate;
    }
}
