package com.uniquehire.cafe.repository;

import com.uniquehire.cafe.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

}
