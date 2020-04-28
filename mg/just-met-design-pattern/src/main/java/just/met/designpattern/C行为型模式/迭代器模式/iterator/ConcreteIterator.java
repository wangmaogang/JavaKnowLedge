package just.met.designpattern.C行为型模式.迭代器模式.iterator;

import java.util.List;

/**
 * 具体迭代器类
 */
public class ConcreteIterator<T> implements Iterator {

    private List<T> list;
    private int index = -1;

    public ConcreteIterator(List<T> list){
        this.list = list;
    }

    @Override
    public T first() {
        return list.get(0);
    }

    @Override
    public T next() {
        if(hasNext()){
            return list.get(++index);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if(index<list.size()-1){
            return true;
        }
        return false;
    }

    @Override
    public void remove() {
        //详情见原Iterator.remove
    }
}
