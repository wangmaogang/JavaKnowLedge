package just.met.designpattern.C行为型模式.策略模式.strategy;

/**
 * 策略A实现类
 * @author wangmaogang
 */
public class ConcreteStrategyA extends AbstractStrategy {
    
    @Override
    public void algorithmInterface() {
        System.out.println("getType() = " + getType());
    }

    @Override
    public String getType() {
        return "STRATEGY_A";
    }
}
