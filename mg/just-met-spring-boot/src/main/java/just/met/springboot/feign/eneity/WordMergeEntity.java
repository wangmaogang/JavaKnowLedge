package just.met.springboot.feign.eneity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangmaogang
 */
@Data
public class WordMergeEntity implements Serializable {

    /**
     * 原word文档路径集合
     */
    private List<String> FilePathList;

    /**
     * 生成的新word文档路径
     */
    private String NewFilePath;

    /**
     * 转换类型
     * 0:直接将word文档合并成一个word文档，返回的是word文档的路径，操作较快
     * 1.将所有PDF合并成一个PDF，操作较慢
     */
    private int Type;
}
