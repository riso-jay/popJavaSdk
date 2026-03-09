package com.pjbest.wop.wm.service;

import java.util.List;

import com.vip.pop.BaseService;
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.utils.JsonUtils;

/**
 * WOP大订单服务
 */
public class WopBigOrderService {

    private static final String SERVICE_NAME = "com.pjbest.wop.wm.service.WopBigOrderService";
    private final BaseService baseService;

    /**
     * 构造函数
     */
    public WopBigOrderService() {
        this.baseService = PopServiceFactory.getBaseService();
    }

    /**
     * 取消大订单接口
     * 对应方法: cancel(STRUCT cancelReq)
     * @param cancelReq 取消大订单请求 (必填)
     * @return com.pjbest.wop.wm.service.CancelBigOrderRespone
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.CancelBigOrderRespone cancel(com.pjbest.wop.wm.service.CancelBigOrderRequest cancelReq) throws Exception {
        if (cancelReq == null) {
            throw new IllegalArgumentException("cancelReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"cancelReq\":").append(JsonUtils.toStr(cancelReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "cancel", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, CancelBigOrderRespone.class);
    }

    /**
     * 清空大订单明细接口
     * 对应方法: cleanDetails(STRUCT cleanDetailsReq)
     * @param cleanDetailsReq 清空大订单明细请求 (必填)
     * @return com.pjbest.wop.wm.service.CleanBigOrderDetailsRespone
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.CleanBigOrderDetailsRespone cleanDetails(com.pjbest.wop.wm.service.CleanBigOrderDetailsRequest cleanDetailsReq) throws Exception {
        if (cleanDetailsReq == null) {
            throw new IllegalArgumentException("cleanDetailsReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"cleanDetailsReq\":").append(JsonUtils.toStr(cleanDetailsReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "cleanDetails", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, CleanBigOrderDetailsRespone.class);
    }

    /**
     * 创建大订单单头接口
     * 对应方法: createHeader(STRUCT createHeaderReq)
     * @param createHeaderReq 创建大订单单头请求 (必填)
     * @return com.pjbest.wop.wm.service.CreateBigOrderHeaderRespone
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.CreateBigOrderHeaderRespone createHeader(com.pjbest.wop.wm.service.CreateBigOrderHeaderRequest createHeaderReq) throws Exception {
        if (createHeaderReq == null) {
            throw new IllegalArgumentException("createHeaderReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"createHeaderReq\":").append(JsonUtils.toStr(createHeaderReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "createHeader", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, CreateBigOrderHeaderRespone.class);
    }

    /**
     * 获取大订单物流轨迹接口
     * 对应方法: getDeliveryTrace(STRUCT getDeliveryTraceReq)
     * @param getDeliveryTraceReq 获取大订单物流轨迹请求 (必填)
     * @return com.pjbest.wop.wm.service.GetBigOrderDeliveryTraceRespone
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.GetBigOrderDeliveryTraceRespone getDeliveryTrace(com.pjbest.wop.wm.service.GetBigOrderDeliveryTraceRequest getDeliveryTraceReq) throws Exception {
        if (getDeliveryTraceReq == null) {
            throw new IllegalArgumentException("getDeliveryTraceReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"getDeliveryTraceReq\":").append(JsonUtils.toStr(getDeliveryTraceReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "getDeliveryTrace", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, GetBigOrderDeliveryTraceRespone.class);
    }

    /**
     * 获取大订单明细接口
     * 对应方法: getDetailList(STRUCT getDetailListReq)
     * @param getDetailListReq 获取大订单明细请求 (必填)
     * @return com.pjbest.wop.wm.service.GetBigOrderDetailListRespone
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.GetBigOrderDetailListRespone getDetailList(com.pjbest.wop.wm.service.GetBigOrderDetailListRequest getDetailListReq) throws Exception {
        if (getDetailListReq == null) {
            throw new IllegalArgumentException("getDetailListReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"getDetailListReq\":").append(JsonUtils.toStr(getDetailListReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "getDetailList", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, GetBigOrderDetailListRespone.class);
    }

    /**
     * 获取订单头接口
     * 对应方法: getHeader(STRUCT getHeaderReq)
     * @param getHeaderReq 获取订单头请求 (必填)
     * @return com.pjbest.wop.wm.service.GetBigOrderHeaderRespone
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.GetBigOrderHeaderRespone getHeader(com.pjbest.wop.wm.service.GetBigOrderHeaderRequest getHeaderReq) throws Exception {
        if (getHeaderReq == null) {
            throw new IllegalArgumentException("getHeaderReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"getHeaderReq\":").append(JsonUtils.toStr(getHeaderReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "getHeader", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, GetBigOrderHeaderRespone.class);
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
     * 导入大订单明细接口（支持多批次导入）
     * 对应方法: importDetails(STRUCT importDetailsReq)
     * @param importDetailsReq 导入大订单明细请求 (必填)
     * @return com.pjbest.wop.wm.service.ImportBigOrderDetailsRespone
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.ImportBigOrderDetailsRespone importDetails(com.pjbest.wop.wm.service.ImportBigOrderDetailsRequest importDetailsReq) throws Exception {
        if (importDetailsReq == null) {
            throw new IllegalArgumentException("importDetailsReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"importDetailsReq\":").append(JsonUtils.toStr(importDetailsReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "importDetails", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, ImportBigOrderDetailsRespone.class);
    }

    /**
     * 提交大订单接口
     * 对应方法: submit(STRUCT submitReq)
     * @param submitReq 提交大订单请求 (必填)
     * @return com.pjbest.wop.wm.service.SubmitBigOrderRespone
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.SubmitBigOrderRespone submit(com.pjbest.wop.wm.service.BigOrderSubmitRequest submitReq) throws Exception {
        if (submitReq == null) {
            throw new IllegalArgumentException("submitReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"submitReq\":").append(JsonUtils.toStr(submitReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "submit", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, SubmitBigOrderRespone.class);
    }

}
