package com.sun.fox.mybatis.base.server;

import java.util.List;

public interface BaseService<T>{
    /**
     *  插入
     * @param record
     * @return
     */
    int insert(T record);

    /**
     *  匹配插入
     * @param record
     * @return
     */
    int insertSelective(T record);

    /**
     *  批量插入--数据库Id 自增
     * @param recordList
     * @return
     */
    int insertList(List<T> recordList);

    /**
     *  批量插入id自己输入
     * @param record
     * @return
     */
    int insertUseGeneratedKeys(T record);


    /**
     *  依据id更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(T record);

    /**
     *  依据ID 匹配跟新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(T record);

    /**
     *
     * @param key
     * @return
     */
    int deleteByPrimaryKey(Object key);

    /**
     *  批量查询
     * @param ids
     * @return
     */
    int deleteByIds(String ids);



    /**
     * 多条件查询列表信息
     * @param record
     * @return
     */
    List<T> select( T record);

    /***
     * 依据Id查询数据
     * @param key
     * @return
     */
    T selectByPrimaryKey(Object key);



    /**
     *  多Ids  批量查询
     * @param ids
     * @return
     */
    List<T> selectByIds(String ids);


}
