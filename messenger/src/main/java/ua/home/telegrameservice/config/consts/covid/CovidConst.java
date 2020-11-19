package ua.home.telegrameservice.config.consts.covid;

/**
 * @author azatvornitskiy
 * @since 2020-11-05
 */
public interface CovidConst
{
    String API_COVID_URL = "https://api-covid19.rnbo.gov.ua/data?to=%s";
    String API_COUNTRY_COVID_URL = "https://coronavirus-19-api.herokuapp.com/countries/ukraine";
    String DATE_PATTERN = "yyyy-MM-dd";
    String CITY_CHERNIGIV = "Chernihivska";
    String COVID_CITY_MESSAGE_TEMPLATE_EN = "%0D%0A " +
                                         "\uD83D\uDC80 <b>COVID-19</b> %0D%0A" +
                                         "<b>Oblast:</b> \"{0}\"  %0D%0A %0D%0A" +
                                         "\uD83D\uDC8A <b>Total cases:</b> \"{1}\" | today: \"{2}\" %0D%0A" +
                                         "\uD83D\uDC80 <b>Total death:</b> \"{3}\" | today: \"{4}\" %0D%0A" +
                                         "\uD83D\uDC4C <b>Total recovery:</b> \"{5}\" | today: \"{6}\" %0D%0A " +
                                         "-------------------------------------------- %0D%0A";

    String COVID_CITY_MESSAGE_TEMPLATE_RU = "%0D%0A " +
                                            "\uD83D\uDC80 <b>COVID-19</b> %0D%0A" +
                                            "<b>Область:</b> \"{0}\"  %0D%0A %0D%0A" +
                                            "\uD83D\uDC8A <b>Всего случаев:</b> \"{1}\" | за сегодня: \"{2}\" %0D%0A" +
                                            "\uD83D\uDC80 <b>Всего смертей:</b> \"{3}\" | за сегодня: \"{4}\" %0D%0A" +
                                            "\uD83D\uDC4C <b>Всего выздоровевших:</b> \"{5}\" | за сегодня: \"{6}\" %0D%0A " +
                                            "-------------------------------------------- %0D%0A";

    String COVID_COUNTRY_MESSAGE_TEMPLATE_EN = "Country: \"{0}\" \uD83C\uDDFA\uD83C\uDDE6 %0D%0A %0D%0A" +
                                            "\uD83D\uDC8A Total cases: \"{1}\" | today: \"{2}\" %0D%0A" +
                                            "\uD83D\uDC80 Total death: \"{3}\" | today: \"{4}\" %0D%0A" +
                                            "\uD83D\uDC4C Total recovery: \"{5}\" %0D%0A" +
                                            "-------------------------------------------- %0D%0A%0D%0A";

    String COVID_COUNTRY_MESSAGE_TEMPLATE_RU = "Страна: \"{0}\" \uD83C\uDDFA\uD83C\uDDE6 %0D%0A %0D%0A" +
                                            "\uD83D\uDC8A Всего случаев: \"{1}\" | за сегодня: \"{2}\" %0D%0A" +
                                            "\uD83D\uDC80 Всего смертей: \"{3}\" | за сегодня: \"{4}\" %0D%0A" +
                                            "\uD83D\uDC4C Всего выздоровевших: \"{5}\" %0D%0A" +
                                            "-------------------------------------------- %0D%0A%0D%0A";

    String BASE_INFO_SITE = "<a href=\"https://covid19.rnbo.gov.ua/\">Источник</a>";
}