package com.iweb.service;



import com.iweb.bean.Address;
import com.iweb.bean.User;

import java.util.List;

/**
 * @author jxy
 * @date
 */
public interface AddressService {
    List<Address> list(String uid);
    boolean add(Address address, String userId);
    boolean delete(String id);
    boolean update(Address address);
    Address get(String id);
}
