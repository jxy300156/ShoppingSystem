package com.iweb.service.impl;

import com.iweb.DAO.CartDAO;
import com.iweb.DAO.UserCartDAO;
import com.iweb.DAO.impl.CartDAOImpl;
import com.iweb.DAO.impl.UserCartDAOImpl;
import com.iweb.bean.Cart;
import com.iweb.bean.UserCart;
import com.iweb.service.CartService;
import com.iweb.util.UUIDUtil;

import java.util.List;

/**
 * @author jxy
 * @date
 */
public class CartServiceImpl implements CartService {
    private CartDAO cartDAO = new CartDAOImpl();
    private UserCartDAO userCartDAO = new UserCartDAOImpl();
    @Override
    public List<Cart> list(String uid) {
        return cartDAO.list(uid);
    }

    @Override
    public boolean add(Cart cart,String userId) {
        cart.setId(UUIDUtil.uuid());
        boolean isAdd = cartDAO.add(cart);
        if(isAdd){
            UserCart userCart = new UserCart();
            userCart.setId(UUIDUtil.uuid());
            userCart.setUserId(userId);
            userCart.setCartId(cart.getId());
            boolean addToUserCart = userCartDAO.add(userCart);
            if(addToUserCart){
                return true;
            }else {return false;}
        }else {
            return false;
        }
    }

    @Override
    public boolean update(Cart cart) {
        return cartDAO.update(cart);
    }

    @Override
    public boolean delete(String id) {
        boolean isDelete = cartDAO.delete(id);
        if(isDelete){
            boolean deleteUserCart = userCartDAO.delete(id);
            if(deleteUserCart){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public Cart get(String id) {
        return cartDAO.get(id);
    }

}
