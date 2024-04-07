package com.rahul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.model.forecastSummary.HourlyWeather;
import com.rahul.model.forecastSummary.WeatherForecast;
import com.rahul.model.hourlyForecast.WeatherData;
import com.rahul.service.WeatherService;

@RestController

public class WeatherController {
	
	@Autowired
	private WeatherService ws;
	
	@GetMapping("/weather/{location}")
	public ResponseEntity<WeatherForecast> getForecastSummaryByLocationName(@PathVariable String location) {
//		
		WeatherForecast forcast = ws.rapidApiGetForecastSummaryByLocationName(location);
		if(forcast == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(forcast, HttpStatus.OK);
	}
	@GetMapping("/weather/hourly/{location}")
	public ResponseEntity<WeatherData> getHourlyForecastByLocationName(@PathVariable String location){
		WeatherData resp= ws.RapidApiGetHourlyForecastByLocationName(location);
		if(resp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	
}
