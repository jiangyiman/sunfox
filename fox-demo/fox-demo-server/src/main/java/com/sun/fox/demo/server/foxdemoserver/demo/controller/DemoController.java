package com.sun.fox.demo.server.foxdemoserver.demo.controller;

import com.sun.fox.demo.api.foxdemoapi.client.DemoClient;
import com.sun.fox.demo.api.foxdemoapi.pojo.DemoDto;
import com.sun.fox.demo.server.foxdemoserver.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController implements DemoClient {

    @Autowired
    private DemoService demoService;

    @GetMapping("/getdemo")
    @Override
    public DemoDto getDemoObj() {
        return null;
    }
}
