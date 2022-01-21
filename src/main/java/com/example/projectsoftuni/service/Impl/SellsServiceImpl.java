package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.Cartons;
import com.example.projectsoftuni.model.entity.Egg;
import com.example.projectsoftuni.model.entity.Sells;
import com.example.projectsoftuni.model.entity.enums.*;
import com.example.projectsoftuni.model.service.CartonServiceModel;
import com.example.projectsoftuni.model.service.EggServiceModel;
import com.example.projectsoftuni.model.service.SearchSellFromToServiceModel;
import com.example.projectsoftuni.model.service.SellsServiceModel;
import com.example.projectsoftuni.model.view.SellsViewModel;
import com.example.projectsoftuni.repository.CartonAddRepository;
import com.example.projectsoftuni.repository.EggAddRepository;
import com.example.projectsoftuni.repository.SellsRepository;
import com.example.projectsoftuni.service.CartonAddService;
import com.example.projectsoftuni.service.EggAddService;
import com.example.projectsoftuni.service.SellsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellsServiceImpl implements SellsService {

    private final SellsRepository sellsRepository;
    private final ModelMapper modelMapper;
    private final SellsServiceModel sellsServiceModel;
    private final EggServiceModel eggServiceModel;
    private final EggAddService eggAddService;
    private final EggAddRepository eggAddRepository;
    private final CartonServiceModel cartonServiceModel;
    private final CartonAddService cartonAddService;
    private final CartonAddRepository cartonAddRepository;
    private final SearchSellFromToServiceModel searchSellFromToServiceModel;

    public SellsServiceImpl(SellsRepository sellsRepository, ModelMapper modelMapper, SellsServiceModel sellsServiceModel, EggServiceModel eggServiceModel, EggAddService eggAddService, EggAddRepository eggAddRepository, CartonServiceModel cartonServiceModel, CartonAddService cartonAddService, CartonAddRepository cartonAddRepository, SearchSellFromToServiceModel searchSellFromToServiceModel) {
        this.sellsRepository = sellsRepository;
        this.modelMapper = modelMapper;
        this.sellsServiceModel = sellsServiceModel;
        this.eggServiceModel = eggServiceModel;
        this.eggAddService = eggAddService;
        this.eggAddRepository = eggAddRepository;
        this.cartonServiceModel = cartonServiceModel;
        this.cartonAddService = cartonAddService;
        this.cartonAddRepository = cartonAddRepository;
        this.searchSellFromToServiceModel = searchSellFromToServiceModel;
    }

    @Override
    public void addSell(SellsServiceModel sellsServiceModel) {
        Sells sells = modelMapper.map(sellsServiceModel, Sells.class);
        sells.setBase(sellsServiceModel.getBase());
        sells.setCartons(sellsServiceModel.getCartons());
        sells.setEgg(sellsServiceModel.getEgg());
        sells.setCountOfEgg(sellsServiceModel.getCountOfEgg());
        sells.setAddDate(sellsServiceModel.getAddDate());
        sells.setClientEnum(sellsServiceModel.getClientEnum());
        sells.setPrice(sellsServiceModel.getPrice());
        sells.setPalletTypeEnum(sellsServiceModel.getPalletTypeEnum());
        sells.setCountIssuedPallets(sellsServiceModel.getCountIssuedPallets());
        double currentPrice = sellsServiceModel.getPrice();
        sells.setTotalPrice(sellsServiceModel.getCountOfEgg() * currentPrice);

        //За намаляне на бройката на кашони
        Cartons cartons = modelMapper.map(cartonServiceModel, Cartons.class);
        cartons.setCartons(sellsServiceModel.getCartons());
        cartons.setBase(sellsServiceModel.getBase());
        cartons.setDate(LocalDateTime.now());
        int isZeroCartons = 1;

        if (sells.getBase().equals(CategoryBaseEnum.LOWER)
                && sells.getCartons().equals(CategoryCartonsEnum.CARTONS_120)) {

            Long divideCountOfEgg = (sellsServiceModel.getCountOfEgg()) / 120;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton120FromBaseLower();
            if (countOfCorey20FromLowerBase == 0) {
                isZeroCartons = 0;
            }
            cartons.setCount(countOfCorey20FromLowerBase - divideCountOfEgg);

        } else if (sells.getBase().equals(CategoryBaseEnum.LOWER)
                && sells.getCartons().equals(CategoryCartonsEnum.CARTONS_180)) {

            Long divideCountOfEgg = (sellsServiceModel.getCountOfEgg()) / 180;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton180FromBaseLower();
            if (countOfCorey20FromLowerBase == 0) {
                isZeroCartons = 0;
            }
            cartons.setCount(countOfCorey20FromLowerBase - divideCountOfEgg);

        } else if (sells.getBase().equals(CategoryBaseEnum.UPPER)
                && sells.getCartons().equals(CategoryCartonsEnum.CARTONS_120)) {

            Long divideCountOfEgg = (sellsServiceModel.getCountOfEgg()) / 120;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton120FromBaseUpper();
            if (countOfCorey20FromLowerBase == 0) {
                isZeroCartons = 0;
            }
            cartons.setCount(countOfCorey20FromLowerBase - divideCountOfEgg);

        } else if (sells.getBase().equals(CategoryBaseEnum.UPPER)
                && sells.getCartons().equals(CategoryCartonsEnum.CARTONS_180)) {

            Long divideCountOfEgg = (sellsServiceModel.getCountOfEgg()) / 180;
            Long countOfCorey20FromLowerBaseC = cartonAddService.getCountOfCarton180FromBaseUpper();
            if (countOfCorey20FromLowerBaseC == 0) {
                isZeroCartons = 0;
            }
            cartons.setCount(countOfCorey20FromLowerBaseC - divideCountOfEgg);
        }

            //Намаляне на бройката на яйцата след направена продажба
            Egg egg = modelMapper.map(eggServiceModel, Egg.class);
            egg.setEgg(sellsServiceModel.getEgg());
            egg.setCartons(sellsServiceModel.getCartons());
            egg.setBase(sellsServiceModel.getBase());
            LocalDate date = LocalDate.now();
            egg.setAddDate(date);

            Long sellCount = sellsServiceModel.getCountOfEgg();

            int isZero = 1;

            // Base LOWER
            if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_20)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategoryXLLower();

                if (countOfCorey20FromLowerBase == 0) {
                    isZero = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_120)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategoryXLCartonsLower();
                if (countOfCorey20FromLowerBase == 0) {
                    isZero = 0;
                }
                egg.setCountOfEgg(countOfCorey20FromLowerBase - sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30)
                    && egg.getEgg().equals(CategoryEggEnum.L)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategoryLCoreyLower();
                if (countOfCorey20FromLowerBase == 0) {
                    isZero = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180)
                    && egg.getEgg().equals(CategoryEggEnum.L)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategoryLCartonLower();
                if (countOfCorey20FromLowerBase == 0) {
                    isZero = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30)
                    && egg.getEgg().equals(CategoryEggEnum.M)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategoryMCoreyLower();
                if (countOfCorey20FromLowerBase == 0) {
                    isZero = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180)
                    && egg.getEgg().equals(CategoryEggEnum.M)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategoryMCartonLower();
                if (countOfCorey20FromLowerBase == 0) {
                    isZero = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30)
                    && egg.getEgg().equals(CategoryEggEnum.S)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategorySCoreyLower();
                if (countOfCorey20FromLowerBase == 0) {
                    isZero = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180)
                    && egg.getEgg().equals(CategoryEggEnum.S)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategorySCartonLower();
                if (countOfCorey20FromLowerBase == 0) {
                    isZero = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30)
                    && egg.getEgg().equals(CategoryEggEnum.BROKEN)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategoryBrokenLower();
                if (countOfCorey20FromLowerBase == 0) {
                    isZero = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }


            // Base UPPER
            if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_20)) {

                Long countOfCorey20FromUpperBase = eggAddService.findByCategoryXLUpper();

                if (countOfCorey20FromUpperBase == 0) {
                    isZero = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_120)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategoryXLCartonsLower();
                if (countOfCorey20FromLowerBase == 0) {
                    isZero = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30)
                    && egg.getEgg().equals(CategoryEggEnum.L)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategoryLCoreyLower();
                if (countOfCorey20FromLowerBase == 0) {
                    isZero = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180)
                    && egg.getEgg().equals(CategoryEggEnum.L)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategoryLCartonLower();
                if (countOfCorey20FromLowerBase == 0) {
                    isZero = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30)
                    && egg.getEgg().equals(CategoryEggEnum.M)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategoryMCoreyLower();
                if (countOfCorey20FromLowerBase == 0) {
                    isZero = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180)
                    && egg.getEgg().equals(CategoryEggEnum.M)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategoryMCartonLower();
                if (countOfCorey20FromLowerBase == 0) {
                    isZero = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30)
                    && egg.getEgg().equals(CategoryEggEnum.S)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategorySCoreyLower();
                if (countOfCorey20FromLowerBase == 0) {
                    isZero = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180)
                    && egg.getEgg().equals(CategoryEggEnum.S)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategorySCartonLower();
                if (countOfCorey20FromLowerBase == 0) {
                    isZero = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30)
                    && egg.getEgg().equals(CategoryEggEnum.BROKEN)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategoryBrokenLower();
                if (countOfCorey20FromLowerBase == 0) {
                    isZero = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }


            if (isZero == 1) {
                eggAddRepository.save(egg);
                sellsRepository.save(sells);

                if (isZeroCartons == 1) {
                    cartonAddRepository.save(cartons);
                }
            }

        }


    @Override
    public List<Sells> findLastSellsByDate(LocalDate now) {
        return sellsRepository.findByAddDateOrderByAddDateDesc(LocalDate.now());
    }

    @Override
    public List<SellsViewModel> getAllSells() {
        List<Sells> sells = sellsRepository.findAll();
        return sells.stream().map(sell -> modelMapper.map(sell, SellsViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public Long getIssuedPallCount() {
        return sellsRepository.getAllByClientEnumAndPalletTypeEnum(ClientEnum.AKVILOD_OOD, PalletTypeEnum.EURO).
                stream().map(Sells::getCountIssuedPallets).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getIssuedPallCountT() {
        return sellsRepository.getAllByClientEnumAndPalletTypeEnum(ClientEnum.ET_ZORNICA_TEODOR_BONCHEV, PalletTypeEnum.EURO).
                stream().map(Sells::getCountIssuedPallets).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getIssuedPallCountAkvTermo() {
        return sellsRepository.getAllByClientEnumAndPalletTypeEnum(ClientEnum.AKVILOD_OOD, PalletTypeEnum.THERMO).
                stream().map(Sells::getCountIssuedPallets).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getIssuedPallCountTTermo() {
        return sellsRepository.getAllByClientEnumAndPalletTypeEnum(ClientEnum.ET_ZORNICA_TEODOR_BONCHEV, PalletTypeEnum.THERMO).
                stream().map(Sells::getCountIssuedPallets).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long fromTo(SearchSellFromToServiceModel searchSellFromToServiceModel) {
        return sellsRepository.findSellsByEggAndAddDateBetween(searchSellFromToServiceModel.getCategoryEggEnum(), searchSellFromToServiceModel.getStart(), searchSellFromToServiceModel.getEnd()).
                stream().map(Sells::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }



}
