package ua.home.telegrameservice.service.covidapi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.home.telegrameservice.config.consts.covid.CovidConst;
import ua.home.telegrameservice.model.covid.City;
import ua.home.telegrameservice.model.covid.Country;
import ua.home.telegrameservice.service.covidapi.CovidService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author azatvornitskiy
 * @since 2020-11-05
 */
@Service
public class CovidServiceImpl implements CovidService
{

    @Autowired
    private final RestTemplate restTemplate;

    public CovidServiceImpl(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    @Override
    public City getGovCovidInfoForCity(String city)
    {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CovidConst.DATE_PATTERN);
        final String todayDate = simpleDateFormat.format(new Date());

        ResponseEntity<Country> covidStatusResponse = restTemplate.exchange(
                String.format(CovidConst.API_COVID_URL, todayDate),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Country>()
                {
                }
        );

        return getCityCovidInformation(covidStatusResponse.getBody(), city);

    }

    private City getCityCovidInformation(final Country countryInformation, final String cityName)
    {
        return countryInformation.getCities().stream()
                .filter(city -> city.getLabel().getEn().equals(cityName))
                .findFirst()
                .get();
    }
}
