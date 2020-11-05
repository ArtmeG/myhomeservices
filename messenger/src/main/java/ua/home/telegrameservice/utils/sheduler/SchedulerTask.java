package ua.home.telegrameservice.utils.sheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.home.telegrameservice.facade.covid.CovidInfoFacade;
import ua.home.telegrameservice.facade.currency.CurrencyFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask
{
    private static final Logger LOG = LoggerFactory.getLogger(SchedulerTask.class);

    @Autowired
    CurrencyFacade currencyFacade;

    @Autowired
    CovidInfoFacade covidInfoFacade;

    @Scheduled(cron = "0 0 8,20 ? * * ")
    public void reportCurrentTime()
    {
        try
        {
            LOG.info("Getting currency information");
            currencyFacade.getCurrencyRate();
        } catch (Exception ex)
        {
            LOG.error("Exception during getting currency info");
        }

        try
        {
            LOG.info("Getting COVID-19 information");
            covidInfoFacade.getCovidInfo();
        } catch (Exception ex)
        {
            LOG.error("Exception during getting COVID-19 info");
        }
    }
}
