package com.pjbest.pdc.service;

import java.util.List;

import com.vip.pop.BaseService;
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.utils.JsonUtils;

/**
 * WOP品牌同步API
 */
public class PdcBrandService {

    private static final String SERVICE_NAME = "com.pjbest.pdc.service.PdcBrandService";
    private final BaseService baseService;

    /**
     * 构造函数
     */
    public PdcBrandService() {
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
     * 品牌同步接口
     * 对应方法: syncPdcBrand(STRING crmCustCode, STRUCT syncBrand)
     * @param crmCustCode 货主编码 (必填)
     * @param syncBrand 商品信息 (必填)
     * @return com.pjbest.pdc.service.BrandSyncRespone
     * @throws Exception 请求异常
     */
    public com.pjbest.pdc.service.BrandSyncRespone syncPdcBrand(String crmCustCode, com.pjbest.pdc.service.BrandSyncReq syncBrand) throws Exception {
        if (crmCustCode == null || crmCustCode.trim().isEmpty()) {
            throw new IllegalArgumentException("crmCustCode不能为空");
        }
        if (syncBrand == null) {
            throw new IllegalArgumentException("syncBrand不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"crmCustCode\":\"").append(crmCustCode).append("\"");
        params.append(",");
        params.append("\"syncBrand\":").append(JsonUtils.toStr(syncBrand));
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "syncPdcBrand", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, BrandSyncRespone.class);
    }

}
