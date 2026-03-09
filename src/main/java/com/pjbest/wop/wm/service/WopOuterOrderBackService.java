package com.pjbest.wop.wm.service;

import java.util.List;

import com.vip.pop.BaseService;
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.utils.JsonUtils;

/**
 * 客退单接口服务
 */
public class WopOuterOrderBackService {

    private static final String SERVICE_NAME = "com.pjbest.wop.wm.service.WopOuterOrderBackService";
    private final BaseService baseService;

    /**
     * 构造函数
     */
    public WopOuterOrderBackService() {
        this.baseService = PopServiceFactory.getBaseService();
    }

    /**
     * 取消客退单
     * 对应方法: cancelOrder(STRING customerCode, STRING orderBackSn)
     * @param customerCode 客户编码 (必填)
     * @param orderBackSn 客退单号 (必填)
     * @return com.pjbest.wop.wm.service.ObCancelResult
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.ObCancelResult cancelOrder(String customerCode, String orderBackSn) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (orderBackSn == null || orderBackSn.trim().isEmpty()) {
            throw new IllegalArgumentException("orderBackSn不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"orderBackSn\":\"").append(orderBackSn).append("\"");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "cancelOrder", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, ObCancelResult.class);
    }

    /**
     * 创建客退单
     * 对应方法: createOrder(STRING customerCode, STRUCT orderBackInfo)
     * @param customerCode 客户编码 (必填)
     * @param orderBackInfo 客退单信息 (必填)
     * @return com.pjbest.wop.wm.service.ObCreateResult
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.ObCreateResult createOrder(String customerCode, com.pjbest.wop.wm.service.OrderBackInfo orderBackInfo) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (orderBackInfo == null) {
            throw new IllegalArgumentException("orderBackInfo不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"orderBackInfo\":").append(JsonUtils.toStr(orderBackInfo));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "createOrder", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, ObCreateResult.class);
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
     * 修改客退单承运商信息
     * 对应方法: modifyCarrier(STRUCT req)
     * @param req 修改客退单承运商请求 (必填)
     * @return com.pjbest.wop.wm.service.ModifyCarrierRespone
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.ModifyCarrierRespone modifyCarrier(com.pjbest.wop.wm.service.ModifyCarrierRequest req) throws Exception {
        if (req == null) {
            throw new IllegalArgumentException("req不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"req\":").append(JsonUtils.toStr(req));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "modifyCarrier", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, ModifyCarrierRespone.class);
    }

    /**
     * 通过erp订单号查询客退单列表
     * 对应方法: queryOrderBackByErpOrderSn(STRING customerCode, STRUCT req)
     * @param customerCode 客户编码 (必填)
     * @param req 客退单号 (必填)
     * @return java.util.List<com.pjbest.wop.wm.service.WopOrderBackInfo>
     * @throws Exception 请求异常
     */
    public java.util.List<com.pjbest.wop.wm.service.WopOrderBackInfo> queryOrderBackByErpOrderSn(String customerCode, com.pjbest.wop.wm.service.QueryByErpOrderSnReq req) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (req == null) {
            throw new IllegalArgumentException("req不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"req\":").append(JsonUtils.toStr(req));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "queryOrderBackByErpOrderSn", params.toString());

        // 将API响应结果转换为List对象
        return JsonUtils.toList(result, WopOrderBackInfo.class);
    }

    /**
     * 查询客退单详情
     * 对应方法: queryOrderDetail(STRING customerCode, STRING orderBackSn)
     * @param customerCode 客户编码 (必填)
     * @param orderBackSn 客退单号 (必填)
     * @return com.pjbest.wop.wm.service.WopOrderBackInfo
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.WopOrderBackInfo queryOrderDetail(String customerCode, String orderBackSn) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (orderBackSn == null || orderBackSn.trim().isEmpty()) {
            throw new IllegalArgumentException("orderBackSn不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"orderBackSn\":\"").append(orderBackSn).append("\"");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "queryOrderDetail", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, WopOrderBackInfo.class);
    }

    /**
     * 批量查询客退单状态
     * 对应方法: queryOrderStatusBatch(STRING customerCode, LIST orderBackSns)
     * @param customerCode 客户编码 (必填)
     * @param orderBackSns 客退单号列表 (必填)
     * @return java.util.List<com.pjbest.wop.wm.service.ObStatusResult>
     * @throws Exception 请求异常
     */
    public java.util.List<com.pjbest.wop.wm.service.ObStatusResult> queryOrderStatusBatch(String customerCode, java.util.List<String> orderBackSns) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (orderBackSns == null || orderBackSns.isEmpty()) {
            throw new IllegalArgumentException("orderBackSns不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"orderBackSns\":[");
        for (int i = 0; i < orderBackSns.size(); i++) {
            if (i > 0) params.append(",");
            params.append("\"").append(orderBackSns.get(i)).append("\"");
        }
        params.append("]");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "queryOrderStatusBatch", params.toString());

        // 将API响应结果转换为List对象
        return JsonUtils.toList(result, ObStatusResult.class);
    }

    /**
     * 查询客退单
     * 对应方法: searchOrderList(STRUCT req)
     * @param customerCode 客户编码 (必填)
     * @param req 客退单号 (必填)
     * @return java.util.List<com.pjbest.wop.wm.service.WopOrderBackInfo>
     * @throws Exception 请求异常
     */
    public java.util.List<com.pjbest.wop.wm.service.WopOrderBackInfo> searchOrderList(String customerCode, com.pjbest.wop.wm.service.QueryByErpOrderSnReq req) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (req == null) {
            throw new IllegalArgumentException("req不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"req\":").append(JsonUtils.toStr(req));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "searchOrderList", params.toString());

        // 将API响应结果转换为List对象
        return JsonUtils.toList(result, WopOrderBackInfo.class);
    }

}
