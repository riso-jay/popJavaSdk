package com.pjbest.wop.wm.service;

import java.util.List;

import com.vip.pop.BaseService;
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.utils.JsonUtils;

/**
 * WOP外部订单接口
 */
public class WopOuterOrderService {

    private static final String SERVICE_NAME = "com.pjbest.wop.wm.service.WopOuterOrderService";
    private final BaseService baseService;

    /**
     * 构造函数
     */
    public WopOuterOrderService() {
        this.baseService = PopServiceFactory.getBaseService();
    }

    /**
     * 批量取消订单接口
     * 对应方法: batchCancelOrder(STRING customerCode, LIST wopErpOrderSnList)
     * @param customerCode 客户编码 (必填)
     * @param wopErpOrderSnList 唯品物流ERP订单号 (必填)
     * @return java.util.List<com.pjbest.wop.wm.service.OrderCancelResult>
     * @throws Exception 请求异常
     */
    public java.util.List<com.pjbest.wop.wm.service.OrderCancelResult> batchCancelOrder(String customerCode, java.util.List<String> wopErpOrderSnList) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (wopErpOrderSnList == null || wopErpOrderSnList.isEmpty()) {
            throw new IllegalArgumentException("wopErpOrderSnList不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"wopErpOrderSnList\":[");
        for (int i = 0; i < wopErpOrderSnList.size(); i++) {
            if (i > 0) params.append(",");
            params.append("\"").append(wopErpOrderSnList.get(i)).append("\"");
        }
        params.append("]");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "batchCancelOrder", params.toString());

        // 将API响应结果转换为List对象
        return JsonUtils.toList(result, OrderCancelResult.class);
    }

    /**
     * 获取订单物流轨迹接口
     * 对应方法: getDeliveryTrace(STRUCT req)
     * @param req 获取单物流轨迹请求 (必填)
     * @return com.pjbest.wop.wm.service.GetOrderDeliveryTraceRespone
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.GetOrderDeliveryTraceRespone getDeliveryTrace(com.pjbest.wop.wm.service.GetOrderDeliveryTraceRequest req) throws Exception {
        if (req == null) {
            throw new IllegalArgumentException("req不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"req\":").append(JsonUtils.toStr(req));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "getDeliveryTrace", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, GetOrderDeliveryTraceRespone.class);
    }

    /**
     * 查询订单明细接口
     * 对应方法: getOrderDetails(STRING customerCode, STRING wopErpOrderSn)
     * @param customerCode 客户编码 (必填)
     * @param wopErpOrderSn 唯品物流ERP订单号 (必填)
     * @return java.util.List<com.pjbest.wop.wm.service.OrderDetail>
     * @throws Exception 请求异常
     */
    public java.util.List<com.pjbest.wop.wm.service.OrderDetail> getOrderDetails(String customerCode, String wopErpOrderSn) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (wopErpOrderSn == null || wopErpOrderSn.trim().isEmpty()) {
            throw new IllegalArgumentException("wopErpOrderSn不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"wopErpOrderSn\":\"").append(wopErpOrderSn).append("\"");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "getOrderDetails", params.toString());

        // 将API响应结果转换为List对象
        return JsonUtils.toList(result, OrderDetail.class);
    }

    /**
     * 获获取订单缺货接口
     * 对应方法: getOrderLackByMaxId(STRUCT req)
     * @throws Exception 请求异常
     */
    public void getOrderLackByMaxId() throws Exception {

        // 无参数
        String result = baseService.doRequest(SERVICE_NAME, "getOrderLackByMaxId", "{}");

        // 无返回值,仅执行请求
    }

    /**
     * 查询订单状态接口
     * 对应方法: getOrderStatus(STRING customerCode, STRING wopErpOrderSn)
     * @param customerCode 客户编码 (必填)
     * @param wopErpOrderSn 唯品物流ERP订单号 (必填)
     * @return com.pjbest.wop.wm.service.OrderStatus
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.OrderStatus getOrderStatus(String customerCode, String wopErpOrderSn) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (wopErpOrderSn == null || wopErpOrderSn.trim().isEmpty()) {
            throw new IllegalArgumentException("wopErpOrderSn不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"wopErpOrderSn\":\"").append(wopErpOrderSn).append("\"");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "getOrderStatus", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, OrderStatus.class);
    }

    /**
     * 批量查询订单状态接口
     * 对应方法: getOrderStatusBatch(STRING customerCode, LONG maxId, INTEGER limit)
     * @param customerCode 客户编码 (必填)
     * @param maxId 上次查询返回的最大ID (必填)
     * @param limit 查询数量 (必填)
     * @return java.util.List<com.pjbest.wop.wm.service.OrderStatus>
     * @throws Exception 请求异常
     */
    public java.util.List<com.pjbest.wop.wm.service.OrderStatus> getOrderStatusBatch(String customerCode, Long maxId, Integer limit) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (maxId == null) {
            throw new IllegalArgumentException("maxId不能为空");
        }
        if (limit == null) {
            throw new IllegalArgumentException("limit不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"maxId\":").append(maxId);
        params.append(",");
        params.append("\"limit\":").append(limit);
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "getOrderStatusBatch", params.toString());

        // 将API响应结果转换为List对象
        return JsonUtils.toList(result, OrderStatus.class);
    }

    /**
     * 查询订单轨迹接口
     * 对应方法: getOrderTrace(STRING customerCode, STRING wopErpOrderSn)
     * @param customerCode 客户编码 (必填)
     * @param wopErpOrderSn 唯品物流ERP订单号 (必填)
     * @return java.util.List<com.pjbest.wop.wm.service.OrderTrace>
     * @throws Exception 请求异常
     */
    public java.util.List<com.pjbest.wop.wm.service.OrderTrace> getOrderTrace(String customerCode, String wopErpOrderSn) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (wopErpOrderSn == null || wopErpOrderSn.trim().isEmpty()) {
            throw new IllegalArgumentException("wopErpOrderSn不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"wopErpOrderSn\":\"").append(wopErpOrderSn).append("\"");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "getOrderTrace", params.toString());

        // 将API响应结果转换为List对象
        return JsonUtils.toList(result, OrderTrace.class);
    }

    /**
     * 根据客户ERP订单号查询查询唯品物流ERP订单号
     * 对应方法: getWopErpOrderSnByCustomerErpOrderSn(STRING customerCode, STRING erpOrderSn)
     * @param customerCode 客户编码 (必填)
     * @param erpOrderSn 客户ERP订单号 (必填)
     * @return String
     * @throws Exception 请求异常
     */
    public String getWopErpOrderSnByCustomerErpOrderSn(String customerCode, String erpOrderSn) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (erpOrderSn == null || erpOrderSn.trim().isEmpty()) {
            throw new IllegalArgumentException("erpOrderSn不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"erpOrderSn\":\"").append(erpOrderSn).append("\"");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "getWopErpOrderSnByCustomerErpOrderSn", params.toString());

        // 返回基本类型结果
        return JsonUtils.toObj(result, String.class);
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
     * 订单缺货拉取确认接口
     * 对应方法: orderLackConfirm(STRUCT req)
     * @param req 订单缺货拉取确认请求 (必填)
     * @return com.pjbest.wop.wm.service.OrderLackConfirmRespone
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.OrderLackConfirmRespone orderLackConfirm(com.pjbest.wop.wm.service.OrderLackConfirmRequest req) throws Exception {
        if (req == null) {
            throw new IllegalArgumentException("req不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"req\":").append(JsonUtils.toStr(req));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "orderLackConfirm", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, OrderLackConfirmRespone.class);
    }

    /**
     * 批量查询创建订单任务状态
     * 对应方法: queryCreateOrderTaskStatus(STRING customerCode, LIST createOrderTaskCode)
     * @param customerCode 客户编码 (必填)
     * @param createOrderTaskCode 创建订单任务编码列表 (必填)
     * @return java.util.List<com.pjbest.wop.wm.service.CreateOrderTaskStatus>
     * @throws Exception 请求异常
     */
    public java.util.List<com.pjbest.wop.wm.service.CreateOrderTaskStatus> queryCreateOrderTaskStatus(String customerCode, java.util.List<String> createOrderTaskCode) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (createOrderTaskCode == null || createOrderTaskCode.isEmpty()) {
            throw new IllegalArgumentException("createOrderTaskCode不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"createOrderTaskCode\":[");
        for (int i = 0; i < createOrderTaskCode.size(); i++) {
            if (i > 0) params.append(",");
            params.append("\"").append(createOrderTaskCode.get(i)).append("\"");
        }
        params.append("]");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "queryCreateOrderTaskStatus", params.toString());

        // 将API响应结果转换为List对象
        return JsonUtils.toList(result, CreateOrderTaskStatus.class);
    }

    /**
     * 查询订单出仓数量（带PO）接口
     * 对应方法: queryOutQty(STRUCT req)
     * @param req 查询订单出仓数量（带PO）请求 (必填)
     * @return com.pjbest.wop.wm.service.QueryOutQtyRespone
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.QueryOutQtyRespone queryOutQty(com.pjbest.wop.wm.service.QueryOutQtyRequest req) throws Exception {
        if (req == null) {
            throw new IllegalArgumentException("req不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"req\":").append(JsonUtils.toStr(req));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "queryOutQty", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, QueryOutQtyRespone.class);
    }

    /**
     * 批量提交创建订单任务（异步创建订单）
     * 对应方法: submitCreateOrderTask(STRING customerCode, LIST orderInfo)
     * @param customerCode 客户编码 (必填)
     * @param orderInfo 订单信息 (必填)
     * @return java.util.List<com.pjbest.wop.wm.service.CreateOrderTaskResult>
     * @throws Exception 请求异常
     */
    public java.util.List<com.pjbest.wop.wm.service.CreateOrderTaskResult> submitCreateOrderTask(String customerCode, java.util.List<com.pjbest.wop.wm.service.OrderInfo> orderInfo) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (orderInfo == null || orderInfo.isEmpty()) {
            throw new IllegalArgumentException("orderInfo不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"orderInfo\":[");
        for (int i = 0; i < orderInfo.size(); i++) {
            if (i > 0) params.append(",");
            params.append(JsonUtils.toStr(orderInfo.get(i)));
        }
        params.append("]");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "submitCreateOrderTask", params.toString());

        // 将API响应结果转换为List对象
        return JsonUtils.toList(result, CreateOrderTaskResult.class);
    }

}
