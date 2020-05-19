package just.met.designpattern.C行为型模式.迭代器模式.aggregate;

import just.met.designpattern.C行为型模式.迭代器模式.iterator.ConcreteIterator;
import just.met.designpattern.C行为型模式.迭代器模式.iterator.Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体聚集类
 * @param <T>
 */
public class ConcreteAggregate<T> implements Aggregate {

    private List<T> list = new ArrayList<>();

    @Override
    public void add(Object o) {
        list.add((T)o);
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(list);
    }
}
