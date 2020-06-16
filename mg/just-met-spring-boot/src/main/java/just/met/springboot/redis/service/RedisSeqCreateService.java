package just.met.springboot.redis.service;

import just.met.springboot.redis.tools.JedisTool;
import just.met.springboot.redis.tools.RedisSequenceUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wangmaogang
 */
@Service
public class RedisSeqCreateService {

    @Resource
    JedisTool jedisTool;

    @Resource
    RedisSequenceUtil redisSequenceUtil;

    /**
     * 普通获取序号方法，存在并发问题
     * @param dataKey
     * @return
     */
    public int getVolumeNextNum(String dataKey) {

        //默认初始编号为0
        String lastNum;

        //情况1：redis有值，直接取出
        if (jedisTool.existKey(dataKey)) {
            lastNum = jedisTool.get(dataKey);
        }
        //情况2：redis没有值，去数据库查找当前最大编号
        else {
            lastNum = "0";
        }

        //如果lastNum为空值，则置为0
        if (lastNum == null || lastNum.equals("")) {
            lastNum = "0";
        }
        //编号+1后更新redis，并设置过期时间
        int nextNum = Integer.valueOf(lastNum) + 1;
        jedisTool.set(dataKey, String.valueOf(nextNum));
        return nextNum;
    }

    /**
     * 获取对应key的序号（并发情况下不会产生重号问题）
     *
     * @param key
     * @return
     */
    public long getSeqNum(String key) throws InterruptedException {

        //获取当前序号
        long nowNum = redisSequenceUtil.getNow(key);
        //如果redis宕机重启或首次记录此key，此时nowNum为0,去查看数据库是否已经有数值
        if (nowNum == 0) {
            System.out.println("不存在此key，进入方法set");
            //1.先去数据库查找当前最大编号
            //模拟耗时查询1s
            Thread.sleep(1000);
            //假设当前是5
            long nowValue = 5L;
            //2.设置当前编号，setIncr方法采用CAS实现原子操作,不管多少线程同时进入此,只会set一次
            redisSequenceUtil.setIncr(key, nowValue);
        }
        nowNum = redisSequenceUtil.getIncr(key);
        System.out.println("当前序号：" + nowNum);
        return nowNum;
    }
}
