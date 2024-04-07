package com.rahul.model.forecastSummary;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastItem {
	@JsonProperty("dateWithTimezone")
    private String dateWithTimezone;
	@JsonProperty("temperature")
	private Temperature temperature;
	@JsonProperty("wind")
	private Wind wind;
	@JsonProperty("astronomy")
    private Astronomy astronomy;

    
}
