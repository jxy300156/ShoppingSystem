package com.iweb.DAO;


import com.iweb.bean.Admin;

/**
 * @author jxy
 * @date
 */
public interface AdminDAO {
    /**
     * 实现管理员登录，根据传入的admin参数，管理员用户是否在数据库中存在
     * 若存在则返回该Admin类型的对象
     * @param admin
     * @return
     */
    Admin login(Admin admin);

    /**
     * 在注册的时候，对注册时的用户名进行判断，若相应的管理员用户存在数大于1
     * 返回false，否则返回true
     * @param username
     * @return
     */
    boolean verifyUsername(String username);

    /**
     * 实现管理员注册功能，将注册的管理员用户数据添加到数据库中
     * 如果执行成功的语句数大于0，则返回true，否则返回false
     * @param admin
     * @return
     */
    boolean addAdmin(Admin admin);
}
