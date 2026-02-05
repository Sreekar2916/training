package com.uniquehire.cafe.serviceimpl;

import com.uniquehire.cafe.dto.OrderDetailsDTO;
import com.uniquehire.cafe.dto.OrderRequestDTO;
import com.uniquehire.cafe.dto.OrderResponseDTO;
import com.uniquehire.cafe.dto.ResponseDTO;
import com.uniquehire.cafe.model.Order;
import com.uniquehire.cafe.model.OrderDetails;
import com.uniquehire.cafe.repository.OrderRepository;
import com.uniquehire.cafe.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public ResponseDTO createOrder(OrderRequestDTO request) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            Order order = new Order();
            List<OrderDetails> orderDetails = new ArrayList<>();

            if(Objects.nonNull(request.getOrderNumber())){
                order.setOrderNumber(request.getOrderNumber());
            }

            if(Objects.nonNull(request.getTableName())){
                order.setTableName(request.getTableName());
            }

            if(Objects.nonNull(request.getCreatedBy())){
                order.setCreatedBy(request.getCreatedBy());
                order.setUpdatedBy(request.getCreatedBy());
            }
            order.setCreatedAt(LocalDateTime.now());
            order.setUpdatedAt(LocalDateTime.now());

            List<OrderDetailsDTO> orderDetailsDTOList = request.getOrderDetails();
            for(OrderDetailsDTO detailsDTO : orderDetailsDTOList){
                OrderDetails orderDetail = new OrderDetails();
                if(Objects.nonNull(detailsDTO.getName())){
                    orderDetail.setName(detailsDTO.getName());
                }
                if(Objects.nonNull(detailsDTO.getPrice())){
                    orderDetail.setPrice(detailsDTO.getPrice());
                }
                if(Objects.nonNull(detailsDTO.getType())){
                    orderDetail.setType(detailsDTO.getType());
                }
                if(Objects.nonNull(detailsDTO.getQuantity())){
                    orderDetail.setQuantity(detailsDTO.getQuantity());
                }
                if(Objects.nonNull(detailsDTO.getComments())){
                    orderDetail.setComments(detailsDTO.getComments());
                }
                if(Objects.nonNull(detailsDTO.getCreatedBy())){
                    orderDetail.setCreatedBy(detailsDTO.getCreatedBy());
                    orderDetail.setUpdatedBy(detailsDTO.getCreatedBy());
                }
                orderDetail.setCreatedAt(LocalDateTime.now());
                orderDetail.setUpdatedAt(LocalDateTime.now());
                orderDetail.setOrder(order);
                orderDetails.add(orderDetail);
            }
            order.setOrderDetails(orderDetails);
            Order orderResponse = orderRepository.save(order);
            if(orderResponse != null && orderResponse.getId() != null){
                responseDTO.setMessage("OrderCreated Successfully");
                responseDTO.setStatus(HttpStatus.CREATED.value());
            }

        }catch (Exception e){
            responseDTO.setMessage("OrderCreated Failure");
            responseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            e.printStackTrace();
        }
        return responseDTO;
    }

    @Override
    public List<OrderResponseDTO> getAllOrders() {

        List<Order> orders = orderRepository.findAll();
        List<OrderResponseDTO> ordersResponse = new ArrayList<>();
        for(Order order:orders){

            OrderResponseDTO orderResponseDTO=new OrderResponseDTO();

            if(Objects.nonNull(order.getId()))
                orderResponseDTO.setId(order.getId());

            if(Objects.nonNull(order.getOrderNumber()))
                orderResponseDTO.setOrderNumber(order.getOrderNumber());

            if(Objects.nonNull(order.getTableName()))
                orderResponseDTO.setTableName(order.getTableName());

            if(Objects.nonNull(order.getCreatedBy()))
                orderResponseDTO.setCreatedBy(order.getCreatedBy());

            orderResponseDTO.setCreatedAt(order.getCreatedAt());

            orderResponseDTO.setUpdatedAt(order.getUpdatedAt());

            if(Objects.nonNull(order.getUpdatedBy()))
                orderResponseDTO.setUpdatedBy(order.getUpdatedBy());

            List<OrderDetailsDTO> orderDetails= new ArrayList<>();

            if(Objects.nonNull(order.getOrderDetails())) {
                for (OrderDetails details : order.getOrderDetails()) {

                    OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();


                    orderDetailsDTO.setComments(details.getComments());
                    orderDetailsDTO.setType(details.getType());
                    orderDetailsDTO.setPrice(details.getPrice());
                    orderDetailsDTO.setName(details.getName());
                    orderDetailsDTO.setQuantity(details.getQuantity());
                    orderDetailsDTO.setCreatedBy(details.getCreatedBy());
                    orderDetails.add(orderDetailsDTO);
                }
            }
            orderResponseDTO.setOrderDetails(orderDetails);
            ordersResponse.add(orderResponseDTO);
        }
        return ordersResponse;


    }

    @Override
    public OrderResponseDTO getOrderByID(Long id) {
        return null;
    }
}
