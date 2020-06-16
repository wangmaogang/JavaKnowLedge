package just.met.springboot.redis.tools;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component
public class JedisTool {
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
     * 插入hash值
     *
     * @param key
     * @param field
     * @param value
     */
    public void hashSet(String key, String field, String value) {
        Jedis client = getJedis();
        try {
            client.hset(key, field, value);
        } finally {
            client.close();
        }

    }

    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     */
    public boolean existKey(String key) {
        Jedis client = getJedis();
        try {
            return client.exists(key);
        } finally {
            client.close();
        }
    }

    /**
     * 根据key设置过期时间
     *
     * @param key
     * @return
     */
    public Long expire(String key, int seconds) {
        Jedis client = getJedis();
        try {
            return client.expire(key, seconds);
        } finally {
            client.close();
        }
    }

    /**
     * 获取到期时间
     *
     * @param key
     * @return
     */
    public Long getExpire(String key) {
        Jedis client = getJedis();
        try {
            return client.ttl(key);
        } finally {
            client.close();
        }
    }

    /**
     * 插入map
     *
     * @param key
     * @param map
     */
    public void hmset(String key, Map<String, String> map) {
        Jedis client = getJedis();
        try {
            client.hmset(key, map);
        } finally {
            client.close();
        }
    }

    /**
     * 获取map
     *
     * @param key
     * @return
     */
    public Map<String, String> hgetAll(String key) {
        Jedis client = getJedis();
        try {
            return client.hgetAll(key);
        } finally {
            client.close();
        }
    }

    /**
     * 获取map中的key对应的value
     *
     * @param key
     * @param field
     * @return
     */
    public String hget(String key, String field) {
        Jedis client = getJedis();
        try {
            return client.hget(key, field);
        } finally {
            client.close();
        }
    }

    /**
     * 删除map中对应的key
     *
     * @param key
     * @param ids
     * @return
     */
    public Long hdel(String key, List<String> ids) {
        Jedis client = getJedis();
        try {
            return client.hdel(key, ids.stream().toArray(String[]::new));
        } finally {
            client.close();
        }
    }

    /**
     * 存数据至list尾部
     *
     * @param key
     * @param values
     * @return
     */
    public Long rpush(String key, String... values) {
        Jedis client = getJedis();
        try {
            return client.rpush(key, values);
        } finally {
            client.close();
        }
    }

    /**
     * 从list中取出指定位置的数据
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<String> lrange(String key, Long start, Long end) {
        Jedis client = getJedis();
        try {
            return client.lrange(key, start, end);
        } finally {
            client.close();
        }
    }

    /**
     * 获取list长度
     *
     * @param key
     * @return
     */
    public Long llen(String key) {
        Jedis client = getJedis();
        try {
            return client.llen(key);
        } finally {
            client.close();
        }
    }

    /**
     * 删除list中指定的数据
     * count > 0 : 从表头开始向表尾搜索，移除与 value 相等的元素，数量为 count 。
     * count < 0 : 从表尾开始向表头搜索，移除与 value 相等的元素，数量为 count 的绝对值。
     * count = 0 : 移除表中所有与 value 相等的值。
     *
     * @param key
     * @param count
     * @param value
     * @return
     */
    public Long lrem(String key, long count, String value) {
        Jedis client = getJedis();
        try {
            return client.lrem(key, count, value);
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
    public Long del(String key) {
        Jedis client = getJedis();
        try {
            return client.del(key);
        } finally {
            client.close();
        }
    }

    /**
     * 加锁
     *
     * @param key
     * @param value
     * @return
     */
    public String setnx(String key, String value) {
        Jedis client = getJedis();
        try {
            //NX是不存在时才set， XX是存在时才set， EX是秒，PX是毫秒
            //有效期为1天
            SetParams setParams = new SetParams();
            setParams.ex(60 * 60 * 24);
            setParams.nx();
            return client.set(key, value, setParams);
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
}
