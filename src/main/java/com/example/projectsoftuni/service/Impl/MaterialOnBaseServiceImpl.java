package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.Material;
import com.example.projectsoftuni.model.entity.MaterialOnBase;
import com.example.projectsoftuni.model.entity.Sells;
import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.MaterialEnum;
import com.example.projectsoftuni.model.service.MaterialOnBaseServiceModel;
import com.example.projectsoftuni.model.service.SearchFromToMaterialServiceModel;
import com.example.projectsoftuni.model.service.SubtractionMaterialFromBasesServiceModel;
import com.example.projectsoftuni.repository.MaterialOnBaseRepository;
import com.example.projectsoftuni.repository.MaterialRepository;
import com.example.projectsoftuni.service.MaterialOnBaseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialOnBaseServiceImpl implements MaterialOnBaseService {

    private final ModelMapper modelMapper;
    private final MaterialOnBaseRepository materialOnBaseRepository;
    private final MaterialRepository materialRepository;
    private final MaterialOnBaseServiceModel materialOnBaseServiceModel;

    public MaterialOnBaseServiceImpl(ModelMapper modelMapper, MaterialOnBaseRepository materialOnBaseRepository, MaterialRepository materialRepository, MaterialOnBaseServiceModel materialOnBaseServiceModel) {
        this.modelMapper = modelMapper;
        this.materialOnBaseRepository = materialOnBaseRepository;
        this.materialRepository = materialRepository;
        this.materialOnBaseServiceModel = materialOnBaseServiceModel;
    }

    @Override
    public void addMaterialOnBase(MaterialOnBaseServiceModel materialOnBaseServiceModel) {
        MaterialOnBase materialOnBase = modelMapper.map(materialOnBaseServiceModel, MaterialOnBase.class);
        materialOnBase.setMaterialEnum(materialOnBaseServiceModel.getMaterialEnum());
        materialOnBase.setCategoryBaseEnum(materialOnBaseServiceModel.getCategoryBaseEnum());
        materialOnBase.setMaterialCount(materialOnBaseServiceModel.getMaterialCount());
        materialOnBase.setAddDate(materialOnBaseServiceModel.getAddDate());

        Material material = modelMapper.map(materialOnBaseServiceModel, Material.class);
        material.setMaterialEnum(materialOnBaseServiceModel.getMaterialEnum());
        material.setMaterialCount(-materialOnBaseServiceModel.getMaterialCount());
        material.setAddDate(materialOnBaseServiceModel.getAddDate());

        materialRepository.save(material);
        materialOnBaseRepository.save(materialOnBase);
    }

    @Override
    public Long getTapeCountLower() {
        return materialOnBaseRepository.getMaterialOnBaseByMaterialEnumAndCategoryBaseEnum(MaterialEnum.TAPE, CategoryBaseEnum.LOWER).
                stream().map(MaterialOnBase::getMaterialCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getStretchOrdinaryLower() {
        return materialOnBaseRepository.getMaterialOnBaseByMaterialEnumAndCategoryBaseEnum(MaterialEnum.STRETCH_ORDINARY, CategoryBaseEnum.LOWER).
                stream().map(MaterialOnBase::getMaterialCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getStretchHolesLower() {
        return materialOnBaseRepository.getMaterialOnBaseByMaterialEnumAndCategoryBaseEnum(MaterialEnum.STRETCH_WITH_HOLES, CategoryBaseEnum.LOWER).
                stream().map(MaterialOnBase::getMaterialCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getTapeCountUpper() {
        return materialOnBaseRepository.getMaterialOnBaseByMaterialEnumAndCategoryBaseEnum(MaterialEnum.TAPE, CategoryBaseEnum.UPPER).
                stream().map(MaterialOnBase::getMaterialCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getStretchOrdinaryUpper() {
        return materialOnBaseRepository.getMaterialOnBaseByMaterialEnumAndCategoryBaseEnum(MaterialEnum.STRETCH_ORDINARY, CategoryBaseEnum.UPPER).
                stream().map(MaterialOnBase::getMaterialCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getStretchHolesUpper() {
        return materialOnBaseRepository.getMaterialOnBaseByMaterialEnumAndCategoryBaseEnum(MaterialEnum.STRETCH_WITH_HOLES, CategoryBaseEnum.UPPER).
                stream().map(MaterialOnBase::getMaterialCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public void subtractionMaterial(SubtractionMaterialFromBasesServiceModel subtractionMaterialFromBasesServiceModel) {
        MaterialOnBase materialOnBase = modelMapper.map(subtractionMaterialFromBasesServiceModel, MaterialOnBase.class);
        materialOnBase.setCategoryBaseEnum(subtractionMaterialFromBasesServiceModel.getCategoryBaseEnum());
        materialOnBase.setMaterialEnum(subtractionMaterialFromBasesServiceModel.getMaterialEnum());
        materialOnBase.setMaterialCount(-subtractionMaterialFromBasesServiceModel.getMaterialCount());
        materialOnBase.setAddDate(subtractionMaterialFromBasesServiceModel.getAddDate());

        materialOnBaseRepository.save(materialOnBase);
    }

    @Override
    public Long getTapeCountPAckaging() {
        return materialOnBaseRepository.getMaterialOnBaseByMaterialEnumAndCategoryBaseEnum(MaterialEnum.TAPE, CategoryBaseEnum.PACKAGING).
                stream().map(MaterialOnBase::getMaterialCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getStretchOrdinaryPackaging() {
        return materialOnBaseRepository.getMaterialOnBaseByMaterialEnumAndCategoryBaseEnum(MaterialEnum.STRETCH_ORDINARY, CategoryBaseEnum.PACKAGING).
                stream().map(MaterialOnBase::getMaterialCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getStretchHolesPackaging() {
        return materialOnBaseRepository.getMaterialOnBaseByMaterialEnumAndCategoryBaseEnum(MaterialEnum.STRETCH_WITH_HOLES, CategoryBaseEnum.PACKAGING).
                stream().map(MaterialOnBase::getMaterialCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public List<MaterialOnBase> viewIssuedMaterial(SearchFromToMaterialServiceModel searchFromToMaterialServiceModel) {
        List<MaterialOnBase> allS = new ArrayList<>();
        List<MaterialOnBase> allMaterial =
        materialOnBaseRepository.findMaterialOnBaseByAddDateBetween(searchFromToMaterialServiceModel.getStart(), searchFromToMaterialServiceModel.getEnd());

        Long sum = 0L;
        for (MaterialEnum material: MaterialEnum.values()) {
            sum = 0L;
            for (int i = 0; i <= allMaterial.size() -1; i++) {

                if(allMaterial.get(i).getMaterialEnum().name().equals(material.name())
                        && allMaterial.get(i).getMaterialCount() < 0){
                   sum += allMaterial.get(i).getMaterialCount() * -1;
                }
            }
            MaterialOnBase materialOnBase = modelMapper.map(materialOnBaseServiceModel, MaterialOnBase.class);
            materialOnBase.setAddDate(LocalDate.now());
            materialOnBase.setMaterialEnum(material);
            materialOnBase.setMaterialCount(sum);
            allS.add(materialOnBase);
        }


        return allS;
    }


}
