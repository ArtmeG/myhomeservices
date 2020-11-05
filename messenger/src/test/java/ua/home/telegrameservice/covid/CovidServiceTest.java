package ua.home.telegrameservice.covid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.home.telegrameservice.model.covid.City;
import ua.home.telegrameservice.service.covidapi.CovidService;

import static org.junit.Assert.assertEquals;
import static ua.home.telegrameservice.config.consts.covid.CovidConst.CITY_CHERNIGIV;

/**
 *
 * @author azatvornitskiy
 * @since 2020-11-05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CovidServiceTest
{
    @Autowired
    CovidService covidService;

    @Test
    public void expectedCovidStatisticSuccessful()
    {
        final City cheCity = covidService.getGovCovidInfoForCity(CITY_CHERNIGIV);

        assertEquals(CITY_CHERNIGIV, cheCity.getLabel().getEn());
    }
}
