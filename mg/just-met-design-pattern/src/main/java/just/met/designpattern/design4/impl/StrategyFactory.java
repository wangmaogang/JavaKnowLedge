package just.met.designpattern.design4.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StrategyFactory {

    private static Map<String,Strategy> map;
    List<Strategy> list = new ArrayList<>();

    public StrategyFactory(){

        System.out.println("StrategyFactory构造方法");
        list.add(new ConcreteStrategyA());
        list.add(new ConcreteStrategyB());
        list.add(new ConcreteStrategyC());
        map = list.stream().collect(Collectors.toMap(Strategy::getType,strategy -> strategy));
    }

    public static class Holder{
        private final static StrategyFactory sInstance = new StrategyFactory();
    }

    private static StrategyFactory getInstance(){
        System.out.println("StrategyFactory-Holder-getInstance()方法");
        return Holder.sInstance;
    }

    public Strategy get(String type){
        return map.get(type);
    }

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
