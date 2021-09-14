package com.pt15305ud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pt15305ud.dao.ProductDAO;
import com.pt15305ud.entity.Product;
import com.pt15305ud.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO pDAO;

	@Override
	public List<Product> findAll() {
		return pDAO.findAll();
	}

	@Override
	public Product findById(Integer id) {
		Optional<Product> opt = pDAO.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}

	}

	@Override
	public List<Product> findByCategoryId(String cid) {
		return pDAO.findByCategoryId(cid);

	}

	@Override
	public Product create(Product product) {
		return pDAO.save(product);
	}

	@Override
	public Product update(Product product) {
		return pDAO.save(product);
	}

	@Override
	public void delete(Integer id) {
		pDAO.deleteById(id);
	}

	@Override
	public List<Product> findAllAndAvailable() {
		return pDAO.findByAvailableTrue();
	}

	@Override
	public List<Product> findByCategoryIdAndAvailable(String cid) {
		return pDAO.findByCategoryIdAndAvailableTrue(cid);
	}

}
