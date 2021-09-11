package com.pt15305ud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pt15305ud.entity.Category;

@Repository
public interface CategoryDAO extends JpaRepository<Category, String>{

}
