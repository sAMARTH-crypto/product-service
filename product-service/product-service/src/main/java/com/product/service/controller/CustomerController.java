package com.product.service.controller;

import com.product.service.service.CustomerService;
import com.product.service.model.Customer;
import com.product.service.model.Orders;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/customers")
public class CustomerController {

  @Autowired
  CustomerService customerService;

  @GetMapping
  public List<Customer> findAll() {
    return customerService.findAll();
  }

  @GetMapping("/{id}")
  public Customer get(@PathVariable Long id) {
    return customerService.getById(id);
  }

  @GetMapping("/{customerId}/orders")
  public List<Orders> getCustomerOrder(@PathVariable Long customerId) {
    return customerService.getCustomerOrders(customerId);
  }

  @GetMapping("/{customerId}/orders/{orderId}")
  public Orders getOrderById(@PathVariable("customerId") Long customerId,
      @PathVariable("orderId") Long orderId) {
    return customerService.getOrderById(customerId, orderId);
  }
}
