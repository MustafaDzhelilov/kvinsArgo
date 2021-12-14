package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.Cartons;
import com.example.projectsoftuni.model.entity.Egg;
import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;
import com.example.projectsoftuni.model.service.CartonServiceModel;
import com.example.projectsoftuni.model.service.EggServiceModel;
import com.example.projectsoftuni.repository.CartonAddRepository;
import com.example.projectsoftuni.repository.EggAddRepository;
import com.example.projectsoftuni.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

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


    public EggAddServiceImpl(EggAddRepository eggAddRepository, ModelMapper modelMapper, EggCategoryService eggCategoryService
            , BaseCategoryService baseCategoryService, CartonCategoryService cartonCategoryService, HaleCategoryService haleCategoryService, CartonAddService cartonAddService, CartonServiceModel cartonServiceModel, CartonAddRepository cartonAddRepository) {
        this.eggAddRepository = eggAddRepository;
        this.modelMapper = modelMapper;
        this.eggCategoryService = eggCategoryService;
        this.baseCategoryService = baseCategoryService;
        this.cartonCategoryService = cartonCategoryService;

        this.haleCategoryService = haleCategoryService;
        this.cartonAddService = cartonAddService;
        this.cartonServiceModel = cartonServiceModel;
        this.cartonAddRepository = cartonAddRepository;
    }

    @Override
    public void add(EggServiceModel eggServiceModel) {
        Egg egg = modelMapper.map(eggServiceModel, Egg.class);
        egg.setEgg(eggServiceModel.getEgg());
        egg.setBase(eggServiceModel.getBase());
        egg.setCartons(eggServiceModel.getCartons());
        egg.setHale(eggServiceModel.getHale());

        //  За намаляне на бройката от картони/кори след като се направи добавяне на яйца
        Cartons cartons =  modelMapper.map(cartonServiceModel, Cartons.class);
        cartons.setCartons(eggServiceModel.getCartons());
        cartons.setBase(eggServiceModel.getBase());
        LocalDateTime date = LocalDateTime.now();
        cartons.setDate(date);
        int  isZero = 1;

        if(egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_20)){

            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 20;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCore120FromBaseLowerLast();
            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            cartons.setCount(countOfCorey20FromLowerBase - divideCountOfEgg);

        }else if(egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_120)){

            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 120;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton120FromBaseLower();
            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            cartons.setCount(countOfCorey20FromLowerBase - divideCountOfEgg);

        } else if(egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30)){

            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCore180FromBaseLower();
            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            cartons.setCount(countOfCorey20FromLowerBase - divideCountOfEgg);

        } else if(egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180)){

            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 180;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton180FromBaseLower();
            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            cartons.setCount(countOfCorey20FromLowerBase - divideCountOfEgg);

        } else if(egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_20)){

            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 20;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCore120FromBaseUpper();
            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            cartons.setCount(countOfCorey20FromLowerBase - divideCountOfEgg);

        } else if(egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_120)){

            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 120;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton120FromBaseUpper();
            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            cartons.setCount(countOfCorey20FromLowerBase - divideCountOfEgg);

        } else if(egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30)){

            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 30;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCore180FromBaseUpper();
            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            cartons.setCount(countOfCorey20FromLowerBase - divideCountOfEgg);

        } else if(egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180)){

            Long divideCountOfEgg = (eggServiceModel.getCountOfEgg()) / 180;
            Long countOfCorey20FromLowerBase = cartonAddService.getCountOfCarton180FromBaseUpper();
            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            cartons.setCount(countOfCorey20FromLowerBase - divideCountOfEgg);

        }

        if(isZero == 1) {
            eggAddRepository.save(egg);
            cartonAddRepository.save(cartons);
        }

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
    public Long findByCategoryLCoreyLower() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_30)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findByCategoryLCartonLower() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.LOWER, CategoryCartonsEnum.CARTONS_180)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findByCategoryMCoreyLower() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_30)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findByCategoryMCartonLower() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.LOWER, CategoryCartonsEnum.CARTONS_180)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findByCategorySCoreyLower() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_30)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findByCategorySCartonLower() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.LOWER, CategoryCartonsEnum.CARTONS_180)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findByCategoryBrokenLower() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_30)
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
    public Long findByCategoryLCoreyUpper() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_30)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findByCategoryLCartonsUpper() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.L, CategoryBaseEnum.UPPER, CategoryCartonsEnum.CARTONS_180)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findByCategoryMCoreyUpper() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_30)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findByCategoryMCartonsUpper() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.M, CategoryBaseEnum.UPPER, CategoryCartonsEnum.CARTONS_180)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findByCategorySCoreyUpper() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_30)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findByCategorySCartonUpper() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.S, CategoryBaseEnum.UPPER, CategoryCartonsEnum.CARTONS_180)
                .stream().map(Egg::getCountOfEgg).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long findByCategoryBrokenUpper() {
        return eggAddRepository.findAllByEggAndBaseAndCartons(CategoryEggEnum.BROKEN, CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_30)
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

}
