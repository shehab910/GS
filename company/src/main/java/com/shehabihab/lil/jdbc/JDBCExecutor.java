package com.shehabihab.lil.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCExecutor {

    public static void main(String... args) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost",
                "company", "postgres", "mypassword");
        try {
            Connection connection = dcm.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from students");
            statement.executeQuery();
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                System.out.println(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}