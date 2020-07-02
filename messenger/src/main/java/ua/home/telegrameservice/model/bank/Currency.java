package ua.home.telegrameservice.model.bank;

import lombok.Data;

@Data
public class Currency
{

    private Integer id;

    //currency to be converted to
    private String ccy;

    // base carrency
    private String base_ccy;

    // bank buy
    private String buy;

    //bank sale
    private String sale;
}
