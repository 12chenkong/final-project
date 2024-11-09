package com.chan.finalproject.controller;

import com.chan.finalproject.dto.ApiRespone;
import com.chan.finalproject.service.ProductService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@NoArgsConstructor
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getProducts")
    public ResponseEntity<?> getProducts(){
        if(productService.getProducts().isEmpty()){
            ApiRespone apiRespone=ApiRespone.builder()
                    .payload(null)
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .message("Fail to fetch")
                    .build();
            return new ResponseEntity<>(apiRespone,HttpStatus.NOT_FOUND);
        }
            ApiRespone apiRespone=ApiRespone.builder()
                    .message("Successfully get project")
                    .httpStatus(HttpStatus.OK)
                    .payload(productService.getProducts())
                    .build();
            return new ResponseEntity<>(apiRespone,HttpStatus.OK);

    }

    @GetMapping("/getProd/{price}")
    public ResponseEntity<?>getProductByPrice(@PathVariable double price){

        if(!productService.fetchProdGeaterThanGivePrice(price).isPresent()){
            ApiRespone apiRespone=ApiRespone.builder()
                    .message("fail to fetch product by price")
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .payload(null)
                    .build();
            return new ResponseEntity<>(apiRespone,HttpStatus.NOT_FOUND);
        }
       ApiRespone apiRespone=ApiRespone.builder()
               .payload(productService.fetchProdGeaterThanGivePrice(price).get())
               .message("Successfully get product by price")
               .httpStatus(HttpStatus.OK)
               .build();
       return new ResponseEntity<>(apiRespone,HttpStatus.OK);
    }


}
