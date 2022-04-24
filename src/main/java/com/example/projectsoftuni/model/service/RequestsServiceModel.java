package com.example.projectsoftuni.model.service;

import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.ClientEnum;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class RequestsServiceModel {


    private Long id;
    private ClientEnum clientEnum;
    private CategoryEggEnum categoryEggEnum;
    private CategoryCartonsEnum categoryCartonsEnum;
    private Long count;
    private Long sellCount;
    private LocalDate requestsDate;

    public RequestsServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientEnum getClientEnum() {
        return clientEnum;
    }

    public void setClientEnum(ClientEnum clientEnum) {
        this.clientEnum = clientEnum;
    }

    public CategoryEggEnum getCategoryEggEnum() {
        return categoryEggEnum;
    }

    public void setCategoryEggEnum(CategoryEggEnum categoryEggEnum) {
        this.categoryEggEnum = categoryEggEnum;
    }

    public CategoryCartonsEnum getCategoryCartonsEnum() {
        return categoryCartonsEnum;
    }

    public void setCategoryCartonsEnum(CategoryCartonsEnum categoryCartonsEnum) {
        this.categoryCartonsEnum = categoryCartonsEnum;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public LocalDate getRequestsDate() {
        return requestsDate;
    }

    public void setRequestsDate(LocalDate requestsDate) {
        this.requestsDate = requestsDate;
    }

    public Long getSellCount() {
        return sellCount;
    }

    public void setSellCount(Long sellCount) {
        this.sellCount = sellCount;
    }
}
