package just.met.designpattern.design4.impl1;

/**
 * 策略A实现类
 * @author wangmaogang
 */
public class ConcreteStrategyA extends Strategy {
    
    @Override
    public void AlgorithmInterface() {
        System.out.println("getType() = " + getType());
    }

    @Override
    public String getType() {
        return StrategyType.STRATEGY_A.getType();
    }
}
