package com.example.springtestwithmock.com.repository;

import com.example.springtestwithmock.com.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Double> {

    Product findByName(String name);
}
