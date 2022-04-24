package com.example.projectsoftuni.model.service;

import com.example.projectsoftuni.model.entity.enums.MaterialEnum;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SearchFromToMaterialServiceModel {

    private Long id;
    private LocalDate start;
    private LocalDate end;

    public SearchFromToMaterialServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
