package just.met.javabase.反射.工厂模式;

/**
 * 王牌代工厂-工厂类
 * @author wangmaogang
 */
public class DeviceFactory {

    /**
     * 获取接口实例化对象
     * @param className 实现接口的子类名称
     * @param tClass 接口类型
     * @param <T>
     * @return 如果子类存在则返回指定接口实例
     * @throws ClassNotFoundException
     */
    static <T> T getInstance(String className,Class<T> tClass) throws Exception {
        //反射获取各个手机实现类的**实例newInstance**
        Object object = Class.forName(className).newInstance();
        //将各个手机实现类转为各自的接口类型
        return tClass.cast(object);
    }

}
