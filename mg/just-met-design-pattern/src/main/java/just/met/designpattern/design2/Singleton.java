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

    /**
     * 单独测试静态内部类模式加载顺序
     *
     * 1. 静态方法、构造方法 均未执行
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("测试静态方法");
    }

}
