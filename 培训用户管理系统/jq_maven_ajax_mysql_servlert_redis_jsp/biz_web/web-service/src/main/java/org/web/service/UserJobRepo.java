package org.web.service;

import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserJobRepo {
	//返回一个插入是否成功的值，1表示成功，0表示失败
			public static int insertUser(String name,String user_name) {
				 Connection con=ConnectJdbc.getConection();
				 int flag=0;
				 String sql0="insert into user_job(job_name,user_name) values(?,?)";
		         
		         try {
		        	con.setAutoCommit(false);//JDBC中默认是true，自动提交事务
					PreparedStatement pst=con.prepareStatement(sql0);
					 pst.setString(1,name);
					 pst.setString(2,user_name);
					 flag=pst.executeUpdate();
					 con.commit();//提交事务
			         ConnectJdbc.close(con);
			         
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        return flag;

				
			}
			public static List<UserJob> getAllJob(String user_name){
				 Connection con=ConnectJdbc.getConection();
				 List<UserJob> listJobs=new ArrayList<UserJob>();
				 String sql0="select * from user_job where user_name=?";
		         
		         
		     	 PreparedStatement pst;
				 try {
					
					pst = con.prepareStatement(sql0);
					pst.setString(1,user_name);
					 ResultSet resultSet=pst.executeQuery();
			         while (resultSet.next()) {
			         	int p1=resultSet.getInt(1);
			         	String p2=resultSet.getString(2);			         	
			         	UserJob temp=new UserJob();
			            temp.setJob_id(p1);
			            temp.setJob_name(p2);
			            listJobs.add(temp);
			             
				        }
			         ConnectJdbc.close(con);
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         return listJobs;
		       
			}
			public static int deleteJobById(int id) {
				int flag=0;
				Connection con=ConnectJdbc.getConection();
				String sql="delete from user_job where job_id=?";
//				System.out.println(name);
				PreparedStatement pst;
				try {
					con.setAutoCommit(false);//JDBC中默认是true，自动提交事务
					pst = con.prepareStatement(sql);
					pst.setInt(1,id);
			        flag=pst.executeUpdate();
			        con.commit();//提交事务
					ConnectJdbc.close(con);
			        
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        return flag;
			} 
}
