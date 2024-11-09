package com.chan.finalproject.repository;

import com.chan.finalproject.dto.ProductRespone;
import com.chan.finalproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    @Query("SELECT new com.chan.finalproject.dto.ProductRespone(p.price,p.productName) FROM Product p")
    List<ProductRespone> getProducts();
    @Query("SELECT new com.chan.finalproject.dto.ProductRespone(p.price,p.productName) FROM Product p WHERE p.price>:price")
    List<ProductRespone> findProdByPrice(double price);
}
