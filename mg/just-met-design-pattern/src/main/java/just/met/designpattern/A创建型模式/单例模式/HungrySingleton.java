package just.met.designpattern.A创建型模式.单例模式;


/**
 * 单例模式-饿汉式
 * @author wangmaogang
 */
public class HungrySingleton {

    public HungrySingleton(){
        System.out.println("HungrySingleton构造方法");
    }

    public final static HungrySingleton singleton = new HungrySingleton();

    public static HungrySingleton getInstance(){
        System.out.println("HungrySingleton-getInstance()静态方法");
        return singleton;
    }
}


