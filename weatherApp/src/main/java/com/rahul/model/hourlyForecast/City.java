package com.rahul.model.hourlyForecast;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class City {
	@JsonProperty("name")
	private String name;
	@JsonProperty("country")
    private String country;
}
