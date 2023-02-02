package com.example.springtestwithmock.com.service;

import com.example.springtestwithmock.com.models.Product;
import com.example.springtestwithmock.com.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(double id) {
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {

        return repository.findByName(name);
    }

    public String deleteProduct(double id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public Product updateProduct(double productId, Product product) {
        Product existingProduct = repository.findById(productId).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }

}
