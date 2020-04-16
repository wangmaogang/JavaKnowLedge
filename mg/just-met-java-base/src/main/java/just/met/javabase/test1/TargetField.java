package just.met.javabase.test1;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wangmaogang
 */
@Target(ElementType.FIELD)//字段、枚举的常量
@Retention(RetentionPolicy.RUNTIME)// 注解会在class字节码文件中存在，在运行时可以通过反射获取到
public @interface TargetField {
    String getValue() default "[ElementType.FIELD]我是定义在字段、枚举的常量上的注解元素value的默认值";
}
