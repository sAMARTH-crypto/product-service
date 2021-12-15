package com.product.service.service;

import com.product.service.model.Customer;
import com.product.service.model.Orders;
import com.product.service.repo.CustomerRepository;
import com.product.service.repo.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  @Autowired
  CustomerRepository customerRepository;

  @Autowired
  OrderRepository orderRepository;

  public List<Customer> findAll() {
    return customerRepository.findAll();
  }

  public Customer getById(Long id) {
    return customerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Customer Not found"));
  }

  public List<Orders> getCustomerOrders(Long customerId) {
    Customer customer = getById(customerId);
    return orderRepository.findAllByCustomer(customer);
  }

  public Orders getOrderById(Long customerId, Long orderId) {
    return orderRepository.findById(orderId)
        .orElseThrow(() -> new RuntimeException("Order Not found"));
  }

}
