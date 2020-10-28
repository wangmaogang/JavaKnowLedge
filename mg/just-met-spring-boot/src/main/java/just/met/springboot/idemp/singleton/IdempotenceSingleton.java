package just.met.springboot.idemp.singleton;

import just.met.springboot.idemp.Idempotence;
import just.met.springboot.idemp.service.impl.RedisIdempotenceStorage;
import just.met.springboot.设计模式.utils.SpringBeanFactoryUtils;

import javax.annotation.Resource;

/**
 * 幂等函数单例类
 * 枚举类型是线程安全的，并且只会装载一次
 * @author wangmaogang
 */
public enum IdempotenceSingleton {

    INSTANCE;

    private Idempotence instance;

    IdempotenceSingleton(){
        instance = new Idempotence(SpringBeanFactoryUtils.getBean(RedisIdempotenceStorage.class));
    }

    public Idempotence getInstance(){
        return instance;
    }

}