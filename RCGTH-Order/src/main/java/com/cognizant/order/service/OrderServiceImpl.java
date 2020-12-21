package com.cognizant.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.order.clients.IndentifyProfileClient;
import com.cognizant.order.entity.Orders;
import com.cognizant.order.exception.OrderAlreadyExistsException;
import com.cognizant.order.exception.OrderNotFoundException;
import com.cognizant.order.exception.ProductTypeNotFoundException;
import com.cognizant.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private IndentifyProfileClient client;

	@Override
	public Orders saveOrders(Orders orders) throws OrderAlreadyExistsException, ProductTypeNotFoundException {
		Orders order = client.matchProfile(orders);
		if(order.getProducts().get(0).getExpiry()==null) {
			throw new ProductTypeNotFoundException("Product Type Not Found!");
		}
		if (orderRepository.findById(orders.getOrderId()).isPresent()) {
			throw new OrderAlreadyExistsException("Order already exists!!");
		}
		return orderRepository.save(order);
	}

	@Override
	public List<Orders> getAllOrders() {
		List<Orders> order = orderRepository.findAll();
		return order;

	}

	@Override
	public Orders updateOrders(Orders order) throws OrderNotFoundException {
		Optional<Orders> orders = orderRepository.findById(order.getOrderId());
		Orders updateOrders = new Orders();
		if (orders.isPresent()) {
			Orders updateOrder = orders.get();
			updateOrder.setOrderName(order.getOrderName());
			updateOrder.setProducts(order.getProducts());
			updateOrders = orderRepository.save(updateOrder);

		} else {
			throw new OrderNotFoundException("Order not found with id:" + order.getOrderId());
		}
		return updateOrders;
	}

	@Override
	public String deleteOrders(int orderId) throws OrderNotFoundException {

		Optional<Orders> order = orderRepository.findById(orderId);
		if (order.isPresent()) {

			orderRepository.deleteById(orderId);
		} else {
			throw new OrderNotFoundException("Order not found with id:" + orderId);
		}

		return "Order deleted with id: " + orderId;
	}

}
