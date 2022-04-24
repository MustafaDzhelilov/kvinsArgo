package com.example.projectsoftuni.model.entity;

import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;

import javax.persistence.*;

@Entity
@Table(name = "CoreyFreeAfterPackaging")
public class CoreyFreeAfterPackaging extends BaseEntity{

    private CategoryCartonsEnum cartons;
    private Long count;

    public CoreyFreeAfterPackaging() {
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "cartons",nullable = false)
    public CategoryCartonsEnum getCartons() {
        return cartons;
    }

    public void setCartons(CategoryCartonsEnum cartons) {
        this.cartons = cartons;
    }

    @Column(name = "count", nullable = false)
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}


