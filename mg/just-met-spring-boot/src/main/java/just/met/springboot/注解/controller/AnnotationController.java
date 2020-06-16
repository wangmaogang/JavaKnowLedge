package just.met.springboot.注解.controller;


import just.met.springboot.注解.service.AnnotationTestService;
import org.springframework.context.annotation.Lazy;
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
    AnnotationTestService annotationTestService;

    AnnotationTestService annotationTestServiceNoDi = new AnnotationTestService();

    /**
     * Dao/Service都已注入，正常执行
     * @return
     */
    @RequestMapping(value = "di",method = RequestMethod.GET)
    public String diTest() {
        annotationTestService.printStr();
        return "diTest";
    }

    /**
     * Dao注入，但Service是new实例，不能调用Dao，会报空指针
     * @return
     */
    @RequestMapping(value = "noDi",method = RequestMethod.GET)
    public String noDiTest() {
        annotationTestServiceNoDi.printStr();
        return "noDiTest";
    }

}
