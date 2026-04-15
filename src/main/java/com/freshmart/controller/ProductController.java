package com.freshmart.controller;

import com.freshmart.model.Category;
import com.freshmart.model.Product;
import com.freshmart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // GET /api/products - list all products
    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    // GET /api/products/{id} - get product by id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // GET /api/products/category/{category} - filter by category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable String category) {
        try {
            Category cat = Category.valueOf(category.toUpperCase());
            List<Product> products = productRepository.findByCategory(cat);
            return ResponseEntity.ok(products);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // GET /api/products/search?q=term - search by name
    @GetMapping("/search")
    public List<Product> search(@RequestParam("q") String query) {
        return productRepository.findByNameContainingIgnoreCase(query);
    }
}
