package com.cognizant.order.model;

import lombok.Data;

@Data
public class ProductPojo {
	
//	private int slno;
	private int productId;
	private String productName;
	private String productType;
	private int productPrice;
	private String returnpolicy;
	private String fragility;
	private String expiry;
	private String warranty;


}
