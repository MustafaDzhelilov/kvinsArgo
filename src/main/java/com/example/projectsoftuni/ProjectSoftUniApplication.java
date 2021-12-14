package com.example.projectsoftuni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProjectSoftUniApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectSoftUniApplication.class, args);
    }

}
