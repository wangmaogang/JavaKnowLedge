package just.met.springboot.idemp.tools;

import just.met.springboot.idemp.aspect.IdempotenceOperate;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * 方法参数获取工具类
 * @author wangmaogang
 */
public class MethodParamTools {

    /**
     * 系统默认的业务主键字符串
     */
    private static final String DEFAULT_BUSINESS_STR = "NOAH";

    /**
     * 指定分隔标志
     */
    private static final String SPLIT_FLAG = "\\.";

    /**
     * 获取连接点对应的Signature对象,向下转型MethodSignature对象
     * @param joinPoint 连接点
     * @return 方法MethodSignature实例
     */
    public static MethodSignature getMethodSignature(JoinPoint joinPoint){
        //类型转换，向下转型，必定成功，因为其内部的实现MethodSignatureImpl实现的就是MethodSignature接口
        return (MethodSignature) joinPoint.getSignature();
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
        return methodPath + splitFlag + methodName;
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
        //CASE 1 : 如果指定的业务主键不为空，则查询相应的参数值
        if (StringUtils.isNotEmpty(fieldName)) {
            String[] targetNames = fieldName.split(SPLIT_FLAG);
            // CASE 1.1 : 简单字符串参数，如 (orderId)
            if(targetNames.length <= 1){
                return getSingleFieldValue(joinPoint,fieldName);
            }
            // CASE 1.2 : 复杂实体类对象参数,如（map。orderId，entity.userId）
            else {
                return getComplexFieldValue(joinPoint,fieldName);
            }
        }
        //CASE 2 : 如果指定的业务主键为空，则视为不需要业务主键，返回系统默认的字符串
        else {
            return DEFAULT_BUSINESS_STR;
        }
    }

    /**
     * 简单字符串参数提取
     * @param joinPoint 连接点
     * @param fieldName 提取参数名称
     * @return 提取指定参数名的value
     */
    public static String getSingleFieldValue(JoinPoint joinPoint,String fieldName){
        //获取当前注解所修饰的方法上的所有参数名称
        String[] parameterNames = getMethodSignature(joinPoint).getParameterNames();
        //获取当前注解所修饰的方法上的所有参数
        Object[] objects = joinPoint.getArgs();
        //循环参数，找到匹配的业务主键
        for (int i = 0; i < parameterNames.length; i++) {
            String parameterName = parameterNames[i];
            if (fieldName.equals(parameterName)) {
                // 获取对象类型
                String typeName = objects[i].getClass().getTypeName();
                //仅匹配字符串类型的，防止匹配到实体类而产生转换错误
                System.out.println(String.class.getName());
                if(String.class.getName().equals(typeName)){
                    return String.valueOf(objects[i]);
                }
            }
        }
        //如果未匹配到业务主键，则返回null
        return null;
    }

    /**
     * 复杂实体类参数提取
     * @param joinPoint 连接点
     * @param fieldName 提取参数名称
     * @return 提取指定参数名的value
     */
    public static String getComplexFieldValue(JoinPoint joinPoint,String fieldName){
        //获取分隔后的参数
        String[] targetNames = fieldName.split(SPLIT_FLAG);
        //获取当前注解所修饰的方法上的所有参数名称
        String[] parameterNames = getMethodSignature(joinPoint).getParameterNames();
        //获取当前注解所修饰的方法上的所有参数
        Object[] objects = joinPoint.getArgs();
        //循环参数，找到匹配的业务主键
        for (int i = 0; i < parameterNames.length; i++) {
            String parameterName = parameterNames[i];
            if (targetNames[0].equals(parameterName)) {
                // 获取对象类型
                String typeName = objects[i].getClass().getTypeName();
                //仅匹配字符串类型的，防止匹配到实体类而产生转换错误
                System.out.println(LinkedHashMap.class.getName());
                //将targetNames[0]关联的对象属性全部放入map中
                Map<String,Object> map = new HashMap<>(64);
                //如果对象是Map对象，直接获取key对应的value
                if(LinkedHashMap.class.getName().equals(typeName) || HashMap.class.getName().equals(typeName)){
                    map = (Map<String,Object>)objects[i];
                }
                //如果不是Map对象,转换成Map对象
                else {
                    try {
                        map = getObjInnerValues(objects[i]);
                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                return MapUtils.getString(map,targetNames[1],null);
            }
        }
        return null;
    }

    /**
     * 返回指定对象的所有属性Map集合
     * @param model 指定对象
     * @return 返回Map集合
     * @throws NoSuchMethodException 抛出异常
     * @throws IllegalAccessException 抛出异常
     * @throws InvocationTargetException 抛出异常
     */
    public static HashMap<String,Object> getObjInnerValues(Object model) throws NoSuchMethodException,IllegalAccessException,InvocationTargetException {

        HashMap<String, Object> map = new HashMap<>(64);

        Field[] fields = model.getClass().getDeclaredFields();
        //遍历所有属性
        for (Field field : fields) {
            //获取属性的名字
            String name = field.getName();
            System.out.println("attribute name:" + name);
            //将属性的首字符大写，方便构造get，set方法
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            //获取属性的类型
            String type = field.getGenericType().toString();
            //调用getter方法获取属性值
            Method m = model.getClass().getMethod("get" + name);
            map.put(field.getName(), m.invoke(model).toString());
        }
        return map;
    }
}
