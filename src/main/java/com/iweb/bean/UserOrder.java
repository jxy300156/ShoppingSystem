package com.iweb.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jxy
 * @date
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserOrder {
    private String id;
    private String userId;
    private String orderId;
}
