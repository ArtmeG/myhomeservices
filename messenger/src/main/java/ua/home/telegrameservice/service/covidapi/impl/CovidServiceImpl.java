package ua.home.telegrameservice.service.covidapi.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.home.telegrameservice.config.consts.covid.CovidConst;
import ua.home.telegrameservice.model.covid.City;
import ua.home.telegrameservice.model.covid.Country;
import ua.home.telegrameservice.service.covidapi.CovidService;
import ua.home.telegrameservice.utils.rest.RestTemplateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author azatvornitskiy
 * @since 2020-11-05
 */
@Service
public class CovidServiceImpl extends RestTemplateUtil implements CovidService
{
    public CovidServiceImpl(RestTemplate restTemplate)
    {
        super(restTemplate);
    }

    @Override
    public City getGovCovidInfoForCity(String city)
    {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CovidConst.DATE_PATTERN);
        final String todayDate = simpleDateFormat.format(new Date());

        return getCityCovidInformation(getDataFromGetApi(
                        String.format(CovidConst.API_COVID_URL, todayDate),
                        new ParameterizedTypeReference<Country>(){}
                    ),
                    city
        );
    }

    @Override
    public Country getCovidInfoForCountry()
    {
        return getDataFromGetApi(
                CovidConst.API_COUNTRY_COVID_URL,
                new ParameterizedTypeReference<Country>(){}
        );
    }

    private City getCityCovidInformation(final Country countryInformation, final String cityName)
    {
        return countryInformation.getCities().stream()
                .filter(city -> city.getLabel().getEn().equals(cityName))
                .findFirst()
                .get();
    }
}
