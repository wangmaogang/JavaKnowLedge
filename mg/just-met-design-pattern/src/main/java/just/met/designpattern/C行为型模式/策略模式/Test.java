package just.met.designpattern.C行为型模式.策略模式;

/**
 * @author wangmaogang
 */
public class Test {

    /**
     * 测试策略模式+工厂模式组合
     * @param args
     */
    public static void main(String[] args) {
        StrategyFactory.getInstance().get("STRATEGY_A").algorithmInterface();
        StrategyFactory.getInstance().get("STRATEGY_B").algorithmInterface();
        StrategyFactory.getInstance().get("STRATEGY_C").algorithmInterface();
    }

}
