package just.met.springboot.idemp.service.impl;

import just.met.springboot.idemp.service.IdempotenceStorage;
import just.met.springboot.idemp.tools.RedisTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 幂等号存储-Redis实现
 * @author wangmaogang
 */
@Component
@Slf4j
public class RedisIdempotenceStorage implements IdempotenceStorage {

    @Resource
    RedisTool redisTool;

    /**
     * setnx设置成功返回“OK”
     */
    private final String successFlag  = "OK";

    @Override
    public boolean save(String key) {

        //如果不存在，则set,成功返回“OK”；如果存在，则失败，返回NULL
        String result = redisTool.setnx(key, UUID.randomUUID().toString(), 60);
        if(result != null && successFlag.equals(result)){
            return true;
        }
        return false;
    }

    @Override
    public void delete(String key) {
        redisTool.delete(key);
    }
}
