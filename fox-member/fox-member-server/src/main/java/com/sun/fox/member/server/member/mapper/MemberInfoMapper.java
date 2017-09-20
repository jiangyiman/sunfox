package com.sun.fox.member.server.member.mapper;

import com.sun.fox.member.server.member.model.MemberInfo;
import com.sun.fox.mybatis.base.bmapper.BaseDaoMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberInfoMapper extends BaseDaoMapper<MemberInfo> {
}