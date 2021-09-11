package com.pt15305ud.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.pt15305ud.entity.Order;

public interface OrderService {

	Order create(JsonNode orderData);

	Order findById(Long id);

	List<Order> findByUsername(String username);

}
