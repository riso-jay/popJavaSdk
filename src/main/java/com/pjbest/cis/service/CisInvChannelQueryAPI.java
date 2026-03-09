package com.pjbest.cis.service;

import java.util.List;

import com.vip.pop.BaseService;
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.utils.JsonUtils;

/**
 * CIS渠道库存查询API
 */
public class CisInvChannelQueryAPI {

    private static final String SERVICE_NAME = "com.pjbest.cis.service.CisInvChannelQueryAPI";
    private final BaseService baseService;

    /**
     * 构造函数
     */
    public CisInvChannelQueryAPI() {
        this.baseService = PopServiceFactory.getBaseService();
    }

    /**
     * 获取供应商业务渠道列表
     * 对应方法: getActionChannel(STRING vendorCode, STRING actionCode, STRING opType, STRING systemPoNo, INTEGER qty, STRING otherPoNo, STRING grade, BYTE saleStatus)
     * @param vendorCode 供应商编码 (必填)
     * @param actionCode 业务编码 (必填)
     * @param opType 业务类型 (必填)
     * @param systemPoNo 入库单号 (选填)
     * @param qty 操作数 (选填)
     * @param otherPoNo 其他入库单号 (选填)
     * @param grade 货品等级 (选填)
     * @param saleStatus 售卖状态 0:可用 1:不可用 (选填)
     * @return com.pjbest.cis.service.ActionChannelList
     * @throws Exception 请求异常
     */
    public com.pjbest.cis.service.ActionChannelList getActionChannel(String vendorCode, String actionCode, String opType, String systemPoNo, Integer qty, String otherPoNo, String grade, Byte saleStatus) throws Exception {
        if (vendorCode == null || vendorCode.trim().isEmpty()) {
            throw new IllegalArgumentException("vendorCode不能为空");
        }
        if (actionCode == null || actionCode.trim().isEmpty()) {
            throw new IllegalArgumentException("actionCode不能为空");
        }
        if (opType == null || opType.trim().isEmpty()) {
            throw new IllegalArgumentException("opType不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"vendorCode\":\"").append(vendorCode).append("\"");
        params.append(",");
        params.append("\"actionCode\":\"").append(actionCode).append("\"");
        params.append(",");
        params.append("\"opType\":\"").append(opType).append("\"");
        if (systemPoNo != null && !systemPoNo.trim().isEmpty()) {
            params.append(",");
            params.append("\"systemPoNo\":\"").append(systemPoNo).append("\"");
        }
        if (qty != null) {
            params.append(",");
            params.append("\"qty\":").append(qty);
        }
        if (otherPoNo != null && !otherPoNo.trim().isEmpty()) {
            params.append(",");
            params.append("\"otherPoNo\":\"").append(otherPoNo).append("\"");
        }
        if (grade != null && !grade.trim().isEmpty()) {
            params.append(",");
            params.append("\"grade\":\"").append(grade).append("\"");
        }
        if (saleStatus != null) {
            params.append(",");
            params.append("\"saleStatus\":").append(saleStatus);
        }
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "getActionChannel", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, ActionChannelList.class);
    }

    /**
     * 获取供应商所有的渠道,供应商没配置则返回默认渠道
     * 对应方法: getAllChannelByPriorityCode(STRING vendorCode, STRING priorityCode)
     * @param vendorCode 供应商编码 (必填)
     * @param priorityCode 优先级代码 (必填)
     * @return java.util.List<Byte>
     * @throws Exception 请求异常
     */
    public java.util.List<Byte> getAllChannelByPriorityCode(String vendorCode, String priorityCode) throws Exception {
        if (vendorCode == null || vendorCode.trim().isEmpty()) {
            throw new IllegalArgumentException("vendorCode不能为空");
        }
        if (priorityCode == null || priorityCode.trim().isEmpty()) {
            throw new IllegalArgumentException("priorityCode不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"vendorCode\":\"").append(vendorCode).append("\"");
        params.append(",");
        params.append("\"priorityCode\":\"").append(priorityCode).append("\"");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "getAllChannelByPriorityCode", params.toString());

        // 将API响应结果转换为List对象
        return JsonUtils.toList(result, Byte.class);
    }

    /**
     * 获取供应商所有的渠道,供应商没配置则返回默认渠道
     * 对应方法: getAllChannelByVendor(STRING vendorCode, BYTE priorityType)
     * @param vendorCode 供应商编码 (必填)
     * @param priorityCode 优先级代码 (必填)
     * @return java.util.List<Byte>
     * @throws Exception 请求异常
     */
    public java.util.List<Byte> getAllChannelByVendor(String vendorCode, String priorityCode) throws Exception {
        if (vendorCode == null || vendorCode.trim().isEmpty()) {
            throw new IllegalArgumentException("vendorCode不能为空");
        }
        if (priorityCode == null || priorityCode.trim().isEmpty()) {
            throw new IllegalArgumentException("priorityCode不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"vendorCode\":\"").append(vendorCode).append("\"");
        params.append(",");
        params.append("\"priorityCode\":\"").append(priorityCode).append("\"");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "getAllChannelByVendor", params.toString());

        // 将API响应结果转换为List对象
        return JsonUtils.toList(result, Byte.class);
    }

    /**
     * 获取渠道优先级类型 0:调减 1:调增
     * 对应方法: getChannelPriorityType(STRING actionCode, STRING opType, INTEGER qty)
     * @throws Exception 请求异常
     */
    public void getChannelPriorityType() throws Exception {

        // 无参数
        String result = baseService.doRequest(SERVICE_NAME, "getChannelPriorityType", "{}");

        // 无返回值,仅执行请求
    }

    /**
     * 获取唯品会渠道销售请求参数
     * 对应方法: getVipChannelSaleBaseReq(STRING vendorCode, STRING warehouse, STRING itemCode)
     * @param vendorCode 供应商编码 (必填)
     * @param warehouse 仓库编码 (必填)
     * @param itemCode 商品编码 (选填)
     * @return com.pjbest.cis.service.QueryChannelReq
     * @throws Exception 请求异常
     */
    public com.pjbest.cis.service.QueryChannelReq getVipChannelSaleBaseReq(String vendorCode, String warehouse, String itemCode) throws Exception {
        if (vendorCode == null || vendorCode.trim().isEmpty()) {
            throw new IllegalArgumentException("vendorCode不能为空");
        }
        if (warehouse == null || warehouse.trim().isEmpty()) {
            throw new IllegalArgumentException("warehouse不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"vendorCode\":\"").append(vendorCode).append("\"");
        params.append(",");
        params.append("\"warehouse\":\"").append(warehouse).append("\"");
        if (itemCode != null && !itemCode.trim().isEmpty()) {
            params.append(",");
            params.append("\"itemCode\":\"").append(itemCode).append("\"");
        }
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "getVipChannelSaleBaseReq", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, QueryChannelReq.class);
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
     * 分页返回查询结果
     * 对应方法: invChannelQueryByPage(STRUCT queryChannelReq, STRUCT paginationModel)
     * @param queryChannelReq 查询对象 (必填)
     * @param paginationModel 分页对象 注:排序不起作用 (必填)
     * @return java.util.List<com.pjbest.cis.service.QueryChannelResult>
     * @throws Exception 请求异常
     */
    public java.util.List<com.pjbest.cis.service.QueryChannelResult> invChannelQueryByPage(com.pjbest.cis.service.QueryChannelReq queryChannelReq, com.pjbest.wop.base.inner.common.service.PaginationModel paginationModel) throws Exception {
        if (queryChannelReq == null) {
            throw new IllegalArgumentException("queryChannelReq不能为空");
        }
        if (paginationModel == null) {
            throw new IllegalArgumentException("paginationModel不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"queryChannelReq\":").append(JsonUtils.toStr(queryChannelReq));
        params.append(",");
        params.append("\"paginationModel\":").append(JsonUtils.toStr(paginationModel));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "invChannelQueryByPage", params.toString());

        // 将API响应结果转换为List对象
        return JsonUtils.toList(result, QueryChannelResult.class);
    }

    /**
     * 查询总记录 数
     * 对应方法: invChannelQueryCount(STRUCT queryChannelReq)
     * @param queryChannelReq 查询对象 (必填)
     * @return Integer
     * @throws Exception 请求异常
     */
    public Integer invChannelQueryCount(com.pjbest.cis.service.QueryChannelReq queryChannelReq) throws Exception {
        if (queryChannelReq == null) {
            throw new IllegalArgumentException("queryChannelReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"queryChannelReq\":").append(JsonUtils.toStr(queryChannelReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "invChannelQueryCount", params.toString());

        // 返回基本类型结果
        return JsonUtils.toObj(result, Integer.class);
    }

    /**
     * 通过渠道库存编码获取渠道库存
     * 对应方法: selectByInvCode(STRING invCode)
     * @param invCode 渠道库存编码 (必填)
     * @return com.pjbest.cis.service.QueryChannelResult
     * @throws Exception 请求异常
     */
    public com.pjbest.cis.service.QueryChannelResult selectByInvCode(String invCode) throws Exception {
        if (invCode == null || invCode.trim().isEmpty()) {
            throw new IllegalArgumentException("invCode不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"invCode\":\"").append(invCode).append("\"");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "selectByInvCode", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, QueryChannelResult.class);
    }

    /**
     * 汇总查询结果
     * 对应方法: selectInvChannelQuerySum(STRUCT queryChannelReq)
     * @param queryChannelReq 查询对象 (必填)
     * @return java.util.List<com.pjbest.cis.service.QueryChannelResult>
     * @throws Exception 请求异常
     */
    public java.util.List<com.pjbest.cis.service.QueryChannelResult> selectInvChannelQuerySum(com.pjbest.cis.service.QueryChannelReq queryChannelReq) throws Exception {
        if (queryChannelReq == null) {
            throw new IllegalArgumentException("queryChannelReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"queryChannelReq\":").append(JsonUtils.toStr(queryChannelReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "selectInvChannelQuerySum", params.toString());

        // 将API响应结果转换为List对象
        return JsonUtils.toList(result, QueryChannelResult.class);
    }

    /**
     * 库存汇总查询
     * 对应方法: selectInvChannelSumByMultiRequests(LIST inventoryQueryReqList)
     * @param inventoryQueryReqList 查询对象集合 (必填)
     * @return java.util.List<com.pjbest.cis.service.InvChannelSum>
     * @throws Exception 请求异常
     */
    public java.util.List<com.pjbest.cis.service.InvChannelSum> selectInvChannelSumByMultiRequests(java.util.List<com.pjbest.cis.service.InventoryQueryReq> inventoryQueryReqList) throws Exception {
        if (inventoryQueryReqList == null || inventoryQueryReqList.isEmpty()) {
            throw new IllegalArgumentException("inventoryQueryReqList不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"inventoryQueryReqList\":[");
        for (int i = 0; i < inventoryQueryReqList.size(); i++) {
            if (i > 0) params.append(",");
            params.append(JsonUtils.toStr(inventoryQueryReqList.get(i)));
        }
        params.append("]");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "selectInvChannelSumByMultiRequests", params.toString());

        // 将API响应结果转换为List对象
        return JsonUtils.toList(result, InvChannelSum.class);
    }

}
