package com.example.projectsoftuni.model.entity;

import com.example.projectsoftuni.model.entity.enums.CategorySiloEnum;
import com.example.projectsoftuni.model.entity.enums.CategorySupplierEnum;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "fodder")
public class Fodder extends BaseEntity{

    private CategorySiloEnum siloEnum;
    private Long kilogramOfFodder;
    private LocalDate acceptedTime;

    public Fodder() {
    }

    @Enumerated(EnumType.STRING)
    public CategorySiloEnum getSiloEnum() {
        return siloEnum;
    }

    public void setSiloEnum(CategorySiloEnum siloEnum) {
        this.siloEnum = siloEnum;
    }


    @Column(name = "kilogramOfFodder",nullable = false)
    public Long getKilogramOfFodder() {
        return kilogramOfFodder;
    }

    public void setKilogramOfFodder(Long kilogramOfFodder) {
        this.kilogramOfFodder = kilogramOfFodder;
    }


    @Column(name = "acceptedTime", nullable = false)
    public LocalDate getAcceptedTime() {
        return acceptedTime;
    }

    public void setAcceptedTime(LocalDate acceptedTime) {
        this.acceptedTime = acceptedTime;
    }
}
