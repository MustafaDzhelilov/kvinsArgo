package com.example.projectsoftuni.model.binding;

import com.example.projectsoftuni.model.entity.enums.ClientEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class SearchSellTottalPriceByClientBindingModel {

    private LocalDate start;
    private LocalDate end;

    public SearchSellTottalPriceByClientBindingModel() {
    }

    @PastOrPresent(message = "Date cannot be in future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getStart() {
        return start;
    }


    public void setStart(LocalDate start) {
        this.start = start;
    }

    @PastOrPresent(message = "Date cannot be in future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }
}
