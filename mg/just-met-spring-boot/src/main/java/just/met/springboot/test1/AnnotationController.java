package just.met.springboot.test1;


import just.met.springboot.test1.service.MgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试接口
 * @author wangmaogang
 */

@RestController
@RequestMapping("annotation")
public class AnnotationController {

    @Resource
    MgService mgServiceDi;

    MgService mgServiceNoDi = new MgService();

    /**
     * Dao/Service都已注入，正常执行
     * @return
     */
    @RequestMapping(value = "di",method = RequestMethod.GET)
    public String mgServiceDi() {
        mgServiceDi.printStrDi();
        return "test1-Service-@Autowired";
    }

    /**
     * Dao注入，但Service是new实例，不能调用Dao，会报空指针
     * @return
     */
    @RequestMapping(value = "noDi",method = RequestMethod.GET)
    public String mgServiceNoDi() {
        mgServiceNoDi.printStrDi();
        return "test1-Service-new";
    }

}
