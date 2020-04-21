package just.met.designpattern.design2;

/**
 * 单例模式-静态内部类
 * @author wangmaogang
 */
public class StaticInnerClassSingleton {


    private StaticInnerClassSingleton(){
        System.out.println("StaticInnerClassSingleton-构造方法");
    }

    public static StaticInnerClassSingleton getInstance(){
        System.out.println("StaticInnerClassSingleton-getInstance()静态方法");
        return Holder.singleton;
    }

    private static class Holder{
        private static final StaticInnerClassSingleton singleton = new StaticInnerClassSingleton();
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
