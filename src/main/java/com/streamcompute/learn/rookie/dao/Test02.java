package com.streamcompute.learn.rookie.dao;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test02 {
    public static void main(String[] args) throws IOException {
        String resource = "./mybatisConf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession session = factory.openSession();
        String json = "{\"PROJ_ID\": \"85d06cef-61d1-4959-b68c-b6c81b9983a8\", \"INDUSTRY_ID\": \"F17CF31D-DDE2-1430-8A65-666020D20811\", \"PROJ_NAME\": \"\\u9f99\\u6b66\\u9547\\u96c6\\u9547\\u65b0\\u533a\\u6613\\u5730\\u6276\\u8d2b\\u642c\\u8fc1\\u5de5\\u7a0b\", \"PROJ_APP\": \"\\u77f3\\u5c4f\\u53bf\\u9f99\\u6b66\\u9547\\u4eba\\u6c11\\u653f\\u5e9c\", \"TOTAL_INVESTMENT\": 1259.0, \"APPLICATE_AREA\": 532525, \"BUILD_AREA\": 532525, \"BUILD_ADDRESS\": \"\\u4e91\\u5357\\u7701\\u7ea2\\u6cb3\\u5dde\\u77f3\\u5c4f\\u53bf\\u9f99\\u6b66\\u9547\", \"LINKMAN\": \"\\u738b\\u9e4f\"}";
//        JSONObject record = (JSONObject) JSONObject.parse(json);
        InvestDetail detail = JSON.parseObject(json,InvestDetail.class);
        try {
            String statement = "insertRecord";//映射sql的标识字符串
            //执行查询返回一个唯一user对象的sql
            session.insert(statement,detail);
            session.commit();
//            session.insert()
//            Demo one = session.selectOne("zhang-zhen-yu-57-17");
            System.out.println("insert success");
        } finally {
            session.close();
        }


    }
}
