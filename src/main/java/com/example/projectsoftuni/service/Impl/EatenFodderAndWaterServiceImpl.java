package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.EatenFodderAndWater;
import com.example.projectsoftuni.model.entity.Fodder;
import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;
import com.example.projectsoftuni.model.entity.enums.CategorySiloEnum;
import com.example.projectsoftuni.model.entity.enums.CategorySupplierEnum;
import com.example.projectsoftuni.model.service.EatenFodderAndWaterServiceModel;
import com.example.projectsoftuni.model.service.FodderServiceModel;
import com.example.projectsoftuni.repository.EatenFodderAndWaterRepository;
import com.example.projectsoftuni.repository.FodderRepository;
import com.example.projectsoftuni.service.EatenFodderAndWaterService;
import com.example.projectsoftuni.service.FodderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EatenFodderAndWaterServiceImpl implements EatenFodderAndWaterService {

    private final ModelMapper modelMapper;
    private final EatenFodderAndWaterServiceModel eatenFodderAndWaterServiceModel;
    private final EatenFodderAndWaterRepository eatenFodderAndWaterRepository;
    private final FodderService fodderService;
    private final FodderServiceModel fodderServiceModel;
    private final FodderRepository fodderRepository;

    public EatenFodderAndWaterServiceImpl(ModelMapper modelMapper, EatenFodderAndWaterServiceModel eatenFodderAndWaterServiceModel, EatenFodderAndWaterRepository eatenFodderAndWaterRepository, FodderService fodderService, FodderServiceModel fodderServiceModel, FodderRepository fodderRepository) {
        this.modelMapper = modelMapper;
        this.eatenFodderAndWaterServiceModel = eatenFodderAndWaterServiceModel;
        this.eatenFodderAndWaterRepository = eatenFodderAndWaterRepository;
        this.fodderService = fodderService;
        this.fodderServiceModel = fodderServiceModel;
        this.fodderRepository = fodderRepository;
    }

    @Override
    public void add(EatenFodderAndWaterServiceModel eatenFodderAndWaterServiceModel) {
        EatenFodderAndWater eatenFodderAndWater = modelMapper.map(eatenFodderAndWaterServiceModel, EatenFodderAndWater.class);
        eatenFodderAndWater.setSiloEnum(eatenFodderAndWaterServiceModel.getSiloEnum());
        eatenFodderAndWater.setKilogramOfFodder(eatenFodderAndWaterServiceModel.getKilogramOfFodder());
        eatenFodderAndWater.setLitreOfWater(eatenFodderAndWater.getLitreOfWater());
        eatenFodderAndWater.setAcceptedTime(eatenFodderAndWater.getAcceptedTime());

        //???? ?????????? ???? ???????????? ???? ???????? ???????????????????? ???? ???????????????????????? ???? ????????.
        Fodder fodder = modelMapper.map(fodderServiceModel, Fodder.class);
        fodder.setSiloEnum(eatenFodderAndWaterServiceModel.getSiloEnum());
        Fodder currentKgOfFodder = fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(eatenFodderAndWaterServiceModel.getSiloEnum(),
                        eatenFodderAndWaterServiceModel.getAcceptedTime());
        Long kg = currentKgOfFodder.getKilogramOfFodder();
        fodder.setKilogramOfFodder(eatenFodderAndWaterServiceModel.getKilogramOfFodder() - kg);
        fodder.setAcceptedTime(eatenFodderAndWaterServiceModel.getAcceptedTime().plusDays(1));


        eatenFodderAndWaterRepository.save(eatenFodderAndWater);
        fodderRepository.save(fodder);
    }
    // ???? 111 ?????? ???? ???????? 1 ???? ???????? 4 ???? ?????????????? ?????? ???? ???????? ?? ??????????
    @Override
    public Long findLastRecordsByCategory() {
        return eatenFodderAndWaterRepository.
                getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_1, LocalDate.now()).
                getKilogramOfFodder();

    }

    @Override
    public Long findLastRecordsByCategoryHale2() {
        return eatenFodderAndWaterRepository.
                getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_2, LocalDate.now()).
                getKilogramOfFodder();
    }

    @Override
    public Long findLastRecordsByCategoryHale3() {
        return eatenFodderAndWaterRepository.
                getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_3, LocalDate.now()).
                getKilogramOfFodder();
    }

    @Override
    public Long findLastRecordsByCategoryHale4() {
        return eatenFodderAndWaterRepository.
                getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_4, LocalDate.now()).
                getKilogramOfFodder();
    }

    //???? 111 ?????? ???? ?????????????? ?????? ???? ???????? ?? ??????????
    @Override
    public Long getLitreOfWater() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_1, LocalDate.now()).getLitreOfWater();
    }

    @Override
    public Long getLitreOfWaterHale2() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_2, LocalDate.now()).getLitreOfWater();
    }

    @Override
    public Long getLitreOfWaterHale3() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_3, LocalDate.now()).getLitreOfWater();
    }

    @Override
    public Long getLitreOfWaterHale4() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_4, LocalDate.now()).getLitreOfWater();
    }
    // ???? ?????????????? ?????? -1 ?????? ???? ???????? ?? ??????????
    @Override
    public Long findLastRecordsByCategoryHale1MinOne() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_1, LocalDate.now().minusDays(1)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterMinOne() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_1, LocalDate.now().minusDays(1)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale2MinOne() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_2, LocalDate.now().minusDays(1)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale2MinOne() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_2, LocalDate.now().minusDays(1)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale3MinOne() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_3, LocalDate.now().minusDays(1)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale3MinOne() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_3, LocalDate.now().minusDays(1)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale4MinOne() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_4, LocalDate.now().minusDays(1)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale4MinOne() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_4, LocalDate.now().minusDays(1)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale1MinTwo() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_1, LocalDate.now().minusDays(2)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterMinTwo() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_1, LocalDate.now().minusDays(2)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale2MinTwo() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_2, LocalDate.now().minusDays(2)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale2MinTwo() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_2, LocalDate.now().minusDays(2)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale3MinTwo() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_3, LocalDate.now().minusDays(2)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale3MinTwo() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_3, LocalDate.now().minusDays(2)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale4MinTwo() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_4, LocalDate.now().minusDays(2)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale4MinTwo() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_4, LocalDate.now().minusDays(2)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale1MinThree() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_1, LocalDate.now().minusDays(3)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterMinThree() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_1, LocalDate.now().minusDays(3)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale2MinThree() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_2, LocalDate.now().minusDays(3)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale2MinThree() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_2, LocalDate.now().minusDays(3)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale3MinThree() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_3, LocalDate.now().minusDays(3)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale3MinThree() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_3, LocalDate.now().minusDays(3)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale4MinThree() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_4, LocalDate.now().minusDays(3)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale4MinThree() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_4, LocalDate.now().minusDays(3)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale1MinFourth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_1, LocalDate.now().minusDays(4)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterMinFourth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_1, LocalDate.now().minusDays(4)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale2MinFourth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_2, LocalDate.now().minusDays(4)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale2MinFourth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_2, LocalDate.now().minusDays(4)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale3MinFourth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_3, LocalDate.now().minusDays(4)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale3MinFourth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_3, LocalDate.now().minusDays(4)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale4MinFourth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_4, LocalDate.now().minusDays(4)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale4MinFourth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_4, LocalDate.now().minusDays(4)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale1MinFifth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_1, LocalDate.now().minusDays(5)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterMinFifth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_1, LocalDate.now().minusDays(5)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale2MinFifth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_2, LocalDate.now().minusDays(5)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale2MinFifth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_2, LocalDate.now().minusDays(5)).getKilogramOfFodder();
    }

    @Override
    public Long findLastRecordsByCategoryHale3MinFifth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_3, LocalDate.now().minusDays(5)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale3MinFifth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_3, LocalDate.now().minusDays(5)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale4MinFifth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_4, LocalDate.now().minusDays(5)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale4MinFifth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_4, LocalDate.now().minusDays(5)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale1MinSix() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_1, LocalDate.now().minusDays(6)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterMinSix() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_1, LocalDate.now().minusDays(6)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale2MinSix() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_2, LocalDate.now().minusDays(6)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale2MinSix() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_2, LocalDate.now().minusDays(6)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale3MinSix() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_3, LocalDate.now().minusDays(6)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale3MinSix() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_3, LocalDate.now().minusDays(6)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale4MinSix() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_4, LocalDate.now().minusDays(6)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale4MinSix() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_4, LocalDate.now().minusDays(6)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale5() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_5, LocalDate.now()).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale5() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_5, LocalDate.now()).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale6() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_6, LocalDate.now()).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale6() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_6, LocalDate.now()).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale7() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_7, LocalDate.now()).getLitreOfWater();
    }

    @Override
    public Long getLitreOfWaterHale7() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_7, LocalDate.now()).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale8() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_8, LocalDate.now()).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale8() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_8, LocalDate.now()).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale9() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_9, LocalDate.now()).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale9() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_9, LocalDate.now()).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale5MinOne() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_5, LocalDate.now().minusDays(1)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale5MinOne() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_5, LocalDate.now().minusDays(1)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale6MinOne() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_6, LocalDate.now().minusDays(1)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale6MinOne() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_6, LocalDate.now().minusDays(1)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale7MinOne() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(1)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale7MinOne() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(1)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale8MinOne() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_8, LocalDate.now().minusDays(1)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale8MinOne() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_8, LocalDate.now().minusDays(1)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale9MinOne() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_9, LocalDate.now().minusDays(1)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale9MinOne() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_9, LocalDate.now().minusDays(1)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale5MinTwo() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_5, LocalDate.now().minusDays(2)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale5MinTwo() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_5, LocalDate.now().minusDays(2)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale6MinTwo() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_6, LocalDate.now().minusDays(2)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale6MinTwo() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_6, LocalDate.now().minusDays(2)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale7MinTwo() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(2)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale7MinTwo() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(2)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale8MinTwo() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_8, LocalDate.now().minusDays(2)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale8MinTwo() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_8, LocalDate.now().minusDays(2)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale9MinTwo() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_9, LocalDate.now().minusDays(2)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale9MinTwo() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_9, LocalDate.now().minusDays(2)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale5MinThree() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_5, LocalDate.now().minusDays(3)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale5MinThree() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_5, LocalDate.now().minusDays(3)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale6MinThree() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_6, LocalDate.now().minusDays(3)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale6MinThree() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_6, LocalDate.now().minusDays(3)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale7MinThree() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(3)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale7MinThree() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(3)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale8MinThree() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_8, LocalDate.now().minusDays(3)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale8MinThree() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_8, LocalDate.now().minusDays(3)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale9MinThree() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_9, LocalDate.now().minusDays(3)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale9MinThree() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_9, LocalDate.now().minusDays(3)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale5MinFourth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_5, LocalDate.now().minusDays(4)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale5MinFourth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_5, LocalDate.now().minusDays(4)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale6MinFourth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_6, LocalDate.now().minusDays(4)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale6MinFourth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_6, LocalDate.now().minusDays(4)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale7MinFourth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(4)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale7MinFourth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(4)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale8MinFourth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_8, LocalDate.now().minusDays(4)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale8MinFourth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_8, LocalDate.now().minusDays(4)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale9MinFourth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_9, LocalDate.now().minusDays(4)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale9MinFourth() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_9, LocalDate.now().minusDays(4)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale5MinFive() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_5, LocalDate.now().minusDays(5)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale5MinFive() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_5, LocalDate.now().minusDays(5)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale6MinFive() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_6, LocalDate.now().minusDays(5)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale6MinFive() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_6, LocalDate.now().minusDays(5)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale7MinFive() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(5)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale7MinFive() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(5)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale8MinFive() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_8, LocalDate.now().minusDays(5)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale8MinFive() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_8, LocalDate.now().minusDays(5)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale9MinFive() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_9, LocalDate.now().minusDays(5)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale9MinFive() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_9, LocalDate.now().minusDays(5)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale5MinSix() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_5, LocalDate.now().minusDays(6)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale5MinSix() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_5, LocalDate.now().minusDays(6)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale6MinSix() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_6, LocalDate.now().minusDays(6)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale6MinSix() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_6, LocalDate.now().minusDays(6)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale7MinSix() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(6)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale7MinSix() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(6)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale8MinSix() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_8, LocalDate.now().minusDays(6)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale8MinSix() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_8, LocalDate.now().minusDays(6)).getLitreOfWater();
    }

    @Override
    public Long findLastRecordsByCategoryHale9MinSix() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum.SILO_9, LocalDate.now().minusDays(6)).getKilogramOfFodder();
    }

    @Override
    public Long getLitreOfWaterHale9MinSix() {
        return eatenFodderAndWaterRepository.getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum.SILO_9, LocalDate.now().minusDays(6)).getLitreOfWater();
    }

}
