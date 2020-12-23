package com.cognizant.identifyprofiles.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Profile implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String profiletype;
	private String returnpolicy;
	private String fragility;
	private String expiry;
	private String warranty;
}
