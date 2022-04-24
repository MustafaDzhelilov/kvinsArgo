package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.Fodder;
import com.example.projectsoftuni.model.entity.MainFodder;
import com.example.projectsoftuni.model.entity.enums.CategorySiloEnum;
import com.example.projectsoftuni.model.entity.enums.CategorySupplierEnum;
import com.example.projectsoftuni.model.service.FodderServiceModel;
import com.example.projectsoftuni.model.service.MainFodderServiceModel;
import com.example.projectsoftuni.model.service.SearchFromToKgAcceptedFooderServiceModel;
import com.example.projectsoftuni.repository.FodderRepository;
import com.example.projectsoftuni.repository.MainFodderRepository;
import com.example.projectsoftuni.service.FodderService;
import com.example.projectsoftuni.service.MainFodderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FodderServiceImpl implements FodderService {

    private final FodderRepository fodderRepository;
    private final ModelMapper modelMapper;
    private final FodderServiceModel fodderServiceModel;
    private final SearchFromToKgAcceptedFooderServiceModel searchFromToKgAcceptedFooderServiceModel;
    private final MainFodderService mainFodderService;
    private final MainFodderServiceModel mainFodderServiceModel;
    private final MainFodderRepository mainFodderRepository;
    Long diffKg = 0L;
    Long count = 0L;

    public FodderServiceImpl(FodderRepository fodderRepository, ModelMapper modelMapper, FodderServiceModel fodderServiceModel, SearchFromToKgAcceptedFooderServiceModel searchFromToKgAcceptedFooderServiceModel, MainFodderService mainFodderService, MainFodderServiceModel mainFodderServiceModel, MainFodderRepository mainFodderRepository) {
        this.fodderRepository = fodderRepository;
        this.modelMapper = modelMapper;
        this.fodderServiceModel = fodderServiceModel;
        this.searchFromToKgAcceptedFooderServiceModel = searchFromToKgAcceptedFooderServiceModel;
        this.mainFodderService = mainFodderService;
        this.mainFodderServiceModel = mainFodderServiceModel;
        this.mainFodderRepository = mainFodderRepository;
    }

    @Override
    public void add(FodderServiceModel fodderServiceModel) {
        Fodder fodder = modelMapper.map(fodderServiceModel, Fodder.class);
        fodder.setSiloEnum(fodderServiceModel.getSiloEnum());
        fodder.setKilogramOfFodder(fodderServiceModel.getKilogramOfFodder());
        fodder.setAcceptedTime(fodderServiceModel.getAcceptedTime());

        MainFodder mainFodder = modelMapper.map(mainFodderServiceModel, MainFodder.class);
        mainFodder.setSupplierEnum(CategorySupplierEnum.KVINS);
        mainFodder.setKilogramOfFodder(-fodderServiceModel.getKilogramOfFodder());
        mainFodder.setAcceptedTime(fodderServiceModel.getAcceptedTime());

        Long currentFodderKgAfterScale = mainFodderService.getKg();

        if(currentFodderKgAfterScale >= fodderServiceModel.getKilogramOfFodder()){
            fodderRepository.save(fodder);
            mainFodderRepository.save(mainFodder);
        }else{
            count = 1L;
            diffKg = fodderServiceModel.getKilogramOfFodder() - currentFodderKgAfterScale;
        }

    }

    @Override
    public Long checkStatusKg() {
        Long result = -1L;
        if(count == 0){
            result = count;
        }else if(count == 1) {
            result = diffKg;
        }
        return result;
    }

    @Override
    public Long getKgOfFodderBySiloLast(CategorySiloEnum siloEnum) {
        return fodderRepository.
                getAllBySiloEnum(siloEnum).
                stream().
                map(Fodder::getKilogramOfFodder).
                reduce(Long::sum).
                orElse(0L);
    }

    @Override
    public Long getKGSilo1() {
        return fodderRepository.getAllBySiloEnum(CategorySiloEnum.SILO_1).stream().map(Fodder::getKilogramOfFodder).
                reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKGSilo2() {
        return fodderRepository.getAllBySiloEnum(CategorySiloEnum.SILO_2).stream().map(Fodder::getKilogramOfFodder).
                reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKGSilo3() {
        return fodderRepository.getAllBySiloEnum(CategorySiloEnum.SILO_3).stream().map(Fodder::getKilogramOfFodder).
                reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKGSilo4() {
        return fodderRepository.getAllBySiloEnum(CategorySiloEnum.SILO_4).stream().map(Fodder::getKilogramOfFodder).
                reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKGSilo5() {
        return fodderRepository.getAllBySiloEnum(CategorySiloEnum.SILO_5).stream().map(Fodder::getKilogramOfFodder).
                reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKGSilo6() {
        return fodderRepository.getAllBySiloEnum(CategorySiloEnum.SILO_6).stream().map(Fodder::getKilogramOfFodder).
                reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKGSilo7() {
        return fodderRepository.getAllBySiloEnum(CategorySiloEnum.SILO_7).stream().map(Fodder::getKilogramOfFodder).
                reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKGSilo8() {
        return fodderRepository.getAllBySiloEnum(CategorySiloEnum.SILO_8).stream().map(Fodder::getKilogramOfFodder).
                reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKGSilo9() {
        return fodderRepository.getAllBySiloEnum(CategorySiloEnum.SILO_9).stream().map(Fodder::getKilogramOfFodder).
                reduce(Long::sum).orElse(0L);
    }


    //До 62 ред за текущия ден
    @Override
    public Long getKgOfFodder() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_1, LocalDate.now()).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo2() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_2, LocalDate.now()).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo3() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_3, LocalDate.now()).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo4() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_4, LocalDate.now()).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    // за текущия ден -1 ден
    @Override
    public Long getKgOfFodderMinOne() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_1, LocalDate.now().minusDays(1)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo2MinOne() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_2, LocalDate.now().minusDays(1)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo3MinOne() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_3, LocalDate.now().minusDays(1)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo4MinOne() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_4, LocalDate.now().minusDays(1)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    //До 110 ред за текущия ден -2 ден
    @Override
    public Long getKgOfFodderMinTwo() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_1, LocalDate.now().minusDays(2)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo2MinTwo() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_2, LocalDate.now().minusDays(2)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo3MinTwo() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_3, LocalDate.now().minusDays(2)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo4MinTwo() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_4, LocalDate.now().minusDays(2)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    //До 134 ред за текущия ден -3 дена
    @Override
    public Long getKgOfFodderMinThree() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_1, LocalDate.now().minusDays(3)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo2MinThree() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_2, LocalDate.now().minusDays(3)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo3MinThree() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_3, LocalDate.now().minusDays(3)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo4MinThree() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_4, LocalDate.now().minusDays(3)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    //До 158 ред за текущия ден -4 дена
    @Override
    public Long getKgOfFodderMinFourth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_1, LocalDate.now().minusDays(4)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo2MinFourth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_2, LocalDate.now().minusDays(4)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo3MinFourth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_3, LocalDate.now().minusDays(4)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo4MinFourth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_4, LocalDate.now().minusDays(4)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    //До 182 ред за текущия ден -5 дена
    @Override
    public Long getKgOfFodderMinFifth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_1, LocalDate.now().minusDays(5)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo2MinFifth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_2, LocalDate.now().minusDays(5)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo3MinFifth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_3, LocalDate.now().minusDays(5)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo4MinFifth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_4, LocalDate.now().minusDays(5)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    //До  ред за текущия ден -5 дена
    @Override
    public Long getKgOfFodderMinSix() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_1, LocalDate.now().minusDays(6)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo2MinSix() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_2, LocalDate.now().minusDays(6)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo3MinSix() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_3, LocalDate.now().minusDays(6)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo4MinSix() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_4, LocalDate.now().minusDays(6)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderHale5() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_5, LocalDate.now()).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo6() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_6, LocalDate.now()).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo7() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_7, LocalDate.now()).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);

    }

    @Override
    public Long getKgOfFodderSilo8() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_8, LocalDate.now()).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo9() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_9, LocalDate.now()).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderHale5MinOne() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_5, LocalDate.now().minusDays(1)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo6MinOne() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_6, LocalDate.now().minusDays(1)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo7MinOne() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(1)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo8MinOne() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_8, LocalDate.now().minusDays(1)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo9MinOne() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_9, LocalDate.now().minusDays(1)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderHale5MinTwo() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_5, LocalDate.now().minusDays(2)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo6MinTwo() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_6, LocalDate.now().minusDays(2)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo7MinTwo() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(2)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo8MinTwo() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_8, LocalDate.now().minusDays(2)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo9MinTwo() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_9, LocalDate.now().minusDays(2)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderHale5MinThree() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_5, LocalDate.now().minusDays(3)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo6MinThree() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_6, LocalDate.now().minusDays(3)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);

    }

    @Override
    public Long getKgOfFodderSilo7MinThree() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(3)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo8MinThree() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_8, LocalDate.now().minusDays(3)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo9MinThree() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_9, LocalDate.now().minusDays(3)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderHale5MinFourth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_5, LocalDate.now().minusDays(4)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo6MinFourth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_6, LocalDate.now().minusDays(4)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo7MinFourth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(4)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo8MinFourth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_8, LocalDate.now().minusDays(4)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo9MinFourth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_9, LocalDate.now().minusDays(4)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderHale5MinFive() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_5, LocalDate.now().minusDays(5)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo6MinFive() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_6, LocalDate.now().minusDays(5)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo7MinFive() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(5)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo8MinFive() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_8, LocalDate.now().minusDays(5)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo9MinFive() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_9, LocalDate.now().minusDays(5)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderHale5MinSix() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_5, LocalDate.now().minusDays(6)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo6MinSix() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_6, LocalDate.now().minusDays(6)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo7MinSix() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(7)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo8MinSix() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(6)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getKgOfFodderSilo9MinSix() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_9, LocalDate.now().minusDays(6)).
                stream().map(Fodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }

    @Override
    public List<Fodder> getKgOfFodderBySilo(SearchFromToKgAcceptedFooderServiceModel searchFromToKgAcceptedFooderServiceModel) {
        return fodderRepository.
                getAllByAcceptedTimeBetween(searchFromToKgAcceptedFooderServiceModel.getStart(),
                        searchFromToKgAcceptedFooderServiceModel.getEnd());
    }


}


