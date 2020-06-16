package just.met.springboot.设计模式.utils;

import com.alibaba.fastjson.JSON;
import just.met.springboot.feign.eneity.Result;
import just.met.springboot.设计模式.eneity.DailyManagerInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 策略执行单例类
 * @author noah
 */
@Slf4j
public class StrategyExecuteSingleton {

    //私有化构造函数
    private StrategyExecuteSingleton() {
    }

    //静态枚举类
    enum SingletonEnum {
        //创建一个枚举对象，该对象天生为单例
        INSTANCE;
        private final StrategyExecuteSingleton strategyExecuteSingleton;

        //私有化枚举的构造函数
        SingletonEnum() {
            //Bean注入，可在此类中使用spring管理的bean
            strategyExecuteSingleton = SpringBeanFactoryUtils.getBean(StrategyExecuteSingleton.class);
        }

        public StrategyExecuteSingleton getInstance() {
            return strategyExecuteSingleton;
        }
    }

    //获取ApprovalTools对象的静态方法
    public static StrategyExecuteSingleton getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }

    /**
     * 策略执行
     *
     * @param dailyManagerInfo
     * @return
     */
    public Result execute(DailyManagerInfo dailyManagerInfo) {
        return null;
    }


}
