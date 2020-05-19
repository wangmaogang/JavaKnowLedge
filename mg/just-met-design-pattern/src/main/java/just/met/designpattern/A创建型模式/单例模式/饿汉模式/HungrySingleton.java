package just.met.designpattern.A创建型模式.单例模式.饿汉模式;


/**
 * 单例模式-饿汉式
 * @author wangmaogang
 */
public class HungrySingleton {

    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }
}


