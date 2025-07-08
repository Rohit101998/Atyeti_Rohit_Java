package com.ecommarce.project.service;

import com.ecommarce.project.model.Product;
import com.ecommarce.project.payload.ProductDTO;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, Product product);
}
