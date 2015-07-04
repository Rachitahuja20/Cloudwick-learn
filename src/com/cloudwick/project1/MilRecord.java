package com.cloudwick.project1;

import java.sql.*;

/**
 * Created by ahuja on 3/29/15.
 */
public class MilRecord {

    public long Records() {

        try {
            Class.forName("org.sqlite.JDBC");

        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        Connection connection = null;
        long ptime = System.currentTimeMillis();
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:JDBCsample2.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists Mil");

            statement.executeUpdate("create table Mil (Name string, Id integer)");


            PreparedStatement ps = connection.prepareStatement(
                    "insert into Mil values(?,?)");


            connection.setAutoCommit(false);

            for (int i = 0; i < 1000000; i++) {


                ps.setString(1, "Name " + i);
                ps.setInt(2, i);
                ps.addBatch();


            }

            ps.executeBatch();
            connection.commit();
            connection.setAutoCommit(true);
            ps.close();

            // ResultSet rs = statement.executeQuery("select * from person where Id<1000");

            // while (rs.next()) {
            // read the result set
            //System.out.println("name = " + rs.getString("name"));
            //System.out.println("id = " + rs.getInt("id"));

            // }

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
        long ctime = System.currentTimeMillis();
        long time = ctime - ptime;
        return time;
    }

    public static void main(String[] args) {

        MilRecord time = new MilRecord();
        long tim = time.Records();

        System.out.print(tim);

    }


}
