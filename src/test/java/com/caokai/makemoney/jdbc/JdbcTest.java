package com.caokai.makemoney.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {

    // 获取连接
    private String url = "****";
    private String user = "root";
    private String password = "123456";


    @Test
    void resultSetTest() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        String querySql = "select * from student";
        ResultSet resultSet = statement.executeQuery(querySql);
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println("id:" + id);
            System.out.println("name:" + name);
            System.out.println("age:" + age);
            System.out.println("--------");
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    void preparedStatementTest() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        String querySql = "select * from student where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(querySql);
        preparedStatement.setString(1, "1");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println("id:" + id);
            System.out.println("name:" + name);
            System.out.println("age:" + age);
            System.out.println("--------");
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
