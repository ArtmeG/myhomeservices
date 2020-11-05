package ua.home.telegrameservice.facade.covid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.home.telegrameservice.config.consts.covid.CovidConst;
import ua.home.telegrameservice.messagesender.telegram.TelegramMessanger;
import ua.home.telegrameservice.model.covid.City;
import ua.home.telegrameservice.service.covidapi.CovidService;

import java.text.MessageFormat;

import static ua.home.telegrameservice.config.consts.covid.CovidConst.CITY_CHERNIGIV;

/**
 * @author azatvornitskiy
 * @since 2020-11-05
 */
@Component
public class CovidInfoFacade
{

    @Autowired
    private TelegramMessanger telegramMessanger;

    @Autowired
    private CovidService covidService;

    public void getCovidInfo()
    {
        final City cheCity = covidService.getGovCovidInfoForCity(CITY_CHERNIGIV);

        telegramMessanger.sendMessage ( MessageFormat.format(
                CovidConst.COVID_MESSAGE_TEMPLATE,
                CITY_CHERNIGIV,
                cheCity.getConfirmed(), cheCity.getDelta_confirmed(),
                cheCity.getDeaths(), cheCity.getDelta_deaths(),
                cheCity.getRecovered(), cheCity.getDelta_recovered()
                ));
    }

}
