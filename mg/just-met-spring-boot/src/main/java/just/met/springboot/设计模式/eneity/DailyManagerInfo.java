package just.met.springboot.设计模式.eneity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 请求参数
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyManagerInfo {
    /**
     * 请求的基本信息
     */
    private BaseRequestInfo baseRequestInfo;

    /**
     * 前端请求的json参数
     */
    private String jsonData;

    /**
     * 当前执行策略类型
     */
    private String type;

}
