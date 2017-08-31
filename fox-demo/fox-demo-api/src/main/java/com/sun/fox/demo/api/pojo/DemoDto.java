package com.sun.fox.demo.api.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 出餐
 */
@ApiModel(description = "Demo用户信息")
public class DemoDto {


    @ApiModelProperty(value = "用户id")
    private String id;
    @NotEmpty(message = "用户名不能为空")
    @ApiModelProperty(value = "用户Name")
    private String name;
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
