package com.pt15305ud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pt15305ud.dao.CategoryDAO;
import com.pt15305ud.entity.Category;
import com.pt15305ud.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDAO cDao;

	@Override
	public List<Category> findAll() {
		return cDao.findAll();
	}

}
