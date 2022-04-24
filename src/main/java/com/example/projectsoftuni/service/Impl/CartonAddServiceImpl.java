package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.Cartons;
import com.example.projectsoftuni.model.entity.MaterialOnBase;
import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.MaterialEnum;
import com.example.projectsoftuni.model.service.CartonServiceModel;
import com.example.projectsoftuni.model.service.SearchFromToCartonServiceModel;
import com.example.projectsoftuni.model.service.TransferCartonBetweenBaseServiceModel;
import com.example.projectsoftuni.repository.CartonAddRepository;
import com.example.projectsoftuni.service.CartonAddService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class CartonAddServiceImpl implements CartonAddService {

    private final ModelMapper modelMapper;
    private final CartonAddRepository cartonAddRepository;
    private final CartonServiceModel cartonServiceModel;

    public CartonAddServiceImpl(ModelMapper modelMapper, CartonAddRepository cartonAddRepository, CartonServiceModel cartonServiceModel) {
        this.modelMapper = modelMapper;
        this.cartonAddRepository = cartonAddRepository;
        this.cartonServiceModel = cartonServiceModel;
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
                .stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountOfCarton120FromBaseUpper() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.UPPER, CategoryCartonsEnum.CARTONS_120)
                .stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountOfCarton180FromBaseUpper() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.UPPER, CategoryCartonsEnum.CARTONS_180_WHITE)
                .stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }


    @Override
    public Long getCountOfCore120FromBaseLower() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_20)
                .stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountOfCarton120FromBaseLower() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.LOWER, CategoryCartonsEnum.CARTONS_120)
                .stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountOfCarton180FromBaseLower() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.LOWER, CategoryCartonsEnum.CARTONS_180_WHITE)
                .stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
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

    @Override
    public Long getCountOfCarton180FromBaseLowerBrown() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.LOWER, CategoryCartonsEnum.CARTONS_180_BROWN).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountOfCarton360FromBaseLowerBrown() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.LOWER, CategoryCartonsEnum.CARTONS_360_BROWN).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountOfCarton180FromBaseUpperBrown() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.UPPER, CategoryCartonsEnum.CARTONS_180_BROWN).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountOfCarton360FromBaseUpperBrown() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.UPPER, CategoryCartonsEnum.CARTONS_360_BROWN).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountCoreyFamilyLower() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.LOWER,CategoryCartonsEnum.COREY_30_FAMILY).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountCoreyChezLower() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.LOWER,CategoryCartonsEnum.COREY_30_CHEZ).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountCoreyEuroLower() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.LOWER,CategoryCartonsEnum.COREY_30_EURO).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountCoreyHartmanLower() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.LOWER,CategoryCartonsEnum.COREY_30_HARTMAN).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountCoreyHartmanUpper() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.UPPER,CategoryCartonsEnum.COREY_30_HARTMAN).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountCoreyEuroUpper() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.UPPER,CategoryCartonsEnum.COREY_30_EURO).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountCoreyChezUpper() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.UPPER,CategoryCartonsEnum.COREY_30_CHEZ).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountCoreyFamilyUpper() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.UPPER,CategoryCartonsEnum.COREY_30_FAMILY).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountPaperDunapackUpper() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.UPPER,CategoryCartonsEnum.PAPER_SHEET_DUN).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountPaperDSmitkUpper() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.UPPER,CategoryCartonsEnum.PAPER_SHEET_DSM).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountCornerDunapackUpper() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.UPPER,CategoryCartonsEnum.PAPER_CORNER_DUN).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountCornerDSmitkUpper() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.UPPER,CategoryCartonsEnum.PAPER_CORNER_DSM).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountPaperDunapackLower() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.LOWER,CategoryCartonsEnum.PAPER_SHEET_DUN).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountPaperDSmitkLower() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.LOWER,CategoryCartonsEnum.PAPER_SHEET_DSM).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountCornerDunapackLower() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.LOWER,CategoryCartonsEnum.PAPER_CORNER_DUN).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountCornerDSmitkLower() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.LOWER,CategoryCartonsEnum.PAPER_CORNER_DSM).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountCartons(CategoryCartonsEnum cartons, CategoryBaseEnum categoryBaseEnum) {
        return cartonAddRepository.findAllByBaseAndCartons(categoryBaseEnum, cartons).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountCorner(CategoryCartonsEnum cartons, CategoryBaseEnum categoryBaseEnum) {
        return cartonAddRepository.findAllByBaseAndCartons(categoryBaseEnum, cartons).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountPaper(CategoryCartonsEnum cartons, CategoryBaseEnum categoryBaseEnum) {
        return cartonAddRepository.findAllByBaseAndCartons(categoryBaseEnum, cartons).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public void transferCarton(TransferCartonBetweenBaseServiceModel transferCartonBetweenBaseServiceModel) {
        Cartons cartons = modelMapper.map(cartonServiceModel, Cartons.class);
        cartons.setBase(transferCartonBetweenBaseServiceModel.getFromBase());
        cartons.setCartons(transferCartonBetweenBaseServiceModel.getCategoryCartonsEnum());
        cartons.setCount(-transferCartonBetweenBaseServiceModel.getCount());
        cartons.setDate(LocalDateTime.now());

        Cartons cartons1 = modelMapper.map(cartonServiceModel, Cartons.class);
        cartons1.setBase(transferCartonBetweenBaseServiceModel.getToBase());
        cartons1.setCartons(transferCartonBetweenBaseServiceModel.getCategoryCartonsEnum());
        cartons1.setCount(transferCartonBetweenBaseServiceModel.getCount());
        cartons1.setDate(LocalDateTime.now());

        cartonAddRepository.save(cartons);
        cartonAddRepository.save(cartons1);
    }

    @Override
    public Long getCountCoreyUkraynaLower() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_UKRAYNA).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountCoreyElpaLower() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_ELPA).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountCoreyEkoFarmLower() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_EKO_FARM).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountCoreyNew1Lower() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_NEW1).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountCoreyNew2Lower() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.LOWER, CategoryCartonsEnum.COREY_NEW2).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountCoreyUkraynaUpper() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_UKRAYNA).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountCoreyElpaUpper() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_ELPA).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountCoreyEkoFarmUpper() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_EKO_FARM).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountCoreyNew1Upper() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_NEW1).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountCoreyNew2Upper() {
        return cartonAddRepository.findAllByBaseAndCartons(CategoryBaseEnum.UPPER, CategoryCartonsEnum.COREY_NEW2).
                stream().map(Cartons::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public List<Cartons> viewIssuedCarton(SearchFromToCartonServiceModel searchFromToCartonServiceModel) {

        List<Cartons> allS = new ArrayList<>();
        List<Cartons> allMaterial =
                cartonAddRepository.findCartonsByDateBetween(searchFromToCartonServiceModel.getStart().atStartOfDay(),
                        searchFromToCartonServiceModel.getEnd().atStartOfDay().plusHours(24));

        Long sum ;
        for (CategoryCartonsEnum carton: CategoryCartonsEnum.values()) {
            sum = 0L;
            for (int i = 0; i <= allMaterial.size() -1; i++) {

                if(allMaterial.get(i).getCartons().name().equals(carton.name())
                        && allMaterial.get(i).getCount() < 0){
                    sum += allMaterial.get(i).getCount() * -1;
                }
            }
            Cartons cartons = modelMapper.map(cartonServiceModel, Cartons.class);
            cartons.setDate(LocalDateTime.now());
            cartons.setCartons(carton);
            cartons.setBase(CategoryBaseEnum.UPPER);
            cartons.setCount(sum);
            allS.add(cartons);
        }

        return allS;
    }


}
