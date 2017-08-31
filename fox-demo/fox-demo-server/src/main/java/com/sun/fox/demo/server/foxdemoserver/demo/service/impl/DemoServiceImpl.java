package com.sun.fox.demo.server.foxdemoserver.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.fox.demo.server.foxdemoserver.demo.mapper.DemoUsersMapper;
import com.sun.fox.demo.server.foxdemoserver.demo.model.DemoUsers;
import com.sun.fox.demo.server.foxdemoserver.demo.service.DemoService;
import com.sun.fox.mybatis.base.server.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl extends BaseServiceImpl<DemoUsers> implements DemoService {

    @Autowired
    private DemoUsersMapper demoUsersMapper;
    @Override
    public DemoUsers getDemoObj() {
        DemoUsers demoUser = new DemoUsers();
        demoUser.setId(1001L);
        demoUser.setName("测试1");
        demoUser.setLove("足球");
        return demoUser;
    }

    @Override
    public PageInfo<DemoUsers> getPageDemoUser( int page, int size ) {
          PageInfo<DemoUsers> info = PageHelper.startPage(page, size)
                .doSelectPageInfo(
                        () -> demoUsersMapper.getListDemoUSerPage());
        return info;
    }
}
