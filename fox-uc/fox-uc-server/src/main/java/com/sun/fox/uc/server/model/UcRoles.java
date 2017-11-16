package com.sun.fox.uc.server.model;

import com.sun.fox.mybatis.base.model.BaseModel;
import java.util.Date;
import javax.persistence.*;

@Table(name = "uc_roles")
public class UcRoles extends BaseModel {
    @Id
    private Long id;

    @Column(name = "role_name")
    private String roleName;
    @Column(name = "role_code")
    private String roleCode;

    /**
     * 描述
     */
    private String describe;

    private Integer active;

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
     * @return role_name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode( String roleCode ) {
        this.roleCode = roleCode;
    }

    /**
     * 获取描述
     *
     * @return describe - 描述
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * 设置描述
     *
     * @param describe 描述
     */
    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    /**
     * @return active
     */
    public Integer getActive() {
        return active;
    }

    /**
     * @param active
     */
    public void setActive(Integer active) {
        this.active = active;
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