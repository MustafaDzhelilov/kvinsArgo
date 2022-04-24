package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.Hale;
import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;
import com.example.projectsoftuni.model.service.HensServiceModel;
import com.example.projectsoftuni.repository.HensAddRepository;
import com.example.projectsoftuni.service.HensAddService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Service
public class HensAddServiceImpl implements HensAddService {

    private final HensAddRepository hensAddRepository;
    private final ModelMapper modelMapper;
    private final HensServiceModel hensServiceModel;

    public HensAddServiceImpl(HensAddRepository hensAddRepository, ModelMapper modelMapper, HensServiceModel hensServiceModel) {
        this.hensAddRepository = hensAddRepository;
        this.modelMapper = modelMapper;
        this.hensServiceModel = hensServiceModel;
    }


    @Override
    public void add(HensServiceModel hensServiceModel) {
        Hale hale = modelMapper.map(hensServiceModel, Hale.class);
        hale.setHale(hensServiceModel.getHale());
        hale.setCountOfDelHens(0L);

        hensAddRepository.save(hale);
    }

    @Override
    public Long getCountOfHensFirst() {
        return hensAddRepository.findAllByHale(CategoryHaleEnum.FIRST)
                .stream().map(Hale::getCountOfHens).reduce(Long::sum).orElse(0L);
    }

   @Override
   public Long getCountOfDelHensFirst() {
       return hensAddRepository.findAllByHale(CategoryHaleEnum.FIRST)
               .stream().map(Hale::getCountOfDelHens).reduce(Long::sum).orElse(0L);
   }

    @Override
    public Long getCountOfHensSecond() {
        return hensAddRepository.findAllByHale(CategoryHaleEnum.SECOND)
                .stream().map(Hale::getCountOfHens).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountOfHensThird() {
        return hensAddRepository.findAllByHale(CategoryHaleEnum.THIRD)
                .stream().map(Hale::getCountOfHens).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountOfHensFourth() {
        return hensAddRepository.findAllByHale(CategoryHaleEnum.FOURTH)
                .stream().map(Hale::getCountOfHens).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountOfHensFifth() {
        return hensAddRepository.findAllByHale(CategoryHaleEnum.FIFTH)
                .stream().map(Hale::getCountOfHens).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountOfHensSixth() {
        return hensAddRepository.findAllByHale(CategoryHaleEnum.SIXTH)
                .stream().map(Hale::getCountOfHens).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountOfHensSeventh() {
        return hensAddRepository.findAllByHale(CategoryHaleEnum.SEVENTH)
                .stream().map(Hale::getCountOfHens).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountOfHensEighth() {
        return hensAddRepository.findAllByHale(CategoryHaleEnum.EIGHTH)
                .stream().map(Hale::getCountOfHens).reduce(Long::sum).orElse(0L);
    }

    @Override
    public Long getCountOfHensNinth() {
        return hensAddRepository.findAllByHale(CategoryHaleEnum.NINTH)
                .stream().map(Hale::getCountOfHens).reduce(Long::sum).orElse(0L);
    }

    @Override
    public void delete(HensServiceModel hensServiceModel) {
        Hale hale = modelMapper.map(hensServiceModel, Hale.class);

        hale.setHale(hensServiceModel.getHale());

        if(hale.getHale().equals(CategoryHaleEnum.FIRST)){
            hale.setCountOfHens(getCountOfHnesFirstLast() - hensServiceModel.getCountOfDelHens());
        }else if(hale.getHale().equals(CategoryHaleEnum.SECOND)){
            hale.setCountOfHens(getCountOfHensSecondLast() - hensServiceModel.getCountOfDelHens());
        }else if(hale.getHale().equals(CategoryHaleEnum.THIRD)){
            hale.setCountOfHens(getCountOfHensThirdLast() - hensServiceModel.getCountOfDelHens());
        }else if(hale.getHale().equals(CategoryHaleEnum.FOURTH)){
            hale.setCountOfHens(getCountOfHensFourthLast() - hensServiceModel.getCountOfDelHens());
        }else if(hale.getHale().equals(CategoryHaleEnum.FIFTH)){
            hale.setCountOfHens(getCountOfHensFifthLast() - hensServiceModel.getCountOfDelHens());
        }else if(hale.getHale().equals(CategoryHaleEnum.SIXTH)){
            hale.setCountOfHens(getCountOfHensSixthLast() - hensServiceModel.getCountOfDelHens());
        }else if(hale.getHale().equals(CategoryHaleEnum.SEVENTH)){
            hale.setCountOfHens(getCountOfHensSeventhLast() - hensServiceModel.getCountOfDelHens());
        }else if(hale.getHale().equals(CategoryHaleEnum.EIGHTH)){
            hale.setCountOfHens(getCountOfHensEighthLast() - hensServiceModel.getCountOfDelHens());
        }else if(hale.getHale().equals(CategoryHaleEnum.NINTH)){
            hale.setCountOfHens(getCountOfHensNinthLast() - hensServiceModel.getCountOfDelHens());
        }

        hensAddRepository.save(hale);
    }


    @Override
    public Long getCountOfHnesFirstLast() {
        return hensAddRepository.findLastOrderByHale(CategoryHaleEnum.FIRST)
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensSecondLast() {
        return hensAddRepository.findLastOrderByHale(CategoryHaleEnum.SECOND)
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensThirdLast() {
        return hensAddRepository.findLastOrderByHale(CategoryHaleEnum.THIRD)
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensFourthLast() {
        return hensAddRepository.findLastOrderByHale(CategoryHaleEnum.FOURTH)
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensFifthLast() {
        return hensAddRepository.findLastOrderByHale(CategoryHaleEnum.FIFTH)
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensSixthLast() {
        return hensAddRepository.findLastOrderByHale(CategoryHaleEnum.SIXTH)
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensSeventhLast() {
        return hensAddRepository.findLastOrderByHale(CategoryHaleEnum.SEVENTH)
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensEighthLast() {
        return hensAddRepository.findLastOrderByHale(CategoryHaleEnum.EIGHTH)
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensNinthLast() {
        return hensAddRepository.findLastOrderByHale(CategoryHaleEnum.NINTH)
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    ////За броя на кокошките от Първо хале от текущия ден
    @Override
    public Long getCountOfHensFirstAboutCurrentDay() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.FIRST, LocalDate.now())
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }
    //от текущия ден -1
    @Override
    public Long getCountOfHensFirstAboutCurrentDayMinusOne() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.FIRST, LocalDate.now().minusDays(1))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }
    //от текущия ден -2
    @Override
    public Long getCountOfHensFirstAboutCurrentDayMinusTwo() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.FIRST, LocalDate.now().minusDays(2))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    //от текущия ден -3
    @Override
    public Long getCountOfHensFirstAboutCurrentDayMinusThree() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.FIRST, LocalDate.now().minusDays(3))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    //от текущия ден -4
    @Override
    public Long getCountOfHensFirstAboutCurrentDayMinusFourth() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.FIRST, LocalDate.now().minusDays(4))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    //от текущия ден -5
    @Override
    public Long getCountOfHensFirstAboutCurrentDayMinusFive() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.FIRST, LocalDate.now().minusDays(5))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    //от текущия ден -6
    @Override
    public Long getCountOfHensFirstAboutCurrentDayMinusSix() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.FIRST, LocalDate.now().minusDays(6))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    //от текущия ден -7
    @Override
    public Long getCountOfHensFirstAboutCurrentDayMinusSeven() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.FIRST, LocalDate.now().minusDays(7))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    //За броя на кокошките от Второ хале от текущия ден
    @Override
    public Long getCountOfHensSecondAboutCurrentDay() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.SECOND, LocalDate.now())
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensSecondAboutCurrentDayMinusOne() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.SECOND, LocalDate.now().minusDays(1))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensSecondAboutCurrentDayMinusTwo() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.SECOND, LocalDate.now().minusDays(2))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensSecondAboutCurrentDayMinusThree() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.SECOND, LocalDate.now().minusDays(3))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensSecondAboutCurrentDayMinusFourth() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.SECOND, LocalDate.now().minusDays(4))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensSecondAboutCurrentDayMinusFive() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.SECOND, LocalDate.now().minusDays(5))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensSecondAboutCurrentDayMinusSix() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.SECOND, LocalDate.now().minusDays(6))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensSecondAboutCurrentDayMinusSeven() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.SECOND, LocalDate.now().minusDays(7))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    //За броя на кокошките от Трето хале от текущия ден
    @Override
    public Long getCountOfHensThirdAboutCurrentDay() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.THIRD, LocalDate.now())
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensThirdAboutCurrentDayMinusOne() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.THIRD, LocalDate.now().minusDays(1))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensThirdAboutCurrentDayMinusTwo() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.THIRD, LocalDate.now().minusDays(2))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensThirdAboutCurrentDayMinusThree() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.THIRD, LocalDate.now().minusDays(3))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensThirdAboutCurrentDayMinusFourth() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.THIRD, LocalDate.now().minusDays(4))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensThirdAboutCurrentDayMinusFive() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.THIRD, LocalDate.now().minusDays(5))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensThirdAboutCurrentDayMinusSix() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.THIRD, LocalDate.now().minusDays(6))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensThirdAboutCurrentDayMinusSeven() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.THIRD, LocalDate.now().minusDays(7))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    //За броя на кокошките от Четвърто хале от текущия ден
    @Override
    public Long getCountOfHensFourthAboutCurrentDay() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.FOURTH, LocalDate.now())
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensFourthAboutCurrentDayMinusOne() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.FOURTH, LocalDate.now().minusDays(1))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensFourthAboutCurrentDayMinusTwo() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.FOURTH, LocalDate.now().minusDays(2))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensFourthAboutCurrentDayMinusThree() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.FOURTH, LocalDate.now().minusDays(3))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensFourthAboutCurrentDayMinusFourth() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.FOURTH, LocalDate.now().minusDays(4))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensFourthAboutCurrentDayMinusFive() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.FOURTH, LocalDate.now().minusDays(5))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensFourthAboutCurrentDayMinusSix() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.FOURTH, LocalDate.now().minusDays(6))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensFourthAboutCurrentDayMinusSeven() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.FOURTH, LocalDate.now().minusDays(7))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    //За броя на кокошките от Пето хале от текущия ден
    @Override
    public Long getCountOfHensFiveAboutCurrentDay() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.FIFTH, LocalDate.now())
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensFiveAboutCurrentDayMinusOne() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.FIFTH, LocalDate.now().minusDays(1))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensFiveAboutCurrentDayMinusTwo() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.FIFTH, LocalDate.now().minusDays(2))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensFiveAboutCurrentDayMinusThree() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.FIFTH, LocalDate.now().minusDays(3))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensFiveAboutCurrentDayMinusFourth() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.FIFTH, LocalDate.now().minusDays(4))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensFiveAboutCurrentDayMinusFive() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.FIFTH, LocalDate.now().minusDays(5))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensFiveAboutCurrentDayMinusSix() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.FIFTH, LocalDate.now().minusDays(6))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensFiveAboutCurrentDayMinusSeven() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.FIFTH, LocalDate.now().minusDays(7))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    //За броя на кокошките от Шесто хале от текущия ден
    @Override
    public Long getCountOfHensSixAboutCurrentDay() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.SIXTH, LocalDate.now())
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensSixAboutCurrentDayMinusOne() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.SIXTH, LocalDate.now().minusDays(1))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensSixAboutCurrentDayMinusTwo() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.SIXTH, LocalDate.now().minusDays(2))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensSixAboutCurrentDayMinusThree() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.SIXTH, LocalDate.now().minusDays(3))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensSixAboutCurrentDayMinusFourth() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.SIXTH, LocalDate.now().minusDays(4))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensSixAboutCurrentDayMinusFive() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.SIXTH, LocalDate.now().minusDays(5))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensSixAboutCurrentDayMinusSix() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.SIXTH, LocalDate.now().minusDays(6))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensSixAboutCurrentDayMinusSeven() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.SIXTH, LocalDate.now().minusDays(7))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    //За броя на кокошките от Седмо хале от текущия ден
    @Override
    public Long getCountOfHensSevenAboutCurrentDay() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.SEVENTH, LocalDate.now())
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensSevenAboutCurrentDayMinusOne() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.SEVENTH, LocalDate.now().minusDays(1))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensSevenAboutCurrentDayMinusTwo() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.SEVENTH, LocalDate.now().minusDays(2))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensSevenAboutCurrentDayMinusThree() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.SEVENTH, LocalDate.now().minusDays(3))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensSevenAboutCurrentDayMinusFourth() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.SEVENTH, LocalDate.now().minusDays(4))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensSevenAboutCurrentDayMinusFive() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.SEVENTH, LocalDate.now().minusDays(5))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensSevenAboutCurrentDayMinusSix() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.SEVENTH, LocalDate.now().minusDays(6))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensSevenAboutCurrentDayMinusSeven() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.SEVENTH, LocalDate.now().minusDays(7))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    //За броя на кокошките от Осмо хале от текущия ден
    @Override
    public Long getCountOfHensEightAboutCurrentDay() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.EIGHTH, LocalDate.now())
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensEightAboutCurrentDayMinusOne() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.EIGHTH, LocalDate.now().minusDays(1))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensEightAboutCurrentDayMinusTwo() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.EIGHTH, LocalDate.now().minusDays(2))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensEightAboutCurrentDayMinusThree() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.EIGHTH, LocalDate.now().minusDays(3))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensEightAboutCurrentDayMinusFourth() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.EIGHTH, LocalDate.now().minusDays(4))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensEightAboutCurrentDayMinusFive() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.EIGHTH, LocalDate.now().minusDays(5))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensEightAboutCurrentDayMinusSix() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.EIGHTH, LocalDate.now().minusDays(6))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensEightAboutCurrentDayMinusSeven() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.EIGHTH, LocalDate.now().minusDays(7))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    //За броя на кокошките от Девето хале от текущия ден
    @Override
    public Long getCountOfHensNinthAboutCurrentDay() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.NINTH, LocalDate.now())
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensNinthAboutCurrentDayMinusOne() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.NINTH, LocalDate.now().minusDays(1))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensNinthAboutCurrentDayMinusTwo() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.NINTH, LocalDate.now().minusDays(2))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensNinthAboutCurrentDayMinusThree() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.NINTH, LocalDate.now().minusDays(3))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensNinthAboutCurrentDayMinusFourth() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.NINTH, LocalDate.now().minusDays(4))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensNinthAboutCurrentDayMinusFive() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.NINTH, LocalDate.now().minusDays(5))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensNinthAboutCurrentDayMinusSix() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.NINTH, LocalDate.now().minusDays(6))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }

    @Override
    public Long getCountOfHensNinthAboutCurrentDayMinusSeven() {
        return hensAddRepository.findLastOrderByHaleAndCreated(CategoryHaleEnum.NINTH, LocalDate.now().minusDays(7))
                .stream().map(Hale::getCountOfHens).reduce(Long::min).orElse(0L);
    }


}
