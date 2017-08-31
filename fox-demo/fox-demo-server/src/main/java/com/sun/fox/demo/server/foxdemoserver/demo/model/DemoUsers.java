package com.sun.fox.demo.server.foxdemoserver.demo.model;

import com.sun.fox.mybatis.base.model.BaseModel;
import javax.persistence.*;

@Table(name = "demo_users")
public class DemoUsers extends BaseModel {
    /**
     * 用户ID
     */
    @Id
    private Long id;

    /**
     * 姓名
     */
    @Column(name="name")
    private String name;

    /**
     * 爱好
     */
    @Column(name="love")
    private String love;

    /**
     * 获取用户ID
     *
     * @return id - 用户ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置用户ID
     *
     * @param id 用户ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取爱好
     *
     * @return love - 爱好
     */
    public String getLove() {
        return love;
    }

    /**
     * 设置爱好
     *
     * @param love 爱好
     */
    public void setLove(String love) {
        this.love = love == null ? null : love.trim();
    }
}