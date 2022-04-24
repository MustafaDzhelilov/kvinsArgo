package com.example.projectsoftuni.model.service;

import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.ClientEnum;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class SearchSellFromToWithClientServiceModel {

    private Long id;
    private ClientEnum clientEnum;
    private LocalDate start;
    private LocalDate end;

    public SearchSellFromToWithClientServiceModel() {
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

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }
}
