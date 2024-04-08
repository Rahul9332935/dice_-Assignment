package com.rahul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.rahul.exception.WeatherServiceException;
import com.rahul.model.forecastSummary.WeatherForecast;
import com.rahul.model.hourlyForecast.WeatherData;
import com.rahul.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	@Value("${auth.clientId}")
	private String clientId;
	@Value("${auth.clientSecret}")
	private String clientSecret;
	
	
	@GetMapping("/summary/{location}")
    public ResponseEntity<?> getForecastSummaryByLocationName(@PathVariable String location) {
        
        try {
            WeatherForecast forecast = weatherService.rapidApiGetForecastSummaryByLocationName(location);
            if (forecast != null) {
                return new ResponseEntity<>(forecast, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Forecast not found for location: " + location, HttpStatus.NOT_FOUND);
            }
        } catch (WeatherServiceException e) {
            return new ResponseEntity<>("Internal server error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpClientErrorException.NotFound e) {
            return new ResponseEntity<>("Resource not found: " + e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (HttpClientErrorException.Unauthorized e) {
            return new ResponseEntity<>("Unauthorized: " + e.getMessage(), HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<>("Unexpected error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/hourly/{location}")
    public ResponseEntity<?> getHourlyForecastByLocationName( @PathVariable String location) {
       

        try {
            WeatherData resp = weatherService.RapidApiGetHourlyForecastByLocationName(location);
            if (resp != null) {
                return new ResponseEntity<>(resp, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Forecast not found for location: " + location, HttpStatus.NOT_FOUND);
            }
        } catch (WeatherServiceException e) {
            return new ResponseEntity<>("Internal server error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpClientErrorException.NotFound e) {
            return new ResponseEntity<>("Resource not found: " + e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (HttpClientErrorException.Unauthorized e) {
            return new ResponseEntity<>("Unauthorized: " + e.getMessage(), HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<>("Unexpected error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
}
