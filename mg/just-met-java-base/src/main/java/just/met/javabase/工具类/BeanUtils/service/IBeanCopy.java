package just.met.javabase.工具类.BeanUtils.service;

/**
 * 属性复制通用方式
 * @author wangmaogang
 */
public interface IBeanCopy<K,V> {

    /**
     * 属性复制
     * @param original
     * @param target
     */
    void beanCopy(K original,K target,String type);
}
