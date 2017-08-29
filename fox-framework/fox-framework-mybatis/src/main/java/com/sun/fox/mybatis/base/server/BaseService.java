package com.sun.fox.mybatis.base.server;

import java.util.List;

public interface BaseService<T>{
    int insert(T record);
    int insertSelective(T record);
    int updateByPrimaryKey(T record);
    int updateByPrimaryKeySelective(T record);
    int delete(T record);
    int deleteByPrimaryKey(Object key);

    List<T> select( T record);
    T selectByPrimaryKey(Object key);

    List<T> selectAll();
    T selectOne(T record);
    T selectByPrimaryKey(String key);

    int selectCount(T record);


    int insertList(List<T> recordList);
    int insertUseGeneratedKeys(T record);
    List<T> selectByIds(String ids);
    int deleteByIds(String ids);

}
