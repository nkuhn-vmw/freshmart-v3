package com.freshmart;

import com.freshmart.model.Category;
import com.freshmart.model.Product;
import com.freshmart.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {
    private final ProductRepository productRepository;

    public DataSeeder(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() > 0) {
            return; // already seeded
        }
        List<Product> products = List.of(
                new Product("Organic Bananas", "Fresh organic bananas", new BigDecimal("1.29"), Category.PRODUCE, 50, "🍌"),
                new Product("Avocados (3pk)", "Ripe avocados pack of 3", new BigDecimal("4.99"), Category.PRODUCE, 50, "🥑"),
                new Product("Fresh Strawberries", "Sweet strawberries", new BigDecimal("3.99"), Category.PRODUCE, 50, "🍓"),
                new Product("Whole Milk 1 Gal", "Whole milk gallon", new BigDecimal("4.49"), Category.DAIRY, 50, "🥛"),
                new Product("Greek Yogurt", "Greek yogurt cup", new BigDecimal("1.79"), Category.DAIRY, 50, "🫙"),
                new Product("Cheddar Cheese Block", "Cheddar cheese block", new BigDecimal("5.99"), Category.DAIRY, 50, "🧀"),
                new Product("Sourdough Loaf", "Artisan sourdough bread", new BigDecimal("5.49"), Category.BAKERY, 50, "🍞"),
                new Product("Chocolate Croissants (4pk)", "Chocolate croissants pack of 4", new BigDecimal("4.99"), Category.BAKERY, 50, "🥐"),
                new Product("Chicken Breast 1lb", "Boneless chicken breast", new BigDecimal("8.99"), Category.MEAT, 50, "🍗"),
                new Product("Ground Beef 1lb", "Lean ground beef", new BigDecimal("7.49"), Category.MEAT, 50, "🥩"),
                new Product("Atlantic Salmon Fillet", "Fresh salmon fillet", new BigDecimal("12.99"), Category.SEAFOOD, 50, "🐟"),
                new Product("Orange Juice 64oz", "Pure orange juice", new BigDecimal("3.79"), Category.BEVERAGES, 50, "🍊"),
                new Product("Sparkling Water 12pk", "Sparkling water pack", new BigDecimal("5.99"), Category.BEVERAGES, 50, "💧"),
                new Product("Trail Mix 16oz", "Mixed nuts and dried fruit", new BigDecimal("6.49"), Category.SNACKS, 50, "🥜"),
                new Product("Dark Chocolate Bar", "Rich dark chocolate", new BigDecimal("2.99"), Category.SNACKS, 50, "🍫"),
                new Product("Frozen Pizza Margherita", "Classic pizza", new BigDecimal("6.99"), Category.FROZEN, 50, "🍕"),
                new Product("Ice Cream Vanilla 1pt", "Vanilla ice cream", new BigDecimal("4.99"), Category.FROZEN, 50, "🍦"),
                new Product("Pasta Penne 1lb", "Penne pasta", new BigDecimal("1.99"), Category.PANTRY, 50, "🍝"),
                new Product("Extra Virgin Olive Oil", "Olive oil bottle", new BigDecimal("8.99"), Category.PANTRY, 50, "🫒"),
                new Product("Paper Towels 6pk", "Paper towels pack", new BigDecimal("9.99"), Category.HOUSEHOLD, 50, "🧻")
        );
        productRepository.saveAll(products);
    }
}
