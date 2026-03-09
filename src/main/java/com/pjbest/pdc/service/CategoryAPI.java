package com.pjbest.pdc.service;

import java.util.List;

import com.vip.pop.BaseService;
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.utils.JsonUtils;

/**
 * WOP类目API
 */
public class CategoryAPI {

    private static final String SERVICE_NAME = "com.pjbest.pdc.service.CategoryAPI";
    private final BaseService baseService;

    /**
     * 构造函数
     */
    public CategoryAPI() {
        this.baseService = PopServiceFactory.getBaseService();
    }

    /**
     * 根据品类编码和名称校验品类信息接口
     * 对应方法: checkCategoryByCodeAndName(STRING categoryCode, STRING categoryName)
     * @param categoryCode 品类编码 (必填)
     * @param categoryName 品类名称 (必填)
     * @return Boolean
     * @throws Exception 请求异常
     */
    public Boolean checkCategoryByCodeAndName(String categoryCode, String categoryName) throws Exception {
        if (categoryCode == null || categoryCode.trim().isEmpty()) {
            throw new IllegalArgumentException("categoryCode不能为空");
        }
        if (categoryName == null || categoryName.trim().isEmpty()) {
            throw new IllegalArgumentException("categoryName不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"categoryCode\":\"").append(categoryCode).append("\"");
        params.append(",");
        params.append("\"categoryName\":\"").append(categoryName).append("\"");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "checkCategoryByCodeAndName", params.toString());

        // 返回基本类型结果
        return JsonUtils.toObj(result, Boolean.class);
    }

    /**
     * 获取类目节点信息接口
     * 对应方法: getCategory(INTEGER categoryId)
     * @param categoryId 分类ID (必填)
     * @return com.pjbest.pdc.service.Category
     * @throws Exception 请求异常
     */
    public com.pjbest.pdc.service.Category getCategory(Integer categoryId) throws Exception {
        if (categoryId == null) {
            throw new IllegalArgumentException("categoryId不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"categoryId\":").append(categoryId);
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "getCategory", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, Category.class);
    }

    /**
     * 批量获取分类ID和属性IDS特有属性信息
     * 对应方法: getCategorySpecialAttributeList(LIST categorySpecialParams)
     * @param categorySpecialParams 分类特有属性参数集合 (必填)
     * @return java.util.List<com.pjbest.pdc.service.CategorySpecialAttributes>
     * @throws Exception 请求异常
     */
    public java.util.List<com.pjbest.pdc.service.CategorySpecialAttributes> getCategorySpecialAttributeList(java.util.List<com.pjbest.pdc.service.CategorySpecialParam> categorySpecialParams) throws Exception {
        if (categorySpecialParams == null || categorySpecialParams.isEmpty()) {
            throw new IllegalArgumentException("categorySpecialParams不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"categorySpecialParams\":[");
        for (int i = 0; i < categorySpecialParams.size(); i++) {
            if (i > 0) params.append(",");
            params.append(JsonUtils.toStr(categorySpecialParams.get(i)));
        }
        params.append("]");
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "getCategorySpecialAttributeList", params.toString());

        // 将API响应结果转换为List对象
        return JsonUtils.toList(result, CategorySpecialAttributes.class);
    }

    /**
     * 根据分类ID和属性ID获取特有属性信息
     * 对应方法: getCategorySpecialAttributes(INTEGER categoryId, INTEGER attributeId)
     * @param categoryId 分类ID (必填)
     * @param attributeId 分类属性ID, 当attributeId=0时返回分类对应所有的特有属性信息 (选填)
     * @return java.util.List<com.pjbest.pdc.service.AttributeWithValue>
     * @throws Exception 请求异常
     */
    public java.util.List<com.pjbest.pdc.service.AttributeWithValue> getCategorySpecialAttributes(Integer categoryId, Integer attributeId) throws Exception {
        if (categoryId == null) {
            throw new IllegalArgumentException("categoryId不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"categoryId\":").append(categoryId);
        if (attributeId != null) {
            params.append(",");
            params.append("\"attributeId\":").append(attributeId);
        }
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "getCategorySpecialAttributes", params.toString());

        // 将API响应结果转换为List对象
        return JsonUtils.toList(result, AttributeWithValue.class);
    }

    /**
     * 获取给定时间戳以后变更的发布导航分类节点信息接口
     * 对应方法: getUpdatedPublishCategories(LONG sinceUpdateTime, INTEGER hierarchyId, INTEGER pageNum, INTEGER pageSize)
     * @param sinceUpdateTime 时间戳 (必填)
     * @param hierarchyId 导航ID (必填)
     * @param pageNum 当前页码 (选填)
     * @param pageSize 一页多少条,不能大于1000 (必填)
     * @return com.pjbest.pdc.service.CategoryUpdates
     * @throws Exception 请求异常
     */
    public com.pjbest.pdc.service.CategoryUpdates getUpdatedPublishCategories(Long sinceUpdateTime, Integer hierarchyId, Integer pageNum, Integer pageSize) throws Exception {
        if (sinceUpdateTime == null) {
            throw new IllegalArgumentException("sinceUpdateTime不能为空");
        }
        if (hierarchyId == null) {
            throw new IllegalArgumentException("hierarchyId不能为空");
        }
        if (pageSize == null) {
            throw new IllegalArgumentException("pageSize不能为空");
        }

        // 构建参数JSON对象
        StringBuilder params = new StringBuilder();
        params.append("{");
        params.append("\"sinceUpdateTime\":").append(sinceUpdateTime);
        params.append(",");
        params.append("\"hierarchyId\":").append(hierarchyId);
        if (pageNum != null) {
            params.append(",");
            params.append("\"pageNum\":").append(pageNum);
        }
        params.append(",");
        params.append("\"pageSize\":").append(pageSize);
        params.append("}");

        String result = baseService.doRequest(SERVICE_NAME, "getUpdatedPublishCategories", params.toString());

        // 将API响应结果转换为对应的对象
        return JsonUtils.toObj(result, CategoryUpdates.class);
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

}
