package com.pjbest.pdc.service;

import com.vip.pop.base.annotation.Required;

/**
 * ERP 商品信息
 */
public class ErpDecPdcItem implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识 (长度不能超过 50)
     */
    @Required("唯一标识 (长度不能超过 50) ")
    private String transactionId;

    /**
     * 商品规格(长度不能超过 50)
     */
    @Required("商品规格(长度不能超过 50) ")
    private String size;

    /**
     * 商品颜色(长度不能超过 50)
     */
    @Required("商品颜色(长度不能超过 50) ")
    private String color;

    /**
     * 吊牌价 (单位元)不填默认填0 整数位数上限为15位，小数位数上限为2位
     */
    
    private String tagPrice;

    /**
     * 商品单位(长度不能超过 64)
     */
    @Required("商品单位(长度不能超过 64) ")
    private String stockUnit;

    /**
     * 商品配件(长度不能超过 50)
     */
    
    private String parts;

    /**
     * 是否质保(Y/N ;默认为N) 当选择Y则(期限基线、保质期时长、保险期时长、拒上线日期（refeuse）、拒收期限(inbLife) )必填、【保质期时长 > 保险期时长】，而且【1 <= 拒收期限 <= 保质期时长】;如果选择否则保质期时长必填
     */
    @Required("是否质保(Y/N ;默认为N) 当选择Y则(期限基线、保质期时长、保险期时长、拒上线日期（refeuse）、拒收期限(inbLife) )必填、【保质期时长 > 保险期时长】，而且【1 <= 拒收期限 <= 保质期时长】;如果选择否则保质期时长必填 ")
    private String isShelfLifeMgmt;

    /**
     * 期限基线 E:过期日期 V:生产日期 只能为 E/V
     */
    
    private String qgpStandard;

    /**
     * 保质期时长(单位：天 长度10位)
     */
    
    private Integer shelfLife;

    /**
     * 保险期时长(单位：天 长度10位)
     */
    @Required("保险期时长(单位：天 长度10位) ")
    private Integer insurancePeriod;

    /**
     * 拒上线日期(单位：天 长度10位)
     */
    
    private Integer refuse;

    /**
     * 操作类型(两种类型：add|update)
     */
    @Required("操作类型(两种类型：add|update) ")
    private String actionType;

    /**
     * 保存温度（单位℃ 长度不能超过 50）
     */
    
    private String temperature;

    /**
     * 是否国产:0未知|1中国|2进口 (只能为 0、1、2)
     */
    @Required("是否国产:0未知|1中国|2进口 (只能为 0、1、2) ")
    private Byte provenance;

    /**
     * 是否序列号管理:0否|1是 (不填默认否)
     */
    
    private Byte isSerialNumManage;

    /**
     * 是否易碎品(Y/N ;默认为N)
     */
    @Required("是否易碎品(Y/N ;默认为N) ")
    private String isFragile;

    /**
     * 是否航空禁运 0：否，1：是。默认0
     */
    @Required("是否航空禁运 0：否，1：是。默认0 ")
    private Byte isAirForbit;

    /**
     * 是否贵重品 默认0：否 只能为 0、1
     */
    @Required("是否贵重品 默认0：否 只能为 0、1 ")
    private Byte isLuxury;

    /**
     * 是否大件 默认0：否 只能为 0、1
     */
    
    private Byte isLarge;

    /**
     * 净重(单位：克 10位整数)
     */
    
    private String netWeight;

    /**
     * 毛重(单位：克 10位整数)
     */
    
    private String grossWeight;

    /**
     * 长（含包装）(单位：毫米 10位整数)
     */
    
    private String length;

    /**
     * 商品编码(长度不能超过 50)
     */
    @Required("商品编码(长度不能超过 50) ")
    private String itemCode;

    /**
     * 宽（含包装）(单位：毫米 10位整数)
     */
    
    private String width;

    /**
     * 高（含包装）(单位：毫米 10位整数)
     */
    
    private String height;

    /**
     * 长（不含包装）(单位：毫米 10位整数)
     */
    
    private String grossLength;

    /**
     * 宽（不含包装）(单位：毫米 10位整数)
     */
    
    private String grossWidth;

    /**
     * 高（不含包装）(单位：毫米 10位整数)
     */
    
    private String grossHeight;

    /**
     * 是否需要批次管理(Y/N ;默认为N)
     */
    
    private String isBatchMgmt;

    /**
     * 是否定制品(0否，1是,默认值0)
     */
    
    private String customMade;

    /**
     * 数据源(长度不能超过 20)
     */
    @Required("数据源(长度不能超过 20) ")
    private String dataSource;

    /**
     * 拒收期限(单位：天 长度10位)
     */
    
    private Integer inbLife;

    /**
     * 商品名称(长度不能超过 64)
     */
    @Required("商品名称(长度不能超过 64) ")
    private String itemName;

    /**
     * 商品小类名称(长度不能超过 50) 商品小类编码或商品小类名称两个选填一个
     */
    
    private String category3Name;

    /**
     * 商品小类编码(长度不能超过 50) 商品小类编码或商品小类名称两个选填一个
     */
    
    private String category3Code;

    /**
     * 品牌编码(长度不能超过 50) 品牌编码和品牌名称两个选填一个
     */
    
    private String brandCode;

    /**
     * 品牌名称(长度不能超过 120) 品牌编码和品牌名称两个选填一个
     */
    
    private String brandName;

    /**
     * 商品货号(长度不能超过 50)
     */
    @Required("商品货号(长度不能超过 50) ")
    private String goodsCode;

    // 构造函数
    public ErpDecPdcItem() {super();}

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTagPrice() {
        return tagPrice;
    }

    public void setTagPrice(String tagPrice) {
        this.tagPrice = tagPrice;
    }

    public String getStockUnit() {
        return stockUnit;
    }

    public void setStockUnit(String stockUnit) {
        this.stockUnit = stockUnit;
    }

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }

    public String getIsShelfLifeMgmt() {
        return isShelfLifeMgmt;
    }

    public void setIsShelfLifeMgmt(String isShelfLifeMgmt) {
        this.isShelfLifeMgmt = isShelfLifeMgmt;
    }

    public String getQgpStandard() {
        return qgpStandard;
    }

    public void setQgpStandard(String qgpStandard) {
        this.qgpStandard = qgpStandard;
    }

    public Integer getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Integer getInsurancePeriod() {
        return insurancePeriod;
    }

    public void setInsurancePeriod(Integer insurancePeriod) {
        this.insurancePeriod = insurancePeriod;
    }

    public Integer getRefuse() {
        return refuse;
    }

    public void setRefuse(Integer refuse) {
        this.refuse = refuse;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public Byte getProvenance() {
        return provenance;
    }

    public void setProvenance(Byte provenance) {
        this.provenance = provenance;
    }

    public Byte getIsSerialNumManage() {
        return isSerialNumManage;
    }

    public void setIsSerialNumManage(Byte isSerialNumManage) {
        this.isSerialNumManage = isSerialNumManage;
    }

    public String getIsFragile() {
        return isFragile;
    }

    public void setIsFragile(String isFragile) {
        this.isFragile = isFragile;
    }

    public Byte getIsAirForbit() {
        return isAirForbit;
    }

    public void setIsAirForbit(Byte isAirForbit) {
        this.isAirForbit = isAirForbit;
    }

    public Byte getIsLuxury() {
        return isLuxury;
    }

    public void setIsLuxury(Byte isLuxury) {
        this.isLuxury = isLuxury;
    }

    public Byte getIsLarge() {
        return isLarge;
    }

    public void setIsLarge(Byte isLarge) {
        this.isLarge = isLarge;
    }

    public String getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(String netWeight) {
        this.netWeight = netWeight;
    }

    public String getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(String grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getGrossLength() {
        return grossLength;
    }

    public void setGrossLength(String grossLength) {
        this.grossLength = grossLength;
    }

    public String getGrossWidth() {
        return grossWidth;
    }

    public void setGrossWidth(String grossWidth) {
        this.grossWidth = grossWidth;
    }

    public String getGrossHeight() {
        return grossHeight;
    }

    public void setGrossHeight(String grossHeight) {
        this.grossHeight = grossHeight;
    }

    public String getIsBatchMgmt() {
        return isBatchMgmt;
    }

    public void setIsBatchMgmt(String isBatchMgmt) {
        this.isBatchMgmt = isBatchMgmt;
    }

    public String getCustomMade() {
        return customMade;
    }

    public void setCustomMade(String customMade) {
        this.customMade = customMade;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public Integer getInbLife() {
        return inbLife;
    }

    public void setInbLife(Integer inbLife) {
        this.inbLife = inbLife;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory3Name() {
        return category3Name;
    }

    public void setCategory3Name(String category3Name) {
        this.category3Name = category3Name;
    }

    public String getCategory3Code() {
        return category3Code;
    }

    public void setCategory3Code(String category3Code) {
        this.category3Code = category3Code;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

}
