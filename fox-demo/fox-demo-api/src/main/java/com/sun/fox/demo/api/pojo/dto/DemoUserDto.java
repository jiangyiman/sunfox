package com.sun.fox.demo.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *  DemoUser 出参
 */
@ApiModel(description = "Demo用户信息")
public class DemoUserDto {
    @ApiModelProperty(value = "用户id")
    private Long id;
    @ApiModelProperty(value = "用户Name")
    private String name;
    @ApiModelProperty(value = "用户爱好")
    private String love;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
