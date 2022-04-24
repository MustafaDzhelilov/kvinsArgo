package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.entity.PackingProduct;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.PackagingCartonsEnum;
import com.example.projectsoftuni.model.service.ProductAfterPackagingServiceModel;

import java.util.List;

public interface ProductAfterPackagingService {
    void add(ProductAfterPackagingServiceModel productAfterPackagingServiceModel);


    List<PackingProduct> getAll();

    Object getXLbox_6();

    Object getXLbox_10();

    Object getXLbox_12();

    Object getLbox_6();

    Object getLbox_10();

    Object getLbox_12();

    Object getMbox_6();

    Object getMbox_10();

    Object getMbox_12();

    Object getSbox_6();

    Object getSbox_10();

    Object getSbox_12();

    int getStatusNotOk();

    int getStatusEggNotOk();

    Object getLBox15();

    Object getLBox30();

    Object getMbox_15();

    Object getMbox_30();

    Object getSbox_15();

    Object getSbox_30();

    Long getCountFromAskedProduct(PackagingCartonsEnum packagingCartonsEnum, CategoryEggEnum egg);
}
