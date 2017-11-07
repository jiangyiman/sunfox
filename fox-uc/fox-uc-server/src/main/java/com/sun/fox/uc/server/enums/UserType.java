package com.sun.fox.uc.server.enums;

import com.sun.fox.mybatis.base.enums.BaseEnum;

/**
 * 用户类型
 */
public enum UserType implements BaseEnum {
    SYS_ADMIN(1, "系统用户"),
    COMP_USER(2, "组织用户");

    private Integer value;
    private String desc;

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public String desc() {
        return desc;
    }

    UserType( Integer value, String desc ) {
        this.value = value;
        this.desc = desc;
    }


    public static UserType of( Integer value ) {
        if (value == null) {
            return null;
        }
        for (UserType type : values()) {
            if (type.value.equals(value.intValue())) {
                return type;
            }
        }
        return null;
    }
}
