package com.cognizant.order.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int productId;
	private String productName;
	private String productType;
	private int productPrice;
	private String returnpolicy;
	private String fragility;
	private String expiry;
	private String warranty;
	@ManyToOne
	@JoinColumn(name = "orderId")
	private Orders order;

}
