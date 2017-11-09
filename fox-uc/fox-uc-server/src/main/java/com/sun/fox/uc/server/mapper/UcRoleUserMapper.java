package com.sun.fox.uc.server.mapper;

import com.sun.fox.mybatis.base.bmapper.BaseDaoMapper;
import com.sun.fox.uc.server.model.UcRoleUser;
import com.sun.fox.uc.server.model.UcRoles;
import com.sun.fox.uc.server.model.UcUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UcRoleUserMapper extends BaseDaoMapper<UcRoleUser> {

    Set<UcRoles> getRoleByUserId( @Param("userId") Long userId );
}