package ua.home.telegrameservice.bank;

import ua.home.telegrameservice.model.bank.CurrencyDto;
import ua.home.telegrameservice.service.bankapi.BankService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankServiceTest
{
    private static final Logger LOG = LoggerFactory.getLogger(BankServiceTest.class);

    @Autowired
    BankService bankServiceImpl;


    @Test
    public void getCurrencyExcageRateTest()
    {
        CurrencyDto currencyDto = bankServiceImpl.getCurrencyExchangeRateForCoursid(11);

        Assert.assertNotNull("Ther currency is null", currencyDto);

    }


    @Test
    public void getCurrencyExcageRateEqaulsToUsaTest()
    {
        CurrencyDto currencyDto = bankServiceImpl.getCurrencyExchangeRateForCoursid(11);

        Assert.assertEquals("The currency is not equals to USD", "USD", currencyDto.getCcy());
        LOG.error(currencyDto.toString());
    }
}
