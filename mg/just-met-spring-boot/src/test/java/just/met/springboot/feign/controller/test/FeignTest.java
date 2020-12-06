package just.met.springboot.feign.controller.test;

import just.met.springboot.JustMetSpringBootApplication;
import just.met.springboot.feign.eneity.WordSignEntity;
import just.met.springboot.feign.service.WordProcessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;


@SpringBootTest(classes = JustMetSpringBootApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class FeignTest {

    @Resource
    WordProcessService wordProcessService;

    @Test
    public void feignTest() {
        String filepath = System.getProperty("user.dir")+"/a.xlsx";
        System.out.println(filepath);
        String filePath = "C:\\Users\\wangmaogang\\Desktop\\报告空白模板-写入数据前2.doc";
        String imgPath = "C:\\Users\\wangmaogang\\Desktop\\wordRange\\wordRange\\电子签名\\qianming.bmp";
        String param = "校核员";
        WordSignEntity wordSignEntity = new WordSignEntity();
        wordSignEntity.setFilePath(filePath);
        wordSignEntity.setElectronicFilePath(imgPath);
        wordSignEntity.setParameter(param);
        wordProcessService.writeSignature(wordSignEntity);
    }
}