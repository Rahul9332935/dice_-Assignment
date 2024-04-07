package com.rahul.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import com.rahul.model.forecastSummary.HourlyWeather;
import com.rahul.model.forecastSummary.WeatherForecast;
import com.rahul.model.hourlyForecast.WeatherData;
@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${X-RapidAPI-Key}")
    private String apiKey;
//    "738e943283msha9df0c0bc496552p1b1c1ajsn0d92c4b15f5e";
    @Value("${weather.apiKey}")
    private String weatherApiKey;
    
    private final String apiHost = "forecast9.p.rapidapi.com";
    
    @Autowired
    private RestTemplate restTemplate;


    public WeatherForecast rapidApiGetForecastSummaryByLocationName(String location) {
//    	System.out.println(apiKey);
    	String apiUrl = "https://forecast9.p.rapidapi.com/rapidapi/forecast/"+location+"/summary/";
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", apiHost);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<WeatherForecast> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, WeatherForecast.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }


	@Override
	public WeatherData RapidApiGetHourlyForecastByLocationName(String location) {
        String apiUrl = "https://api.openweathermap.org/data/2.5/forecast?q=" + location + "&appid=" + weatherApiKey;
        
        System.out.println(apiUrl);
        WeatherData response = restTemplate.getForObject(apiUrl, WeatherData.class);
        System.out.println(response);
        return response;
    }
}

