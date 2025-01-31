package ua.home.telegrameservice.model.bank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyDto
{

    @JsonProperty
    private String ccy;
    @JsonProperty
    // base carrency
    private String base_ccy;
    @JsonProperty
    // bank buy
    private String buy;
    @JsonProperty
    //bank sale
    private String sale;

    @Override
    public String toString()
    {
        return String.format("Currency %S, Buy rate %s, Sell rate %s", ccy, buy, sale);
    }
}
