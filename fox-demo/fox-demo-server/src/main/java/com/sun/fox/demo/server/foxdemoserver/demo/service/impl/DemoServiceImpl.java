package com.sun.fox.demo.server.foxdemoserver.demo.service.impl;

import com.sun.fox.demo.api.pojo.DemoDto;
import com.sun.fox.demo.server.foxdemoserver.demo.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public DemoDto getDemoObj() {
        DemoDto dto = new DemoDto();
        dto.setId("10000118");
        dto.setLove("足球");
        dto.setName("茅茹");
        return dto;
    }
}
