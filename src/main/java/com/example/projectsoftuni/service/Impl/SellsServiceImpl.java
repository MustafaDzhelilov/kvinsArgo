package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.*;
import com.example.projectsoftuni.model.entity.enums.*;
import com.example.projectsoftuni.model.service.*;
import com.example.projectsoftuni.model.view.SellsViewModel;
import com.example.projectsoftuni.repository.CartonAddRepository;
import com.example.projectsoftuni.repository.EggAddRepository;
import com.example.projectsoftuni.repository.PalletsRepository;
import com.example.projectsoftuni.repository.SellsRepository;
import com.example.projectsoftuni.service.CartonAddService;
import com.example.projectsoftuni.service.EggAddService;
import com.example.projectsoftuni.service.RequestsService;
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
    private final SearchSellFromToWithClientServiceModel searchSellFromToWithClientServiceModel;
    private final RequestsService requestsService;
    private final PalletsServiceModel palletsServiceModel;
    private final PalletsRepository palletsRepository;
    int countEgg;
    int countCarton;
    int countDivideEgg;
    int isZero = 1;
    int isZeroCartons = 1;
    int halfCartonsOrCorey = 1;

    public SellsServiceImpl(SellsRepository sellsRepository, ModelMapper modelMapper, SellsServiceModel sellsServiceModel, EggServiceModel eggServiceModel, EggAddService eggAddService, EggAddRepository eggAddRepository, CartonServiceModel cartonServiceModel, CartonAddService cartonAddService, CartonAddRepository cartonAddRepository, SearchSellFromToServiceModel searchSellFromToServiceModel, SearchSellFromToWithClientServiceModel searchSellFromToWithClientServiceModel, RequestsService requestsService, PalletsServiceModel palletsServiceModel, PalletsRepository palletsRepository) {
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
        this.searchSellFromToWithClientServiceModel = searchSellFromToWithClientServiceModel;
        this.requestsService = requestsService;
        this.palletsServiceModel = palletsServiceModel;
        this.palletsRepository = palletsRepository;
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

        Pallets pallets = modelMapper.map(palletsServiceModel, Pallets.class);
        pallets.setCategoryBaseEnum(sellsServiceModel.getBase());
        pallets.setPalletTypeEnum(sellsServiceModel.getPalletTypeEnum());
        pallets.setCount(-sellsServiceModel.getCountIssuedPallets());
        pallets.setLocalDate(LocalDate.now());

        if (sells.getBase().equals(CategoryBaseEnum.LOWER)
                && sells.getCartons().equals(CategoryCartonsEnum.CARTONS_120)) {

            Long divideCountOfEgg = (sellsServiceModel.getCountOfEgg()) / 120;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton120FromBaseLower();
            if (countOfCorey20FromLowerBase < divideCountOfEgg) {
                isZeroCartons = 0;
            }

        } else if (sells.getBase().equals(CategoryBaseEnum.LOWER)
                && sells.getCartons().equals(CategoryCartonsEnum.CARTONS_180_WHITE)) {

            Long divideCountOfEgg = (sellsServiceModel.getCountOfEgg()) / 180;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton180FromBaseLower();
            if (countOfCorey20FromLowerBase < divideCountOfEgg) {
                isZeroCartons = 0;
            }


        } else if(sells.getBase().equals(CategoryBaseEnum.LOWER)
                && sells.getCartons().equals(CategoryCartonsEnum.CARTONS_180_BROWN)) {
            Long divideCountOfEgg = (sellsServiceModel.getCountOfEgg()) / 180;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton180FromBaseLowerBrown();
            if (countOfCorey20FromLowerBase < divideCountOfEgg) {
                isZeroCartons = 0;
            }


        }else if(sells.getBase().equals(CategoryBaseEnum.LOWER)
                && sells.getCartons().equals(CategoryCartonsEnum.CARTONS_360_BROWN)) {
            Long divideCountOfEgg = (sellsServiceModel.getCountOfEgg()) / 360;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton360FromBaseLowerBrown(); // TODO
            if (countOfCorey20FromLowerBase < divideCountOfEgg) {
                isZeroCartons = 0;
            }


        }else if (sells.getBase().equals(CategoryBaseEnum.UPPER)
                && sells.getCartons().equals(CategoryCartonsEnum.CARTONS_120)) {

            Long divideCountOfEgg = (sellsServiceModel.getCountOfEgg()) / 120;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton120FromBaseUpper();
            if (countOfCorey20FromLowerBase < divideCountOfEgg) {
                isZeroCartons = 0;
            }


        } else if (sells.getBase().equals(CategoryBaseEnum.UPPER)
                && sells.getCartons().equals(CategoryCartonsEnum.CARTONS_180_WHITE)) {

            Long divideCountOfEgg = (sellsServiceModel.getCountOfEgg()) / 180;
            Long countOfCorey20FromLowerBaseC = cartonAddService.getCountOfCarton180FromBaseUpper();
            if (countOfCorey20FromLowerBaseC < divideCountOfEgg) {
                isZeroCartons = 0;
            }

        }else if(sells.getBase().equals(CategoryBaseEnum.UPPER)
                && sells.getCartons().equals(CategoryCartonsEnum.CARTONS_180_BROWN)){

            Long divideCountOfEgg = (sellsServiceModel.getCountOfEgg()) / 180;
            Long countOfCorey20FromLowerBaseC = cartonAddService.getCountOfCarton180FromBaseUpperBrown();
            if (countOfCorey20FromLowerBaseC < divideCountOfEgg) {
                isZeroCartons = 0;
            }

        }else if(sells.getBase().equals(CategoryBaseEnum.UPPER)
                && sells.getCartons().equals(CategoryCartonsEnum.CARTONS_360_BROWN)) {
            Long divideCountOfEgg = (sellsServiceModel.getCountOfEgg()) / 360;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton360FromBaseUpperBrown();
            if (countOfCorey20FromLowerBase < divideCountOfEgg) {
                isZeroCartons = 0;
            }


        }

            //Намаляне на бройката на яйцата след направена продажба
            Egg egg = modelMapper.map(eggServiceModel, Egg.class);
            egg.setEgg(sellsServiceModel.getEgg());
            egg.setCartons(sellsServiceModel.getCartons());
            egg.setBase(sellsServiceModel.getBase());
            LocalDate date = LocalDate.now();
            egg.setAddDate(date);

            Long sellCount = sellsServiceModel.getCountOfEgg();
            ;

            // Base LOWER
            if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_20)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategoryXLLower();

                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 20 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_120)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategoryXLCartonsLower();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 120 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(- sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_CHEZ)
                    && egg.getEgg().equals(CategoryEggEnum.L)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyChezBaseLowerL();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_FAMILY)
                    && egg.getEgg().equals(CategoryEggEnum.L)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyFamilyBaseLowerL();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_HARTMAN)
                    && egg.getEgg().equals(CategoryEggEnum.L)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyHartmanBaseLowerL();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_EURO)
                    && egg.getEgg().equals(CategoryEggEnum.L)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyEuroBaseLowerL();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }  else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180_WHITE)
                    && egg.getEgg().equals(CategoryEggEnum.L)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategoryLCartonLower();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 180 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180_BROWN)
                    && egg.getEgg().equals(CategoryEggEnum.L)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCartons180BaseLowerBrownL();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 180 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_360_BROWN)
                    && egg.getEgg().equals(CategoryEggEnum.L)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCartons360BaseLowerBrownL();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 360 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_CHEZ)
                    && egg.getEgg().equals(CategoryEggEnum.M)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyChezBaseLowerM();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_EURO)
                    && egg.getEgg().equals(CategoryEggEnum.M)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyEuroBaseLowerM();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_HARTMAN)
                    && egg.getEgg().equals(CategoryEggEnum.M)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyHartmanBaseLowerM();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_FAMILY)
                    && egg.getEgg().equals(CategoryEggEnum.M)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyFamilyBaseLowerM();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180_WHITE)
                    && egg.getEgg().equals(CategoryEggEnum.M)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategoryMCartonLower();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 180 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180_BROWN)
                    && egg.getEgg().equals(CategoryEggEnum.M)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCarton180BaseLowerBrownM();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 180 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_360_BROWN)
                    && egg.getEgg().equals(CategoryEggEnum.M)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCarton360BaseLowerBrownM();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 180 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_FAMILY)
                    && egg.getEgg().equals(CategoryEggEnum.S)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyFamilyBaseLowerS();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_CHEZ)
                    && egg.getEgg().equals(CategoryEggEnum.S)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyChezBaseLowerS();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_HARTMAN)
                    && egg.getEgg().equals(CategoryEggEnum.S)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyHartmanBaseLowerS();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_EURO)
                    && egg.getEgg().equals(CategoryEggEnum.S)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyEuroBaseLowerS();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180_WHITE)
                    && egg.getEgg().equals(CategoryEggEnum.S)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategorySCartonLower();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 180 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180_BROWN)
                    && egg.getEgg().equals(CategoryEggEnum.S)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCarton180BaseLowerBrownS();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 180 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_EURO)
                    && egg.getEgg().equals(CategoryEggEnum.BROKEN)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCarton360BaseLowerBrownS();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_FAMILY)
                    && egg.getEgg().equals(CategoryEggEnum.BROKEN)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyFamilyLowerBroken();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_EURO)
                    && egg.getEgg().equals(CategoryEggEnum.BROKEN)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyEuroLowerBroken();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_HARTMAN)
                    && egg.getEgg().equals(CategoryEggEnum.BROKEN)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyHartmanLowerBroken();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_CHEZ)
                    && egg.getEgg().equals(CategoryEggEnum.BROKEN)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyChezLowerBroken();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180_WHITE)
                    && egg.getEgg().equals(CategoryEggEnum.BROKEN)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCartonLowerBroken();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 180 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }


            // Base UPPER
            if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_20)) {

                Long countOfCorey20FromUpperBase = eggAddService.findByCategoryXLUpper();

                if (countOfCorey20FromUpperBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 20 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_120)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategoryXLCartonsUpper();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 120 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_CHEZ)
                    && egg.getEgg().equals(CategoryEggEnum.L)) {

                Long countOfCorey20FromUpperBase = eggAddService.findCoreyChezUpperL();
                if (countOfCorey20FromUpperBase < sellCount) {
                    isZero = 0;

                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_EURO)
                    && egg.getEgg().equals(CategoryEggEnum.L)) {

                Long countOfCorey20FromUpperBase = eggAddService.findCoreyEuroUpperL();
                if (countOfCorey20FromUpperBase < sellCount) {
                    isZero = 0;

                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_HARTMAN)
                    && egg.getEgg().equals(CategoryEggEnum.L)) {

                Long countOfCorey20FromUpperBase = eggAddService.findCoreyHartmanUpperL();
                if (countOfCorey20FromUpperBase < sellCount) {
                    isZero = 0;

                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_FAMILY)
                    && egg.getEgg().equals(CategoryEggEnum.L)) {

                Long countOfCorey20FromUpperBase = eggAddService.findCoreyFamilyUpperL();
                if (countOfCorey20FromUpperBase < sellCount) {
                    isZero = 0;

                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180_WHITE)
                    && egg.getEgg().equals(CategoryEggEnum.L)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategoryLCartonsUpper();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 180 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }  else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180_BROWN)
                    && egg.getEgg().equals(CategoryEggEnum.L)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCarton180UpperBrownL();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 180 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_360_BROWN)
                    && egg.getEgg().equals(CategoryEggEnum.L)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCarton360UpperBrownL();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 360 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_FAMILY)
                    && egg.getEgg().equals(CategoryEggEnum.M)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyFamilyUpperM();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_EURO)
                    && egg.getEgg().equals(CategoryEggEnum.M)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyEuroUpperM();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_HARTMAN)
                    && egg.getEgg().equals(CategoryEggEnum.M)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyHartmanUpperM();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_CHEZ)
                    && egg.getEgg().equals(CategoryEggEnum.M)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyChezUpperM();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180_WHITE)
                    && egg.getEgg().equals(CategoryEggEnum.M)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategoryMCartonsUpper();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 180 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180_BROWN)
                    && egg.getEgg().equals(CategoryEggEnum.M)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCarton180UpperBrownM();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 180 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_360_BROWN)
                    && egg.getEgg().equals(CategoryEggEnum.M)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCarton360UpperBrownM();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 360 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_CHEZ)
                    && egg.getEgg().equals(CategoryEggEnum.S)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyChezUpperS();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_FAMILY)
                    && egg.getEgg().equals(CategoryEggEnum.S)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyFamilyUpperS();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_HARTMAN)
                    && egg.getEgg().equals(CategoryEggEnum.S)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyHartmanUpperS();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_EURO)
                    && egg.getEgg().equals(CategoryEggEnum.S)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyEuroUpperS();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180_WHITE)
                    && egg.getEgg().equals(CategoryEggEnum.S)) {

                Long countOfCorey20FromLowerBase = eggAddService.findByCategorySCartonUpper();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 180 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            } else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180_BROWN)
                    && egg.getEgg().equals(CategoryEggEnum.S)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCarton180UpperBrownS();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 180 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_360_BROWN)
                    && egg.getEgg().equals(CategoryEggEnum.S)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCarton360UpperBrownS();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 360 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_EURO)
                    && egg.getEgg().equals(CategoryEggEnum.BROKEN)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyEuroUpperBroken();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_CHEZ)
                    && egg.getEgg().equals(CategoryEggEnum.BROKEN)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyChezUpperBroken();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_HARTMAN)
                    && egg.getEgg().equals(CategoryEggEnum.BROKEN)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyHartmanUpperBroken();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_FAMILY)
                    && egg.getEgg().equals(CategoryEggEnum.BROKEN)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCoreyFamilyUpperBroken();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 30 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                    && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180_WHITE)
                    && egg.getEgg().equals(CategoryEggEnum.BROKEN)) {

                Long countOfCorey20FromLowerBase = eggAddService.findCartonUpperBroken();
                if (countOfCorey20FromLowerBase < sellCount) {
                    isZero = 0;
                }
                if(sellCount % 180 != 0){
                    halfCartonsOrCorey = 0;
                }
                egg.setCountOfEgg(-sellCount);

            }

            if(halfCartonsOrCorey == 1) {
                if (isZero == 1 && isZeroCartons == 1) {
                    eggAddRepository.save(egg);
                    sellsRepository.save(sells);
                    palletsRepository.save(pallets);

                }
            }else if(halfCartonsOrCorey == 0){
                getTrueDivideCountOfEgg();
            }

        }

    @Override
    public int getStatusNotOk() {
        if(isZero == 0){
            countEgg = 1;
        }else{
            countEgg = 0;
        }
        return countEgg;
    }

    @Override
    public int getStatusNotOkCartons() {
        if(isZeroCartons == 0){
            countCarton = 1;
        }else{
            countCarton = 0;
        }
        return countCarton;
    }

    @Override
    public int getTrueDivideCountOfEgg() {
        if(halfCartonsOrCorey == 0){
            countDivideEgg = 1;
        }else{
            countDivideEgg = 0;
        }
        return countDivideEgg;
    }

    @Override
    public List<Sells> getAllFromTo(SearchSellTotalPriceByClientServiceModel searchSellTotalPriceByClientServiceModel) {
        return sellsRepository.getAllByAddDateBetween(searchSellTotalPriceByClientServiceModel.getStart().atStartOfDay(), searchSellTotalPriceByClientServiceModel.getEnd().atStartOfDay().plusHours(24));
    }

    @Override
    public Long getReturnedEUroByClient(ClientEnum client, PalletTypeEnum euro) {
        return sellsRepository.getAllByClientEnumAndPalletTypeEnum(client,euro).
                stream().map(Sells::getCountIssuedPallets).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getReturnedPallThermoByClient(ClientEnum client, PalletTypeEnum thermo) {
        return sellsRepository.getAllByClientEnumAndPalletTypeEnum(client, thermo).
                stream().map(Sells::getCountIssuedPallets).reduce(Long::sum).orElse(0L);
    }

    @Override
    public List<Sells> getAllSellsAboutToday() {
        return sellsRepository.getAllByAddDateBetween(LocalDateTime.now().minusMinutes(15), LocalDateTime.now());
    }


    @Override
    public List<SellsViewModel> getAllSells() {
        List<Sells> sells = sellsRepository.findAll();
        return sells.stream().map(sell -> modelMapper.map(sell, SellsViewModel.class)).collect(Collectors.toList());
    }


    @Override
    public Long fromTo(SearchSellFromToServiceModel searchSellFromToServiceModel) {
        return sellsRepository.findSellsByEggAndAddDateBetween(searchSellFromToServiceModel.getCategoryEggEnum(), searchSellFromToServiceModel.getStart().atStartOfDay(), searchSellFromToServiceModel.getEnd().atStartOfDay().plusHours(24)).
                stream().map(Sells::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public List<Sells> getSells() {
        return sellsRepository.getSellsByAddDateBetween(searchSellFromToServiceModel.getStart().atStartOfDay(), searchSellFromToServiceModel.getEnd().atStartOfDay().plusHours(24));
    }


    @Override
    public Long fromToForCountXL(SearchSellFromToWithClientServiceModel searchSellFromToWithClientServiceModel) {
        return sellsRepository.findSellsByEggAndClientEnumAndAddDateBetween(CategoryEggEnum.XL, searchSellFromToWithClientServiceModel.getClientEnum(), searchSellFromToWithClientServiceModel.getStart().atStartOfDay(), searchSellFromToWithClientServiceModel.getEnd().atStartOfDay().plusHours(24)).
                stream().map(Sells::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long fromToForCountL(SearchSellFromToWithClientServiceModel searchSellFromToWithClientServiceModel) {
        return sellsRepository.findSellsByEggAndClientEnumAndAddDateBetween(CategoryEggEnum.L, searchSellFromToWithClientServiceModel.getClientEnum(), searchSellFromToWithClientServiceModel.getStart().atStartOfDay(), searchSellFromToWithClientServiceModel.getEnd().atStartOfDay().plusHours(24)).
                stream().map(Sells::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long fromToForCountM(SearchSellFromToWithClientServiceModel searchSellFromToWithClientServiceModel) {
        return sellsRepository.findSellsByEggAndClientEnumAndAddDateBetween(CategoryEggEnum.M, searchSellFromToWithClientServiceModel.getClientEnum(), searchSellFromToWithClientServiceModel.getStart().atStartOfDay(), searchSellFromToWithClientServiceModel.getEnd().atStartOfDay().plusHours(24)).
                stream().map(Sells::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long fromToForCountS(SearchSellFromToWithClientServiceModel searchSellFromToWithClientServiceModel) {
        return sellsRepository.findSellsByEggAndClientEnumAndAddDateBetween(CategoryEggEnum.S, searchSellFromToWithClientServiceModel.getClientEnum(), searchSellFromToWithClientServiceModel.getStart().atStartOfDay(), searchSellFromToWithClientServiceModel.getEnd().atStartOfDay().plusHours(24)).
                stream().map(Sells::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long fromToForCountBroken(SearchSellFromToWithClientServiceModel searchSellFromToWithClientServiceModel) {
        return sellsRepository.findSellsByEggAndClientEnumAndAddDateBetween(CategoryEggEnum.BROKEN, searchSellFromToWithClientServiceModel.getClientEnum(), searchSellFromToWithClientServiceModel.getStart().atStartOfDay(), searchSellFromToWithClientServiceModel.getEnd().atStartOfDay().plusHours(24)).
                stream().map(Sells::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }
    




}
