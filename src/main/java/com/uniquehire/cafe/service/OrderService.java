package com.uniquehire.cafe.service;

import com.uniquehire.cafe.dto.OrderRequestDTO;
import com.uniquehire.cafe.dto.ResponseDTO;
import org.springframework.stereotype.Service;

public interface OrderService {
    public ResponseDTO createOrder(OrderRequestDTO request);
    public void getAllOrders();
    public void getOrderByID(Long id);
}
