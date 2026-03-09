package com.pjbest.wop.wm.service;

import java.util.List;

import com.vip.pop.BaseService;
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.utils.JsonUtils;

/**
 * WOP订单事件服务
 */
public class WopOrderEventService {

    private static final String SERVICE_NAME = "com.pjbest.wop.wm.service.WopOrderEventService";
    private final BaseService baseService;

    /**
     * 构造函数
     */
    public WopOrderEventService() {
        this.baseService = PopServiceFactory.getBaseService();
    }

    /**
     * 
     * 对应方法: createSelective(STRUCT wopOrderEventModel)
     * @param wopOrderEventModel null (选填)
     * @return Integer
     * @throws Exception 请求异常
     */
    public Integer createSelective(com.pjbest.wop.wm.service.WopOrderEventModel wopOrderEventModel) throws Exception {

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        if (wopOrderEventModel != null) {
            params.append("\"wopOrderEventModel\":").append(JsonUtils.toStr(wopOrderEventModel));
        }
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "createSelective", params.toString());

        // 返回基本类型结果
        return JsonUtils.toObj(result, Integer.class);
    }

    /**
     * 通过rowMd5查询记录（内部方法）
     * 对应方法: findByRowMd5(STRING rowMd5)
     * @param rowMd5 null (必填)
     * @return com.pjbest.wop.wm.service.WopOrderEventModel
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.WopOrderEventModel findByRowMd5(String rowMd5) throws Exception {
        if (rowMd5 == null || rowMd5.trim().isEmpty()) {
            throw new IllegalArgumentException("rowMd5不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"rowMd5\":\"").append(rowMd5).append("\"");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "findByRowMd5", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, WopOrderEventModel.class);
    }

    /**
     * 完成事件处理
     * 对应方法: finishEvent(STRUCT req)
     * @param req null (必填)
     * @return com.pjbest.wop.wm.service.FinishEventRespone
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.FinishEventRespone finishEvent(com.pjbest.wop.wm.service.FinishEventRequest req) throws Exception {
        if (req == null) {
            throw new IllegalArgumentException("req不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"req\":").append(JsonUtils.toStr(req));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "finishEvent", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, FinishEventRespone.class);
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
     * 累加事件处理次数（用于曾经处理过但失败需重试，累加处理次数，不更新处理状态）
     * 对应方法: markTryEvent(STRUCT req)
     * @param req null (必填)
     * @return com.pjbest.wop.wm.service.MarkTryEventRespone
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.MarkTryEventRespone markTryEvent(com.pjbest.wop.wm.service.MarkTryEventRequest req) throws Exception {
        if (req == null) {
            throw new IllegalArgumentException("req不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"req\":").append(JsonUtils.toStr(req));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "markTryEvent", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, MarkTryEventRespone.class);
    }

    /**
     * 查询待处理订单事件列表
     * 对应方法: queryNeedHandleEvents(STRUCT req)
     * @param req null (必填)
     * @return com.pjbest.wop.wm.service.QueryNeedHandleEventsRespone
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.QueryNeedHandleEventsRespone queryNeedHandleEvents(com.pjbest.wop.wm.service.QueryNeedHandleEventsRequest req) throws Exception {
        if (req == null) {
            throw new IllegalArgumentException("req不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"req\":").append(JsonUtils.toStr(req));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "queryNeedHandleEvents", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, QueryNeedHandleEventsRespone.class);
    }

    /**
     * 查询在库序列号（追踪ID）
     * 对应方法: queryTrackingIds(STRUCT req)
     * @param req null (必填)
     * @return com.pjbest.wop.wm.service.QueryTrackingIdsRespone
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.QueryTrackingIdsRespone queryTrackingIds(com.pjbest.wop.wm.service.QueryTrackingIdsRequest req) throws Exception {
        if (req == null) {
            throw new IllegalArgumentException("req不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"req\":").append(JsonUtils.toStr(req));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "queryTrackingIds", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, QueryTrackingIdsRespone.class);
    }

    /**
     * 重置订单事件为未处理
     * 对应方法: resetEvent(STRUCT req)
     * @param req null (必填)
     * @return com.pjbest.wop.wm.service.ResetEventRespone
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.ResetEventRespone resetEvent(com.pjbest.wop.wm.service.ResetEventRequest req) throws Exception {
        if (req == null) {
            throw new IllegalArgumentException("req不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"req\":").append(JsonUtils.toStr(req));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "resetEvent", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, ResetEventRespone.class);
    }

}
