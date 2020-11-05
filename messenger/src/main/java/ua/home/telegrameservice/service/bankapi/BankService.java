package ua.home.telegrameservice.service.bankapi;

import ua.home.telegrameservice.model.bank.CurrencyDto;

public interface BankService
{
    CurrencyDto getCurrencyExchangeRateForCoursid(Integer coursid);
}
