package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.ReturnedPallets;
import com.example.projectsoftuni.model.entity.enums.ClientEnum;
import com.example.projectsoftuni.model.entity.enums.PalletTypeEnum;
import com.example.projectsoftuni.model.service.ReturnedPalletsServiceModel;
import com.example.projectsoftuni.repository.ReturnedPalletsRepository;
import com.example.projectsoftuni.service.ReturnedPalletsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ReturnedPalletsServiceImpl implements ReturnedPalletsService {

    private ReturnedPalletsRepository returnedPalletsRepository;
    private ReturnedPalletsServiceModel returnedPalletsServiceModel;
    private ModelMapper modelMapper;

    public ReturnedPalletsServiceImpl(ReturnedPalletsRepository returnedPalletsRepository, ReturnedPalletsServiceModel returnedPalletsServiceModel, ModelMapper modelMapper) {
        this.returnedPalletsRepository = returnedPalletsRepository;
        this.returnedPalletsServiceModel = returnedPalletsServiceModel;
        this.modelMapper = modelMapper;
    }

    @Override
    public void returnPallets(ReturnedPalletsServiceModel returnedPalletsServiceModel) {
        ReturnedPallets returnedPallets = modelMapper.map(returnedPalletsServiceModel, ReturnedPallets.class);
        returnedPallets.setClientEnum(returnedPalletsServiceModel.getClientEnum());
        returnedPallets.setPalletTypeEnum(returnedPalletsServiceModel.getPalletTypeEnum());
        returnedPallets.setCountReturned(returnedPalletsServiceModel.getCountReturned());
        returnedPallets.setReturnedDate(returnedPalletsServiceModel.getReturnedDate());

        returnedPalletsRepository.save(returnedPallets);
    }

    @Override
    public Long getReturnedPallCount() {
        return returnedPalletsRepository.getReturnedPalletsByClientEnumAndPalletTypeEnum(ClientEnum.AKVILOD_OOD, PalletTypeEnum.EURO).
                stream().map(ReturnedPallets::getCountReturned).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getReturnedPallCountT() {
        return returnedPalletsRepository.getReturnedPalletsByClientEnumAndPalletTypeEnum(ClientEnum.ET_ZORNICA_TEODOR_BONCHEV, PalletTypeEnum.EURO).
                stream().map(ReturnedPallets::getCountReturned).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getReturnedPallCountAkvTermo() {
        return returnedPalletsRepository.getReturnedPalletsByClientEnumAndPalletTypeEnum(ClientEnum.AKVILOD_OOD, PalletTypeEnum.THERMO).
                stream().map(ReturnedPallets::getCountReturned).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getReturnedPallCountTTermo() {
        return returnedPalletsRepository.getReturnedPalletsByClientEnumAndPalletTypeEnum(ClientEnum.ET_ZORNICA_TEODOR_BONCHEV, PalletTypeEnum.THERMO).
                stream().map(ReturnedPallets::getCountReturned).reduce(Long::sum).orElse(0L);
    }
}
