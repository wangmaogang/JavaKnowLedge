package just.met.springboot.设计模式.config;

import just.met.springboot.设计模式.strategy.BaseDailyManagerStrategy;
import just.met.springboot.设计模式.context.DailyManagerContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 日常管理策略装载类
 */
@Configuration
public class DailyManagerConfiguration {

    @Bean
    public DailyManagerContext loadDailyManagerStrategy(ApplicationContext context){

        DailyManagerContext dailyManagerContext = new DailyManagerContext();
        //策略类Map集合
        Map<String, BaseDailyManagerStrategy> managerStrategyMap = new HashMap<>();
        //获取容器中指定类
        Map strategyMap = context.getBeansOfType(BaseDailyManagerStrategy.class);
        List<BaseDailyManagerStrategy> list = new ArrayList<>(strategyMap.values());
        if(list != null && list.size() > 0){
            for(BaseDailyManagerStrategy baseDailyManagerStrategy : list){
                managerStrategyMap.put(baseDailyManagerStrategy.getType(),baseDailyManagerStrategy);
            }
        }
        //返回策略类Map集合
        dailyManagerContext.setManagerStrategyMap(managerStrategyMap);
        return dailyManagerContext;

    }

}
