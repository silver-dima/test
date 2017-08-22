package com.mabaya.test.repository;

import com.mabaya.test.domain.Category;
import com.mabaya.test.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductsByCategory(Category category);
}
