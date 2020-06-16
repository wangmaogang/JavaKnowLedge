package just.met.springboot.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 调用 .NET Spire.Doc
 * @author wangchuncheng
 * @date 20200522
 *
 * */
@FeignClient(name = "${feign.client.wordprocess.name}", url = "${feign.client.wordprocess.url}")
public interface WordProcessService {

    /**
     * Word 文本内容替换
     * @param filePath  需要操作的文件路径
     * @param newFilePath 返回文件路径
     * @param data json 需要替换的文本
     * @return R 结果
     * */
    @PostMapping(value = "/api/word/paramConvert", headers = "Content-Type: application/x-www-form-urlencoded")
    Result paramConvert(@RequestParam("filePath") String filePath,@RequestParam("newFilePath") String newFilePath,@RequestParam("data") String data);


    /**
     * Word 写入签名
     * @param wordSignEntity
     * @return R 结果
     * */
    @RequestMapping(value = "/api/word/writeSignature", method = RequestMethod.POST)
    Result writeSignature(@RequestBody WordSignEntity wordSignEntity);


}
