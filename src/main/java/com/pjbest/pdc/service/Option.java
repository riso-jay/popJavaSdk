package com.pjbest.pdc.service;

import com.vip.pop.base.annotation.Required;

/**
 * 属性选项
 */
public class Option implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 属性项ID
     */
    
    private Integer attributeId;

    /**
     * 如果是虚拟选项，这里是其它需要聚合的多个选项
     */
    
    private java.util.List<Integer> realOptions;

    /**
     * 外国名称, 保存格式为JSON
     */
    
    private String foreignname;

    /**
     * 选项外部信息, 保存格式为JSON
     */
    
    private String externaldata;

    /**
     * 选项别名
     */
    
    private String aliases;

    /**
     * 属性值（文本/数值/布尔）
     */
    
    private String literal;

    /**
     * 属性值解析是否成功标识。false：失败，true：成功
     */
    
    private Boolean flag;

    /**
     * 备注信息 add by chuping.zhai 2014-12-25
     */
    
    private java.util.List<String> remarks;

    /**
     * 选项ID
     */
    
    private Integer optionId;

    /**
     * 选项名称
     */
    
    private String name;

    /**
     * 英文名称
     */
    
    private String englishname;

    /**
     * 选项描述
     */
    
    private String description;

    /**
     * 选项分组
     */
    
    private String hierarchyGroup;

    /**
     * 排序因子
     */
    
    private Integer sort;

    /**
     * 父选项ID，为0表示都独立选项，否则为依赖选项
     */
    
    private Integer parentOptionId;

    /**
     * 是否为虚拟选项，虚拟选型是多个其它选型的聚合
     */
    
    private Boolean isVirtual;

    // 构造函数
    public Option() {super();}

    public Integer getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    public java.util.List<Integer> getRealOptions() {
        return realOptions;
    }

    public void setRealOptions(java.util.List<Integer> realOptions) {
        this.realOptions = realOptions;
    }

    public String getForeignname() {
        return foreignname;
    }

    public void setForeignname(String foreignname) {
        this.foreignname = foreignname;
    }

    public String getExternaldata() {
        return externaldata;
    }

    public void setExternaldata(String externaldata) {
        this.externaldata = externaldata;
    }

    public String getAliases() {
        return aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

    public String getLiteral() {
        return literal;
    }

    public void setLiteral(String literal) {
        this.literal = literal;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public java.util.List<String> getRemarks() {
        return remarks;
    }

    public void setRemarks(java.util.List<String> remarks) {
        this.remarks = remarks;
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getHierarchyGroup() {
        return hierarchyGroup;
    }

    public void setHierarchyGroup(String hierarchyGroup) {
        this.hierarchyGroup = hierarchyGroup;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getParentOptionId() {
        return parentOptionId;
    }

    public void setParentOptionId(Integer parentOptionId) {
        this.parentOptionId = parentOptionId;
    }

    public Boolean getIsVirtual() {
        return isVirtual;
    }

    public void setIsVirtual(Boolean isVirtual) {
        this.isVirtual = isVirtual;
    }

}
