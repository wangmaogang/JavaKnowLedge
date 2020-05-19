package just.met.designpattern.A创建型模式.单例模式.静态内部类;

/**
 * 单例模式-静态内部类
 * @author wangmaogang
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton(){
    }

    public static StaticInnerClassSingleton getInstance(){
        return Holder.singleton;
    }

    private static class Holder{
        private static final StaticInnerClassSingleton singleton = new StaticInnerClassSingleton();
    }

}
