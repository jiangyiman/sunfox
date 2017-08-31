package com.sun.fox.common.page;

import java.util.List;

/**
 *  分页数据集
 * @param <T>
 */
public class Page<T> {

    private List<T> list;

    private long count;

    public Page( List<T> list, long count ) {
        this.list = list;
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList( List<T> list ) {
        this.list = list;
    }

    public long getCount() {
        return count;
    }

    public void setCount( long count ) {
        this.count = count;
    }
}
