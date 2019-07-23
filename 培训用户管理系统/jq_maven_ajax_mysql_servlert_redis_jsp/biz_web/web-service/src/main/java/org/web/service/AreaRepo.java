package org.web.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AreaRepo {
	public static List<String> getAllProvince(){
		 Connection con=ConnectJdbc.getConection();
		 List<String> listprovince=new ArrayList<String>();
		 String sql0="select province from province";
        
        
    	 PreparedStatement pst;
		 try {
			pst = con.prepareStatement(sql0);
			 ResultSet resultSet=pst.executeQuery();
	         while (resultSet.next()) {
	         	String p1=resultSet.getString(1);
	         	
	            listprovince.add(p1);
	            
	             
		        }
	        ConnectJdbc.close(con);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return listprovince;
                   
        
	}
	public static Map<String,String> getAllCity(){
		 Connection con=ConnectJdbc.getConection();
		 Map<String,String> cityToProvince=new HashMap<String,String>();
		 String sql0="select city,province from pro_city";
         
       
   	     PreparedStatement pst;
		 try {
			pst = con.prepareStatement(sql0);
			 ResultSet resultSet=pst.executeQuery();
	         while (resultSet.next()) {
	         	String p1=resultSet.getString(1);
	         	String p2=resultSet.getString(2);
	            cityToProvince.put(p1,p2);
	            
	             
		        }
	         ConnectJdbc.close(con);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       return cityToProvince;
                  
       
	}
	public static List<String> getCityByProvince(String province){
		 Connection con=ConnectJdbc.getConection();
		 List<String> listcity=new ArrayList<String>();
		 String sql0="select city from pro_city where province=?";
       
       
   	 PreparedStatement pst;
		 try {
			pst = con.prepareStatement(sql0);
			pst.setString(1,province);
			ResultSet resultSet=pst.executeQuery();
	         while (resultSet.next()) {
	         	String p1=resultSet.getString(1);
	         	
	            listcity.add(p1);
	            
	             
		        }
	         ConnectJdbc.close(con);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       return listcity;
                  
       
	}
}
