package just.met.javabase.test3.t2;

import just.met.javabase.test3.RefectionPractice;
import just.met.javabase.test3.t1.DeviceFactory;
import just.met.javabase.test3.t1.IComputer;
import just.met.javabase.test3.t1.IPhone;
import just.met.javabase.test3.t1.impl.HuaWeiComputer;
import just.met.javabase.test3.t1.impl.HuaWeiPhone;
import just.met.javabase.test3.t1.impl.MiComputer;
import just.met.javabase.test3.t1.impl.MiPhone;

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

