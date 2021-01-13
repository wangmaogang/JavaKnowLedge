package just.met.springboot.策略及门面模式结合Spring.context;

import just.met.springboot.feign.eneity.Result;
import just.met.springboot.策略及门面模式结合Spring.eneity.DailyManagerInfo;
import just.met.springboot.策略及门面模式结合Spring.ex.StrategyFailedException;
import just.met.springboot.策略及门面模式结合Spring.strategy.BaseDailyManagerStrategy;
import lombok.Data;

import java.util.Map;

/**
 * 日常管理上下文策略类
 * @author wangmaogang
 */
@Data
public class DailyManagerContext {

    /**
     * 策略Map集合
     */
    private Map<String, BaseDailyManagerStrategy> managerStrategyMap;
    /**
     * 请求参数线程级变量
     */
    private ThreadLocal<DailyManagerInfo> managerInfoThreadLocal;

    public Result executeStrategy(DailyManagerInfo dailyManagerInfo) throws StrategyFailedException.FailedExecute {

        //初始化创建 DailyManagerInfo 保存到 managerInfoThreadLocal
        createBusinessCache(dailyManagerInfo);

        if(managerInfoThreadLocal.get() != null){
            try {
                //根据日常管理类型找到对应的策略
                BaseDailyManagerStrategy baseDailyManagerStrategy = managerStrategyMap.get(managerInfoThreadLocal.get().getType());
                if(baseDailyManagerStrategy != null) {
                    return baseDailyManagerStrategy.execute(managerInfoThreadLocal.get());
                }
            }catch (Exception e){
                throw new StrategyFailedException.FailedExecute("策略执行失败",e);
            }
            finally {
                //手动调用 remove() 可以加快内存的释放
                if(managerInfoThreadLocal.get() != null){
                    managerInfoThreadLocal.remove();
                }
            }
        }
        return Result.error("策略执行失败,请求本地线程下对象为空");
    }

    /**
     *
     * 为每个线程创建独有的业务信息对象
     * @param dailyManagerInfo  业务参数
     */
    private synchronized void createBusinessCache(DailyManagerInfo dailyManagerInfo){
        if(managerInfoThreadLocal.get()==null){
            managerInfoThreadLocal.set(dailyManagerInfo);
        }
    }
}
