package com.iweb.DAO;

import com.iweb.bean.Address;

import java.util.List;

/**
 * @author jxy
 * @date
 */
public interface AddressDAO {
    List<Address> list(String uid);
    boolean add(Address address);
    boolean delete(String id);
    boolean update(Address address);
    Address get(String id);
}
