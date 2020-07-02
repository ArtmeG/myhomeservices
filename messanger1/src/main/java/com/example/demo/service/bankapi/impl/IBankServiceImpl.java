package com.example.demo.service.bankapi.impl;

import com.example.demo.config.consts.bank.BankUrls;
import com.example.demo.model.bank.CurrencyDto;
import com.example.demo.service.bankapi.IBankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class IBankServiceImpl implements IBankService {

    private static final Logger LOG = LoggerFactory.getLogger(IBankServiceImpl.class);

    @Autowired
    private final RestTemplate restTemplate;

    public IBankServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //Безналичный курс ПриватБанка (конвертация по картам, Приват24, пополнение вкладов):
    @Override
    public CurrencyDto getCurrencyExchangeRateForCoursid(Integer coursid) {

        try {
            ResponseEntity<List<CurrencyDto>> rateResponse =
                    restTemplate.exchange(BankUrls.API_BANKURL.concat(coursid.toString()),
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<CurrencyDto>>() {
                            });
            List<CurrencyDto> currencyRates = rateResponse.getBody();

            return getUsaCurrencyRate(Objects.requireNonNull(currencyRates));

        } catch (RestClientException ex) {
            LOG.error("Annable to call {s}", BankUrls.API_BANKURL);
        }

        return null;
    }

    private CurrencyDto getUsaCurrencyRate(List<CurrencyDto> currencyRatesList) {

        for (CurrencyDto currencyDto : currencyRatesList) {
            if (currencyDto.getCcy().equals(BankUrls.BANK_CCY)) {
                return  currencyDto;
            }
        }
        return null;
    }

}
