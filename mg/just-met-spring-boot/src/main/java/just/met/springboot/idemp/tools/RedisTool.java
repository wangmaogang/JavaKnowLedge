package just.met.springboot.idemp.tools;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import javax.annotation.Resource;

/**
 * Jedis工具类
 * @author wangmaogang
 */
@Component
public class RedisTool {

    @Resource
    private JedisPool jedisPool;

    private Jedis getJedis() {
        return jedisPool.getResource();
    }

    /**
     * 插入字符串
     *
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        Jedis client = getJedis();
        try {
            client.set(key, value);
        } finally {
            client.close();
        }
    }

    /**
     * 根据key获取字符串
     *
     * @param key
     * @return
     */
    public String get(String key) {
        Jedis client = getJedis();
        try {
            return client.get(key);
        } finally {
            client.close();
        }
    }

    /**
     * 判定key是否存在
     *
     * @param key
     * @return
     */
    public boolean exists(String key) {
        Jedis client = getJedis();
        try {
            return client.exists(key);
        } finally {
            client.close();
        }
    }

    /**
     * 不存在时才set,并设置过期时间
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    public String setnx(String key, String value,int expireTime) {
        Jedis client = getJedis();
        try {
            // NX是不存在时才set， 即创建键值对之前先判断是否存在，存在则不创建;XX是存在时才set
            // EX是秒，PX是毫秒
            // 高版本 redis client 使用: client.set(key, value, SetParams.setParams().nx().ex(expireTime));
            // 低版本 redis client 使用 ：client.set(key, value, "NX","EX",expireTime);
            return client.set(key, value, SetParams.setParams().nx().ex(expireTime));
        } finally {
            client.close();
        }
    }

    /**
     * 写入新值，返回旧值
     *
     * @param key
     * @return
     */
    public String getSet(String key, String value) {
        Jedis client = getJedis();
        try {
            return client.getSet(key, value);
        } finally {
            client.close();
        }
    }

    /**
     * 删除数据
     *
     * @param key
     * @return
     */
    public Long delete(String key) {
        Jedis client = getJedis();
        try {
            return client.del(key);
        } finally {
            client.close();
        }
    }
}
