package just.met.javabase.反射.动态代理;

/**
 * @author wangmaogang
 */
public class Test {

    public static void main(String[] args) throws Exception {

        //JDK动态代理测试
        ISubject subject = new JdkDynamicProxy(new RealSubject()).getProxy();
        subject.doSomething();

    }
}

