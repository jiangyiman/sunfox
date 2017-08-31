package com.sun.fox.mybatis.base.server.impl;

import com.sun.fox.mybatis.base.bmapper.BaseDaoMapper;
import com.sun.fox.mybatis.base.model.BaseModel;
import com.sun.fox.mybatis.base.server.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 基础Service
 *
 * @param <T>
 */
@Service
public abstract class BaseServiceImpl<T extends BaseModel> implements BaseService<T> {

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

    /**
     * 返回插入对象
     *
     * @param record
     * @return
     */
    @Override
    public T insertRetObjSelective( T record ) {
        baseDaoMapper.insertRetObjSelective(record);
        return record;
    }

    /**
     * 返回插入Id
     *
     * @param record
     * @return
     */
    @Override
    public Long insertRetKeySelective( T record ) {
        baseDaoMapper.insertRetObjSelective(record);
        return record.getId();
    }

    /**
     * 返回插入Ids
     *
     * @param recordList
     * @return
     */
    @Override
    public List<T> insertRetListObjSelective( List<T> recordList ) {
        baseDaoMapper.insertRetListObjSelective(recordList);
        return recordList;
    }

    @Override
    public List<Long> insertRetListKeySelective(List<T> recordList){
        baseDaoMapper.insertRetListObjSelective(recordList);
        List<Long> list = recordList.stream().map(T::getId).collect(Collectors.toList());
        return  list;
    }

}
