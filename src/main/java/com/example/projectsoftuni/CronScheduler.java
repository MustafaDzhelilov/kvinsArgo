package com.example.projectsoftuni;

import com.example.projectsoftuni.service.CartonAddService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronScheduler {

    private final CartonAddService cartonAddService;

    public CronScheduler(CartonAddService cartonAddService) {
        this.cartonAddService = cartonAddService;
    }

    @Scheduled(cron = "* */8 02-03 * * */7")
    public void deleteTopCartonsFromTableCartonsByCartonCategory(){
        cartonAddService.deleteTopCartonsByCartonsCategory();
    }

}
