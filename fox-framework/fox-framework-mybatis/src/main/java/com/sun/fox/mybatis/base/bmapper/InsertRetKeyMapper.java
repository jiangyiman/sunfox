package com.sun.fox.mybatis.base.bmapper;

import com.sun.fox.mybatis.base.bmapper.impl.InsertRetKeyProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;

import java.util.List;

/**
 *  返回ID 插入扩展 MySql
 * @param <T>
 */
public interface InsertRetKeyMapper<T> {

    /**
     *  返回插入Id
     * @param record
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id" )
    @InsertProvider(type = InsertRetKeyProvider.class, method = "dynamicSQL")
    int insertRetObjSelective(T record);

    /**
     *  返回插入Id  未实现 可以在base Service 实现
     * @param record
     * @return
     */
    @Deprecated
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @InsertProvider(type = InsertRetKeyProvider.class, method = "dynamicSQL")
    int insertRetKeySelective(T record);

    /**
     *  返回插入Ids
     * @param recordList
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @InsertProvider(type = InsertRetKeyProvider.class, method = "dynamicSQL")
    int insertRetListObjSelective(List<T> recordList);
}
