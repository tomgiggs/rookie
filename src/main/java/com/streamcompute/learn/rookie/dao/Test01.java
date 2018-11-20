package com.streamcompute.learn.rookie.dao;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test01 {
    public static void main(String[] args) throws IOException {
        String resource = "./mybatisConf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession session = factory.openSession();
        try {
            String statement = "selectUser";//映射sql的标识字符串
            //执行查询返回一个唯一user对象的sql
            List<Object> user = session.selectList(statement, "zhang-zhen-yu-57-17");
//            Demo one = session.selectOne("zhang-zhen-yu-57-17");
            System.out.println(user.get(1));
        } finally {
            session.close();
        }
    }
}
