package com.freshmart.repository;

import com.freshmart.model.Category;
import com.freshmart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);
    List<Product> findByNameContainingIgnoreCase(String name);
}
