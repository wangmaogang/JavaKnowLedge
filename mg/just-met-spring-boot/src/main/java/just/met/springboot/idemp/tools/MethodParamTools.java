package just.met.springboot.idemp.tools;

import just.met.springboot.idemp.aspect.IdempotenceOperate;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;


/**
 * 方法参数获取工具类
 * @author wangmaogang
 */
public class MethodParamTools {

    /**
     * 获取连接点对应的Signature对象,向下转型MethodSignature对象
     * @param joinPoint 连接点
     * @return 方法MethodSignature实例
     */
    public static MethodSignature getMethodSignature(JoinPoint joinPoint){
        //类型转换，向下转型，必定成功，因为其内部的实现MethodSignatureImpl实现的就是MethodSignature接口
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature;
    }

    /**
     * 获取方法的全路径
     * @param joinPoint 连接点
     * @return 返回方法的全路径
     */
    public static String getMethodFullPath(JoinPoint joinPoint){
        //获取method名称 + 类路径
        String splitFlag = ".";
        String methodName = getMethodSignature(joinPoint).getMethod().getName();
        String methodPath = getMethodSignature(joinPoint).getMethod().getDeclaringClass().getName();
        String methodStr = methodPath + splitFlag + methodName;
        return methodStr;
    }

    /**
     * 获取方法的业务主键，即获取指定方法上的Business注解的参数值
     * @param joinPoint 连接点
     * @return 返回业务主键
     */
    public static String getMethodBusinessId(JoinPoint joinPoint) {

        //获取连接点注解实例
        IdempotenceOperate annotation = getMethodSignature(joinPoint).getMethod().getAnnotation(IdempotenceOperate.class);
        //获取注解标记的业务主键名称
        String fieldName = annotation.businessId();
        if (StringUtils.isNotEmpty(fieldName)) {
            //获取当前注解所修饰的方法上的所有参数
            String[] parameterNames = getMethodSignature(joinPoint).getParameterNames();
            //循环参数，找到匹配的业务主键
            for (int i = 0; i < parameterNames.length; i++) {
                String parameterName = parameterNames[i];
                if (fieldName.equals(parameterName)) {
                    Object[] objects = joinPoint.getArgs();
                    return String.valueOf(objects[i]);
                }
            }
        }
        return null;
    }
}
