package Dao.connection;

import java.sql.*;

public class DataBaseConnection{
    private final String DBDriver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String DBURL ="jdbc:sqlserver://localhost:1433;DatabaseName=student";
    private final String DBUSER ="sa";
    private final String DBPASSWORD ="yyw@20010301";
    private Connection conn = null;
    //构造器
    public DataBaseConnection(){
        try{
            Class.forName(DBDriver);
            conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("连接数据库失败");
        }
    }

    //获得连接
    public Connection getConnection(){
        return this.conn; }

    //关闭连接
    public void close() throws SQLException{
        this.conn.close(); }
}

