package com.vip.wop.app.jit.service;

import java.util.List;

import com.vip.pop.BaseService;
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.utils.JsonUtils;

/**
 * 云仓JIT订单服务
 */
public class WopJitOrderPopService {

    private static final String SERVICE_NAME = "com.vip.wop.app.jit.service.WopJitOrderPopService";
    private final BaseService baseService;

    /**
     * 构造函数
     */
    public WopJitOrderPopService() {
        this.baseService = PopServiceFactory.getBaseService();
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
     * 云仓JIT订单查询接口
     * 对应方法: queryJitOrder(STRUCT request, INTEGER pageNum, INTEGER pageSize)
     * @param request 查询条件 (必填)
     * @param pageNum 页码，默认为1 (选填)
     * @param pageSize 页大小，默认为10，最大50 (选填)
     * @return com.vip.wop.app.jit.service.JitOrderQueryResponse
     * @throws Exception 请求异常
     */
    public com.vip.wop.app.jit.service.JitOrderQueryResponse queryJitOrder(com.vip.wop.app.jit.service.JitOrderQueryRequest request, Integer pageNum, Integer pageSize) throws Exception {
        if (request == null) {
            throw new IllegalArgumentException("request不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"request\":").append(JsonUtils.toStr(request));
        if (pageNum != null) {
            params.append(",");
            params.append("\"pageNum\":").append(pageNum);
        }
        if (pageSize != null) {
            params.append(",");
            params.append("\"pageSize\":").append(pageSize);
        }
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "queryJitOrder", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, JitOrderQueryResponse.class);
    }

    /**
     * 云仓JIT订单明细查询接口
     * 对应方法: queryJitOrderDetail(STRING crmCustCode, STRING platformOrderSn, INTEGER pageNum, INTEGER pageSize)
     * @param crmCustCode 供应商编码 (必填)
     * @param platformOrderSn JIT送货单号 (必填)
     * @param pageNum 页码，默认为1 (选填)
     * @param pageSize 页大小，默认为10，最大50 (选填)
     * @return com.vip.wop.app.jit.service.JitOrderDetailQueryResponse
     * @throws Exception 请求异常
     */
    public com.vip.wop.app.jit.service.JitOrderDetailQueryResponse queryJitOrderDetail(String crmCustCode, String platformOrderSn, Integer pageNum, Integer pageSize) throws Exception {
        if (crmCustCode == null || crmCustCode.trim().isEmpty()) {
            throw new IllegalArgumentException("crmCustCode不能为空");
        }
        if (platformOrderSn == null || platformOrderSn.trim().isEmpty()) {
            throw new IllegalArgumentException("platformOrderSn不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"crmCustCode\":\"").append(crmCustCode).append("\"");
        params.append(",");
        params.append("\"platformOrderSn\":\"").append(platformOrderSn).append("\"");
        if (pageNum != null) {
            params.append(",");
            params.append("\"pageNum\":").append(pageNum);
        }
        if (pageSize != null) {
            params.append(",");
            params.append("\"pageSize\":").append(pageSize);
        }
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "queryJitOrderDetail", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, JitOrderDetailQueryResponse.class);
    }

}
