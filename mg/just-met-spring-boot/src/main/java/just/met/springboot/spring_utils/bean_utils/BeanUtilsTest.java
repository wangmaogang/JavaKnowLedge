package just.met.springboot.spring_utils.bean_utils;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * BeanUtils测试类
 *
 * BeanUtils是深拷贝，还是浅拷贝?
 * 是浅拷贝。
 * 浅拷贝：【仅仅是引用，属性不会复制】 只是调用子对象的set方法，并没有将所有属性拷贝。(也就是说，引用的一个内存地址)
 * 深拷贝：【属性自己复制一份】 将子对象的属性也拷贝过去。
 *
 * 什么情况适合用BeanUtils?
 * 如果都是单一的属性，那么不涉及到深拷贝的问题，适合用BeanUtils。
 *
 * 有子对象就一定不能用BeanUtils么
 * 并不绝对，这个要区分考虑：
 * 1、子对象还要改动。
 * 2、子对象不怎么改动。
 * 虽然有子对象，但是子对象并不怎么改动，那么用BeanUtils也是没问题的。
 *
 * 代码eg:
 * 翠山有个儿子无忌，儿子继承了他的face和height。
 * 但是life应该是自己的。
 * 后来翠山自刎而死，无忌也变成dead状态了。这就是浅拷贝，无忌用的life引用的翠山的life对象。
 */
public class BeanUtilsTest {
    public static void main(String[] args){
        case3();
    }

    /**
     * 1.翠山自刎，无忌也挂了
     * 结果
     *
     * {"face":"handsome","height":"180","life":{"status":"dead"}}
     * {"face":"handsome","height":"180","life":{"status":"dead"}}
     */
    public static void case1(){
        Father cuiShan = new Father();
        cuiShan.setFace("handsome");
        cuiShan.setHeight("180");
        Life cuiShanLife = new Life();
        cuiShanLife.setStatus("alive");
        cuiShan.setLife(cuiShanLife);
        Son wuJi=new Son();
        BeanUtils.copyProperties(cuiShan,wuJi);

        Life wuJiLife = wuJi.getLife();
        wuJiLife.setStatus("alive");
        wuJi.setLife(wuJiLife);
        cuiShanLife.setStatus("dead"); // 翠山后来自刎了

        System.out.println(JSON.toJSONString(cuiShan));
        System.out.println(JSON.toJSONString(wuJi));
    }


    /**
     * 2.翠山自刎，无忌设置活着，翠山也活了
     * 结果
     *
     * {"face":"handsome","height":"180","life":{"status":"alive"}}
     * {"face":"handsome","height":"180","life":{"status":"alive"}}
     */
    public static void case2(){
        Father cuiShan = new Father();
        cuiShan.setFace("handsome");
        cuiShan.setHeight("180");
        Life cuiShanLife = new Life();
        cuiShanLife.setStatus("alive");
        cuiShan.setLife(cuiShanLife);
        Son wuJi=new Son();
        BeanUtils.copyProperties(cuiShan,wuJi);

        cuiShanLife.setStatus("dead"); // 翠山后来自刎了
        Life wuJiLife = wuJi.getLife();
        wuJiLife.setStatus("alive");
        wuJi.setLife(wuJiLife);


        System.out.println(JSON.toJSONString(cuiShan));
        System.out.println(JSON.toJSONString(wuJi));
    }

    /**
     * 3.翠山和无忌互不影响
     * 结果
     *
     * {"face":"handsome","height":"180","life":{"status":"dead"}}
     * {"face":"handsome","height":"180","life":{"status":"alive"}}
     */
    public static void case3(){
        Father cuiShan = new Father();
        cuiShan.setFace("handsome");
        cuiShan.setHeight("180");
        Life cuiShanLife = new Life();
        cuiShanLife.setStatus("alive");
        cuiShan.setLife(cuiShanLife);
        Son wuJi=new Son();
        BeanUtils.copyProperties(cuiShan,wuJi);

        // 翠山自刎了  该行放在上下均可
        cuiShanLife.setStatus("dead");
        // 无忌用个新对象 不受翠山影响了
        Life wuJiLife = new Life();
        wuJiLife.setStatus("alive");
        wuJi.setLife(wuJiLife);

        System.out.println(JSON.toJSONString(cuiShan));
        System.out.println(JSON.toJSONString(wuJi));
    }
}


/**
 * 父类
 */
@Data
class Father {
    private String face; // 长相
    private String height; // 身高
    private Life life; // 生命
}

/**
 * 子类
 */
@Data
class Son extends Father {
    private Life life;
}


@Data
class Life {
    private String status;
}

