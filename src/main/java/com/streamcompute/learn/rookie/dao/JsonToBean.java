package com.streamcompute.learn.rookie.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonToBean {
    public static void main(String[] args) {
        String json = "{\"PROJ_ID\": \"85d06cef-61d1-4959-b68c-b6c81b9983a8\", \"INDUSTRY_ID\": \"F17CF31D-DDE2-1430-8A65-666020D20811\", \"PROJ_NAME\": \"\\u9f99\\u6b66\\u9547\\u96c6\\u9547\\u65b0\\u533a\\u6613\\u5730\\u6276\\u8d2b\\u642c\\u8fc1\\u5de5\\u7a0b\", \"PROJ_APP\": \"\\u77f3\\u5c4f\\u53bf\\u9f99\\u6b66\\u9547\\u4eba\\u6c11\\u653f\\u5e9c\", \"TOTAL_INVESTMENT\": 1259.0, \"APPLICATE_AREA\": 532525, \"BUILD_AREA\": 532525, \"BUILD_ADDRESS\": \"\\u4e91\\u5357\\u7701\\u7ea2\\u6cb3\\u5dde\\u77f3\\u5c4f\\u53bf\\u9f99\\u6b66\\u9547\", \"LINKMAN\": \"\\u738b\\u9e4f\"}";
//        JSONObject record = (JSONObject) JSONObject.parse(json);
        InvestDetail detail = JSON.parseObject(json,InvestDetail.class);

//        System.out.println(detail.getAPPLICATE_AREA());

    }
}
