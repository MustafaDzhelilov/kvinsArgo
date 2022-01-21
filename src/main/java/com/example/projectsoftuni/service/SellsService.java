package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.entity.Sells;
import com.example.projectsoftuni.model.service.SearchSellFromToServiceModel;
import com.example.projectsoftuni.model.service.SellsServiceModel;
import com.example.projectsoftuni.model.view.SellsViewModel;

import java.time.LocalDate;
import java.util.List;

public interface SellsService {


    void addSell(SellsServiceModel sellsServiceModel);

    List<Sells> findLastSellsByDate(LocalDate now);

    List<SellsViewModel> getAllSells();

    Long getIssuedPallCount();

    Long getIssuedPallCountT();

    Long getIssuedPallCountAkvTermo();

    Long getIssuedPallCountTTermo();

    Long fromTo(SearchSellFromToServiceModel searchSellFromToServiceModel);

}
