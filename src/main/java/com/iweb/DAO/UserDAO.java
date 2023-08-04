package com.iweb.DAO;

import com.iweb.bean.User;

/**
 * @author jxy
 * @date
 */
public interface UserDAO {
    /**
     * 实现用户登录，根据传入的user参数，用户是否在数据库中存在
     * 若存在则返回该User类型的对象
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 在注册的时候，对注册时的用户名进行判断，若相应的用户存在数大于1
     * 返回false，否则返回true
     * @param username
     * @return
     */
    boolean verifyUsername(String username);

    /**
     * 实现用户注册功能，将注册的用户数据添加到数据库中
     * 如果执行成功的语句数大于0，则返回true，否则返回false
     * @param user
     * @return
     */
    boolean addUser(User user);
}
