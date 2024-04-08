package com.rahul.service;

import com.rahul.exception.WeatherServiceException;
import com.rahul.model.forecastSummary.WeatherForecast;
import com.rahul.model.hourlyForecast.WeatherData;

public interface WeatherService {
	
	WeatherForecast rapidApiGetForecastSummaryByLocationName(String location) throws WeatherServiceException;
	
	WeatherData RapidApiGetHourlyForecastByLocationName(String location) throws WeatherServiceException;

}
