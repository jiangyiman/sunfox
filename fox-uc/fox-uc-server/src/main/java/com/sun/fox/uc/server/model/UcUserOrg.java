package com.sun.fox.uc.server.model;

import com.sun.fox.mybatis.base.model.BaseModel;
import javax.persistence.*;

@Table(name = "uc_user_org")
public class UcUserOrg extends BaseModel {
    @Id
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "org_id")
    private Long orgId;

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
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return org_id
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * @param orgId
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
}