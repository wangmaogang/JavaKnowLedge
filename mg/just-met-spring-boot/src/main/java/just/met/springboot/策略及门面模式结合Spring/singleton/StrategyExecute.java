package just.met.springboot.策略及门面模式结合Spring.singleton;

import just.met.springboot.feign.eneity.Result;
import just.met.springboot.策略及门面模式结合Spring.eneity.DailyManagerInfo;

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
