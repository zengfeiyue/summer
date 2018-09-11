package com.summer.common.code;


import java.sql.*;

/**
 * 代码生成器
 * @author zengfeiyue
 */
public class CodeGenerator {
    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://193.112.27.98:3306/life?useUnicode=true&characterEncoding=UTF-8";
        String user = "root";
        String password = "root";

        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);
        if (!conn.isClosed())
            System.out.println("Succeeded connecting to the Database!");
        else
            System.err.println("connect filed");
        // 获取所有表名
        Statement statement = conn.createStatement();

        getTables(conn);

        ResultSet resultSet = statement
                .executeQuery("select * from activity");
        // 获取列名
        ResultSetMetaData metaData = resultSet.getMetaData();
        for (int i = 0; i < metaData.getColumnCount(); i++) {
            // resultSet数据下标从1开始
            String columnName = metaData.getColumnName(i + 1);
            int type = metaData.getColumnType(i + 1);
            if (Types.INTEGER == type) {
                // int
            } else if (Types.VARCHAR == type) {
                // String
            }
            System.out.print(columnName + "\t");
        }
        System.out.println();
        // 获取数据
        while (resultSet.next()) {
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                // resultSet数据下标从1开始
                System.out.print(resultSet.getString(i + 1) + "\t");
            }
            System.out.println();

        }
        statement.close();
        conn.close();

    }

    private static void getTables(Connection conn) throws SQLException {
        DatabaseMetaData dbMetData = conn.getMetaData();
        // mysql convertDatabaseCharsetType null
        ResultSet rs = dbMetData.getTables(null,null, null,
                new String[] { "TABLE", "VIEW" });

        while (rs.next()) {
            if (rs.getString(4) != null
                    && (rs.getString(4).equalsIgnoreCase("TABLE") || rs
                    .getString(4).equalsIgnoreCase("VIEW"))) {
                String tableName = rs.getString(3).toLowerCase();
                System.out.print(tableName + "\t");
                // 根据表名提前表里面信息：
                ResultSet colRet = dbMetData.getColumns(null, "%", tableName,
                        "%");
                while (colRet.next()) {
                    String columnName = colRet.getString("COLUMN_NAME");
                    String columnType = colRet.getString("TYPE_NAME");
                    int datasize = colRet.getInt("COLUMN_SIZE");
                    int digits = colRet.getInt("DECIMAL_DIGITS");
                    int nullable = colRet.getInt("NULLABLE");
                    // System.out.println(columnName + " " + columnType + " "+
                    // datasize + " " + digits + " " + nullable);
                }

            }
        }
        System.out.println();

        // resultSet数据下标从1开始 ResultSet tableRet =
        //conn.getMetaData().getTables(null, null, "%", new String[] { "TABLE" });
        //while (tableRet.next()) {
        //	System.out.print(tableRet.getString(3) + "\t");
        //}
        //System.out.println();

    }
}
