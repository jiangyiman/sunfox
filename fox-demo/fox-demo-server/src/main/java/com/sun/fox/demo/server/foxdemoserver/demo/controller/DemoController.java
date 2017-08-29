package com.sun.fox.demo.server.foxdemoserver.demo.controller;

import com.sun.fox.demo.api.client.DemoClient;
import com.sun.fox.demo.api.pojo.DemoDto;
import com.sun.fox.demo.server.foxdemoserver.demo.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("DemoApi")
@RestController
@RequestMapping("/demo")
public class DemoController implements DemoClient {


    @Autowired
    private DemoService demoService;

    @ApiOperation(value = "demo", notes = "查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @GetMapping("/getdemo")
    public DemoDto getDemoObj() {
        return demoService.getDemoObj();
    }
    @ApiOperation(value = "demo", notes = "查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @Override
    public DemoDto getDemoObj1() {
        return demoService.getDemoObj();
    }

    @ApiOperation(value = "demo", notes = "查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @Override
    public DemoDto getDemoObj2() {
        return demoService.getDemoObj();
    }
    @ApiOperation(value = "demo", notes = "查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @Override
    public DemoDto getDemoObj3() {
        return demoService.getDemoObj();
    }
    @ApiOperation(value = "demo", notes = "查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @Override
    public DemoDto getDemoObj4() {
        return demoService.getDemoObj();
    }
}
