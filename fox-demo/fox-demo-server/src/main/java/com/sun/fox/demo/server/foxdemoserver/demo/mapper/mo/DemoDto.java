package com.sun.fox.demo.server.foxdemoserver.demo.mapper.mo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(description = "Demo用户信息")
@Table(name = "return_order")
public class DemoDto {

    @Id
    @ApiModelProperty(value = "用户id")
    private String id;
    @Column(name = "name")
    @ApiModelProperty(value = "用户Name")
    private String name;
    @Column(name = "love")
    @ApiModelProperty(value = "用户爱好")
    private String love;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
