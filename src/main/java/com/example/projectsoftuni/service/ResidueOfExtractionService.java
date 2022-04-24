package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.service.ResidueOfExtractionServiceModel;

public interface ResidueOfExtractionService {

    void packagingLower(ResidueOfExtractionServiceModel residueOfExtractionServiceModel);

    Long getCountXlLower();

    Long getCountLLower();

    Long getCountMLower();

    Long getCountSLower();

    Long getCountHLower();

    Long getCountXlUpper();

    Long getCountLUpper();

    Long getCountMUpper();

    Long getCountSUpper();

    Long getCountHUpper();

    void packagingUpper(ResidueOfExtractionServiceModel residueOfExtractionServiceModel);

    int getStatusIsZero();
}
