package com.pjbest.pdc.service;

import com.vip.pop.base.annotation.Required;

/**
 * 变更分类节点
 */
public class Category implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 分类ID
     */
    
    private Integer categoryId;

    /**
     * 相关分类
     */
    
    private java.util.List<Integer> relatedCategories;

    /**
     * 子分类
     */
    
    private java.util.List<com.pjbest.pdc.service.Category> children;

    /**
     * 分类映射
     */
    
    private java.util.List<com.pjbest.pdc.service.CategoryMapping> mapping;

    /**
     * 主父分类
     */
    
    private Integer majorParentCategoryid;

    /**
     * 非主父分类
     */
    
    private java.util.List<Integer> salveParentCategoryids;

    /**
     * 分类属性
     */
    
    private java.util.List<com.pjbest.pdc.service.Attribute> attributes;

    /**
     * 外国名称, 保存格式为JSON
     */
    
    private String foreignname;

    /**
     * 图片链接
     */
    
    private String image;

    /**
     * 目标链接地址
     */
    
    private String linkaddress;

    /**
     * 展示粒度状态位
     */
    
    private Integer flag;

    /**
     * 分类名称
     */
    
    private String name;

    /**
     * 最大售售卖数
     */
    
    private Integer maxsalenum;

    /**
     * 最小售卖数
     */
    
    private Integer minisalenum;

    /**
     * 展示模式 0:映射录入导航 1:URL链接 2:档期ID
     */
    
    private Integer showType;

    /**
     * 档期ID
     */
    
    private Integer timeLineId;

    /**
     * 分类关联的品牌
     */
    
    private com.pjbest.pdc.service.Brands brands;

    /**
     * 展示导航二级分类属性交集属性值并集，格式：pid:vid;pid:vid;
     */
    
    private String subCatAttr;

    /**
     * 展示分类标签条件属性，格式：pid:vid;pid:vid;
     */
    
    private String tagFilter;

    /**
     * 删除状态
     */
    
    private Integer status;

    /**
     * 主父分类
     */
    
    private com.pjbest.pdc.service.Parents majorParents;

    /**
     * 从父分类
     */
    
    private java.util.List<com.pjbest.pdc.service.Parents> salveParents;

    /**
     * 英文名称
     */
    
    private String englishname;

    /**
     * 分类描述
     */
    
    private String description;

    /**
     * 分类类型
     */
    
    private com.pjbest.pdc.service.CategoryType type;

    /**
     * 关键字
     */
    
    private String keywords;

    /**
     * 标记位，用于后续扩展属性
     */
    
    private Long flags;

    /**
     * 展示导航ID
     */
    
    private String hierarchyId;

    /**
     * 最后变更时间, 获取变更的节点接口使用
     */
    
    private Long lastUpdateTime;

    // 构造函数
    public Category() {super();}

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public java.util.List<Integer> getRelatedCategories() {
        return relatedCategories;
    }

    public void setRelatedCategories(java.util.List<Integer> relatedCategories) {
        this.relatedCategories = relatedCategories;
    }

    public java.util.List<com.pjbest.pdc.service.Category> getChildren() {
        return children;
    }

    public void setChildren(java.util.List<com.pjbest.pdc.service.Category> children) {
        this.children = children;
    }

    public java.util.List<com.pjbest.pdc.service.CategoryMapping> getMapping() {
        return mapping;
    }

    public void setMapping(java.util.List<com.pjbest.pdc.service.CategoryMapping> mapping) {
        this.mapping = mapping;
    }

    public Integer getMajorParentCategoryid() {
        return majorParentCategoryid;
    }

    public void setMajorParentCategoryid(Integer majorParentCategoryid) {
        this.majorParentCategoryid = majorParentCategoryid;
    }

    public java.util.List<Integer> getSalveParentCategoryids() {
        return salveParentCategoryids;
    }

    public void setSalveParentCategoryids(java.util.List<Integer> salveParentCategoryids) {
        this.salveParentCategoryids = salveParentCategoryids;
    }

    public java.util.List<com.pjbest.pdc.service.Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(java.util.List<com.pjbest.pdc.service.Attribute> attributes) {
        this.attributes = attributes;
    }

    public String getForeignname() {
        return foreignname;
    }

    public void setForeignname(String foreignname) {
        this.foreignname = foreignname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLinkaddress() {
        return linkaddress;
    }

    public void setLinkaddress(String linkaddress) {
        this.linkaddress = linkaddress;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxsalenum() {
        return maxsalenum;
    }

    public void setMaxsalenum(Integer maxsalenum) {
        this.maxsalenum = maxsalenum;
    }

    public Integer getMinisalenum() {
        return minisalenum;
    }

    public void setMinisalenum(Integer minisalenum) {
        this.minisalenum = minisalenum;
    }

    public Integer getShowType() {
        return showType;
    }

    public void setShowType(Integer showType) {
        this.showType = showType;
    }

    public Integer getTimeLineId() {
        return timeLineId;
    }

    public void setTimeLineId(Integer timeLineId) {
        this.timeLineId = timeLineId;
    }

    public com.pjbest.pdc.service.Brands getBrands() {
        return brands;
    }

    public void setBrands(com.pjbest.pdc.service.Brands brands) {
        this.brands = brands;
    }

    public String getSubCatAttr() {
        return subCatAttr;
    }

    public void setSubCatAttr(String subCatAttr) {
        this.subCatAttr = subCatAttr;
    }

    public String getTagFilter() {
        return tagFilter;
    }

    public void setTagFilter(String tagFilter) {
        this.tagFilter = tagFilter;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public com.pjbest.pdc.service.Parents getMajorParents() {
        return majorParents;
    }

    public void setMajorParents(com.pjbest.pdc.service.Parents majorParents) {
        this.majorParents = majorParents;
    }

    public java.util.List<com.pjbest.pdc.service.Parents> getSalveParents() {
        return salveParents;
    }

    public void setSalveParents(java.util.List<com.pjbest.pdc.service.Parents> salveParents) {
        this.salveParents = salveParents;
    }

    public String getEnglishname() {
        return englishname;
    }

    public void setEnglishname(String englishname) {
        this.englishname = englishname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public com.pjbest.pdc.service.CategoryType getType() {
        return type;
    }

    public void setType(com.pjbest.pdc.service.CategoryType type) {
        this.type = type;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Long getFlags() {
        return flags;
    }

    public void setFlags(Long flags) {
        this.flags = flags;
    }

    public String getHierarchyId() {
        return hierarchyId;
    }

    public void setHierarchyId(String hierarchyId) {
        this.hierarchyId = hierarchyId;
    }

    public Long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

}
