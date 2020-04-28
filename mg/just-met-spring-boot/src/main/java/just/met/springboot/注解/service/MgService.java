package just.met.springboot.注解.service;

import just.met.springboot.注解.dao.MgDiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangmaogang
 */
@Service
public class MgService {

    @Autowired
    MgDiDao mgDaoDi;
    public void printStrDi(){
        mgDaoDi.printStr();
    }

}
