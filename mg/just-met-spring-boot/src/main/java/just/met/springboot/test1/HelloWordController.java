package just.met.springboot.test1;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口
 */

@RestController
@RequestMapping("helloWorld")
public class HelloWordController {

    @RequestMapping(value = "get",method = RequestMethod.GET)
    public String get() {
        return "hello world";
    }

}
