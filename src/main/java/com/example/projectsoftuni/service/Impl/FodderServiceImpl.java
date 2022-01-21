package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.EatenFodderAndWater;
import com.example.projectsoftuni.model.entity.Fodder;
import com.example.projectsoftuni.model.entity.enums.CategorySiloEnum;
import com.example.projectsoftuni.model.service.EatenFodderAndWaterServiceModel;
import com.example.projectsoftuni.model.service.FodderServiceModel;
import com.example.projectsoftuni.repository.FodderRepository;
import com.example.projectsoftuni.service.EatenFodderAndWaterService;
import com.example.projectsoftuni.service.FodderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FodderServiceImpl implements FodderService {

    private final FodderRepository fodderRepository;
    private final ModelMapper modelMapper;
    private final FodderServiceModel fodderServiceModel;

    public FodderServiceImpl(FodderRepository fodderRepository, ModelMapper modelMapper, FodderServiceModel fodderServiceModel) {
        this.fodderRepository = fodderRepository;
        this.modelMapper = modelMapper;
        this.fodderServiceModel = fodderServiceModel;
    }

    @Override
    public void add(FodderServiceModel fodderServiceModel) {
        Fodder fodder = modelMapper.map(fodderServiceModel, Fodder.class);
        fodder.setSiloEnum(fodderServiceModel.getSiloEnum());
        fodder.setSupplierEnum(fodderServiceModel.getSupplierEnum());
        fodder.setKilogramOfFodder(fodderServiceModel.getKilogramOfFodder());
        fodder.setAcceptedTime(fodderServiceModel.getAcceptedTime());

        fodderRepository.save(fodder);
    }
    //До 62 ред за текущия ден
    @Override
    public Long getKgOfFodder() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_1, LocalDate.now()).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo2() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_2, LocalDate.now()).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo3() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_3, LocalDate.now()).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo4() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_4, LocalDate.now()).getKilogramOfFodder();
    }
    // за текущия ден -1 ден
    @Override
    public Long getKgOfFodderMinOne() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_1, LocalDate.now().minusDays(1)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo2MinOne() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_2, LocalDate.now().minusDays(1)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo3MinOne() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_3, LocalDate.now().minusDays(1)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo4MinOne() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_4, LocalDate.now().minusDays(1)).getKilogramOfFodder();
    }
    //До 110 ред за текущия ден -2 ден
    @Override
    public Long getKgOfFodderMinTwo() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_1, LocalDate.now().minusDays(2)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo2MinTwo() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_2, LocalDate.now().minusDays(2)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo3MinTwo() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_3, LocalDate.now().minusDays(2)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo4MinTwo() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_4, LocalDate.now().minusDays(2)).getKilogramOfFodder();
    }
    //До 134 ред за текущия ден -3 дена
    @Override
    public Long getKgOfFodderMinThree() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_1, LocalDate.now().minusDays(3)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo2MinThree() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_2, LocalDate.now().minusDays(3)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo3MinThree() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_3, LocalDate.now().minusDays(3)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo4MinThree() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_4, LocalDate.now().minusDays(3)).getKilogramOfFodder();
    }
    //До 158 ред за текущия ден -4 дена
    @Override
    public Long getKgOfFodderMinFourth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_1, LocalDate.now().minusDays(4)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo2MinFourth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_2, LocalDate.now().minusDays(4)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo3MinFourth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_3, LocalDate.now().minusDays(4)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo4MinFourth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_4, LocalDate.now().minusDays(4)).getKilogramOfFodder();
    }
    //До 182 ред за текущия ден -5 дена
    @Override
    public Long getKgOfFodderMinFifth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_1, LocalDate.now().minusDays(5)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo2MinFifth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_2, LocalDate.now().minusDays(5)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo3MinFifth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_3, LocalDate.now().minusDays(5)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo4MinFifth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_4, LocalDate.now().minusDays(5)).getKilogramOfFodder();
    }
    //До  ред за текущия ден -5 дена
    @Override
    public Long getKgOfFodderMinSix() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_1, LocalDate.now().minusDays(6)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo2MinSix() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_2, LocalDate.now().minusDays(6)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo3MinSix() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_3, LocalDate.now().minusDays(6)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo4MinSix() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_4, LocalDate.now().minusDays(6)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderHale5() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_5, LocalDate.now()).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo6() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_6, LocalDate.now()).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo7() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_7, LocalDate.now()).getKilogramOfFodder();

    }

    @Override
    public Long getKgOfFodderSilo8() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_8, LocalDate.now()).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo9() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_9, LocalDate.now()).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderHale5MinOne() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_5, LocalDate.now().minusDays(1)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo6MinOne() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_6, LocalDate.now().minusDays(1)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo7MinOne() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(1)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo8MinOne() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_8, LocalDate.now().minusDays(1)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo9MinOne() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_9, LocalDate.now().minusDays(1)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderHale5MinTwo() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_5, LocalDate.now().minusDays(2)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo6MinTwo() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_6, LocalDate.now().minusDays(2)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo7MinTwo() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(2)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo8MinTwo() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_8, LocalDate.now().minusDays(2)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo9MinTwo() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_9, LocalDate.now().minusDays(2)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderHale5MinThree() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_5, LocalDate.now().minusDays(3)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo6MinThree() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_6, LocalDate.now().minusDays(3)).getKilogramOfFodder();

    }

    @Override
    public Long getKgOfFodderSilo7MinThree() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(3)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo8MinThree() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_8, LocalDate.now().minusDays(3)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo9MinThree() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_9, LocalDate.now().minusDays(3)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderHale5MinFourth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_5, LocalDate.now().minusDays(4)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo6MinFourth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_6, LocalDate.now().minusDays(4)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo7MinFourth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(4)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo8MinFourth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_8, LocalDate.now().minusDays(4)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo9MinFourth() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_9, LocalDate.now().minusDays(4)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderHale5MinFive() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_5, LocalDate.now().minusDays(5)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo6MinFive() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_6, LocalDate.now().minusDays(5)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo7MinFive() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(5)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo8MinFive() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_8, LocalDate.now().minusDays(5)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo9MinFive() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_9, LocalDate.now().minusDays(5)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderHale5MinSix() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_5, LocalDate.now().minusDays(6)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo6MinSix() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_6, LocalDate.now().minusDays(6)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo7MinSix() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(7)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo8MinSix() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_7, LocalDate.now().minusDays(6)).getKilogramOfFodder();
    }

    @Override
    public Long getKgOfFodderSilo9MinSix() {
        return fodderRepository.
                getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum.SILO_9, LocalDate.now().minusDays(6)).getKilogramOfFodder();
    }
}
