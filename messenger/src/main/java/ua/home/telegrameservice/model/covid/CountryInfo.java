package ua.home.telegrameservice.model.covid;

import lombok.Data;

/**
 * @author azatvornitskiy
 * @since 2020-11-05
 */
@Data
public class CountryInfo
{
    private String country;
    private int cases;
    private int todayCases;
    private int deaths;
    private int todayDeaths;
    private int recovered;
    private int active;
    private int critical;
    private int casesPerOneMillion;
    private int deathsPerOneMillion;
    private int totalTests;
    private int testsPerOneMillion;
}
