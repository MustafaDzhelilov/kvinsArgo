package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.*;
import com.example.projectsoftuni.model.entity.enums.*;
import com.example.projectsoftuni.model.service.*;
import com.example.projectsoftuni.repository.*;
import com.example.projectsoftuni.service.CartonAddService;
import com.example.projectsoftuni.service.EggAddService;
import com.example.projectsoftuni.service.ExportService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class ExportServiceImpl implements ExportService {

    private final EggAddRepository eggAddRepository;
    private final ModelMapper modelMapper;
    private final CartonAddRepository cartonAddRepository;
    private final CartonServiceModel cartonServiceModel;
    private final EggServiceModel eggServiceModel;
    private final ExportRepository exportRepository;
    private final SellsServiceModel sellsServiceModel;
    private final SellsRepository sellsRepository;
    private final EggAddService eggAddService;
    private final CartonAddService cartonAddService;
    private final PalletsServiceModel palletsServiceModel;
    private final PalletsRepository palletsRepository;
    Cartons cartons1;
    Cartons cartons2;
    Long isZero = 0L;
    int count;
    int wrongCorner = 0;
    int wrongCorn;
    int coreyNull = 0;
    int cornerNull = 0;
    int paperNull = 0;
    int eggQuantity = 0;

    public ExportServiceImpl(EggAddRepository eggAddRepository, ModelMapper modelMapper, CartonAddRepository cartonAddRepository, CartonServiceModel cartonServiceModel, EggServiceModel eggServiceModel, ExportRepository exportRepository, SellsServiceModel sellsServiceModel, SellsRepository sellsRepository, EggAddService eggAddService, CartonAddService cartonAddService, PalletsServiceModel palletsServiceModel, PalletsRepository palletsRepository) {
        this.eggAddRepository = eggAddRepository;
        this.modelMapper = modelMapper;
        this.cartonAddRepository = cartonAddRepository;
        this.cartonServiceModel = cartonServiceModel;
        this.eggServiceModel = eggServiceModel;
        this.exportRepository = exportRepository;
        this.sellsServiceModel = sellsServiceModel;
        this.sellsRepository = sellsRepository;
        this.eggAddService = eggAddService;
        this.cartonAddService = cartonAddService;
        this.palletsServiceModel = palletsServiceModel;
        this.palletsRepository = palletsRepository;
    }


    @Override
    public void add(ExportServiceModel exportServiceModel) {

        Export export = modelMapper.map(exportServiceModel, Export.class);
        export.setCategoryBaseEnum(exportServiceModel.getCategoryBaseEnum());
        export.setTypeExportEnum(exportServiceModel.getTypeExportEnum());
        export.setCountPallet(exportServiceModel.getCountPallet());
        export.setDate(exportServiceModel.getDate());
        export.setPalletTypeEnum(exportServiceModel.getPalletTypeEnum());
        export.setClientEnum(exportServiceModel.getClientEnum());
        export.setCategoryEggEnum(exportServiceModel.getCategoryEggEnum());
        export.setCategoryCartonsEnum(exportServiceModel.getCategoryCartonsEnum());
        export.setPrice(export.getPrice());



        Cartons cartons = modelMapper.map(cartonServiceModel, Cartons.class);
        cartons.setBase(exportServiceModel.getCategoryBaseEnum());
        cartons.setCartons(exportServiceModel.getCategoryCartonsEnum());
        cartons.setDate(LocalDateTime.now());

        if(exportServiceModel.getTypeOfCorner() == 1) {
            cartons1 = modelMapper.map(cartonServiceModel, Cartons.class);
            cartons1.setBase(exportServiceModel.getCategoryBaseEnum());
            cartons1.setCartons(CategoryCartonsEnum.PAPER_CORNER_DUN);
            cartons1.setCount(exportServiceModel.getCountPallet() * 4);
            export.setCategoryPaperCornerEnum(CategoryPaperCornerEnum.PAPER_CORNER_DUN);
            cartons1.setDate(LocalDateTime.now());
        }else if(exportServiceModel.getTypeOfCorner() == 2 ){
            cartons1 = modelMapper.map(cartonServiceModel, Cartons.class);
            cartons1.setBase(exportServiceModel.getCategoryBaseEnum());
            cartons1.setCartons(CategoryCartonsEnum.PAPER_CORNER_DSM);
            cartons1.setCount(exportServiceModel.getCountPallet() * 4);
            export.setCategoryPaperCornerEnum(CategoryPaperCornerEnum.PAPER_CORNER_DSM);
            cartons1.setDate(LocalDateTime.now());
        }else{
             wrongCorner = 1;
        }


        if(exportServiceModel.getTypeOfPaper() == 1) {
            cartons2 = modelMapper.map(cartonServiceModel, Cartons.class);
            cartons2.setBase(exportServiceModel.getCategoryBaseEnum());
            cartons2.setCartons(CategoryCartonsEnum.PAPER_SHEET_DUN);
            cartons2.setDate(LocalDateTime.now());
            export.setCategoryPaperSheetEnum(CategoryPaperSheetEnum.PAPER_SHEET_DUN);
        }else if(exportServiceModel.getTypeOfPaper() == 2){
            cartons2 = modelMapper.map(cartonServiceModel, Cartons.class);
            cartons2.setBase(exportServiceModel.getCategoryBaseEnum());
            cartons2.setCartons(CategoryCartonsEnum.PAPER_SHEET_DSM);
            export.setCategoryPaperSheetEnum(CategoryPaperSheetEnum.PAPER_SHEET_DSM);
            cartons2.setDate(LocalDateTime.now());
        }else{
            isZero = 1L;
        }

        Egg egg = modelMapper.map(eggServiceModel, Egg.class);
        egg.setBase(exportServiceModel.getCategoryBaseEnum());
        egg.setCartons(exportServiceModel.getCategoryCartonsEnum());
        egg.setAddDate(exportServiceModel.getDate());
        egg.setEgg(exportServiceModel.getCategoryEggEnum());

        Sells sells = modelMapper.map(sellsServiceModel, Sells.class);
        sells.setAddDate(LocalDateTime.now());
        sells.setBase(exportServiceModel.getCategoryBaseEnum());
        sells.setCartons(exportServiceModel.getCategoryCartonsEnum());
        sells.setClientEnum(exportServiceModel.getClientEnum());
        sells.setCountIssuedPallets(exportServiceModel.getCountPallet());
        sells.setPalletTypeEnum(exportServiceModel.getPalletTypeEnum());
        sells.setEgg(exportServiceModel.getCategoryEggEnum());
        sells.setPrice(exportServiceModel.getPrice());

        Pallets pallets = modelMapper.map(palletsServiceModel, Pallets.class);
        pallets.setCategoryBaseEnum(exportServiceModel.getCategoryBaseEnum());
        pallets.setPalletTypeEnum(exportServiceModel.getPalletTypeEnum());
        pallets.setCount(-exportServiceModel.getCountPallet());
        pallets.setLocalDate(LocalDate.now());


        String exportType = exportServiceModel.getTypeExportEnum().name();
        Long countPallet = exportServiceModel.getCountPallet();

        Long countEgg = 0L;
        Long countCorner = 0L;
        Long countPaper = 0L;
        Long countCorey = 0L ;


        if(exportType.equals("SIXTY")){
            countEgg = countPallet * 10800;
            countPaper = countPallet * 5;
            countCorner = countPallet * 4;
            countCorey = countPallet * 60;
            export.setCountEgg(10800L);
            export.setTotalPrice(10800 * (exportServiceModel.getPrice()));
            sells.setCountOfEgg(10800L);
            sells.setTotalPrice(10800 * (exportServiceModel.getPrice()));
        }else if( exportType.equals("FIFTY_TWO")){
            countEgg = countPallet * 9360;
            countPaper = countPallet * 5;
            countCorner = countPallet * 4;
            countCorey = countPallet * 312;
            export.setCountEgg(9360L);
            export.setTotalPrice(9360 * (exportServiceModel.getPrice()));
            sells.setCountOfEgg(9360L);
            sells.setTotalPrice(9360 * (exportServiceModel.getPrice()));
        }else if(exportType.equals("FIFTY")){
            countEgg = countPallet * 9000;
            countPaper = countPallet * 4;
            countCorner = countPallet * 4;
            countCorey = countPallet * 48;
            export.setCountEgg(9000L);
            export.setTotalPrice(9000 * (exportServiceModel.getPrice()));
            sells.setCountOfEgg(9000L);
            sells.setTotalPrice(9000 * (exportServiceModel.getPrice()));
        }else if( exportType.equals("XL_FIFTY")){
            countEgg = countPallet * 6000;
            countPaper = countPallet * 4;
            countCorner = countPallet * 4;
            countCorner = countPallet * 48;
            export.setCountEgg(6000L);
            export.setTotalPrice(6000 * (exportServiceModel.getPrice()));
            sells.setCountOfEgg(6000L);
            sells.setTotalPrice(6000 * (exportServiceModel.getPrice()));
        }

        if(countCorey < cartonAddService.getCountCartons(cartons.getCartons(), exportServiceModel.getCategoryBaseEnum())){
            coreyNull = 1;
        }else if(countCorner < cartonAddService.getCountCorner(cartons1.getCartons(), exportServiceModel.getCategoryBaseEnum())){
            cornerNull = 1;
        }else if(countPaper < cartonAddService.getCountPaper(cartons2.getCartons(), exportServiceModel.getCategoryBaseEnum())){
            paperNull = 1;
        }else if(countEgg < eggAddService.getCountEgg(exportServiceModel.getCategoryBaseEnum(), exportServiceModel.getCategoryEggEnum(), exportServiceModel.getCategoryCartonsEnum())){
            eggQuantity = 1;
        }


        if(isZero == 0 && wrongCorner == 0) {
            cartons.setCount(-countCorey);
            cartons1.setCount(-countCorner);
            cartons2.setCount(-countPaper);
            egg.setCountOfEgg(-countEgg);
            cartonAddRepository.save(cartons);
            cartonAddRepository.save(cartons1);
            cartonAddRepository.save(cartons2);
            eggAddRepository.save(egg);
            sellsRepository.save(sells);
            exportRepository.save(export);
            palletsRepository.save(pallets);
        }else if(isZero == 1){
            getStatusPaper();
        }else if(wrongCorner == 1){
            getStatusCorner();
        }

    }


    @Override
    public int getStatusPaper() {
        if(isZero == 1){
            count = 1;
        }else{
            count = 0;
        }
        return count;
    }

    @Override
    public int getStatusCorner() {
        if(wrongCorner == 1){
            wrongCorn = 1;
        }else{
            wrongCorn = 0;
        }
        return wrongCorn;
    }

    @Override
    public int getStatusCoreyisNull() {
        if(coreyNull == 1){
            count = 1;
        }else{
            count = 0;
        }
        return count;
    }

    @Override
    public int getStatusCornerisNull() {
        if(cornerNull == 1){
            count = 1;
        }else{
            count = 0;
        }
        return count;
    }


    @Override
    public int getStatusPaperisNull() {
        if(paperNull == 1){
            count = 1;
        }else{
            count = 0;
        }
        return count;
    }


    @Override
    public int getStatusEggNoQuantity() {
        if(eggQuantity == 1){
            count = 1;
        }else{
            count = 0;
        }
        return count;
    }

    @Override
    public Long getReturnedEuroByClient(ClientEnum client, PalletTypeEnum euro) {
        return exportRepository.getAllByClientEnumAndPalletTypeEnum(client, euro).
                stream().map(Export::getCountPallet).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getReturnedPallThermoByClient(ClientEnum client, PalletTypeEnum thermo) {
        return exportRepository.getAllByClientEnumAndPalletTypeEnum(client, thermo).
                stream().map(Export::getCountPallet).reduce(Long::sum).orElse(0L);
    }


}
