package just.met.springboot.redis.controller;


import just.met.springboot.redis.service.RedisSeqCreateService;
import just.met.springboot.redis.tools.RedisSequenceUtil;
import just.met.springboot.注解.service.AnnotationTestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Redis并发测试接口
 * @author wangmaogang
 */

@RestController
@RequestMapping("redis")
public class RedisController {

    @Resource
    RedisSeqCreateService redisSeqCreateService;

    String key = "NEW_KEY";

    /**
     * RedisAtomicLong原子操作获取序列号，不存在重号问题
     * @return
     */
    @RequestMapping(value = "getNextSeqNum",method = RequestMethod.GET)
    public String getNextSeqNum() {
        return "结果："+redisSeqCreateService.getNextSeqNum(key);
    }

}
