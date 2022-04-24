package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.Material;
import com.example.projectsoftuni.model.entity.MaterialOnBase;
import com.example.projectsoftuni.model.entity.enums.MaterialEnum;
import com.example.projectsoftuni.model.service.MaterialOnBaseServiceModel;
import com.example.projectsoftuni.model.service.MaterialServiceModel;
import com.example.projectsoftuni.model.service.UserServiceModel;
import com.example.projectsoftuni.repository.MaterialRepository;
import com.example.projectsoftuni.service.MaterialService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialServiceModel materialServiceModel;
    private final ModelMapper modelMapper;
    private final MaterialRepository materialRepository;
    private final UserServiceModel userServiceModel;
    private final MaterialOnBaseServiceModel materialOnBaseServiceModel;

    public MaterialServiceImpl(MaterialServiceModel materialServiceModel, ModelMapper modelMapper, MaterialRepository materialRepository, UserServiceModel userServiceModel, MaterialOnBaseServiceModel materialOnBaseServiceModel) {
        this.materialServiceModel = materialServiceModel;
        this.modelMapper = modelMapper;
        this.materialRepository = materialRepository;
        this.userServiceModel = userServiceModel;
        this.materialOnBaseServiceModel = materialOnBaseServiceModel;
    }

    @Override
    public void addMaterial(MaterialServiceModel materialServiceModel) {
        Material material = modelMapper.map(materialServiceModel, Material.class);
        material.setMaterialEnum(materialServiceModel.getMaterialEnum());
        material.setMaterialCount(materialServiceModel.getMaterialCount());
        material.setAddDate(materialServiceModel.getAddDate());
        String username = userServiceModel.getFirstName();
        material.setUserName(username);

        materialRepository.save(material);

    }

    @Override
    public Long getTapeCount() {
        return materialRepository.getMaterialByMaterialEnum(MaterialEnum.TAPE).
                stream().map(Material::getMaterialCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getStretchOrdinary() {
        return materialRepository.getMaterialByMaterialEnum(MaterialEnum.STRETCH_ORDINARY).
                stream().map(Material::getMaterialCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getStretchHoles() {
        return materialRepository.getMaterialByMaterialEnum(MaterialEnum.STRETCH_WITH_HOLES).
                stream().map(Material::getMaterialCount).reduce(Long::sum).orElse(0L);
    }


}
