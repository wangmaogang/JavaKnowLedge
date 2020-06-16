package just.met.springboot.feign;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangmaogang
 */
@Data
public class WordSignEntity implements Serializable {

    /**
     * word文档路径
     */
    private String FilePath;

    /**
     * 电子签名路径
     */
    private String ElectronicFilePath;

    /**
     * 替换参数名称
     */
    private String Parameter;
}
