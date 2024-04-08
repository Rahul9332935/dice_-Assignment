package com.rahul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.model.forecastSummary.WeatherForecast;
import com.rahul.model.hourlyForecast.WeatherData;
import com.rahul.service.WeatherService;

import jakarta.servlet.http.HttpServletResponse;

//@RestController
@Controller
public class WeatherController {
	
	@Autowired
	private WeatherService ws;
	
	@Value("${auth.clientId}")
	private String clientId;
	@Value("${auth.clientSecret}")
	private String clientSecret;
	
	@GetMapping("/weather/summary/{location}")
    public String getForecastSummaryByLocationName(@RequestHeader("X-Client-ID") String clientId,
                                                    @RequestHeader("X-Client-Secret") String clientSecret,
                                                    @PathVariable String location,
                                                    Model model,
                                                    HttpServletResponse response) {
        if (!isValidCredentials(clientId, clientSecret)) {
            return handleUnauthorized(model, response);
        }

        WeatherForecast weatherForecast = ws.rapidApiGetForecastSummaryByLocationName(location);
        if (weatherForecast == null) {
            return handleNotFound(model, response);
        }

        model.addAttribute("weatherForecast", weatherForecast);
        return "forecast_summary";
    }

    @GetMapping("/weather/hourly/{location}")
    public String getHourlyForecastByLocationName(@RequestHeader("X-Client-ID") String clientId,
                                                   @RequestHeader("X-Client-Secret") String clientSecret,
                                                   @PathVariable String location,
                                                   Model model,
                                                   HttpServletResponse response) {
        if (!isValidCredentials(clientId, clientSecret)) {
            return handleUnauthorized(model, response);
        }

        WeatherData weatherData = ws.RapidApiGetHourlyForecastByLocationName(location);
        if (weatherData == null) {
            return handleNotFound(model, response);
        }

        model.addAttribute("weatherData", weatherData);
        return "hourly_forecast";
    }

    private boolean isValidCredentials(String clientId, String clientSecret) {
        return clientId.equals(this.clientId) && clientSecret.equals(this.clientSecret);
    }

    private String handleUnauthorized(Model model, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        model.addAttribute("errorMessage", "Unauthorized access");
        return "error";
    }

    private String handleNotFound(Model model, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        model.addAttribute("errorMessage", "Data not found");
        return "error";
    }
	
	
//	@GetMapping("/summary/{location}")
//	public ResponseEntity<WeatherForecast> getForecastSummaryByLocationName(@PathVariable String location) {
//	
//		WeatherForecast forcast = ws.rapidApiGetForecastSummaryByLocationName(location);
//		if(forcast == null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<>(forcast, HttpStatus.OK);
//	}
	
//	@GetMapping("/hourly/{location}")
//	public ResponseEntity<WeatherData> getHourlyForecastByLocationName(@PathVariable String location){
//		WeatherData resp= ws.RapidApiGetHourlyForecastByLocationName(location);
//		if(resp == null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<>(resp, HttpStatus.OK);
//	}
	
    
	
}
