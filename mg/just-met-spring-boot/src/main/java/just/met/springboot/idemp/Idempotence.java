package just.met.springboot.idemp;

import just.met.springboot.idemp.service.IdempotenceStorage;
import org.springframework.stereotype.Component;

/**
 * 幂等函数
 * @author wangmaogang
 */
public class Idempotence{

    /**
     * 具体存储方式实例方法
     */
    private final IdempotenceStorage idempotenceStorage;

    public  Idempotence(IdempotenceStorage idempotenceStorage){
        this.idempotenceStorage = idempotenceStorage;
    }

    /**
     * 存储key
     * @param key 业务主键
     * @return 返回成功失败
     */
    public boolean save(String key) {
        return idempotenceStorage.save(key);
    }

    /**
     * 删除key
     * @param key 业务主键
     */
    public void delete(String key) {
        idempotenceStorage.delete(key);
    }
}
