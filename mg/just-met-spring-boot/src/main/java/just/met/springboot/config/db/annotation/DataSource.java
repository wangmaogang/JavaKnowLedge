package just.met.springboot.config.db.annotation;

import java.lang.annotation.*;

/**
 * 多数据源注解
 * @author wangmaogang
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default "";
}
