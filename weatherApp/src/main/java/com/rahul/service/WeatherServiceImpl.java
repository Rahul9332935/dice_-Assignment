package com.rahul.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import com.rahul.exception.WeatherServiceException;
import com.rahul.model.forecastSummary.WeatherForecast;
import com.rahul.model.hourlyForecast.WeatherData;
@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${X-RapidAPI-Key}")
    private String apiKey;
    @Value("${weather.apiKey}")
    private String weatherApiKey;
    @Value("${X-RapidAPI-Host}")
    private String apiHost;
    
    @Autowired
    private RestTemplate restTemplate;


    public WeatherForecast rapidApiGetForecastSummaryByLocationName(String location) throws WeatherServiceException {
        try {
            String apiUrl = "https://forecast9.p.rapidapi.com/rapidapi/forecast/" + location + "/summary/";
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-RapidAPI-Key", apiKey);
            headers.set("X-RapidAPI-Host", apiHost);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<WeatherForecast> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, WeatherForecast.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            } else {
                throw new WeatherServiceException("Failed to get forecast summary: " + response.getStatusCode());
            }
        } catch (Exception e) {
            throw new WeatherServiceException("Failed to get forecast summary", e);
        }
    }

    public WeatherData RapidApiGetHourlyForecastByLocationName(String location) throws WeatherServiceException {
        try {
            String apiUrl = "https://api.openweathermap.org/data/2.5/forecast?q=" + location + "&appid=" + weatherApiKey;
            WeatherData response = restTemplate.getForObject(apiUrl, WeatherData.class);
            if (response != null) {
                return response;
            } else {
                throw new WeatherServiceException("Failed to get hourly forecast: response is null");
            }
        } catch (Exception e) {
            throw new WeatherServiceException("Failed to get hourly forecast", e);
        }
    }
}

