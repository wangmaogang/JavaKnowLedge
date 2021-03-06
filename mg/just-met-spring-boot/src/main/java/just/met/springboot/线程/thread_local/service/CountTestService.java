package just.met.springboot.线程.thread_local.service;


import org.springframework.stereotype.Service;

/**
 * @author wangmaogang
 */
@Service
public interface CountTestService {

    /**
     * 数量新增
     */
    void countAdd();

    /**
     * 获取当前数量
     * @return
     */
    int getCount();

    /**
     * 清理缓存
     */
    void clearCache();
}
