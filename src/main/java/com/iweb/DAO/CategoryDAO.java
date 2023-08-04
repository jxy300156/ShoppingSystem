package com.iweb.DAO;

import com.iweb.bean.Category;

import java.util.List;

/**
 * @author jxy
 * @date
 */
public interface CategoryDAO {

    /**
     * 分页查询数据库中的所有商品分类信息，存入到集合，
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<Category> list(int pageIndex,int pageSize);

    /**
     * 计算当前页面的数据数
     * @return
     */
    int count();

    /**
     * 通过传入的分类参数进行向数据库中的商品分类插入数据
     * 如果执行成功的语句数大于0则返回true，否则返回false
     * @param category 作为被插入数据参数传入
     * @return
     */
    boolean add(Category category);

    /**
     * 通过传入的分类id参数进行删除数据库中的商品分类中的对应数据
     * 如果执行成功的语句数大于0则返回true，否则返回false
     * @param id 作为被删除分类的id参数传入
     * @return
     */
    boolean delete(String id);


    /**
     * 通过分类id获取对应的分类对象
     * @param id 作为获取分类对象的id传入
     * @return
     */
    Category get(String id);

    /**
     * 在添加分类信息是，通过传入的分类名称进行判断，如果数据库中存在
     * 重复的数据数大于0，则返回false，否则返回true
     * @param name 作为判断的分类名称参数传入
     * @return
     */
    boolean verifyName(String name);

    List<Category> queryAllCategory();
    List<Category> list();
}
