package just.met.springboot.设计模式结合Spring.strategy.impl;

import just.met.springboot.feign.eneity.Result;
import just.met.springboot.设计模式结合Spring.define.DailyManagerStatus;
import just.met.springboot.设计模式结合Spring.eneity.DailyManagerInfo;
import just.met.springboot.设计模式结合Spring.strategy.BaseDailyManagerStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import static just.met.springboot.设计模式结合Spring.singleton.StrategyExecuteSingletonEnum.*;

/**
 * 策略实现类二
 * @author wangmaogang
 */
@Component
@Slf4j
public class SecondStrategy implements BaseDailyManagerStrategy {


    @Override
    public String getType() {
        return DailyManagerStatus.SECOND;
    }

    @Override
    public Result execute(DailyManagerInfo dailyManagerInfo) {
        log.info("SecondStrategy.execute");
        return INSTANCE.getInstance().execute(dailyManagerInfo);
    }


    @Override
    public Result callback(DailyManagerInfo dailyManagerInfo) {
        log.info("SecondStrategy.callback");
        return Result.ok();
    }
}
