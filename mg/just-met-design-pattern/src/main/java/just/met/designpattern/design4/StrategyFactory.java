package just.met.designpattern.design4;

import just.met.designpattern.design4.impl.ConcreteStrategyA;
import just.met.designpattern.design4.impl.ConcreteStrategyB;
import just.met.designpattern.design4.impl.ConcreteStrategyC;
import just.met.designpattern.design4.impl.Strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wangmaogang
 */
public class StrategyFactory {

    private static Map<String, Strategy> map;
    List<Strategy> list = new ArrayList<>();

    public StrategyFactory(){

        System.out.println("StrategyFactory构造方法");
        list.add(new ConcreteStrategyA());
        list.add(new ConcreteStrategyB());
        list.add(new ConcreteStrategyC());
        map = list.stream().collect(Collectors.toMap(Strategy::getType,strategy -> strategy));

    }

    private static class Holder{
        static{
            System.out.println("Holder-sInstance-方法");
        }
        private final static StrategyFactory sInstance = new StrategyFactory();
    }

    public static StrategyFactory getInstance(){
        System.out.println("StrategyFactory-Holder-getInstance()方法");
        return Holder.sInstance;
    }

    public Strategy get(String type){
        return map.get(type);
    }

}
