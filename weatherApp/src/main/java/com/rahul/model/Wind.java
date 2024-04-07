package com.rahul.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Wind {
	@JsonProperty("unit")
    private String unit;
	@JsonProperty("direction")
    private String direction;
	@JsonProperty("min")
    private int min;
	@JsonProperty("max")
    private int max;
	

    
}
