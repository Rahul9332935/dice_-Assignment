package com.rahul.model.hourlyForecast;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Wind {
	
	@JsonProperty("speed")
	private Double speed;
	@JsonProperty("deg")
    private Integer deg;
	@JsonProperty("gust")
    private Double gust;
}
