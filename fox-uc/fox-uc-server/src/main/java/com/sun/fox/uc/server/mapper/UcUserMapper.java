package com.sun.fox.uc.server.mapper;

import com.sun.fox.mybatis.base.bmapper.BaseDaoMapper;
import com.sun.fox.uc.server.model.UcUser;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UcUserMapper extends BaseDaoMapper<UcUser> {

    @Select("SELECT * FROM uc_user WHERE username = #{ username }")
    UcUser getUcUserByUserName( String username);
}