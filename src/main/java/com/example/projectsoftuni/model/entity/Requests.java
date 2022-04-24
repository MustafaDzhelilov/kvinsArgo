package com.example.projectsoftuni.model.entity;

import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.ClientEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "requests")
public class Requests extends BaseEntity{

    private ClientEnum clientEnum;
    private CategoryEggEnum categoryEggEnum;
    private CategoryCartonsEnum categoryCartonsEnum;
    private Long count;
    private Long sellCount;
    private LocalDate requestsDate;

    public Requests() {
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "client",nullable = false)
    public ClientEnum getClientEnum() {
        return clientEnum;
    }

    public void setClientEnum(ClientEnum clientEnum) {
        this.clientEnum = clientEnum;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "egg",nullable = false)
    public CategoryEggEnum getCategoryEggEnum() {
        return categoryEggEnum;
    }

    public void setCategoryEggEnum(CategoryEggEnum categoryEggEnum) {
        this.categoryEggEnum = categoryEggEnum;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "carton",nullable = false)
    public CategoryCartonsEnum getCategoryCartonsEnum() {
        return categoryCartonsEnum;
    }

    public void setCategoryCartonsEnum(CategoryCartonsEnum categoryCartonsEnum) {
        this.categoryCartonsEnum = categoryCartonsEnum;
    }

    @Column(name = "count",nullable = false)
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Column(name = "requestsDate", nullable = false)
    public LocalDate getRequestsDate() {
        return requestsDate;
    }

    public void setRequestsDate(LocalDate requestsDate) {
        this.requestsDate = requestsDate;
    }

    @Column(name = "sellCount")
    public Long getSellCount() {
        return sellCount;
    }

    public void setSellCount(Long sellCount) {
        this.sellCount = sellCount;
    }
}
