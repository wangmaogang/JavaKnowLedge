package just.met.springboot.多线程.thread_local;


import just.met.springboot.多线程.thread_local.t1.CountTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 多线程下测试接口
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
     * 测试使用ThreadLocal
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
     * 测试不使用ThreadLocal
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
