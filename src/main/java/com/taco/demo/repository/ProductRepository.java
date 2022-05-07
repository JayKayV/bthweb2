package com.taco.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.taco.demo.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
