package com.rahul.model.forecastSummary;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Astronomy {
	
	@JsonProperty("sunrise")
    private String sunrise;
	@JsonProperty("sunset")
    private String sunset;
	

    
}
