package com.sun.fox.uc.server.model;

import com.sun.fox.mybatis.base.model.BaseModel;
import java.util.Date;
import javax.persistence.*;

@Table(name = "uc_resources")
public class UcResources extends BaseModel {
    @Id
    private Long id;

    @Column(name = "resources_name")
    private String resourcesName;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user")
    private Long createUser;

    @Column(name = "last_time")
    private Date lastTime;

    @Column(name = "last_user")
    private Long lastUser;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return resources_name
     */
    public String getResourcesName() {
        return resourcesName;
    }

    /**
     * @param resourcesName
     */
    public void setResourcesName(String resourcesName) {
        this.resourcesName = resourcesName == null ? null : resourcesName.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return create_user
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * @return last_time
     */
    public Date getLastTime() {
        return lastTime;
    }

    /**
     * @param lastTime
     */
    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    /**
     * @return last_user
     */
    public Long getLastUser() {
        return lastUser;
    }

    /**
     * @param lastUser
     */
    public void setLastUser(Long lastUser) {
        this.lastUser = lastUser;
    }
}