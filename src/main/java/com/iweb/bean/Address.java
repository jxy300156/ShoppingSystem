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
public class Address {
    private String id;
    private String province;
    private String city;
    private String area;
    private String street;
}
