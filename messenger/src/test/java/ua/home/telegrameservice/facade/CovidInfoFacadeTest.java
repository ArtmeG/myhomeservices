package ua.home.telegrameservice.facade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.home.telegrameservice.facade.covid.CovidInfoFacade;

/**
 * @author azatvornitskiy
 * @since 2020-11-05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CovidInfoFacadeTest
{

    @Autowired
    CovidInfoFacade covidInfoFacade;

    @Test
    public void sendTestMessage()
    {
        covidInfoFacade.getCovidInfo();
    }

}
