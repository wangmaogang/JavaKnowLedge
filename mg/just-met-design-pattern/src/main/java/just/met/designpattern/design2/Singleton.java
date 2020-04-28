package just.met.designpattern.design2;

/**
 * 单例模式-静态内部类
 * @author wangmaogang
 */
public class Singleton {


    private Singleton(){
        System.out.println("Singleton-构造方法");
    }

    public static Singleton getInstance(){
        System.out.println("Singleton-getInstance()静态方法");
        return Holder.singleton;
    }

    private static class Holder{
        private static final Singleton singleton = new Singleton();
    }

}
