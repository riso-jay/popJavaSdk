package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * PO信息
 */
public class PoInfo implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * PO编码
     */
    
    private String poNo;

    /**
     * 仓库收货人电话
     */
    
    private String receiverTel;

    /**
     * 仓库收货人手机
     */
    
    private String receiverMobie;

    /**
     * 仓库收货国家
     */
    
    private String receiverCountry;

    /**
     * 仓库收货省
     */
    
    private String receiverStateName;

    /**
     * 仓库收货省名称
     */
    
    private String receiverStateCode;

    /**
     * 仓库收货市
     */
    
    private String receiverCityName;

    /**
     * 仓库收货市编码
     */
    
    private String receiverCityCode;

    /**
     * 仓库收货区
     */
    
    private String receiverDistrictName;

    /**
     * 仓库收货区编码
     */
    
    private String receiverDistrictCode;

    /**
     * 仓库收货详细地址
     */
    
    private String receiverDetailAddress;

    /**
     * 客户PO
     */
    
    private String clientPoNo;

    /**
     * 仓库编码
     */
    
    private String warehouseCode;

    /**
     * 仓库名称
     */
    
    private String warehouseName;

    /**
     * 默认销售渠道 0:待定 1:唯品会 2:非唯品会 3:乐蜂
     */
    
    private Byte channel;

    /**
     * 退货联系人
     */
    
    private String returnContacter;

    /**
     * 退货联系人电话
     */
    
    private String returnContacterTel;

    /**
     * 退货联系人手机
     */
    
    private String returnContacterMobile;

    /**
     * 退货国家
     */
    
    private String returnCountry;

    /**
     * 退货省名称
     */
    
    private String returnStateName;

    /**
     * 退货省编码
     */
    
    private String returnStateCode;

    /**
     * 退货市名称
     */
    
    private String returnCityName;

    /**
     * 经销类型
     */
    
    private String type;

    /**
     * 退货市编码
     */
    
    private String returnCityCode;

    /**
     * 退货地区编码
     */
    
    private String returnDistrictName;

    /**
     * 退货地区名称
     */
    
    private String returnDistrictCode;

    /**
     * 退货详细地址
     */
    
    private String returnDetailAddress;

    /**
     * 邮箱
     */
    
    private String email;

    /**
     * 是否当面清点， 0:不需要 1:需要
     */
    
    private Byte isNeedFaceCount;

    /**
     * 总重量
     */
    
    private Double totalWeight;

    /**
     * 总体积
     */
    
    private Double totalVolume;

    /**
     * 重量
     */
    
    private Double weight;

    /**
     * 体积
     */
    
    private Double volume;

    /**
     * 状态
     */
    
    private Byte status;

    /**
     * 入库预约启始时间
     */
    
    private Long reservationBegindt;

    /**
     * 入库预约结束时间
     */
    
    private Long reservationEnddt;

    /**
     * 入库预约号
     */
    
    private String reservationNo;

    /**
     * 入库预约人
     */
    
    private String reservationUser;

    /**
     * 是否已预约 0-未预约-1-已预约
     */
    
    private Byte isReservated;

    /**
     * 装箱状态 0：未装箱；1：装箱忠；2：装箱完成
     */
    
    private Short packingStatus;

    /**
     * 总件数
     */
    
    private Long totalQty;

    /**
     * 总吊牌价
     */
    
    private Double totalTagPrice;

    /**
     * 装箱数量
     */
    
    private Integer totalPackingQty;

    /**
     * 审核人名称
     */
    
    private String authUser;

    /**
     * 供应商编码
     */
    
    private String vendorCode;

    /**
     * 审核时间
     */
    
    private Long authTime;

    /**
     * 审核人联系人名称
     */
    
    private String authContactor;

    /**
     * PO上架时间
     */
    
    private String startOnRacksTime;

    /**
     * 流程备注
     */
    
    private String flowRemark;

    /**
     * 备注
     */
    
    private String remark;

    /**
     * 创建人
     */
    
    private String createdByUser;

    /**
     * 创建时间
     */
    
    private Long createdDtmLoc;

    /**
     * 修改人
     */
    
    private String updatedByUser;

    /**
     * 修改者当地时间
     */
    
    private Long updatedDtmLoc;

    /**
     * 是否按箱收货（0：否；1：是；默认为0）
     */
    
    private Byte boxFlag;

    /**
     * 采购员
     */
    
    private String buyer;

    /**
     * 是否允许分批入库（0：否，1：是，默认为1）
     */
    
    private Byte isBatchStorage;

    /**
     * 开始入库时间
     */
    @Required("开始入库时间 ")
    private Long warehousingTime;

    /**
     * 发货时间 (例：2017-08-08 08:08:08)
     */
    
    private Long deliveryTime;

    /**
     * 预计到货时间 (例：2017-08-08 08:08:08)
     */
    
    private Long expectArriveTime;

    /**
     * 发货联系人
     */
    
    private String deliveryContacter;

    /**
     * 发货联系人电话
     */
    
    private String deliveryContacterTel;

    /**
     * 发货联系人手机
     */
    
    private String deliveryContacterMobile;

    /**
     * 发货门店编码
     */
    
    private String deliveryStoreCode;

    /**
     * 发货门店名称
     */
    
    private String deliveryStoreName;

    /**
     * 发货国家
     */
    
    private String deliveryCountry;

    /**
     * 销售区域
     */
    
    private String saleArea;

    /**
     * 发货省份编码
     */
    
    private String deliveryStateCode;

    /**
     * 发货省份名称
     */
    
    private String deliveryStateName;

    /**
     * 发货城市编码
     */
    
    private String deliveryCityCode;

    /**
     * 发货城市名称
     */
    
    private String deliveryCityName;

    /**
     * 发货区域编码
     */
    
    private String deliveryDistrictCode;

    /**
     * 发货区域名称
     */
    
    private String deliveryDistrictName;

    /**
     * 发货地址
     */
    
    private String deliveryDetailAddress;

    /**
     * 关闭PO操作时间/入库完成时间
     */
    
    private Long operTime;

    /**
     * 业务来源
     */
    
    private String transactionSource;

    /**
     * 邮政编码
     */
    
    private String zipCode;

    /**
     * 直通车退货单号
     */
    
    private String returnNo;

    /**
     * 开始入库时间
     */
    
    private Long firstIqcTime;

    /**
     * 关闭入库单时间
     */
    
    private Long receiptClosedTime;

    /**
     * 唯品会退供单号
     */
    
    private String vipReturnSn;

    /**
     * 仓库收货人
     */
    
    private String receiver;

    // 构造函数
    public PoInfo() {super();}

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public String getReceiverTel() {
        return receiverTel;
    }

    public void setReceiverTel(String receiverTel) {
        this.receiverTel = receiverTel;
    }

    public String getReceiverMobie() {
        return receiverMobie;
    }

    public void setReceiverMobie(String receiverMobie) {
        this.receiverMobie = receiverMobie;
    }

    public String getReceiverCountry() {
        return receiverCountry;
    }

    public void setReceiverCountry(String receiverCountry) {
        this.receiverCountry = receiverCountry;
    }

    public String getReceiverStateName() {
        return receiverStateName;
    }

    public void setReceiverStateName(String receiverStateName) {
        this.receiverStateName = receiverStateName;
    }

    public String getReceiverStateCode() {
        return receiverStateCode;
    }

    public void setReceiverStateCode(String receiverStateCode) {
        this.receiverStateCode = receiverStateCode;
    }

    public String getReceiverCityName() {
        return receiverCityName;
    }

    public void setReceiverCityName(String receiverCityName) {
        this.receiverCityName = receiverCityName;
    }

    public String getReceiverCityCode() {
        return receiverCityCode;
    }

    public void setReceiverCityCode(String receiverCityCode) {
        this.receiverCityCode = receiverCityCode;
    }

    public String getReceiverDistrictName() {
        return receiverDistrictName;
    }

    public void setReceiverDistrictName(String receiverDistrictName) {
        this.receiverDistrictName = receiverDistrictName;
    }

    public String getReceiverDistrictCode() {
        return receiverDistrictCode;
    }

    public void setReceiverDistrictCode(String receiverDistrictCode) {
        this.receiverDistrictCode = receiverDistrictCode;
    }

    public String getReceiverDetailAddress() {
        return receiverDetailAddress;
    }

    public void setReceiverDetailAddress(String receiverDetailAddress) {
        this.receiverDetailAddress = receiverDetailAddress;
    }

    public String getClientPoNo() {
        return clientPoNo;
    }

    public void setClientPoNo(String clientPoNo) {
        this.clientPoNo = clientPoNo;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Byte getChannel() {
        return channel;
    }

    public void setChannel(Byte channel) {
        this.channel = channel;
    }

    public String getReturnContacter() {
        return returnContacter;
    }

    public void setReturnContacter(String returnContacter) {
        this.returnContacter = returnContacter;
    }

    public String getReturnContacterTel() {
        return returnContacterTel;
    }

    public void setReturnContacterTel(String returnContacterTel) {
        this.returnContacterTel = returnContacterTel;
    }

    public String getReturnContacterMobile() {
        return returnContacterMobile;
    }

    public void setReturnContacterMobile(String returnContacterMobile) {
        this.returnContacterMobile = returnContacterMobile;
    }

    public String getReturnCountry() {
        return returnCountry;
    }

    public void setReturnCountry(String returnCountry) {
        this.returnCountry = returnCountry;
    }

    public String getReturnStateName() {
        return returnStateName;
    }

    public void setReturnStateName(String returnStateName) {
        this.returnStateName = returnStateName;
    }

    public String getReturnStateCode() {
        return returnStateCode;
    }

    public void setReturnStateCode(String returnStateCode) {
        this.returnStateCode = returnStateCode;
    }

    public String getReturnCityName() {
        return returnCityName;
    }

    public void setReturnCityName(String returnCityName) {
        this.returnCityName = returnCityName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReturnCityCode() {
        return returnCityCode;
    }

    public void setReturnCityCode(String returnCityCode) {
        this.returnCityCode = returnCityCode;
    }

    public String getReturnDistrictName() {
        return returnDistrictName;
    }

    public void setReturnDistrictName(String returnDistrictName) {
        this.returnDistrictName = returnDistrictName;
    }

    public String getReturnDistrictCode() {
        return returnDistrictCode;
    }

    public void setReturnDistrictCode(String returnDistrictCode) {
        this.returnDistrictCode = returnDistrictCode;
    }

    public String getReturnDetailAddress() {
        return returnDetailAddress;
    }

    public void setReturnDetailAddress(String returnDetailAddress) {
        this.returnDetailAddress = returnDetailAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte getIsNeedFaceCount() {
        return isNeedFaceCount;
    }

    public void setIsNeedFaceCount(Byte isNeedFaceCount) {
        this.isNeedFaceCount = isNeedFaceCount;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Double getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(Double totalVolume) {
        this.totalVolume = totalVolume;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getReservationBegindt() {
        return reservationBegindt;
    }

    public void setReservationBegindt(Long reservationBegindt) {
        this.reservationBegindt = reservationBegindt;
    }

    public Long getReservationEnddt() {
        return reservationEnddt;
    }

    public void setReservationEnddt(Long reservationEnddt) {
        this.reservationEnddt = reservationEnddt;
    }

    public String getReservationNo() {
        return reservationNo;
    }

    public void setReservationNo(String reservationNo) {
        this.reservationNo = reservationNo;
    }

    public String getReservationUser() {
        return reservationUser;
    }

    public void setReservationUser(String reservationUser) {
        this.reservationUser = reservationUser;
    }

    public Byte getIsReservated() {
        return isReservated;
    }

    public void setIsReservated(Byte isReservated) {
        this.isReservated = isReservated;
    }

    public Short getPackingStatus() {
        return packingStatus;
    }

    public void setPackingStatus(Short packingStatus) {
        this.packingStatus = packingStatus;
    }

    public Long getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(Long totalQty) {
        this.totalQty = totalQty;
    }

    public Double getTotalTagPrice() {
        return totalTagPrice;
    }

    public void setTotalTagPrice(Double totalTagPrice) {
        this.totalTagPrice = totalTagPrice;
    }

    public Integer getTotalPackingQty() {
        return totalPackingQty;
    }

    public void setTotalPackingQty(Integer totalPackingQty) {
        this.totalPackingQty = totalPackingQty;
    }

    public String getAuthUser() {
        return authUser;
    }

    public void setAuthUser(String authUser) {
        this.authUser = authUser;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public Long getAuthTime() {
        return authTime;
    }

    public void setAuthTime(Long authTime) {
        this.authTime = authTime;
    }

    public String getAuthContactor() {
        return authContactor;
    }

    public void setAuthContactor(String authContactor) {
        this.authContactor = authContactor;
    }

    public String getStartOnRacksTime() {
        return startOnRacksTime;
    }

    public void setStartOnRacksTime(String startOnRacksTime) {
        this.startOnRacksTime = startOnRacksTime;
    }

    public String getFlowRemark() {
        return flowRemark;
    }

    public void setFlowRemark(String flowRemark) {
        this.flowRemark = flowRemark;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(String createdByUser) {
        this.createdByUser = createdByUser;
    }

    public Long getCreatedDtmLoc() {
        return createdDtmLoc;
    }

    public void setCreatedDtmLoc(Long createdDtmLoc) {
        this.createdDtmLoc = createdDtmLoc;
    }

    public String getUpdatedByUser() {
        return updatedByUser;
    }

    public void setUpdatedByUser(String updatedByUser) {
        this.updatedByUser = updatedByUser;
    }

    public Long getUpdatedDtmLoc() {
        return updatedDtmLoc;
    }

    public void setUpdatedDtmLoc(Long updatedDtmLoc) {
        this.updatedDtmLoc = updatedDtmLoc;
    }

    public Byte getBoxFlag() {
        return boxFlag;
    }

    public void setBoxFlag(Byte boxFlag) {
        this.boxFlag = boxFlag;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public Byte getIsBatchStorage() {
        return isBatchStorage;
    }

    public void setIsBatchStorage(Byte isBatchStorage) {
        this.isBatchStorage = isBatchStorage;
    }

    public Long getWarehousingTime() {
        return warehousingTime;
    }

    public void setWarehousingTime(Long warehousingTime) {
        this.warehousingTime = warehousingTime;
    }

    public Long getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Long deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Long getExpectArriveTime() {
        return expectArriveTime;
    }

    public void setExpectArriveTime(Long expectArriveTime) {
        this.expectArriveTime = expectArriveTime;
    }

    public String getDeliveryContacter() {
        return deliveryContacter;
    }

    public void setDeliveryContacter(String deliveryContacter) {
        this.deliveryContacter = deliveryContacter;
    }

    public String getDeliveryContacterTel() {
        return deliveryContacterTel;
    }

    public void setDeliveryContacterTel(String deliveryContacterTel) {
        this.deliveryContacterTel = deliveryContacterTel;
    }

    public String getDeliveryContacterMobile() {
        return deliveryContacterMobile;
    }

    public void setDeliveryContacterMobile(String deliveryContacterMobile) {
        this.deliveryContacterMobile = deliveryContacterMobile;
    }

    public String getDeliveryStoreCode() {
        return deliveryStoreCode;
    }

    public void setDeliveryStoreCode(String deliveryStoreCode) {
        this.deliveryStoreCode = deliveryStoreCode;
    }

    public String getDeliveryStoreName() {
        return deliveryStoreName;
    }

    public void setDeliveryStoreName(String deliveryStoreName) {
        this.deliveryStoreName = deliveryStoreName;
    }

    public String getDeliveryCountry() {
        return deliveryCountry;
    }

    public void setDeliveryCountry(String deliveryCountry) {
        this.deliveryCountry = deliveryCountry;
    }

    public String getSaleArea() {
        return saleArea;
    }

    public void setSaleArea(String saleArea) {
        this.saleArea = saleArea;
    }

    public String getDeliveryStateCode() {
        return deliveryStateCode;
    }

    public void setDeliveryStateCode(String deliveryStateCode) {
        this.deliveryStateCode = deliveryStateCode;
    }

    public String getDeliveryStateName() {
        return deliveryStateName;
    }

    public void setDeliveryStateName(String deliveryStateName) {
        this.deliveryStateName = deliveryStateName;
    }

    public String getDeliveryCityCode() {
        return deliveryCityCode;
    }

    public void setDeliveryCityCode(String deliveryCityCode) {
        this.deliveryCityCode = deliveryCityCode;
    }

    public String getDeliveryCityName() {
        return deliveryCityName;
    }

    public void setDeliveryCityName(String deliveryCityName) {
        this.deliveryCityName = deliveryCityName;
    }

    public String getDeliveryDistrictCode() {
        return deliveryDistrictCode;
    }

    public void setDeliveryDistrictCode(String deliveryDistrictCode) {
        this.deliveryDistrictCode = deliveryDistrictCode;
    }

    public String getDeliveryDistrictName() {
        return deliveryDistrictName;
    }

    public void setDeliveryDistrictName(String deliveryDistrictName) {
        this.deliveryDistrictName = deliveryDistrictName;
    }

    public String getDeliveryDetailAddress() {
        return deliveryDetailAddress;
    }

    public void setDeliveryDetailAddress(String deliveryDetailAddress) {
        this.deliveryDetailAddress = deliveryDetailAddress;
    }

    public Long getOperTime() {
        return operTime;
    }

    public void setOperTime(Long operTime) {
        this.operTime = operTime;
    }

    public String getTransactionSource() {
        return transactionSource;
    }

    public void setTransactionSource(String transactionSource) {
        this.transactionSource = transactionSource;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getReturnNo() {
        return returnNo;
    }

    public void setReturnNo(String returnNo) {
        this.returnNo = returnNo;
    }

    public Long getFirstIqcTime() {
        return firstIqcTime;
    }

    public void setFirstIqcTime(Long firstIqcTime) {
        this.firstIqcTime = firstIqcTime;
    }

    public Long getReceiptClosedTime() {
        return receiptClosedTime;
    }

    public void setReceiptClosedTime(Long receiptClosedTime) {
        this.receiptClosedTime = receiptClosedTime;
    }

    public String getVipReturnSn() {
        return vipReturnSn;
    }

    public void setVipReturnSn(String vipReturnSn) {
        this.vipReturnSn = vipReturnSn;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

}
