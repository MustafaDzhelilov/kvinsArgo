package com.example.projectsoftuni.model.view;

import com.example.projectsoftuni.model.entity.enums.ClientEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Configuration
public class SearchFromToWithClientViewModel {

    private ClientEnum clientEnum;
    private LocalDate start;
    private LocalDate end;

    public SearchFromToWithClientViewModel() {
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
