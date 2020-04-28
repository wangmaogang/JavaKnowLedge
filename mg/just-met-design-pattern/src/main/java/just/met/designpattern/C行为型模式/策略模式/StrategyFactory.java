package just.met.designpattern.C行为型模式.策略模式;

import just.met.designpattern.C行为型模式.策略模式.strategy.AbstractStrategy;
import just.met.designpattern.C行为型模式.策略模式.strategy.ConcreteStrategyA;
import just.met.designpattern.C行为型模式.策略模式.strategy.ConcreteStrategyB;
import just.met.designpattern.C行为型模式.策略模式.strategy.ConcreteStrategyC;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wangmaogang
 */
public class StrategyFactory {

    private static Map<String, AbstractStrategy> map;
    List<AbstractStrategy> list = new ArrayList<>();

    public StrategyFactory(){
        list.add(new ConcreteStrategyA());
        list.add(new ConcreteStrategyB());
        list.add(new ConcreteStrategyC());
        map = list.stream().collect(Collectors.toMap(AbstractStrategy::getType,strategy -> strategy));

    }

    private static class Holder{
        private final static StrategyFactory sInstance = new StrategyFactory();
    }

    public static StrategyFactory getInstance(){
        return Holder.sInstance;
    }

    public AbstractStrategy get(String type){
        return map.get(type);
    }

}
