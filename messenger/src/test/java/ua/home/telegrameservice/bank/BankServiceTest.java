package ua.home.telegrameservice.bank;

import ua.home.telegrameservice.model.bank.CurrencyDto;
import ua.home.telegrameservice.service.bankapi.IBankService;
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
    IBankService iBankServiceImpl;


    @Test
    public void getCurrencyExcageRateTest()
    {
        CurrencyDto currencyDto = iBankServiceImpl.getCurrencyExchangeRateForCoursid(11);

        Assert.assertTrue("Ther currency is null", currencyDto != null);

    }


    @Test
    public void getCurrencyExcageRateEqaulsToUsaTest()
    {
        CurrencyDto currencyDto = iBankServiceImpl.getCurrencyExchangeRateForCoursid(11);

        Assert.assertTrue("The currency is not equals to USD", currencyDto.getCcy().equals("USD"));
        LOG.error(currencyDto.toString());
    }
}
