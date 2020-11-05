package ua.home.telegrameservice.model.covid;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author azatvornitskiy
 * @since 2020-11-05
 */
@Data
public class Country
{
    @JsonProperty("ukraine")
    private List<City> cities;
}
