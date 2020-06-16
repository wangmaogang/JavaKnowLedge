package just.met.springboot.设计模式.strategy;

import just.met.springboot.feign.eneity.Result;
import just.met.springboot.设计模式.eneity.DailyManagerInfo;

/**
 * 日常管理策略接口类
 */
public interface BaseDailyManagerStrategy {

    /**
     * 当前类型
     * @return
     */
    String getType();

    /**
     * 策略执行
     * @param dailyManagerInfo 基本请求参数
     * @return
     */
    Result execute(DailyManagerInfo dailyManagerInfo);

    /**
     * 策略执行完成，方法回调
     * @param dailyManagerInfo
     * @return
     */
    Result callback(DailyManagerInfo dailyManagerInfo);

}
