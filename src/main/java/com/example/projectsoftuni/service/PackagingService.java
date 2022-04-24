package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.PackagingCartonsEnum;
import com.example.projectsoftuni.model.service.PackagingServiceModel;
import com.example.projectsoftuni.model.service.ProductAfterPackagingServiceModel;

public interface PackagingService {
    void add(PackagingServiceModel packagingServiceModel);

    int getStatusNotOk();

    Object getXLCoreCount();

    Object getXLCartonCount();

    Object getLCartonCount();

    Object getMCartonCount();

    Object getSCartonCount();

    Long getLFamilyCartonCount();

    Long getLChezCartonCount();

    Long getLHartmanCartonCount();

    Long getLEuroCartonCount();

    Long getMFamilyCartonCount();

    Long getMChezCartonCount();

    Long getMHartmanCartonCount();

    Long getMEuroCartonCount();

    Long getSFamilyCartonCount();

    Long getSChezCartonCount();

    Long getSHartmanCartonCount();

    Long getSEuroCartonCount();


    Long getCategoryEggAndCategoryCartons(CategoryCartonsEnum categoryCartonsEnum, CategoryEggEnum categoryEggEnum);


}
