package org.covid.util;

import java.sql.*;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC&characterEncoding=utf-8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    public static PreparedStatement psmt = null;
    public static Connection connection = null;
    public static ResultSet rs = null;

    // 通用的：查询总数
    public static int getTotalCount(String sql) {
        int count = -1;
        try {
            psmt = createPreParedStatement(sql, null);
            rs = psmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, psmt, connection);
        }
        return count;
    }

    // 通用的增删改
    public static boolean executeUpdate(String sql, Object[] params) {
        try {
            psmt = createPreParedStatement(sql, params);
            int count = psmt.executeUpdate();
            if (count > 0)
                return true;
            else
                return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            closeAll(null, psmt, connection);
        }
    }

    public static void closeAll(ResultSet rs, Statement stmt, Connection connection) {
        try {
            if (rs != null)
                rs.close();
            if (psmt != null)
                psmt.close();
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static PreparedStatement createPreParedStatement(String sql, Object[] params)
            throws ClassNotFoundException, SQLException {
        psmt = getConnection().prepareStatement(sql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                psmt.setObject(i + 1, params[i]);
            }
        }
        return psmt;
    }

    // 通用的查 :通用 表示 适合与 任何查询
    public static ResultSet executeQuery(String sql, Object[] params) {
        try {
            psmt = createPreParedStatement(sql, params);
            rs = psmt.executeQuery();
            return rs;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

