package com.sun.fox.common.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @param <S> 源对象
 * @param <T> 代理对象
 */
public abstract class BaseComverter<S, T> {

    /**
     * 对象转换
     *
     * @param source
     * @return
     */
    public abstract T coverter( S source );

    public List<T> coverterAll( List<S> sources ) {
        if (sources == null || sources.isEmpty()) {
            return new ArrayList<>();
        }
        return sources.stream().map(this::coverter).collect(Collectors.toList());
    }
}
