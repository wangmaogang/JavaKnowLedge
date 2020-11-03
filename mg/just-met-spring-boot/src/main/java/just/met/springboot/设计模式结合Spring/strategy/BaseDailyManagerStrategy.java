package just.met.springboot.设计模式结合Spring.strategy;

import just.met.springboot.feign.eneity.Result;
import just.met.springboot.设计模式结合Spring.eneity.DailyManagerInfo;

/**
 * 日常管理策略接口类
 * @author wangmaogang
 */
public interface BaseDailyManagerStrategy {

    /**
     * 当前类型
     * @return 返回当前类型
     */
    String getType();

    /**
     * 策略执行
     * @param dailyManagerInfo 基本请求参数
     * @return 返回执行结果
     */
    Result execute(DailyManagerInfo dailyManagerInfo);

    /**
     * 策略执行完成，方法回调
     * @param dailyManagerInfo 基本请求参数
     * @return 返回执行结果
     */
    Result callback(DailyManagerInfo dailyManagerInfo);

}
