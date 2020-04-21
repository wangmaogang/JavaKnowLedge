package just.met.springboot.test1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口
 * @author wangmaogang
 */

@RestController
@RequestMapping("test2")
public class Test2Controller {

    @Autowired
    MgService mgService;

    MgService newMgService = new MgService();

    @RequestMapping(value = "get",method = RequestMethod.GET)
    public String get() {
        System.out.println("newMgService:"+newMgService.printStr());
        return "test2"+mgService.printStr();
    }

}
