package just.met.javabase.注解.annos;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wangmaogang
 */
@Target(ElementType.TYPE)//接口、类、枚举
@Retention(RetentionPolicy.RUNTIME)// 注解会在class字节码文件中存在，在运行时可以通过反射获取到
public @interface TargetType {
    String getValue() default "[ElementType.TYPE]我是定义在接口、类、枚举上的注解元素value的默认值";
}
