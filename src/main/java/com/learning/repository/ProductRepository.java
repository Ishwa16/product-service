package com.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
