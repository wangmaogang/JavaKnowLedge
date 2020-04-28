package just.met.javabase.test3.t1.impl;

import just.met.javabase.test3.t1.IComputer;
import just.met.javabase.test3.t1.IPhone;

/**
 * 华为电脑生产类
 * @author wangmaogang
 */
public class HuaWeiComputer implements IComputer {

    public final static String CLASS_NAME = "just.met.javabase.test3.t1.impl.HuaWeiComputer";

    @Override
    public void executeComputer() {
        System.out.println("I AM HUA-WEI-COMPUTER");
    }
}
