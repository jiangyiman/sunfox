package com.sun.fox.mybatis.base.enums;

import java.util.Objects;

public interface BaseEnum {
    Integer value();
    String desc();

    /**
     * 默认实现的方法，可覆盖
     */
    default boolean equals(BaseEnum baseEnum) {
        return Objects.equals(this.value(), baseEnum.value());
    }
}
