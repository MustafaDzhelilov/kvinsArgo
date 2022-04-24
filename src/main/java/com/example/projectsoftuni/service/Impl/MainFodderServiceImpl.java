package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.MainFodder;
import com.example.projectsoftuni.model.service.MainFodderServiceModel;
import com.example.projectsoftuni.repository.MainFodderRepository;
import com.example.projectsoftuni.service.MainFodderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MainFodderServiceImpl implements MainFodderService {
    private final ModelMapper modelMapper;
    private final MainFodderServiceModel mainFodderServiceModel;
    private final MainFodderRepository mainFodderRepository;

    public MainFodderServiceImpl(ModelMapper modelMapper, MainFodderServiceModel mainFodderServiceModel, MainFodderRepository mainFodderRepository) {
        this.modelMapper = modelMapper;
        this.mainFodderServiceModel = mainFodderServiceModel;
        this.mainFodderRepository = mainFodderRepository;
    }

    @Override
    public void add(MainFodderServiceModel mainFodderServiceModel) {
        MainFodder mainFodder = modelMapper.map(mainFodderServiceModel, MainFodder.class);
        mainFodder.setSupplierEnum(mainFodderServiceModel.getSupplierEnum());
        mainFodder.setKilogramOfFodder(mainFodderServiceModel.getKilogramOfFodder());
        mainFodder.setAcceptedTime(mainFodderServiceModel.getAcceptedTime());

        mainFodderRepository.save(mainFodder);
    }

    @Override
    public Long getKg() {
        return mainFodderRepository.findAll()
                .stream().map(MainFodder::getKilogramOfFodder).reduce(Long::sum).orElse(0L);
    }
}
