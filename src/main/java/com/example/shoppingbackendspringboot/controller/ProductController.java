package com.example.shoppingbackendspringboot.controller;

import com.example.shoppingbackendspringboot.dto.OrderCreateDTO;
import com.example.shoppingbackendspringboot.dto.OrderUpdateDTO;
import com.example.shoppingbackendspringboot.dto.ProductCreateDTO;
import com.example.shoppingbackendspringboot.dto.ProductUpdateDTO;
import com.example.shoppingbackendspringboot.entity.Order;
import com.example.shoppingbackendspringboot.entity.Product;
import com.example.shoppingbackendspringboot.service.OrderService;
import com.example.shoppingbackendspringboot.service.ProductService;
import com.example.shoppingbackendspringboot.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final UserService userService;
    private final ModelMapper modelMapper;


    @GetMapping
    @PreAuthorize("hasRole('PRODUCT_READ_ALL')")
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('PRODUCT_READ_ALL BY PRODUCT ID')")
    public Product getProductById(@PathVariable("id") Long id) {
        return this.productService.getProductById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('PRODUCT_CREATE')")
    public ResponseEntity<Product> createOrder(@Valid @RequestBody ProductCreateDTO productCreateDTO) {
        return new ResponseEntity<>(this.productService.createProduct(modelMapper.map(productCreateDTO, Product.class)), HttpStatus.CREATED);
    }

    @PutMapping
    @PreAuthorize("hasRole('PRODUCT_UPDATE')")
    public Product updateOrder(@Valid @RequestBody ProductUpdateDTO productUpdateDTO) {
        Product product = this.productService.getProductById(productUpdateDTO.getId());
        modelMapper.map(productUpdateDTO, product);
        return this.productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('PRODUCT_DELETE')")
    public void deleteProduct(@PathVariable("id") Long id) {
        this.productService.deleteProduct(id);
    }

}