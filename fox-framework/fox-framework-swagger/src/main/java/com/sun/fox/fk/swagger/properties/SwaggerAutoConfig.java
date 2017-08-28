package com.sun.fox.fk.swagger.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Component
@ConfigurationProperties("swagger")
public class SwaggerAutoConfig {

    /**
     * API接口访问地址
     */
    private String pathmapping;

    /**
     * 是否生效
     */
    private Boolean enabled = Boolean.TRUE;

    /**
     * 是否分组配置接口
     */
    private Boolean disGroup = Boolean.FALSE;

    /**
     * 默认同意头配置
     */
    private DocketInfo defual;

    /**
     * 分组配置
     */
    private List<Map<String,DocketInfo>> docket;

    public static class  DocketInfo{
        private String name;
        private String url;
        private String email;
        /**
         * 标题
         **/
        private String title = "";
        /**
         * 描述
         **/
        private String description = "";
        /**
         * 版本
         **/
        private String version = "";
        /**
         * 许可证
         **/
        private String license = "";
        /**
         * 许可证URL
         **/
        private String licenseUrl = "";
        /**
         * 服务条款URL
         **/
        private String termsOfServiceUrl = "";
        /**
         * swagger会解析的包路径
         **/
        private String basePackage = "";

        /**
         * swagger会解析的url规则
         **/
        private List<String> basePath = new ArrayList<>();
        /**
         * 在basePath基础上需要排除的url规则
         **/
        private List<String> excludePath = new ArrayList<>();

        public String getName() {
            return name;
        }

        public void setName( String name ) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl( String url ) {
            this.url = url;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail( String email ) {
            this.email = email;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle( String title ) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription( String description ) {
            this.description = description;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion( String version ) {
            this.version = version;
        }

        public String getLicense() {
            return license;
        }

        public void setLicense( String license ) {
            this.license = license;
        }

        public String getLicenseUrl() {
            return licenseUrl;
        }

        public void setLicenseUrl( String licenseUrl ) {
            this.licenseUrl = licenseUrl;
        }

        public String getTermsOfServiceUrl() {
            return termsOfServiceUrl;
        }

        public void setTermsOfServiceUrl( String termsOfServiceUrl ) {
            this.termsOfServiceUrl = termsOfServiceUrl;
        }

        public String getBasePackage() {
            return basePackage;
        }

        public void setBasePackage( String basePackage ) {
            this.basePackage = basePackage;
        }

        public List<String> getBasePath() {
            return basePath;
        }

        public void setBasePath( List<String> basePath ) {
            this.basePath = basePath;
        }

        public List<String> getExcludePath() {
            return excludePath;
        }

        public void setExcludePath( List<String> excludePath ) {
            this.excludePath = excludePath;
        }
    }

    public String getPathmapping() {
        return pathmapping;
    }

    public void setPathmapping( String pathmapping ) {
        this.pathmapping = pathmapping;
    }

    public List<Map<String, DocketInfo>> getDocket() {
        return docket;
    }

    public void setDocket( List<Map<String, DocketInfo>> docket ) {
        this.docket = docket;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled( Boolean enabled ) {
        this.enabled = enabled;
    }

    public DocketInfo getDefual() {
        return defual;
    }

    public void setDefual( DocketInfo defual ) {
        this.defual = defual;
    }
    public Boolean getDisGroup() {
        return disGroup;
    }

    public void setDisGroup( Boolean disGroup ) {
        this.disGroup = disGroup;
    }
}
