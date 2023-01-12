package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlCon {

	//这里是MySQLDemo 类
		/*
		*java连接mysql数据库
		*1、加载驱动程序
		*2、数据库连接字符串"jdbc:mysql://localhost:3306/数据库名?"
		*3、数据库登录名
		*3、数据库登录密码
		*/	
					
		// MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
		//static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		// static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";
	 
	    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
	    static final String JDBC_DRIVER = " ";  
	    static final String DB_URL = "jdbc:mysql://localhost:3306/zhs?useSSL=false&serverTimezone=UTC";
	 
	 
	    // 数据库的用户名与密码，需要根据自己的设置
	    static final String USER = "root";
	    static final String PASS = "root";
	 
	    public static void main(String[] args) {
	        //Connection conn = null;
	        Statement stmt = null;
	        try{
	            // 注册 JDBC 驱动
	            Class.forName(JDBC_DRIVER);
	        
	            // 打开链接
	            System.out.println("连接数据库...");
	            //conn = DriverManager.getConnection(DB_URL,USER,PASS);
	            
	            new Thread(()->{
	     	        Statement stmt1 = null;
	            	System.out.println(" 线程1实例化Statement对象...");
		            try {
		            	Connection  conn = DriverManager.getConnection(DB_URL,USER,PASS);
						stmt1 = conn.createStatement();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            int i = 0;
		            while(true) {
		            	i ++;
		            	String sql = "insert into user (name,age,cengyongming,"
		            			+ "minzu,jiguan,biyexuxiao,xuexing,shengao,hunyin,"
		            			+ "shenfenzhenghao,youxiang,jiatingzhuzhi,zuigaoxueli,"
		            			+ "zuigaoxuewei) values ('(线程1)张" + i + "',20,'测试','测试','测试'"
		            		    + ",'测试','测试','测试','测试','测试','测试','测试','测试','测试')";
		            	try {
							stmt1.executeUpdate(sql);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }
	            }).start();
	            
	            new Thread(()->{
	     	        Statement stmt2 = null;
	            	System.out.println(" 线程2实例化Statement对象...");
		            try {
		            	Connection  conn = DriverManager.getConnection(DB_URL,USER,PASS);
						stmt2 = conn.createStatement();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            int i = 0;
		            while(true) {
		            	i ++;
		            	String sql = "insert into user (name,age,cengyongming,"
		            			+ "minzu,jiguan,biyexuxiao,xuexing,shengao,hunyin,"
		            			+ "shenfenzhenghao,youxiang,jiatingzhuzhi,zuigaoxueli,"
		            			+ "zuigaoxuewei) values ('(线程2)张" + i + "',20,'测试','测试','测试'"
		            		    + ",'测试','测试','测试','测试','测试','测试','测试','测试','测试')";
		            	try {
							stmt2.executeUpdate(sql);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }
	            }).start();
	            new Thread(()->{
	     	        Statement stmt3 = null;
	            	System.out.println(" 线程3实例化Statement对象...");
		            try {
		            	Connection  conn = DriverManager.getConnection(DB_URL,USER,PASS);
						stmt3 = conn.createStatement();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            int i = 0;
		            while(true) {
		            	i ++;
		            	String sql = "insert into user (name,age,cengyongming,"
		            			+ "minzu,jiguan,biyexuxiao,xuexing,shengao,hunyin,"
		            			+ "shenfenzhenghao,youxiang,jiatingzhuzhi,zuigaoxueli,"
		            			+ "zuigaoxuewei) values ('(线程3)张" + i + "',20,'测试','测试','测试'"
		            		    + ",'测试','测试','测试','测试','测试','测试','测试','测试','测试')";
		            	try {
							stmt3.executeUpdate(sql);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }
	            }).start();
	        
	            // 执行查询
//	            System.out.println(" 实例化Statement对象...");
//	            stmt = conn.createStatement();
//	            int i = 0;
//	            while(true) {
//	            	i ++;
//	            	String sql = "insert into user (name,age,cengyongming,"
//	            			+ "minzu,jiguan,biyexuxiao,xuexing,shengao,hunyin,"
//	            			+ "shenfenzhenghao,youxiang,jiatingzhuzhi,zuigaoxueli,"
//	            			+ "zuigaoxuewei) values ('张" + i + "',20,'测试','测试','测试'"
//	            		    + ",'测试','测试','测试','测试','测试','测试','测试','测试','测试')";
//	            	stmt.executeUpdate(sql);
//	            }
	            
	            
	            
//	            String sql;
//	            sql = "SELECT id, name, age FROM user";
//	            ResultSet rs = stmt.executeQuery(sql);
//	        
//	            // 展开结果集数据库
//	            while(rs.next()){
//	                // 通过字段检索
//	                int id  = rs.getInt("id");
//	                String name = rs.getString("name");
//	                String age = rs.getString("age");
//	                //Thread.sleep(500);
//	                // 输出数据
//	                System.out.print("ID: " + id);
//	                System.out.print(", 姓名: " + name);
//	                System.out.print(", 年龄 URL: " + age);
//	                System.out.print("\n");
//	            }
//	            // 完成后关闭
//	            rs.close();
//	            stmt.close();
//	            conn.close();
	        }catch(Exception e){
	            // 处理 Class.forName 错误
	            e.printStackTrace();
	        }finally{
	            // 关闭资源
	            try{
	                if(stmt!=null) stmt.close();
	            }catch(SQLException se2){
	            }// 什么都不做
//	            try{
//	                if(conn!=null) conn.close();
//	            }catch(SQLException se){
//	                se.printStackTrace();
//	            }
	        }
	        System.out.println("Goodbye!");
	    }	
}
