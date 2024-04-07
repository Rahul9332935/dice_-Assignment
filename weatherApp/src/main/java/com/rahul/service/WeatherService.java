package com.rahul.service;

import com.rahul.model.forecastSummary.HourlyWeather;
import com.rahul.model.forecastSummary.WeatherForecast;
import com.rahul.model.hourlyForecast.WeatherData;

public interface WeatherService {
	
	WeatherForecast rapidApiGetForecastSummaryByLocationName(String location);
	
	WeatherData RapidApiGetHourlyForecastByLocationName(String location);

}
