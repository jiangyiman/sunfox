package com.sun.fox.demo.server.foxdemoserver.demo.controller;

import com.sun.fox.demo.api.client.DemoClient;
import com.sun.fox.demo.api.pojo.DemoDto;
import com.sun.fox.demo.server.foxdemoserver.demo.service.DemoService;
import com.sun.fox.fk.swagger.properties.SwaggerAutoConfig;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@Api("测试接口")
public class DemoController implements DemoClient {

    @Autowired
    private DemoService demoService;

    @Autowired
    SwaggerAutoConfig swaggerAutoConfig;

    @GetMapping("/getdemo")
    @Override
    public DemoDto getDemoObj() {

        swaggerAutoConfig.getDefual();
        return demoService.getDemoObj();
    }
}
