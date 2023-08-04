package com.iweb.DAO;

import com.iweb.bean.User;
import com.iweb.bean.UserAddress;

/**
 * @author jxy
 * @date
 */
public interface UserAddressDAO {
    boolean add(UserAddress userAddress);
    boolean delete(String aid);
}
