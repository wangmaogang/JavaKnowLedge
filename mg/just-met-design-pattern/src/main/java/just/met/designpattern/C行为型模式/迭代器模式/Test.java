package just.met.designpattern.C行为型模式.迭代器模式;

import just.met.designpattern.C行为型模式.迭代器模式.aggregate.Aggregate;
import just.met.designpattern.C行为型模式.迭代器模式.aggregate.ConcreteAggregate;
import just.met.designpattern.C行为型模式.迭代器模式.iterator.ConcreteIterator;
import just.met.designpattern.C行为型模式.迭代器模式.iterator.Iterator;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("王一");
        aggregate.add("王二");
        aggregate.add("王三");

        Iterator<String> iterator = aggregate.createIterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }



    }

}
