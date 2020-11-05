package ua.home.telegrameservice.utils.sheduler;

import ua.home.telegrameservice.facade.covid.CovidInfoFacade;
import ua.home.telegrameservice.facade.currency.CurrencyFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask
{


    @Autowired
    CurrencyFacade currencyFacade;

    @Autowired
    CovidInfoFacade covidInfoFacade;

    @Scheduled(cron = "0 0 8,20 ? * * ")
    public void reportCurrentTime()
    {
        currencyFacade.getCurrencyRate();
        covidInfoFacade.getCovidInfo();
    }
}
