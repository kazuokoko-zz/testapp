package com.pt15305ud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pt15305ud.entity.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {

	@Query("select p from Product p where p.category.id=?1")
	List<Product> findByCategoryId(String cid);

	@Query("select p from Product p where p.available=true")
	List<Product> findByAvailableTrue();

	@Query("select p from Product p where p.category.id=?1 and p.available=true")
	List<Product> findByCategoryIdAndAvailableTrue(String cid);

}
