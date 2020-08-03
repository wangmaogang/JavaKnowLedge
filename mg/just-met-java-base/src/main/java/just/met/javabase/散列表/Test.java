package just.met.javabase.散列表;

import just.met.javabase.动态代理.jdk动态代理.ISubject;
import just.met.javabase.动态代理.jdk动态代理.JdkDynamicProxy;
import just.met.javabase.动态代理.jdk动态代理.RealSubject;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author wangmaogang
 */
public class Test {

    public static void main(String[] args) throws Exception {

        UserInfo userInfo1 = new UserInfo(1,"2");
        UserInfo userInfo2 = new UserInfo(1,"2");

        //直接比较2个对象
        System.out.println("userInfo.hashcode:"+Objects.hash(userInfo1));
        System.out.println("userInfo2.hashcode:"+Objects.hash(userInfo2));
        System.out.println(userInfo1.equals(userInfo2));

        //比较2个对象的name属性
        System.out.println("userInfo1.name.hashcode:"+Objects.hash(userInfo1.getName()));
        System.out.println("userInfo2.name.hashcode:"+Objects.hash(userInfo2.getName()));
        System.out.println(userInfo1.getName().equals(userInfo2.getName()));

        String s1="abc";
        String s2 =new String("abc");

        System.out.println("s1.hashcode:"+Objects.hash(s1));
        System.out.println("s2.hashcode:"+Objects.hash(s2));
        System.out.println(s1.equals(s2));

    }
}

