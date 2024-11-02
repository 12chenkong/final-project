package com.chan.finalproject.controller;

import com.chan.finalproject.dto.ApiRespone;
import com.chan.finalproject.dto.OrderRequest;
import com.chan.finalproject.model.Customer;
import com.chan.finalproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private CustomerService customerService;
    @Autowired
    public OrderController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/PlaceOrder")
    ResponseEntity<?>createCustomer(@RequestBody OrderRequest orderRequest){
     return new ResponseEntity<>(customerService.CreateCustomer(orderRequest), HttpStatus.CREATED);
    }


    @GetMapping("/GetAllOrders")
   public ResponseEntity<?>getAllOrders(){
        ApiRespone apiRespone=ApiRespone.builder()
                .message("Successfully get data")
                .payload(customerService.findAllOrders())
                .httpStatus(HttpStatus.OK)
                .build();
        return new ResponseEntity<>(apiRespone,HttpStatus.OK);
    }

    @GetMapping("/getOrderById/{id}")
    public ResponseEntity<?>getById(@PathVariable int id){
        if(customerService.getCusById(id).isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.valueOf(404));
        }else {
            ApiRespone apiRespone=ApiRespone.builder()
                    .httpStatus(HttpStatus.OK)
                    .payload(customerService.getCusById(id))
                    .message("get customer with id successfully")
                    .build();
            return new ResponseEntity<>(apiRespone,HttpStatus.OK);
        }

    }

    @PutMapping("/updateOrder/{id}")
    public ResponseEntity<?>updateOrder(@PathVariable int id,@RequestBody OrderRequest orderRequest){
        if(customerService.updateById(id,orderRequest).isEmpty()){
            ApiRespone apiRespone=ApiRespone.builder()
                    .message("Failed to fetch update order")
                    .payload(null)
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .build();
            return new ResponseEntity<>(apiRespone,HttpStatus.NOT_FOUND);

        }else {
            ApiRespone apiRespone=ApiRespone.builder()
                    .message("Successully update order")
                    .payload(customerService.updateById(id,orderRequest))
                    .httpStatus(HttpStatus.OK)
                    .build();
            return new ResponseEntity<>(apiRespone,HttpStatus.OK);
        }

    }

}
