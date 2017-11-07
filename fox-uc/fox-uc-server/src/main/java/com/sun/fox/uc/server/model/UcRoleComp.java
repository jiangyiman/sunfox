package com.sun.fox.uc.server.model;

import com.sun.fox.mybatis.base.model.BaseModel;
import javax.persistence.*;

@Table(name = "uc_role_comp")
public class UcRoleComp extends BaseModel {
    @Id
    private Long id;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "comp_id")
    private Long compId;

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
     * @return role_id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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
}