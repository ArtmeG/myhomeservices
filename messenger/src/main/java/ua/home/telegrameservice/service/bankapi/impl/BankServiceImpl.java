package ua.home.telegrameservice.service.bankapi.impl;

import ua.home.telegrameservice.config.consts.bank.BankConst;
import ua.home.telegrameservice.model.bank.CurrencyDto;
import ua.home.telegrameservice.service.bankapi.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import ua.home.telegrameservice.utils.rest.RestTemplateUtil;

import java.util.List;
import java.util.Objects;

@Service
public class BankServiceImpl extends RestTemplateUtil implements BankService
{

    private static final Logger LOG = LoggerFactory.getLogger(BankServiceImpl.class);

    public BankServiceImpl(RestTemplate restTemplate)
    {
        super(restTemplate);
    }

    //Безналичный курс ПриватБанка (конвертация по картам, Приват24, пополнение вкладов):
    @Override
    public CurrencyDto getCurrencyExchangeRateForCoursid(Integer coursid)
    {
        try
        {
            return getUsaCurrencyRate(Objects.requireNonNull(
                            getDataFromGetApi(BankConst.API_BANKURL.concat(coursid.toString()),
                                    new ParameterizedTypeReference<List<CurrencyDto>>(){}
                            )
                    )
            );

        } catch (RestClientException ex)
        {
            LOG.error("Unable to call {s}", BankConst.API_BANKURL);
        }

        return new CurrencyDto();
    }

    private CurrencyDto getUsaCurrencyRate(List<CurrencyDto> currencyRatesList)
    {

        for (CurrencyDto currencyDto : currencyRatesList)
        {
            if (currencyDto.getCcy().equals(BankConst.BANK_CCY))
            {
                return currencyDto;
            }
        }
        return null;
    }

}
