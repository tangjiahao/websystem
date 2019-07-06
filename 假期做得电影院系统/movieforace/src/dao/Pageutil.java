package dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import alljavabean.*;
import alljavabean.connectionace;

public class Pageutil<T> {
    private int totalrecords;
    private int totalpages;
    private int pagesize;
    private int pageindex;
    private int firstpage;
    private int lastpage;
    private int nextpage;
    private int prepage;
    
    
    public int getNextpage() {
        return nextpage;
    }
    public void setNextpage() {
	if(this.pageindex<this.totalpages)
        this.nextpage = this.pageindex+1 ;
	else{
	    this.nextpage=this.pageindex;
	}
    }
    public int getPrepage() {
        return prepage;
    }
    public void setPrepage() {
	if(this.pageindex>this.firstpage )
        this.prepage = this.pageindex-1 ;
	else{
	    this.prepage=this.pageindex;
	}
    }
    public int getFirstpage() {
        return firstpage;
    }
    public void setFirstpage(int firstpage) {
        this.firstpage = 1;
        if(this.totalrecords==0)
            this.firstpage=0;
    }
    public int getLastpage() {
        return lastpage;
    }
    public void setLastpage(int lastpage) {
        this.lastpage = this.totalpages;
    }
    private List<T> pagedata;
    public int getTotalrecords() {
        return totalrecords;
    }
    public void setTotalrecords(int totalrecords) {
        this.totalrecords = totalrecords;
    }
    public int getTotalpages() {
        return totalpages;
    }
    public void setTotalpages(int s) {
        this.totalpages = this.totalrecords/this.pagesize;
        if(this.totalrecords%this.pagesize!=0)
            this.totalpages +=1;
    }
    public int getPagesize() {
        return pagesize;
    }
    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }
    public int getPageindex() {
        return pageindex;
    }
    public void setPageindex(int pageindex) {
        this.pageindex = pageindex;
    }
    public List<T> getPagedata() {
        return pagedata;
    }
    public void setPagedata(List<T> pagedata) {
        this.pagedata = pagedata;
    }
   
    
    
    
    private T resolveResultSetToOjbect(ResultSet rs,Class<T> clsace){
	T t = null;
	try {
		//实例化T类的对象
		t = clsace.newInstance();
		//得到当前表结构
		ResultSetMetaData ace123= rs.getMetaData();
		//通过T类的Class对象得到T类中所有的属性
		Field[] ace1 = clsace.getDeclaredFields();
		//循环遍历所有的列
		for (int i = 1; i <= ace123.getColumnCount(); i++) {
			//得到列名和列值
			String colName = ace123.getColumnName(i);
			Object value = rs.getObject(colName);
			//遍历所有的属性
			for (Field field : ace1) {
				//允许给所有的属性赋值
				field.setAccessible(true);
				//当列名和属性名匹配的时候将当前列的值赋值给当前对象的当前属性
				if(colName.equalsIgnoreCase(field.getName())){
					field.set(t, value);
				}
			}
		}
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return t;
}
    public void pageshow(String sql,Class<T> clsace,Object...objects)
    {
	Connection con =connectionace.getConection();
	try {
		PreparedStatement pst = con.prepareStatement(sql);
		if(objects != null && objects.length > 0){
			for (int i = 0; i < objects.length; i++) {
				pst.setObject(i+1, objects[i]);
			}
		}
		ResultSet rs = pst.executeQuery();
		List<T> data = new ArrayList<T>();
		while(rs != null && rs.next()){
			//T t = clsace.newInstance();
			//对t对象的属性进行一一赋值
			data.add(resolveResultSetToOjbect(rs,clsace));
		}
                int row=this.countrecords(sql);
                if(row>0)
                {
                    System.out.print(row);
                    
                    this.setPagedata(data);
                    this.setPageindex((int)objects[0]/(int)objects[1]+1);
                    this.setPagesize((int)objects[1]);
                    this.setTotalrecords(row);
                    this.setTotalpages(0);
                    this.setFirstpage(1);
                    this.setLastpage(0);
                    this.setNextpage();
                    this.setPrepage();
                   
                }
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally{
	       connectionace.close(con);
	}
	
	 
    }
    private int countrecords(String sql)
    {
	String sql0="select count(*) from";
        sql0+=sql.substring(sql.indexOf("from")+4,sql.indexOf("limit"));
        System.out.print(sql0);
        Connection con=connectionace.getConection();
        try {
            
            
            PreparedStatement pst=con.prepareStatement(sql0);
            
           
            
            ResultSet res=pst.executeQuery();
            res.next();
            int row = res.getInt(1);
            return row;
//        System.out.println(sql0);
	
    }catch (SQLException e) {
        System.out.println(e);
    }
    return 0;
     
}
   
}
