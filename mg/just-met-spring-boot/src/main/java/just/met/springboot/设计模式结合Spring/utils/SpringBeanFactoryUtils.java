package just.met.springboot.设计模式结合Spring.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * 实现ApplicationContextAware接口
 * @author wangmaogang
 */
@Component
public class SpringBeanFactoryUtils implements ApplicationContextAware {

    private static ApplicationContext appCtx;

    /**
     * 此方法可以把ApplicationContext对象inject到当前类中作为一个静态成员变量。
     * @param applicationContext ApplicationContext 对象.
     * @throws BeansException 抛出Bean异常
     */
    @Override

    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        appCtx = applicationContext;
    }

    /**
     * 获取ApplicationContext
     * @return 返回应用上下文
     */
    public static ApplicationContext getApplicationContext() {
        return appCtx;
    }

    /**
     * 快速得到一个BEAN
     *
     * @param beanName bean的名字
     * @return 返回一个bean对象
     */
    public static Object getBean(String beanName) {
        return appCtx.getBean(beanName);
    }

    /**
     * 快速得到一个BEAN
     *
     * @param clazz bean的类型
     * @return 返回一个bean对象
     */
    public static <T> T getBean(Class<T> clazz) {
        return appCtx.getBean(clazz);
    }
}
