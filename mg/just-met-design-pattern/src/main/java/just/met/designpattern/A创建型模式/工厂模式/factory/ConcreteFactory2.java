package just.met.designpattern.A创建型模式.工厂模式.factory;

import just.met.designpattern.A创建型模式.工厂模式.product.ConcreteProduct1;
import just.met.designpattern.A创建型模式.工厂模式.product.ConcreteProduct2;
import just.met.designpattern.A创建型模式.工厂模式.product.Product;

/**
 * @author wangmaogang
 */
public class ConcreteFactory2 implements AbstractFactory{
    @Override
    public Product newProduct() {
        System.out.println("我是具体工厂2");
        return new ConcreteProduct2();
    }
}
