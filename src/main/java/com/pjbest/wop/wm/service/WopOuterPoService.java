package com.pjbest.wop.wm.service;

import java.util.List;

import com.vip.pop.BaseService;
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.utils.JsonUtils;

/**
 * WOP入库单PO服务
 */
public class WopOuterPoService {

    private static final String SERVICE_NAME = "com.pjbest.wop.wm.service.WopOuterPoService";
    private final BaseService baseService;

    /**
     * 构造函数
     */
    public WopOuterPoService() {
        this.baseService = PopServiceFactory.getBaseService();
    }

    /**
     * 取消PO单接口
     * 对应方法: cancelPo(STRING customerCode, STRING poNo, STRING systemSource)
     * @param customerCode 客户编码 (必填)
     * @param poNo PO编号 (必填)
     * @param systemSource 来源系统 (选填)
     * @return com.pjbest.wop.wm.service.OperationResult
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.OperationResult cancelPo(String customerCode, String poNo, String systemSource) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (poNo == null || poNo.trim().isEmpty()) {
            throw new IllegalArgumentException("poNo不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"poNo\":\"").append(poNo).append("\"");
        if (systemSource != null && !systemSource.trim().isEmpty()) {
            params.append(",");
            params.append("\"systemSource\":\"").append(systemSource).append("\"");
        }
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "cancelPo", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, OperationResult.class);
    }

    /**
     * 清空PO单明细接口
     * 对应方法: cleanPoDetail(STRING customerCode, STRING poNo)
     * @param customerCode 客户编码 (必填)
     * @param poNo PO编号 (必填)
     * @return com.pjbest.wop.wm.service.OperationResult
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.OperationResult cleanPoDetail(String customerCode, String poNo) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (poNo == null || poNo.trim().isEmpty()) {
            throw new IllegalArgumentException("poNo不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"poNo\":\"").append(poNo).append("\"");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "cleanPoDetail", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, OperationResult.class);
    }

    /**
     * 关闭PO单接口
     * 对应方法: closePo(STRUCT closePoReq)
     * @param closePoReq 关闭PO单请求参数 (必填)
     * @return com.pjbest.wop.wm.service.ClosePoRespone
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.ClosePoRespone closePo(com.pjbest.wop.wm.service.ClosePoRequest closePoReq) throws Exception {
        if (closePoReq == null) {
            throw new IllegalArgumentException("closePoReq不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"closePoReq\":").append(JsonUtils.toStr(closePoReq));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "closePo", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, ClosePoRespone.class);
    }

    /**
     * 创建PO单表头接口
     * 对应方法: createPo(STRING customerCode, STRUCT poInfo, STRING systemSource)
     * @param customerCode 客户编码 (必填)
     * @param poInfo PO信息 (必填)
     * @param systemSource 来源系统 (选填)
     * @return com.pjbest.wop.wm.service.CreatePoResult
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.CreatePoResult createPo(String customerCode, com.pjbest.wop.wm.service.CreatePoInfo poInfo, String systemSource) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (poInfo == null) {
            throw new IllegalArgumentException("poInfo不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"poInfo\":").append(JsonUtils.toStr(poInfo));
        if (systemSource != null && !systemSource.trim().isEmpty()) {
            params.append(",");
            params.append("\"systemSource\":\"").append(systemSource).append("\"");
        }
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "createPo", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, CreatePoResult.class);
    }

    /**
     * 创建PO单并自动提交接口
     * 对应方法: createPoWithDetail(STRING customerCode, STRUCT poInfo, LIST impPoDetailList)
     * @param customerCode 客户编码 (必填)
     * @param poInfo PO信息 (必填)
     * @param impPoDetailList PO明细信息 (必填)
     * @return com.pjbest.wop.wm.service.CreatePoResult
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.CreatePoResult createPoWithDetail(String customerCode, com.pjbest.wop.wm.service.CreatePoInfo poInfo, java.util.List<com.pjbest.wop.wm.service.ImpPoDetail> impPoDetailList) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (poInfo == null) {
            throw new IllegalArgumentException("poInfo不能为空");
        }
        if (impPoDetailList == null || impPoDetailList.isEmpty()) {
            throw new IllegalArgumentException("impPoDetailList不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"poInfo\":").append(JsonUtils.toStr(poInfo));
        params.append(",");
        params.append("\"impPoDetailList\":[");
        for (int i = 0; i < impPoDetailList.size(); i++) {
            if (i > 0) params.append(",");
            params.append(JsonUtils.toStr(impPoDetailList.get(i)));
        }
        params.append("]");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "createPoWithDetail", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, CreatePoResult.class);
    }

    /**
     * 修改PO单表头接口
     * 对应方法: editPo(STRING customerCode, STRING poNo, STRUCT poInfo)
     * @param customerCode 客户编码 (必填)
     * @param poNo PO编号 (必填)
     * @param poInfo PO信息 (必填)
     * @return com.pjbest.wop.wm.service.OperationResult
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.OperationResult editPo(String customerCode, String poNo, com.pjbest.wop.wm.service.CreatePoInfo poInfo) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (poNo == null || poNo.trim().isEmpty()) {
            throw new IllegalArgumentException("poNo不能为空");
        }
        if (poInfo == null) {
            throw new IllegalArgumentException("poInfo不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"poNo\":\"").append(poNo).append("\"");
        params.append(",");
        params.append("\"poInfo\":").append(JsonUtils.toStr(poInfo));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "editPo", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, OperationResult.class);
    }

    /**
     * 获取PO单收货明细接口
     * 对应方法: getDeliveryResult(STRING customerCode, STRING poNo, INTEGER pageNum, INTEGER pageSize)
     * @param customerCode 客户编码 (必填)
     * @param poNo PO编号 (必填)
     * @param pageNum 页码 (必填)
     * @param pageSize 页面大小 (必填)
     * @return com.pjbest.wop.wm.service.SearchDeliveryResult
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.SearchDeliveryResult getDeliveryResult(String customerCode, String poNo, Integer pageNum, Integer pageSize) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (poNo == null || poNo.trim().isEmpty()) {
            throw new IllegalArgumentException("poNo不能为空");
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
        params.append("\"poNo\":\"").append(poNo).append("\"");
        params.append(",");
        params.append("\"pageNum\":").append(pageNum);
        params.append(",");
        params.append("\"pageSize\":").append(pageSize);
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "getDeliveryResult", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, SearchDeliveryResult.class);
    }

    /**
     * PO单明细查询接口
     * 对应方法: getPoDetailList(STRING customerCode, STRING poNo, INTEGER pageNum, INTEGER pageSize, LIST poNoList)
     * @param customerCode 客户编码 (必填)
     * @param poNo PO编号 (选填)
     * @param pageNum 页码 (必填)
     * @param pageSize 页面大小 (必填)
     * @param poNoList PO单集合 (选填)
     * @return com.pjbest.wop.wm.service.SearchPoDetailResult
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.SearchPoDetailResult getPoDetailList(String customerCode, String poNo, Integer pageNum, Integer pageSize, java.util.List<String> poNoList) throws Exception {
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
        if (poNo != null && !poNo.trim().isEmpty()) {
            params.append(",");
            params.append("\"poNo\":\"").append(poNo).append("\"");
        }
        params.append(",");
        params.append("\"pageNum\":").append(pageNum);
        params.append(",");
        params.append("\"pageSize\":").append(pageSize);
        if (poNoList != null && !poNoList.isEmpty()) {
            params.append(",");
            params.append("\"poNoList\":[");
            for (int i = 0; i < poNoList.size(); i++) {
                if (i > 0) params.append(",");
                params.append("\"").append(poNoList.get(i)).append("\"");
            }
            params.append("]");
        }
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "getPoDetailList", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, SearchPoDetailResult.class);
    }

    /**
     * 通过客记PO获取系统PO号接口
     * 对应方法: getPoNoByClientPoNo(STRING customerCode, STRING clientPoNo)
     * @param customerCode 客户编码 (必填)
     * @param clientPoNo PO编号 (必填)
     * @return String
     * @throws Exception 请求异常
     */
    public String getPoNoByClientPoNo(String customerCode, String clientPoNo) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (clientPoNo == null || clientPoNo.trim().isEmpty()) {
            throw new IllegalArgumentException("clientPoNo不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"clientPoNo\":\"").append(clientPoNo).append("\"");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "getPoNoByClientPoNo", params.toString());

        // 返回基本类型结果
        return JsonUtils.toObj(result, String.class);
    }

    /**
     * 入库结果查询接口
     * 对应方法: getReceiptResult(STRING customerCode, STRING systemSource, STRING poNo, INTEGER pageNum, INTEGER pageSize, LIST transactionIdList)
     * @param customerCode 客户编码 (必填)
     * @param systemSource 来源系统 (必填)
     * @param poNo PO编号 (必填)
     * @param pageNum 页码 (必填)
     * @param pageSize 页面大小 (必填)
     * @param transactionIdList 接口主表ID列表 (选填)
     * @return com.pjbest.wop.wm.service.SearchReceiptResult
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.SearchReceiptResult getReceiptResult(String customerCode, String systemSource, String poNo, Integer pageNum, Integer pageSize, java.util.List<String> transactionIdList) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (systemSource == null || systemSource.trim().isEmpty()) {
            throw new IllegalArgumentException("systemSource不能为空");
        }
        if (poNo == null || poNo.trim().isEmpty()) {
            throw new IllegalArgumentException("poNo不能为空");
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
        params.append("\"systemSource\":\"").append(systemSource).append("\"");
        params.append(",");
        params.append("\"poNo\":\"").append(poNo).append("\"");
        params.append(",");
        params.append("\"pageNum\":").append(pageNum);
        params.append(",");
        params.append("\"pageSize\":").append(pageSize);
        if (transactionIdList != null && !transactionIdList.isEmpty()) {
            params.append(",");
            params.append("\"transactionIdList\":[");
            for (int i = 0; i < transactionIdList.size(); i++) {
                if (i > 0) params.append(",");
                params.append("\"").append(transactionIdList.get(i)).append("\"");
            }
            params.append("]");
        }
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "getReceiptResult", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, SearchReceiptResult.class);
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
     * 导入PO单明细接口
     * 对应方法: importPoDetail(STRING customerCode, STRING poNo, LIST impPoDetailList, STRING systemSource)
     * @param customerCode 客户编码 (必填)
     * @param poNo PO编号 (必填)
     * @param impPoDetailList PO明细信息 (必填)
     * @param systemSource 来源系统 (选填)
     * @return com.pjbest.wop.wm.service.OperationResult
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.OperationResult importPoDetail(String customerCode, String poNo, java.util.List<com.pjbest.wop.wm.service.ImpPoDetail> impPoDetailList, String systemSource) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (poNo == null || poNo.trim().isEmpty()) {
            throw new IllegalArgumentException("poNo不能为空");
        }
        if (impPoDetailList == null || impPoDetailList.isEmpty()) {
            throw new IllegalArgumentException("impPoDetailList不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"poNo\":\"").append(poNo).append("\"");
        params.append(",");
        params.append("\"impPoDetailList\":[");
        for (int i = 0; i < impPoDetailList.size(); i++) {
            if (i > 0) params.append(",");
            params.append(JsonUtils.toStr(impPoDetailList.get(i)));
        }
        params.append("]");
        if (systemSource != null && !systemSource.trim().isEmpty()) {
            params.append(",");
            params.append("\"systemSource\":\"").append(systemSource).append("\"");
        }
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "importPoDetail", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, OperationResult.class);
    }

    /**
     * PO查询接口
     * 对应方法: queryPo(STRING customerCode, STRING poNos)
     * @param customerCode 客户编码 (必填)
     * @param poNos PO编号(多个中间以英文逗号分隔，限定100个 ) (必填)
     * @return java.util.List<com.pjbest.wop.wm.service.QueryPoResult>
     * @throws Exception 请求异常
     */
    public java.util.List<com.pjbest.wop.wm.service.QueryPoResult> queryPo(String customerCode, String poNos) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (poNos == null || poNos.trim().isEmpty()) {
            throw new IllegalArgumentException("poNos不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"poNos\":\"").append(poNos).append("\"");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "queryPo", params.toString());

        // 将API响应结果转换为List对象
        return JsonUtils.toList(result, QueryPoResult.class);
    }

    /**
     * 根据系统PO查PO单接口
     * 对应方法: queryPoBySystemPoNo(STRUCT req)
     * @param req null (必填)
     * @return com.pjbest.wop.wm.service.QueryPoBySystemPoNoRespone
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.QueryPoBySystemPoNoRespone queryPoBySystemPoNo(com.pjbest.wop.wm.service.QueryPoBySystemPoNoRequest req) throws Exception {
        if (req == null) {
            throw new IllegalArgumentException("req不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"req\":").append(JsonUtils.toStr(req));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "queryPoBySystemPoNo", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, QueryPoBySystemPoNoRespone.class);
    }

    /**
     * PO单查询接口
     * 对应方法: searchPoList(STRING customerCode, STRUCT con, INTEGER pageNum, INTEGER pageSize, STRING systemSource)
     * @param customerCode 客户编码 (必填)
     * @param con 查询条件 (必填)
     * @param pageNum 页码 (必填)
     * @param pageSize 页面大小 (必填)
     * @param systemSource 来源系统 (选填)
     * @return com.pjbest.wop.wm.service.SearchPoResult
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.SearchPoResult searchPoList(String customerCode, com.pjbest.wop.wm.service.PoQueryCondition con, Integer pageNum, Integer pageSize, String systemSource) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (con == null) {
            throw new IllegalArgumentException("con不能为空");
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
        params.append("\"con\":").append(JsonUtils.toStr(con));
        params.append(",");
        params.append("\"pageNum\":").append(pageNum);
        params.append(",");
        params.append("\"pageSize\":").append(pageSize);
        if (systemSource != null && !systemSource.trim().isEmpty()) {
            params.append(",");
            params.append("\"systemSource\":\"").append(systemSource).append("\"");
        }
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "searchPoList", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, SearchPoResult.class);
    }

    /**
     * 提交PO单接口
     * 对应方法: submitPo(STRING customerCode, STRING poNo, STRING systemSource)
     * @param customerCode 客户编码 (必填)
     * @param poNo PO编号 (必填)
     * @param systemSource 来源系统 (选填)
     * @return com.pjbest.wop.wm.service.OperationResult
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.OperationResult submitPo(String customerCode, String poNo, String systemSource) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (poNo == null || poNo.trim().isEmpty()) {
            throw new IllegalArgumentException("poNo不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"poNo\":\"").append(poNo).append("\"");
        if (systemSource != null && !systemSource.trim().isEmpty()) {
            params.append(",");
            params.append("\"systemSource\":\"").append(systemSource).append("\"");
        }
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "submitPo", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, OperationResult.class);
    }

}
