package ua.home.telegrameservice.service.covidapi.impl;

import org.apache.commons.lang.time.DateUtils;
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
import java.util.Objects;

import static ua.home.telegrameservice.utils.date.DateUtils.getFormattedDate;

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
    public City getGovCovidInfoForCity(String cityName)
    {
        final String todayDate = getFormattedDate(new Date());

        final City cityStatistics = getCityCovidInformation(getDataFromGetApi(
                String.format(CovidConst.API_COVID_URL, todayDate),
                new ParameterizedTypeReference<Country>()
                {
                }
                ),
                cityName
        );

        calculateDelta(cityStatistics, cityName);

        return cityStatistics;
    }

    @Override
    public Country getCovidInfoForCountry()
    {
        return getDataFromGetApi(
                CovidConst.API_COUNTRY_COVID_URL,
                new ParameterizedTypeReference<Country>()
                {
                }
        );
    }

    private City getCityCovidInformation(final Country countryInformation, final String cityName)
    {
        return countryInformation.getCities().stream()
                .filter(city -> city.getLabel().getEn().equals(cityName))
                .findFirst()
                .get();
    }

    private void calculateDelta(final City cityStatistics, String cityName)
    {

        if (Objects.isNull(cityStatistics.getDeltaConfirmed()) || cityStatistics.getDeltaConfirmed().compareTo(0) == 0)
        {
            final String yesterdayDay =  getFormattedDate( DateUtils.addDays(new Date(), -1));

            final City cityStatisticsForYesterday = getCityCovidInformation(getDataFromGetApi(
                    String.format(CovidConst.API_COVID_URL, yesterdayDay),
                    new ParameterizedTypeReference<Country>()
                    {
                    }
                    ),
                    cityName
            );

            if (Objects.nonNull(cityStatisticsForYesterday.getConfirmed()) || cityStatisticsForYesterday.getConfirmed().compareTo(new Integer(0)) != 0)
            {
                cityStatistics.setDeltaConfirmed(
                        cityStatistics.getConfirmed() - cityStatisticsForYesterday.getConfirmed()
                );
            }

            if (Objects.nonNull(cityStatisticsForYesterday.getDeaths()) || cityStatisticsForYesterday.getDeaths().compareTo(new Integer(0)) != 0)
            {
                cityStatistics.setDeltaDeaths(
                        cityStatistics.getDeaths() - cityStatisticsForYesterday.getDeaths()
                );
            }

            if (Objects.nonNull(cityStatisticsForYesterday.getRecovered()) || cityStatisticsForYesterday.getRecovered().compareTo(new Integer(0)) != 0)
            {
                cityStatistics.setDeltaRecovered(
                        cityStatistics.getRecovered() - cityStatisticsForYesterday.getRecovered()
                );
            }
        }

    }

}
