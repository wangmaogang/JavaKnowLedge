package just.met.javabase.动态代理.jdk动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 * @author wangmaogang
 */
public class JdkDynamicProxy implements InvocationHandler {

    private Object target;

    public JdkDynamicProxy(Object target){
        this.target = target;
    }

    /**
     * 获取被代理的接口实例对象
     * @param <T>
     * @return
     */
    public <T> T getProxy(){
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("---BEGIN-我是代理类，执行被代理对象的方法之前---");
        Object result = method.invoke(target,args);
        System.out.println("---END-我是代理类，执行被代理对象的方法之后---");
        return result;

    }
}
