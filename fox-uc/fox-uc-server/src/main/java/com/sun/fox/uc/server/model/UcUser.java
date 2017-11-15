package com.sun.fox.uc.server.model;

import com.sun.fox.mybatis.base.model.BaseModel;

import java.util.Date;
import javax.persistence.*;

@Table(name = "uc_user")
public class UcUser extends BaseModel {

    //@Transient  //非表字段，字段名称无所谓

    @Id
    private Long id;

    /**
     * 用户编号
     */
    @Column(name = "user_code")
    private String userCode;

    private String username;

    private String password;

    private String salt;

    /**
     * 昵称
     */
    @Column(name = "nike_name")
    private String nikeName;

    /**
     * 生日
     */
    private Date birthday;

    private String email;

    /**
     * 用户类别
     */
    private Integer type;

    private String phone;

    /**
     * 1:男 2女
     */
    private Boolean sex;

    private Boolean active;

    /**
     *  有效时间戳
     */
    private Long expires;

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
    public void setId( Long id ) {
        this.id = id;
    }

    /**
     * 获取用户编号
     *
     * @return user_code - 用户编号
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * 设置用户编号
     *
     * @param userCode 用户编号
     */
    public void setUserCode( String userCode ) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername( String username ) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword( String password ) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt
     */
    public void setSalt( String salt ) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 获取昵称
     *
     * @return nike_name - 昵称
     */
    public String getNikeName() {
        return nikeName;
    }

    /**
     * 设置昵称
     *
     * @param nikeName 昵称
     */
    public void setNikeName( String nikeName ) {
        this.nikeName = nikeName == null ? null : nikeName.trim();
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday( Date birthday ) {
        this.birthday = birthday;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail( String email ) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取用户类别
     *
     * @return type - 用户类别
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置用户类别
     *
     * @param type 用户类别
     */
    public void setType( Integer type ) {
        this.type = type == null ? null : type;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone( String phone ) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取1:男 2女
     *
     * @return sex - 1:男 2女
     */
    public Boolean getSex() {
        return sex;
    }

    /**
     * 设置1:男 2女
     *
     * @param sex 1:男 2女
     */
    public void setSex( Boolean sex ) {
        this.sex = sex;
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
    public void setActive( Boolean active ) {
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
    public void setCreateTime( Date createTime ) {
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
    public void setCreateUser( Long createUser ) {
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
    public void setLastTime( Date lastTime ) {
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
    public void setLastUser( Long lastUser ) {
        this.lastUser = lastUser;
    }

    public Long getExpires() {
        return expires;
    }

    public void setExpires( Long expires ) {
        this.expires = expires;
    }
}