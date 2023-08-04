package com.iweb.bean.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jxy
 * @date
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVo<T> {
    private boolean isOk;
    private String mess;
    private T t;
}
