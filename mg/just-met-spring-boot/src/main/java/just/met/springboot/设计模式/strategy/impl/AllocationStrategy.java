package just.met.springboot.设计模式.strategy.impl;

import just.met.springboot.feign.eneity.Result;
import just.met.springboot.设计模式.define.DailyManagerStatus;
import just.met.springboot.设计模式.eneity.DailyManagerInfo;
import just.met.springboot.设计模式.strategy.BaseDailyManagerStrategy;
import just.met.springboot.设计模式.utils.StrategyExecuteSingleton;
import org.springframework.stereotype.Component;


/**
 * 策略实现类一
 * @author noah
 */
@Component
public class AllocationStrategy implements BaseDailyManagerStrategy {


    @Override
    public String getType() {
        return DailyManagerStatus.allocation;
    }

    @Override
    public Result execute(DailyManagerInfo dailyManagerInfo) {
        return StrategyExecuteSingleton.getInstance().execute(dailyManagerInfo);
    }


    @Override
    public Result callback(DailyManagerInfo dailyManagerInfo) {
        return null;
    }
}
