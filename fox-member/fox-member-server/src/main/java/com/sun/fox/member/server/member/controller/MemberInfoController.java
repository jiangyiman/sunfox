package com.sun.fox.member.server.member.controller;

import com.sun.fox.demo.api.pojo.dto.DemoUserDto;
import com.sun.fox.demo.api.pojo.vo.DemoUserVo;
import com.sun.fox.member.server.member.service.MemberInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/member_info")
@EnableOAuth2Sso
public class MemberInfoController {

    @Autowired
    private MemberInfoService memberInfoService;

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "新增Demo", notes = "demo add")
    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Boolean addMemberUser( @RequestBody DemoUserVo vo ) {
        return null;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "依据id删除", notes = "demo delete")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "id", value = "会员id", required = true, dataType = "int", paramType = "path")
    })
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int deleteDemoUser(@PathVariable("id") Long id ) {

        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "依据id修改", notes = "demo update")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "id", value = "页码", required = true, dataType = "int", paramType = "path")
    })
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int updateDemoUser(@PathVariable("id") Long id,@RequestBody DemoUserVo vo ) {
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "依据Id查询Demo", notes = "demo query by  id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "id", value = "页码", required = true, dataType = "int", paramType = "path")
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DemoUserDto getDemoUserById(@PathVariable("id") Long id ) {
        return null;
    }

}
