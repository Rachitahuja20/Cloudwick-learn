package com.cloudwick.project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ahuja on 3/29/15.
 */
public class JDBCSample {

    public static void main(String[] args) throws ClassNotFoundException {
        // load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC");

        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:JDBCsample.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists person");
            statement.executeUpdate("create table person (Id integer, Name string, Salary integer)");
            statement.executeUpdate("insert into person values(1, 'leo', 15000)");
            statement.executeUpdate("insert into person values(2, 'yui', 20000)");

            ResultSet result = statement.executeQuery("select * from person");


            while (result.next()) {
                // read the result set
                System.out.println("name = " + result.getString("name"));
                System.out.println("id = " + result.getInt("id"));
                System.out.println("Salary = " + result.getInt("Salary"));

            }
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
    }
}



