package just.met.javabase.test3.t2;

/**
 * 真实对象-实现类
 * @author wangmaogang
 */
public class RealSubject implements ISubject{

    @Override
    public void doSomething() {
        System.out.println("真实对象-实现类-RealSubject-doSomething()");
    }
}
