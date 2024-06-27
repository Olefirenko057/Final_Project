package com.example.final_project.dto.responsedDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemResponseDto {
    private Long productId;
    private Integer quantity;
    private Long orderItemId;
    private BigDecimal priceAtPurchase;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("order")
    private OrderResponseDto orderDto;
}
