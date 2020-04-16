package just.met.javabase.test1;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wangmaogang
 */
@Target(ElementType.METHOD)//方法
@Retention(RetentionPolicy.RUNTIME)// 注解会在class字节码文件中存在，在运行时可以通过反射获取到
public @interface TargetMethod {
    String getValue() default "[ElementType.METHOD]我是定义在方法上的注解元素value的默认值";
}
