package com.pt15305ud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pt15305ud.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {

}
