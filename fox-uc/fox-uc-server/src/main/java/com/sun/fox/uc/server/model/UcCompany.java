package com.sun.fox.uc.server.model;

import com.sun.fox.mybatis.base.model.BaseModel;
import java.util.Date;
import javax.persistence.*;

@Table(name = "uc_company")
public class UcCompany extends BaseModel {
    /**
     * 组织名称
     */
    @Id
    private Long id;

    /**
     * 组织名称
     */
    @Column(name = "comp_name")
    private String compName;

    /**
     * 组织编码
     */
    @Column(name = "comp_code")
    private String compCode;

    /**
     * 联系电话
     */
    @Column(name = "comp_tel")
    private String compTel;

    /**
     * 联系手机
     */
    @Column(name = "comp_phone")
    private String compPhone;

    /**
     * 联系人
     */
    @Column(name = "comp_linkman")
    private String compLinkman;

    /**
     * 联系地址
     */
    @Column(name = "comp_address")
    private String compAddress;

    /**
     * 组织图标
     */
    @Column(name = "comp_logo")
    private String compLogo;

    /**
     * 组织主页
     */
    @Column(name = "comp_url")
    private String compUrl;

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
     * 获取组织名称
     *
     * @return id - 组织名称
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置组织名称
     *
     * @param id 组织名称
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取组织名称
     *
     * @return comp_name - 组织名称
     */
    public String getCompName() {
        return compName;
    }

    /**
     * 设置组织名称
     *
     * @param compName 组织名称
     */
    public void setCompName(String compName) {
        this.compName = compName == null ? null : compName.trim();
    }

    /**
     * 获取组织编码
     *
     * @return comp_code - 组织编码
     */
    public String getCompCode() {
        return compCode;
    }

    /**
     * 设置组织编码
     *
     * @param compCode 组织编码
     */
    public void setCompCode(String compCode) {
        this.compCode = compCode == null ? null : compCode.trim();
    }

    /**
     * 获取联系电话
     *
     * @return comp_tel - 联系电话
     */
    public String getCompTel() {
        return compTel;
    }

    /**
     * 设置联系电话
     *
     * @param compTel 联系电话
     */
    public void setCompTel(String compTel) {
        this.compTel = compTel == null ? null : compTel.trim();
    }

    /**
     * 获取联系手机
     *
     * @return comp_phone - 联系手机
     */
    public String getCompPhone() {
        return compPhone;
    }

    /**
     * 设置联系手机
     *
     * @param compPhone 联系手机
     */
    public void setCompPhone(String compPhone) {
        this.compPhone = compPhone == null ? null : compPhone.trim();
    }

    /**
     * 获取联系人
     *
     * @return comp_linkman - 联系人
     */
    public String getCompLinkman() {
        return compLinkman;
    }

    /**
     * 设置联系人
     *
     * @param compLinkman 联系人
     */
    public void setCompLinkman(String compLinkman) {
        this.compLinkman = compLinkman == null ? null : compLinkman.trim();
    }

    /**
     * 获取联系地址
     *
     * @return comp_address - 联系地址
     */
    public String getCompAddress() {
        return compAddress;
    }

    /**
     * 设置联系地址
     *
     * @param compAddress 联系地址
     */
    public void setCompAddress(String compAddress) {
        this.compAddress = compAddress == null ? null : compAddress.trim();
    }

    /**
     * 获取组织图标
     *
     * @return comp_logo - 组织图标
     */
    public String getCompLogo() {
        return compLogo;
    }

    /**
     * 设置组织图标
     *
     * @param compLogo 组织图标
     */
    public void setCompLogo(String compLogo) {
        this.compLogo = compLogo == null ? null : compLogo.trim();
    }

    /**
     * 获取组织主页
     *
     * @return comp_url - 组织主页
     */
    public String getCompUrl() {
        return compUrl;
    }

    /**
     * 设置组织主页
     *
     * @param compUrl 组织主页
     */
    public void setCompUrl(String compUrl) {
        this.compUrl = compUrl == null ? null : compUrl.trim();
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