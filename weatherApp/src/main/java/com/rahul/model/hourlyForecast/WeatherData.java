package com.rahul.model.hourlyForecast;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherData {
	
	@JsonProperty
    private City city;
	
	@JsonProperty
    private List<WeatherEntry> list;
	

}
