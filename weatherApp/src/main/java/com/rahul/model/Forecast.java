package com.rahul.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Forecast {
	@JsonProperty("items")
    private List<ForecastItem> items;

	
}
