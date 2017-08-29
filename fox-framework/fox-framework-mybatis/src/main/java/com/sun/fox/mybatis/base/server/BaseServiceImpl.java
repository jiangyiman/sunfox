package com.sun.fox.mybatis.base.server;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseServiceImpl implements BaseService{

    @Override
    public int insert( Object record ) {
        return 0;
    }

    @Override
    public int insertSelective( Object record ) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey( Object record ) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective( Object record ) {
        return 0;
    }

    @Override
    public int delete( Object record ) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey( Object key ) {
        return 0;
    }

    @Override
    public List select( Object record ) {
        return null;
    }

    @Override
    public Object selectByPrimaryKey( Object key ) {
        return null;
    }

    @Override
    public List selectAll() {
        return null;
    }

    @Override
    public Object selectOne( Object record ) {
        return null;
    }

    @Override
    public Object selectByPrimaryKey( String key ) {
        return null;
    }

    @Override
    public int selectCount( Object record ) {
        return 0;
    }

    @Override
    public int insertList( List recordList ) {
        return 0;
    }

    @Override
    public int insertUseGeneratedKeys( Object record ) {
        return 0;
    }

    @Override
    public List selectByIds( String ids ) {
        return null;
    }

    @Override
    public int deleteByIds( String ids ) {
        return 0;
    }
}
