package just.met.javabase.动态代理.jdk动态代理;

/**
 * 真实实例-接口实现类
 * @author wangmaogang
 */
public class RealSubject implements ISubject{

    @Override
    public void doSomething() {
        System.out.println("真实对象-实现类-RealSubject-doSomething()");
    }
}
