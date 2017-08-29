package com.sun.fox.demo.api.client;


import com.sun.fox.demo.api.pojo.DemoDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 测试demo
 */
@FeignClient("fox-demo-server")
public interface DemoClient {

    @GetMapping(value = "/demo/getdemo1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    DemoDto getDemoObj1();

    @GetMapping("/demo/getdemo2")
    DemoDto getDemoObj2();

    @GetMapping("/demo/getdemo3")
    DemoDto getDemoObj3();

    @GetMapping("/demo/getdemo4")
    DemoDto getDemoObj4();

}
