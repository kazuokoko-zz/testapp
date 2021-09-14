package com.pt15305ud.service;

import java.util.List;

import com.pt15305ud.entity.Product;

public interface ProductService {

	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findByCategoryId(String cid);

	Product create(Product product);

	Product update(Product product);

	void delete(Integer id);

	List<Product> findAllAndAvailable();

	List<Product> findByCategoryIdAndAvailable(String cid);

}
