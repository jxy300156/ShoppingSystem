package com.iweb.service;

import com.iweb.bean.Category;

import java.util.List;

/**
 * @author jxy
 * @date
 */
public interface CategoryService {
    /**
     * 列出所有的商品分类信息
     * @return 返回Category类型的集合
     */
    List<Category> list(int pageIndex,int pageSize);

    /**
     * 计算当前页面中的分类数据数量
     * @return
     */
    int count();

    /**
     * 添加商品分类
     * @param category 作为被插入数据参数传入
     * @return
     */
    boolean add(Category category);

    /**
     * 删除对应商品分类
     * @param id 作为被删除分类的id参数传入
     * @return
     */
    boolean delete(String id);


    /**
     * 获取对应商品分类对象
     * @param id 作为获取分类对象的id传入
     * @return
     */
    Category get(String id);

    List<Category> queryAllCategory();
    List<Category> list();
}
