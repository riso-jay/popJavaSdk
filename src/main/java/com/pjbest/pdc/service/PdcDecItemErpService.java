package com.pjbest.pdc.service;

import java.util.List;

import com.vip.pop.BaseService;
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.utils.JsonUtils;

/**
 * ERP 商品同步服务
 */
public class PdcDecItemErpService {

    private static final String SERVICE_NAME = "com.pjbest.pdc.service.PdcDecItemErpService";
    private final BaseService baseService;

    /**
     * 构造函数
     */
    public PdcDecItemErpService() {
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
     * 同步商品信息
     * 对应方法: syncPdcItem(STRING crmCustCode, STRUCT item)
     * @param crmCustCode 货主编码 (选填)
     * @param item 商品信息 (选填)
     * @return com.pjbest.pdc.service.ErpDecPdcItemResult
     * @throws Exception 请求异常
     */
    public com.pjbest.pdc.service.ErpDecPdcItemResult syncPdcItem(String crmCustCode, com.pjbest.pdc.service.ErpDecPdcItem item) throws Exception {

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        if (crmCustCode != null && !crmCustCode.trim().isEmpty()) {
            params.append("\"crmCustCode\":\"").append(crmCustCode).append("\"");
        }
        if (item != null) {
            params.append(",");
            params.append("\"item\":").append(JsonUtils.toStr(item));
        }
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "syncPdcItem", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, ErpDecPdcItemResult.class);
    }

}
