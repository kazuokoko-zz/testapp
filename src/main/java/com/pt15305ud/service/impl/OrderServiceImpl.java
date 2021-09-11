package com.pt15305ud.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pt15305ud.dao.OrderDAO;
import com.pt15305ud.dao.OrderDetailDAO;
import com.pt15305ud.entity.Order;
import com.pt15305ud.entity.OrderDetail;
import com.pt15305ud.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO _oDAO;
	
	@Autowired
	OrderDetailDAO _odDAO;

	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();
		Order order = mapper.convertValue(orderData, Order.class);
		_oDAO.save(order);

		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {
		};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type).stream()
				.peek(od -> od.setOrder(order)).collect(Collectors.toList());
		_odDAO.saveAll(details);
		return order;
	}

	@Override
	public Order findById(Long id) {
		return _oDAO.findById(id).get();
	}

	@Override
	public List<Order> findByUsername(String username) {
		return _oDAO.findByUsername(username);
	}

}
