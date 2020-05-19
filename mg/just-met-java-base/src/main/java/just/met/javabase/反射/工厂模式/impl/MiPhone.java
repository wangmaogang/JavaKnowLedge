package just.met.javabase.反射.工厂模式.impl;

import just.met.javabase.反射.工厂模式.IPhone;

/**
 * 小米手机生产类
 * @author wangmaogang
 */
public class MiPhone implements IPhone {

    public final static String CLASS_NAME = "just.met.javabase.test3.t1.impl.MiPhone";

    @Override
    public void executePhone() {
        System.out.println("I AM MI-PHONE");
    }
}
