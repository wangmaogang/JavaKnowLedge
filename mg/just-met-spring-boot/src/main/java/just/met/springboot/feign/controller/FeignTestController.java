package just.met.springboot.feign.controller;

import just.met.springboot.feign.eneity.Result;
import just.met.springboot.feign.eneity.WordMergeEntity;
import just.met.springboot.feign.service.WordProcessService;
import just.met.springboot.feign.eneity.WordSignEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

        String filePath = "C:\\Users\\noah\\Desktop\\出错证书.docx";
        String elePath = "C:\\Users\\noah\\Desktop\\9dIQ1FZsxQJc414s.bmp";
        String parameter = "【批准人】";

        WordSignEntity wordSignEntity = new WordSignEntity();
        wordSignEntity.setFilePath(filePath);
        wordSignEntity.setElectronicFilePath(elePath);
        wordSignEntity.setParameter(parameter);
        Result r = wordProcessService.writeSignature(wordSignEntity);
        return r;
    }

    @GetMapping("test2")
    public Result FeignTest2(){

        List<String> list = new ArrayList<String>();
        String filePath_1 = "C:\\Users\\noah\\Desktop\\诺亚总则-6.pdf";
        String filePath_2 = "C:\\Users\\noah\\Desktop\\过程控制文件V3.0.pdf";
        String newFilePath = "C:\\Users\\noah\\Desktop\\合并文档.pdf";
        list.add(filePath_1);
        list.add(filePath_2);
        WordMergeEntity wordMergeEntity = new WordMergeEntity();
        wordMergeEntity.setFilePathList(list);
        wordMergeEntity.setNewFilePath(newFilePath);
        wordMergeEntity.setType(1);

        Result r = wordProcessService.MergeWordFiles(wordMergeEntity);
        return r;
    }
}
