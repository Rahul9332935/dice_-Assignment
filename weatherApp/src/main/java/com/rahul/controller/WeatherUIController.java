package com.rahul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rahul.model.forecastSummary.WeatherForecast;
import com.rahul.model.hourlyForecast.WeatherData;
import com.rahul.service.WeatherService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class WeatherUIController {
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping
	public String homepage() {
		return "homepage";
	}
	
	@GetMapping("/ui/weather/summary/{location}")
    public String getForecastSummaryByLocationName(
                                                    @PathVariable String location,
                                                    Model model,
                                                    HttpServletResponse response) {
        

        WeatherForecast weatherForecast = weatherService.rapidApiGetForecastSummaryByLocationName(location);
        if (weatherForecast == null) {
            return handleNotFound(model, response);
        }

        model.addAttribute("weatherForecast", weatherForecast);
        return "forecast_summary";
    }

    @GetMapping("/ui/weather/hourly/{location}")
    public String getHourlyForecastByLocationName(
                                                   @PathVariable String location,
                                                   Model model,
                                                   HttpServletResponse response) {

        WeatherData weatherData = weatherService.RapidApiGetHourlyForecastByLocationName(location);
        if (weatherData == null) {
            return handleNotFound(model, response);
        }

        model.addAttribute("weatherData", weatherData);
        return "hourly_forecast";
    }
	
    private String handleNotFound(Model model, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        model.addAttribute("errorMessage", "Data not found");
        return "error";
    }
}
