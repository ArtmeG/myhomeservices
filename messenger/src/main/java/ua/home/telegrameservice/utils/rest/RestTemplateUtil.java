package ua.home.telegrameservice.utils.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpMethod;

/**
 * @author azatvornitskiy
 * @since 2020-11-05
 */
public class RestTemplateUtil
{
    @Autowired
    private final RestTemplate restTemplate;

    public RestTemplateUtil(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    public <T> T getDataFromGetApi(
            String apiUrl,
            ParameterizedTypeReference parameterizedTypeReference
    )
    {
        return (T) this.getBodyResponseData(restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                parameterizedTypeReference)
        );
    }

    private <T> T getBodyResponseData(ResponseEntity<T> responseEntity)
    {
        return responseEntity.getBody();
    }

}
