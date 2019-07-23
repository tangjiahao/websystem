package org.web.service;

import redis.clients.jedis.Jedis;

public class ConnectRedis {
	public static Jedis getJedis() {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		return jedis;
	}
	

}
