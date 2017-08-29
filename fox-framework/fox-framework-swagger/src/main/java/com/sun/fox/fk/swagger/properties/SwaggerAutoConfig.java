package com.sun.fox.fk.swagger.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties("swagger")
public class SwaggerAutoConfig {

    private Boolean enable = Boolean.TRUE;
    private String  pathmapping ;
    private Boolean engroup = Boolean.FALSE;
    private Defual defual;
    private Map<String,Defual> docket;

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable( Boolean enable ) {
        this.enable = enable;
    }

    public String getPathmapping() {
        return pathmapping;
    }

    public void setPathmapping( String pathmapping ) {
        this.pathmapping = pathmapping;
    }

    public Boolean getEngroup() {
        return engroup;
    }

    public void setEngroup( Boolean engroup ) {
        this.engroup = engroup;
    }

    public Defual getDefual() {
        return defual;
    }
    public void setDefual( Defual defual ) {
        this.defual = defual;
    }
    public Map<String, Defual> getDocket() {
        return docket;
    }
    public void setDocket( Map<String, Defual> docket ) {
        this.docket = docket;
    }
}
