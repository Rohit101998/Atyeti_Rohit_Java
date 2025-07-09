package com.ecommarce.project.service;

import com.ecommarce.project.model.Product;
import com.ecommarce.project.payload.ProductDTO;
import com.ecommarce.project.payload.ProductResponse;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, Product product);

    ProductResponse getAllProducts();

    ProductResponse searchByCategory(Long categoryId);

    ProductResponse searchProductByKeyword(String keyword);

    ProductDTO updateProduct(Long productId, Product product);
}
