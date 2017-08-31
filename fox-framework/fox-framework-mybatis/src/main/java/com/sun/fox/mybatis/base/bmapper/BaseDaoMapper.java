package com.sun.fox.mybatis.base.bmapper;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.MySqlMapper;

@SuppressWarnings("rawtypes")
public interface BaseDaoMapper<T> extends BaseMapper<T> ,IdsMapper<T>,MySqlMapper<T>,ConditionMapper<T> {

}
