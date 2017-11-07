package com.sun.fox.uc.server.model;

import com.sun.fox.mybatis.base.model.BaseModel;
import java.util.Date;
import javax.persistence.*;

@Table(name = "uc_organization")
public class UcOrganization extends BaseModel {
    @Id
    private Long id;

    @Column(name = "org_name")
    private String orgName;

    @Column(name = "org_code")
    private String orgCode;

    @Column(name = "parent_id")
    private Integer parentId;

    private Boolean active;

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
     * @return org_name
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * @param orgName
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    /**
     * @return org_code
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * @param orgCode
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * @return parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * @return active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * @param active
     */
    public void setActive(Boolean active) {
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