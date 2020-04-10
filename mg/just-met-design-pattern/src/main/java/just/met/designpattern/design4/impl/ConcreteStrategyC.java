package just.met.designpattern.design4.impl;

/**
 * 策略B实现类
 * @author wangmaogang
 */
public class ConcreteStrategyC extends Strategy {
    
    @Override
    public void AlgorithmInterface() {
        System.out.println("getType() = " + getType());
    }

    @Override
    public String getType() {
        return StrategyType.STRATEGY_C.getType();
    }
}
