package com.example.projectsoftuni.model.entity;

import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@DynamicUpdate
@Table(name = "hales")
public class Hale extends BaseEntity{

    private CategoryHaleEnum hale;
    private Long countOfHens;
    private Long countOfDelHens;
    private LocalDate created;

    public Hale() {
    }

    @Enumerated(EnumType.STRING)
    public CategoryHaleEnum getHale() {
        return hale;
    }

    public void setHale(CategoryHaleEnum hale) {
        this.hale = hale;
    }

    @Column(name = "countOfHens")
    public Long getCountOfHens() {
        return countOfHens;
    }

    public void setCountOfHens(Long countOfHens) {
        this.countOfHens = countOfHens;
    }


    @Column(name = "countOfDelHens")
    public Long getCountOfDelHens() {
        return countOfDelHens;
    }

    public void setCountOfDelHens(Long countOfDelHens) {
        this.countOfDelHens = countOfDelHens;
    }

    @Column(name = "created")
    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }
}
