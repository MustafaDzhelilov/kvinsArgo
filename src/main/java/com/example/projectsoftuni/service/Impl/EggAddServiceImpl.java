package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.Cartons;
import com.example.projectsoftuni.model.entity.Egg;
import com.example.projectsoftuni.model.entity.ResidueOfExtraction;
import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;
import com.example.projectsoftuni.model.service.CartonServiceModel;
import com.example.projectsoftuni.model.service.EggServiceModel;
import com.example.projectsoftuni.model.service.ResidueOfExtractionServiceModel;
import com.example.projectsoftuni.repository.CartonAddRepository;
import com.example.projectsoftuni.repository.EggAddRepository;
import com.example.projectsoftuni.repository.ResidueOfExtractionRepository;
import com.example.projectsoftuni.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EggAddServiceImpl implements EggAddService {

    private final EggAddRepository eggAddRepository;
    private final ModelMapper modelMapper;
    private final EggCategoryService eggCategoryService;
    private final BaseCategoryService baseCategoryService;
    private final CartonCategoryService cartonCategoryService;
    private final HaleCategoryService haleCategoryService;
    private final CartonAddService cartonAddService;
    private final CartonServiceModel cartonServiceModel;
    private final CartonAddRepository cartonAddRepository;
    private final ResidueOfExtractionServiceModel residueOfExtractionServiceModel;
    private final ResidueOfExtractionRepository residueOfExtractionRepository;
    int equalTypeCarton = 0;
    int wrongCoreyInXL = 0;
    int wrongCoreyLMS = 0;


    public EggAddServiceImpl(EggAddRepository eggAddRepository, ModelMapper modelMapper, EggCategoryService eggCategoryService
            , BaseCategoryService baseCategoryService, CartonCategoryService cartonCategoryService, HaleCategoryService haleCategoryService, CartonAddService cartonAddService, CartonServiceModel cartonServiceModel, CartonAddRepository cartonAddRepository, ResidueOfExtractionServiceModel residueOfExtractionServiceModel, ResidueOfExtractionRepository residueOfExtractionRepository) {
        this.eggAddRepository = eggAddRepository;
        this.modelMapper = modelMapper;
        this.eggCategoryService = eggCategoryService;
        this.baseCategoryService = baseCategoryService;
        this.cartonCategoryService = cartonCategoryService;

        this.haleCategoryService = haleCategoryService;
        this.cartonAddService = cartonAddService;
        this.cartonServiceModel = cartonServiceModel;
        this.cartonAddRepository = cartonAddRepository;
        this.residueOfExtractionServiceModel = residueOfExtractionServiceModel;
        this.residueOfExtractionRepository = residueOfExtractionRepository;
    }

    @Override
    public void add(EggServiceModel eggServiceModel) {
        Egg egg = modelMapper.map(eggServiceModel, Egg.class);
        egg.setEgg(eggServiceModel.getEgg());
        egg.setBase(eggServiceModel.getBase());
        egg.setCoreyInCartons(eggServiceModel.getCoreyInCartons());
        egg.setCartons(eggServiceModel.getCartons());
        egg.setHale(eggServiceModel.getHale());


        //  За намаляне на бройката от картони/кори след като се направи добавяне на яйца
        Cartons cartons =  modelMapper.map(cartonServiceModel, Cartons.class);
        cartons.setCartons(eggServiceModel.getCartons());
        cartons.setBase(eggServiceModel.getBase());
        LocalDateTime date = LocalDateTime.now();
        cartons.setDate(date);

        Cartons coreyInCartons = modelMapper.map(cartonServiceModel, Cartons.class);
        coreyInCartons.setCartons(eggServiceModel.getCoreyInCartons());
        coreyInCartons.setBase(eggServiceModel.getBase());
        coreyInCartons.setDate(LocalDateTime.now());

        ResidueOfExtraction residueOfExtraction = modelMapper.map(residueOfExtractionServiceModel, ResidueOfExtraction.class);
        residueOfExtraction.setBase(eggServiceModel.getBase());
        residueOfExtraction.setEgg(eggServiceModel.getEgg());
        residueOfExtraction.setHale(eggServiceModel.getHale());
        residueOfExtraction.setAddDate(eggServiceModel.getAddDate());

        int  isZero = 1;

        if(egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_20)){


               Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 20;
                Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCore120FromBaseLower();
                if(countOfCorey20FromLowerBase < divideCountOfEgg){
                    isZero = 0;
                }
                residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 20)); // Остатъка, която не се дели точно на избрания амбалаж се запаметява в таблица остатък
                cartons.setCount(-divideCountOfEgg);

        }else if(egg.getBase().equals(CategoryBaseEnum.LOWER) &&
                egg.getCartons().equals(CategoryCartonsEnum.CARTONS_120)) {
            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 120;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton120FromBaseLower();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }
            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg *120));
            cartons.setCount(-divideCountOfEgg);
            coreyInCartons.setCount(-divideCountOfEgg * 8);

        }else if(egg.getBase().equals(CategoryBaseEnum.LOWER) &&
                egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180_WHITE)) {
            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 180;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton180FromBaseLower();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 180));
            cartons.setCount(-divideCountOfEgg);
            coreyInCartons.setCount(-divideCountOfEgg * 8);

        }else if(egg.getBase().equals(CategoryBaseEnum.LOWER) &&
                egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180_BROWN)) {
            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 180;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton180FromBaseLowerBrown();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 180));
            cartons.setCount(-divideCountOfEgg);
            coreyInCartons.setCount(-divideCountOfEgg * 8);

        }else if(egg.getBase().equals(CategoryBaseEnum.LOWER) &&
                egg.getCartons().equals(CategoryCartonsEnum.CARTONS_360_BROWN)) {
            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 360;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton360FromBaseLowerBrown();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 360));
            cartons.setCount(-divideCountOfEgg);
            coreyInCartons.setCount(-divideCountOfEgg * 8);

        } else if(egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_FAMILY)){

           Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyFamilyLower();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 30));
            cartons.setCount(-divideCountOfEgg);

        }else if(egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_CHEZ)){

            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyChezLower();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 30));
            cartons.setCount(-divideCountOfEgg);

        }  else if(egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_EURO)){

            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyEuroLower();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 30));
            cartons.setCount(-divideCountOfEgg);

        } else if(egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_HARTMAN)){

            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyHartmanLower();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 30));
            cartons.setCount(-divideCountOfEgg);

        } else if(egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_UKRAYNA)){

            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyUkraynaLower();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 30));
            cartons.setCount(-divideCountOfEgg);

        }else if(egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_ELPA)){

            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyElpaLower();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 30));
            cartons.setCount(-divideCountOfEgg);

        }else if(egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_EKO_FARM)){

            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyEkoFarmLower();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 30));
            cartons.setCount(-divideCountOfEgg);

        }else if(egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_NEW1)){

            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyNew1Lower();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 30));
            cartons.setCount(-divideCountOfEgg);

        }else if(egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_NEW2)){

            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyNew2Lower();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 30));
            cartons.setCount(-divideCountOfEgg);

        }else if(egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_20)){

           Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 20;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCore120FromBaseUpper();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 20));
            cartons.setCount(-divideCountOfEgg);


        }else if(egg.getBase().equals(CategoryBaseEnum.UPPER) &&
                egg.getCartons().equals(CategoryCartonsEnum.CARTONS_120)) {
            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 120;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton120FromBaseUpper();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 120));
            cartons.setCount(-divideCountOfEgg);
            coreyInCartons.setCount(-divideCountOfEgg * 8);

        }else if(egg.getBase().equals(CategoryBaseEnum.UPPER) &&
                egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180_WHITE)) {
            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 180;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton180FromBaseUpper();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 180));
            cartons.setCount(-divideCountOfEgg);
            coreyInCartons.setCount(-divideCountOfEgg * 8);

        }else if(egg.getBase().equals(CategoryBaseEnum.UPPER) &&
                egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180_BROWN)) {
            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 180;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton180FromBaseUpperBrown();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 180));
            cartons.setCount(-divideCountOfEgg);
            coreyInCartons.setCount(-divideCountOfEgg * 8);

        }else if(egg.getBase().equals(CategoryBaseEnum.UPPER) &&
                egg.getCartons().equals(CategoryCartonsEnum.CARTONS_360_BROWN)) {
            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 360;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton360FromBaseUpperBrown();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 360));
            cartons.setCount(-divideCountOfEgg);
            coreyInCartons.setCount(-divideCountOfEgg * 8);

        }else if(egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_UKRAYNA)) {

            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyUkraynaUpper();
            if (countOfCorey20FromLowerBase < divideCountOfEgg) {
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 30));
            cartons.setCount(-divideCountOfEgg);


        }else if(egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_ELPA)) {

            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyElpaUpper();
            if (countOfCorey20FromLowerBase < divideCountOfEgg) {
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 30));
            cartons.setCount(-divideCountOfEgg);


        }else if(egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_EKO_FARM)) {

            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyEkoFarmUpper();
            if (countOfCorey20FromLowerBase < divideCountOfEgg) {
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 30));
            cartons.setCount(-divideCountOfEgg);


        }else if(egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_NEW1)) {

            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyNew1Upper();
            if (countOfCorey20FromLowerBase < divideCountOfEgg) {
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 30));
            cartons.setCount(-divideCountOfEgg);


        }else if(egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_NEW2)) {

            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyNew2Upper();
            if (countOfCorey20FromLowerBase < divideCountOfEgg) {
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 30));
            cartons.setCount(-divideCountOfEgg);


        }else if(egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_HARTMAN)){

           Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyHartmanUpper();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 30));
            cartons.setCount(-divideCountOfEgg);

        } else if(egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_EURO)){

            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyEuroUpper();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 30));
            cartons.setCount(-divideCountOfEgg);

        } else if(egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_FAMILY)){

            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyFamilyUpper();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 30));
            cartons.setCount(-divideCountOfEgg);

        } else if(egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_CHEZ)){

            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyChezUpper();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            residueOfExtraction.setCountOfEgg(eggServiceModel.getCountOfEgg() - (divideCountOfEgg * 30));
            cartons.setCount(-divideCountOfEgg);

        }

        if(eggServiceModel.getCartons() == CategoryCartonsEnum.COREY_30_HARTMAN ||
                eggServiceModel.getCartons() == CategoryCartonsEnum.COREY_30_CHEZ ||
            eggServiceModel.getCartons() == CategoryCartonsEnum.COREY_30_FAMILY ||
                eggServiceModel.getCartons() == CategoryCartonsEnum.COREY_30_EURO ||
                eggServiceModel.getCartons() == CategoryCartonsEnum.COREY_UKRAYNA ||
                eggServiceModel.getCartons() == CategoryCartonsEnum.COREY_ELPA ||
                eggServiceModel.getCartons() == CategoryCartonsEnum.COREY_EKO_FARM ||
                eggServiceModel.getCartons() == CategoryCartonsEnum.COREY_NEW1 ||
                eggServiceModel.getCartons() == CategoryCartonsEnum.COREY_NEW2 &&
                        eggServiceModel.getCoreyInCartons() != null){
            equalTypeCarton = 1;
        }

        if(eggServiceModel.getCartons() == CategoryCartonsEnum.CARTONS_120 &&
        eggServiceModel.getCoreyInCartons() != CategoryCartonsEnum.COREY_20){
            wrongCoreyInXL = 1;
        }

        if(eggServiceModel.getEgg() == CategoryEggEnum.XL &&
                eggServiceModel.getCartons() != CategoryCartonsEnum.CARTONS_120 &&
                eggServiceModel.getCoreyInCartons() != CategoryCartonsEnum.COREY_20){
            wrongCoreyInXL = 1;
        }
        if(eggServiceModel.getEgg() == CategoryEggEnum.XL &&
                eggServiceModel.getCartons() == CategoryCartonsEnum.CARTONS_120 &&
                eggServiceModel.getCoreyInCartons() != CategoryCartonsEnum.COREY_20){
            wrongCoreyInXL = 1;
        }
        if(eggServiceModel.getEgg() == CategoryEggEnum.XL &&
                eggServiceModel.getCartons() != CategoryCartonsEnum.CARTONS_120){
            wrongCoreyInXL = 1;
        }

        if(eggServiceModel.getEgg() == CategoryEggEnum.L
                && eggServiceModel.getCartons() ==  CategoryCartonsEnum.CARTONS_120){
            wrongCoreyLMS = 1;
        }

        if(eggServiceModel.getEgg() == CategoryEggEnum.M
                && eggServiceModel.getCartons() == CategoryCartonsEnum.CARTONS_120){
            wrongCoreyLMS = 1;
        }

        if(eggServiceModel.getEgg() == CategoryEggEnum.S
                && eggServiceModel.getCartons() == CategoryCartonsEnum.CARTONS_120){
            wrongCoreyLMS = 1;
        }

        if(isZero == 1 && equalTypeCarton == 0 && wrongCoreyInXL == 0 && wrongCoreyLMS == 0) {
            eggAddRepository.save(egg);
            cartonAddRepository.save(cartons);
            residueOfExtractionRepository.save(residueOfExtraction);
            if(eggServiceModel.getCoreyInCartons() != null){
                cartonAddRepository.save(coreyInCartons);
            }

        }

    }

    @Override
    public int equalsTypeCartons() {
        int result;
        if(equalTypeCarton == 1){
            result = 1;
        }else{
            result = 0;
        }
        return result;
    }

    @Override
    public int wrongCoreyInXL() {
        int result;
        if(wrongCoreyInXL == 1){
            result = 1;
        }else{
            result = 0;
        }
        return result;
    }

    @Override
    public int wrongCoreyLMS() {
        int result;
        if(wrongCoreyLMS ==1){
            result = 1;
        }else{
            result = 0;
        }
        return result;
    }

    @Override
    public Long findCoreyUkraynaLowerL() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_UKRAYNA)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyElpaLowerL() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_ELPA)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyEkoFarmLowerL() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_EKO_FARM)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyNew1LowerL() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_NEW1)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyNew2LowerL() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_NEW2)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyUkraynaLowerM() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_UKRAYNA)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyElpaLowerM() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_ELPA)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyEkoFarmLowerM() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_EKO_FARM)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyNew1LowerM() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_NEW1)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyNew2LowerM() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_NEW2)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyUkraynaLowerS() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_UKRAYNA)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyElpaLowerS() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_ELPA)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyEkoFarmLowerS() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_EKO_FARM)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyNew1LowerS() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_NEW1)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyNew2LowerS() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_NEW2)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyUkraynaLowerBROKEN() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_UKRAYNA)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyElpaLowerBROKEN() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_ELPA)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyEkoFarmLowerBROKEN() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_EKO_FARM)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyNew1LowerBROKEN() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_NEW1)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyNew2LowerBROKEN() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_NEW2)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyUkraynaUpperL() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_UKRAYNA)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyElpaUpperL() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_ELPA)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyEkoFarmUpperL() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_EKO_FARM)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyNew1UpperL() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_NEW1)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyNew2UpperL() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_NEW2)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyUkraynaUpperM() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_UKRAYNA)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyElpaUpperM() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_ELPA)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyEkoFarmUpperM() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_EKO_FARM)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyNew1UpperM() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_NEW1)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyNew2UpperM() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_NEW2)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyUkraynaUpperS() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_UKRAYNA)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyElpaUpperS() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_ELPA)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyEkoFarmUpperS() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_EKO_FARM)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyNew1UpperS() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_NEW1)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyNew2UpperS() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_NEW2)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyUkraynaUpperBROKEN() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_UKRAYNA)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyElpaUpperBROKEN() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_ELPA)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyEkoFarmUpperBROKEN() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_EKO_FARM)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyNew1UpperBROKEN() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_NEW1)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyNew2UpperBROKEN() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_NEW2)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public List<Egg> checkCountOfImport(LocalDate now) {
        return eggAddRepository.findByAddDate(LocalDate.now());
    }

    @Override
    public List<Egg> findAll() {
        return eggAddRepository.findAll();
    }

    @Override
    public void deleteLocation(Long id) {
        eggAddRepository.deleteById(id);
    }


    @Override
    public Long findByCategoryXL() {
        return eggAddRepository.findAllByEgg(CategoryEggEnum.XL)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findByCategoryL() {
        return eggAddRepository.findAllByEgg(CategoryEggEnum.L)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findByCategoryM() {
        return eggAddRepository.findAllByEgg(CategoryEggEnum.M)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findByCategoryS() {
        return eggAddRepository.findAllByEgg(CategoryEggEnum.S)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findByCategoryBROKEN() {
        return eggAddRepository.findAllByEgg(CategoryEggEnum.BROKEN)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findByCategoryXLLower() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.XL, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_20)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findByCategoryXLCartonsLower() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.XL, CategoryBaseEnum.LOWER, CategoryCartonsEnum.CARTONS_120)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }


    @Override
    public Long findByCategoryLCartonLower() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.LOWER, CategoryCartonsEnum.CARTONS_180_WHITE)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }


    @Override
    public Long findByCategoryMCartonLower() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.LOWER, CategoryCartonsEnum.CARTONS_180_WHITE)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }


    @Override
    public Long findByCategorySCartonLower() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.LOWER, CategoryCartonsEnum.CARTONS_180_WHITE)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }


    @Override
    public Long findByCategoryXLUpper() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.XL, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_20)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findByCategoryXLCartonsUpper() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.XL, CategoryBaseEnum.UPPER, CategoryCartonsEnum.CARTONS_120)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }


    @Override
    public Long findByCategoryLCartonsUpper() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.UPPER, CategoryCartonsEnum.CARTONS_180_WHITE)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }


    @Override
    public Long findByCategoryMCartonsUpper() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.UPPER, CategoryCartonsEnum.CARTONS_180_WHITE)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }


    @Override
    public Long findByCategorySCartonUpper() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.UPPER, CategoryCartonsEnum.CARTONS_180_WHITE)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }


    // За броя на яйцата от Първо хале за  текущия ден
    @Override
    public Long findByHaleFirstAndDateDescCurrentDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.FIRST, LocalDate.now())
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }


    //За текущия ден - 1 ден
    @Override
    public Long findFirstAndDateDescMinusOneDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.FIRST, LocalDate.now().minusDays(1))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    //За текущия ден - 2 дни
    @Override
    public Long findFirstAndDateDescMinusTwoDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.FIRST, LocalDate.now().minusDays(2))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    //За текущия ден - 3 дни
    @Override
    public Long findFirstAndDateDescMinusThreeDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.FIRST, LocalDate.now().minusDays(3))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    //За текущия ден - 4 дни
    @Override
    public Long findFirstAndDateDescMinusFourthDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.FIRST, LocalDate.now().minusDays(4))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    //За текущия ден - 5 дни
    @Override
    public Long findFirstAndDateDescMinusFiveDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.FIRST, LocalDate.now().minusDays(5))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    //За текущия ден - 6 дни
    @Override
    public Long findFirstAndDateDescMinusSixDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.FIRST, LocalDate.now().minusDays(6))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    //За текущия ден - 7 дни
    @Override
    public Long findFirstAndDateDescMinusSevenDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.FIRST, LocalDate.now().minusDays(7))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    // За броя на яйцата от Второ хале за  текущия ден
    @Override
    public Long findByHaleSecondAndDateDescCurrentDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.SECOND, LocalDate.now())
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    //За текущия ден - 1 дни
    @Override
    public Long findSecondAndDateDescMinusOneDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.SECOND, LocalDate.now().minusDays(1))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }
    //За текущия ден - 2 дни
    @Override
    public Long findSecondAndDateDescMinusTwoDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.SECOND, LocalDate.now().minusDays(2))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }
    //За текущия ден - 3 дни
    @Override
    public Long findSecondAndDateDescMinusThreeDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.SECOND, LocalDate.now().minusDays(3))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }
    //За текущия ден - 4 дни
    @Override
    public Long findSecondAndDateDescMinusFourthDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.SECOND, LocalDate.now().minusDays(4))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }
    //За текущия ден - 5 дни
    @Override
    public Long findSecondAndDateDescMinusFiveDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.SECOND, LocalDate.now().minusDays(5))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }
    //За текущия ден - 6 дни
    @Override
    public Long findSecondAndDateDescMinusSixDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.SECOND, LocalDate.now().minusDays(6))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }
    //За текущия ден - 7 дни
    @Override
    public Long findSecondAndDateDescMinusSevenDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.SECOND, LocalDate.now().minusDays(7))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    // За броя на яйцата от Трето хале за  текущия ден
    @Override
    public Long findByHaleThirdAndDateDescCurrentDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.THIRD, LocalDate.now())
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findThirdAndDateDescMinusOneDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.THIRD, LocalDate.now().minusDays(1))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findThirdAndDateDescMinusTwoDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.THIRD, LocalDate.now().minusDays(2))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findThirdAndDateDescMinusThreeDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.THIRD, LocalDate.now().minusDays(3))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findThirdAndDateDescMinusFourthDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.THIRD, LocalDate.now().minusDays(4))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findThirdAndDateDescMinusFiveDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.THIRD, LocalDate.now().minusDays(5))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findThirdAndDateDescMinusSixDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.THIRD, LocalDate.now().minusDays(6))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findThirdAndDateDescMinusSevenDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.THIRD, LocalDate.now().minusDays(7))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    // За броя на яйцата от Четвърто хале за  текущия ден
    @Override
    public Long findByHaleFourthAndDateDescCurrentDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.FOURTH, LocalDate.now())
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findFourthAndDateDescMinusOneDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.FOURTH, LocalDate.now().minusDays(1))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findFourthAndDateDescMinusTwoDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.FOURTH, LocalDate.now().minusDays(2))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findFourthAndDateDescMinusThreeDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.FOURTH, LocalDate.now().minusDays(3))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findFourthAndDateDescMinusFourthDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.FOURTH, LocalDate.now().minusDays(4))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findFourthAndDateDescMinusFiveDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.FOURTH, LocalDate.now().minusDays(5))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findFourthAndDateDescMinusSixDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.FOURTH, LocalDate.now().minusDays(6))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findFourthAndDateDescMinusSevenDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.FOURTH, LocalDate.now().minusDays(7))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    // За броя на яйцата от пето хале за  текущия ден
    @Override
    public Long findByHaleFiveAndDateDescCurrentDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.FIFTH, LocalDate.now())
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findFiveAndDateDescMinusOneDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.FIFTH, LocalDate.now().minusDays(1))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findFiveAndDateDescMinusTwoDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.FIFTH, LocalDate.now().minusDays(2))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findFiveAndDateDescMinusThreeDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.FIFTH, LocalDate.now().minusDays(3))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findFiveAndDateDescMinusFourthDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.FIFTH, LocalDate.now().minusDays(4))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findFiveAndDateDescMinusFiveDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.FIFTH, LocalDate.now().minusDays(5))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findFiveAndDateDescMinusSixDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.FIFTH, LocalDate.now().minusDays(6))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findFiveAndDateDescMinusSevenDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.FIFTH, LocalDate.now().minusDays(7))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    // За броя на яйцата от Шесто хале за  текущия ден
    @Override
    public Long findByHaleSixAndDateDescCurrentDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.SIXTH, LocalDate.now())
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findSixAndDateDescMinusOneDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.SIXTH, LocalDate.now().minusDays(1))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findSixAndDateDescMinusTwoDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.SIXTH, LocalDate.now().minusDays(2))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findSixAndDateDescMinusThreeDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.SIXTH, LocalDate.now().minusDays(3))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findSixAndDateDescMinusFourthDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.SIXTH, LocalDate.now().minusDays(4))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findSixAndDateDescMinusFiveDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.SIXTH, LocalDate.now().minusDays(5))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findSixAndDateDescMinusSixDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.SIXTH, LocalDate.now().minusDays(6))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findSixAndDateDescMinusSevenDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.SIXTH, LocalDate.now().minusDays(7))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    // За броя на яйцата от Седмо хале за  текущия ден
    @Override
    public Long findByHaleSevenAndDateDescCurrentDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.SEVENTH, LocalDate.now())
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findSevenAndDateDescMinusOneDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.SEVENTH, LocalDate.now().minusDays(1))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findSevenAndDateDescMinusTwoDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.SEVENTH, LocalDate.now().minusDays(2))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findSevenAndDateDescMinusThreeDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.SEVENTH, LocalDate.now().minusDays(3))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findSevenAndDateDescMinusFourthDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.SEVENTH, LocalDate.now().minusDays(4))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findSevenAndDateDescMinusFiveDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.SEVENTH, LocalDate.now().minusDays(5))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findSevenAndDateDescMinusSixDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.SEVENTH, LocalDate.now().minusDays(6))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findSevenAndDateDescMinusSevenDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.SEVENTH, LocalDate.now().minusDays(7))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    // За броя на яйцата от Осмо хале за  текущия ден
    @Override
    public Long findByHaleEightAndDateDescCurrentDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.EIGHTH, LocalDate.now())
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findEightAndDateDescMinusOneDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.EIGHTH, LocalDate.now().minusDays(1))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findEightAndDateDescMinusTwoDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.EIGHTH, LocalDate.now().minusDays(2))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findEightAndDateDescMinusThreeDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.EIGHTH, LocalDate.now().minusDays(3))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findEightAndDateDescMinusFourthDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.EIGHTH, LocalDate.now().minusDays(4))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findEightAndDateDescMinusFiveDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.EIGHTH, LocalDate.now().minusDays(5))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findEightAndDateDescMinusSixDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.EIGHTH, LocalDate.now().minusDays(6))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findEightAndDateDescMinusSevenDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.EIGHTH, LocalDate.now().minusDays(7))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    // За броя на яйцата от Девето хале за  текущия ден
    @Override
    public Long findByHaleNinthAndDateDescCurrentDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.NINTH, LocalDate.now())
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findNinthAndDateDescMinusOneDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.NINTH, LocalDate.now().minusDays(1))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findNinthAndDateDescMinusTwoDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.NINTH, LocalDate.now().minusDays(2))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findNinthAndDateDescMinusThreeDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.NINTH, LocalDate.now().minusDays(3))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findNinthAndDateDescMinusFourthDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.NINTH, LocalDate.now().minusDays(4))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findNinthAndDateDescMinusFiveDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.NINTH, LocalDate.now().minusDays(5))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findNinthAndDateDescMinusSixDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.NINTH, LocalDate.now().minusDays(6))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findNinthAndDateDescMinusSevenDay() {
        return eggAddRepository.findByHaleAndAddDate(CategoryHaleEnum.NINTH, LocalDate.now().minusDays(7))
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }
    // Край на процентната таблица

    @Override
    public Long findCoreyChezBaseLowerL() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_30_CHEZ).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyFamilyBaseLowerL() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_30_FAMILY).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyHartmanBaseLowerL() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_30_HARTMAN).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyEuroBaseLowerL() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_30_EURO).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCartons180BaseLowerBrownL() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.LOWER, CategoryCartonsEnum.CARTONS_180_BROWN).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCartons360BaseLowerBrownL() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.LOWER, CategoryCartonsEnum.CARTONS_360_BROWN).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyChezBaseLowerM() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_30_CHEZ).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyEuroBaseLowerM() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_30_EURO).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyHartmanBaseLowerM() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_30_HARTMAN).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyFamilyBaseLowerM() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_30_FAMILY).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findByCarton180BaseLowerBrownM() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.LOWER, CategoryCartonsEnum.CARTONS_180_BROWN).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findByCarton360BaseLowerBrownM() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.LOWER, CategoryCartonsEnum.CARTONS_360_BROWN).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyFamilyBaseLowerS() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_30_FAMILY).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyChezBaseLowerS() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_30_CHEZ).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyHartmanBaseLowerS() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_30_HARTMAN).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyEuroBaseLowerS() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_30_EURO).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCarton180BaseLowerBrownS() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.LOWER, CategoryCartonsEnum.CARTONS_180_BROWN).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCarton360BaseLowerBrownS() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.LOWER, CategoryCartonsEnum.CARTONS_360_BROWN).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyFamilyLowerBroken() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_30_FAMILY).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyEuroLowerBroken() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_30_EURO).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyHartmanLowerBroken() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_30_HARTMAN).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyChezLowerBroken() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_30_CHEZ).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findByCartonLowerBroken() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.LOWER, CategoryCartonsEnum.CARTONS_180_WHITE).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyChezUpperL() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_30_CHEZ).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyEuroUpperL() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_30_EURO).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyHartmanUpperL() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_30_HARTMAN).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyFamilyUpperL() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_30_FAMILY).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCarton180UpperBrownL() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.UPPER, CategoryCartonsEnum.CARTONS_180_BROWN).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCarton360UpperBrownL() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.UPPER, CategoryCartonsEnum.CARTONS_360_BROWN).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyFamilyUpperM() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_30_FAMILY).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyEuroUpperM() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_30_EURO).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyHartmanUpperM() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_30_HARTMAN).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyChezUpperM() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_30_CHEZ).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCarton180UpperBrownM() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.UPPER, CategoryCartonsEnum.CARTONS_180_BROWN).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCarton360UpperBrownM() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.UPPER, CategoryCartonsEnum.CARTONS_360_BROWN).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyChezUpperS() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_30_CHEZ).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyFamilyUpperS() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_30_FAMILY).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyHartmanUpperS() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_30_HARTMAN).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyEuroUpperS() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_30_EURO).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCarton180UpperBrownS() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.UPPER, CategoryCartonsEnum.CARTONS_180_BROWN).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCarton360UpperBrownS() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.UPPER, CategoryCartonsEnum.CARTONS_360_BROWN).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyEuroUpperBroken() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_30_EURO).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyChezUpperBroken() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_30_CHEZ).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyHartmanUpperBroken() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_30_HARTMAN).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCoreyFamilyUpperBroken() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_30_FAMILY).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCartonUpperBroken() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.UPPER, CategoryCartonsEnum.CARTONS_180_WHITE).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCarton360BaseUpperBrownBroken() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.UPPER, CategoryCartonsEnum.CARTONS_360_BROWN).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCarton180BaseUpperBrownBroken() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.UPPER, CategoryCartonsEnum.CARTONS_180_BROWN).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCarton360BaseLowerBrownBroken() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.LOWER, CategoryCartonsEnum.CARTONS_360_BROWN).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findCarton180BaseLowerBrownBroken() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.LOWER, CategoryCartonsEnum.CARTONS_180_BROWN).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountEgg(CategoryBaseEnum categoryBaseEnum, CategoryEggEnum categoryEggEnum, CategoryCartonsEnum categoryCartonsEnum) {
        return eggAddRepository.findAllByEggAndBaseAndCartons(categoryEggEnum, categoryBaseEnum, categoryCartonsEnum).
                stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }




}
