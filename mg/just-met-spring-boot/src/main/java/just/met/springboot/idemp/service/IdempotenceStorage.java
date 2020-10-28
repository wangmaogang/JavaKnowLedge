package just.met.springboot.idemp.service;

/**
 * 幂等号存储接口
 * @author wangmaogang
 */
public interface IdempotenceStorage {

    /**
     * 幂等key存储
     * @param key 需要存储的键
     * @return 如果key不存在，则新增，并返回true;如果key存在，则返回false
     */
    boolean save(String key);

    /**
     * 幂等key删除
     * @param key 需要存储的键
     */
    void delete(String key);
}
