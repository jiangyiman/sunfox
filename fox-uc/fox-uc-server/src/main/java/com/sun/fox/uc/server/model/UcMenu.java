package com.sun.fox.uc.server.model;

import com.sun.fox.mybatis.base.model.BaseModel;
import java.util.Date;
import javax.persistence.*;

@Table(name = "uc_menu")
public class UcMenu extends BaseModel {
    @Id
    private Long id;

    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 菜单地址
     */
    @Column(name = "menu_url")
    private String menuUrl;

    /**
     * 菜单编码
     */
    @Column(name = "menu_code")
    private String menuCode;

    /**
     * 菜单类型，
     */
    @Column(name = "menu_type")
    private Boolean menuType;

    /**
     * 1 启用 0 禁用
     */
    private Boolean active;

    @Column(name = "parent_id")
    private Long parentId;

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
     * 获取菜单名称
     *
     * @return menu_name - 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置菜单名称
     *
     * @param menuName 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * 获取菜单地址
     *
     * @return menu_url - 菜单地址
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * 设置菜单地址
     *
     * @param menuUrl 菜单地址
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    /**
     * 获取菜单编码
     *
     * @return menu_code - 菜单编码
     */
    public String getMenuCode() {
        return menuCode;
    }

    /**
     * 设置菜单编码
     *
     * @param menuCode 菜单编码
     */
    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode == null ? null : menuCode.trim();
    }

    /**
     * 获取菜单类型，
     *
     * @return menu_type - 菜单类型，
     */
    public Boolean getMenuType() {
        return menuType;
    }

    /**
     * 设置菜单类型，
     *
     * @param menuType 菜单类型，
     */
    public void setMenuType(Boolean menuType) {
        this.menuType = menuType;
    }

    /**
     * 获取1 启用 0 禁用
     *
     * @return active - 1 启用 0 禁用
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * 设置1 启用 0 禁用
     *
     * @param active 1 启用 0 禁用
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * @return parent_id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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