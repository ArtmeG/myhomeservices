package ua.home.telegrameservice.model.covid;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 *
 * @author azatvornitskiy
 * @since 2020-11-05
 */
@Data
public class Label
{
    @JsonProperty
    private String en;
    @JsonProperty
    private String uk;
}
