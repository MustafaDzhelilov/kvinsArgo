package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.Pallets;
import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.PalletTypeEnum;
import com.example.projectsoftuni.model.service.PalletsServiceModel;
import com.example.projectsoftuni.model.service.TransferPalletsBetweenBaseServiceModel;
import com.example.projectsoftuni.repository.PalletsRepository;
import com.example.projectsoftuni.service.PalletsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PalletsServiceImpl implements PalletsService {

    private final ModelMapper modelMapper;
    private final PalletsRepository palletsRepository;
    private final PalletsServiceModel palletsServiceModel;

    public PalletsServiceImpl(ModelMapper modelMapper, PalletsRepository palletsRepository, PalletsServiceModel palletsServiceModel) {
        this.modelMapper = modelMapper;
        this.palletsRepository = palletsRepository;
        this.palletsServiceModel = palletsServiceModel;
    }

    @Override
    public void add(PalletsServiceModel palletsServiceModel) {
        Pallets pallets = modelMapper.map(palletsServiceModel, Pallets.class);
        pallets.setCategoryBaseEnum(palletsServiceModel.getCategoryBaseEnum());
        pallets.setPalletTypeEnum(palletsServiceModel.getPalletTypeEnum());
        pallets.setCount(palletsServiceModel.getCount());
        pallets.setLocalDate(LocalDate.now());

        palletsRepository.save(pallets);
    }

    @Override
    public void transfer(TransferPalletsBetweenBaseServiceModel transferPalletsBetweenBaseServiceModel) {
        Pallets pallets = modelMapper.map(palletsServiceModel, Pallets.class);
        pallets.setCategoryBaseEnum(transferPalletsBetweenBaseServiceModel.getFrom());
        pallets.setPalletTypeEnum(transferPalletsBetweenBaseServiceModel.getPalletTypeEnum());
        pallets.setCount(-transferPalletsBetweenBaseServiceModel.getCount());
        pallets.setLocalDate(transferPalletsBetweenBaseServiceModel.getDate());

        Pallets pallets1 = modelMapper.map(palletsServiceModel, Pallets.class);
        pallets1.setCategoryBaseEnum(transferPalletsBetweenBaseServiceModel.getTo());
        pallets1.setPalletTypeEnum(transferPalletsBetweenBaseServiceModel.getPalletTypeEnum());
        pallets1.setLocalDate(transferPalletsBetweenBaseServiceModel.getDate());
        pallets1.setCount(transferPalletsBetweenBaseServiceModel.getCount());

        palletsRepository.save(pallets);
        palletsRepository.save(pallets1);
    }

    @Override
    public Long getCOuntEuroLower() {
        return palletsRepository.getPalletsByCategoryBaseEnumAndPalletTypeEnum(CategoryBaseEnum.LOWER, PalletTypeEnum.EURO).
                stream().map(Pallets::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountThermoLower() {
        return palletsRepository.getPalletsByCategoryBaseEnumAndPalletTypeEnum(CategoryBaseEnum.LOWER, PalletTypeEnum.THERMO).
                stream().map(Pallets::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountEuroUpper() {
        return palletsRepository.getPalletsByCategoryBaseEnumAndPalletTypeEnum(CategoryBaseEnum.UPPER, PalletTypeEnum.EURO).
                stream().map(Pallets::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountThermoUpper() {
        return palletsRepository.getPalletsByCategoryBaseEnumAndPalletTypeEnum(CategoryBaseEnum.UPPER, PalletTypeEnum.THERMO).
                stream().map(Pallets::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountEuroPackaging() {
        return palletsRepository.getPalletsByCategoryBaseEnumAndPalletTypeEnum(CategoryBaseEnum.PACKAGING, PalletTypeEnum.EURO).
                stream().map(Pallets::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountThermoPackaging() {
        return palletsRepository.getPalletsByCategoryBaseEnumAndPalletTypeEnum(CategoryBaseEnum.PACKAGING, PalletTypeEnum.THERMO).
                stream().map(Pallets::getCount).reduce(Long::sum).orElse(0L);
    }
}
