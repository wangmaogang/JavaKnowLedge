package just.met.designpattern.design2;


/**
 * 单例模式-饿汉式
 * @author wangmaogang
 */
public class Singleton2 {

    public Singleton2(){
        System.out.println("Singleton2构造方法");
    }

    public final static Singleton2 singleton2 = new Singleton2();

    public static Singleton2 getInstance(){
        System.out.println("Singleton2-getInstance()静态方法");
        return singleton2;
    }

    /**
     * 单独测试懒汉模式加载顺序
     *
     * 1. 构造方法 执行
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("测试静态方法");
    }
}


