package just.met.springboot.test1;

import org.springframework.stereotype.Service;

/**
 * @author wangmaogang
 */
@Service
public class MgService {

    private Long MgServiceId = System.currentTimeMillis();

    public String printStr(){
        System.out.println("MgServiceId:"+MgServiceId);
        return String.valueOf(System.currentTimeMillis());
    }

}
