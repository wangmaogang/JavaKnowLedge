package just.met.springboot.注解.service;

import just.met.springboot.注解.dao.AnnotationTestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author wangmaogang
 */
@Service
public class AnnotationTestService {

    @Autowired
    AnnotationTestDao annotationTestDao;
    public void printStr(){
        annotationTestDao.printStr();
    }

}
