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
    String COVID_CITY_MESSAGE_TEMPLATE = "COVID-19 %0D%0A" +
                                         "Oblast: \"{0}\"  %0D%0A" +
                                         "Total cases: \"{1}\" | today: \"{2}\" %0D%0A" +
                                         "Total death: \"{3}\" | today: \"{4}\" %0D%0A" +
                                         "Total recovery: \"{5}\" | today: \"{6}\" %0D%0A %0D%0A" +
                                         "--------------------------------- %0D%0A";
    String COVID_COUNTRY_MESSAGE_TEMPLATE = "Country: \"{0}\" %0D%0A " +
                                            "Total cases: \"{1}\" | today: \"{2}\" %0D%0A" +
                                            "Total death: \"{3}\" | today: \"{4}\" %0D%0A" +
                                            "Total recovery: \"{5}\"";
}
