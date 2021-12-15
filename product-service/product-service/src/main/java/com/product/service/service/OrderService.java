package com.product.service.service;

import com.product.service.model.Orders;
import com.product.service.repo.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  @Autowired
  OrderRepository ordersRepository;

  public Orders create(Orders orders) {
    return ordersRepository.save(orders);
  }

  public void delete(Long id) {
    Orders Orders =
        ordersRepository.findById(id).orElseThrow(() -> new RuntimeException("Orders Not found"));
    ordersRepository.delete(Orders);
  }

  public List<Orders> findAll() {
    return ordersRepository.findAll();
  }

  public Orders update(Long id, Orders orders) {
    Orders u =
        ordersRepository.findById(id).orElseThrow(() -> new RuntimeException("Orders Not found"));
    u.setDate(orders.getDate());
    u.setPayment(orders.getPayment());
    u.setTotal(orders.getTotal());
    return ordersRepository.save(u);
  }

  public Orders getById(Long id) {
    return ordersRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Orders Not found"));
  }

  public void deleteAll() {
    ordersRepository.deleteAll();
  }

  public void updateAll(Orders orders) {
    for (Orders u : findAll()) {
      u.setDate(orders.getDate());
      u.setPayment(orders.getPayment());
      u.setTotal(orders.getTotal());
      ordersRepository.save(u);
    }
  }
}
