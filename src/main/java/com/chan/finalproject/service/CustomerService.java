package com.chan.finalproject.service;

import com.chan.finalproject.dto.CustomerRespone;
import com.chan.finalproject.dto.OrderRequest;
import com.chan.finalproject.model.Customer;
import com.chan.finalproject.model.Product;
import com.chan.finalproject.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
  private CustomerRepo customerRepo;
  @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer CreateCustomer(OrderRequest orderRequest){
        System.out.println(orderRequest.getCustomer());
      return customerRepo.save(orderRequest.getCustomer());
    }

    public List<Customer>findAllOrders(){
     return customerRepo.findAll();
    }

    public Optional<Customer> getCusById(int id){
      return customerRepo.findById(id);
    }

    public Optional<Customer>updateById(int id,OrderRequest orderRequest){
      Optional<Customer> customer=customerRepo.findById(id);
      customer.get().setEmail(orderRequest.getCustomer().getEmail());
      customer.get().setName(orderRequest.getCustomer().getName());
      customer.get().setGender(orderRequest.getCustomer().getGender());
      customer.get().setProduct(orderRequest.getCustomer().getProduct());
      return customer;
  }

  public List<CustomerRespone> fetchCusOnly(){
    return customerRepo.fetchCusOnly();
  }


}
