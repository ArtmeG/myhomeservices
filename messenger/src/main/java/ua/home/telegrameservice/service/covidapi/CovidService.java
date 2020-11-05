package ua.home.telegrameservice.service.covidapi;

import ua.home.telegrameservice.model.covid.City;

/**
 * @author azatvornitskiy
 * @since 2020-11-05
 */
public interface CovidService
{
    City getGovCovidInfoForCity(final String city);
}
