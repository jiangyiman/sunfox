package com.sun.fox.demo.server.foxdemoserver.demo.service;

import com.github.pagehelper.PageInfo;
import com.sun.fox.demo.server.foxdemoserver.demo.model.DemoUsers;
import com.sun.fox.mybatis.base.server.BaseService;

/**
 * 获取测试信息
 */
public interface DemoService extends BaseService<DemoUsers>{

     DemoUsers getDemoObj();

     PageInfo<DemoUsers> getPageDemoUser( int page, int size);
}
