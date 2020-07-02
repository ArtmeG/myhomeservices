package com.example.demo.facade.currency;

import com.example.demo.config.consts.bank.BankUrls;
import com.example.demo.messagesender.telegram.TelegramMessanger;
import com.example.demo.model.bank.CurrencyDto;
import com.example.demo.service.bankapi.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrencyFacade
{
    @Autowired
    private TelegramMessanger telegramMessanger;

    @Autowired
    IBankService iBankService;

    public void getCurrencyRate(){
        final CurrencyDto currencyDto = iBankService.getCurrencyExchangeRateForCoursid(BankUrls.CURRENCY_CODE);

        telegramMessanger.sendMessage(String.format("Currency rate for today %s", currencyDto.toString()));
        System.out.println("Log");
    }
}
