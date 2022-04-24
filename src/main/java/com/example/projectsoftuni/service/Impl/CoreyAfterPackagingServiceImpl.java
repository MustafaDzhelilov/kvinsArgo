package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.Cartons;
import com.example.projectsoftuni.model.entity.CoreyFreeAfterPackaging;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.service.CartonServiceModel;
import com.example.projectsoftuni.model.service.CoreyFreeAfterPackagingServiceModel;
import com.example.projectsoftuni.repository.CartonAddRepository;
import com.example.projectsoftuni.repository.CoreyAfterPackagingRepository;
import com.example.projectsoftuni.service.CoreyAfterPackagingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CoreyAfterPackagingServiceImpl implements CoreyAfterPackagingService {

    private final ModelMapper modelMapper;
    private final CoreyAfterPackagingRepository coreyAfterPackagingRepository;
    private final CartonServiceModel cartonServiceModel;
    private final CartonAddRepository cartonAddRepository;
    private final CoreyFreeAfterPackagingServiceModel coreyFreeAfterPackagingServiceModel;

    public CoreyAfterPackagingServiceImpl(ModelMapper modelMapper, CoreyAfterPackagingRepository coreyAfterPackagingRepository, CartonServiceModel cartonServiceModel, CartonAddRepository cartonAddRepository, CoreyFreeAfterPackagingServiceModel coreyFreeAfterPackagingServiceModel) {
        this.modelMapper = modelMapper;
        this.coreyAfterPackagingRepository = coreyAfterPackagingRepository;
        this.cartonServiceModel = cartonServiceModel;
        this.cartonAddRepository = cartonAddRepository;
        this.coreyFreeAfterPackagingServiceModel = coreyFreeAfterPackagingServiceModel;
    }

    @Override
    public void transferCartonToBase(CoreyFreeAfterPackagingServiceModel coreyFreeAfterPackagingServiceModel) {
        CoreyFreeAfterPackaging coreyFreeAfterPackaging = modelMapper.map(coreyFreeAfterPackagingServiceModel, CoreyFreeAfterPackaging.class);
        coreyFreeAfterPackaging.setCartons(coreyFreeAfterPackagingServiceModel.getCartons());
        coreyFreeAfterPackaging.setCount(-coreyFreeAfterPackagingServiceModel.getCount());

        Cartons cartons = modelMapper.map(cartonServiceModel, Cartons.class);
        cartons.setBase(coreyFreeAfterPackagingServiceModel.getCategoryBaseEnum());
        cartons.setCartons(coreyFreeAfterPackagingServiceModel.getCartons());
        cartons.setCount(coreyFreeAfterPackagingServiceModel.getCount());
        cartons.setDate(LocalDateTime.now());


        coreyAfterPackagingRepository.save(coreyFreeAfterPackaging);
        cartonAddRepository.save(cartons);
    }

    @Override
    public List<CoreyFreeAfterPackaging> getAllCartons() {

        return coreyAfterPackagingRepository.findAll();
    }

    @Override
    public Long getCartonsCountToTransfer(CategoryCartonsEnum categoryCartonsEnum) {
        return coreyAfterPackagingRepository
                .findAllByCartons(coreyFreeAfterPackagingServiceModel.getCartons())
                .stream()
                .map(CoreyFreeAfterPackaging::getCount)
                .reduce(Long::sum)
                .orElse(0L);
    }

    @Override
    public Long getCount(CoreyFreeAfterPackagingServiceModel coreyFreeAfterPackagingServiceModel) {
        return coreyAfterPackagingRepository
                .findAllByCartons(coreyFreeAfterPackagingServiceModel.getCartons())
                .stream()
                .map(CoreyFreeAfterPackaging::getCount)
                .reduce(Long::sum)
                .orElse(0L);
    }

}
