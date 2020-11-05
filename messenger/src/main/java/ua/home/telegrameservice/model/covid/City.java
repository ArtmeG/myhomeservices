package ua.home.telegrameservice.model.covid;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 *
 * @author azatvornitskiy
 * @since 2020-11-05
 */
@Data
public class City
{
    @JsonProperty
    private int id;
    private Label label;
    private int country;
    private int confirmed;
    private int deaths;
    private int recovered;
    private int existing;
    private int suspicion;
    private double lat;
    private double lng;
    private int delta_confirmed;
    private int delta_deaths;
    private int delta_recovered;
    private int delta_existing;
    private int delta_suspicion;
}
