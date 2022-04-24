package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.entity.CoreyFreeAfterPackaging;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.service.CoreyFreeAfterPackagingServiceModel;

import java.util.List;

public interface CoreyAfterPackagingService {
    void transferCartonToBase(CoreyFreeAfterPackagingServiceModel coreyFreeAfterPackagingServiceModel);

    List<CoreyFreeAfterPackaging> getAllCartons();

    Long getCartonsCountToTransfer(CategoryCartonsEnum categoryCartonsEnum);

    Long getCount(CoreyFreeAfterPackagingServiceModel coreyFreeAfterPackagingServiceModel);
}
