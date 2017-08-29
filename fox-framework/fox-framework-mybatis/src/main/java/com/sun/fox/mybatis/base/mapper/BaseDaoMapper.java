package com.sun.fox.mybatis.base.mapper;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface BaseDaoMapper<T> extends BaseMapper<T> ,IdsMapper<T>,MySqlMapper<T>,ConditionMapper<T> {

}
