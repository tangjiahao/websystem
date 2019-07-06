package dao;


import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import alljavabean.*;

public class jdbcdao<T> {
	/**
	 * 解析当前行数据，返回一个T类的对象
	
	 */
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
	/**
	 * 根据主键(单主键)查询单个对象
	
	 */
	public T loadObjectById(String sql,Class<T> clsace,Serializable id){
		Connection con = connectionace.getConection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setObject(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs != null && rs.next()){
				//T t = clsace.newInstance();
				//对t对象的属性进行一一赋值
				return this.resolveResultSetToOjbect(rs, clsace);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			connectionace.close(con);
		}
		return null;
	}
	/**
	 * 查询满足条件的单个对象
	 
	 */
	public T loadOneObject(String sql,Class<T> clsace,Object...objects){
		Connection con = connectionace.getConection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			if(objects != null && objects.length > 0){
				for (int i = 0; i < objects.length; i++) {
					pst.setObject(i+1, objects[i]);
				}
			}
			ResultSet rs = pst.executeQuery();
			if(rs != null && rs.next()){
				//T t = clsace.newInstance();
				//对t对象的属性进行一一赋值
				return this.resolveResultSetToOjbect(rs, clsace);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			connectionace.close(con);
		}
		return null;
	}
	/**
	 * 查询满足条件的数据
	 * @return
	 */
	public List<T> loadAllObjects(String sql,Class<T> clsace,Object...objects){
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
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
		       connectionace.close(con);
		}
		return null;
	}
	
	public int alterObject(String sql,Object ... objects){
		Connection con = connectionace.getConection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
		       
			if(objects != null && objects.length > 0){
				for (int i = 0; i < objects.length; i++) {
					pst.setObject(i+1, objects[i]);
				}
			}
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			connectionace.close(con);
		}
		return 0;
	}
}

