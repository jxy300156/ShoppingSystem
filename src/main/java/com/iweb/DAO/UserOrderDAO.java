package com.iweb.DAO;

import com.iweb.bean.UserOrder;

/**
 * @author jxy
 * @date
 */
public interface UserOrderDAO {
    boolean add(UserOrder userOrder);
    boolean delete(String oid);
}
