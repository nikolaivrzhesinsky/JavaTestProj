package com.example.springtestwithmock;

import com.example.springtestwithmock.com.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestMySQLRepository extends JpaRepository<Product, Long> {

}
