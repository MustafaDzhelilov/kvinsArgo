package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.binding.PackagingBindingModel;
import com.example.projectsoftuni.model.entity.CartonsForPackaging;
import com.example.projectsoftuni.model.entity.CoreyFreeAfterPackaging;
import com.example.projectsoftuni.model.entity.Packaging;
import com.example.projectsoftuni.model.entity.PackingProduct;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.PackagingCartonsEnum;
import com.example.projectsoftuni.model.service.*;
import com.example.projectsoftuni.repository.CartonsForPackagingRepository;
import com.example.projectsoftuni.repository.CoreyAfterPackagingRepository;
import com.example.projectsoftuni.repository.PackagingRepository;
import com.example.projectsoftuni.repository.ProductAfterPackagingRepository;
import com.example.projectsoftuni.service.CartonsForPackagingService;
import com.example.projectsoftuni.service.PackagingService;
import com.example.projectsoftuni.service.ProductAfterPackagingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductAfterPackagingServiceImpl implements ProductAfterPackagingService {

    private final ModelMapper modelMapper;
    private final ProductAfterPackagingRepository productAfterPackagingRepository;
    private final ProductAfterPackagingServiceModel productAfterPackagingServiceModel;
    private final PackagingServiceModel packagingServiceModel;
    private final PackagingRepository packagingRepository;
    private final CoreyFreeAfterPackagingServiceModel coreyFreeAfterPackagingServiceModel;
    private final CoreyAfterPackagingRepository coreyAfterPackagingRepository;
    private final CartonsForPackagingService cartonsForPackagingService;
    private final CartonsForPackagingServiceModel cartonsForPackagingServiceModel;
    private final CartonsForPackagingRepository cartonsForPackagingRepository;
    private final PackagingService packagingService;
    private final PackagingBindingModel packagingBindingModel;
    int noBoxes;
    int freeCorey;
    int noEgg;
    int countEgg;
    int countBox;

    public ProductAfterPackagingServiceImpl(ModelMapper modelMapper, ProductAfterPackagingRepository productAfterPackagingRepository, ProductAfterPackagingServiceModel productAfterPackagingServiceModel, PackagingServiceModel packagingServiceModel, PackagingRepository packagingRepository, CoreyFreeAfterPackagingServiceModel coreyFreeAfterPackagingServiceModel, CoreyAfterPackagingRepository coreyAfterPackagingRepository, CartonsForPackagingService cartonsForPackagingService, CartonsForPackagingServiceModel cartonsForPackagingServiceModel, CartonsForPackagingRepository cartonsForPackagingRepository, PackagingService packagingService, PackagingBindingModel packagingBindingModel) {
        this.modelMapper = modelMapper;
        this.productAfterPackagingRepository = productAfterPackagingRepository;
        this.productAfterPackagingServiceModel = productAfterPackagingServiceModel;
        this.packagingServiceModel = packagingServiceModel;
        this.packagingRepository = packagingRepository;
        this.coreyFreeAfterPackagingServiceModel = coreyFreeAfterPackagingServiceModel;
        this.coreyAfterPackagingRepository = coreyAfterPackagingRepository;
        this.cartonsForPackagingService = cartonsForPackagingService;
        this.cartonsForPackagingServiceModel = cartonsForPackagingServiceModel;
        this.cartonsForPackagingRepository = cartonsForPackagingRepository;
        this.packagingService = packagingService;
        this.packagingBindingModel = packagingBindingModel;
    }


    @Override
    public void add(ProductAfterPackagingServiceModel productAfterPackagingServiceModel) {
        PackingProduct packingProduct = modelMapper.map(productAfterPackagingServiceModel, PackingProduct.class);
        packingProduct.setCategoryEggEnum(productAfterPackagingServiceModel.getCategoryEggEnum());
        packingProduct.setCategoryCartonsEnum(productAfterPackagingServiceModel.getCategoryCartonsEnum());
        packingProduct.setPackagingCartonsEnum(productAfterPackagingServiceModel.getPackagingCartonsEnum());

        Long countEgg = packagingService.getCategoryEggAndCategoryCartons(productAfterPackagingServiceModel.getCategoryCartonsEnum(), productAfterPackagingServiceModel.getCategoryEggEnum());
        if(countEgg < productAfterPackagingServiceModel.getCount()){
            noEgg = 1;
        }

        Long countBoxes = 0L;
        if(productAfterPackagingServiceModel.getPackagingCartonsEnum().equals(PackagingCartonsEnum.BOX_6)){
           countBoxes  = ((productAfterPackagingServiceModel.getCount()) / 6);

           freeCorey = 1;
            if(cartonsForPackagingService.getPackagingCartonsEnumBox6()< countBoxes){
                noBoxes = 1;
            }
        }else if(productAfterPackagingServiceModel.getPackagingCartonsEnum().equals(PackagingCartonsEnum.BOX_10)){
            countBoxes  = ((productAfterPackagingServiceModel.getCount()) / 10);
            freeCorey = 1;
            if(cartonsForPackagingService.getPackagingCartonsEnumBox10() < countBoxes){
                noBoxes = 1;
            }

        }else if(productAfterPackagingServiceModel.getPackagingCartonsEnum().equals(PackagingCartonsEnum.BOX_12)){
            countBoxes  = ((productAfterPackagingServiceModel.getCount()) / 12);
            freeCorey = 1;
            if(cartonsForPackagingService.getPackagingCartonsEnumBox12() < countBoxes){
                noBoxes = 1;
            }
        }else if(productAfterPackagingServiceModel.getPackagingCartonsEnum().equals(PackagingCartonsEnum.COVER_15)){
            countBoxes = ((productAfterPackagingServiceModel.getCount()) / 15);
            if(cartonsForPackagingService.getPackagingCartonsEnumCover15() < countBoxes){
                noBoxes = 1;
            }
        }else if(productAfterPackagingServiceModel.getPackagingCartonsEnum().equals(PackagingCartonsEnum.COVER_30)){
            countBoxes = ((productAfterPackagingServiceModel.getCount()) / 30);
            if(cartonsForPackagingService.getPackagingCartonsEnumCover30() < countBoxes){
                noBoxes = 1;
            }
        }

        packingProduct.setCount(countBoxes);
        packingProduct.setPackingDate(productAfterPackagingServiceModel.getPackingDate());

        Packaging packaging = modelMapper.map(packagingServiceModel, Packaging.class);
        packaging.setCategoryEggEnum(productAfterPackagingServiceModel.getCategoryEggEnum());
        packaging.setCategoryCartonsEnum(productAfterPackagingServiceModel.getCategoryCartonsEnum());
        packaging.setTransferDate(productAfterPackagingServiceModel.getPackingDate());
        packaging.setCount(-productAfterPackagingServiceModel.getCount());

        CoreyFreeAfterPackaging coreyFreeAfterPackaging = modelMapper.map(coreyFreeAfterPackagingServiceModel, CoreyFreeAfterPackaging.class);
        coreyFreeAfterPackaging.setCartons(productAfterPackagingServiceModel.getCategoryCartonsEnum());
        coreyFreeAfterPackaging.setCount(productAfterPackagingServiceModel.getCount() / 30);

        CartonsForPackaging cartonsForPackaging = modelMapper.map(cartonsForPackagingServiceModel, CartonsForPackaging.class);
        cartonsForPackaging.setPackagingCartonsEnum(productAfterPackagingServiceModel.getPackagingCartonsEnum());
        cartonsForPackaging.setDate(productAfterPackagingServiceModel.getPackingDate());
        cartonsForPackaging.setCount(-countBoxes);


        if(noEgg == 1){
            getStatusEggNotOk();
        }else if(noBoxes ==1){
            getStatusNotOk();
        }else {
            cartonsForPackagingRepository.save(cartonsForPackaging);
            packagingRepository.save(packaging);
            productAfterPackagingRepository.save(packingProduct);
            if(freeCorey == 1){
                coreyAfterPackagingRepository.save(coreyFreeAfterPackaging);
            }
        }
    }

    @Override
    public int getStatusNotOk() {
        if(noBoxes == 1) {
            countBox = 1;
        }
        return countBox;
    }

    @Override
    public int getStatusEggNotOk() {
        if(noEgg == 1) {
            countEgg = 1;
        }
        return countEgg;
    }

    @Override
    public Long getLBox15() {
        return productAfterPackagingRepository.getPackingProductByCategoryEggEnumAndPackagingCartonsEnum(CategoryEggEnum.L, PackagingCartonsEnum.COVER_15).
                stream().map(PackingProduct::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getLBox30() {
        return productAfterPackagingRepository.getPackingProductByCategoryEggEnumAndPackagingCartonsEnum(CategoryEggEnum.L, PackagingCartonsEnum.COVER_30).
                stream().map(PackingProduct::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getMbox_15() {
        return productAfterPackagingRepository.getPackingProductByCategoryEggEnumAndPackagingCartonsEnum(CategoryEggEnum.M, PackagingCartonsEnum.COVER_15).
                stream().map(PackingProduct::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getMbox_30() {
        return productAfterPackagingRepository.getPackingProductByCategoryEggEnumAndPackagingCartonsEnum(CategoryEggEnum.M, PackagingCartonsEnum.COVER_30).
                stream().map(PackingProduct::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getSbox_15() {
        return productAfterPackagingRepository.getPackingProductByCategoryEggEnumAndPackagingCartonsEnum(CategoryEggEnum.S, PackagingCartonsEnum.COVER_15).
                stream().map(PackingProduct::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getSbox_30() {
        return productAfterPackagingRepository.getPackingProductByCategoryEggEnumAndPackagingCartonsEnum(CategoryEggEnum.S, PackagingCartonsEnum.COVER_30).
                stream().map(PackingProduct::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountFromAskedProduct(PackagingCartonsEnum packagingCartonsEnum, CategoryEggEnum egg) {
        return productAfterPackagingRepository.getPackingProductByCategoryEggEnumAndPackagingCartonsEnum(egg,packagingCartonsEnum).
                stream().map(PackingProduct::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public List<PackingProduct> getAll() {
        return productAfterPackagingRepository.findDistinctByCategoryCartonsEnumIsNotNull()
                .stream()
                .sorted(Comparator.comparing(PackingProduct::getPackingDate)
                        .reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Long getXLbox_6() {
        return productAfterPackagingRepository.getPackingProductByCategoryEggEnumAndPackagingCartonsEnum(CategoryEggEnum.XL, PackagingCartonsEnum.BOX_6).
                stream().map(PackingProduct::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getXLbox_10() {
        return productAfterPackagingRepository.getPackingProductByCategoryEggEnumAndPackagingCartonsEnum(CategoryEggEnum.XL, PackagingCartonsEnum.BOX_10).
                stream().map(PackingProduct::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getXLbox_12() {
        return productAfterPackagingRepository.getPackingProductByCategoryEggEnumAndPackagingCartonsEnum(CategoryEggEnum.XL, PackagingCartonsEnum.BOX_12).
                stream().map(PackingProduct::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getLbox_6() {
        return productAfterPackagingRepository.getPackingProductByCategoryEggEnumAndPackagingCartonsEnum(CategoryEggEnum.L, PackagingCartonsEnum.BOX_6).
                stream().map(PackingProduct::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getLbox_10() {
        return productAfterPackagingRepository.getPackingProductByCategoryEggEnumAndPackagingCartonsEnum(CategoryEggEnum.L, PackagingCartonsEnum.BOX_10).
                stream().map(PackingProduct::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getLbox_12() {
        return productAfterPackagingRepository.getPackingProductByCategoryEggEnumAndPackagingCartonsEnum(CategoryEggEnum.L, PackagingCartonsEnum.BOX_12).
                stream().map(PackingProduct::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getMbox_6() {
        return productAfterPackagingRepository.getPackingProductByCategoryEggEnumAndPackagingCartonsEnum(CategoryEggEnum.M, PackagingCartonsEnum.BOX_6).
                stream().map(PackingProduct::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getMbox_10() {
        return productAfterPackagingRepository.getPackingProductByCategoryEggEnumAndPackagingCartonsEnum(CategoryEggEnum.M, PackagingCartonsEnum.BOX_10).
                stream().map(PackingProduct::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getMbox_12() {
        return productAfterPackagingRepository.getPackingProductByCategoryEggEnumAndPackagingCartonsEnum(CategoryEggEnum.M, PackagingCartonsEnum.BOX_12).
                stream().map(PackingProduct::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getSbox_6() {
        return productAfterPackagingRepository.getPackingProductByCategoryEggEnumAndPackagingCartonsEnum(CategoryEggEnum.S, PackagingCartonsEnum.BOX_6).
                stream().map(PackingProduct::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getSbox_10() {
        return productAfterPackagingRepository.getPackingProductByCategoryEggEnumAndPackagingCartonsEnum(CategoryEggEnum.S, PackagingCartonsEnum.BOX_10).
                stream().map(PackingProduct::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getSbox_12() {
        return productAfterPackagingRepository.getPackingProductByCategoryEggEnumAndPackagingCartonsEnum(CategoryEggEnum.S, PackagingCartonsEnum.BOX_12).
                stream().map(PackingProduct::getCount).reduce(Long::sum).orElse(0L);
    }


}
