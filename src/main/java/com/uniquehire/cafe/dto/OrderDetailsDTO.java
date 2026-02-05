package com.uniquehire.cafe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDTO {
    private String name;
    private Double price;
    private Integer quantity;
    private String type;
    private String comments;
    private String createdBy;
}
