package com.rudineibrito.apiObserver.services;

import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@EnableScheduling
public class ScheduledTasks {

    ApiRequest apiRequestTemplate = new ApiRequest();
    EmailService emailService = new EmailService();

    @Scheduled(fixedDelay = 60 * 60000)
    public void testApis() {
        if(apiRequestTemplate.sendRequest() != HttpStatus.OK) {
            System.out.println("error");
            emailService.sendEmail("rudineidebrito18@gmail.com", "Rudinei", "hello world!");
        } else {
            System.out.println("ok");
        }
    }
}
