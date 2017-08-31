package com.sun.fox.mybatis.base.server.impl;

import com.sun.fox.mybatis.base.bmapper.BaseDaoMapper;
import com.sun.fox.mybatis.base.server.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 基础Service
 *
 * @param <T>
 */
@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseDaoMapper<T> baseDaoMapper;

    @Override
    public int insert( T record ) {
        return baseDaoMapper.insert(record);
    }

    @Override
    public int insertSelective( T record ) {

        return baseDaoMapper.insertSelective(record);
    }
    @Override
    public int insertList( List<T> recordList ) {
        return baseDaoMapper.insertList(recordList);
    }

    @Override
    public int insertUseGeneratedKeys( T record ) {
        return baseDaoMapper.insertUseGeneratedKeys(record);
    }

    @Override
    public int updateByPrimaryKey( T record ) {
        return baseDaoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective( T record ) {
        return baseDaoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey( Object key ) {
        return baseDaoMapper.deleteByPrimaryKey(key);
    }
    @Override
    public int deleteByIds( String ids ) {
        return baseDaoMapper.deleteByIds(ids);
    }

    @Override
    public List<T> select( T record ) {
        return baseDaoMapper.select(record);
    }
    @Override
    public T selectByPrimaryKey( Object key ) {
        return (T) baseDaoMapper.selectByPrimaryKey(key);
    }
    @Override
    public List<T> selectByIds( String ids ) {
        return baseDaoMapper.selectByIds(ids);
    }


}
