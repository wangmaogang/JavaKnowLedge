package just.met.springboot.redis.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @description: Redis生成序号工具（原子）
 * @author wangmaogang
 */
@Component
public class RedisSequenceUtil {

    private static String KEY_PREFIX = "seq_";

    @Resource
    RedisTemplate dictRedisTemplate;

    /**
     * 获取序列号(仅获取)
     *
     * @param key
     * @return
     */
    public Long getNow(String key) {
        if (key == null) {
            return null;
        }
        RedisAtomicLong seqAtomic = new RedisAtomicLong(KEY_PREFIX + key, dictRedisTemplate.getConnectionFactory());
        Long seq = seqAtomic.get();
        return seq;
    }

    /**
     * 获取当前序列号(会自增+1)
     * @param key
     * @return
     */
    public Long getIncr(String key){
        if(key==null){
            return null;
        }
        RedisAtomicLong seqAtomic = new RedisAtomicLong(KEY_PREFIX+key,dictRedisTemplate.getConnectionFactory());
        Long seq = seqAtomic.getAndIncrement();

        return seq;
    }

    /**
     * 设置当前序列号
     * @param key
     * @param nowValue
     * @return
     */
    public boolean setIncr(String key,Long nowValue){
        RedisAtomicLong seqAtomic = new RedisAtomicLong(KEY_PREFIX+key,dictRedisTemplate.getConnectionFactory());
        if(seqAtomic.compareAndSet(0L,nowValue)){
            System.out.println("compareAndSet:true");
            return true;
        }
        return false;
    }


}

