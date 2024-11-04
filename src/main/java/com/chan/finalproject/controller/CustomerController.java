package com.chan.finalproject.controller;

import com.chan.finalproject.dto.ApiRespone;
import com.chan.finalproject.dto.CustomerRespone;
import com.chan.finalproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
        private CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/GetCusOnly")
    ResponseEntity<?>getCus(){
       ApiRespone apiRespone=ApiRespone.builder()
               .message("Successfully")
               .httpStatus(HttpStatus.OK)
               .payload(customerService.fetchCusOnly())
               .build();

       return new ResponseEntity<>(apiRespone,HttpStatus.OK);
    }
}
