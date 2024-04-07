package com.rahul.model.forecastSummary;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Temperature {
	@JsonProperty("min")
    private int min;
	@JsonProperty("max")
    private int max;
	@JsonProperty("avg")
    private double avg; 
	
	
}
