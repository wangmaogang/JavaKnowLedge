package just.met.javabase.动态代理.jdk动态代理;

import just.met.javabase.动态代理.jdk动态代理.ISubject;
import just.met.javabase.动态代理.jdk动态代理.JdkDynamicProxy;
import just.met.javabase.动态代理.jdk动态代理.RealSubject;

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

