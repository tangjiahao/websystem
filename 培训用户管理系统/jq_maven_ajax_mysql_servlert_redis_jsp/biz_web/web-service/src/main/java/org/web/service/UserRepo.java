package org.web.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UserRepo {
   
	public static List<User> getAllUser(){
		 Connection con=ConnectJdbc.getConection();
		 List<User> listUsers=new ArrayList<User>();
		 String sql0="select * from User";
         
         
     	 PreparedStatement pst;
		 try {
			pst = con.prepareStatement(sql0);
			 ResultSet resultSet=pst.executeQuery();
	         while (resultSet.next()) {
	         	String p1=resultSet.getString(1);
	         	String p2=resultSet.getString(2);
	         	String p3=resultSet.getString(3);
	         	String p4=resultSet.getString(4);
	         	String p5=resultSet.getString(5);
	         	String p6=resultSet.getString(6);
	         	String p7=resultSet.getString(7);
	         	String p8=resultSet.getString(8);
	         	
	         	User temp=new User();
	            temp.setUser_id(p1);
	            temp.setUser_name(p2);
	            temp.setUser_pwd(p3);
	            temp.setUser_mail(p4);
	            temp.setUser_area(p5);
	            temp.setUser_hobby(p6);
	            temp.setUser_job(p7);
	            temp.setUser_creat_time(p8);
	            listUsers.add(temp);
	             
		        }
	         ConnectJdbc.close(con);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return listUsers;
       
	}
	public static int getUserAmount(String sql) {
		Connection conn=null;
      PreparedStatement ps=null;
      ResultSet rs=null;
      try {
    	  conn=ConnectJdbc.getConection();
          ps = conn.prepareStatement(sql);
          rs = ps.executeQuery();
          int num=0;
          while(rs.next()){
              num=rs.getInt(1);
          }
          ConnectJdbc.close(conn);
          return num;
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
      
	}
	public static List<User> serchUserByName(String name){
		Connection con=ConnectJdbc.getConection();
		 List<User> listUsers=new ArrayList<User>();
		 String sql0="select * from User where user_name=?";
        
        
    	 PreparedStatement pst;
		 try {

	        
			 pst = con.prepareStatement(sql0);
			 pst.setString(1,name);
			 ResultSet resultSet=pst.executeQuery();
	         while (resultSet.next()) {
	         	String p1=resultSet.getString(1);
	         	String p2=resultSet.getString(2);
	         	String p3=resultSet.getString(3);
	         	String p4=resultSet.getString(4);
	         	String p5=resultSet.getString(5);
	         	String p6=resultSet.getString(6);
	         	String p7=resultSet.getString(7);
	         	String p8=resultSet.getString(8);
	         	
	         	User temp=new User();
	            temp.setUser_id(p1);
	            temp.setUser_name(p2);
	            temp.setUser_pwd(p3);
	            temp.setUser_mail(p4);
	            temp.setUser_area(p5);
	            temp.setUser_hobby(p6);
	            temp.setUser_job(p7);
	            temp.setUser_creat_time(p8);
	            listUsers.add(temp);
	             
		        }
	         ConnectJdbc.close(con);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return listUsers;
	}
	

	//得到分页的Userlist
	public static List<User> getPageOfUsers(String sql,int index,int pagesize){
		Connection con=ConnectJdbc.getConection();
		 List<User> listUsers=new ArrayList<User>();
		 String endString=sql+" limit ?,?";
//		 System.out.println(endString);
		 PreparedStatement pst;
		 try {
			pst = con.prepareStatement(endString);
			pst.setInt(1, (index-1)*pagesize);
			 pst.setInt(2,pagesize);
			 ResultSet resultSet=pst.executeQuery();
	        while (resultSet.next()) {
	        	String p1=resultSet.getString(1);
	        	String p2=resultSet.getString(2);
	        	String p3=resultSet.getString(3);
	        	String p4=resultSet.getString(4);
	        	String p5=resultSet.getString(5);
	        	String p6=resultSet.getString(6);
	        	String p7=resultSet.getString(7);
	        	String p8=resultSet.getString(8);
	        	
	        	User temp=new User();
	           temp.setUser_id(p1);
	           temp.setUser_name(p2);
	           temp.setUser_pwd(p3);
	           temp.setUser_mail(p4);
	           temp.setUser_area(p5);
	           temp.setUser_hobby(p6);
	           temp.setUser_job(p7);
	           temp.setUser_creat_time(p8);
	           listUsers.add(temp);
	            
			
			
		   }
	        ConnectJdbc.close(con); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return listUsers;
		 
	}
	//返回一个插入是否成功的值，1表示成功，0表示失败
		public static int insertUser(String name,String pwd,String mail,String area,String hobby,String job,String time) {
			 Connection con=ConnectJdbc.getConection();
			 int flag=0;
			 String sql0="insert into User values(?,?,?,?,?,?,?,?)";
	         String id=UUID.randomUUID().toString();
	         try {
	        	con.setAutoCommit(false);//JDBC中默认是true，自动提交事务
				PreparedStatement pst=con.prepareStatement(sql0);
				 pst.setString(1,id);
	             pst.setString(2,name);
	             pst.setString(3,pwd);
	             pst.setString(4,mail);
	             pst.setString(5,area);
	             pst.setString(6,hobby);
	             pst.setString(7,job);
	             pst.setString(8,time);
				 flag=pst.executeUpdate();
				 con.commit();//提交事务
		         ConnectJdbc.close(con);
		         
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return flag;

			
		}
	//返回一个是否更新成功的变量
	public static int updateUserByName(String name,String pwd,String mail,String area,String hobby,String job,String time) {
		String sql="update User set user_pwd=?,user_mail=?,user_area=?,user_hobby=?,user_job=?,user_creat_time=? where user_name=?";
		Connection conn=ConnectJdbc.getConection();
		int flag=0;
		try {
			conn.setAutoCommit(false);//JDBC中默认是true，自动提交事务         
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,pwd);
            pst.setString(2,mail);
            pst.setString(3,area );
            pst.setString(4,hobby );
            pst.setString(5,job );
            pst.setString(6,time );
            pst.setString(7,name );           
            flag=pst.executeUpdate();
			conn.commit();//提交事务
			ConnectJdbc.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return flag;
		
	}
	public static int deleteUserByName(String name) {
		int flag=0;
		Connection con=ConnectJdbc.getConection();
		String sql="delete from User where user_name=?";
//		System.out.println(name);
		PreparedStatement pst;
		try {
			con.setAutoCommit(false);//JDBC中默认是true，自动提交事务
			pst = con.prepareStatement(sql);
			pst.setString(1,name);
	        flag=pst.executeUpdate();
	        con.commit();//提交事务
			ConnectJdbc.close(con);
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("flag:"+flag);
        return flag;
	} 
}
