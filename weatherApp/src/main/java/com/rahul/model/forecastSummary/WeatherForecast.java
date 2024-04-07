package com.rahul.model.forecastSummary;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherForecast {
	@JsonProperty("location")
    private Location location;
	@JsonProperty("forecast")
    private Forecast forecast;

   
}
