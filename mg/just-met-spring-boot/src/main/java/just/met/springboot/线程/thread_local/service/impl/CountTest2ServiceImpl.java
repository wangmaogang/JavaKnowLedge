package just.met.springboot.线程.thread_local.service.impl;

import just.met.springboot.线程.thread_local.service.CountTestService;
import org.springframework.stereotype.Service;

/**
 * 不使用ThreadLocal测试
 * @author wangmaogang
 */
@Service("CountTest2ServiceImpl")
public class CountTest2ServiceImpl implements CountTestService {

    private Integer local = 0;

    @Override
    public void countAdd(){
        local++;
    }

    @Override
    public int getCount() {
        return local;
    }

    @Override
    public void clearCache() {
        this.destroyLocalCountCache();
    }


    /**
     * 销毁每个线程的业务数量
     */
    private void destroyLocalCountCache(){

    }
}
