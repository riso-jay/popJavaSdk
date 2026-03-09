package com.pjbest.wop.wm.service;

import java.util.List;

import com.vip.pop.BaseService;
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.utils.JsonUtils;

/**
 * WOP海淘订单服务
 */
public class WopOutterHtOrderService {

    private static final String SERVICE_NAME = "com.pjbest.wop.wm.service.WopOutterHtOrderService";
    private final BaseService baseService;

    /**
     * 构造函数
     */
    public WopOutterHtOrderService() {
        this.baseService = PopServiceFactory.getBaseService();
    }

    /**
     * 取消海淘订单
     * 对应方法: cancel(STRUCT cancelReq)
     * @param cancelReq 取消海淘订单请求 (必填)
     * @return com.pjbest.wop.wm.service.CancelHtOrderRsp
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.CancelHtOrderRsp cancel(com.pjbest.wop.wm.service.CancelHtOrderReq cancelReq) throws Exception {
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
        return JsonUtils.toObj(result, CancelHtOrderRsp.class);
    }

    /**
     * 创建海淘订单
     * 对应方法: createHtOrder(STRUCT createHtOrderReq)
     * @param createHtOrderReq 创建海淘订单请求 (必填)
     * @return com.pjbest.wop.wm.service.CreateHtOrderRsp
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.CreateHtOrderRsp createHtOrder(com.pjbest.wop.wm.service.CreateHtOrderReq createHtOrderReq) throws Exception {
        if (createHtOrderReq == null) {
            throw new IllegalArgumentException("createHtOrderReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"createHtOrderReq\":").append(JsonUtils.toStr(createHtOrderReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "createHtOrder", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, CreateHtOrderRsp.class);
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
     * 查询海淘订单
     * 对应方法: queryHtOrder(STRUCT queryReq)
     * @param queryReq 查询海淘订单头请求 (必填)
     * @return com.pjbest.wop.wm.service.QueryHtOrderRsp
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.QueryHtOrderRsp queryHtOrder(com.pjbest.wop.wm.service.QueryHtOrderReq queryReq) throws Exception {
        if (queryReq == null) {
            throw new IllegalArgumentException("queryReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"queryReq\":").append(JsonUtils.toStr(queryReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "queryHtOrder", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, QueryHtOrderRsp.class);
    }

    /**
     * 查询海淘订单状态
     * 对应方法: queryStatus(STRUCT queryStatusReq)
     * @param queryStatusReq 查询海淘订单状态请求 (必填)
     * @return com.pjbest.wop.wm.service.QueryStatusRsp
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.QueryStatusRsp queryStatus(com.pjbest.wop.wm.service.QueryStatusReq queryStatusReq) throws Exception {
        if (queryStatusReq == null) {
            throw new IllegalArgumentException("queryStatusReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"queryStatusReq\":").append(JsonUtils.toStr(queryStatusReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "queryStatus", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, QueryStatusRsp.class);
    }

    /**
     * 重推海淘订单
     * 对应方法: reSend(STRUCT reSendReq)
     * @param reSendReq 重推海淘订单请求 (必填)
     * @return com.pjbest.wop.wm.service.ReSendHtOrderRsp
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.ReSendHtOrderRsp reSend(com.pjbest.wop.wm.service.ReSendHtOrderReq reSendReq) throws Exception {
        if (reSendReq == null) {
            throw new IllegalArgumentException("reSendReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"reSendReq\":").append(JsonUtils.toStr(reSendReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "reSend", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, ReSendHtOrderRsp.class);
    }

}
