package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.entity.enums.PackagingCartonsEnum;
import com.example.projectsoftuni.model.service.CartonsForPackagingServiceModel;

public interface CartonsForPackagingService {


    void addCartons(CartonsForPackagingServiceModel cartonsForPackagingServiceModel);


    Long getPackagingCartonsEnumBox6();

    Long getPackagingCartonsEnumBox10();

    Long getPackagingCartonsEnumBox12();

    Long getPackagingCartonsEnumCover15();

    Long getPackagingCartonsEnumCover30();
}
