package com.rahul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<WeatherForecast> getForecastSummaryByLocationName(@RequestHeader("X-Client-ID") String clientId,
            @RequestHeader("X-Client-Secret") String clientSecret, @PathVariable String location) {
		if (!isValidCredentials(clientId, clientSecret)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
		WeatherForecast forcast = weatherService.rapidApiGetForecastSummaryByLocationName(location);
		if(forcast == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(forcast, HttpStatus.OK);
	}
	
	@GetMapping("/hourly/{location}")
	public ResponseEntity<WeatherData> getHourlyForecastByLocationName(@RequestHeader("X-Client-ID") String clientId,
            @RequestHeader("X-Client-Secret") String clientSecret, @PathVariable String location){
		
		if (!isValidCredentials(clientId, clientSecret)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
		
		WeatherData resp= weatherService.RapidApiGetHourlyForecastByLocationName(location);
		if(resp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	
	private boolean isValidCredentials(String clientId, String clientSecret) {
        return clientId.equals(this.clientId) && clientSecret.equals(this.clientSecret);
    }

	
}
