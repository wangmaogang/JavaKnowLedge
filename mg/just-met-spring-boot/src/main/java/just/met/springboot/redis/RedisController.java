package just.met.springboot.redis;


import just.met.springboot.redis.service.RedisSeqCreateService;
import just.met.springboot.redis.tools.RedisSequenceUtil;
import just.met.springboot.注解.service.AnnotationTestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试接口
 * @author wangmaogang
 */

@RestController
@RequestMapping("redis")
public class RedisController {

    @Resource
    RedisSeqCreateService redisSeqCreateService;

    String key = "NEW_KEY_2";

    /**
     * RedisSeqCreateService获取
     * @return
     */
    @RequestMapping(value = "test1",method = RequestMethod.GET)
    public String test1() {
        return "结果："+redisSeqCreateService.getVolumeNextNum(key);
    }

    /**
     * RedisSequenceUtil获取序列号
     * @return
     */
    @RequestMapping(value = "test2",method = RequestMethod.GET)
    public String test2() throws InterruptedException {
        return "结果："+redisSeqCreateService.getSeqNum(key);
    }

}
