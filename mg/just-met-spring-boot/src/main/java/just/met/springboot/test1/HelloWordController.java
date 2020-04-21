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
@RequestMapping("helloWorld")
public class HelloWordController {

    @Autowired
    MgService mgService;

    @RequestMapping(value = "get",method = RequestMethod.GET)
    public String get() {
        return "hello world"+mgService.printStr();
    }

}
