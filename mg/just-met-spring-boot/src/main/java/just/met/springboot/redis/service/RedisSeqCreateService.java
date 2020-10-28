package just.met.springboot.redis.service;

import just.met.springboot.config.db.DataSourceNames;
import just.met.springboot.config.db.annotation.DataSource;
import just.met.springboot.redis.dao.RedisNumDao;
import just.met.springboot.redis.tools.RedisSequenceUtil;
import just.met.springboot.redis.tools.date.LocalDataConvertTools;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static java.time.format.DateTimeFormatter.BASIC_ISO_DATE;

/**
 * @author wangmaogang
 */
@Service
public class RedisSeqCreateService {

    @Resource
    RedisSequenceUtil redisSequenceUtil;

    @Autowired(required = false)
    @Lazy
    RedisNumDao redisNumDao;

    /**
     * 获取对应key的序号，采用redis的原子操作（并发情况下不会产生重号问题）
     * 逻辑概述：
     * 流水号 = "SQBH" + 8位年月 + 4位流水号
     * #情况1：redis有值，直接取出，+1后更新redis,然后返回
     * #情况2：redis没有值，去数据库查找当前最大编号，+1后更新redis,然后返回
     *
     * @param key
     * @return
     */
    public String getNextSeqNum(String key) {

        String numPrefix = "SQBH";
        String nowDate = LocalDataConvertTools.getNowData(BASIC_ISO_DATE);

        //获取当前序号
        long nowNum = redisSequenceUtil.getNow(key);
        //如果redis宕机重启或首次记录此key，此时nowNum为0,去查看数据库是否已经有数值
        if (nowNum == 0) {
            //1.先去数据库查找当日最大编号,新编号 = 当日最大编号 + 1,即如果为0自动设置为1
            long nowValue = getSecondDbNowDayMaxNum() + 1;
            nowValue = (nowValue == 0 ? 1 : nowValue);
            //2.设置当前编号，setIncr方法采用CAS实现原子操作,不管多少线程同时进入此,只会set一次
            redisSequenceUtil.setIncr(key, nowValue);
        }
        //获取最新的自增编号
        nowNum = redisSequenceUtil.getIncr(key);
        String flowNum = numPrefix + nowDate + StringUtils.leftPad("" + nowNum, 4, "0");
        ;
        return flowNum;
    }

    /**
     * 获取First数据库当天最大的编号,若不存在，返回0
     *
     * @return
     */
    public Integer getFirstDbNowDayMaxNum() {
        Integer num = redisNumDao.getNowDayMaxNum();
        if (null == num) {
            return 0;
        }
        return num;
    }

    /**
     * 获取Second数据库当天最大的编号,若不存在，返回0
     *
     * @return
     */
    @DataSource(name = DataSourceNames.SECOND)
    public Integer getSecondDbNowDayMaxNum() {
        Integer num = redisNumDao.getNowDayMaxNum();
        if (null == num) {
            return 0;
        }
        return num;
    }
}
