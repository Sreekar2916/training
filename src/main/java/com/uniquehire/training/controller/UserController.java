package com.uniquehire.training.controller;

import com.uniquehire.cafe.dto.OrderRequestDTO;
import com.uniquehire.cafe.dto.ResponseDTO;
import com.uniquehire.cafe.service.OrderService;
import com.uniquehire.training.dto.UserRequestDTO;
import com.uniquehire.training.dto.UserResponseDTO;
import com.uniquehire.training.model.User;
import com.uniquehire.training.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    private OrderService orderService;


    public UserController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @PostMapping
    public User createUser(@RequestBody UserRequestDTO user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<UserResponseDTO> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("order")
    public ResponseDTO createOrder(@RequestBody OrderRequestDTO request){
        System.out.println("Entered to Controller: OrderController,  method(): createOrder");
        ResponseDTO responseDTO = null;
        if(request != null){
            responseDTO = orderService.createOrder(request);
        }
        return responseDTO;
    }
}
