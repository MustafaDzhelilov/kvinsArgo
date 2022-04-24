package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.PackingProduct;
import com.example.projectsoftuni.model.entity.Pallets;
import com.example.projectsoftuni.model.entity.SellFromPackaging;
import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.ClientEnum;
import com.example.projectsoftuni.model.entity.enums.PalletTypeEnum;
import com.example.projectsoftuni.model.service.PalletsServiceModel;
import com.example.projectsoftuni.model.service.ProductAfterPackagingServiceModel;
import com.example.projectsoftuni.model.service.SellFromPackagingServiceModel;
import com.example.projectsoftuni.repository.PalletsRepository;
import com.example.projectsoftuni.repository.ProductAfterPackagingRepository;
import com.example.projectsoftuni.repository.SellFromPackagingRepository;
import com.example.projectsoftuni.service.PackagingService;
import com.example.projectsoftuni.service.ProductAfterPackagingService;
import com.example.projectsoftuni.service.SellFromPackagingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellFromPackagingServiceImpl implements SellFromPackagingService {

    private final SellFromPackagingRepository sellFromPackagingRepository;
    private final ModelMapper modelMapper;
    private final SellFromPackagingServiceModel sellFromPackagingServiceModel;
    private final PackagingService packagingService;
    private final ProductAfterPackagingService productAfterPackagingService;
    private final ProductAfterPackagingServiceModel productAfterPackagingServiceModel;
    private final ProductAfterPackagingRepository productAfterPackagingRepository;
    private final PalletsServiceModel palletsServiceModel;
    private final PalletsRepository palletsRepository;
    int noEgg = 1;
    int countEgg;

    public SellFromPackagingServiceImpl(SellFromPackagingRepository sellFromPackagingRepository, ModelMapper modelMapper, SellFromPackagingServiceModel sellFromPackagingServiceModel, PackagingService packagingService, ProductAfterPackagingService productAfterPackagingService, ProductAfterPackagingServiceModel productAfterPackagingServiceModel, ProductAfterPackagingRepository productAfterPackagingRepository, PalletsServiceModel palletsServiceModel, PalletsRepository palletsRepository) {
        this.sellFromPackagingRepository = sellFromPackagingRepository;
        this.modelMapper = modelMapper;
        this.sellFromPackagingServiceModel = sellFromPackagingServiceModel;
        this.packagingService = packagingService;
        this.productAfterPackagingService = productAfterPackagingService;
        this.productAfterPackagingServiceModel = productAfterPackagingServiceModel;
        this.productAfterPackagingRepository = productAfterPackagingRepository;
        this.palletsServiceModel = palletsServiceModel;
        this.palletsRepository = palletsRepository;
    }


    @Override
    public void sell(SellFromPackagingServiceModel sellFromPackagingServiceModel) {
        SellFromPackaging sellFromPackaging = modelMapper.map(sellFromPackagingServiceModel, SellFromPackaging.class);
        sellFromPackaging.setPackagingCartonsEnum(sellFromPackagingServiceModel.getPackagingCartonsEnum());
        sellFromPackaging.setEgg(sellFromPackagingServiceModel.getEgg());
        sellFromPackaging.setCount(sellFromPackagingServiceModel.getCount());
        sellFromPackaging.setDate(sellFromPackagingServiceModel.getDate());
        sellFromPackaging.setClientEnum(sellFromPackagingServiceModel.getClientEnum());
        sellFromPackaging.setPalletTypeEnum(sellFromPackagingServiceModel.getPalletTypeEnum());
        sellFromPackaging.setCountIssuedPallets(sellFromPackagingServiceModel.getCountIssuedPallets());
        sellFromPackaging.setPrice(sellFromPackagingServiceModel.getPrice());
        sellFromPackaging.setTotalPrice((sellFromPackagingServiceModel.getPrice()) * sellFromPackagingServiceModel.getCount());

        Long countEgg = productAfterPackagingService.getCountFromAskedProduct(sellFromPackagingServiceModel.getPackagingCartonsEnum(), sellFromPackagingServiceModel.getEgg());

        PackingProduct packingProduct = modelMapper.map(productAfterPackagingServiceModel, PackingProduct.class);
        packingProduct.setCategoryEggEnum(sellFromPackagingServiceModel.getEgg());
        packingProduct.setCount(-sellFromPackagingServiceModel.getCount());
        packingProduct.setPackagingCartonsEnum(sellFromPackagingServiceModel.getPackagingCartonsEnum());
        packingProduct.setPackingDate(sellFromPackagingServiceModel.getDate());

        Pallets pallets = modelMapper.map(palletsServiceModel, Pallets.class);
        pallets.setCategoryBaseEnum(CategoryBaseEnum.PACKAGING);
        pallets.setPalletTypeEnum(sellFromPackagingServiceModel.getPalletTypeEnum());
        pallets.setLocalDate(LocalDate.now());
        pallets.setCount(-sellFromPackagingServiceModel.getCountIssuedPallets());



        if(countEgg >= sellFromPackagingServiceModel.getCount()){
            noEgg =0;
            sellFromPackagingRepository.save(sellFromPackaging);
            productAfterPackagingRepository.save(packingProduct);
            palletsRepository.save(pallets);
        }
    }

    @Override
    public int getStatusForQuantityEgg() {
        if(noEgg == 0){
            countEgg = 1;
        }else{
            countEgg = 0;
        }
        return countEgg;
    }

    @Override
    public List<SellFromPackaging> getAllSellsFromPackaging() {
        return sellFromPackagingRepository
                .findAllByOrderByDateDesc()
                .stream()
                .sorted(Comparator.comparing(SellFromPackaging::getDate)
                        .thenComparing(SellFromPackaging::getClientEnum)
                        .thenComparing(SellFromPackaging::getEgg)
                        .reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Long getReturnedEuroByCLient(ClientEnum client, PalletTypeEnum euro) {
        return sellFromPackagingRepository.getReturnedPalletsByClientEnumAndPalletTypeEnum(client, euro).
                stream().map(SellFromPackaging::getCountIssuedPallets).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getReturnedPallThermoByClient(ClientEnum client, PalletTypeEnum thermo) {
        return sellFromPackagingRepository.getReturnedPalletsByClientEnumAndPalletTypeEnum(client, thermo).
                stream().map(SellFromPackaging::getCountIssuedPallets).reduce(Long::sum).orElse(0L);
    }
}
