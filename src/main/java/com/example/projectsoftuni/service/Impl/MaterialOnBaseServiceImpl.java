package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.Material;
import com.example.projectsoftuni.model.entity.MaterialOnBase;
import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.MaterialEnum;
import com.example.projectsoftuni.model.service.MaterialOnBaseServiceModel;
import com.example.projectsoftuni.repository.MaterialOnBaseRepository;
import com.example.projectsoftuni.repository.MaterialRepository;
import com.example.projectsoftuni.service.MaterialOnBaseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}
