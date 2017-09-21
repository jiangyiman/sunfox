package com.sun.fox.member.api.client;

import com.sun.fox.member.api.pojo.MemberInfoDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "bespoke-member-server")
public interface MemberInfoClient {

    @GetMapping(value = "/member_info/by_login_name", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    MemberInfoDto getMemberInfoByLoginName( @RequestParam("login_name") String loginName );
}
