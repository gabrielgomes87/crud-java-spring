package com.pmcg.crud.controllers;

import com.pmcg.crud.domain.product.Product;
import com.pmcg.crud.domain.product.ProductRepository;
import com.pmcg.crud.domain.product.RequestProduct;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository repository;
    @GetMapping
    public ResponseEntity getAllProducts(){
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity registerProduct(@RequestBody @Valid RequestProduct data){
        Product newProduct = new Product(data);
        repository.save(newProduct);
        System.out.println(data);
        return ResponseEntity.ok().build();

    }

    @PutMapping
    @Transactional
    public ResponseEntity updateProduct(@RequestBody @Valid RequestProduct data){
        Optional<Product> optionalProduct = repository.findById(data.id());
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(data.name());
            product.setPrice_in_cents(data.price_in_cents());
            return ResponseEntity.ok(product);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
