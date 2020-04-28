package just.met.designpattern.A创建型模式.工厂模式.factory;

import just.met.designpattern.A创建型模式.工厂模式.product.ConcreteProduct1;
import just.met.designpattern.A创建型模式.工厂模式.product.Product;

/**
 * @author wangmaogang
 */
public class ConcreteFactory1 implements AbstractFactory{
    @Override
    public Product newProduct() {
        System.out.println("我是具体工厂1");
        return new ConcreteProduct1();
    }
}
