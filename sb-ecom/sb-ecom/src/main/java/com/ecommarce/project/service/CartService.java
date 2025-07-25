package com.ecommarce.project.service;

import com.ecommarce.project.payload.CartDTO;

public interface CartService {

    CartDTO addProductToCart(Long productId, Integer quantity);
}
