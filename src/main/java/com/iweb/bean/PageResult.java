package com.iweb.bean;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    private int total;
    private List<T> data;
}
