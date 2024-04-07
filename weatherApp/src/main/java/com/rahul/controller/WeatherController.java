package com.rahul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.model.forecastSummary.WeatherForecast;
import com.rahul.model.hourlyForecast.WeatherData;
import com.rahul.service.WeatherService;

//@RestController
@Controller
@RequestMapping("/weather")
public class WeatherController {
	
	@Autowired
	private WeatherService ws;
	
//	@GetMapping("/summary/{location}")
//	public ResponseEntity<WeatherForecast> getForecastSummaryByLocationName(@PathVariable String location) {
//	
//		WeatherForecast forcast = ws.rapidApiGetForecastSummaryByLocationName(location);
//		if(forcast == null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<>(forcast, HttpStatus.OK);
//	}
	@GetMapping("/summary/{location}")
    public String getForecastSummaryByLocationName(@PathVariable String location, Model model) {
        WeatherForecast weatherForecast = ws.rapidApiGetForecastSummaryByLocationName(location);
        if (weatherForecast == null) {
            return "error"; 
        }
        model.addAttribute("weatherForecast", weatherForecast);
        return "forecast_summary";
    }
//	@GetMapping("/hourly/{location}")
//	public ResponseEntity<WeatherData> getHourlyForecastByLocationName(@PathVariable String location){
//		WeatherData resp= ws.RapidApiGetHourlyForecastByLocationName(location);
//		if(resp == null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<>(resp, HttpStatus.OK);
//	}
	@GetMapping("/hourly/{location}")
    public String getHourlyForecastByLocationName(@PathVariable String location, Model model) {
        WeatherData weatherData = ws.RapidApiGetHourlyForecastByLocationName(location);
        if (weatherData == null) {
            return "error"; 
        }
        model.addAttribute("weatherData", weatherData);
        return "hourly_forecast";
    }
	
}
