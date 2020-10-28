package just.met.springboot.idemp.aspect;

import just.met.springboot.idemp.eneity.R;
import just.met.springboot.idemp.eneity.RequestInfo;
import just.met.springboot.idemp.service.impl.FixedIdempotenceIdGenerator;
import just.met.springboot.idemp.service.impl.RedisIdempotenceStorage;
import just.met.springboot.idemp.singleton.IdempotenceSingleton;
import just.met.springboot.idemp.tools.MethodParamTools;
import just.met.springboot.idemp.tools.RedisTool;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 幂等切面类
 *
 * @author wangmaogang
 */
@Aspect
@Component
@Slf4j
public class IdempotenceAspect {

    /**
     * 切入点
     */
    @Pointcut("@annotation(just.met.springboot.idemp.aspect.IdempotenceOperate)")
    public void entryPoint() {
        // 无需内容
    }

    /**
     * 开始执行前置通知
     *
     * @param joinPoint
     */
    @Before("entryPoint()")
    public void before(JoinPoint joinPoint) {
        log.info("entryPoint - before");
        try {
            //相关业务逻辑
        } catch (Throwable e) {
            log.info("around " + joinPoint + " with exception : " + e.getMessage());
        }
    }

    /**
     * 开始执行后置通知
     *
     * @param joinPoint
     */
    @After("entryPoint()")
    public void after(JoinPoint joinPoint) {
        log.info("entryPoint - after");
        try {
            //相关业务逻辑
        } catch (Throwable e) {
            log.info("around " + joinPoint + " with exception : " + e.getMessage());
        }
    }

    /**
     * 环绕通知处理
     *
     * @param point
     * @throws Throwable
     */
    @Around("entryPoint()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        //获取主键
        String businessId = MethodParamTools.getMethodBusinessId(point);
        //判定是否存在匹配的业务主键
        if (StringUtils.isBlank(businessId)) {
            return R.error().put("msg", "业务主键未匹配！");
        }

        //生成“幂等key”
        RequestInfo requestInfo = new RequestInfo("wmg", MethodParamTools.getMethodFullPath(point), businessId);
        String key = new FixedIdempotenceIdGenerator(requestInfo).generateId();
        //“幂等key”存入redis，返回幂等重复操作标志，返回true代表不是重复操作，可以进行操作
        boolean idempotenceFlag = IdempotenceSingleton.INSTANCE.getInstance().save(key);
        log.info("idempotenceFlag:" + idempotenceFlag);
        //不是重复操作
        if (idempotenceFlag) {
            // 执行业务
            Object result = point.proceed();
            //执行完业务，删除key
            IdempotenceSingleton.INSTANCE.getInstance().delete(key);
            return result;
        }
        //是重复操作
        else {
            log.info("Repeat operation!");
            return R.error().put("msg", "Repeat operation！");
        }
    }
}
