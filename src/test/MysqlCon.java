package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlCon {

	//������MySQLDemo ��
		/*
		*java����mysql���ݿ�
		*1��������������
		*2�����ݿ������ַ���"jdbc:mysql://localhost:3306/���ݿ���?"
		*3�����ݿ��¼��
		*3�����ݿ��¼����
		*/	
					
		// MySQL 8.0 ���°汾 - JDBC �����������ݿ� URL
		//static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		// static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";
	 
	    // MySQL 8.0 ���ϰ汾 - JDBC �����������ݿ� URL
	    static final String JDBC_DRIVER = " ";  
	    static final String DB_URL = "jdbc:mysql://localhost:3306/zhs?useSSL=false&serverTimezone=UTC";
	 
	 
	    // ���ݿ���û��������룬��Ҫ�����Լ�������
	    static final String USER = "root";
	    static final String PASS = "root";
	 
	    public static void main(String[] args) {
	        //Connection conn = null;
	        Statement stmt = null;
	        try{
	            // ע�� JDBC ����
	            Class.forName(JDBC_DRIVER);
	        
	            // ������
	            System.out.println("�������ݿ�...");
	            //conn = DriverManager.getConnection(DB_URL,USER,PASS);
	            
	            new Thread(()->{
	     	        Statement stmt1 = null;
	            	System.out.println(" �߳�1ʵ����Statement����...");
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
		            			+ "zuigaoxuewei) values ('(�߳�1)��" + i + "',20,'����','����','����'"
		            		    + ",'����','����','����','����','����','����','����','����','����')";
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
	            	System.out.println(" �߳�2ʵ����Statement����...");
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
		            			+ "zuigaoxuewei) values ('(�߳�2)��" + i + "',20,'����','����','����'"
		            		    + ",'����','����','����','����','����','����','����','����','����')";
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
	            	System.out.println(" �߳�3ʵ����Statement����...");
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
		            			+ "zuigaoxuewei) values ('(�߳�3)��" + i + "',20,'����','����','����'"
		            		    + ",'����','����','����','����','����','����','����','����','����')";
		            	try {
							stmt3.executeUpdate(sql);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }
	            }).start();
	        
	            // ִ�в�ѯ
//	            System.out.println(" ʵ����Statement����...");
//	            stmt = conn.createStatement();
//	            int i = 0;
//	            while(true) {
//	            	i ++;
//	            	String sql = "insert into user (name,age,cengyongming,"
//	            			+ "minzu,jiguan,biyexuxiao,xuexing,shengao,hunyin,"
//	            			+ "shenfenzhenghao,youxiang,jiatingzhuzhi,zuigaoxueli,"
//	            			+ "zuigaoxuewei) values ('��" + i + "',20,'����','����','����'"
//	            		    + ",'����','����','����','����','����','����','����','����','����')";
//	            	stmt.executeUpdate(sql);
//	            }
	            
	            
	            
//	            String sql;
//	            sql = "SELECT id, name, age FROM user";
//	            ResultSet rs = stmt.executeQuery(sql);
//	        
//	            // չ����������ݿ�
//	            while(rs.next()){
//	                // ͨ���ֶμ���
//	                int id  = rs.getInt("id");
//	                String name = rs.getString("name");
//	                String age = rs.getString("age");
//	                //Thread.sleep(500);
//	                // �������
//	                System.out.print("ID: " + id);
//	                System.out.print(", ����: " + name);
//	                System.out.print(", ���� URL: " + age);
//	                System.out.print("\n");
//	            }
//	            // ��ɺ�ر�
//	            rs.close();
//	            stmt.close();
//	            conn.close();
	        }catch(Exception e){
	            // ���� Class.forName ����
	            e.printStackTrace();
	        }finally{
	            // �ر���Դ
	            try{
	                if(stmt!=null) stmt.close();
	            }catch(SQLException se2){
	            }// ʲô������
//	            try{
//	                if(conn!=null) conn.close();
//	            }catch(SQLException se){
//	                se.printStackTrace();
//	            }
	        }
	        System.out.println("Goodbye!");
	    }	
}
