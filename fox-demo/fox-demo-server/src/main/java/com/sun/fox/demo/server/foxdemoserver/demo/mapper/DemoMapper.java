package com.sun.fox.demo.server.foxdemoserver.demo.mapper;

import com.sun.fox.demo.server.foxdemoserver.demo.mapper.mo.DemoDto;
import com.sun.fox.mybatis.base.mapper.BaseDaoMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoMapper extends BaseDaoMapper<DemoDto> {

}
