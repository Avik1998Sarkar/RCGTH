package com.cognizant.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String profiletype;
	private String returnpolicy;
	private String fragility;
	private String expiry;
	private String warranty;
}
