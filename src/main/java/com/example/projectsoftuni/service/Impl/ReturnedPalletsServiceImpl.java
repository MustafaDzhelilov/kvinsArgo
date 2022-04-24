package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.Pallets;
import com.example.projectsoftuni.model.entity.ReturnedPallets;
import com.example.projectsoftuni.model.entity.enums.ClientEnum;
import com.example.projectsoftuni.model.entity.enums.PalletTypeEnum;
import com.example.projectsoftuni.model.service.PalletsServiceModel;
import com.example.projectsoftuni.model.service.ReturnedPalletsServiceModel;
import com.example.projectsoftuni.repository.PalletsRepository;
import com.example.projectsoftuni.repository.ReturnedPalletsRepository;
import com.example.projectsoftuni.service.ReturnedPalletsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ReturnedPalletsServiceImpl implements ReturnedPalletsService {

    private ReturnedPalletsRepository returnedPalletsRepository;
    private ReturnedPalletsServiceModel returnedPalletsServiceModel;
    private PalletsServiceModel palletsServiceModel;
    private PalletsRepository palletsRepository;
    private ModelMapper modelMapper;

    public ReturnedPalletsServiceImpl(ReturnedPalletsRepository returnedPalletsRepository, ReturnedPalletsServiceModel returnedPalletsServiceModel, PalletsServiceModel palletsServiceModel, PalletsRepository palletsRepository, ModelMapper modelMapper) {
        this.returnedPalletsRepository = returnedPalletsRepository;
        this.returnedPalletsServiceModel = returnedPalletsServiceModel;
        this.palletsServiceModel = palletsServiceModel;
        this.palletsRepository = palletsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void returnPallets(ReturnedPalletsServiceModel returnedPalletsServiceModel) {
        ReturnedPallets returnedPallets = modelMapper.map(returnedPalletsServiceModel, ReturnedPallets.class);
        returnedPallets.setClientEnum(returnedPalletsServiceModel.getClientEnum());
        returnedPallets.setCategoryBaseEnum(returnedPalletsServiceModel.getCategoryBaseEnum());
        returnedPallets.setPalletTypeEnum(returnedPalletsServiceModel.getPalletTypeEnum());
        returnedPallets.setCountReturned(returnedPalletsServiceModel.getCountReturned());
        returnedPallets.setReturnedDate(returnedPalletsServiceModel.getReturnedDate());

        Pallets pallets = modelMapper.map(palletsServiceModel, Pallets.class);
        pallets.setCategoryBaseEnum(returnedPalletsServiceModel.getCategoryBaseEnum());
        pallets.setPalletTypeEnum(returnedPalletsServiceModel.getPalletTypeEnum());
        pallets.setCount(returnedPalletsServiceModel.getCountReturned());
        pallets.setLocalDate(returnedPalletsServiceModel.getReturnedDate());


        returnedPalletsRepository.save(returnedPallets);
        palletsRepository.save(pallets);
    }


    @Override
    public Long getReturnedEuroByClient(ClientEnum client, PalletTypeEnum euro) {
        return returnedPalletsRepository.getReturnedPalletsByClientEnumAndPalletTypeEnum(client,euro).
                stream().map(ReturnedPallets::getCountReturned).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getReturnedPallThermoByClient(ClientEnum client, PalletTypeEnum thermo) {
        return returnedPalletsRepository.getReturnedPalletsByClientEnumAndPalletTypeEnum(client, thermo).
                stream().map(ReturnedPallets::getCountReturned).reduce(Long::sum).orElse(0L);
    }

}
