/*
 * Copyright (c) 2018, 2018, Travel and/or its affiliates. All rights reserved.
 * TRAVEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package com.jett.business;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author flysLi
 * @ClassName MySQLUtil
 * @Decription TODO
 * @Date 2018/10/12 14:31
 * @Version 1.0
 */
public class MySQLUtil<T> {
    public static final String URL = "jdbc:mysql://42.51.15.186:3306/ExtGameServer";
    public static final String USER = "88wanyo";
    public static final String PASSWORD = "sj5702671";

    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConnection() {
        Connection connection = null;
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭数据库连接
     *
     * @param connection
     */
    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int cmmand() {
        Connection connection = null;
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement st = connection.createStatement();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String sql = "insert into `GM_COMMAND` (`SN`, `FromIP`, `ServerID`, `Command`, `CmdLength`, `Status`, `OptTimeStamp`, `FlagID`, `LASTTIME`) values" +
                        "('" + (System.currentTimeMillis() / 1000) + "','114.114.114.114','4000','loadgift','8','1','2147483647','0','" + sdf.format(new Date()) + "');";
                System.out.println(sql);
                return st.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static int executeCharId(String name) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                connection = DriverManager.getConnection("jdbc:mysql://42.51.15.186:3306/S4000_DATA?useUnicode=true&characterEncoding=UTF8", USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            String sql = "SELECT CHARID FROM CHARBASE WHERE NAME=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("CHARID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySQLUtil.close(connection);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(MySQLUtil.cmmand());

    }
}
