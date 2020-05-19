package just.met.springboot.注解.dao;

import org.springframework.stereotype.Component;

/**
 * @author wangmaogang
 */
@Component
public class AnnotationTestDao {

    public void printStr(){
        System.out.println("MgDaoDi:@Component注入");
    }

}
