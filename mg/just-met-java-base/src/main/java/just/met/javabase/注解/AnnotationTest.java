package just.met.javabase.注解;

import just.met.javabase.注解.annos.TargetField;
import just.met.javabase.注解.annos.TargetMethod;
import just.met.javabase.注解.annos.TargetParameter;
import just.met.javabase.注解.annos.TargetType;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author wangmaogang
 */
@TargetType
public class AnnotationTest {

    @TargetField
    private String name = "我是字段";

    @TargetMethod
    private void testMethod(@TargetParameter String str){
        System.out.println("testMethod参数值 === "+str);
    }

    public static void main(String[] args) {
        // 1.获取AnnotationTest类上的注解
        TargetType t = AnnotationTest.class.getAnnotation(TargetType.class);
        System.out.println("类上的注解值 === "+t.getValue());
        TargetMethod tm = null;
        try {
            // 2.根据反射获取类上的testMethod方法
            Method method = AnnotationTest.class.getDeclaredMethod("testMethod",String.class);
            // 获取方法上的注解
            tm = method.getAnnotation(TargetMethod.class);
            System.out.println("方法上的注解值 === "+tm.getValue());
            // 3.获取方法上的所有参数注解，循环所有注解找到TargetParameter注解
            Annotation[][] annotations = method.getParameterAnnotations();
            for(Annotation[] tt : annotations){
                for(Annotation t1:tt){
                    if(t1 instanceof TargetParameter){
                        System.out.println("参数上的注解值 === "+((TargetParameter) t1).getValue());
                    }
                }
            }
            method.invoke(new AnnotationTest(), "改变默认参数");
            // 4.获取AnnotationTest类上字段field的注解
            TargetField fieldAn = AnnotationTest.class.getDeclaredField("name").getAnnotation(TargetField.class);
            System.out.println("字段上的注解值 === "+fieldAn.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
