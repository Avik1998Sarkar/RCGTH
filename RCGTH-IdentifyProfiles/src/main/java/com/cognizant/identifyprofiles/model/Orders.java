package com.cognizant.identifyprofiles.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Orders {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private List<Product> products;
	private String orderName;

}
