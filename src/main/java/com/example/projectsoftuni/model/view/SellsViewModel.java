package com.example.projectsoftuni.model.view;

import com.example.projectsoftuni.model.entity.Client;
import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;

import java.time.LocalDate;

public class SellsViewModel {

    private Long id;
    private CategoryEggEnum egg;
    private CategoryBaseEnum base;
    private Long countOfEgg;
    private CategoryCartonsEnum cartons;
    private LocalDate addDate;
    private Client client;

    public SellsViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryEggEnum getEgg() {
        return egg;
    }

    public void setEgg(CategoryEggEnum egg) {
        this.egg = egg;
    }

    public CategoryBaseEnum getBase() {
        return base;
    }

    public void setBase(CategoryBaseEnum base) {
        this.base = base;
    }

    public Long getCountOfEgg() {
        return countOfEgg;
    }

    public void setCountOfEgg(Long countOfEgg) {
        this.countOfEgg = countOfEgg;
    }

    public CategoryCartonsEnum getCartons() {
        return cartons;
    }

    public void setCartons(CategoryCartonsEnum cartons) {
        this.cartons = cartons;
    }

    public LocalDate getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDate addDate) {
        this.addDate = addDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
