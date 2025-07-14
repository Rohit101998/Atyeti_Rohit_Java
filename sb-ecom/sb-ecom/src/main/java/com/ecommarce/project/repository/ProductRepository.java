package com.ecommarce.project.repository;

import com.ecommarce.project.model.Category;
import com.ecommarce.project.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findByCategoryOrderByPriceAsc(Category category, Pageable pageDetail);

    Page<Product> findByProductNameLikeIgnoreCase(String keyword, Pageable pageDetail);
}
