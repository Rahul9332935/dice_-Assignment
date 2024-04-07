package com.rahul.model.forecastSummary;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HourlyWeather {
	
	@JsonProperty("city().name")
	private String cod;
	
	@JsonProperty("temp")
	private double temp;
	@JsonProperty("temp_min")
	private double temp_min;
	@JsonProperty("temp_max")
	private double temp_max;
	@JsonProperty("humidity")
	private int humidity;
	@JsonProperty("weather.main")
	private String weather;

}
