package com.ecommarce.project.service;

import com.ecommarce.project.exceptions.APIException;
import com.ecommarce.project.exceptions.ResourceNotFoundException;
import com.ecommarce.project.model.Cart;
import com.ecommarce.project.model.CartItem;
import com.ecommarce.project.model.Product;
import com.ecommarce.project.payload.CartDTO;
import com.ecommarce.project.payload.ProductDTO;
import com.ecommarce.project.repositories.CartItemRepository;
import com.ecommarce.project.repositories.CartRepository;
import com.ecommarce.project.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AuthUtil authUtil;

    @Override
    public CartDTO addProductToCart(Long productId, Integer quantity) {
        //find existing cart or create one
        Cart cart = createCart();

        //Retrieve Product Details
        Product product = productRepository.findById(productId)
                .orElseThrow(()->new ResourceNotFoundException("Product","productId",productId));
        //Perform Validation
        CartItem cartItem = cartItemRepository.findCartItemByProductIdAndCarId(
                cart.getCartId(),
                productId
        );

        if(cartItem != null){
            throw new APIException("Product" + product.getProductName() + " already exist in the cart");
        }

        if(product.getQuantity() < quantity ){
            throw new APIException("Please, make an order of the " + product.getProductName()
            + " less than or equal to the quantity " + product.getQuantity()+".");
        }

        //Create Cart Item
        CartItem newCartItem = new CartItem();
        newCartItem.setProduct(product);
        newCartItem.setCart(cart);
        newCartItem.setQuantity(quantity);
        newCartItem.setDiscount(product.getDiscount());
        newCartItem.setProductPrice(product.getSpecialPrice());
        //Save Cart Item
        cartItemRepository.save(newCartItem);

        product.setQuantity(product.getQuantity());

        cart.setTotalPrice(cart.getTotalPrice() + (product.getSpecialPrice() * quantity));

        cartRepository.save(cart);
        //Return Updated cart

       CartDTO cartDTO = modelMapper.map(cart,CartDTO.class);

        List<CartItem> cartItems = cart.getCartItems();

        Stream<ProductDTO> productDTOStream = cartItems.stream().map(item->{
            ProductDTO map = modelMapper.map(item.getProduct(),ProductDTO.class);
            map.setQuantity(item.getQuantity());
            return map;
        });
        cartDTO.setProducts(productDTOStream.toList());

        return cartDTO;
    }

    private Cart createCart(){
        Cart userCart = cartRepository.findCartByEmail(authUtil.loggedInEmail());
        if(userCart != null ){
            return  userCart;
        }
        Cart cart = new Cart();
        cart.setTotalPrice(0.00);
        cart.setUser(authUtil.loggedInUser());
        Cart newCart = cartRepository.save(cart);
        return newCart;

    }
}
