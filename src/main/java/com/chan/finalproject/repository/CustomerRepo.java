package com.chan.finalproject.repository;

import com.chan.finalproject.dto.CustomerRespone;
import com.chan.finalproject.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
        @Query("SELECT new  com.chan.finalproject.dto.CustomerRespone(c.name,c.gender,c.email) FROM Customer c  ")
        List<CustomerRespone> fetchCusOnly();

}
