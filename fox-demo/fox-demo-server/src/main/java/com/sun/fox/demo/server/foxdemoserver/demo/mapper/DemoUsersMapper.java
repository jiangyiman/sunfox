package com.sun.fox.demo.server.foxdemoserver.demo.mapper;

import com.sun.fox.demo.server.foxdemoserver.demo.model.DemoUsers;
import com.sun.fox.mybatis.base.bmapper.BaseDaoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoUsersMapper extends BaseDaoMapper<DemoUsers> {

    //@Select("select *  from demo_users order by id desc")
    List<DemoUsers> getListDemoUSerPage();
}