package ua.home.telegrameservice.facade.currency;

import ua.home.telegrameservice.config.consts.bank.BankConst;
import ua.home.telegrameservice.messagesender.telegram.TelegramMessanger;
import ua.home.telegrameservice.model.bank.CurrencyDto;
import ua.home.telegrameservice.service.bankapi.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class CurrencyFacade
{
    @Autowired
    private TelegramMessanger telegramMessanger;

    @Autowired
    BankService bankService;

    public void getCurrencyRate()
    {
        final CurrencyDto currencyDto = bankService.getCurrencyExchangeRateForCoursid(BankConst.CURRENCY_CODE);

        telegramMessanger.sendMessage(
                MessageFormat.format(
                        BankConst.CURRENCY_MESSAGE_STATISTIC,
                        currencyDto.getCcy(),
                        currencyDto.getBuy(),
                        currencyDto.getSale()
                )
        );
    }
}
