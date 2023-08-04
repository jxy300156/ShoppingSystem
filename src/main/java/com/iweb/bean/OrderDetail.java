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
public class OrderDetail {
    private String id;
    private String province;
    private String city;
    private String area;
    private String street;
    private String productName;
    private BigDecimal cost;
    private Byte state;
}
