package just.met.springboot.idemp;


import just.met.springboot.idemp.aspect.IdempotenceOperate;
import just.met.springboot.idemp.eneity.R;
import just.met.springboot.idemp.eneity.RequestInfo;
import just.met.springboot.idemp.service.impl.FixedIdempotenceIdGenerator;
import just.met.springboot.idemp.tools.MethodParamTools;
import just.met.springboot.idemp.tools.RedisTool;
import just.met.springboot.redis.service.RedisSeqCreateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Redis并发测试接口
 *
 * @author wangmaogang
 */

@RestController
@RequestMapping("idempotence")
@Slf4j
public class IdempotenceController {

    @Resource
    RedisTool redisTool;

    /**
     * 幂等操作测试
     *
     * @return
     */
    @IdempotenceOperate(businessId = "bId")
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public R test(String bId, String status) throws InterruptedException {
        log.info("bId:" + bId + ",status:" + status);
        Thread.sleep(10000);
        return R.ok();
    }

    /**
     * redis操作测试
     *
     * @return
     */
    @RequestMapping(value = "test2", method = RequestMethod.GET)
    public R test2(String content) {
        String result = redisTool.setnx(content, UUID.randomUUID().toString(),60);
        return R.ok(result);
    }
}
