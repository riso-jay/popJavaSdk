package com.pjbest.wop.wm.service;

import java.util.List;

import com.vip.pop.BaseService;
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.utils.JsonUtils;

/**
 * 唯品物流WOP外部报表接口
 */
public class WmReportingService {

    private static final String SERVICE_NAME = "com.pjbest.wop.wm.service.WmReportingService";
    private final BaseService baseService;

    /**
     * 构造函数
     */
    public WmReportingService() {
        this.baseService = PopServiceFactory.getBaseService();
    }

    /**
     * 渠道库存查询
     * 对应方法: channelInvQuery(STRUCT queryChannelReq)
     * @param queryChannelReq 查询条件 (必填)
     * @return com.pjbest.wop.wm.service.ChannelInvResponse
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.ChannelInvResponse channelInvQuery(com.pjbest.wop.wm.service.ChannelInvReq queryChannelReq) throws Exception {
        if (queryChannelReq == null) {
            throw new IllegalArgumentException("queryChannelReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"queryChannelReq\":").append(JsonUtils.toStr(queryChannelReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "channelInvQuery", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, ChannelInvResponse.class);
    }

    /**
     * osp-idlc默认生成此接口方法，建议服务开发者实现此接口，用于osp-monitor等工具检测该服务的健康情况。
     * 对应方法: healthCheck()
     * @throws Exception 请求异常
     */
    public void healthCheck() throws Exception {

        // 无参数
        String result = baseService.doRequest(SERVICE_NAME, "healthCheck", "{}");

        // 无返回值,仅执行请求
    }

    /**
     * 库存盘点结果确认接口
     * 对应方法: invCheckReportAck(STRING customerCode, LIST ackResultList)
     * @param customerCode 客户编码 (必填)
     * @param ackResultList 流水确认结果 (必填)
     * @return com.pjbest.wop.wm.service.InvCheckAckResponse
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.InvCheckAckResponse invCheckReportAck(String customerCode, java.util.List<com.pjbest.wop.wm.service.InvCheckReportAckResult> ackResultList) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (ackResultList == null || ackResultList.isEmpty()) {
            throw new IllegalArgumentException("ackResultList不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"ackResultList\":[");
        for (int i = 0; i < ackResultList.size(); i++) {
            if (i > 0) params.append(",");
            params.append(JsonUtils.toStr(ackResultList.get(i)));
        }
        params.append("]");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "invCheckReportAck", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, InvCheckAckResponse.class);
    }

    /**
     * 库存盘点结果查询
     * 对应方法: invCheckReportQuery(STRING customerCode, INTEGER pageNum, INTEGER pageSize)
     * @param customerCode 客户编码 (必填)
     * @param pageNum 页码 (必填)
     * @param pageSize 每页数量 (必填)
     * @return com.pjbest.wop.wm.service.InvCheckResponse
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.InvCheckResponse invCheckReportQuery(String customerCode, Integer pageNum, Integer pageSize) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (pageNum == null) {
            throw new IllegalArgumentException("pageNum不能为空");
        }
        if (pageSize == null) {
            throw new IllegalArgumentException("pageSize不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"pageNum\":").append(pageNum);
        params.append(",");
        params.append("\"pageSize\":").append(pageSize);
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "invCheckReportQuery", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, InvCheckResponse.class);
    }

    /**
     * 出库SKU汇总查询
     * 对应方法: queryInvOutQuantitySkuSum(STRING vendorCode, STRING startDate, STRING endDate, STRING warehouseCode, STRING itemCode)
     * @param vendorCode 供应商编码 (必填)
     * @param startDate 开始时间,格式为：yyyy-mm-dd (必填)
     * @param endDate 结束时间,格式为：yyyy-mm-dd (必填)
     * @param warehouseCode 仓库编码 (选填)
     * @param itemCode 商品编码 (选填)
     * @return com.pjbest.wop.wm.service.InventorySkuSumResponse
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.InventorySkuSumResponse queryInvOutQuantitySkuSum(String vendorCode, String startDate, String endDate, String warehouseCode, String itemCode) throws Exception {
        if (vendorCode == null || vendorCode.trim().isEmpty()) {
            throw new IllegalArgumentException("vendorCode不能为空");
        }
        if (startDate == null || startDate.trim().isEmpty()) {
            throw new IllegalArgumentException("startDate不能为空");
        }
        if (endDate == null || endDate.trim().isEmpty()) {
            throw new IllegalArgumentException("endDate不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"vendorCode\":\"").append(vendorCode).append("\"");
        params.append(",");
        params.append("\"startDate\":\"").append(startDate).append("\"");
        params.append(",");
        params.append("\"endDate\":\"").append(endDate).append("\"");
        if (warehouseCode != null && !warehouseCode.trim().isEmpty()) {
            params.append(",");
            params.append("\"warehouseCode\":\"").append(warehouseCode).append("\"");
        }
        if (itemCode != null && !itemCode.trim().isEmpty()) {
            params.append(",");
            params.append("\"itemCode\":\"").append(itemCode).append("\"");
        }
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "queryInvOutQuantitySkuSum", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, InventorySkuSumResponse.class);
    }

    /**
     * 进销存报表查询
     * 对应方法: queryPurchaseSalesInventory(STRUCT query)
     * @param query 查询条件 (必填)
     * @return com.pjbest.wop.wm.service.PurchaseSalesResponse
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.PurchaseSalesResponse queryPurchaseSalesInventory(com.pjbest.wop.wm.service.PurchaseSalesRequest query) throws Exception {
        if (query == null) {
            throw new IllegalArgumentException("query不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"query\":").append(JsonUtils.toStr(query));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "queryPurchaseSalesInventory", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, PurchaseSalesResponse.class);
    }

    /**
     * 实时库存报表查询
     * 对应方法: queryRealtimeInventory(STRUCT query)
     * @param query 查询条件 (必填)
     * @return com.pjbest.wop.wm.service.RealtimeInventoryResponse
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.RealtimeInventoryResponse queryRealtimeInventory(com.pjbest.wop.wm.service.RealtimeInventoryRequest query) throws Exception {
        if (query == null) {
            throw new IllegalArgumentException("query不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"query\":").append(JsonUtils.toStr(query));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "queryRealtimeInventory", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, RealtimeInventoryResponse.class);
    }

    /**
     * wms119库存报表查询
     * 对应方法: queryWms119Inventory(STRUCT query)
     * @param query 查询条件 (必填)
     * @return String
     * @throws Exception 请求异常
     */
    public String queryWms119Inventory(com.pjbest.wop.wm.service.Wms119InventoryRequest query) throws Exception {
        if (query == null) {
            throw new IllegalArgumentException("query不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"query\":").append(JsonUtils.toStr(query));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "queryWms119Inventory", params.toString());

        // 返回基本类型结果
        return JsonUtils.toObj(result, String.class);
    }

    /**
     * 库存异动通知确认接口
     * 对应方法: stockChangeReportAck(STRING customerCode, LIST ackResultList, STRING bizType, STRING virtualClientCode)
     * @param customerCode 客户编码 (必填)
     * @param ackResultList 流水确认结果 (必填)
     * @param bizType 库存异动业务类型 (选填)
     * @param virtualClientCode 虚拟货主客户编码 (选填)
     * @return java.util.List<com.pjbest.wop.wm.service.StockchangeReportAck>
     * @throws Exception 请求异常
     */
    public java.util.List<com.pjbest.wop.wm.service.StockchangeReportAck> stockChangeReportAck(String customerCode, java.util.List<com.pjbest.wop.wm.service.StockchangeReportAck> ackResultList, String bizType, String virtualClientCode) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (ackResultList == null || ackResultList.isEmpty()) {
            throw new IllegalArgumentException("ackResultList不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"ackResultList\":[");
        for (int i = 0; i < ackResultList.size(); i++) {
            if (i > 0) params.append(",");
            params.append(JsonUtils.toStr(ackResultList.get(i)));
        }
        params.append("]");
        if (bizType != null && !bizType.trim().isEmpty()) {
            params.append(",");
            params.append("\"bizType\":\"").append(bizType).append("\"");
        }
        if (virtualClientCode != null && !virtualClientCode.trim().isEmpty()) {
            params.append(",");
            params.append("\"virtualClientCode\":\"").append(virtualClientCode).append("\"");
        }
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "stockChangeReportAck", params.toString());

        // 将API响应结果转换为List对象
        return JsonUtils.toList(result, StockchangeReportAck.class);
    }

    /**
     * 库存异动通知确认接口
     * 对应方法: stockChangeReportAckByObj(STRUCT stockChangeReportAckReq)
     * @param customerCode 客户编码 (必填)
     * @param ackResultList 流水确认结果 (必填)
     * @param bizType 库存异动业务类型 (选填)
     * @param virtualClientCode 虚拟货主客户编码 (选填)
     * @return java.util.List<com.pjbest.wop.wm.service.StockchangeReportAck>
     * @throws Exception 请求异常
     */
    public java.util.List<com.pjbest.wop.wm.service.StockchangeReportAck> stockChangeReportAckByObj(String customerCode, java.util.List<com.pjbest.wop.wm.service.StockchangeReportAck> ackResultList, String bizType, String virtualClientCode) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (ackResultList == null || ackResultList.isEmpty()) {
            throw new IllegalArgumentException("ackResultList不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"ackResultList\":[");
        for (int i = 0; i < ackResultList.size(); i++) {
            if (i > 0) params.append(",");
            params.append(JsonUtils.toStr(ackResultList.get(i)));
        }
        params.append("]");
        if (bizType != null && !bizType.trim().isEmpty()) {
            params.append(",");
            params.append("\"bizType\":\"").append(bizType).append("\"");
        }
        if (virtualClientCode != null && !virtualClientCode.trim().isEmpty()) {
            params.append(",");
            params.append("\"virtualClientCode\":\"").append(virtualClientCode).append("\"");
        }
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "stockChangeReportAckByObj", params.toString());

        // 将API响应结果转换为List对象
        return JsonUtils.toList(result, StockchangeReportAck.class);
    }

    /**
     * 库存异动查询
     * 对应方法: stockChangeReportQuery(STRING customerCode, INTEGER pageNum, INTEGER pageSize, STRING bizType, STRING virtualClientCode)
     * @param customerCode 客户编码 (必填)
     * @param pageNum 页码 (必填)
     * @param pageSize 每页数量 (必填)
     * @param bizType 库存异动业务类型 (选填)
     * @param virtualClientCode 虚拟货主客户编码 (选填)
     * @return java.util.List<com.pjbest.wop.wm.service.StockchangeReportRes>
     * @throws Exception 请求异常
     */
    public java.util.List<com.pjbest.wop.wm.service.StockchangeReportRes> stockChangeReportQuery(String customerCode, Integer pageNum, Integer pageSize, String bizType, String virtualClientCode) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (pageNum == null) {
            throw new IllegalArgumentException("pageNum不能为空");
        }
        if (pageSize == null) {
            throw new IllegalArgumentException("pageSize不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"pageNum\":").append(pageNum);
        params.append(",");
        params.append("\"pageSize\":").append(pageSize);
        if (bizType != null && !bizType.trim().isEmpty()) {
            params.append(",");
            params.append("\"bizType\":\"").append(bizType).append("\"");
        }
        if (virtualClientCode != null && !virtualClientCode.trim().isEmpty()) {
            params.append(",");
            params.append("\"virtualClientCode\":\"").append(virtualClientCode).append("\"");
        }
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "stockChangeReportQuery", params.toString());

        // 将API响应结果转换为List对象
        return JsonUtils.toList(result, StockchangeReportRes.class);
    }

    /**
     * 库存异动查询
     * 对应方法: stockChangeReportQueryByObj(STRUCT stockChangeReportReq)
     * @param customerCode 客户编码 (必填)
     * @param pageNum 页码 (必填)
     * @param pageSize 每页数量 (必填)
     * @param bizType 库存异动业务类型 (选填)
     * @param virtualClientCode 虚拟货主客户编码 (选填)
     * @return java.util.List<com.pjbest.wop.wm.service.StockchangeReportRes>
     * @throws Exception 请求异常
     */
    public java.util.List<com.pjbest.wop.wm.service.StockchangeReportRes> stockChangeReportQueryByObj(String customerCode, Integer pageNum, Integer pageSize, String bizType, String virtualClientCode) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (pageNum == null) {
            throw new IllegalArgumentException("pageNum不能为空");
        }
        if (pageSize == null) {
            throw new IllegalArgumentException("pageSize不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"pageNum\":").append(pageNum);
        params.append(",");
        params.append("\"pageSize\":").append(pageSize);
        if (bizType != null && !bizType.trim().isEmpty()) {
            params.append(",");
            params.append("\"bizType\":\"").append(bizType).append("\"");
        }
        if (virtualClientCode != null && !virtualClientCode.trim().isEmpty()) {
            params.append(",");
            params.append("\"virtualClientCode\":\"").append(virtualClientCode).append("\"");
        }
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "stockChangeReportQueryByObj", params.toString());

        // 将API响应结果转换为List对象
        return JsonUtils.toList(result, StockchangeReportRes.class);
    }

}
