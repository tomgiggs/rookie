package com.streamcompute.learn.rookie.controller;

import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.sql.*;

@RestController
public class MysqlDemo {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/mail";
    static  final  String userName = "root";
    static  final  String password = "root";
    @RequestMapping(value = "/getmysql", method = RequestMethod.GET)
    public String getRecord() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection conn;
        conn = DriverManager.getConnection(DB_URL,userName,password);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from list limit 10");
        resultSet.next();
        String sellerName=resultSet.getString("name");
        statement.close();
        conn.close();
         return  sellerName;



    }
}
