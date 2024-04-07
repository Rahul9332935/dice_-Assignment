package com.rahul.model.hourlyForecast;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class WeatherEntry {
	@JsonProperty
	private Main main;
	@JsonProperty
    private List<Weather> weather;
	@JsonProperty
    private Wind wind;
	@JsonProperty
    private int visibility;
	@JsonProperty
    private String dt_txt;

}
