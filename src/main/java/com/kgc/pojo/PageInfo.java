package com.kgc.pojo;

import java.util.List;

public class PageInfo<T> {
    private int pageNo;//当前页码
    private int pageSize;//页面容量
    private int totalCount;//总数据
    private int totalPages;//总页数
    private List<T> list;//分页集合

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        if(totalCount>0){
            this.totalPages = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
        }
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalPages=" + totalPages +
                ", list=" + list +
                '}';
    }
}
