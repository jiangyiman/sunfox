package com.sun.fox.demo.api.client;


import com.sun.fox.demo.api.pojo.DemoDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 测试demo
 */
@FeignClient("fox-demo-server")
public interface DemoClient {

    @GetMapping("/demo/getdemo")
    DemoDto getDemoObj();

}
