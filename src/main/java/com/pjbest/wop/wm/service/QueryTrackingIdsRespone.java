package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 查询在库序列号（追踪ID）响应
 */
public class QueryTrackingIdsRespone implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 商品编码
     */
    
    private String sizeSn;

    /**
     * 序列号（追踪ID）
     */
    
    private String id;

    // 构造函数
    public QueryTrackingIdsRespone() {super();}

    public String getSizeSn() {
        return sizeSn;
    }

    public void setSizeSn(String sizeSn) {
        this.sizeSn = sizeSn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
