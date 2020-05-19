package just.met.designpattern.A创建型模式.单例模式.双检索;

/**
 * 双检索模式
 * @author wangmaogang
 */
public class DlcSingleton {

    private volatile static DlcSingleton instance;

    private DlcSingleton(){}

    public static DlcSingleton getInstance(){
        if(instance == null){
            synchronized (DlcSingleton.class){
                instance = new DlcSingleton();
            }
        }
        return instance;
    }
}
