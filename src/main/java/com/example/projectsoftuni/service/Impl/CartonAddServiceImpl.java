package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.Cartons;
import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.service.CartonServiceModel;
import com.example.projectsoftuni.repository.CartonAddRepository;
import com.example.projectsoftuni.service.CartonAddService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class CartonAddServiceImpl implements CartonAddService {

    private final ModelMapper modelMapper;
    private final CartonAddRepository cartonAddRepository;

    public CartonAddServiceImpl(ModelMapper modelMapper, CartonAddRepository cartonAddRepository) {
        this.modelMapper = modelMapper;
        this.cartonAddRepository = cartonAddRepository;
    }

    @Override
    public void addCarton(CartonServiceModel cartonServiceModel) {
        Cartons cartons = modelMapper.map(cartonServiceModel, Cartons.class);
        cartons.setCartons(cartonServiceModel.getCartons().getCartons());
        cartons.setBase(cartonServiceModel.getBase());

        cartonAddRepository.save(cartons);
    }

    @Override
    public Long getCountOfCore120FromBaseUpper() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_20)
                .stream().map(Cartons::getCount).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfCarton120FromBaseUpper() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.UPPER, CategoryCartonsEnum.CARTONS_120)
                .stream().map(Cartons::getCount).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfCarton180FromBaseUpper() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.UPPER, CategoryCartonsEnum.CARTONS_180)
                .stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountOfCore180FromBaseUpper() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_30)
                .stream().map(Cartons::getCount).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfCore120FromBaseLower() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_20)
                .stream().map(Cartons::getCount).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfCarton120FromBaseLower() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.LOWER, CategoryCartonsEnum.CARTONS_120)
                .stream().map(Cartons::getCount).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfCarton180FromBaseLower() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.LOWER, CategoryCartonsEnum.CARTONS_180)
                .stream().map(Cartons::getCount).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfCore180FromBaseLower() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_30)
                .stream().map(Cartons::getCount).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfCore120FromBaseLowerLast() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_20)
                .stream().map(Cartons::getCount).reduce(Long::min).orElse(0L);
    }

    //За Scheduling
    @Override
    public void deleteTopCartonsByCartonsCategory() {
        Cartons cartons = cartonAddRepository.findTopByBaseAndCartons(CategoryBaseEnum.LOWER, CategoryCartonsEnum.CARTONS_120).get(0);
        cartonAddRepository.delete(cartons);
    }


}
