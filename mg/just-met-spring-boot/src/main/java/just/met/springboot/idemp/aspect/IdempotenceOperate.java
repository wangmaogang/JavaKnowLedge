package just.met.springboot.idemp.aspect;

import java.lang.annotation.*;

/**
 * 幂等操作注解
 * @author wangmaogang
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IdempotenceOperate {
    String businessId() default "";
}