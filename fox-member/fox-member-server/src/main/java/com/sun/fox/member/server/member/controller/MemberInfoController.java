package com.sun.fox.member.server.member.controller;

import com.sun.fox.member.api.client.MemberInfoClient;
import com.sun.fox.member.api.pojo.MemberInfoDto;
import com.sun.fox.member.server.member.model.MemberInfo;
import com.sun.fox.member.server.member.service.MemberInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/member_info")
public class MemberInfoController implements MemberInfoClient {

    @Autowired
    private MemberInfoService memberInfoService;



    @GetMapping(value = "/by_login_name", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MemberInfoDto getMemberInfoByLoginName( @RequestParam("login_name") String loginName) {
        MemberInfo info = new MemberInfo();
        info.setLoginName(loginName);
        MemberInfo member = memberInfoService.selectOne(info);
        MemberInfoDto dto = new MemberInfoDto();
        if(member !=null){
            BeanUtils.copyProperties(member,dto);
            return dto;
        }
        return null;
    }

}
