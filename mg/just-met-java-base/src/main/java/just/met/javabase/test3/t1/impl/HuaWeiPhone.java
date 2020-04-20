package just.met.javabase.test3.t1.impl;

import just.met.javabase.test3.t1.IPhone;

/**
 * 华为手机生产类
 * @author wangmaogang
 */
public class HuaWeiPhone implements IPhone {

    public final static String CLASS_NAME = "just.met.javabase.test3.t1.impl.HuaWeiPhone";

    @Override
    public void executePhone() {
        System.out.println("I AM HUA-WEI-PHONE");
    }
}
