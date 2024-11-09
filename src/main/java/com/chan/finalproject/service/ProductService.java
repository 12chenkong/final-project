package com.chan.finalproject.service;

import com.chan.finalproject.dto.ProductRespone;
import com.chan.finalproject.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepo productRepo;
//    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Optional<List<ProductRespone>> getProducts(){
        return Optional.ofNullable(productRepo.getProducts());
    }

    public  Optional<List<ProductRespone>>fetchProdGeaterThanGivePrice(double price){
       return Optional.ofNullable(productRepo.findProdByPrice(price));
    }
}
