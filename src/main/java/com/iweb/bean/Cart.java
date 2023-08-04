package com.iweb.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author jxy
 * @date
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private String id;
    private String productName;
    private Integer quantity;
    private BigDecimal totalPrice;
}
