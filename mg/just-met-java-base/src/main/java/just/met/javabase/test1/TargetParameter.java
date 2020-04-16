package just.met.javabase.test1;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wangmaogang
 */
@Target(ElementType.PARAMETER)//方法参数
@Retention(RetentionPolicy.RUNTIME)// 注解会在class字节码文件中存在，在运行时可以通过反射获取到
public @interface TargetParameter {
    String getValue() default "[ElementType.PARAMETER]我是定义在方法参数上的注解元素value的默认值";
}
