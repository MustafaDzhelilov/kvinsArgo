package com.example.projectsoftuni.model.view;

import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class SearchFromToViewModel {

    private CategoryEggEnum categoryEggEnum;
    private LocalDate start;
    private LocalDate end;

    public SearchFromToViewModel() {
    }

    public CategoryEggEnum getCategoryEggEnum() {
        return categoryEggEnum;
    }

    public void setCategoryEggEnum(CategoryEggEnum categoryEggEnum) {
        this.categoryEggEnum = categoryEggEnum;
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
