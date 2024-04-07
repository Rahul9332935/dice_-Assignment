package com.rahul.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Location {
	@JsonProperty("name")
    private String name;
	@JsonProperty("timezone")
    private String timezone;
	
}
    

