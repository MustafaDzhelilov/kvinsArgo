package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.entity.Client;
import com.example.projectsoftuni.model.entity.Sells;
import com.example.projectsoftuni.model.service.SellsServiceModel;
import com.example.projectsoftuni.model.view.SellsViewModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SellsService {


    void addSell(SellsServiceModel sellsServiceModel);

    List<Sells> findLastSellsByDate(LocalDate now);

    List<SellsViewModel> getAllSells();

}
