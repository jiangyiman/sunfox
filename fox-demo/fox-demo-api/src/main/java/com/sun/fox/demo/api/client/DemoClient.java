package com.sun.fox.demo.api.client;


import com.sun.fox.demo.api.pojo.DemoDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 测试demo
 */
@FeignClient("fox-demo-server")
public interface DemoClient {

    /**
     * 分页查询
     * @return
     */
    @GetMapping(value = "/demoUser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    DemoDto getPageDemoUser( @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                             @RequestParam(value = "size", required = false, defaultValue = "20") Integer size);

    /**
     * 新增
     * @param vo
     * @return
     */
    @PostMapping(value = "/demoUser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    int addDemoUser(@RequestBody DemoDto vo);


    /**
     *  依据ID删除
     * @param id
     */
    @DeleteMapping(value = "/demoUser/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    int deleteDemoUser(@PathVariable("id") Long id);

    /**
     *  依据Id更新数据
     * @param id
     * @return
     */
    @PutMapping(value = "/demoUser/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    int updateDemoUser(@PathVariable("id") Long id,@RequestBody DemoDto vo);

    /**
     *  依据Id查询
     * @return
     */
    @GetMapping(value = "/demoUser/{id}/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    DemoDto getDemoUserById(@PathVariable("id") Long id);

    ///////////////////////////////////
    @GetMapping(value = "/demoUser/getdemo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    DemoDto getDemoObj1();

}
