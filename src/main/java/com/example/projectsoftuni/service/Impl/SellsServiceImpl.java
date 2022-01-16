package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.Egg;
import com.example.projectsoftuni.model.entity.Sells;
import com.example.projectsoftuni.model.entity.User;
import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.service.EggServiceModel;
import com.example.projectsoftuni.model.service.SellsServiceModel;
import com.example.projectsoftuni.model.view.SellsViewModel;
import com.example.projectsoftuni.model.view.UserViewModel;
import com.example.projectsoftuni.repository.EggAddRepository;
import com.example.projectsoftuni.repository.SellsRepository;
import com.example.projectsoftuni.service.ClientAddService;
import com.example.projectsoftuni.service.EggAddService;
import com.example.projectsoftuni.service.SellsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellsServiceImpl implements SellsService {

    private final SellsRepository sellsRepository;
    private final ModelMapper modelMapper;
    private final SellsServiceModel sellsServiceModel;
    private final EggServiceModel eggServiceModel;
    private final EggAddService eggAddService;
    private final EggAddRepository eggAddRepository;
    private final ClientAddService clientAddService;

    public SellsServiceImpl(SellsRepository sellsRepository, ModelMapper modelMapper, SellsServiceModel sellsServiceModel, EggServiceModel eggServiceModel, EggAddService eggAddService, EggAddRepository eggAddRepository, ClientAddService clientAddService) {
        this.sellsRepository = sellsRepository;
        this.modelMapper = modelMapper;
        this.sellsServiceModel = sellsServiceModel;
        this.eggServiceModel = eggServiceModel;
        this.eggAddService = eggAddService;
        this.eggAddRepository = eggAddRepository;
        this.clientAddService = clientAddService;
    }

    @Override
    public void addSell(SellsServiceModel sellsServiceModel) {
        Sells sells = modelMapper.map(sellsServiceModel, Sells.class);
        sells.setBase(sellsServiceModel.getBase());
        sells.setCartons(sellsServiceModel.getCartons());
        sells.setEgg(sellsServiceModel.getEgg());
        sells.setCountOfEgg(sellsServiceModel.getCountOfEgg());
        sells.setAddDate(sellsServiceModel.getAddDate());
        sells.setClient(clientAddService.findByClientName(sellsServiceModel.getBulstat()));
        sells.setPrice(sellsServiceModel.getPrice());

        System.out.println();

        //Намаляне на бройката на яйцата след направена продажба
        Egg egg = modelMapper.map(eggServiceModel, Egg.class);
        egg.setEgg(sellsServiceModel.getEgg());
        egg.setCartons(sellsServiceModel.getCartons());
        egg.setBase(sellsServiceModel.getBase());
        LocalDate date = LocalDate.now();
        egg.setAddDate(date);

        Long sellCount = sellsServiceModel.getCountOfEgg();

        int  isZero = 1;

        // Base LOWER
        if(egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_20)){

            Long countOfCorey20FromLowerBase = eggAddService.findByCategoryXLLower();

            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            egg.setCountOfEgg(-sellCount);

        }else if(egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_120)){

            Long countOfCorey20FromLowerBase = eggAddService.findByCategoryXLCartonsLower();
            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            egg.setCountOfEgg(countOfCorey20FromLowerBase - sellCount);

        } else if(egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30)
                && egg.getEgg().equals(CategoryEggEnum.L)){

            Long countOfCorey20FromLowerBase = eggAddService.findByCategoryLCoreyLower();
            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            egg.setCountOfEgg(-sellCount);

        } else if(egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180)
                && egg.getEgg().equals(CategoryEggEnum.L)){

            Long countOfCorey20FromLowerBase = eggAddService.findByCategoryLCartonLower();
            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            egg.setCountOfEgg(-sellCount);

        } else if(egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30)
                && egg.getEgg().equals(CategoryEggEnum.M)){

            Long countOfCorey20FromLowerBase = eggAddService.findByCategoryMCoreyLower();
            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            egg.setCountOfEgg(-sellCount);

        } else if(egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180)
                && egg.getEgg().equals(CategoryEggEnum.M)){

            Long countOfCorey20FromLowerBase = eggAddService.findByCategoryMCartonLower();
            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            egg.setCountOfEgg(-sellCount);

        } else if(egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30)
                && egg.getEgg().equals(CategoryEggEnum.S)){

            Long countOfCorey20FromLowerBase = eggAddService.findByCategorySCoreyLower();
            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            egg.setCountOfEgg(-sellCount);

        } else if(egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180)
                && egg.getEgg().equals(CategoryEggEnum.S)){

            Long countOfCorey20FromLowerBase = eggAddService.findByCategorySCartonLower();
            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            egg.setCountOfEgg(-sellCount);

        } else if(egg.getBase().equals(CategoryBaseEnum.LOWER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30)
                && egg.getEgg().equals(CategoryEggEnum.BROKEN)){

            Long countOfCorey20FromLowerBase = eggAddService.findByCategoryBrokenLower();
            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            egg.setCountOfEgg(-sellCount);

        }


        // Base UPPER
        if(egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_20)){

            Long countOfCorey20FromLowerBase = eggAddService.findByCategoryXLLower();

            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            egg.setCountOfEgg(countOfCorey20FromLowerBase - sellCount);

        }else if(egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_120)){

            Long countOfCorey20FromLowerBase = eggAddService.findByCategoryXLCartonsLower();
            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            egg.setCountOfEgg(-sellCount);

        } else if(egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30)
                && egg.getEgg().equals(CategoryEggEnum.L)){

            Long countOfCorey20FromLowerBase = eggAddService.findByCategoryLCoreyLower();
            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            egg.setCountOfEgg(-sellCount);

        } else if(egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180)
                && egg.getEgg().equals(CategoryEggEnum.L)){

            Long countOfCorey20FromLowerBase = eggAddService.findByCategoryLCartonLower();
            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            egg.setCountOfEgg(-sellCount);

        } else if(egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30)
                && egg.getEgg().equals(CategoryEggEnum.M)){

            Long countOfCorey20FromLowerBase = eggAddService.findByCategoryMCoreyLower();
            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            egg.setCountOfEgg(-sellCount);

        } else if(egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180)
                && egg.getEgg().equals(CategoryEggEnum.M)){

            Long countOfCorey20FromLowerBase = eggAddService.findByCategoryMCartonLower();
            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            egg.setCountOfEgg(-sellCount);

        } else if(egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30)
                && egg.getEgg().equals(CategoryEggEnum.S)){

            Long countOfCorey20FromLowerBase = eggAddService.findByCategorySCoreyLower();
            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            egg.setCountOfEgg(-sellCount);

        } else if(egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.CARTONS_180)
                && egg.getEgg().equals(CategoryEggEnum.S)){

            Long countOfCorey20FromLowerBase = eggAddService.findByCategorySCartonLower();
            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            egg.setCountOfEgg(-sellCount);

        } else if(egg.getBase().equals(CategoryBaseEnum.UPPER)
                && egg.getCartons().equals(CategoryCartonsEnum.COREY_30)
                && egg.getEgg().equals(CategoryEggEnum.BROKEN)){

            Long countOfCorey20FromLowerBase = eggAddService.findByCategoryBrokenLower();
            if(countOfCorey20FromLowerBase == 0){
                isZero = 0;
            }
            egg.setCountOfEgg(-sellCount);

        }
        System.out.println();

        if(isZero == 1) {
            eggAddRepository.save(egg);
            sellsRepository.save(sells);
        }

    }

    @Override
    public List<Sells> findLastSellsByDate(LocalDate now) {
        return sellsRepository.findByAddDateOrderByAddDateDesc(LocalDate.now());
    }

    @Override
    public List<SellsViewModel> getAllSells() {
        List<Sells> sells = sellsRepository.findAll();
        return sells.stream().map(sell -> modelMapper.map(sell, SellsViewModel.class)).collect(Collectors.toList());
    }



}
