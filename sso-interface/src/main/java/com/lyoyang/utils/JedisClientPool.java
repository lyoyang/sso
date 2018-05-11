package com.lyoyang.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

public class JedisClientPool implements JedisClient {

    private JedisPool jedisPool;

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    @Override
    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String res = jedis.set(key, value);
        jedis.close();
        return res;
    }

    @Override
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String res = jedis.get(key);
        jedis.close();
        return res;
    }

    @Override
    public Boolean exists(String key) {
        Jedis jedis = jedisPool.getResource();
        Boolean res = jedis.exists(key);
        jedis.close();
        return res;
    }

    @Override
    public Long expire(String key, int seconds) {
        Jedis jedis = jedisPool.getResource();
        Long res = jedis.expire(key, seconds);
        jedis.close();
        return res;
    }

    @Override
    public Long ttl(String key) {
        Jedis jedis = jedisPool.getResource();
        Long res = jedis.ttl(key);
        jedis.close();
        return res;
    }

    @Override
    public Long incr(String key) {
        Jedis jedis = jedisPool.getResource();
        Long res = jedis.incr(key);
        jedis.close();
        return res;
    }

    @Override
    public Long hset(String key, String field, String value) {
        Jedis jedis = jedisPool.getResource();
        Long res = jedis.hset(key, field, value);
        jedis.close();
        return res;
    }

    @Override
    public String hget(String key, String field) {
        Jedis jedis = jedisPool.getResource();
        String res = jedis.hget(key, field);
        jedis.close();
        return res;
    }

    @Override
    public Long hdel(String key, String... field) {
        Jedis jedis = jedisPool.getResource();
        Long res = jedis.hdel(key, field);
        jedis.close();
        return res;
    }

    @Override
    public Boolean hexists(String key, String field) {
        Jedis jedis = jedisPool.getResource();
        Boolean res = jedis.hexists(key, field);
        jedis.close();
        return res;
    }

    @Override
    public List<String> hvals(String key) {
        Jedis jedis = jedisPool.getResource();
        List<String> res = jedis.hvals(key);
        jedis.close();
        return res;
    }

    @Override
    public Long del(String key) {
        Jedis jedis = jedisPool.getResource();
        Long res = jedis.del(key);
        jedis.close();
        return res;
    }
}
