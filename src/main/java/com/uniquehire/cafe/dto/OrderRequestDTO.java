package com.uniquehire.cafe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {
    private String orderNumber;
    private String tableName;
    private String createdBy;
    private List<OrderDetailsDTO> orderDetails;

}
