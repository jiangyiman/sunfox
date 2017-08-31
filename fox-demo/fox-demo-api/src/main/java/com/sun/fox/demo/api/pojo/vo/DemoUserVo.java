package com.sun.fox.demo.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *  DemoUser 出参
 */
@ApiModel(description = "Demo用户信息")
public class DemoUserVo {

    @NotEmpty(message = "用户名不能为空")
    @ApiModelProperty(value = "用户Name")
    private String name;
    @ApiModelProperty(value = "用户爱好")
    private String love;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }
}
