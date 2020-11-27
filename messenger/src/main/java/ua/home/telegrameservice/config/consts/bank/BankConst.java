package ua.home.telegrameservice.config.consts.bank;

public interface BankConst
{
    String API_BANKURL = "https://api.privatbank.ua/p24api/pubinfo?exchange&json&coursid=";
    Integer CURRENCY_CODE = 11;
    String BANK_CCY = "USD";
    String CURRENCY_MESSAGE_STATISTIC = "\uD83D\uDCB1 <b>Currency rate for today</b> \uD83D\uDCB5\uD83D\uDCB5\uD83D\uDCB5 %0D%0A" +
                                        " <b>Currency</b>: \"{0}\"; %0D%0A" +
                                        " <b>Buy rate</b>: \"{1}\"; %0D%0A" +
                                        " <b>Sell rate</b>: \"{2}\"; %0D%0A";
}
