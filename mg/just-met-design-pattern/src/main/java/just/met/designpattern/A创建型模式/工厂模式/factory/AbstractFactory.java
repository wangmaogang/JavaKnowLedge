package just.met.designpattern.A创建型模式.工厂模式.factory;

import just.met.designpattern.A创建型模式.工厂模式.product.Product;

/**
 * @author wangmaogang
 */
public interface AbstractFactory {
    /**
     * 生产一个新产品
     * @return
     */
    Product newProduct();
}
