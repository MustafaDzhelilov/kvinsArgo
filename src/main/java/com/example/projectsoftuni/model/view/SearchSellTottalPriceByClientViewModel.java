package com.example.projectsoftuni.model.view;

import com.example.projectsoftuni.model.entity.enums.ClientEnum;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class SearchSellTottalPriceByClientViewModel {

    private Long id;
    private LocalDate start;
    private LocalDate end;

    public SearchSellTottalPriceByClientViewModel() {
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
