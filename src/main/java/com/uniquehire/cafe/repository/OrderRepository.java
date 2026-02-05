package com.uniquehire.cafe.repository;

import com.uniquehire.cafe.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
