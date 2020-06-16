package just.met.springboot.线程.thread_local.controller;


import just.met.springboot.线程.thread_local.service.CountTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 多线程下ThreadLocal测试
 *
 * springboot自动装载bean，countTestService是单例模式，全局只有一个实例，
 * 每次调用都使用同一个实例，若不使用ThreadLocal，则实例里的变量会累加
 * @author wangmaogang
 */

@RestController
@RequestMapping("thread/local")
public class ThreadLocalTestController {

    @Autowired
    @Qualifier("CountTestServiceImpl")
    CountTestService countTestService;

    @Autowired
    @Qualifier("CountTest2ServiceImpl")
    CountTestService countTest2Service;

    /**
     * 使用ThreadLocal，每次请求都创建线程,变量不会累加
     * @return
     */
    @RequestMapping(value = "t1",method = RequestMethod.GET)
    public String t1(){

        System.out.println("ThreadLocalTestController-t1():"+Thread.currentThread().getName());

        countTestService.countAdd();
        countTestService.countAdd();

        int outCount = countTestService.getCount();
        countTestService.clearCache();

        return "输出：" + outCount;
    }

    /**
     * 不使用ThreadLocal，变量会累加
     *
     * @return
     */
    @RequestMapping(value = "t2",method = RequestMethod.GET)
    public String t2(){

        System.out.println("ThreadLocalTestController-t2():"+Thread.currentThread().getName());

        countTest2Service.countAdd();
        countTest2Service.countAdd();

        int outCount = countTest2Service.getCount();

        return "输出：" + outCount;
    }

}
