package com.sun.fox.demo.server.foxdemoserver.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.fox.demo.api.client.DemoClient;
import com.sun.fox.demo.api.pojo.DemoDto;
import com.sun.fox.demo.server.foxdemoserver.demo.model.DemoUsers;
import com.sun.fox.demo.server.foxdemoserver.demo.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Api("DemoUser  API 增删改查")
@RestController
@RequestMapping("/demoUser")
public class DemoController implements DemoClient {


    @Autowired
    private DemoService demoService;

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "分页获取Demo用户数据", notes = "demo list query")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, defaultValue = "1", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页数量", required = true, defaultValue = "10", dataType = "int", paramType = "query"),
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DemoDto getPageDemoUser( Integer page, Integer size ) {
        PageInfo<DemoUsers> info = demoService.getPageDemoUser(page, size);
        return null;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "新增Demo", notes = "demo add")
    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int addDemoUser( DemoDto vo ) {
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "依据id删除", notes = "demo delete")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "id", value = "页码", required = true, dataType = "int", paramType = "path")
    })
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int deleteDemoUser( Long id ) {
        return demoService.deleteByPrimaryKey(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "依据id修改", notes = "demo update")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "id", value = "页码", required = true, dataType = "int", paramType = "path")
    })
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int updateDemoUser( Long id, DemoDto vo ) {
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "依据Id查询Demo", notes = "demo query by  id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "id", value = "页码", required = true, dataType = "int", paramType = "path")
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DemoDto getDemoUserById( Long id ) {
        DemoUsers du = demoService.selectByPrimaryKey(id);
        return null;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "测试demo", notes = "demo query test")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header")
    })
    @GetMapping(value = "/getdemo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DemoDto getDemoObj1() {
        DemoUsers du = demoService.getDemoObj();
        return null;
    }
}
