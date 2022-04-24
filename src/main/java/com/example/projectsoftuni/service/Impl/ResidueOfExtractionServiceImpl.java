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
import com.example.projectsoftuni.service.CartonAddService;
import com.example.projectsoftuni.service.ResidueOfExtractionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class ResidueOfExtractionServiceImpl implements ResidueOfExtractionService {

    private final ResidueOfExtractionRepository residueOfExtractionRepository;
    private final ModelMapper modelMapper;
    private final CartonServiceModel cartonServiceModel;
    private final CartonAddRepository cartonAddRepository;
    private final EggAddRepository eggAddRepository;
    private final EggServiceModel eggServiceModel;
    private final CartonAddService cartonAddService;
    int  isZero = 1;

    public ResidueOfExtractionServiceImpl(ResidueOfExtractionRepository residueOfExtractionRepository, ModelMapper modelMapper, CartonServiceModel cartonServiceModel, CartonAddRepository cartonAddRepository, EggAddRepository eggAddRepository, EggServiceModel eggServiceModel, CartonAddService cartonAddService) {
        this.residueOfExtractionRepository = residueOfExtractionRepository;
        this.modelMapper = modelMapper;
        this.cartonServiceModel = cartonServiceModel;
        this.cartonAddRepository = cartonAddRepository;
        this.eggAddRepository = eggAddRepository;
        this.eggServiceModel = eggServiceModel;
        this.cartonAddService = cartonAddService;
    }

    @Override
    public void packagingLower(ResidueOfExtractionServiceModel residueOfExtractionServiceModel) {

        ResidueOfExtraction residueOfExtraction = modelMapper.map(residueOfExtractionServiceModel, ResidueOfExtraction.class);
        residueOfExtraction.setAddDate(LocalDate.now());
        residueOfExtraction.setBase(CategoryBaseEnum.LOWER);
        residueOfExtraction.setCountOfEgg(-residueOfExtractionServiceModel.getCountOfEgg());
        residueOfExtraction.setEgg(residueOfExtractionServiceModel.getEgg());
        residueOfExtraction.setCartons(residueOfExtractionServiceModel.getCartons());
        residueOfExtraction.setCoreyInCartons(residueOfExtractionServiceModel.getCoreyInCartons());
        residueOfExtraction.setHale(CategoryHaleEnum.RESIDUE);

        Cartons cartons = modelMapper.map(cartonServiceModel, Cartons.class);
        cartons.setDate(LocalDateTime.now());
        cartons.setBase(CategoryBaseEnum.LOWER);
        cartons.setCartons(residueOfExtractionServiceModel.getCartons());

        Cartons coreyInCartons = modelMapper.map(cartonServiceModel, Cartons.class);
        coreyInCartons.setDate(LocalDateTime.now());
        coreyInCartons.setBase(CategoryBaseEnum.LOWER);
        coreyInCartons.setCartons(residueOfExtractionServiceModel.getCoreyInCartons());

        Egg egg = modelMapper.map(eggServiceModel, Egg.class);
        egg.setEgg(residueOfExtractionServiceModel.getEgg());
        egg.setHale(CategoryHaleEnum.RESIDUE);
        egg.setBase(CategoryBaseEnum.LOWER);
        egg.setCountOfEgg(residueOfExtractionServiceModel.getCountOfEgg());
        egg.setCartons(residueOfExtractionServiceModel.getCartons());
        egg.setCoreyInCartons(residueOfExtractionServiceModel.getCoreyInCartons());
        egg.setAddDate(LocalDate.now());


        if(residueOfExtraction.getBase().equals(CategoryBaseEnum.LOWER)
                && residueOfExtraction.getCartons().equals(CategoryCartonsEnum.COREY_20)){

            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 20;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCore120FromBaseLower();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartons.setCount(-divideCountOfEgg);

        }else if(residueOfExtraction.getBase().equals(CategoryBaseEnum.LOWER) &&
                residueOfExtraction.getCartons().equals(CategoryCartonsEnum.CARTONS_120)) {

            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 120;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton120FromBaseLower();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }


            cartons.setCount(-divideCountOfEgg);
            coreyInCartons.setCount(-divideCountOfEgg * 8);

        }else if(residueOfExtraction.getBase().equals(CategoryBaseEnum.LOWER) &&
                residueOfExtraction.getCartons().equals(CategoryCartonsEnum.CARTONS_180_WHITE)) {
            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 180;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton180FromBaseLower();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartons.setCount(-divideCountOfEgg);
            coreyInCartons.setCount(-divideCountOfEgg * 8);

        }else if(residueOfExtraction.getBase().equals(CategoryBaseEnum.LOWER) &&
                residueOfExtraction.getCartons().equals(CategoryCartonsEnum.CARTONS_180_BROWN)) {
            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 180;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton180FromBaseLowerBrown();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartons.setCount(-divideCountOfEgg);
            coreyInCartons.setCount(-divideCountOfEgg * 8);

        }else if(residueOfExtraction.getBase().equals(CategoryBaseEnum.LOWER) &&
                residueOfExtraction.getCartons().equals(CategoryCartonsEnum.CARTONS_360_BROWN)) {
            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 360;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton360FromBaseLowerBrown();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartons.setCount(-divideCountOfEgg);
            coreyInCartons.setCount(-divideCountOfEgg * 8);

        } else if(residueOfExtraction.getBase().equals(CategoryBaseEnum.LOWER)
                && residueOfExtraction.getCartons().equals(CategoryCartonsEnum.COREY_30_FAMILY)){

            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyFamilyLower();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartons.setCount(-divideCountOfEgg);

        }else if(residueOfExtraction.getBase().equals(CategoryBaseEnum.LOWER)
                && residueOfExtraction.getCartons().equals(CategoryCartonsEnum.COREY_30_CHEZ)){

            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyChezLower();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartons.setCount(-divideCountOfEgg);

        }  else if(residueOfExtraction.getBase().equals(CategoryBaseEnum.LOWER)
                && residueOfExtraction.getCartons().equals(CategoryCartonsEnum.COREY_30_EURO)){

            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyEuroLower();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartons.setCount(-divideCountOfEgg);

        } else if(residueOfExtraction.getBase().equals(CategoryBaseEnum.LOWER)
                && residueOfExtraction.getCartons().equals(CategoryCartonsEnum.COREY_30_HARTMAN)){

            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyHartmanLower();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartons.setCount(-divideCountOfEgg);

        } else if(residueOfExtraction.getBase().equals(CategoryBaseEnum.LOWER)
                && residueOfExtraction.getCartons().equals(CategoryCartonsEnum.COREY_UKRAYNA)){

            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyUkraynaLower();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartons.setCount(-divideCountOfEgg);

        }else if(residueOfExtraction.getBase().equals(CategoryBaseEnum.LOWER)
                && residueOfExtraction.getCartons().equals(CategoryCartonsEnum.COREY_ELPA)){

            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyElpaLower();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartons.setCount(-divideCountOfEgg);

        }else if(residueOfExtraction.getBase().equals(CategoryBaseEnum.LOWER)
                && residueOfExtraction.getCartons().equals(CategoryCartonsEnum.COREY_EKO_FARM)){

            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyEkoFarmLower();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartons.setCount(-divideCountOfEgg);

        }else if(residueOfExtraction.getBase().equals(CategoryBaseEnum.LOWER)
                && residueOfExtraction.getCartons().equals(CategoryCartonsEnum.COREY_NEW1)){

            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyNew1Lower();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartons.setCount(-divideCountOfEgg);

        }else if(residueOfExtraction.getBase().equals(CategoryBaseEnum.LOWER)
                && residueOfExtraction.getCartons().equals(CategoryCartonsEnum.COREY_NEW2)){

            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyNew2Lower();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }
            cartons.setCount(-divideCountOfEgg);

        }

        if(isZero == 1) {
            residueOfExtractionRepository.save(residueOfExtraction);
            cartonAddRepository.save(cartons);
            eggAddRepository.save(egg);
            if (residueOfExtractionServiceModel.getCoreyInCartons() != null) {
                cartonAddRepository.save(coreyInCartons);
            }
        }

    }

    @Override
    public Long getCountXlLower() {
        return residueOfExtractionRepository.findAllByEggAndBase(CategoryEggEnum.XL, CategoryBaseEnum.LOWER).
                stream().map(ResidueOfExtraction::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountLLower() {
        return residueOfExtractionRepository.findAllByEggAndBase(CategoryEggEnum.L, CategoryBaseEnum.LOWER).
                stream().map(ResidueOfExtraction::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountMLower() {
        return residueOfExtractionRepository.findAllByEggAndBase(CategoryEggEnum.M, CategoryBaseEnum.LOWER).
                stream().map(ResidueOfExtraction::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountSLower() {
        return residueOfExtractionRepository.findAllByEggAndBase(CategoryEggEnum.S, CategoryBaseEnum.LOWER).
                stream().map(ResidueOfExtraction::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountHLower() {
        return residueOfExtractionRepository.findAllByEggAndBase(CategoryEggEnum.BROKEN, CategoryBaseEnum.LOWER).
                stream().map(ResidueOfExtraction::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountXlUpper() {
        return residueOfExtractionRepository.findAllByEggAndBase(CategoryEggEnum.XL, CategoryBaseEnum.UPPER).
                stream().map(ResidueOfExtraction::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountLUpper() {
        return residueOfExtractionRepository.findAllByEggAndBase(CategoryEggEnum.L, CategoryBaseEnum.UPPER).
                stream().map(ResidueOfExtraction::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountMUpper() {
        return residueOfExtractionRepository.findAllByEggAndBase(CategoryEggEnum.M, CategoryBaseEnum.UPPER).
                stream().map(ResidueOfExtraction::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountSUpper() {
        return residueOfExtractionRepository.findAllByEggAndBase(CategoryEggEnum.S, CategoryBaseEnum.UPPER).
                stream().map(ResidueOfExtraction::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountHUpper() {
        return residueOfExtractionRepository.findAllByEggAndBase(CategoryEggEnum.BROKEN, CategoryBaseEnum.UPPER).
                stream().map(ResidueOfExtraction::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public void packagingUpper(ResidueOfExtractionServiceModel residueOfExtractionServiceModel) {

        ResidueOfExtraction residueOfExtractionUpper = modelMapper.map(residueOfExtractionServiceModel, ResidueOfExtraction.class);
        residueOfExtractionUpper.setAddDate(LocalDate.now());
        residueOfExtractionUpper.setBase(CategoryBaseEnum.UPPER);
        residueOfExtractionUpper.setCountOfEgg(-residueOfExtractionServiceModel.getCountOfEgg());
        residueOfExtractionUpper.setEgg(residueOfExtractionServiceModel.getEgg());
        residueOfExtractionUpper.setCartons(residueOfExtractionServiceModel.getCartons());
        residueOfExtractionUpper.setCoreyInCartons(residueOfExtractionServiceModel.getCoreyInCartons());
        residueOfExtractionUpper.setHale(CategoryHaleEnum.RESIDUE);

        Cartons cartonsUpper = modelMapper.map(cartonServiceModel, Cartons.class);
        cartonsUpper.setDate(LocalDateTime.now());
        cartonsUpper.setBase(CategoryBaseEnum.UPPER);
        cartonsUpper.setCartons(residueOfExtractionServiceModel.getCartons());

        Cartons coreyInCartonsUpper = modelMapper.map(cartonServiceModel, Cartons.class);
        coreyInCartonsUpper.setDate(LocalDateTime.now());
        coreyInCartonsUpper.setBase(CategoryBaseEnum.UPPER);
        coreyInCartonsUpper.setCartons(residueOfExtractionServiceModel.getCoreyInCartons());

        Egg eggUpper = modelMapper.map(eggServiceModel, Egg.class);
        eggUpper.setEgg(residueOfExtractionServiceModel.getEgg());
        eggUpper.setHale(CategoryHaleEnum.RESIDUE);
        eggUpper.setBase(CategoryBaseEnum.UPPER);
        eggUpper.setCountOfEgg(residueOfExtractionServiceModel.getCountOfEgg());
        eggUpper.setCartons(residueOfExtractionServiceModel.getCartons());
        eggUpper.setCoreyInCartons(residueOfExtractionServiceModel.getCoreyInCartons());
        eggUpper.setAddDate(LocalDate.now());



        if(residueOfExtractionUpper.getBase().equals(CategoryBaseEnum.UPPER)
                && residueOfExtractionUpper.getCartons().equals(CategoryCartonsEnum.COREY_20)){

            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 20;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCore120FromBaseUpper();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartonsUpper.setCount(-divideCountOfEgg);

        }else if(residueOfExtractionUpper.getBase().equals(CategoryBaseEnum.UPPER) &&
                residueOfExtractionUpper.getCartons().equals(CategoryCartonsEnum.CARTONS_120)) {
            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 120;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton120FromBaseUpper();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartonsUpper.setCount(-divideCountOfEgg);
            coreyInCartonsUpper.setCount(-divideCountOfEgg * 8);

        }else if(residueOfExtractionUpper.getBase().equals(CategoryBaseEnum.UPPER) &&
                residueOfExtractionUpper.getCartons().equals(CategoryCartonsEnum.CARTONS_180_WHITE)) {
            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 180;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton180FromBaseUpper();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartonsUpper.setCount(-divideCountOfEgg);
            coreyInCartonsUpper.setCount(-divideCountOfEgg * 8);

        }else if(residueOfExtractionUpper.getBase().equals(CategoryBaseEnum.UPPER) &&
                residueOfExtractionUpper.getCartons().equals(CategoryCartonsEnum.CARTONS_180_BROWN)) {
            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 180;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton180FromBaseUpperBrown();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartonsUpper.setCount(-divideCountOfEgg);
            coreyInCartonsUpper.setCount(-divideCountOfEgg * 8);

        }else if(residueOfExtractionUpper.getBase().equals(CategoryBaseEnum.UPPER) &&
                residueOfExtractionUpper.getCartons().equals(CategoryCartonsEnum.CARTONS_360_BROWN)) {
            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 360;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton360FromBaseUpperBrown();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartonsUpper.setCount(-divideCountOfEgg);
            coreyInCartonsUpper.setCount(-divideCountOfEgg * 8);

        } else if(residueOfExtractionUpper.getBase().equals(CategoryBaseEnum.UPPER)
                && residueOfExtractionUpper.getCartons().equals(CategoryCartonsEnum.COREY_30_FAMILY)){

            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyFamilyUpper();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartonsUpper.setCount(-divideCountOfEgg);

        }else if(residueOfExtractionUpper.getBase().equals(CategoryBaseEnum.UPPER)
                && residueOfExtractionUpper.getCartons().equals(CategoryCartonsEnum.COREY_30_CHEZ)){

            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyChezUpper();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartonsUpper.setCount(-divideCountOfEgg);

        }  else if(residueOfExtractionUpper.getBase().equals(CategoryBaseEnum.UPPER)
                && residueOfExtractionUpper.getCartons().equals(CategoryCartonsEnum.COREY_30_EURO)){

            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyEuroUpper();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartonsUpper.setCount(-divideCountOfEgg);

        } else if(residueOfExtractionUpper.getBase().equals(CategoryBaseEnum.UPPER)
                && residueOfExtractionUpper.getCartons().equals(CategoryCartonsEnum.COREY_30_HARTMAN)){

            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyHartmanUpper();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartonsUpper.setCount(-divideCountOfEgg);

        } else if(residueOfExtractionUpper.getBase().equals(CategoryBaseEnum.UPPER)
                && residueOfExtractionUpper.getCartons().equals(CategoryCartonsEnum.COREY_UKRAYNA)){

            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyUkraynaUpper();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartonsUpper.setCount(-divideCountOfEgg);

        }else if(residueOfExtractionUpper.getBase().equals(CategoryBaseEnum.UPPER)
                && residueOfExtractionUpper.getCartons().equals(CategoryCartonsEnum.COREY_ELPA)){

            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyElpaUpper();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartonsUpper.setCount(-divideCountOfEgg);

        }else if(residueOfExtractionUpper.getBase().equals(CategoryBaseEnum.UPPER)
                && residueOfExtractionUpper.getCartons().equals(CategoryCartonsEnum.COREY_EKO_FARM)){

            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyEkoFarmUpper();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartonsUpper.setCount(-divideCountOfEgg);

        }else if(residueOfExtractionUpper.getBase().equals(CategoryBaseEnum.UPPER)
                && residueOfExtractionUpper.getCartons().equals(CategoryCartonsEnum.COREY_NEW1)){

            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyNew1Upper();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartonsUpper.setCount(-divideCountOfEgg);

        }else if(residueOfExtractionUpper.getBase().equals(CategoryBaseEnum.UPPER)
                && residueOfExtractionUpper.getCartons().equals(CategoryCartonsEnum.COREY_NEW2)){

            Long divideCountOfEgg = (residueOfExtractionServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountCoreyNew2Upper();
            if(countOfCorey20FromLowerBase < divideCountOfEgg){
                isZero = 0;
            }

            cartonsUpper.setCount(-divideCountOfEgg);

        }

        if(isZero == 1) {
            residueOfExtractionRepository.save(residueOfExtractionUpper);
            cartonAddRepository.save(cartonsUpper);
            eggAddRepository.save(eggUpper);
            if (residueOfExtractionServiceModel.getCoreyInCartons() != null) {
                cartonAddRepository.save(coreyInCartonsUpper);
            }
        }
    }

    @Override
    public int getStatusIsZero() {
        return isZero;
    }
}
