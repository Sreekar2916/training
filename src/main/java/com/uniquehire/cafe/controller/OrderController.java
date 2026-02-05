package com.uniquehire.cafe.controller;

import com.uniquehire.cafe.dto.OrderRequestDTO;
import com.uniquehire.cafe.dto.OrderResponseDTO;
import com.uniquehire.cafe.dto.ResponseDTO;
import com.uniquehire.cafe.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseDTO createOrder(@RequestBody OrderRequestDTO request){
        System.out.println("Entered to Controller: OrderController,  method(): createOrder");
        ResponseDTO responseDTO = null;
        if(request != null){
            responseDTO = orderService.createOrder(request);
        }
        return responseDTO;
    }

    @GetMapping("/getOrders")
    public List<OrderResponseDTO> getAllOrders(){
        return orderService.getAllOrders();


    }

    @GetMapping("/getOrders/{id}")
    public void getOrderByID(@PathVariable Long id){

    }
}
