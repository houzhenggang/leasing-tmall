package com.hshc.relay.dto;

import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * 分页
 *
 * @author 钟林俊
 * @version V1.0 2016-08-19 11:38
 */
public class Page<E> {
    // 当前页
    private int pageNum;
    // 页容量
    private int size;
    // 分页起始行数
    private int startRow;
    // 分页终止行数
    private int endRow;
    // 总记录数
    private long totalRecords;
    // 总页数
    private int totalPages;
    // 数据集合
    private List<E> data;

    private T queryObject;

    public Page(){}

    public Page(int pageNum, int size) {
        this.pageNum = pageNum;
        this.size = size;
        this.startRow = pageNum > 0 ? (pageNum - 1) * size : 0;
        this.endRow = pageNum * size;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public T getQueryObject() {
        return queryObject;
    }

    public void setQueryObject(T queryObject) {
        this.queryObject = queryObject;
    }
}
