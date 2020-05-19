package just.met.javabase.反射.工厂模式.impl;

import just.met.javabase.反射.工厂模式.IComputer;

/**
 * 小米电脑生产类
 * @author wangmaogang
 */
public class MiComputer implements IComputer {

    public final static String CLASS_NAME = "just.met.javabase.test3.t1.impl.MiComputer";

    @Override
    public void executeComputer() {
        System.out.println("I AM MI-COMPUTER");
    }
}
