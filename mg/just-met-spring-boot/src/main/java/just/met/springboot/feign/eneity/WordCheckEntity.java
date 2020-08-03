package just.met.springboot.feign.eneity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangmaogang
 */
@Data
public class WordCheckEntity implements Serializable {

    /**
     * word文档路径
     */
    private List<String> FilePathList;

}
