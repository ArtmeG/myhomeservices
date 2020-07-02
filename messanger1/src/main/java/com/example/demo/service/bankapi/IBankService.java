package com.example.demo.service.bankapi;

import com.example.demo.model.bank.CurrencyDto;

public interface IBankService {


    CurrencyDto getCurrencyExchangeRateForCoursid(Integer coursid);

}
