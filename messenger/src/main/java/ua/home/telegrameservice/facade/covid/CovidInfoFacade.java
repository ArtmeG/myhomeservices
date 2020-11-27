package ua.home.telegrameservice.facade.covid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.home.telegrameservice.config.consts.covid.CovidConst;
import ua.home.telegrameservice.messagesender.telegram.TelegramMessanger;
import ua.home.telegrameservice.model.covid.City;
import ua.home.telegrameservice.model.covid.Country;
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
        final StringBuilder covidMessageBuilder = new StringBuilder();

        final City cheCity = covidService.getGovCovidInfoForCity(CITY_CHERNIGIV);
        final Country countryInfo = covidService.getCovidInfoForCountry();

        covidMessageBuilder.append(MessageFormat.format(
                CovidConst.COVID_CITY_MESSAGE_TEMPLATE_RU,
                CITY_CHERNIGIV,
                cheCity.getConfirmed(), cheCity.getDeltaConfirmed(),
                cheCity.getDeaths(), cheCity.getDeltaDeaths(),
                cheCity.getRecovered(), cheCity.getDeltaRecovered()
        ));

        covidMessageBuilder.append(MessageFormat.format(
                CovidConst.COVID_COUNTRY_MESSAGE_TEMPLATE_RU,
                countryInfo.getCountry(),
                countryInfo.getCases(), countryInfo.getTodayCases(),
                countryInfo.getDeaths(), countryInfo.getTodayDeaths(),
                countryInfo.getRecovered()
        ));

        covidMessageBuilder.append(CovidConst.BASE_INFO_SITE);

        telegramMessanger.sendMessage(covidMessageBuilder.toString());
    }

}
