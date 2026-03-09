package com.pjbest.wop.wm.service;

import java.util.List;

import com.vip.pop.BaseService;
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.utils.JsonUtils;

/**
 * WOP退供单服务
 */
public class WopOuterInvReturnOrderService {

    private static final String SERVICE_NAME = "com.pjbest.wop.wm.service.WopOuterInvReturnOrderService";
    private final BaseService baseService;

    /**
     * 构造函数
     */
    public WopOuterInvReturnOrderService() {
        this.baseService = PopServiceFactory.getBaseService();
    }

    /**
     * 取消退供单接口
     * 对应方法: cancelInvReturnOrder(STRUCT cancelInvReq)
     * @param cancelInvReq 取消退供单请求 (必填)
     * @return com.pjbest.wop.wm.service.CancelInvReturnOrderRsp
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.CancelInvReturnOrderRsp cancelInvReturnOrder(com.pjbest.wop.wm.service.CancelInvReturnOrderReq cancelInvReq) throws Exception {
        if (cancelInvReq == null) {
            throw new IllegalArgumentException("cancelInvReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"cancelInvReq\":").append(JsonUtils.toStr(cancelInvReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "cancelInvReturnOrder", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, CancelInvReturnOrderRsp.class);
    }

    /**
     * 清空退供单明细接口
     * 对应方法: cleanInvReturnDetail(STRUCT cleanDetailReq)
     * @param cleanDetailReq 清空退供单明细请求 (必填)
     * @return com.pjbest.wop.wm.service.CleanInvReturnDetailRsp
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.CleanInvReturnDetailRsp cleanInvReturnDetail(com.pjbest.wop.wm.service.CleanInvReturnDetailReq cleanDetailReq) throws Exception {
        if (cleanDetailReq == null) {
            throw new IllegalArgumentException("cleanDetailReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"cleanDetailReq\":").append(JsonUtils.toStr(cleanDetailReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "cleanInvReturnDetail", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, CleanInvReturnDetailRsp.class);
    }

    /**
     * 创建退供单表头接口
     * 对应方法: createInvReturnOrder(STRUCT createReq)
     * @param createReq 创建退供单请求 (必填)
     * @return com.pjbest.wop.wm.service.CreateInvReturnOrderRsp
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.CreateInvReturnOrderRsp createInvReturnOrder(com.pjbest.wop.wm.service.CreateInvReturnOrderReq createReq) throws Exception {
        if (createReq == null) {
            throw new IllegalArgumentException("createReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"createReq\":").append(JsonUtils.toStr(createReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "createInvReturnOrder", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, CreateInvReturnOrderRsp.class);
    }

    /**
     * 修改退供单表头接口
     * 对应方法: editInvReturnOrder(STRUCT editReq)
     * @param editReq 修改退供单请求 (必填)
     * @return com.pjbest.wop.wm.service.EditInvReturnOrderRsp
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.EditInvReturnOrderRsp editInvReturnOrder(com.pjbest.wop.wm.service.EditInvReturnOrderReq editReq) throws Exception {
        if (editReq == null) {
            throw new IllegalArgumentException("editReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"editReq\":").append(JsonUtils.toStr(editReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "editInvReturnOrder", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, EditInvReturnOrderRsp.class);
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
     * 导入退供单明细接口
     * 对应方法: importInvReturnDetail(STRUCT importDetailReq)
     * @param importDetailReq 导入退供单明细请求 (必填)
     * @return com.pjbest.wop.wm.service.ImportInvReturnDetailRsp
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.ImportInvReturnDetailRsp importInvReturnDetail(com.pjbest.wop.wm.service.ImportInvReturnDetailReq importDetailReq) throws Exception {
        if (importDetailReq == null) {
            throw new IllegalArgumentException("importDetailReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"importDetailReq\":").append(JsonUtils.toStr(importDetailReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "importInvReturnDetail", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, ImportInvReturnDetailRsp.class);
    }

    /**
     * 查询退供单接口
     * 对应方法: queryInvReturnOrder(STRUCT queryReq)
     * @param queryReq 查询退供单请求 (必填)
     * @return com.pjbest.wop.wm.service.QueryInvReturnOrderRsp
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.QueryInvReturnOrderRsp queryInvReturnOrder(com.pjbest.wop.wm.service.QueryInvReturnOrderReq queryReq) throws Exception {
        if (queryReq == null) {
            throw new IllegalArgumentException("queryReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"queryReq\":").append(JsonUtils.toStr(queryReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "queryInvReturnOrder", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, QueryInvReturnOrderRsp.class);
    }

    /**
     * 退供单明细查询接口
     * 对应方法: queryInvReturnOrderDetail(STRUCT queryReq)
     * @param queryReq 退供单明细查询请求 (必填)
     * @return com.pjbest.wop.wm.service.QueryInvReturnOrderDetailRsp
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.QueryInvReturnOrderDetailRsp queryInvReturnOrderDetail(com.pjbest.wop.wm.service.QueryInvReturnOrderDetailReq queryReq) throws Exception {
        if (queryReq == null) {
            throw new IllegalArgumentException("queryReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"queryReq\":").append(JsonUtils.toStr(queryReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "queryInvReturnOrderDetail", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, QueryInvReturnOrderDetailRsp.class);
    }

    /**
     * 退供单分页查询接口
     * 对应方法: searchInvReturnOrderList(STRUCT searchReq)
     * @param searchReq 退供单查询请求 (必填)
     * @return com.pjbest.wop.wm.service.SearchInvReturnResult
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.SearchInvReturnResult searchInvReturnOrderList(com.pjbest.wop.wm.service.SearchInvReturnOrderReq searchReq) throws Exception {
        if (searchReq == null) {
            throw new IllegalArgumentException("searchReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"searchReq\":").append(JsonUtils.toStr(searchReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "searchInvReturnOrderList", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, SearchInvReturnResult.class);
    }

    /**
     * 提交退供单接口
     * 对应方法: submitInvReturnOrder(STRUCT submitReq)
     * @param submitReq 提交退供单请求 (必填)
     * @return com.pjbest.wop.wm.service.SubmitInvReturnOrderRsp
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.SubmitInvReturnOrderRsp submitInvReturnOrder(com.pjbest.wop.wm.service.SubmitInvReturnOrderReq submitReq) throws Exception {
        if (submitReq == null) {
            throw new IllegalArgumentException("submitReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"submitReq\":").append(JsonUtils.toStr(submitReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "submitInvReturnOrder", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, SubmitInvReturnOrderRsp.class);
    }

}
