package com.sun.fox.mybatis.base.model;

import javax.persistence.Id;
import java.io.Serializable;

public class BaseModel implements Serializable {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }
}
