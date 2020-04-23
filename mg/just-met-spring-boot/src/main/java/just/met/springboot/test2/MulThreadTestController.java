package just.met.springboot.test2;


import just.met.springboot.test1.service.MgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 多线程下测试接口
 * @author wangmaogang
 */

@RestController
@RequestMapping("mul/thread")
public class MulThreadTestController {

    @RequestMapping(value = "t1",method = RequestMethod.GET)
    public String t1() {
        return "t1";
    }

}
