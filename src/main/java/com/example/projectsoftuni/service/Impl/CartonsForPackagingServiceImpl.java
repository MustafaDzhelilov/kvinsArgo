package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.CartonsForPackaging;
import com.example.projectsoftuni.model.entity.enums.PackagingCartonsEnum;
import com.example.projectsoftuni.model.service.CartonsForPackagingServiceModel;
import com.example.projectsoftuni.model.service.ProductAfterPackagingServiceModel;
import com.example.projectsoftuni.repository.CartonsForPackagingRepository;
import com.example.projectsoftuni.service.CartonsForPackagingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CartonsForPackagingServiceImpl implements CartonsForPackagingService {

    private final CartonsForPackagingRepository cartonsForPackagingRepository;
    private final ProductAfterPackagingServiceModel productAfterPackagingServiceModel;
    private final ModelMapper modelMapper;

    public CartonsForPackagingServiceImpl(CartonsForPackagingRepository cartonsForPackagingRepository, ProductAfterPackagingServiceModel productAfterPackagingServiceModel, ModelMapper modelMapper) {
        this.cartonsForPackagingRepository = cartonsForPackagingRepository;
        this.productAfterPackagingServiceModel = productAfterPackagingServiceModel;
        this.modelMapper = modelMapper;
    }


    @Override
    public void addCartons(CartonsForPackagingServiceModel cartonsForPackagingServiceModel) {
        CartonsForPackaging cartonsForPackaging = modelMapper.map(cartonsForPackagingServiceModel, CartonsForPackaging.class);
        cartonsForPackaging.setPackagingCartonsEnum(cartonsForPackagingServiceModel.getPackagingCartonsEnum());
        cartonsForPackaging.setCount(cartonsForPackagingServiceModel.getCount());
        cartonsForPackaging.setDate(cartonsForPackagingServiceModel.getDate());

        cartonsForPackagingRepository.save(cartonsForPackaging);
    }

    @Override
    public Long getPackagingCartonsEnumBox6() {
        return cartonsForPackagingRepository.findAllByPackagingCartonsEnum(PackagingCartonsEnum.BOX_6)
                .stream().map(CartonsForPackaging::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getPackagingCartonsEnumBox10() {
        return cartonsForPackagingRepository.findAllByPackagingCartonsEnum(PackagingCartonsEnum.BOX_10)
                .stream().map(CartonsForPackaging::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getPackagingCartonsEnumBox12() {
        return cartonsForPackagingRepository.findAllByPackagingCartonsEnum(PackagingCartonsEnum.BOX_12)
                .stream().map(CartonsForPackaging::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getPackagingCartonsEnumCover15() {
        return cartonsForPackagingRepository.findAllByPackagingCartonsEnum(PackagingCartonsEnum.COVER_15)
                .stream().map(CartonsForPackaging::getCount).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getPackagingCartonsEnumCover30() {
        return cartonsForPackagingRepository.findAllByPackagingCartonsEnum(PackagingCartonsEnum.COVER_30)
                .stream().map(CartonsForPackaging::getCount).reduce(Long::sum).orElse(0L);
    }


}
