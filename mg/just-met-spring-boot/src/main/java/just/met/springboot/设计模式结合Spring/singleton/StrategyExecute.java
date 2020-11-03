package just.met.springboot.设计模式结合Spring.singleton;

import just.met.springboot.feign.eneity.Result;
import just.met.springboot.设计模式结合Spring.eneity.DailyManagerInfo;
import lombok.extern.slf4j.Slf4j;

/**
 * 策略执行类
 * @author wangmaogang
 */
public class StrategyExecute{
    /**
     * 策略执行
     *
     * @param dailyManagerInfo 基本请求参数
     * @return 返回执行结果
     */
    public Result execute(DailyManagerInfo dailyManagerInfo) {
        return Result.ok();
    }
}
