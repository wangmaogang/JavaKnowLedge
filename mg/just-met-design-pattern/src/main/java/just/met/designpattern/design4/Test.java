package just.met.designpattern.design4;

import just.met.designpattern.design4.impl.StrategyType;

/**
 * @author wangmaogang
 */
public class Test {

    /**
     * 测试策略模式+工厂模式组合
     * @param args
     */
    public static void main(String[] args) {
        StrategyFactory.getInstance().get(StrategyType.STRATEGY_A.getType()).AlgorithmInterface();
        StrategyFactory.getInstance().get(StrategyType.STRATEGY_A.getType()).AlgorithmInterface();
        StrategyFactory.getInstance().get(StrategyType.STRATEGY_B.getType()).AlgorithmInterface();
        StrategyFactory.getInstance().get(StrategyType.STRATEGY_B.getType()).AlgorithmInterface();
    }

}
