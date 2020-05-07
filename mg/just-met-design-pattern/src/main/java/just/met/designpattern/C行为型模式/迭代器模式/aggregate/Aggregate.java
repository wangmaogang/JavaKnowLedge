package just.met.designpattern.C行为型模式.迭代器模式.aggregate;

import just.met.designpattern.C行为型模式.迭代器模式.iterator.Iterator;

/**
 * 抽象聚集类
 */
public interface Aggregate<T> {

    void add(T t);

    Iterator createIterator();
}
