package just.met.springboot.idemp;

import just.met.springboot.idemp.service.IdempotenceStorage;
import org.springframework.stereotype.Component;

/**
 * 幂等函数
 * @author wangmaogang
 */
public class Idempotence{

    private IdempotenceStorage idempotenceStorage;

    public  Idempotence(IdempotenceStorage idempotenceStorage){
        this.idempotenceStorage = idempotenceStorage;
    }

    public boolean save(String key) {
        return idempotenceStorage.save(key);
    }

    public void delete(String key) {
        idempotenceStorage.delete(key);
    }
}
