package just.met.springboot.线程.thread_local.impl;

import just.met.springboot.线程.thread_local.CountTestService;
import org.springframework.stereotype.Service;

/**
 * 使用ThreadLocal测试
 * @author wangmaogang
 */
@Service("CountTestServiceImpl")
public class CountTestServiceImpl implements CountTestService {

    private ThreadLocal<Integer> local = new ThreadLocal<>();

    @Override
    public void countAdd(){

        System.out.println("CountTestServiceImpl-countAdd():"+Thread.currentThread().getName());

        if(local.get() == null){
            this.initLocalCountCache();
        }
        int count = local.get() + 1;
        local.set(count);

    }

    @Override
    public int getCount() {

        if(local.get() != null){
            return local.get();
        }

        return 0;
    }

    @Override
    public void clearCache() {
        this.destroyLocalCountCache();
    }

    /**
     * 为每个线程初始化独有的业务数量
     */
    private void initLocalCountCache(){

        if(local.get() == null){
            local.set(0);
        }
    }

    /**
     * 销毁每个线程的业务数量
     */
    private void destroyLocalCountCache(){
        if (local.get() != null){
            local.remove();
        }
    }
}
