package com.cognizant.order.model;

import java.util.List;

import lombok.Data;
@Data
public class OrderPojo {
	private int orderId;
	private String orderName;
	private List<ProductPojo> products;

}
