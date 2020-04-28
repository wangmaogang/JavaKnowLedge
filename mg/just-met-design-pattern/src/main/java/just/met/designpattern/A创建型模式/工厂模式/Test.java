package just.met.designpattern.A创建型模式.工厂模式;

import just.met.designpattern.A创建型模式.工厂模式.factory.AbstractFactory;
import just.met.designpattern.A创建型模式.工厂模式.factory.ConcreteFactory1;
import just.met.designpattern.A创建型模式.工厂模式.factory.ConcreteFactory2;

/**
 * @author wangmaogang
 */
public class Test {
    public static void main(String[] args) {
        //具体工厂1
        AbstractFactory factory = new ConcreteFactory1();
        factory.newProduct().show();
        //具体工厂2
        AbstractFactory factory2 = new ConcreteFactory2();
        factory2.newProduct().show();
    }
}
