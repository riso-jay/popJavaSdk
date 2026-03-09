package com.vip.pop.test.json;

import com.pjbest.wop.wm.service.PoInfo;
import com.pjbest.wop.wm.service.SearchPoResult;
import com.vip.pop.utils.JsonUtils;
import org.testng.annotations.Test;


public class FastJsonTest {


    @Test
    public void jsonTest(){
        String jsonStr = "{\n" +
                "    \"poList\": [\n" +
                "        {\n" +
                "            \"totalVolume\": 0.0,\n" +
                "            \"zipCode\": \"510000\",\n" +
                "            \"receiverTel\": \"13450411397\",\n" +
                "            \"deliveryContacterMobile\": \"\",\n" +
                "            \"deliveryDistrictName\": \"\",\n" +
                "            \"totalQty\": 480,\n" +
                "            \"deliveryStateCode\": \"\",\n" +
                "            \"authContactor\": \"\",\n" +
                "            \"receiverDistrictCode\": \"104104101105\",\n" +
                "            \"channel\": 0,\n" +
                "            \"totalTagPrice\": 130.0,\n" +
                "            \"deliveryCityName\": \"\",\n" +
                "            \"type\": \"VIP_3PL_CW\",\n" +
                "            \"vendorCode\": \"17002437\",\n" +
                "            \"returnStateCode\": \"103103\",\n" +
                "            \"deliveryCityCode\": \"\",\n" +
                "            \"receiverCountry\": \"10\",\n" +
                "            \"poNo\": \"2602001205\",\n" +
                "            \"updatedDtmLoc\": 1770220821000,\n" +
                "            \"createdDtmLoc\": 1770220808000,\n" +
                "            \"returnDistrictName\": \"义乌市\",\n" +
                "            \"boxFlag\": 0,\n" +
                "            \"updatedByUser\": \"17002437\",\n" +
                "            \"returnNo\": \"\",\n" +
                "            \"deliveryDetailAddress\": \"\",\n" +
                "            \"receiver\": \"yc\",\n" +
                "            \"saleArea\": \"GZSC\",\n" +
                "            \"weight\": 0.0,\n" +
                "            \"returnStateName\": \"浙江省\",\n" +
                "            \"buyer\": \"\",\n" +
                "            \"volume\": 0.0,\n" +
                "            \"warehousingTime\": 0,\n" +
                "            \"flowRemark\": \"通过接口创建入库单\",\n" +
                "            \"receiverStateName\": \"广东省\",\n" +
                "            \"deliveryStoreName\": \"\",\n" +
                "            \"deliveryStateName\": \"\",\n" +
                "            \"reservationNo\": \"\",\n" +
                "            \"clientPoNo\": \"2026020400002\",\n" +
                "            \"status\": 1,\n" +
                "            \"transactionSource\": \"VSL_VC\",\n" +
                "            \"isBatchStorage\": 1,\n" +
                "            \"createdByUser\": \"SYSTEM\",\n" +
                "            \"startOnRacksTime\": \"\",\n" +
                "            \"receiverCityCode\": \"104104101\",\n" +
                "            \"remark\": \"\",\n" +
                "            \"authTime\": 1770220820000,\n" +
                "            \"authUser\": \"17002437\",\n" +
                "            \"warehouseName\": \"华南肇庆仓\",\n" +
                "            \"warehouseCode\": \"PJ_ZQHX\",\n" +
                "            \"deliveryContacter\": \"\",\n" +
                "            \"deliveryContacterTel\": \"\",\n" +
                "            \"returnContacterMobile\": \"13800138003\",\n" +
                "            \"returnCityName\": \"金华市\",\n" +
                "            \"receiverStateCode\": \"104104\",\n" +
                "            \"email\": \"332@qq.com\",\n" +
                "            \"returnDetailAddress\": \"浙江省金华市义乌市四季路999号B11仓库\",\n" +
                "            \"vipReturnSn\": \"\",\n" +
                "            \"returnContacter\": \"小小大强\",\n" +
                "            \"deliveryDistrictCode\": \"\",\n" +
                "            \"returnCityCode\": \"103103107\",\n" +
                "            \"deliveryStoreCode\": \"\",\n" +
                "            \"returnContacterTel\": \"13800138003\",\n" +
                "            \"receiverMobie\": \"13450411397\",\n" +
                "            \"reservationUser\": \"\",\n" +
                "            \"receiverDetailAddress\": \"丹江口个梵蒂冈保税\",\n" +
                "            \"returnCountry\": \"10\",\n" +
                "            \"totalPackingQty\": 0,\n" +
                "            \"isNeedFaceCount\": 0,\n" +
                "            \"isReservated\": 0,\n" +
                "            \"receiverCityName\": \"广州市\",\n" +
                "            \"deliveryCountry\": \"\",\n" +
                "            \"totalWeight\": 0.0,\n" +
                "            \"receiverDistrictName\": \"海珠区\",\n" +
                "            \"returnDistrictCode\": \"103103107107\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"totalVolume\": 0.0,\n" +
                "            \"zipCode\": \"500021\",\n" +
                "            \"receiverTel\": \"13245678909\",\n" +
                "            \"deliveryContacterMobile\": \"\",\n" +
                "            \"deliveryDistrictName\": \"\",\n" +
                "            \"totalQty\": 3,\n" +
                "            \"deliveryStateCode\": \"\",\n" +
                "            \"authContactor\": \"\",\n" +
                "            \"receiverDistrictCode\": \"104104112123\",\n" +
                "            \"channel\": 0,\n" +
                "            \"totalTagPrice\": 195.0,\n" +
                "            \"deliveryCityName\": \"\",\n" +
                "            \"type\": \"VIP_3PL_CW\",\n" +
                "            \"vendorCode\": \"17002437\",\n" +
                "            \"returnStateCode\": \"103103\",\n" +
                "            \"deliveryCityCode\": \"\",\n" +
                "            \"receiverCountry\": \"10\",\n" +
                "            \"poNo\": \"2602001206\",\n" +
                "            \"updatedDtmLoc\": 1770739211000,\n" +
                "            \"createdDtmLoc\": 1770739203000,\n" +
                "            \"returnDistrictName\": \"义乌市\",\n" +
                "            \"boxFlag\": 0,\n" +
                "            \"updatedByUser\": \"17002437\",\n" +
                "            \"returnNo\": \"\",\n" +
                "            \"deliveryDetailAddress\": \"\",\n" +
                "            \"receiver\": \"yc\",\n" +
                "            \"saleArea\": \"XNJY\",\n" +
                "            \"weight\": 0.0,\n" +
                "            \"returnStateName\": \"浙江省\",\n" +
                "            \"buyer\": \"\",\n" +
                "            \"volume\": 0.0,\n" +
                "            \"warehousingTime\": 0,\n" +
                "            \"flowRemark\": \"通过接口创建入库单\",\n" +
                "            \"receiverStateName\": \"广东省\",\n" +
                "            \"deliveryStoreName\": \"\",\n" +
                "            \"deliveryStateName\": \"\",\n" +
                "            \"reservationNo\": \"\",\n" +
                "            \"clientPoNo\": \"2026021000001\",\n" +
                "            \"status\": 1,\n" +
                "            \"transactionSource\": \"VSL_VC\",\n" +
                "            \"isBatchStorage\": 1,\n" +
                "            \"createdByUser\": \"scfio.li\",\n" +
                "            \"startOnRacksTime\": \"\",\n" +
                "            \"receiverCityCode\": \"104104112\",\n" +
                "            \"remark\": \"\",\n" +
                "            \"authTime\": 1770739210000,\n" +
                "            \"authUser\": \"17002437\",\n" +
                "            \"warehouseName\": \"西南简阳\",\n" +
                "            \"warehouseCode\": \"PJ_XNJY\",\n" +
                "            \"deliveryContacter\": \"\",\n" +
                "            \"deliveryContacterTel\": \"\",\n" +
                "            \"returnContacterMobile\": \"13800138003\",\n" +
                "            \"returnCityName\": \"金华市\",\n" +
                "            \"receiverStateCode\": \"104104\",\n" +
                "            \"email\": \"332@qq.com\",\n" +
                "            \"returnDetailAddress\": \"浙江省金华市义乌市四季路999号B11仓库\",\n" +
                "            \"vipReturnSn\": \"\",\n" +
                "            \"returnContacter\": \"小小大强\",\n" +
                "            \"deliveryDistrictCode\": \"\",\n" +
                "            \"returnCityCode\": \"103103107\",\n" +
                "            \"deliveryStoreCode\": \"\",\n" +
                "            \"returnContacterTel\": \"13800138003\",\n" +
                "            \"receiverMobie\": \"13245678909\",\n" +
                "            \"reservationUser\": \"\",\n" +
                "            \"receiverDetailAddress\": \"西南简阳\",\n" +
                "            \"returnCountry\": \"10\",\n" +
                "            \"totalPackingQty\": 0,\n" +
                "            \"isNeedFaceCount\": 0,\n" +
                "            \"isReservated\": 0,\n" +
                "            \"receiverCityName\": \"肇庆市\",\n" +
                "            \"deliveryCountry\": \"\",\n" +
                "            \"totalWeight\": 0.0,\n" +
                "            \"receiverDistrictName\": \"广宁县\",\n" +
                "            \"returnDistrictCode\": \"103103107107\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"totalNum\": 2\n" +
                "}";
        SearchPoResult searchPoResult = JsonUtils.toObj(jsonStr, SearchPoResult.class);

    }

    @Test
    public void jsonTest2(){
        String jsonStr = "{\n" +
                "            \"totalVolume\": 0.0,\n" +
                "            \"zipCode\": \"510000\",\n" +
                "            \"receiverTel\": \"13450411397\",\n" +
                "            \"deliveryContacterMobile\": \"\",\n" +
                "            \"deliveryDistrictName\": \"\",\n" +
                "            \"totalQty\": 480,\n" +
                "            \"deliveryStateCode\": \"\",\n" +
                "            \"authContactor\": \"\",\n" +
                "            \"receiverDistrictCode\": \"104104101105\",\n" +
                "            \"channel\": 0,\n" +
                "            \"totalTagPrice\": 130.0,\n" +
                "            \"deliveryCityName\": \"\",\n" +
                "            \"type\": \"VIP_3PL_CW\",\n" +
                "            \"vendorCode\": \"17002437\",\n" +
                "            \"returnStateCode\": \"103103\",\n" +
                "            \"deliveryCityCode\": \"\",\n" +
                "            \"receiverCountry\": \"10\",\n" +
                "            \"poNo\": \"2602001205\",\n" +
                "            \"updatedDtmLoc\": 1770220821000,\n" +
                "            \"createdDtmLoc\": 1770220808000,\n" +
                "            \"returnDistrictName\": \"义乌市\",\n" +
                "            \"boxFlag\": 0,\n" +
                "            \"updatedByUser\": \"17002437\",\n" +
                "            \"returnNo\": \"\",\n" +
                "            \"deliveryDetailAddress\": \"\",\n" +
                "            \"receiver\": \"yc\",\n" +
                "            \"saleArea\": \"GZSC\",\n" +
                "            \"weight\": 0.0,\n" +
                "            \"returnStateName\": \"浙江省\",\n" +
                "            \"buyer\": \"\",\n" +
                "            \"volume\": 0.0,\n" +
                "            \"warehousingTime\": 0,\n" +
                "            \"flowRemark\": \"通过接口创建入库单\",\n" +
                "            \"receiverStateName\": \"广东省\",\n" +
                "            \"deliveryStoreName\": \"\",\n" +
                "            \"deliveryStateName\": \"\",\n" +
                "            \"reservationNo\": \"\",\n" +
                "            \"clientPoNo\": \"2026020400002\",\n" +
                "            \"status\": 1,\n" +
                "            \"transactionSource\": \"VSL_VC\",\n" +
                "            \"isBatchStorage\": 1,\n" +
                "            \"createdByUser\": \"SYSTEM\",\n" +
                "            \"startOnRacksTime\": \"\",\n" +
                "            \"receiverCityCode\": \"104104101\",\n" +
                "            \"remark\": \"\",\n" +
                "            \"authTime\": 1770220820000,\n" +
                "            \"authUser\": \"17002437\",\n" +
                "            \"warehouseName\": \"华南肇庆仓\",\n" +
                "            \"warehouseCode\": \"PJ_ZQHX\",\n" +
                "            \"deliveryContacter\": \"\",\n" +
                "            \"deliveryContacterTel\": \"\",\n" +
                "            \"returnContacterMobile\": \"13800138003\",\n" +
                "            \"returnCityName\": \"金华市\",\n" +
                "            \"receiverStateCode\": \"104104\",\n" +
                "            \"email\": \"332@qq.com\",\n" +
                "            \"returnDetailAddress\": \"浙江省金华市义乌市四季路999号B11仓库\",\n" +
                "            \"vipReturnSn\": \"\",\n" +
                "            \"returnContacter\": \"小小大强\",\n" +
                "            \"deliveryDistrictCode\": \"\",\n" +
                "            \"returnCityCode\": \"103103107\",\n" +
                "            \"deliveryStoreCode\": \"\",\n" +
                "            \"returnContacterTel\": \"13800138003\",\n" +
                "            \"receiverMobie\": \"13450411397\",\n" +
                "            \"reservationUser\": \"\",\n" +
                "            \"receiverDetailAddress\": \"丹江口个梵蒂冈保税\",\n" +
                "            \"returnCountry\": \"10\",\n" +
                "            \"totalPackingQty\": 0,\n" +
                "            \"isNeedFaceCount\": 0,\n" +
                "            \"isReservated\": 0,\n" +
                "            \"receiverCityName\": \"广州市\",\n" +
                "            \"deliveryCountry\": \"\",\n" +
                "            \"totalWeight\": 0.0,\n" +
                "            \"receiverDistrictName\": \"海珠区\",\n" +
                "            \"returnDistrictCode\": \"103103107107\"\n" +
                "        }";
        PoInfo poInfo = JsonUtils.toObj(jsonStr, PoInfo.class);

    }
}
