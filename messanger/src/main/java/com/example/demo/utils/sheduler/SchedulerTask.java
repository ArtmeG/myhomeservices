package com.example.demo.utils.sheduler;

import com.example.demo.facade.currency.CurrencyFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {


    @Autowired
    CurrencyFacade currencyFacade;

    @Scheduled(cron = "0 0 8,20 ? * * ")
    public void reportCurrentTime() {
        currencyFacade.getCurrencyRate();
    }
}
