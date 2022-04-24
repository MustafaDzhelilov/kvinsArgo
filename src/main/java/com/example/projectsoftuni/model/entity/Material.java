package com.example.projectsoftuni.model.entity;

import com.example.projectsoftuni.model.entity.enums.MaterialEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "material")
public class Material extends BaseEntity{

    private MaterialEnum materialEnum;
    private Long materialCount;
    private LocalDate addDate;
    private String userName;

    public Material() {
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "type",nullable = false)
    public MaterialEnum getMaterialEnum() {
        return materialEnum;
    }

    public void setMaterialEnum(MaterialEnum materialEnum) {
        this.materialEnum = materialEnum;
    }

    @Column(name = "count",nullable = false)
    public Long getMaterialCount() {
        return materialCount;
    }

    public void setMaterialCount(Long materialCount) {
        this.materialCount = materialCount;
    }

    @Column(name = "addDate", nullable = false)
    public LocalDate getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDate addDate) {
        this.addDate = addDate;
    }

    @Column(name = "username")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
