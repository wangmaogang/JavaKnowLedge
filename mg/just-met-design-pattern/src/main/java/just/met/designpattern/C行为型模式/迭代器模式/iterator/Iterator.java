package just.met.designpattern.C行为型模式.迭代器模式.iterator;

/**
 * 迭代器抽象类
 */
public interface Iterator<E> {

    E first();

    //返回当前迭代元素 ，同时，迭代游标后移
    E next();

    //每次next之前，先调用此方法探测是否迭代到终点
    boolean hasNext();

    //*删除最近一次已近迭代出出去的那个元素。只有当next执行完后，才能调用remove函数。
    default void remove(){
        throw new UnsupportedOperationException("remove");
    }

}
