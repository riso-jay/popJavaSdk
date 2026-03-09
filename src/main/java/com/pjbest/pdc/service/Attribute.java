package com.pjbest.pdc.service;

import com.vip.pop.base.annotation.Required;

/**
 * 分类属性
 */
public class Attribute implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 属性Id
     */
    
    private Integer attriuteId;

    /**
     * 父属性ID，为0表示为独立属性，否则为依赖属性
     */
    
    private Integer parentAttributeId;

    /**
     * 选项列表
     */
    
    private java.util.List<com.pjbest.pdc.service.Option> options;

    /**
     * 属性分组名称
     */
    
    private String attributegroup;

    /**
     * 外国名称, 保存格式为JSON
     */
    
    private String foreignname;

    /**
     * 数据类型为文本类型时，需要增加文本长度限制
     */
    
    private Integer textlength;

    /**
     * 是否为筛选条件，默认为否（是：0 否：1）
     */
    
    private Integer screeningstatus;

    /**
     * 有效开始时间
     */
    
    private Long starttime;

    /**
     * 有效结束时间
     */
    
    private Long endtime;

    /**
     * 属性解析是否成功标识。false：失败，true：成功
     */
    
    private Boolean flag;

    /**
     * 特征集ID ，内部字段不对外开放
     */
    
    private Integer charactersetid;

    /**
     * 属性名称
     */
    
    private String name;

    /**
     * 前置状态 ，内部字段不对外开放
     */
    
    private Integer dependenceStatus;

    /**
     * 英文名称
     */
    
    private String englishname;

    /**
     * 属性说明
     */
    
    private String description;

    /**
     * 属性类型：自然属性/Tag属性
     */
    
    private com.pjbest.pdc.service.AttributeType type;

    /**
     * 数据类型：文本/数值/选项
     */
    
    private com.pjbest.pdc.service.DataType dataType;

    /**
     * 数值单位
     */
    
    private String unit;

    /**
     * 排序因子
     */
    
    private Integer sort;

    /**
     * 属性标记位,条件属性
     */
    
    private Long flags;

    // 构造函数
    public Attribute() {super();}

    public Integer getAttriuteId() {
        return attriuteId;
    }

    public void setAttriuteId(Integer attriuteId) {
        this.attriuteId = attriuteId;
    }

    public Integer getParentAttributeId() {
        return parentAttributeId;
    }

    public void setParentAttributeId(Integer parentAttributeId) {
        this.parentAttributeId = parentAttributeId;
    }

    public java.util.List<com.pjbest.pdc.service.Option> getOptions() {
        return options;
    }

    public void setOptions(java.util.List<com.pjbest.pdc.service.Option> options) {
        this.options = options;
    }

    public String getAttributegroup() {
        return attributegroup;
    }

    public void setAttributegroup(String attributegroup) {
        this.attributegroup = attributegroup;
    }

    public String getForeignname() {
        return foreignname;
    }

    public void setForeignname(String foreignname) {
        this.foreignname = foreignname;
    }

    public Integer getTextlength() {
        return textlength;
    }

    public void setTextlength(Integer textlength) {
        this.textlength = textlength;
    }

    public Integer getScreeningstatus() {
        return screeningstatus;
    }

    public void setScreeningstatus(Integer screeningstatus) {
        this.screeningstatus = screeningstatus;
    }

    public Long getStarttime() {
        return starttime;
    }

    public void setStarttime(Long starttime) {
        this.starttime = starttime;
    }

    public Long getEndtime() {
        return endtime;
    }

    public void setEndtime(Long endtime) {
        this.endtime = endtime;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Integer getCharactersetid() {
        return charactersetid;
    }

    public void setCharactersetid(Integer charactersetid) {
        this.charactersetid = charactersetid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDependenceStatus() {
        return dependenceStatus;
    }

    public void setDependenceStatus(Integer dependenceStatus) {
        this.dependenceStatus = dependenceStatus;
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

    public com.pjbest.pdc.service.AttributeType getType() {
        return type;
    }

    public void setType(com.pjbest.pdc.service.AttributeType type) {
        this.type = type;
    }

    public com.pjbest.pdc.service.DataType getDataType() {
        return dataType;
    }

    public void setDataType(com.pjbest.pdc.service.DataType dataType) {
        this.dataType = dataType;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getFlags() {
        return flags;
    }

    public void setFlags(Long flags) {
        this.flags = flags;
    }

}
