package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.Egg;
import com.example.projectsoftuni.model.entity.Packaging;
import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.PackagingCartonsEnum;
import com.example.projectsoftuni.model.service.EggServiceModel;
import com.example.projectsoftuni.model.service.PackagingServiceModel;
import com.example.projectsoftuni.model.service.ProductAfterPackagingServiceModel;
import com.example.projectsoftuni.repository.CartonAddRepository;
import com.example.projectsoftuni.repository.EggAddRepository;
import com.example.projectsoftuni.repository.PackagingRepository;
import com.example.projectsoftuni.service.EggAddService;
import com.example.projectsoftuni.service.PackagingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PackagingServiceImpl implements PackagingService {
        private final PackagingRepository packagingRepository;
        private final ModelMapper modelMapper;
        private final EggAddRepository eggAddRepository;
        private final CartonAddRepository cartonAddRepository;
        private final EggServiceModel eggServiceModel;
        private final EggAddService eggAddService;
        private final ProductAfterPackagingServiceModel productAfterPackagingServiceModel;
         int isZero = 1;
         int countEgg;

    public PackagingServiceImpl(PackagingRepository packagingRepository, ModelMapper modelMapper, EggAddRepository eggAddRepository, CartonAddRepository cartonAddRepository, EggServiceModel eggServiceModel, EggAddService eggAddService, ProductAfterPackagingServiceModel productAfterPackagingServiceModel) {
        this.packagingRepository = packagingRepository;
        this.modelMapper = modelMapper;
        this.eggAddRepository = eggAddRepository;
        this.cartonAddRepository = cartonAddRepository;
        this.eggServiceModel = eggServiceModel;
        this.eggAddService = eggAddService;
        this.productAfterPackagingServiceModel = productAfterPackagingServiceModel;
    }

    @Override
    public void add(PackagingServiceModel packagingServiceModel) {
        Packaging packaging = modelMapper.map(packagingServiceModel, Packaging.class);
        packaging.setCategoryEggEnum(packagingServiceModel.getCategoryEggEnum());
        packaging.setCategoryCartonsEnum(packagingServiceModel.getCategoryCartonsEnum());
        packaging.setCategoryBaseEnum(packagingServiceModel.getCategoryBaseEnum());
        packaging.setTransferDate(packagingServiceModel.getTransferDate());


        Egg egg = modelMapper.map(eggServiceModel, Egg.class);
        egg.setEgg(packagingServiceModel.getCategoryEggEnum());
        egg.setCartons(packagingServiceModel.getCategoryCartonsEnum());
        egg.setBase(packagingServiceModel.getCategoryBaseEnum());
        egg.setAddDate(packagingServiceModel.getTransferDate());

        Long sellCount = packagingServiceModel.getCount();

        // Base LOWER
        if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_20)) {

            Long countOfCorey20FromLowerBase = eggAddService.findByCategoryXLLower();

            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }
            egg.setCountOfEgg(-sellCount);

        } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_120)) {

            Long countOfCorey20FromLowerBase = eggAddService.findByCategoryXLCartonsLower();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(- sellCount);

        } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_CHEZ)
                && egg.getEgg().equals(CategoryEggEnum.L)) {

            Long countOfCorey20FromLowerBase = eggAddService.findCoreyChezBaseLowerL();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_HARTMAN)
                && egg.getEgg().equals(CategoryEggEnum.L)) {

            Long countOfCorey20FromLowerBase = eggAddService.findCoreyHartmanBaseLowerL();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        }  else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_FAMILY)
                && egg.getEgg().equals(CategoryEggEnum.L)) {

            Long countOfCorey20FromLowerBase = eggAddService.findCoreyFamilyBaseLowerL();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_EURO)
                && egg.getEgg().equals(CategoryEggEnum.L)) {

            Long countOfCorey20FromLowerBase = eggAddService.findCoreyEuroBaseLowerL();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        }else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180_WHITE)
                && egg.getEgg().equals(CategoryEggEnum.L)) {

            Long countOfCorey20FromLowerBase = eggAddService.findByCategoryLCartonLower();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_EURO)
                && egg.getEgg().equals(CategoryEggEnum.M)) {

            Long countOfCorey20FromLowerBase = eggAddService.findCoreyEuroBaseLowerM();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        }  else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_HARTMAN)
                && egg.getEgg().equals(CategoryEggEnum.M)) {

            Long countOfCorey20FromLowerBase = eggAddService.findCoreyHartmanBaseLowerM();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        }  else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_FAMILY)
                && egg.getEgg().equals(CategoryEggEnum.M)) {

            Long countOfCorey20FromLowerBase = eggAddService.findCoreyFamilyBaseLowerM();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        }  else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_CHEZ)
                && egg.getEgg().equals(CategoryEggEnum.M)) {

            Long countOfCorey20FromLowerBase = eggAddService.findCoreyChezBaseLowerM();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180_WHITE)
                && egg.getEgg().equals(CategoryEggEnum.M)) {

            Long countOfCorey20FromLowerBase = eggAddService.findByCategoryMCartonLower();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        } else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_EURO)
                && egg.getEgg().equals(CategoryEggEnum.S)) {

            Long countOfCorey20FromLowerBase = eggAddService.findCoreyEuroBaseLowerS();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        }  else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_HARTMAN)
                && egg.getEgg().equals(CategoryEggEnum.S)) {

            Long countOfCorey20FromLowerBase = eggAddService.findCoreyHartmanBaseLowerS();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        }  else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_FAMILY)
                && egg.getEgg().equals(CategoryEggEnum.S)) {

            Long countOfCorey20FromLowerBase = eggAddService.findCoreyFamilyBaseLowerS();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        }  else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_CHEZ)
                && egg.getEgg().equals(CategoryEggEnum.S)) {

            Long countOfCorey20FromLowerBase = eggAddService.findCoreyChezBaseLowerS();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        }  else if (egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180_WHITE)
                && egg.getEgg().equals(CategoryEggEnum.S)) {

            Long countOfCorey20FromLowerBase = eggAddService.findByCategorySCartonLower();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        }


        // Base UPPER
        if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_20)) {

            Long countOfCorey20FromUpperBase = eggAddService.findByCategoryXLUpper();

            if (countOfCorey20FromUpperBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        } else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_120)) {

            Long countOfCorey20FromLowerBase = eggAddService.findByCategoryXLCartonsUpper();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        } else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_EURO)
                && egg.getEgg().equals(CategoryEggEnum.L)) {

            Long countOfCorey20FromLowerBase = eggAddService.findCoreyEuroUpperL();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        }  else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_HARTMAN)
                && egg.getEgg().equals(CategoryEggEnum.L)) {

            Long countOfCorey20FromLowerBase = eggAddService.findCoreyHartmanUpperL();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        }  else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_FAMILY)
                && egg.getEgg().equals(CategoryEggEnum.L)) {

            Long countOfCorey20FromLowerBase = eggAddService.findCoreyFamilyUpperL();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        }  else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_CHEZ)
                && egg.getEgg().equals(CategoryEggEnum.L)) {

            Long countOfCorey20FromLowerBase = eggAddService.findCoreyChezUpperL();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        }  else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180_WHITE)
                && egg.getEgg().equals(CategoryEggEnum.L)) {

            Long countOfCorey20FromLowerBase = eggAddService.findByCategoryLCartonsUpper();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        } else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_EURO)
                && egg.getEgg().equals(CategoryEggEnum.M)) {

            Long countOfCorey20FromLowerBase = eggAddService.findCoreyEuroUpperM();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        }  else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_HARTMAN)
                && egg.getEgg().equals(CategoryEggEnum.M)) {

            Long countOfCorey20FromLowerBase = eggAddService.findCoreyHartmanUpperM();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        }  else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_FAMILY)
                && egg.getEgg().equals(CategoryEggEnum.M)) {

            Long countOfCorey20FromLowerBase = eggAddService.findCoreyFamilyUpperM();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        }  else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_CHEZ)
                && egg.getEgg().equals(CategoryEggEnum.M)) {

            Long countOfCorey20FromLowerBase = eggAddService.findCoreyChezUpperM();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        }   else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180_WHITE)
                && egg.getEgg().equals(CategoryEggEnum.M)) {

            Long countOfCorey20FromLowerBase = eggAddService.findByCategoryMCartonsUpper();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        } else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_EURO)
                && egg.getEgg().equals(CategoryEggEnum.S)) {

            Long countOfCorey20FromLowerBase = eggAddService.findCoreyEuroUpperS();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        }  else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_HARTMAN)
                && egg.getEgg().equals(CategoryEggEnum.S)) {

            Long countOfCorey20FromLowerBase = eggAddService.findCoreyHartmanUpperS();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        }  else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_FAMILY)
                && egg.getEgg().equals(CategoryEggEnum.S)) {

            Long countOfCorey20FromLowerBase = eggAddService.findCoreyFamilyUpperS();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        }  else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30_CHEZ)
                && egg.getEgg().equals(CategoryEggEnum.S)) {

            Long countOfCorey20FromLowerBase = eggAddService.findCoreyChezUpperS();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        }  else if (egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180_WHITE)
                && egg.getEgg().equals(CategoryEggEnum.S)) {

            Long countOfCorey20FromLowerBase = eggAddService.findByCategorySCartonUpper();
            if (countOfCorey20FromLowerBase < sellCount) {
                isZero = 0;
            }

            egg.setCountOfEgg(-sellCount);

        }

        if (isZero == 1) {
            eggAddRepository.save(egg);
            packaging.setCount(packagingServiceModel.getCount());
            packagingRepository.save(packaging);
        }

    }

    @Override
    public int getStatusNotOk() {
        if(isZero == 0){
            countEgg = 1;
        }else{
            countEgg = 0;
        }
        return countEgg;
    }

    @Override
    public Long getXLCoreCount() {
        return packagingRepository.getAllByCategoryEggEnumAndCategoryCartonsEnum(CategoryEggEnum.XL, CategoryCartonsEnum.COREY_20).
                stream().map(Packaging::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getXLCartonCount() {
        return packagingRepository.getAllByCategoryEggEnumAndCategoryCartonsEnum(CategoryEggEnum.XL,CategoryCartonsEnum.CARTONS_120).
                stream().map(Packaging::getCount).reduce(Long::sum).orElse(0L);
    }


    @Override
    public Long getLCartonCount() {
        return packagingRepository.getAllByCategoryEggEnumAndCategoryCartonsEnum(CategoryEggEnum.L,CategoryCartonsEnum.CARTONS_180_WHITE).
                stream().map(Packaging::getCount).reduce(Long::sum).orElse(0L);
    }


    @Override
    public Long getMCartonCount() {
        return packagingRepository.getAllByCategoryEggEnumAndCategoryCartonsEnum(CategoryEggEnum.M, CategoryCartonsEnum.CARTONS_180_WHITE).
                stream().map(Packaging::getCount).reduce(Long::sum).orElse(0L);
    }


    @Override
    public Long getSCartonCount() {
        return packagingRepository.getAllByCategoryEggEnumAndCategoryCartonsEnum(CategoryEggEnum.S, CategoryCartonsEnum.CARTONS_180_WHITE).
                stream().map(Packaging::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getLFamilyCartonCount() {
        return packagingRepository.getAllByCategoryEggEnumAndCategoryCartonsEnum(CategoryEggEnum.L, CategoryCartonsEnum.COREY_30_FAMILY).
                stream().map(Packaging::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getLChezCartonCount() {
        return packagingRepository.getAllByCategoryEggEnumAndCategoryCartonsEnum(CategoryEggEnum.L, CategoryCartonsEnum.COREY_30_CHEZ).
                stream().map(Packaging::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getLHartmanCartonCount() {
        return packagingRepository.getAllByCategoryEggEnumAndCategoryCartonsEnum(CategoryEggEnum.L, CategoryCartonsEnum.COREY_30_HARTMAN).
                stream().map(Packaging::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getLEuroCartonCount() {
        return packagingRepository.getAllByCategoryEggEnumAndCategoryCartonsEnum(CategoryEggEnum.L, CategoryCartonsEnum.COREY_30_EURO).
                stream().map(Packaging::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getMFamilyCartonCount() {
        return packagingRepository.getAllByCategoryEggEnumAndCategoryCartonsEnum(CategoryEggEnum.M, CategoryCartonsEnum.COREY_30_FAMILY).
                stream().map(Packaging::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getMChezCartonCount() {
        return packagingRepository.getAllByCategoryEggEnumAndCategoryCartonsEnum(CategoryEggEnum.M, CategoryCartonsEnum.COREY_30_CHEZ).
                stream().map(Packaging::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getMHartmanCartonCount() {
        return packagingRepository.getAllByCategoryEggEnumAndCategoryCartonsEnum(CategoryEggEnum.M, CategoryCartonsEnum.COREY_30_HARTMAN).
                stream().map(Packaging::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getMEuroCartonCount() {
        return packagingRepository.getAllByCategoryEggEnumAndCategoryCartonsEnum(CategoryEggEnum.M, CategoryCartonsEnum.COREY_30_EURO).
                stream().map(Packaging::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getSFamilyCartonCount() {
        return packagingRepository.getAllByCategoryEggEnumAndCategoryCartonsEnum(CategoryEggEnum.S, CategoryCartonsEnum.COREY_30_FAMILY).
                stream().map(Packaging::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getSChezCartonCount() {
        return packagingRepository.getAllByCategoryEggEnumAndCategoryCartonsEnum(CategoryEggEnum.S, CategoryCartonsEnum.COREY_30_CHEZ).
                stream().map(Packaging::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getSHartmanCartonCount() {
        return packagingRepository.getAllByCategoryEggEnumAndCategoryCartonsEnum(CategoryEggEnum.S, CategoryCartonsEnum.COREY_30_HARTMAN).
                stream().map(Packaging::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getSEuroCartonCount() {
        return packagingRepository.getAllByCategoryEggEnumAndCategoryCartonsEnum(CategoryEggEnum.S, CategoryCartonsEnum.COREY_30_EURO).
                stream().map(Packaging::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCategoryEggAndCategoryCartons(CategoryCartonsEnum categoryCartonsEnum, CategoryEggEnum categoryEggEnum) {
        return packagingRepository.getAllByCategoryEggEnumAndCategoryCartonsEnum(categoryEggEnum, categoryCartonsEnum).
                stream().map(Packaging::getCount).reduce(Long::sum).orElse(0L);
    }




}
