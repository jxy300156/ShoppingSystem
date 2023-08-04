package com.iweb.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jxy
 * @date
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCate {
    private int id;
    private String productId;
    private String categoryId;
}
