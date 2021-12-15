package com.product.service.repo;

import com.product.service.model.Customer;
import com.product.service.model.Orders;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {


  List<Orders> findAllByCustomer(Customer customer);

}
