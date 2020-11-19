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
    private Integer id;
    private Label label;
    private Integer country;
    private Integer confirmed;
    private Integer deaths;
    private Integer recovered;
    private Integer existing;
    private Integer suspicion;
    private double lat;
    private double lng;
    private Integer deltaConfirmed;
    private Integer deltaDeaths;
    private Integer deltaRecovered;
    private Integer deltaExisting;
    private Integer deltaSuspicion;
}
