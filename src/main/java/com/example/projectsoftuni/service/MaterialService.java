package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.service.MaterialServiceModel;

public interface MaterialService {
    void addMaterial(MaterialServiceModel materialServiceModel);

    Long getTapeCount();

    Long getStretchOrdinary();

    Long getStretchHoles();
}
