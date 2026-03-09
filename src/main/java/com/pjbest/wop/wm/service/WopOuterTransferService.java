package com.pjbest.wop.wm.service;

import java.util.List;

import com.vip.pop.BaseService;
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.utils.JsonUtils;

/**
 * WOP仓间调拨单服务
 */
public class WopOuterTransferService {

    private static final String SERVICE_NAME = "com.pjbest.wop.wm.service.WopOuterTransferService";
    private final BaseService baseService;

    /**
     * 构造函数
     */
    public WopOuterTransferService() {
        this.baseService = PopServiceFactory.getBaseService();
    }

    /**
     * 取消调拨单接口
     * 对应方法: cancelTransfer(STRING customerCode, STRING erpTransferSn, STRING remark, STRING actionTime, STRING userName)
     * @param customerCode 客户编码 (必填)
     * @param erpTransferSn ERP调拨单号 (必填)
     * @param remark 取消原因 (选填)
     * @param actionTime 操作时间 (必填)
     * @param userName 操作人 (必填)
     * @return com.pjbest.wop.wm.service.TransferOperationResult
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.TransferOperationResult cancelTransfer(String customerCode, String erpTransferSn, String remark, String actionTime, String userName) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (erpTransferSn == null || erpTransferSn.trim().isEmpty()) {
            throw new IllegalArgumentException("erpTransferSn不能为空");
        }
        if (actionTime == null || actionTime.trim().isEmpty()) {
            throw new IllegalArgumentException("actionTime不能为空");
        }
        if (userName == null || userName.trim().isEmpty()) {
            throw new IllegalArgumentException("userName不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"erpTransferSn\":\"").append(erpTransferSn).append("\"");
        if (remark != null && !remark.trim().isEmpty()) {
            params.append(",");
            params.append("\"remark\":\"").append(remark).append("\"");
        }
        params.append(",");
        params.append("\"actionTime\":\"").append(actionTime).append("\"");
        params.append(",");
        params.append("\"userName\":\"").append(userName).append("\"");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "cancelTransfer", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, TransferOperationResult.class);
    }

    /**
     * 清空调拨单明细接口
     * 对应方法: cleanTransferDetail(STRING customerCode, STRING erpTransferSn)
     * @param customerCode 客户编码 (必填)
     * @param erpTransferSn ERP调拨单号 (必填)
     * @return com.pjbest.wop.wm.service.TransferOperationResult
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.TransferOperationResult cleanTransferDetail(String customerCode, String erpTransferSn) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (erpTransferSn == null || erpTransferSn.trim().isEmpty()) {
            throw new IllegalArgumentException("erpTransferSn不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"erpTransferSn\":\"").append(erpTransferSn).append("\"");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "cleanTransferDetail", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, TransferOperationResult.class);
    }

    /**
     * 创建调拨单表头接口
     * 对应方法: createTransfer(STRING customerCode, STRUCT transferInfo)
     * @param customerCode 客户编码 (必填)
     * @param transferInfo 调拨单信息 (必填)
     * @return com.pjbest.wop.wm.service.CreateTransferRespone
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.CreateTransferRespone createTransfer(String customerCode, com.pjbest.wop.wm.service.CreateTransferInfo transferInfo) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (transferInfo == null) {
            throw new IllegalArgumentException("transferInfo不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"transferInfo\":").append(JsonUtils.toStr(transferInfo));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "createTransfer", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, CreateTransferRespone.class);
    }

    /**
     * 创建调拨单接口
     * 对应方法: createTransferOrder(STRING customerCode, STRUCT transferInfo, LIST transferDetailList)
     * @param customerCode 客户编码 (必填)
     * @param transferInfo 调拨单信息 (必填)
     * @param transferDetailList 调拨单明细信息 不能大于100 (必填)
     * @return com.pjbest.wop.wm.service.CreateTransferRespone
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.CreateTransferRespone createTransferOrder(String customerCode, com.pjbest.wop.wm.service.CreateTransferInfo transferInfo, java.util.List<com.pjbest.wop.wm.service.ImpTransferDetail> transferDetailList) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (transferInfo == null) {
            throw new IllegalArgumentException("transferInfo不能为空");
        }
        if (transferDetailList == null || transferDetailList.isEmpty()) {
            throw new IllegalArgumentException("transferDetailList不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"transferInfo\":").append(JsonUtils.toStr(transferInfo));
        params.append(",");
        params.append("\"transferDetailList\":[");
        for (int i = 0; i < transferDetailList.size(); i++) {
            if (i > 0) params.append(",");
            params.append(JsonUtils.toStr(transferDetailList.get(i)));
        }
        params.append("]");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "createTransferOrder", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, CreateTransferRespone.class);
    }

    /**
     * 修改调拨单表头接口
     * 对应方法: editTransfer(STRING customerCode, STRING erpTransferSn, STRUCT transferInfo)
     * @param customerCode 客户编码 (必填)
     * @param erpTransferSn ERP调拨单号 (必填)
     * @param transferInfo 拔单信息 (必填)
     * @return com.pjbest.wop.wm.service.TransferOperationResult
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.TransferOperationResult editTransfer(String customerCode, String erpTransferSn, com.pjbest.wop.wm.service.EditTransferInfo transferInfo) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (erpTransferSn == null || erpTransferSn.trim().isEmpty()) {
            throw new IllegalArgumentException("erpTransferSn不能为空");
        }
        if (transferInfo == null) {
            throw new IllegalArgumentException("transferInfo不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"erpTransferSn\":\"").append(erpTransferSn).append("\"");
        params.append(",");
        params.append("\"transferInfo\":").append(JsonUtils.toStr(transferInfo));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "editTransfer", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, TransferOperationResult.class);
    }

    /**
     * 调拨单明细查询接口
     * 对应方法: getTransferDetailList(STRING customerCode, STRING erpTransferSn, INTEGER pageNum, INTEGER pageSize)
     * @param customerCode 客户编码 (必填)
     * @param erpTransferSn ERP调拨单号 (必填)
     * @param pageNum 页码 (必填)
     * @param pageSize 每页的记录数 不能大于500 (必填)
     * @return com.pjbest.wop.wm.service.SearchTransferDetailResult
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.SearchTransferDetailResult getTransferDetailList(String customerCode, String erpTransferSn, Integer pageNum, Integer pageSize) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (erpTransferSn == null || erpTransferSn.trim().isEmpty()) {
            throw new IllegalArgumentException("erpTransferSn不能为空");
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
        params.append("\"erpTransferSn\":\"").append(erpTransferSn).append("\"");
        params.append(",");
        params.append("\"pageNum\":").append(pageNum);
        params.append(",");
        params.append("\"pageSize\":").append(pageSize);
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "getTransferDetailList", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, SearchTransferDetailResult.class);
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
     * 导入调拨单明细接口
     * 对应方法: importTransferDetail(STRING customerCode, STRING erpTransferSn, LIST transferDetailList)
     * @param customerCode 客户编码 (必填)
     * @param erpTransferSn ERP调拨单号 (必填)
     * @param transferDetailList 调拨单明细信息 不能大于100 (必填)
     * @return com.pjbest.wop.wm.service.TransferImportDetailResult
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.TransferImportDetailResult importTransferDetail(String customerCode, String erpTransferSn, java.util.List<com.pjbest.wop.wm.service.ImpTransferDetail> transferDetailList) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (erpTransferSn == null || erpTransferSn.trim().isEmpty()) {
            throw new IllegalArgumentException("erpTransferSn不能为空");
        }
        if (transferDetailList == null || transferDetailList.isEmpty()) {
            throw new IllegalArgumentException("transferDetailList不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"erpTransferSn\":\"").append(erpTransferSn).append("\"");
        params.append(",");
        params.append("\"transferDetailList\":[");
        for (int i = 0; i < transferDetailList.size(); i++) {
            if (i > 0) params.append(",");
            params.append(JsonUtils.toStr(transferDetailList.get(i)));
        }
        params.append("]");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "importTransferDetail", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, TransferImportDetailResult.class);
    }

    /**
     * 调拨单查询接口
     * 对应方法: searchTransferList(STRING customerCode, STRUCT con, INTEGER pageNum, INTEGER pageSize)
     * @param customerCode 客户编码 (必填)
     * @param con 查询条件 (必填)
     * @param pageNum 页码 (必填)
     * @param pageSize 每页的记录数 不能大于500 (必填)
     * @return com.pjbest.wop.wm.service.SearchTransferResult
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.SearchTransferResult searchTransferList(String customerCode, com.pjbest.wop.wm.service.TransferQueryCondition con, Integer pageNum, Integer pageSize) throws Exception {
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
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "searchTransferList", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, SearchTransferResult.class);
    }

    /**
     * 提交调拨单接口
     * 对应方法: submitTransfer(STRING customerCode, STRING erpTransferSn)
     * @param customerCode 客户编码 (必填)
     * @param erpTransferSn ERP调拨单号 (必填)
     * @return com.pjbest.wop.wm.service.TransferOperationResult
     * @throws Exception 请求异常
     */
    public com.pjbest.wop.wm.service.TransferOperationResult submitTransfer(String customerCode, String erpTransferSn) throws Exception {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            throw new IllegalArgumentException("customerCode不能为空");
        }
        if (erpTransferSn == null || erpTransferSn.trim().isEmpty()) {
            throw new IllegalArgumentException("erpTransferSn不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"customerCode\":\"").append(customerCode).append("\"");
        params.append(",");
        params.append("\"erpTransferSn\":\"").append(erpTransferSn).append("\"");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "submitTransfer", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, TransferOperationResult.class);
    }

}
