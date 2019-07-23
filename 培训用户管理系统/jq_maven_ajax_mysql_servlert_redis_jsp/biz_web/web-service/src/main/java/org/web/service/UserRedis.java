package org.web.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;


import redis.clients.jedis.Jedis;

public class UserRedis {
     protected static Jedis jedis=ConnectRedis.getJedis();
     public static void insertUserlog(String name){
    	Date date = new Date();
		DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // HH表示24小时制；
		String time = dFormat.format(date);
    	jedis.lpush(name+"_log",time);
    	 
     }
     public static List<String> getUserLog(String name) {
		List<String> sList=jedis.lrange(name+"_log", 0,-1);
		return sList;
	}
}
