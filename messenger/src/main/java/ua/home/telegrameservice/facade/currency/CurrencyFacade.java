package ua.home.telegrameservice.facade.currency;

import ua.home.telegrameservice.config.consts.bank.BankUrls;
import ua.home.telegrameservice.messagesender.telegram.TelegramMessanger;
import ua.home.telegrameservice.model.bank.CurrencyDto;
import ua.home.telegrameservice.service.bankapi.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrencyFacade
{
    @Autowired
    private TelegramMessanger telegramMessanger;

    @Autowired
    IBankService iBankService;

    public void getCurrencyRate()
    {
        final CurrencyDto currencyDto = iBankService.getCurrencyExchangeRateForCoursid(BankUrls.CURRENCY_CODE);

        telegramMessanger.sendMessage(String.format("Currency rate for today %s", currencyDto.toString()));
        System.out.println("Log");
    }
}
