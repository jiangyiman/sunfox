package com.sun.fox.uc.server.model;

import com.sun.fox.mybatis.base.model.BaseModel;
import javax.persistence.*;

@Table(name = "uc_comp_org")
public class UcCompOrg extends BaseModel {
    @Id
    private Long id;

    @Column(name = "comp_id")
    private Long compId;

    @Column(name = "org_id")
    private Long orgId;

    /**
     * @return  id
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
     * @return comp_id
     */
    public Long getCompId() {
        return compId;
    }

    /**
     * @param compId
     */
    public void setCompId(Long compId) {
        this.compId = compId;
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