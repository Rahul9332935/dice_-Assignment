package com.rahul.model.hourlyForecast;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Main {
	@JsonProperty("temp")
	private Double temp;
	@JsonProperty("temp_min")
    private Double temp_min;
	@JsonProperty("temp_max")
    private Double temp_max;
	@JsonProperty("pressure")
    private Integer pressure;
	@JsonProperty("sea_level")
    private Integer sea_level;
	@JsonProperty("grnd_level")
    private Integer grnd_level;
	@JsonProperty
    private Integer humidity;
}
