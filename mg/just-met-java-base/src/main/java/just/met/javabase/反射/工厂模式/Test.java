package just.met.javabase.反射.工厂模式;

import just.met.javabase.反射.工厂模式.impl.HuaWeiComputer;
import just.met.javabase.反射.工厂模式.impl.HuaWeiPhone;
import just.met.javabase.反射.工厂模式.impl.MiComputer;
import just.met.javabase.反射.工厂模式.impl.MiPhone;

/**
 * @author wangmaogang
 */
public class Test {

    public static void main(String[] args) throws Exception {

        //生产MI-PHONE
        IPhone miPhone = DeviceFactory.getInstance(MiPhone.CLASS_NAME,IPhone.class);
        miPhone.executePhone();

        //生产HUA-WEI-PHONE
        IPhone huaWeiPhone = DeviceFactory.getInstance(HuaWeiPhone.CLASS_NAME,IPhone.class);
        huaWeiPhone.executePhone();

        //生产MI-COMPUTER
        IComputer miComputer = DeviceFactory.getInstance(MiComputer.CLASS_NAME,IComputer.class);
        miComputer.executeComputer();

        //生产HUA-WEI-COMPUTER
        IComputer huaWeiComputer = DeviceFactory.getInstance(HuaWeiComputer.CLASS_NAME,IComputer.class);
        huaWeiComputer.executeComputer();
    }
}

