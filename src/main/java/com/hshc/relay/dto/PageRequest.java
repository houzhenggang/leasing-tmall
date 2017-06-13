package com.hshc.relay.dto;

/**
 * @author 钟林俊
 * @version V1.0 2017-06-13 17:04
 */
public class PageRequest<T> {

    private Integer pageNum;

    private Integer pageSize;

    private T queryObj;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public T getQueryObj() {
        return queryObj;
    }

    public void setQueryObj(T queryObj) {
        this.queryObj = queryObj;
    }
}
