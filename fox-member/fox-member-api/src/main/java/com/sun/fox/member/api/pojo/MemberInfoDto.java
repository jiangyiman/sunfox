package com.sun.fox.member.api.pojo;

import java.util.Date;

public class MemberInfoDto {
    private Long id;

    /**
     * 登录名
     */
    private String loginName;

    private String password;

    /**
     * 1: 主站，2:app,3:github
     */
    private Byte userSource;

    private String nikeName;

    /**
     * 真实姓名
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userPictures;

    /**
     * 手机号码
     */
    private String userMobile;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * 生日
     */
    private Date userBirthday;

    /**
     * 是否有效
     */
    private Boolean active;

    /**
     * 创建时间
     */
    private Date createTime;

    private Long createBy;

    private Date lasterTime;

    private Long upateBy;



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
     * 获取登录名
     *
     * @return login_name - 登录名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置登录名
     *
     * @param loginName 登录名
     */
    public void setLoginName( String loginName ) {
        this.loginName = loginName == null ? null : loginName.trim();
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
     * 获取1: 主站，2:app,3:github
     *
     * @return user_source - 1: 主站，2:app,3:github
     */
    public Byte getUserSource() {
        return userSource;
    }

    /**
     * 设置1: 主站，2:app,3:github
     *
     * @param userSource 1: 主站，2:app,3:github
     */
    public void setUserSource( Byte userSource ) {
        this.userSource = userSource;
    }

    /**
     * @return nike_name
     */
    public String getNikeName() {
        return nikeName;
    }

    /**
     * @param nikeName
     */
    public void setNikeName( String nikeName ) {
        this.nikeName = nikeName == null ? null : nikeName.trim();
    }

    /**
     * 获取真实姓名
     *
     * @return user_name - 真实姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置真实姓名
     *
     * @param userName 真实姓名
     */
    public void setUserName( String userName ) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取用户头像
     *
     * @return user_pictures - 用户头像
     */
    public String getUserPictures() {
        return userPictures;
    }

    /**
     * 设置用户头像
     *
     * @param userPictures 用户头像
     */
    public void setUserPictures( String userPictures ) {
        this.userPictures = userPictures == null ? null : userPictures.trim();
    }

    /**
     * 获取手机号码
     *
     * @return user_mobile - 手机号码
     */
    public String getUserMobile() {
        return userMobile;
    }

    /**
     * 设置手机号码
     *
     * @param userMobile 手机号码
     */
    public void setUserMobile( String userMobile ) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    /**
     * 获取邮箱
     *
     * @return user_email - 邮箱
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * 设置邮箱
     *
     * @param userEmail 邮箱
     */
    public void setUserEmail( String userEmail ) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    /**
     * 获取生日
     *
     * @return user_birthday - 生日
     */
    public Date getUserBirthday() {
        return userBirthday;
    }

    /**
     * 设置生日
     *
     * @param userBirthday 生日
     */
    public void setUserBirthday( Date userBirthday ) {
        this.userBirthday = userBirthday;
    }

    /**
     * 获取是否有效
     *
     * @return active - 是否有效
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * 设置是否有效
     *
     * @param active 是否有效
     */
    public void setActive( Boolean active ) {
        this.active = active;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime( Date createTime ) {
        this.createTime = createTime;
    }

    /**
     * @return create_by
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy
     */
    public void setCreateBy( Long createBy ) {
        this.createBy = createBy;
    }

    /**
     * @return laster_time
     */
    public Date getLasterTime() {
        return lasterTime;
    }

    /**
     * @param lasterTime
     */
    public void setLasterTime( Date lasterTime ) {
        this.lasterTime = lasterTime;
    }

    /**
     * @return upate_by
     */
    public Long getUpateBy() {
        return upateBy;
    }

    /**
     * @param upateBy
     */
    public void setUpateBy( Long upateBy ) {
        this.upateBy = upateBy;
    }
}