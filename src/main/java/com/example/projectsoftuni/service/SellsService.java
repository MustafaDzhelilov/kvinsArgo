package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.entity.Sells;
import com.example.projectsoftuni.model.entity.enums.ClientEnum;
import com.example.projectsoftuni.model.entity.enums.PalletTypeEnum;
import com.example.projectsoftuni.model.service.SearchSellFromToServiceModel;
import com.example.projectsoftuni.model.service.SearchSellFromToWithClientServiceModel;
import com.example.projectsoftuni.model.service.SearchSellTotalPriceByClientServiceModel;
import com.example.projectsoftuni.model.service.SellsServiceModel;
import com.example.projectsoftuni.model.view.SellsViewModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public interface SellsService {


    void addSell(SellsServiceModel sellsServiceModel);

    List<SellsViewModel> getAllSells();

    Long fromTo(SearchSellFromToServiceModel searchSellFromToServiceModel);

    List<Sells> getSells();

    Long fromToForCountXL(SearchSellFromToWithClientServiceModel searchSellFromToWithClientServiceModel);

    Long fromToForCountL(SearchSellFromToWithClientServiceModel searchSellFromToWithClientServiceModel);

    Long fromToForCountM(SearchSellFromToWithClientServiceModel searchSellFromToWithClientServiceModel);

    Long fromToForCountS(SearchSellFromToWithClientServiceModel searchSellFromToWithClientServiceModel);

    Long fromToForCountBroken(SearchSellFromToWithClientServiceModel searchSellFromToWithClientServiceModel);

    int getStatusNotOk();

    int getStatusNotOkCartons();

    int getTrueDivideCountOfEgg();

    List<Sells> getAllFromTo(SearchSellTotalPriceByClientServiceModel searchSellTotalPriceByClientServiceModel);

    Long getReturnedEUroByClient(ClientEnum client, PalletTypeEnum euro);

    Long getReturnedPallThermoByClient(ClientEnum client, PalletTypeEnum thermo);

    List<Sells> getAllSellsAboutToday();
}
