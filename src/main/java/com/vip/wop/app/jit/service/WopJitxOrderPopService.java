package com.vip.wop.app.jit.service;

import java.util.List;

import com.vip.pop.BaseService;
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.utils.JsonUtils;

/**
 * 云仓JITX订单服务
 */
public class WopJitxOrderPopService {

    private static final String SERVICE_NAME = "com.vip.wop.app.jit.service.WopJitxOrderPopService";
    private final BaseService baseService;

    /**
     * 构造函数
     */
    public WopJitxOrderPopService() {
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
     * 云仓JITX订单查询接口
     * 对应方法: queryJitxOrder(STRUCT request, INTEGER pageNum, INTEGER pageSize)
     * @param request 查询条件 (必填)
     * @param pageNum 页码，默认为1 (选填)
     * @param pageSize 页大小，默认为10，最大50 (选填)
     * @return com.vip.wop.app.jit.service.JitxOrderQueryResponse
     * @throws Exception 请求异常
     */
    public com.vip.wop.app.jit.service.JitxOrderQueryResponse queryJitxOrder(com.vip.wop.app.jit.service.JitxOrderQueryRequest request, Integer pageNum, Integer pageSize) throws Exception {
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

        String result = baseService.doRequest(SERVICE_NAME, "queryJitxOrder", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, JitxOrderQueryResponse.class);
    }

    /**
     * 云仓JITX订单明细查询接口
     * 对应方法: queryJitxOrderDetail(STRING crmCustCode, STRING platformOrderSn)
     * @param crmCustCode 供应商编码 (必填)
     * @param platformOrderSn 唯品订单号 (必填)
     * @return com.vip.wop.app.jit.service.JitxOrderDetailQueryResponse
     * @throws Exception 请求异常
     */
    public com.vip.wop.app.jit.service.JitxOrderDetailQueryResponse queryJitxOrderDetail(String crmCustCode, String platformOrderSn) throws Exception {
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
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "queryJitxOrderDetail", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, JitxOrderDetailQueryResponse.class);
    }

}
