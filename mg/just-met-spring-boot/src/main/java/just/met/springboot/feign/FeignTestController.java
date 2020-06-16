package just.met.springboot.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangmaogang
 */
@RestController
@RequestMapping("api/feign")
public class FeignTestController {

    @Resource
    WordProcessService wordProcessService;

    @GetMapping("test1")
    public Result FeignTest(){

        String filePath = "C:\\Users\\wangmaogang\\Desktop\\出错证书.docx";
        String elePath = "C:\\Users\\wangmaogang\\Desktop\\9dIQ1FZsxQJc414s.bmp";
        String parameter = "【批准人】";

        WordSignEntity wordSignEntity = new WordSignEntity();
        wordSignEntity.setFilePath(filePath);
        wordSignEntity.setElectronicFilePath(elePath);
        wordSignEntity.setParameter(parameter);

        Result r = wordProcessService.writeSignature(wordSignEntity);
        return r;
    }

}
