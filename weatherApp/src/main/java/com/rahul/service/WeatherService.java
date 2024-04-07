package com.rahul.service;

import com.rahul.model.WeatherForecast;

public interface WeatherService {
	
	WeatherForecast rapidApiGetForecastSummaryByLocationName(String location);

}
