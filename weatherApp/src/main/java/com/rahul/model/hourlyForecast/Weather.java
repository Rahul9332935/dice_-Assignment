package com.rahul.model.hourlyForecast;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Weather {
	@JsonProperty
	 private String description;
}
